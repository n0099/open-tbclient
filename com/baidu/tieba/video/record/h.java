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
import android.support.v7.widget.ActivityChooserView;
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
/* loaded from: classes22.dex */
public class h {
    private SurfaceView bOe;
    private int bPI;
    private int bPJ;
    private int djl;
    private Camera mCamera;
    protected boolean mFrontCamera;
    protected String mHR;
    private RecordVideoActivity mKF;
    private Bitmap mKG;
    private a mKH;
    private FrameLayout mKI;
    private List<String> mKJ;
    private g mKM;
    protected List<String> mKN;
    private b mKO;
    private com.baidu.tieba.video.record.b mKP;
    private GLVideoPreviewView.a mKQ;
    private c mKR;
    private GLVideoPreviewView.a mKl;
    private Handler mMainHandler;
    private com.baidu.tieba.k.h mpU;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int mKK = 0;
    private Camera.Parameters mKL = null;

    /* loaded from: classes22.dex */
    public interface b {
        void dHp();
    }

    /* loaded from: classes22.dex */
    public interface c {
        void dx(int i, int i2);
    }

    public void an(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.ie(false);
        aVar.nD(R.string.request_permission_default_title);
        aVar.nE(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.i.I(activity));
        aVar.bia();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
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
                        if (h.this.mKF != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.an(h.this.mKF);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.mKF, R.string.disallow_camera_permission);
                            if (h.this.mpU != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.mKF.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.mpU.bq(1, string);
                            }
                            h.this.mKF.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.mKF != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.mKF, R.string.disallow_audio_record_permission);
                            if (h.this.mpU != null) {
                                h.this.mpU.bq(2, h.this.mKF.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.mKF.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.mKQ = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void wW(final boolean z) {
                if (h.this.mKl != null) {
                    com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.mKl.wW(z);
                        }
                    });
                }
            }
        };
        this.mKF = recordVideoActivity;
        dHn();
        this.mKG = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.djl = displayMetrics.heightPixels;
        this.mKI = this.mKF.dHF();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.bOe = gLVideoPreviewView;
            this.mKM = gLVideoPreviewView;
            ((GLVideoPreviewView) this.bOe).setFaceIdentifyStateListener(this.mKQ);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.bOe = videoPreviewView;
            this.mKM = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dHF() != null) {
            recordVideoActivity.dHF().addView(this.bOe, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.mKM.e(this.mCamera);
    }

    public void startRecord() {
        this.mKM.f(this.mCamera);
    }

    public void stopRecord() {
        this.mKM.g(this.mCamera);
    }

    public g dHa() {
        return this.mKM;
    }

    public String dHb() {
        if (this.mKN == null) {
            this.mKN = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.mDD);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.mDD + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.mKN.add(str);
        return str;
    }

    public void dHc() {
        if (this.mKN != null && this.mKN.size() != 0) {
            String remove = this.mKN.remove(this.mKN.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dHd() {
        File file = new File(com.baidu.tieba.video.c.mDD);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mHR = com.baidu.tieba.video.c.mDD + "f_" + System.currentTimeMillis() + ".mp4";
        return this.mHR;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.mKO != null && motionEvent.getAction() == 0) {
            this.mKO.dHp();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dHo();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.mKO = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.djl && x >= com.baidu.adp.lib.util.l.getDimens(this.mKF, R.dimen.ds60)) {
                    int width = this.mKG.getWidth();
                    int height = this.mKG.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.djl - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.mKI == null) {
                            this.mKI = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.mKI.getChildCount()) {
                                if (this.mKH != this.mKI.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.mKI.removeViewAt(i);
                                }
                            }
                        }
                        this.mKH = new a(this.mKF, clamp - (width / 2), clamp2 - (height / 2), this.mKG);
                        this.mKI.addView(this.mKH, new ViewGroup.LayoutParams(-2, -2));
                        dw(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dHo();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dHe() {
        int i;
        int i2;
        if (this.mCamera == null && this.mKF != null) {
            this.mKF.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mKF.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.mKF.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.bPI = c2.width;
            this.bPJ = c2.height;
            this.mKL.setPreviewSize(this.bPI, this.bPJ);
            if (this.mKM != null) {
                this.mKM.setPreviewSize(this.bPI, this.bPJ);
            }
        }
        this.mKL.setPreviewFormat(17);
        dHf();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.mKF, this.mCameraId));
        this.mKJ = this.mKL.getSupportedFocusModes();
        if (this.mKJ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.mKJ.contains("continuous-picture")) {
                this.mKL.setFocusMode("continuous-picture");
            } else if (this.mKJ.contains("continuous-video")) {
                this.mKL.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.mKL);
        if (this.mKF != null && this.mKF.dHF() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.bPJ * 1.0f) / this.bPI;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bOe.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.bOe.setLayoutParams(layoutParams);
            this.bOe.invalidate();
            if (this.mKR != null) {
                this.mKR.dx(layoutParams.width, layoutParams.height);
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

    private void dHf() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.mKL.getSupportedPreviewFpsRange()) {
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
        this.mKL.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void wX(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.wT(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.wT(z)) {
                    dHi();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.wU(z);
            if (-1 != this.mCameraId) {
                dHh();
                this.mKP = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dHi();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dHi();
            if (this.mpU != null) {
                this.mpU.bq(8, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dHg() {
        return this.mKP;
    }

    private void dHh() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.mKL = this.mCamera.getParameters();
            dHe();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dHi() {
        if (this.mKF != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mKF.getPageContext().getPageActivity());
            aVar.nE(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.mKF != null) {
                        h.this.mKF.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.id(true);
            aVar.b(this.mKF.getPageContext());
            aVar.bia();
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
                if (this.mpU != null) {
                    this.mpU.bq(6, com.baidu.tieba.k.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dHj() {
        try {
            if (this.mCamera != null) {
                if (this.mKL == null) {
                    this.mKL = this.mCamera.getParameters();
                }
                if ("off".equals(this.mKL.getFlashMode())) {
                    this.mKL.setFlashMode("torch");
                } else {
                    this.mKL.setFlashMode("off");
                }
                this.mCamera.setParameters(this.mKL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mpU != null) {
                this.mpU.bq(7, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public boolean dHk() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.mKL == null) {
                this.mKL = this.mCamera.getParameters();
            }
            return !"off".equals(this.mKL.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mpU != null) {
                this.mpU.bq(7, com.baidu.tieba.k.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dHl() {
        if (this.bOe != null && (this.bOe instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.bOe;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dGT();
            this.mKK = this.mKK == 0 ? 1 : 0;
            wX(this.mKK == 1);
            gLVideoPreviewView.dGU();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.bOe != null && (this.bOe instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bOe).h(this.mCamera);
            releaseCamera();
            this.mKK = this.mKK == 0 ? 1 : 0;
            wX(this.mKK == 1);
            startPreview();
        }
    }

    public boolean dHm() {
        return this.mKK == 1;
    }

    private void dHn() {
        this.bPI = 720;
        this.bPJ = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHo() {
        if (this.mKI != null && this.mKH != null && this.mKH.getParent() != null) {
            this.mKI.removeView(this.mKH);
        }
    }

    private void dw(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.mKJ.contains("auto")) {
                this.mKL = this.mCamera.getParameters();
                this.mKL.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.mKL);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mpU != null) {
                this.mpU.bq(9, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
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
        if (this.bOe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bOe).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.bOe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bOe).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.bOe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bOe).setSticker(stickerItem);
        }
    }

    public void onResume() {
        wX(this.mKK == 1);
        if (this.bOe != null && (this.bOe instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bOe).onResume();
        }
        if (this.bOe != null && (this.bOe instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bOe).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dGO()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.mKM.h(this.mCamera);
        if (this.bOe != null && (this.bOe instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bOe).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.mKR = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.mKl = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.mKM instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.mKM != null) {
                        h.this.mKM.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.mKM.a(aVar);
        }
    }

    public boolean dGY() {
        return this.mCameraId == 0;
    }
}
