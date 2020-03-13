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
    private int cdw;
    private RecordVideoActivity kBC;
    private Bitmap kBD;
    private a kBE;
    private FrameLayout kBF;
    private List<String> kBG;
    private g kBJ;
    private SurfaceView kBK;
    protected List<String> kBL;
    private b kBM;
    private com.baidu.tieba.video.record.b kBN;
    private GLVideoPreviewView.a kBO;
    private c kBP;
    private GLVideoPreviewView.a kBk;
    private com.baidu.tieba.k.h khZ;
    protected String kwD;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int kBH = 0;
    private Camera.Parameters kBI = null;

    /* loaded from: classes10.dex */
    public interface b {
        void cRw();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void cS(int i, int i2);
    }

    public void al(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fH(false);
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
        aVar.aEC();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.khZ = lVar.cgZ();
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
                        if (h.this.kBC != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.al(h.this.kBC);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.kBC, (int) R.string.disallow_camera_permission);
                            if (h.this.khZ != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.kBC.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.khZ.aP(1, string);
                            }
                            h.this.kBC.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.kBC != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.kBC, (int) R.string.disallow_audio_record_permission);
                            if (h.this.khZ != null) {
                                h.this.khZ.aP(2, h.this.kBC.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.kBC.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kBO = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void tu(final boolean z) {
                if (h.this.kBk != null) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.kBk.tu(z);
                        }
                    });
                }
            }
        };
        this.kBC = recordVideoActivity;
        cRu();
        this.kBD = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cdw = displayMetrics.heightPixels;
        this.kBF = this.kBC.cRL();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.kBK = gLVideoPreviewView;
            this.kBJ = gLVideoPreviewView;
            ((GLVideoPreviewView) this.kBK).setFaceIdentifyStateListener(this.kBO);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.kBK = videoPreviewView;
            this.kBJ = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cRL() != null) {
            recordVideoActivity.cRL().addView(this.kBK, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.kBJ.e(this.mCamera);
    }

    public void startRecord() {
        this.kBJ.f(this.mCamera);
    }

    public void stopRecord() {
        this.kBJ.g(this.mCamera);
    }

    public g cRi() {
        return this.kBJ;
    }

    public String cRj() {
        if (this.kBL == null) {
            this.kBL = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.kuZ);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.kuZ + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.kBL.add(str);
        return str;
    }

    public void cRk() {
        if (this.kBL != null && this.kBL.size() != 0) {
            String remove = this.kBL.remove(this.kBL.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cRl() {
        File file = new File(com.baidu.tieba.video.c.kuZ);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.kwD = com.baidu.tieba.video.c.kuZ + "f_" + System.currentTimeMillis() + ".mp4";
        return this.kwD;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.kBM != null && motionEvent.getAction() == 0) {
            this.kBM.cRw();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cRv();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.kBM = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cdw && x >= com.baidu.adp.lib.util.l.getDimens(this.kBC, R.dimen.ds60)) {
                    int width = this.kBD.getWidth();
                    int height = this.kBD.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cdw - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.kBF == null) {
                            this.kBF = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.kBF.getChildCount()) {
                                if (this.kBE != this.kBF.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.kBF.removeViewAt(i);
                                }
                            }
                        }
                        this.kBE = new a(this.kBC, clamp - (width / 2), clamp2 - (height / 2), this.kBD);
                        this.kBF.addView(this.kBE, new ViewGroup.LayoutParams(-2, -2));
                        cR(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cRv();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cRm() {
        int i;
        int i2;
        if (this.mCamera == null && this.kBC != null) {
            this.kBC.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kBC.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.kBC.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.kBI.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.kBJ != null) {
                this.kBJ.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.kBI.setPreviewFormat(17);
        cRn();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.k(this.kBC, this.mCameraId));
        this.kBG = this.kBI.getSupportedFocusModes();
        if (this.kBG != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.kBG.contains("continuous-picture")) {
                this.kBI.setFocusMode("continuous-picture");
            } else if (this.kBG.contains("continuous-video")) {
                this.kBI.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.kBI);
        if (this.kBC != null && this.kBC.cRL() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kBK.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.kBK.setLayoutParams(layoutParams);
            this.kBK.invalidate();
            if (this.kBP != null) {
                this.kBP.cS(layoutParams.width, layoutParams.height);
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

    private void cRn() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.kBI.getSupportedPreviewFpsRange()) {
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
        this.kBI.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void tv(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.tr(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.tr(z)) {
                    cRq();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.ts(z);
            if (-1 != this.mCameraId) {
                cRp();
                this.kBN = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                cRq();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cRq();
            if (this.khZ != null) {
                this.khZ.aP(8, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cRo() {
        return this.kBN;
    }

    private void cRp() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.kBI = this.mCamera.getParameters();
            cRm();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.q(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cRq() {
        if (this.kBC != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kBC.getPageContext().getPageActivity());
            aVar.jW(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.kBC != null) {
                        h.this.kBC.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fG(true);
            aVar.b(this.kBC.getPageContext());
            aVar.aEC();
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
                if (this.khZ != null) {
                    this.khZ.aP(6, com.baidu.tieba.k.a.q(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cRr() {
        try {
            if (this.mCamera != null) {
                if (this.kBI == null) {
                    this.kBI = this.mCamera.getParameters();
                }
                if ("off".equals(this.kBI.getFlashMode())) {
                    this.kBI.setFlashMode("torch");
                } else {
                    this.kBI.setFlashMode("off");
                }
                this.mCamera.setParameters(this.kBI);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.khZ != null) {
                this.khZ.aP(7, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    public boolean cRs() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.kBI == null) {
                this.kBI = this.mCamera.getParameters();
            }
            return !"off".equals(this.kBI.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.khZ != null) {
                this.khZ.aP(7, com.baidu.tieba.k.a.q(e));
                return false;
            }
            return false;
        }
    }

    public void cRt() {
        if (this.kBK != null && (this.kBK instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.kBK;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cRc();
            this.kBH = this.kBH == 0 ? 1 : 0;
            tv(this.kBH == 1);
            gLVideoPreviewView.cRd();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.kBK != null && (this.kBK instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kBK).h(this.mCamera);
            releaseCamera();
            this.kBH = this.kBH == 0 ? 1 : 0;
            tv(this.kBH == 1);
            startPreview();
        }
    }

    public boolean getIsFrontCamera() {
        return this.kBH == 1;
    }

    private void cRu() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRv() {
        if (this.kBF != null && this.kBE != null && this.kBE.getParent() != null) {
            this.kBF.removeView(this.kBE);
        }
    }

    private void cR(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.kBG.contains("auto")) {
                this.kBI = this.mCamera.getParameters();
                this.kBI.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.kBI);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.khZ != null) {
                this.khZ.aP(9, com.baidu.tieba.k.a.q(e));
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
        if (this.kBK instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kBK).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.kBK instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kBK).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.kBK instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kBK).setSticker(stickerItem);
        }
    }

    public void onResume() {
        tv(this.kBH == 1);
        if (this.kBK != null && (this.kBK instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kBK).onResume();
        }
        if (this.kBK != null && (this.kBK instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kBK).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cQX()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.kBJ.h(this.mCamera);
        if (this.kBK != null && (this.kBK instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kBK).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.kBP = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.kBk = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.kBJ instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.kBJ != null) {
                        h.this.kBJ.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.kBJ.a(aVar);
        }
    }

    public boolean getCameraIsBack() {
        return this.mCameraId == 0;
    }
}
