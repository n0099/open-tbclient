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
/* loaded from: classes10.dex */
public class h {
    private SurfaceView bBo;
    private int cOy;
    protected String lBm;
    private g lGB;
    protected List<String> lGC;
    private b lGD;
    private com.baidu.tieba.video.record.b lGE;
    private GLVideoPreviewView.a lGF;
    private c lGG;
    private GLVideoPreviewView.a lGa;
    private RecordVideoActivity lGu;
    private Bitmap lGv;
    private a lGw;
    private FrameLayout lGx;
    private List<String> lGy;
    private com.baidu.tieba.k.h lmg;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int lGz = 0;
    private Camera.Parameters lGA = null;

    /* loaded from: classes10.dex */
    public interface b {
        void dkc();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void dd(int i, int i2);
    }

    public void ag(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.gX(false);
        aVar.kC(R.string.request_permission_default_title);
        aVar.kD(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.i.G(activity));
        aVar.aST();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lmg = lVar.cyB();
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
                        if (h.this.lGu != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ag(h.this.lGu);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.lGu, (int) R.string.disallow_camera_permission);
                            if (h.this.lmg != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.lGu.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.lmg.bj(1, string);
                            }
                            h.this.lGu.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.lGu != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.lGu, (int) R.string.disallow_audio_record_permission);
                            if (h.this.lmg != null) {
                                h.this.lmg.bj(2, h.this.lGu.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.lGu.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lGF = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void va(final boolean z) {
                if (h.this.lGa != null) {
                    com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.lGa.va(z);
                        }
                    });
                }
            }
        };
        this.lGu = recordVideoActivity;
        dka();
        this.lGv = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cOy = displayMetrics.heightPixels;
        this.lGx = this.lGu.dks();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.bBo = gLVideoPreviewView;
            this.lGB = gLVideoPreviewView;
            ((GLVideoPreviewView) this.bBo).setFaceIdentifyStateListener(this.lGF);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.bBo = videoPreviewView;
            this.lGB = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dks() != null) {
            recordVideoActivity.dks().addView(this.bBo, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.lGB.e(this.mCamera);
    }

    public void startRecord() {
        this.lGB.f(this.mCamera);
    }

    public void stopRecord() {
        this.lGB.g(this.mCamera);
    }

    public g djN() {
        return this.lGB;
    }

    public String djO() {
        if (this.lGC == null) {
            this.lGC = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.lzF);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.lzF + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.lGC.add(str);
        return str;
    }

    public void djP() {
        if (this.lGC != null && this.lGC.size() != 0) {
            String remove = this.lGC.remove(this.lGC.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String djQ() {
        File file = new File(com.baidu.tieba.video.c.lzF);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.lBm = com.baidu.tieba.video.c.lzF + "f_" + System.currentTimeMillis() + ".mp4";
        return this.lBm;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.lGD != null && motionEvent.getAction() == 0) {
            this.lGD.dkc();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dkb();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.lGD = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cOy && x >= com.baidu.adp.lib.util.l.getDimens(this.lGu, R.dimen.ds60)) {
                    int width = this.lGv.getWidth();
                    int height = this.lGv.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cOy - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.lGx == null) {
                            this.lGx = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.lGx.getChildCount()) {
                                if (this.lGw != this.lGx.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.lGx.removeViewAt(i);
                                }
                            }
                        }
                        this.lGw = new a(this.lGu, clamp - (width / 2), clamp2 - (height / 2), this.lGv);
                        this.lGx.addView(this.lGw, new ViewGroup.LayoutParams(-2, -2));
                        dc(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dkb();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void djR() {
        int i;
        int i2;
        if (this.mCamera == null && this.lGu != null) {
            this.lGu.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lGu.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.lGu.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.lGA.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.lGB != null) {
                this.lGB.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.lGA.setPreviewFormat(17);
        djS();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.i(this.lGu, this.mCameraId));
        this.lGy = this.lGA.getSupportedFocusModes();
        if (this.lGy != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.lGy.contains("continuous-picture")) {
                this.lGA.setFocusMode("continuous-picture");
            } else if (this.lGy.contains("continuous-video")) {
                this.lGA.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.lGA);
        if (this.lGu != null && this.lGu.dks() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bBo.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.bBo.setLayoutParams(layoutParams);
            this.bBo.invalidate();
            if (this.lGG != null) {
                this.lGG.dd(layoutParams.width, layoutParams.height);
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

    private void djS() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.lGA.getSupportedPreviewFpsRange()) {
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
        this.lGA.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void vb(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.uX(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.uX(z)) {
                    djV();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.uY(z);
            if (-1 != this.mCameraId) {
                djU();
                this.lGE = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                djV();
            }
        } catch (Exception e) {
            e.printStackTrace();
            djV();
            if (this.lmg != null) {
                this.lmg.bj(8, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b djT() {
        return this.lGE;
    }

    private void djU() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.lGA = this.mCamera.getParameters();
            djR();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.t(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void djV() {
        if (this.lGu != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lGu.getPageContext().getPageActivity());
            aVar.kD(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.lGu != null) {
                        h.this.lGu.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.gW(true);
            aVar.b(this.lGu.getPageContext());
            aVar.aST();
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
                if (this.lmg != null) {
                    this.lmg.bj(6, com.baidu.tieba.k.a.t(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void djW() {
        try {
            if (this.mCamera != null) {
                if (this.lGA == null) {
                    this.lGA = this.mCamera.getParameters();
                }
                if ("off".equals(this.lGA.getFlashMode())) {
                    this.lGA.setFlashMode("torch");
                } else {
                    this.lGA.setFlashMode("off");
                }
                this.mCamera.setParameters(this.lGA);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lmg != null) {
                this.lmg.bj(7, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    public boolean djX() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.lGA == null) {
                this.lGA = this.mCamera.getParameters();
            }
            return !"off".equals(this.lGA.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lmg != null) {
                this.lmg.bj(7, com.baidu.tieba.k.a.t(e));
                return false;
            }
            return false;
        }
    }

    public void djY() {
        if (this.bBo != null && (this.bBo instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.bBo;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.djG();
            this.lGz = this.lGz == 0 ? 1 : 0;
            vb(this.lGz == 1);
            gLVideoPreviewView.djH();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.bBo != null && (this.bBo instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bBo).h(this.mCamera);
            releaseCamera();
            this.lGz = this.lGz == 0 ? 1 : 0;
            vb(this.lGz == 1);
            startPreview();
        }
    }

    public boolean djZ() {
        return this.lGz == 1;
    }

    private void dka() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkb() {
        if (this.lGx != null && this.lGw != null && this.lGw.getParent() != null) {
            this.lGx.removeView(this.lGw);
        }
    }

    private void dc(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.lGy.contains("auto")) {
                this.lGA = this.mCamera.getParameters();
                this.lGA.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.lGA);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lmg != null) {
                this.lmg.bj(9, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends View {
        Bitmap bitmap;
        int left;

        /* renamed from: top  reason: collision with root package name */
        int f1026top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.f1026top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.f1026top, (Paint) null);
            super.onDraw(canvas);
        }
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.bBo instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bBo).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.bBo instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bBo).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.bBo instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bBo).setSticker(stickerItem);
        }
    }

    public void onResume() {
        vb(this.lGz == 1);
        if (this.bBo != null && (this.bBo instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bBo).onResume();
        }
        if (this.bBo != null && (this.bBo instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bBo).onResume();
        }
        if (!com.baidu.tieba.video.record.c.djB()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.lGB.h(this.mCamera);
        if (this.bBo != null && (this.bBo instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bBo).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.lGG = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.lGa = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.lGB instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.lGB != null) {
                        h.this.lGB.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.lGB.a(aVar);
        }
    }

    public boolean djL() {
        return this.mCameraId == 0;
    }
}
