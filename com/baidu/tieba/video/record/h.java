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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    protected boolean adC;
    private RecordVideoActivity jBC;
    private Bitmap jBD;
    private a jBE;
    private int jBF;
    private FrameLayout jBG;
    private List<String> jBH;
    private g jBK;
    private SurfaceView jBL;
    protected List<String> jBM;
    private b jBN;
    private com.baidu.tieba.video.record.b jBO;
    private GLVideoPreviewView.a jBP;
    private c jBQ;
    private GLVideoPreviewView.a jBi;
    private com.baidu.tieba.j.h jhv;
    protected String jws;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jBI = 0;
    private Camera.Parameters jBJ = null;

    /* loaded from: classes5.dex */
    public interface b {
        void cwB();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cI(int i, int i2);
    }

    public void ak(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dR(false);
        aVar.ht(R.string.request_permission_default_title);
        aVar.hu(R.string.request_permission_camera);
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
        aVar.agK();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jhv = lVar.bPk();
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
                        if (h.this.jBC != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ak(h.this.jBC);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.jBC, (int) R.string.disallow_camera_permission);
                            if (h.this.jhv != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.jBC.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.jhv.av(1, string);
                            }
                            h.this.jBC.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.jBC != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.jBC, (int) R.string.disallow_audio_record_permission);
                            if (h.this.jhv != null) {
                                h.this.jhv.av(2, h.this.jBC.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.jBC.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jBP = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void rM(final boolean z) {
                if (h.this.jBi != null) {
                    com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jBi.rM(z);
                        }
                    });
                }
            }
        };
        this.jBC = recordVideoActivity;
        cwz();
        this.jBD = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.jBF = displayMetrics.heightPixels;
        this.jBG = this.jBC.cwR();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jBL = gLVideoPreviewView;
            this.jBK = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jBL).setFaceIdentifyStateListener(this.jBP);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jBL = videoPreviewView;
            this.jBK = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cwR() != null) {
            recordVideoActivity.cwR().addView(this.jBL, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jBK.e(this.mCamera);
    }

    public void startRecord() {
        this.jBK.f(this.mCamera);
    }

    public void stopRecord() {
        this.jBK.g(this.mCamera);
    }

    public g cwm() {
        return this.jBK;
    }

    public String cwn() {
        if (this.jBM == null) {
            this.jBM = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.juG);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.juG + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jBM.add(str);
        return str;
    }

    public void cwo() {
        if (this.jBM != null && this.jBM.size() != 0) {
            String remove = this.jBM.remove(this.jBM.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cwp() {
        File file = new File(com.baidu.tieba.video.c.juG);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.jws = com.baidu.tieba.video.c.juG + "f_" + System.currentTimeMillis() + ".mp4";
        return this.jws;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jBN != null && motionEvent.getAction() == 0) {
            this.jBN.cwB();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cwA();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.jBN = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.jBF && x >= com.baidu.adp.lib.util.l.g(this.jBC, R.dimen.ds60)) {
                    int width = this.jBD.getWidth();
                    int height = this.jBD.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.jBF - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jBG == null) {
                            this.jBG = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jBG.getChildCount()) {
                                if (this.jBE != this.jBG.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jBG.removeViewAt(i);
                                }
                            }
                        }
                        this.jBE = new a(this.jBC, clamp - (width / 2), clamp2 - (height / 2), this.jBD);
                        this.jBG.addView(this.jBE, new ViewGroup.LayoutParams(-2, -2));
                        cH(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cwA();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cwq() {
        int i;
        int i2;
        if (this.mCamera == null && this.jBC != null) {
            this.jBC.finish();
            return;
        }
        int af = com.baidu.adp.lib.util.l.af(this.jBC.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.jBC.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / af)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jBJ.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jBK != null) {
                this.jBK.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jBJ.setPreviewFormat(17);
        cwr();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.jBC, this.mCameraId));
        this.jBH = this.jBJ.getSupportedFocusModes();
        if (this.jBH != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jBH.contains("continuous-picture")) {
                this.jBJ.setFocusMode("continuous-picture");
            } else if (this.jBH.contains("continuous-video")) {
                this.jBJ.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jBJ);
        if (this.jBC != null && this.jBC.cwR() != null) {
            float f = (af * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = af;
                i2 = (int) (af / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jBL.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jBL.setLayoutParams(layoutParams);
            this.jBL.invalidate();
            if (this.jBQ != null) {
                this.jBQ.cI(layoutParams.width, layoutParams.height);
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
            return com.baidu.adp.lib.util.l.ah(context);
        }
        return i;
    }

    private void cwr() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.jBJ.getSupportedPreviewFpsRange()) {
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
        this.jBJ.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void rN(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.rJ(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.rJ(z)) {
                    cwu();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.rK(z);
            if (-1 != this.mCameraId) {
                cwt();
                this.jBO = new com.baidu.tieba.video.record.b(this.mCamera);
                this.adC = z;
            } else {
                cwu();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cwu();
            if (this.jhv != null) {
                this.jhv.av(8, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cws() {
        return this.jBO;
    }

    private void cwt() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jBJ = this.mCamera.getParameters();
            cwq();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cwu() {
        if (this.jBC != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jBC.getPageContext().getPageActivity());
            aVar.hu(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.jBC != null) {
                        h.this.jBC.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dQ(true);
            aVar.b(this.jBC.getPageContext());
            aVar.agK();
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
                if (this.jhv != null) {
                    this.jhv.av(6, com.baidu.tieba.j.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cwv() {
        try {
            if (this.mCamera != null) {
                if (this.jBJ == null) {
                    this.jBJ = this.mCamera.getParameters();
                }
                if ("off".equals(this.jBJ.getFlashMode())) {
                    this.jBJ.setFlashMode("torch");
                } else {
                    this.jBJ.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jBJ);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jhv != null) {
                this.jhv.av(7, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public boolean cww() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jBJ == null) {
                this.jBJ = this.mCamera.getParameters();
            }
            return !"off".equals(this.jBJ.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jhv != null) {
                this.jhv.av(7, com.baidu.tieba.j.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void cwx() {
        if (this.jBL != null && (this.jBL instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jBL;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cwf();
            this.jBI = this.jBI == 0 ? 1 : 0;
            rN(this.jBI == 1);
            gLVideoPreviewView.cwg();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jBL != null && (this.jBL instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jBL).h(this.mCamera);
            releaseCamera();
            this.jBI = this.jBI == 0 ? 1 : 0;
            rN(this.jBI == 1);
            startPreview();
        }
    }

    public boolean cwy() {
        return this.jBI == 1;
    }

    private void cwz() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwA() {
        if (this.jBG != null && this.jBE != null && this.jBE.getParent() != null) {
            this.jBG.removeView(this.jBE);
        }
    }

    private void cH(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jBH.contains("auto")) {
                this.jBJ = this.mCamera.getParameters();
                this.jBJ.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jBJ);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jhv != null) {
                this.jhv.av(9, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
        if (this.jBL instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jBL).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jBL instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jBL).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jBL instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jBL).setSticker(stickerItem);
        }
    }

    public void onResume() {
        rN(this.jBI == 1);
        if (this.jBL != null && (this.jBL instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jBL).onResume();
        }
        if (this.jBL != null && (this.jBL instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jBL).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cwa()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jBK.h(this.mCamera);
        if (this.jBL != null && (this.jBL instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jBL).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jBQ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jBi = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jBK instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jBK != null) {
                        h.this.jBK.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jBK.a(aVar);
        }
    }

    public boolean cwk() {
        return this.mCameraId == 0;
    }
}
