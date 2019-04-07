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
    private com.baidu.tieba.j.h iGX;
    private int iKy;
    protected String iWb;
    private GLVideoPreviewView.a jaT;
    private GLVideoPreviewView.a jbA;
    private c jbB;
    private RecordVideoActivity jbn;
    private Bitmap jbo;
    private a jbp;
    private FrameLayout jbq;
    private List<String> jbr;
    protected boolean jbs;
    private g jbv;
    private SurfaceView jbw;
    protected List<String> jbx;
    private b jby;
    private com.baidu.tieba.video.record.b jbz;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jbt = 0;
    private Camera.Parameters jbu = null;

    /* loaded from: classes5.dex */
    public interface b {
        void clm();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cw(int i, int i2);
    }

    public void aq(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dr(false);
        aVar.gB(d.j.request_permission_default_title);
        aVar.gC(d.j.request_permission_camera);
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
        aVar.aaW();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iGX = lVar.bEz();
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
                        if (h.this.jbn != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aq(h.this.jbn);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.jbn, d.j.disallow_camera_permission);
                            if (h.this.iGX != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.jbn.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.iGX.as(1, string);
                            }
                            h.this.jbn.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.jbn != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.jbn, d.j.disallow_audio_record_permission);
                            if (h.this.iGX != null) {
                                h.this.iGX.as(2, h.this.jbn.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            h.this.jbn.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jbA = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void qI(final boolean z) {
                if (h.this.jaT != null) {
                    com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jaT.qI(z);
                        }
                    });
                }
            }
        };
        this.jbn = recordVideoActivity;
        clk();
        this.jbo = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.iKy = displayMetrics.heightPixels;
        this.jbq = this.jbn.clC();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jbw = gLVideoPreviewView;
            this.jbv = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jbw).setFaceIdentifyStateListener(this.jbA);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jbw = videoPreviewView;
            this.jbv = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.clC() != null) {
            recordVideoActivity.clC().addView(this.jbw, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jbv.e(this.mCamera);
    }

    public void startRecord() {
        this.jbv.f(this.mCamera);
    }

    public void stopRecord() {
        this.jbv.g(this.mCamera);
    }

    public g ckX() {
        return this.jbv;
    }

    public String ckY() {
        if (this.jbx == null) {
            this.jbx = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.iUp);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.iUp + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jbx.add(str);
        return str;
    }

    public void ckZ() {
        if (this.jbx != null && this.jbx.size() != 0) {
            String remove = this.jbx.remove(this.jbx.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cla() {
        File file = new File(com.baidu.tieba.video.c.iUp);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.iWb = com.baidu.tieba.video.c.iUp + "f_" + System.currentTimeMillis() + ".mp4";
        return this.iWb;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jby != null && motionEvent.getAction() == 0) {
            this.jby.clm();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cll();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.jby = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.iKy && x >= com.baidu.adp.lib.util.l.h(this.jbn, d.e.ds60)) {
                    int width = this.jbo.getWidth();
                    int height = this.jbo.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.iKy - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jbq == null) {
                            this.jbq = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jbq.getChildCount()) {
                                if (this.jbp != this.jbq.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jbq.removeViewAt(i);
                                }
                            }
                        }
                        this.jbp = new a(this.jbn, clamp - (width / 2), clamp2 - (height / 2), this.jbo);
                        this.jbq.addView(this.jbp, new ViewGroup.LayoutParams(-2, -2));
                        cv(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cll();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void clb() {
        int i;
        int i2;
        if (this.mCamera == null && this.jbn != null) {
            this.jbn.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.jbn.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.jbn.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jbu.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jbv != null) {
                this.jbv.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jbu.setPreviewFormat(17);
        clc();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.jbn, this.mCameraId));
        this.jbr = this.jbu.getSupportedFocusModes();
        if (this.jbr != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jbr.contains("continuous-picture")) {
                this.jbu.setFocusMode("continuous-picture");
            } else if (this.jbr.contains("continuous-video")) {
                this.jbu.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jbu);
        if (this.jbn != null && this.jbn.clC() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jbw.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jbw.setLayoutParams(layoutParams);
            this.jbw.invalidate();
            if (this.jbB != null) {
                this.jbB.cw(layoutParams.width, layoutParams.height);
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

    private void clc() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.jbu.getSupportedPreviewFpsRange()) {
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
        this.jbu.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void qJ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.qF(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.qF(z)) {
                    clf();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.qG(z);
            if (-1 != this.mCameraId) {
                cle();
                this.jbz = new com.baidu.tieba.video.record.b(this.mCamera);
                this.jbs = z;
            } else {
                clf();
            }
        } catch (Exception e) {
            e.printStackTrace();
            clf();
            if (this.iGX != null) {
                this.iGX.as(8, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cld() {
        return this.jbz;
    }

    private void cle() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jbu = this.mCamera.getParameters();
            clb();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void clf() {
        if (this.jbn != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbn.getPageContext().getPageActivity());
            aVar.gC(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.jbn != null) {
                        h.this.jbn.finish();
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
            aVar.b(this.jbn.getPageContext());
            aVar.aaW();
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
                if (this.iGX != null) {
                    this.iGX.as(6, com.baidu.tieba.j.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void clg() {
        try {
            if (this.mCamera != null) {
                if (this.jbu == null) {
                    this.jbu = this.mCamera.getParameters();
                }
                if ("off".equals(this.jbu.getFlashMode())) {
                    this.jbu.setFlashMode("torch");
                } else {
                    this.jbu.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jbu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGX != null) {
                this.iGX.as(7, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public boolean clh() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jbu == null) {
                this.jbu = this.mCamera.getParameters();
            }
            return !"off".equals(this.jbu.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGX != null) {
                this.iGX.as(7, com.baidu.tieba.j.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void cli() {
        if (this.jbw != null && (this.jbw instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jbw;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.ckQ();
            this.jbt = this.jbt == 0 ? 1 : 0;
            qJ(this.jbt == 1);
            gLVideoPreviewView.ckR();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jbw != null && (this.jbw instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jbw).h(this.mCamera);
            releaseCamera();
            this.jbt = this.jbt == 0 ? 1 : 0;
            qJ(this.jbt == 1);
            startPreview();
        }
    }

    public boolean clj() {
        return this.jbt == 1;
    }

    private void clk() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cll() {
        if (this.jbq != null && this.jbp != null && this.jbp.getParent() != null) {
            this.jbq.removeView(this.jbp);
        }
    }

    private void cv(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jbr.contains("auto")) {
                this.jbu = this.mCamera.getParameters();
                this.jbu.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jbu);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGX != null) {
                this.iGX.as(9, com.baidu.tieba.j.a.p(e));
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
        if (this.jbw instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbw).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jbw instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbw).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jbw instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbw).setSticker(stickerItem);
        }
    }

    public void onResume() {
        qJ(this.jbt == 1);
        if (this.jbw != null && (this.jbw instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jbw).onResume();
        }
        if (this.jbw != null && (this.jbw instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jbw).onResume();
        }
        if (!com.baidu.tieba.video.record.c.ckL()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jbv.h(this.mCamera);
        if (this.jbw != null && (this.jbw instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jbw).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jbB = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jaT = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jbv instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jbv != null) {
                        h.this.jbv.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jbv.a(aVar);
        }
    }

    public boolean ckV() {
        return this.mCameraId == 0;
    }
}
