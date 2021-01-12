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
    private SurfaceView cqi;
    private int dTc;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    protected String nEI;
    private RecordVideoActivity nGF;
    private Bitmap nGG;
    private a nGH;
    private FrameLayout nGI;
    private List<String> nGJ;
    private g nGM;
    protected List<String> nGN;
    private b nGO;
    private com.baidu.tieba.video.record.b nGP;
    private GLVideoPreviewView.a nGQ;
    private c nGR;
    private GLVideoPreviewView.a nGl;
    private com.baidu.tieba.l.g noh;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nGK = 0;
    private Camera.Parameters nGL = null;

    /* loaded from: classes7.dex */
    public interface b {
        void dRQ();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void dC(int i, int i2);
    }

    public void aq(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jE(false);
        aVar.nt(R.string.request_permission_default_title);
        aVar.nu(R.string.request_permission_camera);
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
        aVar.bqe();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.noh = kVar.deY();
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
                        if (h.this.nGF != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aq(h.this.nGF);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nGF, R.string.disallow_camera_permission);
                            if (h.this.noh != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nGF.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.noh.bE(1, string);
                            }
                            h.this.nGF.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nGF != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nGF, R.string.disallow_audio_record_permission);
                            if (h.this.noh != null) {
                                h.this.noh.bE(2, h.this.nGF.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nGF.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nGQ = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void yL(final boolean z) {
                if (h.this.nGl != null) {
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nGl.yL(z);
                        }
                    });
                }
            }
        };
        this.nGF = recordVideoActivity;
        dRO();
        this.nGG = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dTc = displayMetrics.heightPixels;
        this.nGI = this.nGF.dSh();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.cqi = gLVideoPreviewView;
            this.nGM = gLVideoPreviewView;
            ((GLVideoPreviewView) this.cqi).setFaceIdentifyStateListener(this.nGQ);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.cqi = videoPreviewView;
            this.nGM = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dSh() != null) {
            recordVideoActivity.dSh().addView(this.cqi, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nGM.e(this.mCamera);
    }

    public void startRecord() {
        this.nGM.f(this.mCamera);
    }

    public void stopRecord() {
        this.nGM.g(this.mCamera);
    }

    public g dRB() {
        return this.nGM;
    }

    public String dRC() {
        if (this.nGN == null) {
            this.nGN = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nAB);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nAB + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nGN.add(str);
        return str;
    }

    public void dRD() {
        if (this.nGN != null && this.nGN.size() != 0) {
            String remove = this.nGN.remove(this.nGN.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dRE() {
        File file = new File(com.baidu.tieba.video.c.nAB);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nEI = com.baidu.tieba.video.c.nAB + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nEI;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nGO != null && motionEvent.getAction() == 0) {
            this.nGO.dRQ();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dRP();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nGO = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dTc && x >= com.baidu.adp.lib.util.l.getDimens(this.nGF, R.dimen.ds60)) {
                    int width = this.nGG.getWidth();
                    int height = this.nGG.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dTc - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nGI == null) {
                            this.nGI = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nGI.getChildCount()) {
                                if (this.nGH != this.nGI.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nGI.removeViewAt(i);
                                }
                            }
                        }
                        this.nGH = new a(this.nGF, clamp - (width / 2), clamp2 - (height / 2), this.nGG);
                        this.nGI.addView(this.nGH, new ViewGroup.LayoutParams(-2, -2));
                        dB(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dRP();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dRF() {
        int i;
        if (this.mCamera == null && this.nGF != null) {
            this.nGF.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nGF.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nGF.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.nGL.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.nGM != null) {
                this.nGM.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.nGL.setPreviewFormat(17);
        dRG();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nGF, this.mCameraId));
        this.nGJ = this.nGL.getSupportedFocusModes();
        if (this.nGJ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nGJ.contains("continuous-picture")) {
                this.nGL.setFocusMode("continuous-picture");
            } else if (this.nGJ.contains("continuous-video")) {
                this.nGL.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nGL);
        if (this.nGF != null && this.nGF.dSh() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = (int) (equipmentWidth / f2);
            } else {
                equipmentWidth = (int) (screenHeight * f2);
                i = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cqi.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = i;
            this.cqi.setLayoutParams(layoutParams);
            this.cqi.invalidate();
            if (this.nGR != null) {
                this.nGR.dC(layoutParams.width, layoutParams.height);
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

    private void dRG() {
        int[] iArr = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : this.nGL.getSupportedPreviewFpsRange()) {
            if (Math.abs(20000 - iArr2[1]) > i2 || Math.abs(15000 - iArr2[0]) > i) {
                iArr2 = iArr;
            } else {
                i2 = Math.abs(20000 - iArr2[1]);
                i = Math.abs(15000 - iArr2[0]);
            }
            iArr = iArr2;
        }
        this.nGL.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public void yM(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.yI(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.yI(z)) {
                    dRJ();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.yJ(z);
            if (-1 != this.mCameraId) {
                dRI();
                this.nGP = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dRJ();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dRJ();
            if (this.noh != null) {
                this.noh.bE(8, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dRH() {
        return this.nGP;
    }

    private void dRI() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nGL = this.mCamera.getParameters();
            dRF();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dRJ() {
        if (this.nGF != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nGF.getPageContext().getPageActivity());
            aVar.nu(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nGF != null) {
                        h.this.nGF.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.jD(true);
            aVar.b(this.nGF.getPageContext());
            aVar.bqe();
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
                if (this.noh != null) {
                    this.noh.bE(6, com.baidu.tieba.l.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dRK() {
        try {
            if (this.mCamera != null) {
                if (this.nGL == null) {
                    this.nGL = this.mCamera.getParameters();
                }
                if ("off".equals(this.nGL.getFlashMode())) {
                    this.nGL.setFlashMode("torch");
                } else {
                    this.nGL.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nGL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.noh != null) {
                this.noh.bE(7, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    public boolean dRL() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nGL == null) {
                this.nGL = this.mCamera.getParameters();
            }
            return !"off".equals(this.nGL.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.noh != null) {
                this.noh.bE(7, com.baidu.tieba.l.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void dRM() {
        if (this.cqi != null && (this.cqi instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.cqi;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dRu();
            this.nGK = this.nGK == 0 ? 1 : 0;
            yM(this.nGK == 1);
            gLVideoPreviewView.dRv();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.cqi != null && (this.cqi instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cqi).h(this.mCamera);
            releaseCamera();
            this.nGK = this.nGK == 0 ? 1 : 0;
            yM(this.nGK == 1);
            startPreview();
        }
    }

    public boolean dRN() {
        return this.nGK == 1;
    }

    private void dRO() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRP() {
        if (this.nGI != null && this.nGH != null && this.nGH.getParent() != null) {
            this.nGI.removeView(this.nGH);
        }
    }

    private void dB(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nGJ.contains("auto")) {
                this.nGL = this.mCamera.getParameters();
                this.nGL.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nGL);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.noh != null) {
                this.noh.bE(9, com.baidu.tieba.l.a.p(e));
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
        if (this.cqi instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cqi).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.cqi instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cqi).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.cqi instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cqi).setSticker(stickerItem);
        }
    }

    public void onResume() {
        yM(this.nGK == 1);
        if (this.cqi != null && (this.cqi instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cqi).onResume();
        }
        if (this.cqi != null && (this.cqi instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cqi).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dRp()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nGM.h(this.mCamera);
        if (this.cqi != null && (this.cqi instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cqi).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nGR = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nGl = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nGM instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nGM != null) {
                        h.this.nGM.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nGM.a(aVar);
        }
    }

    public boolean dRz() {
        return this.mCameraId == 0;
    }
}
