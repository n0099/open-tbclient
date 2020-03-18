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
/* loaded from: classes10.dex */
public class h {
    private int cdH;
    private GLVideoPreviewView.a kCR;
    private RecordVideoActivity kDj;
    private Bitmap kDk;
    private a kDl;
    private FrameLayout kDm;
    private List<String> kDn;
    private g kDq;
    private SurfaceView kDr;
    protected List<String> kDs;
    private b kDt;
    private com.baidu.tieba.video.record.b kDu;
    private GLVideoPreviewView.a kDv;
    private c kDw;
    private com.baidu.tieba.k.h kjC;
    protected String kyi;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int kDo = 0;
    private Camera.Parameters kDp = null;

    /* loaded from: classes10.dex */
    public interface b {
        void cRQ();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void cT(int i, int i2);
    }

    public void al(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fI(false);
        aVar.jV(R.string.request_permission_default_title);
        aVar.jW(R.string.request_permission_camera);
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
        aVar.aEG();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.kjC = lVar.cht();
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
                        if (h.this.kDj != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.al(h.this.kDj);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.kDj, (int) R.string.disallow_camera_permission);
                            if (h.this.kjC != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.kDj.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.kjC.aP(1, string);
                            }
                            h.this.kDj.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.kDj != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.kDj, (int) R.string.disallow_audio_record_permission);
                            if (h.this.kjC != null) {
                                h.this.kjC.aP(2, h.this.kDj.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.kDj.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kDv = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void tA(final boolean z) {
                if (h.this.kCR != null) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.kCR.tA(z);
                        }
                    });
                }
            }
        };
        this.kDj = recordVideoActivity;
        cRO();
        this.kDk = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cdH = displayMetrics.heightPixels;
        this.kDm = this.kDj.cSf();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.kDr = gLVideoPreviewView;
            this.kDq = gLVideoPreviewView;
            ((GLVideoPreviewView) this.kDr).setFaceIdentifyStateListener(this.kDv);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.kDr = videoPreviewView;
            this.kDq = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cSf() != null) {
            recordVideoActivity.cSf().addView(this.kDr, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.kDq.e(this.mCamera);
    }

    public void startRecord() {
        this.kDq.f(this.mCamera);
    }

    public void stopRecord() {
        this.kDq.g(this.mCamera);
    }

    public g cRC() {
        return this.kDq;
    }

    public String cRD() {
        if (this.kDs == null) {
            this.kDs = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.kwD);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.kwD + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.kDs.add(str);
        return str;
    }

    public void cRE() {
        if (this.kDs != null && this.kDs.size() != 0) {
            String remove = this.kDs.remove(this.kDs.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cRF() {
        File file = new File(com.baidu.tieba.video.c.kwD);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.kyi = com.baidu.tieba.video.c.kwD + "f_" + System.currentTimeMillis() + ".mp4";
        return this.kyi;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.kDt != null && motionEvent.getAction() == 0) {
            this.kDt.cRQ();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cRP();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.kDt = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cdH && x >= com.baidu.adp.lib.util.l.getDimens(this.kDj, R.dimen.ds60)) {
                    int width = this.kDk.getWidth();
                    int height = this.kDk.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cdH - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.kDm == null) {
                            this.kDm = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.kDm.getChildCount()) {
                                if (this.kDl != this.kDm.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.kDm.removeViewAt(i);
                                }
                            }
                        }
                        this.kDl = new a(this.kDj, clamp - (width / 2), clamp2 - (height / 2), this.kDk);
                        this.kDm.addView(this.kDl, new ViewGroup.LayoutParams(-2, -2));
                        cS(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cRP();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cRG() {
        int i;
        int i2;
        if (this.mCamera == null && this.kDj != null) {
            this.kDj.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kDj.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.kDj.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.kDp.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.kDq != null) {
                this.kDq.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.kDp.setPreviewFormat(17);
        cRH();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.k(this.kDj, this.mCameraId));
        this.kDn = this.kDp.getSupportedFocusModes();
        if (this.kDn != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.kDn.contains("continuous-picture")) {
                this.kDp.setFocusMode("continuous-picture");
            } else if (this.kDn.contains("continuous-video")) {
                this.kDp.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.kDp);
        if (this.kDj != null && this.kDj.cSf() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kDr.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.kDr.setLayoutParams(layoutParams);
            this.kDr.invalidate();
            if (this.kDw != null) {
                this.kDw.cT(layoutParams.width, layoutParams.height);
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

    private void cRH() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.kDp.getSupportedPreviewFpsRange()) {
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
        this.kDp.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void tB(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.tx(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.tx(z)) {
                    cRK();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.ty(z);
            if (-1 != this.mCameraId) {
                cRJ();
                this.kDu = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                cRK();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cRK();
            if (this.kjC != null) {
                this.kjC.aP(8, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cRI() {
        return this.kDu;
    }

    private void cRJ() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.kDp = this.mCamera.getParameters();
            cRG();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.q(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cRK() {
        if (this.kDj != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDj.getPageContext().getPageActivity());
            aVar.jW(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.kDj != null) {
                        h.this.kDj.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fH(true);
            aVar.b(this.kDj.getPageContext());
            aVar.aEG();
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
                if (this.kjC != null) {
                    this.kjC.aP(6, com.baidu.tieba.k.a.q(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cRL() {
        try {
            if (this.mCamera != null) {
                if (this.kDp == null) {
                    this.kDp = this.mCamera.getParameters();
                }
                if ("off".equals(this.kDp.getFlashMode())) {
                    this.kDp.setFlashMode("torch");
                } else {
                    this.kDp.setFlashMode("off");
                }
                this.mCamera.setParameters(this.kDp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kjC != null) {
                this.kjC.aP(7, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    public boolean cRM() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.kDp == null) {
                this.kDp = this.mCamera.getParameters();
            }
            return !"off".equals(this.kDp.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kjC != null) {
                this.kjC.aP(7, com.baidu.tieba.k.a.q(e));
                return false;
            }
            return false;
        }
    }

    public void cRN() {
        if (this.kDr != null && (this.kDr instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.kDr;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cRw();
            this.kDo = this.kDo == 0 ? 1 : 0;
            tB(this.kDo == 1);
            gLVideoPreviewView.cRx();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.kDr != null && (this.kDr instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kDr).h(this.mCamera);
            releaseCamera();
            this.kDo = this.kDo == 0 ? 1 : 0;
            tB(this.kDo == 1);
            startPreview();
        }
    }

    public boolean getIsFrontCamera() {
        return this.kDo == 1;
    }

    private void cRO() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRP() {
        if (this.kDm != null && this.kDl != null && this.kDl.getParent() != null) {
            this.kDm.removeView(this.kDl);
        }
    }

    private void cS(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.kDn.contains("auto")) {
                this.kDp = this.mCamera.getParameters();
                this.kDp.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.kDp);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kjC != null) {
                this.kjC.aP(9, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends View {
        Bitmap bitmap;
        int left;

        /* renamed from: top  reason: collision with root package name */
        int f1028top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.f1028top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.f1028top, (Paint) null);
            super.onDraw(canvas);
        }
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.kDr instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kDr).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.kDr instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kDr).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.kDr instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kDr).setSticker(stickerItem);
        }
    }

    public void onResume() {
        tB(this.kDo == 1);
        if (this.kDr != null && (this.kDr instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kDr).onResume();
        }
        if (this.kDr != null && (this.kDr instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kDr).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cRr()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.kDq.h(this.mCamera);
        if (this.kDr != null && (this.kDr instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kDr).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.kDw = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.kCR = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.kDq instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.kDq != null) {
                        h.this.kDq.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.kDq.a(aVar);
        }
    }

    public boolean getCameraIsBack() {
        return this.mCameraId == 0;
    }
}
