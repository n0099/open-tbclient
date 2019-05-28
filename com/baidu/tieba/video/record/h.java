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
    protected boolean adf;
    private com.baidu.tieba.j.h iZT;
    private int jdu;
    protected String jpa;
    private GLVideoPreviewView.a jtQ;
    private RecordVideoActivity juk;
    private Bitmap jul;
    private a jum;
    private FrameLayout jun;
    private List<String> juo;
    private g jur;
    private SurfaceView jus;
    protected List<String> jut;
    private b juu;
    private com.baidu.tieba.video.record.b juv;
    private GLVideoPreviewView.a juw;
    private c jux;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jup = 0;
    private Camera.Parameters juq = null;

    /* loaded from: classes5.dex */
    public interface b {
        void ctr();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cD(int i, int i2);
    }

    public void ah(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dN(false);
        aVar.hn(R.string.request_permission_default_title);
        aVar.ho(R.string.request_permission_camera);
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
        aVar.afG();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZT = lVar.bMn();
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
                        if (h.this.juk != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ah(h.this.juk);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.juk, (int) R.string.disallow_camera_permission);
                            if (h.this.iZT != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.juk.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.iZT.av(1, string);
                            }
                            h.this.juk.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.juk != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.juk, (int) R.string.disallow_audio_record_permission);
                            if (h.this.iZT != null) {
                                h.this.iZT.av(2, h.this.juk.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.juk.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.juw = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void rx(final boolean z) {
                if (h.this.jtQ != null) {
                    com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jtQ.rx(z);
                        }
                    });
                }
            }
        };
        this.juk = recordVideoActivity;
        ctp();
        this.jul = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.jdu = displayMetrics.heightPixels;
        this.jun = this.juk.ctH();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jus = gLVideoPreviewView;
            this.jur = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jus).setFaceIdentifyStateListener(this.juw);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jus = videoPreviewView;
            this.jur = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.ctH() != null) {
            recordVideoActivity.ctH().addView(this.jus, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jur.e(this.mCamera);
    }

    public void startRecord() {
        this.jur.f(this.mCamera);
    }

    public void stopRecord() {
        this.jur.g(this.mCamera);
    }

    public g ctc() {
        return this.jur;
    }

    public String ctd() {
        if (this.jut == null) {
            this.jut = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.jno);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.jno + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jut.add(str);
        return str;
    }

    public void cte() {
        if (this.jut != null && this.jut.size() != 0) {
            String remove = this.jut.remove(this.jut.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String ctf() {
        File file = new File(com.baidu.tieba.video.c.jno);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.jpa = com.baidu.tieba.video.c.jno + "f_" + System.currentTimeMillis() + ".mp4";
        return this.jpa;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.juu != null && motionEvent.getAction() == 0) {
            this.juu.ctr();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.ctq();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.juu = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.jdu && x >= com.baidu.adp.lib.util.l.g(this.juk, R.dimen.ds60)) {
                    int width = this.jul.getWidth();
                    int height = this.jul.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.jdu - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jun == null) {
                            this.jun = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jun.getChildCount()) {
                                if (this.jum != this.jun.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jun.removeViewAt(i);
                                }
                            }
                        }
                        this.jum = new a(this.juk, clamp - (width / 2), clamp2 - (height / 2), this.jul);
                        this.jun.addView(this.jum, new ViewGroup.LayoutParams(-2, -2));
                        cC(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.ctq();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void ctg() {
        int i;
        int i2;
        if (this.mCamera == null && this.juk != null) {
            this.juk.finish();
            return;
        }
        int af = com.baidu.adp.lib.util.l.af(this.juk.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.juk.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / af)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.juq.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jur != null) {
                this.jur.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.juq.setPreviewFormat(17);
        cth();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.juk, this.mCameraId));
        this.juo = this.juq.getSupportedFocusModes();
        if (this.juo != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.juo.contains("continuous-picture")) {
                this.juq.setFocusMode("continuous-picture");
            } else if (this.juo.contains("continuous-video")) {
                this.juq.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.juq);
        if (this.juk != null && this.juk.ctH() != null) {
            float f = (af * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = af;
                i2 = (int) (af / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jus.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jus.setLayoutParams(layoutParams);
            this.jus.invalidate();
            if (this.jux != null) {
                this.jux.cD(layoutParams.width, layoutParams.height);
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

    private void cth() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.juq.getSupportedPreviewFpsRange()) {
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
        this.juq.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ry(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.ru(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.ru(z)) {
                    ctk();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.rv(z);
            if (-1 != this.mCameraId) {
                ctj();
                this.juv = new com.baidu.tieba.video.record.b(this.mCamera);
                this.adf = z;
            } else {
                ctk();
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctk();
            if (this.iZT != null) {
                this.iZT.av(8, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cti() {
        return this.juv;
    }

    private void ctj() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.juq = this.mCamera.getParameters();
            ctg();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void ctk() {
        if (this.juk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.juk.getPageContext().getPageActivity());
            aVar.ho(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.juk != null) {
                        h.this.juk.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dM(true);
            aVar.b(this.juk.getPageContext());
            aVar.afG();
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
                if (this.iZT != null) {
                    this.iZT.av(6, com.baidu.tieba.j.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void ctl() {
        try {
            if (this.mCamera != null) {
                if (this.juq == null) {
                    this.juq = this.mCamera.getParameters();
                }
                if ("off".equals(this.juq.getFlashMode())) {
                    this.juq.setFlashMode("torch");
                } else {
                    this.juq.setFlashMode("off");
                }
                this.mCamera.setParameters(this.juq);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZT != null) {
                this.iZT.av(7, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public boolean ctm() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.juq == null) {
                this.juq = this.mCamera.getParameters();
            }
            return !"off".equals(this.juq.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZT != null) {
                this.iZT.av(7, com.baidu.tieba.j.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void ctn() {
        if (this.jus != null && (this.jus instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jus;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.csV();
            this.jup = this.jup == 0 ? 1 : 0;
            ry(this.jup == 1);
            gLVideoPreviewView.csW();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jus != null && (this.jus instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jus).h(this.mCamera);
            releaseCamera();
            this.jup = this.jup == 0 ? 1 : 0;
            ry(this.jup == 1);
            startPreview();
        }
    }

    public boolean cto() {
        return this.jup == 1;
    }

    private void ctp() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctq() {
        if (this.jun != null && this.jum != null && this.jum.getParent() != null) {
            this.jun.removeView(this.jum);
        }
    }

    private void cC(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.juo.contains("auto")) {
                this.juq = this.mCamera.getParameters();
                this.juq.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.juq);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZT != null) {
                this.iZT.av(9, com.baidu.tieba.j.a.p(e));
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
        if (this.jus instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jus).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jus instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jus).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jus instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jus).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ry(this.jup == 1);
        if (this.jus != null && (this.jus instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jus).onResume();
        }
        if (this.jus != null && (this.jus instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jus).onResume();
        }
        if (!com.baidu.tieba.video.record.c.csQ()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jur.h(this.mCamera);
        if (this.jus != null && (this.jus instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jus).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jux = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jtQ = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jur instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jur != null) {
                        h.this.jur.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jur.a(aVar);
        }
    }

    public boolean cta() {
        return this.mCameraId == 0;
    }
}
