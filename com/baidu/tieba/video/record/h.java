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
    private com.baidu.tieba.j.h iGY;
    private int iKz;
    protected String iWc;
    private GLVideoPreviewView.a jaU;
    private com.baidu.tieba.video.record.b jbA;
    private GLVideoPreviewView.a jbB;
    private c jbC;
    private RecordVideoActivity jbo;
    private Bitmap jbp;
    private a jbq;
    private FrameLayout jbr;
    private List<String> jbs;
    protected boolean jbt;
    private g jbw;
    private SurfaceView jbx;
    protected List<String> jby;
    private b jbz;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jbu = 0;
    private Camera.Parameters jbv = null;

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
            this.iGY = lVar.bEz();
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
                        if (h.this.jbo != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aq(h.this.jbo);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.jbo, d.j.disallow_camera_permission);
                            if (h.this.iGY != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.jbo.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.iGY.as(1, string);
                            }
                            h.this.jbo.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.jbo != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.jbo, d.j.disallow_audio_record_permission);
                            if (h.this.iGY != null) {
                                h.this.iGY.as(2, h.this.jbo.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            h.this.jbo.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jbB = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void qI(final boolean z) {
                if (h.this.jaU != null) {
                    com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jaU.qI(z);
                        }
                    });
                }
            }
        };
        this.jbo = recordVideoActivity;
        clk();
        this.jbp = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.iKz = displayMetrics.heightPixels;
        this.jbr = this.jbo.clC();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jbx = gLVideoPreviewView;
            this.jbw = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jbx).setFaceIdentifyStateListener(this.jbB);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jbx = videoPreviewView;
            this.jbw = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.clC() != null) {
            recordVideoActivity.clC().addView(this.jbx, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jbw.e(this.mCamera);
    }

    public void startRecord() {
        this.jbw.f(this.mCamera);
    }

    public void stopRecord() {
        this.jbw.g(this.mCamera);
    }

    public g ckX() {
        return this.jbw;
    }

    public String ckY() {
        if (this.jby == null) {
            this.jby = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.iUq);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.iUq + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jby.add(str);
        return str;
    }

    public void ckZ() {
        if (this.jby != null && this.jby.size() != 0) {
            String remove = this.jby.remove(this.jby.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cla() {
        File file = new File(com.baidu.tieba.video.c.iUq);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.iWc = com.baidu.tieba.video.c.iUq + "f_" + System.currentTimeMillis() + ".mp4";
        return this.iWc;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jbz != null && motionEvent.getAction() == 0) {
            this.jbz.clm();
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
        this.jbz = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.iKz && x >= com.baidu.adp.lib.util.l.h(this.jbo, d.e.ds60)) {
                    int width = this.jbp.getWidth();
                    int height = this.jbp.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.iKz - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jbr == null) {
                            this.jbr = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jbr.getChildCount()) {
                                if (this.jbq != this.jbr.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jbr.removeViewAt(i);
                                }
                            }
                        }
                        this.jbq = new a(this.jbo, clamp - (width / 2), clamp2 - (height / 2), this.jbp);
                        this.jbr.addView(this.jbq, new ViewGroup.LayoutParams(-2, -2));
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
        if (this.mCamera == null && this.jbo != null) {
            this.jbo.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.jbo.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.jbo.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jbv.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jbw != null) {
                this.jbw.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jbv.setPreviewFormat(17);
        clc();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.jbo, this.mCameraId));
        this.jbs = this.jbv.getSupportedFocusModes();
        if (this.jbs != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jbs.contains("continuous-picture")) {
                this.jbv.setFocusMode("continuous-picture");
            } else if (this.jbs.contains("continuous-video")) {
                this.jbv.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jbv);
        if (this.jbo != null && this.jbo.clC() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jbx.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jbx.setLayoutParams(layoutParams);
            this.jbx.invalidate();
            if (this.jbC != null) {
                this.jbC.cw(layoutParams.width, layoutParams.height);
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
        for (int[] iArr3 : this.jbv.getSupportedPreviewFpsRange()) {
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
        this.jbv.setPreviewFpsRange(iArr2[0], iArr2[1]);
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
                this.jbA = new com.baidu.tieba.video.record.b(this.mCamera);
                this.jbt = z;
            } else {
                clf();
            }
        } catch (Exception e) {
            e.printStackTrace();
            clf();
            if (this.iGY != null) {
                this.iGY.as(8, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cld() {
        return this.jbA;
    }

    private void cle() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jbv = this.mCamera.getParameters();
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
        if (this.jbo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbo.getPageContext().getPageActivity());
            aVar.gC(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.jbo != null) {
                        h.this.jbo.finish();
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
            aVar.b(this.jbo.getPageContext());
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
                if (this.iGY != null) {
                    this.iGY.as(6, com.baidu.tieba.j.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void clg() {
        try {
            if (this.mCamera != null) {
                if (this.jbv == null) {
                    this.jbv = this.mCamera.getParameters();
                }
                if ("off".equals(this.jbv.getFlashMode())) {
                    this.jbv.setFlashMode("torch");
                } else {
                    this.jbv.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jbv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGY != null) {
                this.iGY.as(7, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public boolean clh() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jbv == null) {
                this.jbv = this.mCamera.getParameters();
            }
            return !"off".equals(this.jbv.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGY != null) {
                this.iGY.as(7, com.baidu.tieba.j.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void cli() {
        if (this.jbx != null && (this.jbx instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jbx;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.ckQ();
            this.jbu = this.jbu == 0 ? 1 : 0;
            qJ(this.jbu == 1);
            gLVideoPreviewView.ckR();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jbx != null && (this.jbx instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jbx).h(this.mCamera);
            releaseCamera();
            this.jbu = this.jbu == 0 ? 1 : 0;
            qJ(this.jbu == 1);
            startPreview();
        }
    }

    public boolean clj() {
        return this.jbu == 1;
    }

    private void clk() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cll() {
        if (this.jbr != null && this.jbq != null && this.jbq.getParent() != null) {
            this.jbr.removeView(this.jbq);
        }
    }

    private void cv(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jbs.contains("auto")) {
                this.jbv = this.mCamera.getParameters();
                this.jbv.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jbv);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGY != null) {
                this.iGY.as(9, com.baidu.tieba.j.a.p(e));
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
        if (this.jbx instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbx).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jbx instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbx).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jbx instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jbx).setSticker(stickerItem);
        }
    }

    public void onResume() {
        qJ(this.jbu == 1);
        if (this.jbx != null && (this.jbx instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jbx).onResume();
        }
        if (this.jbx != null && (this.jbx instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jbx).onResume();
        }
        if (!com.baidu.tieba.video.record.c.ckL()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jbw.h(this.mCamera);
        if (this.jbx != null && (this.jbx instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jbx).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jbC = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jaU = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jbw instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jbw != null) {
                        h.this.jbw.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jbw.a(aVar);
        }
    }

    public boolean ckV() {
        return this.mCameraId == 0;
    }
}
