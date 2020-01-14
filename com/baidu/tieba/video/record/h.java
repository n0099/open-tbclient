package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class h {
    private int bZo;
    private g kAA;
    private SurfaceView kAB;
    protected List<String> kAC;
    private b kAD;
    private com.baidu.tieba.video.record.b kAE;
    private GLVideoPreviewView.a kAF;
    private c kAG;
    private GLVideoPreviewView.a kAb;
    private RecordVideoActivity kAt;
    private Bitmap kAu;
    private a kAv;
    private FrameLayout kAw;
    private List<String> kAx;
    private com.baidu.tieba.j.h kgK;
    protected String kvs;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int kAy = 0;
    private Camera.Parameters kAz = null;

    /* loaded from: classes8.dex */
    public interface b {
        void cQa();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void cP(int i, int i2);
    }

    public void ai(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fA(false);
        aVar.jE(R.string.request_permission_default_title);
        aVar.jF(R.string.request_permission_camera);
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.video.record.h.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                activity.finish();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                activity.finish();
            }
        }).b(com.baidu.adp.base.i.ab(activity));
        aVar.aCp();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kgK = lVar.cfr();
        }
        this.mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String string;
                switch (message.what) {
                    case 1:
                        h.this.startPreview();
                        return;
                    case 2:
                        if (h.this.kAt != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ai(h.this.kAt);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.kAt, (int) R.string.disallow_camera_permission);
                            if (h.this.kgK != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.kAt.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.kgK.aP(1, string);
                            }
                            h.this.kAt.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.kAt != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.kAt, (int) R.string.disallow_audio_record_permission);
                            if (h.this.kgK != null) {
                                h.this.kgK.aP(2, h.this.kAt.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.kAt.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kAF = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void tq(final boolean z) {
                if (h.this.kAb != null) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.kAb.tq(z);
                        }
                    });
                }
            }
        };
        this.kAt = recordVideoActivity;
        cPY();
        this.kAu = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.bZo = displayMetrics.heightPixels;
        this.kAw = this.kAt.cQp();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.kAB = gLVideoPreviewView;
            this.kAA = gLVideoPreviewView;
            ((GLVideoPreviewView) this.kAB).setFaceIdentifyStateListener(this.kAF);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.kAB = videoPreviewView;
            this.kAA = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cQp() != null) {
            recordVideoActivity.cQp().addView(this.kAB, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.kAA.e(this.mCamera);
    }

    public void startRecord() {
        this.kAA.f(this.mCamera);
    }

    public void stopRecord() {
        this.kAA.g(this.mCamera);
    }

    public g cPM() {
        return this.kAA;
    }

    public String cPN() {
        if (this.kAC == null) {
            this.kAC = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.ktO);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.ktO + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.kAC.add(str);
        return str;
    }

    public void cPO() {
        if (this.kAC != null && this.kAC.size() != 0) {
            String remove = this.kAC.remove(this.kAC.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cPP() {
        File file = new File(com.baidu.tieba.video.c.ktO);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.kvs = com.baidu.tieba.video.c.ktO + "f_" + System.currentTimeMillis() + ".mp4";
        return this.kvs;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.kAD != null && motionEvent.getAction() == 0) {
            this.kAD.cQa();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cPZ();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.kAD = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.bZo && x >= com.baidu.adp.lib.util.l.getDimens(this.kAt, R.dimen.ds60)) {
                    int width = this.kAu.getWidth();
                    int height = this.kAu.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.bZo - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.kAw == null) {
                            this.kAw = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.kAw.getChildCount()) {
                                if (this.kAv != this.kAw.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.kAw.removeViewAt(i);
                                }
                            }
                        }
                        this.kAv = new a(this.kAt, clamp - (width / 2), clamp2 - (height / 2), this.kAu);
                        this.kAw.addView(this.kAv, new ViewGroup.LayoutParams(-2, -2));
                        cO(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cPZ();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cPQ() {
        int i;
        int i2;
        if (this.mCamera == null && this.kAt != null) {
            this.kAt.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kAt.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.kAt.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.kAz.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.kAA != null) {
                this.kAA.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.kAz.setPreviewFormat(17);
        cPR();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.kAt, this.mCameraId));
        this.kAx = this.kAz.getSupportedFocusModes();
        if (this.kAx != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.kAx.contains("continuous-picture")) {
                this.kAz.setFocusMode("continuous-picture");
            } else if (this.kAx.contains("continuous-video")) {
                this.kAz.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.kAz);
        if (this.kAt != null && this.kAt.cQp() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kAB.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.kAB.setLayoutParams(layoutParams);
            this.kAB.invalidate();
            if (this.kAG != null) {
                this.kAG.cP(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int getScreenHeight(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.l.getEquipmentHeight(context);
        }
        return i;
    }

    private void cPR() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.kAz.getSupportedPreviewFpsRange()) {
            if (Math.abs(20000 - iArr3[1]) > i4 || Math.abs(15000 - iArr3[0]) > i3) {
                i = i3;
                i2 = i4;
                iArr = iArr2;
            } else {
                i2 = Math.abs(20000 - iArr3[1]);
                iArr = iArr3;
                i = Math.abs(15000 - iArr3[0]);
            }
            iArr2 = iArr;
            i4 = i2;
            i3 = i;
        }
        this.kAz.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void tr(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.tn(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.tn(z)) {
                    cPU();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.to(z);
            if (-1 != this.mCameraId) {
                cPT();
                this.kAE = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                cPU();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cPU();
            if (this.kgK != null) {
                this.kgK.aP(8, com.baidu.tieba.j.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cPS() {
        return this.kAE;
    }

    private void cPT() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.kAz = this.mCamera.getParameters();
            cPQ();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cPU() {
        if (this.kAt != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kAt.getPageContext().getPageActivity());
            aVar.jF(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.kAt != null) {
                        h.this.kAt.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fz(true);
            aVar.b(this.kAt.getPageContext());
            aVar.aCp();
        }
    }

    private void releaseCamera() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kgK != null) {
                    this.kgK.aP(6, com.baidu.tieba.j.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cPV() {
        try {
            if (this.mCamera != null) {
                if (this.kAz == null) {
                    this.kAz = this.mCamera.getParameters();
                }
                if ("off".equals(this.kAz.getFlashMode())) {
                    this.kAz.setFlashMode("torch");
                } else {
                    this.kAz.setFlashMode("off");
                }
                this.mCamera.setParameters(this.kAz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kgK != null) {
                this.kgK.aP(7, com.baidu.tieba.j.a.r(e));
            }
        }
    }

    public boolean cPW() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.kAz == null) {
                this.kAz = this.mCamera.getParameters();
            }
            return !"off".equals(this.kAz.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kgK != null) {
                this.kgK.aP(7, com.baidu.tieba.j.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void cPX() {
        if (this.kAB != null && (this.kAB instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.kAB;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cPG();
            this.kAy = this.kAy == 0 ? 1 : 0;
            tr(this.kAy == 1);
            gLVideoPreviewView.cPH();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.kAB != null && (this.kAB instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kAB).h(this.mCamera);
            releaseCamera();
            this.kAy = this.kAy == 0 ? 1 : 0;
            tr(this.kAy == 1);
            startPreview();
        }
    }

    public boolean getIsFrontCamera() {
        return this.kAy == 1;
    }

    private void cPY() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPZ() {
        if (this.kAw != null && this.kAv != null && this.kAv.getParent() != null) {
            this.kAw.removeView(this.kAv);
        }
    }

    private void cO(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.kAx.contains("auto")) {
                this.kAz = this.mCamera.getParameters();
                this.kAz.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.kAz);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kgK != null) {
                this.kgK.aP(9, com.baidu.tieba.j.a.r(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends View {
        Bitmap bitmap;
        int left;
        int top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.top, (Paint) null);
            super.onDraw(canvas);
        }
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.kAB instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kAB).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.kAB instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kAB).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.kAB instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kAB).setSticker(stickerItem);
        }
    }

    public void onResume() {
        tr(this.kAy == 1);
        if (this.kAB != null && (this.kAB instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kAB).onResume();
        }
        if (this.kAB != null && (this.kAB instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kAB).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cPB()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.kAA.h(this.mCamera);
        if (this.kAB != null && (this.kAB instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kAB).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.kAG = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.kAb = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.kAA instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.kAA != null) {
                        h.this.kAA.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.kAA.a(aVar);
        }
    }

    public boolean getCameraIsBack() {
        return this.mCameraId == 0;
    }
}
