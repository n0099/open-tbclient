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
    private List<String> jAA;
    private g jAD;
    private SurfaceView jAE;
    protected List<String> jAF;
    private b jAG;
    private com.baidu.tieba.video.record.b jAH;
    private GLVideoPreviewView.a jAI;
    private c jAJ;
    private GLVideoPreviewView.a jAb;
    private RecordVideoActivity jAv;
    private Bitmap jAw;
    private a jAx;
    private int jAy;
    private FrameLayout jAz;
    private com.baidu.tieba.j.h jgo;
    protected String jvl;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jAB = 0;
    private Camera.Parameters jAC = null;

    /* loaded from: classes5.dex */
    public interface b {
        void cwf();
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
        aVar.agI();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jgo = lVar.bOW();
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
                        if (h.this.jAv != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ak(h.this.jAv);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.jAv, (int) R.string.disallow_camera_permission);
                            if (h.this.jgo != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.jAv.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.jgo.av(1, string);
                            }
                            h.this.jAv.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.jAv != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.jAv, (int) R.string.disallow_audio_record_permission);
                            if (h.this.jgo != null) {
                                h.this.jgo.av(2, h.this.jAv.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.jAv.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jAI = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void rL(final boolean z) {
                if (h.this.jAb != null) {
                    com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jAb.rL(z);
                        }
                    });
                }
            }
        };
        this.jAv = recordVideoActivity;
        cwd();
        this.jAw = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.jAy = displayMetrics.heightPixels;
        this.jAz = this.jAv.cwv();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jAE = gLVideoPreviewView;
            this.jAD = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jAE).setFaceIdentifyStateListener(this.jAI);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jAE = videoPreviewView;
            this.jAD = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cwv() != null) {
            recordVideoActivity.cwv().addView(this.jAE, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jAD.e(this.mCamera);
    }

    public void startRecord() {
        this.jAD.f(this.mCamera);
    }

    public void stopRecord() {
        this.jAD.g(this.mCamera);
    }

    public g cvQ() {
        return this.jAD;
    }

    public String cvR() {
        if (this.jAF == null) {
            this.jAF = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.jtz);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.jtz + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jAF.add(str);
        return str;
    }

    public void cvS() {
        if (this.jAF != null && this.jAF.size() != 0) {
            String remove = this.jAF.remove(this.jAF.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cvT() {
        File file = new File(com.baidu.tieba.video.c.jtz);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.jvl = com.baidu.tieba.video.c.jtz + "f_" + System.currentTimeMillis() + ".mp4";
        return this.jvl;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jAG != null && motionEvent.getAction() == 0) {
            this.jAG.cwf();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cwe();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.jAG = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.jAy && x >= com.baidu.adp.lib.util.l.g(this.jAv, R.dimen.ds60)) {
                    int width = this.jAw.getWidth();
                    int height = this.jAw.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.jAy - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jAz == null) {
                            this.jAz = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jAz.getChildCount()) {
                                if (this.jAx != this.jAz.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jAz.removeViewAt(i);
                                }
                            }
                        }
                        this.jAx = new a(this.jAv, clamp - (width / 2), clamp2 - (height / 2), this.jAw);
                        this.jAz.addView(this.jAx, new ViewGroup.LayoutParams(-2, -2));
                        cH(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cwe();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cvU() {
        int i;
        int i2;
        if (this.mCamera == null && this.jAv != null) {
            this.jAv.finish();
            return;
        }
        int af = com.baidu.adp.lib.util.l.af(this.jAv.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.jAv.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / af)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jAC.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jAD != null) {
                this.jAD.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jAC.setPreviewFormat(17);
        cvV();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.jAv, this.mCameraId));
        this.jAA = this.jAC.getSupportedFocusModes();
        if (this.jAA != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jAA.contains("continuous-picture")) {
                this.jAC.setFocusMode("continuous-picture");
            } else if (this.jAA.contains("continuous-video")) {
                this.jAC.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jAC);
        if (this.jAv != null && this.jAv.cwv() != null) {
            float f = (af * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = af;
                i2 = (int) (af / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jAE.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jAE.setLayoutParams(layoutParams);
            this.jAE.invalidate();
            if (this.jAJ != null) {
                this.jAJ.cI(layoutParams.width, layoutParams.height);
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

    private void cvV() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.jAC.getSupportedPreviewFpsRange()) {
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
        this.jAC.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void rM(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.rI(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.rI(z)) {
                    cvY();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.rJ(z);
            if (-1 != this.mCameraId) {
                cvX();
                this.jAH = new com.baidu.tieba.video.record.b(this.mCamera);
                this.adC = z;
            } else {
                cvY();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cvY();
            if (this.jgo != null) {
                this.jgo.av(8, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cvW() {
        return this.jAH;
    }

    private void cvX() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jAC = this.mCamera.getParameters();
            cvU();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cvY() {
        if (this.jAv != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jAv.getPageContext().getPageActivity());
            aVar.hu(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.jAv != null) {
                        h.this.jAv.finish();
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
            aVar.b(this.jAv.getPageContext());
            aVar.agI();
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
                if (this.jgo != null) {
                    this.jgo.av(6, com.baidu.tieba.j.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cvZ() {
        try {
            if (this.mCamera != null) {
                if (this.jAC == null) {
                    this.jAC = this.mCamera.getParameters();
                }
                if ("off".equals(this.jAC.getFlashMode())) {
                    this.jAC.setFlashMode("torch");
                } else {
                    this.jAC.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jAC);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jgo != null) {
                this.jgo.av(7, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public boolean cwa() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jAC == null) {
                this.jAC = this.mCamera.getParameters();
            }
            return !"off".equals(this.jAC.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jgo != null) {
                this.jgo.av(7, com.baidu.tieba.j.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void cwb() {
        if (this.jAE != null && (this.jAE instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jAE;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cvJ();
            this.jAB = this.jAB == 0 ? 1 : 0;
            rM(this.jAB == 1);
            gLVideoPreviewView.cvK();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jAE != null && (this.jAE instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jAE).h(this.mCamera);
            releaseCamera();
            this.jAB = this.jAB == 0 ? 1 : 0;
            rM(this.jAB == 1);
            startPreview();
        }
    }

    public boolean cwc() {
        return this.jAB == 1;
    }

    private void cwd() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
        if (this.jAz != null && this.jAx != null && this.jAx.getParent() != null) {
            this.jAz.removeView(this.jAx);
        }
    }

    private void cH(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jAA.contains("auto")) {
                this.jAC = this.mCamera.getParameters();
                this.jAC.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jAC);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jgo != null) {
                this.jgo.av(9, com.baidu.tieba.j.a.p(e));
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
        if (this.jAE instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jAE).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jAE instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jAE).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jAE instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jAE).setSticker(stickerItem);
        }
    }

    public void onResume() {
        rM(this.jAB == 1);
        if (this.jAE != null && (this.jAE instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jAE).onResume();
        }
        if (this.jAE != null && (this.jAE instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jAE).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cvE()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jAD.h(this.mCamera);
        if (this.jAE != null && (this.jAE instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jAE).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jAJ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jAb = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jAD instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jAD != null) {
                        h.this.jAD.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jAD.a(aVar);
        }
    }

    public boolean cvO() {
        return this.mCameraId == 0;
    }
}
