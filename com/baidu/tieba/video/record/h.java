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
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    private com.baidu.tieba.j.h iHn;
    private int iKM;
    protected String iWn;
    private Bitmap jbA;
    private a jbB;
    private FrameLayout jbC;
    private List<String> jbD;
    protected boolean jbE;
    private g jbH;
    private SurfaceView jbI;
    protected List<String> jbJ;
    private b jbK;
    private com.baidu.tieba.video.record.b jbL;
    private GLVideoPreviewView.a jbM;
    private c jbN;
    private GLVideoPreviewView.a jbf;
    private RecordVideoActivity jbz;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jbF = 0;
    private Camera.Parameters jbG = null;

    /* loaded from: classes5.dex */
    public interface b {
        void clo();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cw(int i, int i2);
    }

    public void aq(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dr(false);
        aVar.gC(d.j.request_permission_default_title);
        aVar.gD(d.j.request_permission_camera);
        aVar.a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.video.record.h.3
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
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                activity.finish();
            }
        }).b(com.baidu.adp.base.i.aK(activity));
        aVar.aaZ();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iHn = lVar.bEC();
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
                        if (h.this.jbz != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aq(h.this.jbz);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.jbz, d.j.disallow_camera_permission);
                            if (h.this.iHn != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.jbz.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.iHn.aq(1, string);
                            }
                            h.this.jbz.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.jbz != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.jbz, d.j.disallow_audio_record_permission);
                            if (h.this.iHn != null) {
                                h.this.iHn.aq(2, h.this.jbz.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            h.this.jbz.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jbM = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void qI(final boolean z) {
                if (h.this.jbf != null) {
                    com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jbf.qI(z);
                        }
                    });
                }
            }
        };
        this.jbz = recordVideoActivity;
        clm();
        this.jbA = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.iKM = displayMetrics.heightPixels;
        this.jbC = this.jbz.clE();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jbI = gLVideoPreviewView;
            this.jbH = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jbI).setFaceIdentifyStateListener(this.jbM);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jbI = videoPreviewView;
            this.jbH = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.clE() != null) {
            recordVideoActivity.clE().addView(this.jbI, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jbH.e(this.mCamera);
    }

    public void startRecord() {
        this.jbH.f(this.mCamera);
    }

    public void stopRecord() {
        this.jbH.g(this.mCamera);
    }

    public g ckZ() {
        return this.jbH;
    }

    public String cla() {
        if (this.jbJ == null) {
            this.jbJ = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.iUB);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.iUB + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jbJ.add(str);
        return str;
    }

    public void clb() {
        if (this.jbJ != null && this.jbJ.size() != 0) {
            String remove = this.jbJ.remove(this.jbJ.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String clc() {
        File file = new File(com.baidu.tieba.video.c.iUB);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.iWn = com.baidu.tieba.video.c.iUB + "f_" + System.currentTimeMillis() + ".mp4";
        return this.iWn;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jbK != null && motionEvent.getAction() == 0) {
            this.jbK.clo();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cln();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.jbK = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.iKM && x >= com.baidu.adp.lib.util.l.h(this.jbz, d.e.ds60)) {
                    int width = this.jbA.getWidth();
                    int height = this.jbA.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.iKM - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jbC == null) {
                            this.jbC = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jbC.getChildCount()) {
                                if (this.jbB != this.jbC.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jbC.removeViewAt(i);
                                }
                            }
                        }
                        this.jbB = new a(this.jbz, clamp - (width / 2), clamp2 - (height / 2), this.jbA);
                        this.jbC.addView(this.jbB, new ViewGroup.LayoutParams(-2, -2));
                        cv(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cln();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cld() {
        int i;
        int i2;
        if (this.mCamera == null && this.jbz != null) {
            this.jbz.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.jbz.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.jbz.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jbG.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jbH != null) {
                this.jbH.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jbG.setPreviewFormat(17);
        cle();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.jbz, this.mCameraId));
        this.jbD = this.jbG.getSupportedFocusModes();
        if (this.jbD != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jbD.contains("continuous-picture")) {
                this.jbG.setFocusMode("continuous-picture");
            } else if (this.jbD.contains("continuous-video")) {
                this.jbG.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jbG);
        if (this.jbz != null && this.jbz.clE() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jbI.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jbI.setLayoutParams(layoutParams);
            this.jbI.invalidate();
            if (this.jbN != null) {
                this.jbN.cw(layoutParams.width, layoutParams.height);
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
            return com.baidu.adp.lib.util.l.aQ(context);
        }
        return i;
    }

    private void cle() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.jbG.getSupportedPreviewFpsRange()) {
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
        this.jbG.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void qJ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.qF(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.qF(z)) {
                    clh();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.qG(z);
            if (-1 != this.mCameraId) {
                clg();
                this.jbL = new com.baidu.tieba.video.record.b(this.mCamera);
                this.jbE = z;
            } else {
                clh();
            }
        } catch (Exception e) {
            e.printStackTrace();
            clh();
            if (this.iHn != null) {
                this.iHn.aq(8, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b clf() {
        return this.jbL;
    }

    private void clg() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jbG = this.mCamera.getParameters();
            cld();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void clh() {
        if (this.jbz != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbz.getPageContext().getPageActivity());
            aVar.gD(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.jbz != null) {
                        h.this.jbz.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dq(true);
            aVar.b(this.jbz.getPageContext());
            aVar.aaZ();
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
                if (this.iHn != null) {
                    this.iHn.aq(6, com.baidu.tieba.j.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cli() {
        try {
            if (this.mCamera != null) {
                if (this.jbG == null) {
                    this.jbG = this.mCamera.getParameters();
                }
                if ("off".equals(this.jbG.getFlashMode())) {
                    this.jbG.setFlashMode("torch");
                } else {
                    this.jbG.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jbG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iHn != null) {
                this.iHn.aq(7, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public boolean clj() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jbG == null) {
                this.jbG = this.mCamera.getParameters();
            }
            return !"off".equals(this.jbG.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iHn != null) {
                this.iHn.aq(7, com.baidu.tieba.j.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void clk() {
        if (this.jbI != null && (this.jbI instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jbI;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.ckS();
            this.jbF = this.jbF == 0 ? 1 : 0;
            qJ(this.jbF == 1);
            gLVideoPreviewView.ckT();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jbI != null && (this.jbI instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jbI).h(this.mCamera);
            releaseCamera();
            this.jbF = this.jbF == 0 ? 1 : 0;
            qJ(this.jbF == 1);
            startPreview();
        }
    }

    public boolean cll() {
        return this.jbF == 1;
    }

    private void clm() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cln() {
        if (this.jbC != null && this.jbB != null && this.jbB.getParent() != null) {
            this.jbC.removeView(this.jbB);
        }
    }

    private void cv(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jbD.contains("auto")) {
                this.jbG = this.mCamera.getParameters();
                this.jbG.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jbG);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iHn != null) {
                this.iHn.aq(9, com.baidu.tieba.j.a.p(e));
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
        if (this.jbI instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbI).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jbI instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbI).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jbI instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbI).setSticker(stickerItem);
        }
    }

    public void onResume() {
        qJ(this.jbF == 1);
        if (this.jbI != null && (this.jbI instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jbI).onResume();
        }
        if (this.jbI != null && (this.jbI instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jbI).onResume();
        }
        if (!com.baidu.tieba.video.record.c.ckN()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jbH.h(this.mCamera);
        if (this.jbI != null && (this.jbI instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jbI).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jbN = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jbf = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jbH instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jbH != null) {
                        h.this.jbH.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jbH.a(aVar);
        }
    }

    public boolean ckX() {
        return this.mCameraId == 0;
    }
}
