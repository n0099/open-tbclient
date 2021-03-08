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
/* loaded from: classes7.dex */
public class h {
    private int dWJ;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private SurfaceView mSurfaceView;
    private com.baidu.tieba.l.g nAz;
    protected String nQY;
    private GLVideoPreviewView.a nSA;
    private RecordVideoActivity nST;
    private Bitmap nSU;
    private a nSV;
    private FrameLayout nSW;
    private List<String> nSX;
    private g nSZ;
    protected List<String> nTa;
    private b nTb;
    private com.baidu.tieba.video.record.b nTc;
    private GLVideoPreviewView.a nTd;
    private c nTe;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int cameraFacing = 0;
    private Camera.Parameters nSY = null;

    /* loaded from: classes7.dex */
    public interface b {
        void dUr();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void dA(int i, int i2);
    }

    public void ak(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jG(false);
        aVar.nx(R.string.request_permission_default_title);
        aVar.ny(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.j.J(activity));
        aVar.bqz();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nAz = kVar.dho();
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
                        if (h.this.nST != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ak(h.this.nST);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nST, R.string.disallow_camera_permission);
                            if (h.this.nAz != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nST.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.nAz.bK(1, string);
                            }
                            h.this.nST.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nST != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nST, R.string.disallow_audio_record_permission);
                            if (h.this.nAz != null) {
                                h.this.nAz.bK(2, h.this.nST.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nST.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nTd = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void zd(final boolean z) {
                if (h.this.nSA != null) {
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nSA.zd(z);
                        }
                    });
                }
            }
        };
        this.nST = recordVideoActivity;
        dUp();
        this.nSU = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dWJ = displayMetrics.heightPixels;
        this.nSW = this.nST.dUI();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.mSurfaceView = gLVideoPreviewView;
            this.nSZ = gLVideoPreviewView;
            ((GLVideoPreviewView) this.mSurfaceView).setFaceIdentifyStateListener(this.nTd);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.mSurfaceView = videoPreviewView;
            this.nSZ = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dUI() != null) {
            recordVideoActivity.dUI().addView(this.mSurfaceView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nSZ.e(this.mCamera);
    }

    public void startRecord() {
        this.nSZ.f(this.mCamera);
    }

    public void stopRecord() {
        this.nSZ.g(this.mCamera);
    }

    public g dUc() {
        return this.nSZ;
    }

    public String dUd() {
        if (this.nTa == null) {
            this.nTa = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nMR);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nMR + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nTa.add(str);
        return str;
    }

    public void dUe() {
        if (this.nTa != null && this.nTa.size() != 0) {
            String remove = this.nTa.remove(this.nTa.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dUf() {
        File file = new File(com.baidu.tieba.video.c.nMR);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nQY = com.baidu.tieba.video.c.nMR + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nQY;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nTb != null && motionEvent.getAction() == 0) {
            this.nTb.dUr();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dUq();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nTb = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dWJ && x >= com.baidu.adp.lib.util.l.getDimens(this.nST, R.dimen.ds60)) {
                    int width = this.nSU.getWidth();
                    int height = this.nSU.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dWJ - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nSW == null) {
                            this.nSW = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nSW.getChildCount()) {
                                if (this.nSV != this.nSW.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nSW.removeViewAt(i);
                                }
                            }
                        }
                        this.nSV = new a(this.nST, clamp - (width / 2), clamp2 - (height / 2), this.nSU);
                        this.nSW.addView(this.nSV, new ViewGroup.LayoutParams(-2, -2));
                        dz(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dUq();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dUg() {
        int i;
        if (this.mCamera == null && this.nST != null) {
            this.nST.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nST.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nST.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.nSY.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.nSZ != null) {
                this.nSZ.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.nSY.setPreviewFormat(17);
        dUh();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nST, this.mCameraId));
        this.nSX = this.nSY.getSupportedFocusModes();
        if (this.nSX != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nSX.contains("continuous-picture")) {
                this.nSY.setFocusMode("continuous-picture");
            } else if (this.nSX.contains("continuous-video")) {
                this.nSY.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nSY);
        if (this.nST != null && this.nST.dUI() != null) {
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
            if (this.nTe != null) {
                this.nTe.dA(layoutParams.width, layoutParams.height);
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

    private void dUh() {
        int[] iArr = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : this.nSY.getSupportedPreviewFpsRange()) {
            if (Math.abs(20000 - iArr2[1]) > i2 || Math.abs(15000 - iArr2[0]) > i) {
                iArr2 = iArr;
            } else {
                i2 = Math.abs(20000 - iArr2[1]);
                i = Math.abs(15000 - iArr2[0]);
            }
            iArr = iArr2;
        }
        this.nSY.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public void ze(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.za(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.za(z)) {
                    dUk();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.zb(z);
            if (-1 != this.mCameraId) {
                dUj();
                this.nTc = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dUk();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dUk();
            if (this.nAz != null) {
                this.nAz.bK(8, com.baidu.tieba.l.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dUi() {
        return this.nTc;
    }

    private void dUj() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nSY = this.mCamera.getParameters();
            dUg();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dUk() {
        if (this.nST != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nST.getPageContext().getPageActivity());
            aVar.ny(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nST != null) {
                        h.this.nST.finish();
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
            aVar.b(this.nST.getPageContext());
            aVar.bqz();
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
                if (this.nAz != null) {
                    this.nAz.bK(6, com.baidu.tieba.l.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dUl() {
        try {
            if (this.mCamera != null) {
                if (this.nSY == null) {
                    this.nSY = this.mCamera.getParameters();
                }
                if ("off".equals(this.nSY.getFlashMode())) {
                    this.nSY.setFlashMode("torch");
                } else {
                    this.nSY.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nSY);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nAz != null) {
                this.nAz.bK(7, com.baidu.tieba.l.a.o(e));
            }
        }
    }

    public boolean dUm() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nSY == null) {
                this.nSY = this.mCamera.getParameters();
            }
            return !"off".equals(this.nSY.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nAz != null) {
                this.nAz.bK(7, com.baidu.tieba.l.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void dUn() {
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.mSurfaceView;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dTV();
            this.cameraFacing = this.cameraFacing == 0 ? 1 : 0;
            ze(this.cameraFacing == 1);
            gLVideoPreviewView.dTW();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.mSurfaceView != null && (this.mSurfaceView instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.mSurfaceView).h(this.mCamera);
            releaseCamera();
            this.cameraFacing = this.cameraFacing == 0 ? 1 : 0;
            ze(this.cameraFacing == 1);
            startPreview();
        }
    }

    public boolean dUo() {
        return this.cameraFacing == 1;
    }

    private void dUp() {
        this.previewWidth = 720;
        this.previewHeight = 960;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUq() {
        if (this.nSW != null && this.nSV != null && this.nSV.getParent() != null) {
            this.nSW.removeView(this.nSV);
        }
    }

    private void dz(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nSX.contains("auto")) {
                this.nSY = this.mCamera.getParameters();
                this.nSY.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nSY);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nAz != null) {
                this.nAz.bK(9, com.baidu.tieba.l.a.o(e));
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
        ze(this.cameraFacing == 1);
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.mSurfaceView).onResume();
        }
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.mSurfaceView).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dTQ()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nSZ.h(this.mCamera);
        if (this.mSurfaceView != null && (this.mSurfaceView instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.mSurfaceView).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nTe = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nSA = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nSZ instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nSZ != null) {
                        h.this.nSZ.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nSZ.a(aVar);
        }
    }

    public boolean dUa() {
        return this.mCameraId == 0;
    }
}
