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
    private int dCS;
    private int dCT;
    protected String hFM;
    private GLVideoPreviewView.a hKH;
    private RecordVideoActivity hLd;
    private Bitmap hLe;
    private a hLf;
    private FrameLayout hLg;
    private List<String> hLh;
    protected boolean hLi;
    private g hLl;
    private SurfaceView hLm;
    protected List<String> hLn;
    private b hLo;
    private com.baidu.tieba.video.record.b hLp;
    private GLVideoPreviewView.a hLq;
    private c hLr;
    private com.baidu.tieba.j.h hqM;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenHeight;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hLj = 0;
    private Camera.Parameters hLk = null;

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
            this.hqM = lVar.bdZ();
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
                        if (h.this.hLd != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.R(h.this.hLd);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.hLd, e.j.disallow_camera_permission);
                            if (h.this.hqM != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hLd.getResources().getString(e.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.hqM.aa(1, string);
                            }
                            h.this.hLd.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hLd != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hLd, e.j.disallow_audio_record_permission);
                            if (h.this.hqM != null) {
                                h.this.hqM.aa(2, h.this.hLd.getResources().getString(e.j.disallow_audio_record_permission));
                            }
                            h.this.hLd.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hLq = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void oi(final boolean z) {
                if (h.this.hKH != null) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hKH.oi(z);
                        }
                    });
                }
            }
        };
        this.hLd = recordVideoActivity;
        bLL();
        this.hLe = BitmapFactory.decodeResource(recordVideoActivity.getResources(), e.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.hLg = this.hLd.bMd();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hLm = gLVideoPreviewView;
            this.hLl = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hLm).setFaceIdentifyStateListener(this.hLq);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hLm = videoPreviewView;
            this.hLl = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bMd() != null) {
            recordVideoActivity.bMd().addView(this.hLm, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hLl.e(this.mCamera);
    }

    public void startRecord() {
        this.hLl.f(this.mCamera);
    }

    public void stopRecord() {
        this.hLl.g(this.mCamera);
    }

    public g bLy() {
        return this.hLl;
    }

    public String bLz() {
        if (this.hLn == null) {
            this.hLn = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hEb);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hEb + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hLn.add(str);
        return str;
    }

    public void bLA() {
        if (this.hLn != null && this.hLn.size() != 0) {
            String remove = this.hLn.remove(this.hLn.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bLB() {
        File file = new File(com.baidu.tieba.video.c.hEb);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hFM = com.baidu.tieba.video.c.hEb + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hFM;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hLo != null && motionEvent.getAction() == 0) {
            this.hLo.bLN();
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
        this.hLo = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.screenHeight && x >= com.baidu.adp.lib.util.l.h(this.hLd, e.C0210e.ds60)) {
                    int width = this.hLe.getWidth();
                    int height = this.hLe.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.screenHeight - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hLg == null) {
                            this.hLg = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hLg.getChildCount()) {
                                if (this.hLf != this.hLg.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hLg.removeViewAt(i);
                                }
                            }
                        }
                        this.hLf = new a(this.hLd, clamp - (width / 2), clamp2 - (height / 2), this.hLe);
                        this.hLg.addView(this.hLf, new ViewGroup.LayoutParams(-2, -2));
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
        if (this.mCamera == null && this.hLd != null) {
            this.hLd.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.hLd.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hLd.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.dCS = a2.width;
            this.dCT = a2.height;
            this.hLk.setPreviewSize(this.dCS, this.dCT);
            if (this.hLl != null) {
                this.hLl.setPreviewSize(this.dCS, this.dCT);
            }
        }
        this.hLk.setPreviewFormat(17);
        bLD();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.hLd, this.mCameraId));
        this.hLh = this.hLk.getSupportedFocusModes();
        if (this.hLh != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hLh.contains("continuous-picture")) {
                this.hLk.setFocusMode("continuous-picture");
            } else if (this.hLh.contains("continuous-video")) {
                this.hLk.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hLk);
        if (this.hLd != null && this.hLd.bMd() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.dCT * 1.0f) / this.dCS;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hLm.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hLm.setLayoutParams(layoutParams);
            this.hLm.invalidate();
            if (this.hLr != null) {
                this.hLr.bZ(layoutParams.width, layoutParams.height);
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
        for (int[] iArr3 : this.hLk.getSupportedPreviewFpsRange()) {
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
        this.hLk.setPreviewFpsRange(iArr2[0], iArr2[1]);
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
                this.hLp = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hLi = z;
            } else {
                bLG();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bLG();
            if (this.hqM != null) {
                this.hqM.aa(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bLE() {
        return this.hLp;
    }

    private void bLF() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hLk = this.mCamera.getParameters();
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
        if (this.hLd != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLd.getPageContext().getPageActivity());
            aVar.db(e.j.video_quit_confirm);
            aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hLd != null) {
                        h.this.hLd.finish();
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
            aVar.b(this.hLd.getPageContext());
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
                if (this.hqM != null) {
                    this.hqM.aa(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bLH() {
        try {
            if (this.mCamera != null) {
                if (this.hLk == null) {
                    this.hLk = this.mCamera.getParameters();
                }
                if (ARCameraAttr.FlashType.FLASH_OFF.equals(this.hLk.getFlashMode())) {
                    this.hLk.setFlashMode("torch");
                } else {
                    this.hLk.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                }
                this.mCamera.setParameters(this.hLk);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqM != null) {
                this.hqM.aa(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean bLI() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hLk == null) {
                this.hLk = this.mCamera.getParameters();
            }
            return !ARCameraAttr.FlashType.FLASH_OFF.equals(this.hLk.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqM != null) {
                this.hqM.aa(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void bLJ() {
        if (this.hLm != null && (this.hLm instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hLm;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bLr();
            this.hLj = this.hLj == 0 ? 1 : 0;
            oj(this.hLj == 1);
            gLVideoPreviewView.bLs();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hLm != null && (this.hLm instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hLm).h(this.mCamera);
            releaseCamera();
            this.hLj = this.hLj == 0 ? 1 : 0;
            oj(this.hLj == 1);
            startPreview();
        }
    }

    public boolean bLK() {
        return this.hLj == 1;
    }

    private void bLL() {
        this.dCS = 720;
        this.dCT = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLM() {
        if (this.hLg != null && this.hLf != null && this.hLf.getParent() != null) {
            this.hLg.removeView(this.hLf);
        }
    }

    private void bY(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hLh.contains("auto")) {
                this.hLk = this.mCamera.getParameters();
                this.hLk.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hLk);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqM != null) {
                this.hqM.aa(9, com.baidu.tieba.j.a.o(e));
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
        if (this.hLm instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hLm).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hLm instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hLm).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hLm instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hLm).setSticker(stickerItem);
        }
    }

    public void onResume() {
        oj(this.hLj == 1);
        if (this.hLm != null && (this.hLm instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hLm).onResume();
        }
        if (this.hLm != null && (this.hLm instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hLm).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bLm()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hLl.h(this.mCamera);
        if (this.hLm != null && (this.hLm instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hLm).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hLr = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hKH = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hLl instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hLl != null) {
                        h.this.hLl.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hLl.a(aVar);
        }
    }

    public boolean bLw() {
        return this.mCameraId == 0;
    }
}
