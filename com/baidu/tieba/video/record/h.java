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
    protected String lYK;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private FrameLayout mbA;
    private List<String> mbB;
    private g mbE;
    protected List<String> mbF;
    private b mbG;
    private com.baidu.tieba.video.record.b mbH;
    private GLVideoPreviewView.a mbI;
    private c mbJ;
    private GLVideoPreviewView.a mbd;
    private RecordVideoActivity mbx;
    private Bitmap mby;
    private a mbz;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int mbC = 0;
    private Camera.Parameters mbD = null;

    /* loaded from: classes10.dex */
    public interface b {
        void doH();
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
            this.lHf = lVar.cCQ();
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
                        if (h.this.mbx != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ah(h.this.mbx);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.mbx, (int) R.string.disallow_camera_permission);
                            if (h.this.lHf != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.mbx.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.lHf.bn(1, string);
                            }
                            h.this.mbx.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.mbx != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.mbx, (int) R.string.disallow_audio_record_permission);
                            if (h.this.lHf != null) {
                                h.this.lHf.bn(2, h.this.mbx.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.mbx.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.mbI = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void vs(final boolean z) {
                if (h.this.mbd != null) {
                    com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.mbd.vs(z);
                        }
                    });
                }
            }
        };
        this.mbx = recordVideoActivity;
        doF();
        this.mby = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cTi = displayMetrics.heightPixels;
        this.mbA = this.mbx.doX();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.bGc = gLVideoPreviewView;
            this.mbE = gLVideoPreviewView;
            ((GLVideoPreviewView) this.bGc).setFaceIdentifyStateListener(this.mbI);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.bGc = videoPreviewView;
            this.mbE = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.doX() != null) {
            recordVideoActivity.doX().addView(this.bGc, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.mbE.e(this.mCamera);
    }

    public void startRecord() {
        this.mbE.f(this.mCamera);
    }

    public void stopRecord() {
        this.mbE.g(this.mCamera);
    }

    public g dos() {
        return this.mbE;
    }

    public String dot() {
        if (this.mbF == null) {
            this.mbF = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.d.lUx);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.d.lUx + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.mbF.add(str);
        return str;
    }

    public void dou() {
        if (this.mbF != null && this.mbF.size() != 0) {
            String remove = this.mbF.remove(this.mbF.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dov() {
        File file = new File(com.baidu.tieba.video.d.lUx);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.lYK = com.baidu.tieba.video.d.lUx + "f_" + System.currentTimeMillis() + ".mp4";
        return this.lYK;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.mbG != null && motionEvent.getAction() == 0) {
            this.mbG.doH();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.doG();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.mbG = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cTi && x >= com.baidu.adp.lib.util.l.getDimens(this.mbx, R.dimen.ds60)) {
                    int width = this.mby.getWidth();
                    int height = this.mby.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cTi - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.mbA == null) {
                            this.mbA = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.mbA.getChildCount()) {
                                if (this.mbz != this.mbA.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.mbA.removeViewAt(i);
                                }
                            }
                        }
                        this.mbz = new a(this.mbx, clamp - (width / 2), clamp2 - (height / 2), this.mby);
                        this.mbA.addView(this.mbz, new ViewGroup.LayoutParams(-2, -2));
                        di(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.doG();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dow() {
        int i;
        int i2;
        if (this.mCamera == null && this.mbx != null) {
            this.mbx.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mbx.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.mbx.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.mbD.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.mbE != null) {
                this.mbE.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.mbD.setPreviewFormat(17);
        dox();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.mbx, this.mCameraId));
        this.mbB = this.mbD.getSupportedFocusModes();
        if (this.mbB != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.mbB.contains("continuous-picture")) {
                this.mbD.setFocusMode("continuous-picture");
            } else if (this.mbB.contains("continuous-video")) {
                this.mbD.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.mbD);
        if (this.mbx != null && this.mbx.doX() != null) {
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
            if (this.mbJ != null) {
                this.mbJ.dj(layoutParams.width, layoutParams.height);
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

    private void dox() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.mbD.getSupportedPreviewFpsRange()) {
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
        this.mbD.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void vt(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.vp(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.vp(z)) {
                    doA();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.vq(z);
            if (-1 != this.mCameraId) {
                doz();
                this.mbH = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                doA();
            }
        } catch (Exception e) {
            e.printStackTrace();
            doA();
            if (this.lHf != null) {
                this.lHf.bn(8, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b doy() {
        return this.mbH;
    }

    private void doz() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.mbD = this.mCamera.getParameters();
            dow();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.t(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void doA() {
        if (this.mbx != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mbx.getPageContext().getPageActivity());
            aVar.kT(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.mbx != null) {
                        h.this.mbx.finish();
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
            aVar.b(this.mbx.getPageContext());
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

    public void doB() {
        try {
            if (this.mCamera != null) {
                if (this.mbD == null) {
                    this.mbD = this.mCamera.getParameters();
                }
                if ("off".equals(this.mbD.getFlashMode())) {
                    this.mbD.setFlashMode("torch");
                } else {
                    this.mbD.setFlashMode("off");
                }
                this.mCamera.setParameters(this.mbD);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(7, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    public boolean doC() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.mbD == null) {
                this.mbD = this.mCamera.getParameters();
            }
            return !"off".equals(this.mbD.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(7, com.baidu.tieba.k.a.t(e));
                return false;
            }
            return false;
        }
    }

    public void doD() {
        if (this.bGc != null && (this.bGc instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.bGc;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dol();
            this.mbC = this.mbC == 0 ? 1 : 0;
            vt(this.mbC == 1);
            gLVideoPreviewView.dom();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.bGc != null && (this.bGc instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bGc).h(this.mCamera);
            releaseCamera();
            this.mbC = this.mbC == 0 ? 1 : 0;
            vt(this.mbC == 1);
            startPreview();
        }
    }

    public boolean doE() {
        return this.mbC == 1;
    }

    private void doF() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doG() {
        if (this.mbA != null && this.mbz != null && this.mbz.getParent() != null) {
            this.mbA.removeView(this.mbz);
        }
    }

    private void di(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.mbB.contains("auto")) {
                this.mbD = this.mCamera.getParameters();
                this.mbD.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.mbD);
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
        int f1036top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.f1036top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.f1036top, (Paint) null);
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
        vt(this.mbC == 1);
        if (this.bGc != null && (this.bGc instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bGc).onResume();
        }
        if (this.bGc != null && (this.bGc instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bGc).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dog()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.mbE.h(this.mCamera);
        if (this.bGc != null && (this.bGc instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bGc).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.mbJ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.mbd = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.mbE instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.mbE != null) {
                        h.this.mbE.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.mbE.a(aVar);
        }
    }

    public boolean doq() {
        return this.mCameraId == 0;
    }
}
