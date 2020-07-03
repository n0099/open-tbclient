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
    private SurfaceView bGc;
    private int cTi;
    private com.baidu.tieba.k.h lHf;
    protected String lYH;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private g mbB;
    protected List<String> mbC;
    private b mbD;
    private com.baidu.tieba.video.record.b mbE;
    private GLVideoPreviewView.a mbF;
    private c mbG;
    private GLVideoPreviewView.a mba;
    private RecordVideoActivity mbu;
    private Bitmap mbv;
    private a mbw;
    private FrameLayout mbx;
    private List<String> mby;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int mbz = 0;
    private Camera.Parameters mbA = null;

    /* loaded from: classes10.dex */
    public interface b {
        void doD();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void dj(int i, int i2);
    }

    public void ah(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.hg(false);
        aVar.kS(R.string.request_permission_default_title);
        aVar.kT(R.string.request_permission_camera);
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
        aVar.aUN();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCP();
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
                        if (h.this.mbu != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ah(h.this.mbu);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.mbu, (int) R.string.disallow_camera_permission);
                            if (h.this.lHf != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.mbu.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.lHf.bn(1, string);
                            }
                            h.this.mbu.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.mbu != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.mbu, (int) R.string.disallow_audio_record_permission);
                            if (h.this.lHf != null) {
                                h.this.lHf.bn(2, h.this.mbu.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.mbu.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.mbF = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void vs(final boolean z) {
                if (h.this.mba != null) {
                    com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.mba.vs(z);
                        }
                    });
                }
            }
        };
        this.mbu = recordVideoActivity;
        doB();
        this.mbv = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cTi = displayMetrics.heightPixels;
        this.mbx = this.mbu.doT();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.bGc = gLVideoPreviewView;
            this.mbB = gLVideoPreviewView;
            ((GLVideoPreviewView) this.bGc).setFaceIdentifyStateListener(this.mbF);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.bGc = videoPreviewView;
            this.mbB = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.doT() != null) {
            recordVideoActivity.doT().addView(this.bGc, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.mbB.e(this.mCamera);
    }

    public void startRecord() {
        this.mbB.f(this.mCamera);
    }

    public void stopRecord() {
        this.mbB.g(this.mCamera);
    }

    public g doo() {
        return this.mbB;
    }

    public String dop() {
        if (this.mbC == null) {
            this.mbC = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.d.lUu);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.d.lUu + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.mbC.add(str);
        return str;
    }

    public void doq() {
        if (this.mbC != null && this.mbC.size() != 0) {
            String remove = this.mbC.remove(this.mbC.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dor() {
        File file = new File(com.baidu.tieba.video.d.lUu);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.lYH = com.baidu.tieba.video.d.lUu + "f_" + System.currentTimeMillis() + ".mp4";
        return this.lYH;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.mbD != null && motionEvent.getAction() == 0) {
            this.mbD.doD();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.doC();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.mbD = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cTi && x >= com.baidu.adp.lib.util.l.getDimens(this.mbu, R.dimen.ds60)) {
                    int width = this.mbv.getWidth();
                    int height = this.mbv.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cTi - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.mbx == null) {
                            this.mbx = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.mbx.getChildCount()) {
                                if (this.mbw != this.mbx.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.mbx.removeViewAt(i);
                                }
                            }
                        }
                        this.mbw = new a(this.mbu, clamp - (width / 2), clamp2 - (height / 2), this.mbv);
                        this.mbx.addView(this.mbw, new ViewGroup.LayoutParams(-2, -2));
                        di(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.doC();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dos() {
        int i;
        int i2;
        if (this.mCamera == null && this.mbu != null) {
            this.mbu.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mbu.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.mbu.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.mbA.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.mbB != null) {
                this.mbB.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.mbA.setPreviewFormat(17);
        dot();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.mbu, this.mCameraId));
        this.mby = this.mbA.getSupportedFocusModes();
        if (this.mby != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.mby.contains("continuous-picture")) {
                this.mbA.setFocusMode("continuous-picture");
            } else if (this.mby.contains("continuous-video")) {
                this.mbA.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.mbA);
        if (this.mbu != null && this.mbu.doT() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bGc.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.bGc.setLayoutParams(layoutParams);
            this.bGc.invalidate();
            if (this.mbG != null) {
                this.mbG.dj(layoutParams.width, layoutParams.height);
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

    private void dot() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.mbA.getSupportedPreviewFpsRange()) {
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
        this.mbA.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void vt(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.vp(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.vp(z)) {
                    dow();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.vq(z);
            if (-1 != this.mCameraId) {
                dov();
                this.mbE = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dow();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dow();
            if (this.lHf != null) {
                this.lHf.bn(8, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dou() {
        return this.mbE;
    }

    private void dov() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.mbA = this.mCamera.getParameters();
            dos();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.t(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dow() {
        if (this.mbu != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mbu.getPageContext().getPageActivity());
            aVar.kT(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.mbu != null) {
                        h.this.mbu.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.hf(true);
            aVar.b(this.mbu.getPageContext());
            aVar.aUN();
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
                if (this.lHf != null) {
                    this.lHf.bn(6, com.baidu.tieba.k.a.t(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dox() {
        try {
            if (this.mCamera != null) {
                if (this.mbA == null) {
                    this.mbA = this.mCamera.getParameters();
                }
                if ("off".equals(this.mbA.getFlashMode())) {
                    this.mbA.setFlashMode("torch");
                } else {
                    this.mbA.setFlashMode("off");
                }
                this.mCamera.setParameters(this.mbA);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(7, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    public boolean doy() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.mbA == null) {
                this.mbA = this.mCamera.getParameters();
            }
            return !"off".equals(this.mbA.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(7, com.baidu.tieba.k.a.t(e));
                return false;
            }
            return false;
        }
    }

    public void doz() {
        if (this.bGc != null && (this.bGc instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.bGc;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.doh();
            this.mbz = this.mbz == 0 ? 1 : 0;
            vt(this.mbz == 1);
            gLVideoPreviewView.doi();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.bGc != null && (this.bGc instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bGc).h(this.mCamera);
            releaseCamera();
            this.mbz = this.mbz == 0 ? 1 : 0;
            vt(this.mbz == 1);
            startPreview();
        }
    }

    public boolean doA() {
        return this.mbz == 1;
    }

    private void doB() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doC() {
        if (this.mbx != null && this.mbw != null && this.mbw.getParent() != null) {
            this.mbx.removeView(this.mbw);
        }
    }

    private void di(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.mby.contains("auto")) {
                this.mbA = this.mCamera.getParameters();
                this.mbA.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.mbA);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(9, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends View {
        Bitmap bitmap;
        int left;

        /* renamed from: top  reason: collision with root package name */
        int f1035top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.f1035top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.f1035top, (Paint) null);
            super.onDraw(canvas);
        }
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.bGc instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bGc).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.bGc instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bGc).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.bGc instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bGc).setSticker(stickerItem);
        }
    }

    public void onResume() {
        vt(this.mbz == 1);
        if (this.bGc != null && (this.bGc instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bGc).onResume();
        }
        if (this.bGc != null && (this.bGc instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bGc).onResume();
        }
        if (!com.baidu.tieba.video.record.c.doc()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.mbB.h(this.mCamera);
        if (this.bGc != null && (this.bGc instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bGc).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.mbG = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.mba = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.mbB instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.mbB != null) {
                        h.this.mbB.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.mbB.a(aVar);
        }
    }

    public boolean dom() {
        return this.mCameraId == 0;
    }
}
