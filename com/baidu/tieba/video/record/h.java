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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class h {
    private int dVi;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private SurfaceView mSurfaceView;
    protected String nOT;
    private RecordVideoActivity nQO;
    private Bitmap nQP;
    private a nQQ;
    private FrameLayout nQR;
    private List<String> nQS;
    private g nQU;
    protected List<String> nQV;
    private b nQW;
    private com.baidu.tieba.video.record.b nQX;
    private GLVideoPreviewView.a nQY;
    private c nQZ;
    private GLVideoPreviewView.a nQv;
    private com.baidu.tieba.l.g nyu;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int cameraFacing = 0;
    private Camera.Parameters nQT = null;

    /* loaded from: classes8.dex */
    public interface b {
        void dUj();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void dA(int i, int i2);
    }

    public void ak(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jG(false);
        aVar.nw(R.string.request_permission_default_title);
        aVar.nx(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.j.K(activity));
        aVar.bqx();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nyu = kVar.dhf();
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
                        if (h.this.nQO != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ak(h.this.nQO);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nQO, R.string.disallow_camera_permission);
                            if (h.this.nyu != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nQO.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.nyu.bK(1, string);
                            }
                            h.this.nQO.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nQO != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nQO, R.string.disallow_audio_record_permission);
                            if (h.this.nyu != null) {
                                h.this.nyu.bK(2, h.this.nQO.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nQO.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nQY = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void ze(final boolean z) {
                if (h.this.nQv != null) {
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nQv.ze(z);
                        }
                    });
                }
            }
        };
        this.nQO = recordVideoActivity;
        dUh();
        this.nQP = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dVi = displayMetrics.heightPixels;
        this.nQR = this.nQO.dUA();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.mSurfaceView = gLVideoPreviewView;
            this.nQU = gLVideoPreviewView;
            ((GLVideoPreviewView) this.mSurfaceView).setFaceIdentifyStateListener(this.nQY);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.mSurfaceView = videoPreviewView;
            this.nQU = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dUA() != null) {
            recordVideoActivity.dUA().addView(this.mSurfaceView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nQU.e(this.mCamera);
    }

    public void startRecord() {
        this.nQU.f(this.mCamera);
    }

    public void stopRecord() {
        this.nQU.g(this.mCamera);
    }

    public g dTU() {
        return this.nQU;
    }

    public String dTV() {
        if (this.nQV == null) {
            this.nQV = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nKM);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nKM + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nQV.add(str);
        return str;
    }

    public void dTW() {
        if (this.nQV != null && this.nQV.size() != 0) {
            String remove = this.nQV.remove(this.nQV.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dTX() {
        File file = new File(com.baidu.tieba.video.c.nKM);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nOT = com.baidu.tieba.video.c.nKM + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nOT;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nQW != null && motionEvent.getAction() == 0) {
            this.nQW.dUj();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dUi();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nQW = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dVi && x >= com.baidu.adp.lib.util.l.getDimens(this.nQO, R.dimen.ds60)) {
                    int width = this.nQP.getWidth();
                    int height = this.nQP.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dVi - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nQR == null) {
                            this.nQR = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nQR.getChildCount()) {
                                if (this.nQQ != this.nQR.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nQR.removeViewAt(i);
                                }
                            }
                        }
                        this.nQQ = new a(this.nQO, clamp - (width / 2), clamp2 - (height / 2), this.nQP);
                        this.nQR.addView(this.nQQ, new ViewGroup.LayoutParams(-2, -2));
                        dz(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dUi();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dTY() {
        int i;
        if (this.mCamera == null && this.nQO != null) {
            this.nQO.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nQO.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nQO.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.nQT.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.nQU != null) {
                this.nQU.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.nQT.setPreviewFormat(17);
        dTZ();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nQO, this.mCameraId));
        this.nQS = this.nQT.getSupportedFocusModes();
        if (this.nQS != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nQS.contains("continuous-picture")) {
                this.nQT.setFocusMode("continuous-picture");
            } else if (this.nQS.contains("continuous-video")) {
                this.nQT.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nQT);
        if (this.nQO != null && this.nQO.dUA() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = (int) (equipmentWidth / f2);
            } else {
                equipmentWidth = (int) (screenHeight * f2);
                i = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mSurfaceView.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = i;
            this.mSurfaceView.setLayoutParams(layoutParams);
            this.mSurfaceView.invalidate();
            if (this.nQZ != null) {
                this.nQZ.dA(layoutParams.width, layoutParams.height);
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

    private void dTZ() {
        int[] iArr = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : this.nQT.getSupportedPreviewFpsRange()) {
            if (Math.abs(20000 - iArr2[1]) > i2 || Math.abs(15000 - iArr2[0]) > i) {
                iArr2 = iArr;
            } else {
                i2 = Math.abs(20000 - iArr2[1]);
                i = Math.abs(15000 - iArr2[0]);
            }
            iArr = iArr2;
        }
        this.nQT.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public void zf(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.zb(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.zb(z)) {
                    dUc();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.zc(z);
            if (-1 != this.mCameraId) {
                dUb();
                this.nQX = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dUc();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dUc();
            if (this.nyu != null) {
                this.nyu.bK(8, com.baidu.tieba.l.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dUa() {
        return this.nQX;
    }

    private void dUb() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nQT = this.mCamera.getParameters();
            dTY();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dUc() {
        if (this.nQO != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nQO.getPageContext().getPageActivity());
            aVar.nx(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nQO != null) {
                        h.this.nQO.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.jF(true);
            aVar.b(this.nQO.getPageContext());
            aVar.bqx();
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
                if (this.nyu != null) {
                    this.nyu.bK(6, com.baidu.tieba.l.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dUd() {
        try {
            if (this.mCamera != null) {
                if (this.nQT == null) {
                    this.nQT = this.mCamera.getParameters();
                }
                if ("off".equals(this.nQT.getFlashMode())) {
                    this.nQT.setFlashMode("torch");
                } else {
                    this.nQT.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nQT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nyu != null) {
                this.nyu.bK(7, com.baidu.tieba.l.a.o(e));
            }
        }
    }

    public boolean dUe() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nQT == null) {
                this.nQT = this.mCamera.getParameters();
            }
            return !"off".equals(this.nQT.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nyu != null) {
                this.nyu.bK(7, com.baidu.tieba.l.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void dUf() {
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.mSurfaceView;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dTN();
            this.cameraFacing = this.cameraFacing == 0 ? 1 : 0;
            zf(this.cameraFacing == 1);
            gLVideoPreviewView.dTO();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.mSurfaceView != null && (this.mSurfaceView instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.mSurfaceView).h(this.mCamera);
            releaseCamera();
            this.cameraFacing = this.cameraFacing == 0 ? 1 : 0;
            zf(this.cameraFacing == 1);
            startPreview();
        }
    }

    public boolean dUg() {
        return this.cameraFacing == 1;
    }

    private void dUh() {
        this.previewWidth = 720;
        this.previewHeight = 960;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUi() {
        if (this.nQR != null && this.nQQ != null && this.nQQ.getParent() != null) {
            this.nQR.removeView(this.nQQ);
        }
    }

    private void dz(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nQS.contains("auto")) {
                this.nQT = this.mCamera.getParameters();
                this.nQT.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nQT);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nyu != null) {
                this.nyu.bK(9, com.baidu.tieba.l.a.o(e));
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
        if (this.mSurfaceView instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.mSurfaceView).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.mSurfaceView instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.mSurfaceView).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.mSurfaceView instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.mSurfaceView).setSticker(stickerItem);
        }
    }

    public void onResume() {
        zf(this.cameraFacing == 1);
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.mSurfaceView).onResume();
        }
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.mSurfaceView).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dTI()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nQU.h(this.mCamera);
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.mSurfaceView).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nQZ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nQv = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nQU instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nQU != null) {
                        h.this.nQU.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nQU.a(aVar);
        }
    }

    public boolean dTS() {
        return this.mCameraId == 0;
    }
}
