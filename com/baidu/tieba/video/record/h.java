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
/* loaded from: classes23.dex */
public class h {
    private SurfaceView bUN;
    private int bZe;
    private int bZf;
    private int dvr;
    private Camera mCamera;
    private com.baidu.tieba.k.h mFB;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    protected String mXC;
    private GLVideoPreviewView.a mZS;
    private RecordVideoActivity nam;
    private Bitmap nan;
    private a nao;
    private FrameLayout nap;
    private List<String> naq;
    private g nat;
    protected List<String> nau;
    private b nav;
    private com.baidu.tieba.video.record.b naw;
    private GLVideoPreviewView.a nax;
    private c nay;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nar = 0;
    private Camera.Parameters nas = null;

    /* loaded from: classes23.dex */
    public interface b {
        void dLb();
    }

    /* loaded from: classes23.dex */
    public interface c {
        void dx(int i, int i2);
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iA(false);
        aVar.oa(R.string.request_permission_default_title);
        aVar.ob(R.string.request_permission_camera);
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
        aVar.bkJ();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mFB = lVar.cYJ();
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
                        if (h.this.nam != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ao(h.this.nam);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nam, R.string.disallow_camera_permission);
                            if (h.this.mFB != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nam.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.mFB.bA(1, string);
                            }
                            h.this.nam.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nam != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nam, R.string.disallow_audio_record_permission);
                            if (h.this.mFB != null) {
                                h.this.mFB.bA(2, h.this.nam.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nam.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nax = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void xD(final boolean z) {
                if (h.this.mZS != null) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.mZS.xD(z);
                        }
                    });
                }
            }
        };
        this.nam = recordVideoActivity;
        dKZ();
        this.nan = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dvr = displayMetrics.heightPixels;
        this.nap = this.nam.dLr();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.bUN = gLVideoPreviewView;
            this.nat = gLVideoPreviewView;
            ((GLVideoPreviewView) this.bUN).setFaceIdentifyStateListener(this.nax);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.bUN = videoPreviewView;
            this.nat = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dLr() != null) {
            recordVideoActivity.dLr().addView(this.bUN, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nat.e(this.mCamera);
    }

    public void startRecord() {
        this.nat.f(this.mCamera);
    }

    public void stopRecord() {
        this.nat.g(this.mCamera);
    }

    public g dKM() {
        return this.nat;
    }

    public String dKN() {
        if (this.nau == null) {
            this.nau = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.mTq);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.mTq + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nau.add(str);
        return str;
    }

    public void dKO() {
        if (this.nau != null && this.nau.size() != 0) {
            String remove = this.nau.remove(this.nau.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dKP() {
        File file = new File(com.baidu.tieba.video.c.mTq);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mXC = com.baidu.tieba.video.c.mTq + "f_" + System.currentTimeMillis() + ".mp4";
        return this.mXC;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nav != null && motionEvent.getAction() == 0) {
            this.nav.dLb();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dLa();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nav = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dvr && x >= com.baidu.adp.lib.util.l.getDimens(this.nam, R.dimen.ds60)) {
                    int width = this.nan.getWidth();
                    int height = this.nan.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dvr - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nap == null) {
                            this.nap = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nap.getChildCount()) {
                                if (this.nao != this.nap.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nap.removeViewAt(i);
                                }
                            }
                        }
                        this.nao = new a(this.nam, clamp - (width / 2), clamp2 - (height / 2), this.nan);
                        this.nap.addView(this.nao, new ViewGroup.LayoutParams(-2, -2));
                        dw(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dLa();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dKQ() {
        int i;
        int i2;
        if (this.mCamera == null && this.nam != null) {
            this.nam.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nam.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nam.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.bZe = c2.width;
            this.bZf = c2.height;
            this.nas.setPreviewSize(this.bZe, this.bZf);
            if (this.nat != null) {
                this.nat.setPreviewSize(this.bZe, this.bZf);
            }
        }
        this.nas.setPreviewFormat(17);
        dKR();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nam, this.mCameraId));
        this.naq = this.nas.getSupportedFocusModes();
        if (this.naq != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.naq.contains("continuous-picture")) {
                this.nas.setFocusMode("continuous-picture");
            } else if (this.naq.contains("continuous-video")) {
                this.nas.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nas);
        if (this.nam != null && this.nam.dLr() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.bZf * 1.0f) / this.bZe;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bUN.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.bUN.setLayoutParams(layoutParams);
            this.bUN.invalidate();
            if (this.nay != null) {
                this.nay.dx(layoutParams.width, layoutParams.height);
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

    private void dKR() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.nas.getSupportedPreviewFpsRange()) {
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
        this.nas.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void xE(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.xA(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.xA(z)) {
                    dKU();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.xB(z);
            if (-1 != this.mCameraId) {
                dKT();
                this.naw = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dKU();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dKU();
            if (this.mFB != null) {
                this.mFB.bA(8, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dKS() {
        return this.naw;
    }

    private void dKT() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nas = this.mCamera.getParameters();
            dKQ();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dKU() {
        if (this.nam != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nam.getPageContext().getPageActivity());
            aVar.ob(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nam != null) {
                        h.this.nam.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.iz(true);
            aVar.b(this.nam.getPageContext());
            aVar.bkJ();
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
                if (this.mFB != null) {
                    this.mFB.bA(6, com.baidu.tieba.k.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dKV() {
        try {
            if (this.mCamera != null) {
                if (this.nas == null) {
                    this.nas = this.mCamera.getParameters();
                }
                if ("off".equals(this.nas.getFlashMode())) {
                    this.nas.setFlashMode("torch");
                } else {
                    this.nas.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nas);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mFB != null) {
                this.mFB.bA(7, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public boolean dKW() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nas == null) {
                this.nas = this.mCamera.getParameters();
            }
            return !"off".equals(this.nas.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mFB != null) {
                this.mFB.bA(7, com.baidu.tieba.k.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dKX() {
        if (this.bUN != null && (this.bUN instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.bUN;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dKF();
            this.nar = this.nar == 0 ? 1 : 0;
            xE(this.nar == 1);
            gLVideoPreviewView.dKG();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.bUN != null && (this.bUN instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bUN).h(this.mCamera);
            releaseCamera();
            this.nar = this.nar == 0 ? 1 : 0;
            xE(this.nar == 1);
            startPreview();
        }
    }

    public boolean dKY() {
        return this.nar == 1;
    }

    private void dKZ() {
        this.bZe = 720;
        this.bZf = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLa() {
        if (this.nap != null && this.nao != null && this.nao.getParent() != null) {
            this.nap.removeView(this.nao);
        }
    }

    private void dw(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.naq.contains("auto")) {
                this.nas = this.mCamera.getParameters();
                this.nas.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nas);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mFB != null) {
                this.mFB.bA(9, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
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
        if (this.bUN instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bUN).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.bUN instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bUN).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.bUN instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bUN).setSticker(stickerItem);
        }
    }

    public void onResume() {
        xE(this.nar == 1);
        if (this.bUN != null && (this.bUN instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bUN).onResume();
        }
        if (this.bUN != null && (this.bUN instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bUN).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dKA()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nat.h(this.mCamera);
        if (this.bUN != null && (this.bUN instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bUN).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nay = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.mZS = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nat instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nat != null) {
                        h.this.nat.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nat.a(aVar);
        }
    }

    public boolean dKK() {
        return this.mCameraId == 0;
    }
}
