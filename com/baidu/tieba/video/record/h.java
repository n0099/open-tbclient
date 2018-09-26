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
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private int dJw;
    private int djN;
    private int djO;
    private com.baidu.tieba.j.h gWF;
    protected String hli;
    private RecordVideoActivity hqA;
    private Bitmap hqB;
    private a hqC;
    private FrameLayout hqD;
    private List<String> hqE;
    protected boolean hqF;
    private g hqI;
    private SurfaceView hqJ;
    protected List<String> hqK;
    private b hqL;
    private com.baidu.tieba.video.record.b hqM;
    private GLVideoPreviewView.a hqN;
    private c hqO;
    private GLVideoPreviewView.a hqg;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hqG = 0;
    private Camera.Parameters hqH = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bFy();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void bT(int i, int i2);
    }

    public void L(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.aF(false);
        aVar.co(e.j.request_permission_default_title);
        aVar.cp(e.j.request_permission_camera);
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
        aVar.yl();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
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
                        if (h.this.hqA != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.L(h.this.hqA);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.hqA, e.j.disallow_camera_permission);
                            if (h.this.gWF != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hqA.getResources().getString(e.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gWF.ab(1, string);
                            }
                            h.this.hqA.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hqA != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hqA, e.j.disallow_audio_record_permission);
                            if (h.this.gWF != null) {
                                h.this.gWF.ab(2, h.this.hqA.getResources().getString(e.j.disallow_audio_record_permission));
                            }
                            h.this.hqA.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hqN = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void nx(final boolean z) {
                if (h.this.hqg != null) {
                    com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hqg.nx(z);
                        }
                    });
                }
            }
        };
        this.hqA = recordVideoActivity;
        bFw();
        this.hqB = BitmapFactory.decodeResource(recordVideoActivity.getResources(), e.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dJw = displayMetrics.heightPixels;
        this.hqD = this.hqA.bFO();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hqJ = gLVideoPreviewView;
            this.hqI = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hqJ).setFaceIdentifyStateListener(this.hqN);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hqJ = videoPreviewView;
            this.hqI = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bFO() != null) {
            recordVideoActivity.bFO().addView(this.hqJ, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hqI.e(this.mCamera);
    }

    public void startRecord() {
        this.hqI.f(this.mCamera);
    }

    public void stopRecord() {
        this.hqI.g(this.mCamera);
    }

    public g bFj() {
        return this.hqI;
    }

    public String bFk() {
        if (this.hqK == null) {
            this.hqK = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hjw);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hjw + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hqK.add(str);
        return str;
    }

    public void bFl() {
        if (this.hqK != null && this.hqK.size() != 0) {
            String remove = this.hqK.remove(this.hqK.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bFm() {
        File file = new File(com.baidu.tieba.video.c.hjw);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hli = com.baidu.tieba.video.c.hjw + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hli;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hqL != null && motionEvent.getAction() == 0) {
            this.hqL.bFy();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bFx();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hqL = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dJw && x >= com.baidu.adp.lib.util.l.h(this.hqA, e.C0141e.ds60)) {
                    int width = this.hqB.getWidth();
                    int height = this.hqB.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dJw - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hqD == null) {
                            this.hqD = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hqD.getChildCount()) {
                                if (this.hqC != this.hqD.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hqD.removeViewAt(i);
                                }
                            }
                        }
                        this.hqC = new a(this.hqA, clamp - (width / 2), clamp2 - (height / 2), this.hqB);
                        this.hqD.addView(this.hqC, new ViewGroup.LayoutParams(-2, -2));
                        bS(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bFx();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bFn() {
        int i;
        int i2;
        if (this.mCamera == null && this.hqA != null) {
            this.hqA.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.hqA.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hqA.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.djN = a2.width;
            this.djO = a2.height;
            this.hqH.setPreviewSize(this.djN, this.djO);
            if (this.hqI != null) {
                this.hqI.setPreviewSize(this.djN, this.djO);
            }
        }
        this.hqH.setPreviewFormat(17);
        bFo();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hqA, this.mCameraId));
        this.hqE = this.hqH.getSupportedFocusModes();
        if (this.hqE != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hqE.contains("continuous-picture")) {
                this.hqH.setFocusMode("continuous-picture");
            } else if (this.hqE.contains("continuous-video")) {
                this.hqH.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hqH);
        if (this.hqA != null && this.hqA.bFO() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.djO * 1.0f) / this.djN;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hqJ.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hqJ.setLayoutParams(layoutParams);
            this.hqJ.invalidate();
            if (this.hqO != null) {
                this.hqO.bT(layoutParams.width, layoutParams.height);
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

    private void bFo() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hqH.getSupportedPreviewFpsRange()) {
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
        this.hqH.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ny(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nu(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nu(z)) {
                    bFr();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.nv(z);
            if (-1 != this.mCameraId) {
                bFq();
                this.hqM = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hqF = z;
            } else {
                bFr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bFr();
            if (this.gWF != null) {
                this.gWF.ab(8, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bFp() {
        return this.hqM;
    }

    private void bFq() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hqH = this.mCamera.getParameters();
            bFn();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.m(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bFr() {
        if (this.hqA != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hqA.getPageContext().getPageActivity());
            aVar.cp(e.j.video_quit_confirm);
            aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hqA != null) {
                        h.this.hqA.finish();
                    }
                }
            });
            aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aE(true);
            aVar.b(this.hqA.getPageContext());
            aVar.yl();
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
                if (this.gWF != null) {
                    this.gWF.ab(6, com.baidu.tieba.j.a.m(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bFs() {
        try {
            if (this.mCamera != null) {
                if (this.hqH == null) {
                    this.hqH = this.mCamera.getParameters();
                }
                if ("off".equals(this.hqH.getFlashMode())) {
                    this.hqH.setFlashMode("torch");
                } else {
                    this.hqH.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hqH);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gWF != null) {
                this.gWF.ab(7, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public boolean bFt() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hqH == null) {
                this.hqH = this.mCamera.getParameters();
            }
            return !"off".equals(this.hqH.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gWF != null) {
                this.gWF.ab(7, com.baidu.tieba.j.a.m(e));
                return false;
            }
            return false;
        }
    }

    public void bFu() {
        if (this.hqJ != null && (this.hqJ instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hqJ;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bFc();
            this.hqG = this.hqG == 0 ? 1 : 0;
            ny(this.hqG == 1);
            gLVideoPreviewView.bFd();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hqJ != null && (this.hqJ instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hqJ).h(this.mCamera);
            releaseCamera();
            this.hqG = this.hqG == 0 ? 1 : 0;
            ny(this.hqG == 1);
            startPreview();
        }
    }

    public boolean bFv() {
        return this.hqG == 1;
    }

    private void bFw() {
        this.djN = 720;
        this.djO = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFx() {
        if (this.hqD != null && this.hqC != null && this.hqC.getParent() != null) {
            this.hqD.removeView(this.hqC);
        }
    }

    private void bS(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hqE.contains("auto")) {
                this.hqH = this.mCamera.getParameters();
                this.hqH.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hqH);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gWF != null) {
                this.gWF.ab(9, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
        if (this.hqJ instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hqJ).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hqJ instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hqJ).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hqJ instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hqJ).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ny(this.hqG == 1);
        if (this.hqJ != null && (this.hqJ instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hqJ).onResume();
        }
        if (this.hqJ != null && (this.hqJ instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hqJ).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bEX()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hqI.h(this.mCamera);
        if (this.hqJ != null && (this.hqJ instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hqJ).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hqO = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hqg = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hqI instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hqI != null) {
                        h.this.hqI.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hqI.a(aVar);
        }
    }

    public boolean bFh() {
        return this.mCameraId == 0;
    }
}
