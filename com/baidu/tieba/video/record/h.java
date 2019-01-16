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
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    private int dCR;
    private int dCS;
    protected String hFL;
    private GLVideoPreviewView.a hKG;
    private RecordVideoActivity hLc;
    private Bitmap hLd;
    private a hLe;
    private FrameLayout hLf;
    private List<String> hLg;
    protected boolean hLh;
    private g hLk;
    private SurfaceView hLl;
    protected List<String> hLm;
    private b hLn;
    private com.baidu.tieba.video.record.b hLo;
    private GLVideoPreviewView.a hLp;
    private c hLq;
    private com.baidu.tieba.j.h hqL;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenHeight;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hLi = 0;
    private Camera.Parameters hLj = null;

    /* loaded from: classes5.dex */
    public interface b {
        void bLN();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void bZ(int i, int i2);
    }

    public void R(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.bh(false);
        aVar.da(e.j.request_permission_default_title);
        aVar.db(e.j.request_permission_camera);
        aVar.a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.video.record.h.3
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
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                activity.finish();
            }
        }).b(com.baidu.adp.base.i.aK(activity));
        aVar.BS();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hqL = lVar.bdZ();
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
                        if (h.this.hLc != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.R(h.this.hLc);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.hLc, e.j.disallow_camera_permission);
                            if (h.this.hqL != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hLc.getResources().getString(e.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.hqL.aa(1, string);
                            }
                            h.this.hLc.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hLc != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hLc, e.j.disallow_audio_record_permission);
                            if (h.this.hqL != null) {
                                h.this.hqL.aa(2, h.this.hLc.getResources().getString(e.j.disallow_audio_record_permission));
                            }
                            h.this.hLc.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hLp = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void oi(final boolean z) {
                if (h.this.hKG != null) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hKG.oi(z);
                        }
                    });
                }
            }
        };
        this.hLc = recordVideoActivity;
        bLL();
        this.hLd = BitmapFactory.decodeResource(recordVideoActivity.getResources(), e.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.hLf = this.hLc.bMd();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hLl = gLVideoPreviewView;
            this.hLk = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hLl).setFaceIdentifyStateListener(this.hLp);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hLl = videoPreviewView;
            this.hLk = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bMd() != null) {
            recordVideoActivity.bMd().addView(this.hLl, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hLk.e(this.mCamera);
    }

    public void startRecord() {
        this.hLk.f(this.mCamera);
    }

    public void stopRecord() {
        this.hLk.g(this.mCamera);
    }

    public g bLy() {
        return this.hLk;
    }

    public String bLz() {
        if (this.hLm == null) {
            this.hLm = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hEa);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hEa + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hLm.add(str);
        return str;
    }

    public void bLA() {
        if (this.hLm != null && this.hLm.size() != 0) {
            String remove = this.hLm.remove(this.hLm.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bLB() {
        File file = new File(com.baidu.tieba.video.c.hEa);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hFL = com.baidu.tieba.video.c.hEa + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hFL;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hLn != null && motionEvent.getAction() == 0) {
            this.hLn.bLN();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bLM();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hLn = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.screenHeight && x >= com.baidu.adp.lib.util.l.h(this.hLc, e.C0210e.ds60)) {
                    int width = this.hLd.getWidth();
                    int height = this.hLd.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.screenHeight - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hLf == null) {
                            this.hLf = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hLf.getChildCount()) {
                                if (this.hLe != this.hLf.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hLf.removeViewAt(i);
                                }
                            }
                        }
                        this.hLe = new a(this.hLc, clamp - (width / 2), clamp2 - (height / 2), this.hLd);
                        this.hLf.addView(this.hLe, new ViewGroup.LayoutParams(-2, -2));
                        bY(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bLM();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bLC() {
        int i;
        int i2;
        if (this.mCamera == null && this.hLc != null) {
            this.hLc.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.hLc.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hLc.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.dCR = a2.width;
            this.dCS = a2.height;
            this.hLj.setPreviewSize(this.dCR, this.dCS);
            if (this.hLk != null) {
                this.hLk.setPreviewSize(this.dCR, this.dCS);
            }
        }
        this.hLj.setPreviewFormat(17);
        bLD();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.hLc, this.mCameraId));
        this.hLg = this.hLj.getSupportedFocusModes();
        if (this.hLg != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hLg.contains("continuous-picture")) {
                this.hLj.setFocusMode("continuous-picture");
            } else if (this.hLg.contains("continuous-video")) {
                this.hLj.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hLj);
        if (this.hLc != null && this.hLc.bMd() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.dCS * 1.0f) / this.dCR;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hLl.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hLl.setLayoutParams(layoutParams);
            this.hLl.invalidate();
            if (this.hLq != null) {
                this.hLq.bZ(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int getScreenHeight(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
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

    private void bLD() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hLj.getSupportedPreviewFpsRange()) {
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
        this.hLj.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void oj(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.of(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.of(z)) {
                    bLG();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.og(z);
            if (-1 != this.mCameraId) {
                bLF();
                this.hLo = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hLh = z;
            } else {
                bLG();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bLG();
            if (this.hqL != null) {
                this.hqL.aa(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bLE() {
        return this.hLo;
    }

    private void bLF() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hLj = this.mCamera.getParameters();
            bLC();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bLG() {
        if (this.hLc != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLc.getPageContext().getPageActivity());
            aVar.db(e.j.video_quit_confirm);
            aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hLc != null) {
                        h.this.hLc.finish();
                    }
                }
            });
            aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(this.hLc.getPageContext());
            aVar.BS();
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
                if (this.hqL != null) {
                    this.hqL.aa(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bLH() {
        try {
            if (this.mCamera != null) {
                if (this.hLj == null) {
                    this.hLj = this.mCamera.getParameters();
                }
                if (ARCameraAttr.FlashType.FLASH_OFF.equals(this.hLj.getFlashMode())) {
                    this.hLj.setFlashMode("torch");
                } else {
                    this.hLj.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                }
                this.mCamera.setParameters(this.hLj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqL != null) {
                this.hqL.aa(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean bLI() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hLj == null) {
                this.hLj = this.mCamera.getParameters();
            }
            return !ARCameraAttr.FlashType.FLASH_OFF.equals(this.hLj.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqL != null) {
                this.hqL.aa(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void bLJ() {
        if (this.hLl != null && (this.hLl instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hLl;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bLr();
            this.hLi = this.hLi == 0 ? 1 : 0;
            oj(this.hLi == 1);
            gLVideoPreviewView.bLs();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hLl != null && (this.hLl instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hLl).h(this.mCamera);
            releaseCamera();
            this.hLi = this.hLi == 0 ? 1 : 0;
            oj(this.hLi == 1);
            startPreview();
        }
    }

    public boolean bLK() {
        return this.hLi == 1;
    }

    private void bLL() {
        this.dCR = 720;
        this.dCS = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLM() {
        if (this.hLf != null && this.hLe != null && this.hLe.getParent() != null) {
            this.hLf.removeView(this.hLe);
        }
    }

    private void bY(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hLg.contains("auto")) {
                this.hLj = this.mCamera.getParameters();
                this.hLj.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hLj);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqL != null) {
                this.hqL.aa(9, com.baidu.tieba.j.a.o(e));
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
        if (this.hLl instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hLl).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hLl instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hLl).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hLl instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hLl).setSticker(stickerItem);
        }
    }

    public void onResume() {
        oj(this.hLi == 1);
        if (this.hLl != null && (this.hLl instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hLl).onResume();
        }
        if (this.hLl != null && (this.hLl instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hLl).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bLm()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hLk.h(this.mCamera);
        if (this.hLl != null && (this.hLl instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hLl).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hLq = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hKG = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hLk instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hLk != null) {
                        h.this.hLk.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hLk.a(aVar);
        }
    }

    public boolean bLw() {
        return this.mCameraId == 0;
    }
}
