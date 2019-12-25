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
/* loaded from: classes7.dex */
public class h {
    private int bZc;
    private com.baidu.tieba.j.h kdc;
    protected String krK;
    private RecordVideoActivity kwM;
    private Bitmap kwN;
    private a kwO;
    private FrameLayout kwP;
    private List<String> kwQ;
    private g kwT;
    private SurfaceView kwU;
    protected List<String> kwV;
    private b kwW;
    private com.baidu.tieba.video.record.b kwX;
    private GLVideoPreviewView.a kwY;
    private c kwZ;
    private GLVideoPreviewView.a kwu;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int kwR = 0;
    private Camera.Parameters kwS = null;

    /* loaded from: classes7.dex */
    public interface b {
        void cOV();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void cQ(int i, int i2);
    }

    public void ah(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fv(false);
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
        aVar.aBW();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kdc = lVar.cei();
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
                        if (h.this.kwM != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ah(h.this.kwM);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.kwM, (int) R.string.disallow_camera_permission);
                            if (h.this.kdc != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.kwM.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.kdc.aJ(1, string);
                            }
                            h.this.kwM.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.kwM != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.kwM, (int) R.string.disallow_audio_record_permission);
                            if (h.this.kdc != null) {
                                h.this.kdc.aJ(2, h.this.kwM.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.kwM.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kwY = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void te(final boolean z) {
                if (h.this.kwu != null) {
                    com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.kwu.te(z);
                        }
                    });
                }
            }
        };
        this.kwM = recordVideoActivity;
        cOT();
        this.kwN = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.bZc = displayMetrics.heightPixels;
        this.kwP = this.kwM.cPk();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.kwU = gLVideoPreviewView;
            this.kwT = gLVideoPreviewView;
            ((GLVideoPreviewView) this.kwU).setFaceIdentifyStateListener(this.kwY);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.kwU = videoPreviewView;
            this.kwT = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cPk() != null) {
            recordVideoActivity.cPk().addView(this.kwU, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.kwT.e(this.mCamera);
    }

    public void startRecord() {
        this.kwT.f(this.mCamera);
    }

    public void stopRecord() {
        this.kwT.g(this.mCamera);
    }

    public g cOH() {
        return this.kwT;
    }

    public String cOI() {
        if (this.kwV == null) {
            this.kwV = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.kqg);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.kqg + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.kwV.add(str);
        return str;
    }

    public void cOJ() {
        if (this.kwV != null && this.kwV.size() != 0) {
            String remove = this.kwV.remove(this.kwV.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cOK() {
        File file = new File(com.baidu.tieba.video.c.kqg);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.krK = com.baidu.tieba.video.c.kqg + "f_" + System.currentTimeMillis() + ".mp4";
        return this.krK;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.kwW != null && motionEvent.getAction() == 0) {
            this.kwW.cOV();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cOU();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.kwW = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.bZc && x >= com.baidu.adp.lib.util.l.getDimens(this.kwM, R.dimen.ds60)) {
                    int width = this.kwN.getWidth();
                    int height = this.kwN.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.bZc - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.kwP == null) {
                            this.kwP = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.kwP.getChildCount()) {
                                if (this.kwO != this.kwP.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.kwP.removeViewAt(i);
                                }
                            }
                        }
                        this.kwO = new a(this.kwM, clamp - (width / 2), clamp2 - (height / 2), this.kwN);
                        this.kwP.addView(this.kwO, new ViewGroup.LayoutParams(-2, -2));
                        cP(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cOU();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cOL() {
        int i;
        int i2;
        if (this.mCamera == null && this.kwM != null) {
            this.kwM.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kwM.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.kwM.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.kwS.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.kwT != null) {
                this.kwT.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.kwS.setPreviewFormat(17);
        cOM();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.kwM, this.mCameraId));
        this.kwQ = this.kwS.getSupportedFocusModes();
        if (this.kwQ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.kwQ.contains("continuous-picture")) {
                this.kwS.setFocusMode("continuous-picture");
            } else if (this.kwQ.contains("continuous-video")) {
                this.kwS.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.kwS);
        if (this.kwM != null && this.kwM.cPk() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kwU.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.kwU.setLayoutParams(layoutParams);
            this.kwU.invalidate();
            if (this.kwZ != null) {
                this.kwZ.cQ(layoutParams.width, layoutParams.height);
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

    private void cOM() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.kwS.getSupportedPreviewFpsRange()) {
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
        this.kwS.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void tf(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.tb(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.tb(z)) {
                    cOP();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.tc(z);
            if (-1 != this.mCameraId) {
                cOO();
                this.kwX = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                cOP();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cOP();
            if (this.kdc != null) {
                this.kdc.aJ(8, com.baidu.tieba.j.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cON() {
        return this.kwX;
    }

    private void cOO() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.kwS = this.mCamera.getParameters();
            cOL();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cOP() {
        if (this.kwM != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kwM.getPageContext().getPageActivity());
            aVar.jF(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.kwM != null) {
                        h.this.kwM.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fu(true);
            aVar.b(this.kwM.getPageContext());
            aVar.aBW();
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
                if (this.kdc != null) {
                    this.kdc.aJ(6, com.baidu.tieba.j.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cOQ() {
        try {
            if (this.mCamera != null) {
                if (this.kwS == null) {
                    this.kwS = this.mCamera.getParameters();
                }
                if ("off".equals(this.kwS.getFlashMode())) {
                    this.kwS.setFlashMode("torch");
                } else {
                    this.kwS.setFlashMode("off");
                }
                this.mCamera.setParameters(this.kwS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kdc != null) {
                this.kdc.aJ(7, com.baidu.tieba.j.a.r(e));
            }
        }
    }

    public boolean cOR() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.kwS == null) {
                this.kwS = this.mCamera.getParameters();
            }
            return !"off".equals(this.kwS.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kdc != null) {
                this.kdc.aJ(7, com.baidu.tieba.j.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void cOS() {
        if (this.kwU != null && (this.kwU instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.kwU;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cOB();
            this.kwR = this.kwR == 0 ? 1 : 0;
            tf(this.kwR == 1);
            gLVideoPreviewView.cOC();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.kwU != null && (this.kwU instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kwU).h(this.mCamera);
            releaseCamera();
            this.kwR = this.kwR == 0 ? 1 : 0;
            tf(this.kwR == 1);
            startPreview();
        }
    }

    public boolean getIsFrontCamera() {
        return this.kwR == 1;
    }

    private void cOT() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOU() {
        if (this.kwP != null && this.kwO != null && this.kwO.getParent() != null) {
            this.kwP.removeView(this.kwO);
        }
    }

    private void cP(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.kwQ.contains("auto")) {
                this.kwS = this.mCamera.getParameters();
                this.kwS.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.kwS);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kdc != null) {
                this.kdc.aJ(9, com.baidu.tieba.j.a.r(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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
        if (this.kwU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kwU).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.kwU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kwU).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.kwU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kwU).setSticker(stickerItem);
        }
    }

    public void onResume() {
        tf(this.kwR == 1);
        if (this.kwU != null && (this.kwU instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kwU).onResume();
        }
        if (this.kwU != null && (this.kwU instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kwU).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cOw()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.kwT.h(this.mCamera);
        if (this.kwU != null && (this.kwU instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kwU).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.kwZ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.kwu = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.kwT instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.kwT != null) {
                        h.this.kwT.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.kwT.a(aVar);
        }
    }

    public boolean getCameraIsBack() {
        return this.mCameraId == 0;
    }
}
