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
    private com.baidu.tieba.j.h iZR;
    private int jds;
    protected String joZ;
    private GLVideoPreviewView.a jtP;
    private RecordVideoActivity juj;
    private Bitmap juk;
    private a jul;
    private FrameLayout jum;
    private List<String> jun;
    private g juq;
    private SurfaceView jur;
    protected List<String> jus;
    private b jut;
    private com.baidu.tieba.video.record.b juu;
    private GLVideoPreviewView.a juv;
    private c juw;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int juo = 0;
    private Camera.Parameters jup = null;

    /* loaded from: classes5.dex */
    public interface b {
        void ctp();
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
            this.iZR = lVar.bMk();
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
                        if (h.this.juj != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ah(h.this.juj);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.juj, (int) R.string.disallow_camera_permission);
                            if (h.this.iZR != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.juj.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.iZR.av(1, string);
                            }
                            h.this.juj.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.juj != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.juj, (int) R.string.disallow_audio_record_permission);
                            if (h.this.iZR != null) {
                                h.this.iZR.av(2, h.this.juj.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.juj.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.juv = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void rx(final boolean z) {
                if (h.this.jtP != null) {
                    com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jtP.rx(z);
                        }
                    });
                }
            }
        };
        this.juj = recordVideoActivity;
        ctn();
        this.juk = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.jds = displayMetrics.heightPixels;
        this.jum = this.juj.ctF();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jur = gLVideoPreviewView;
            this.juq = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jur).setFaceIdentifyStateListener(this.juv);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jur = videoPreviewView;
            this.juq = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.ctF() != null) {
            recordVideoActivity.ctF().addView(this.jur, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.juq.e(this.mCamera);
    }

    public void startRecord() {
        this.juq.f(this.mCamera);
    }

    public void stopRecord() {
        this.juq.g(this.mCamera);
    }

    public g cta() {
        return this.juq;
    }

    public String ctb() {
        if (this.jus == null) {
            this.jus = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.jnn);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.jnn + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jus.add(str);
        return str;
    }

    public void ctc() {
        if (this.jus != null && this.jus.size() != 0) {
            String remove = this.jus.remove(this.jus.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String ctd() {
        File file = new File(com.baidu.tieba.video.c.jnn);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.joZ = com.baidu.tieba.video.c.jnn + "f_" + System.currentTimeMillis() + ".mp4";
        return this.joZ;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jut != null && motionEvent.getAction() == 0) {
            this.jut.ctp();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cto();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.jut = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.jds && x >= com.baidu.adp.lib.util.l.g(this.juj, R.dimen.ds60)) {
                    int width = this.juk.getWidth();
                    int height = this.juk.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.jds - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jum == null) {
                            this.jum = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jum.getChildCount()) {
                                if (this.jul != this.jum.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jum.removeViewAt(i);
                                }
                            }
                        }
                        this.jul = new a(this.juj, clamp - (width / 2), clamp2 - (height / 2), this.juk);
                        this.jum.addView(this.jul, new ViewGroup.LayoutParams(-2, -2));
                        cC(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cto();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cte() {
        int i;
        int i2;
        if (this.mCamera == null && this.juj != null) {
            this.juj.finish();
            return;
        }
        int af = com.baidu.adp.lib.util.l.af(this.juj.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.juj.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / af)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jup.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.juq != null) {
                this.juq.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jup.setPreviewFormat(17);
        ctf();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.juj, this.mCameraId));
        this.jun = this.jup.getSupportedFocusModes();
        if (this.jun != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jun.contains("continuous-picture")) {
                this.jup.setFocusMode("continuous-picture");
            } else if (this.jun.contains("continuous-video")) {
                this.jup.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jup);
        if (this.juj != null && this.juj.ctF() != null) {
            float f = (af * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = af;
                i2 = (int) (af / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jur.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jur.setLayoutParams(layoutParams);
            this.jur.invalidate();
            if (this.juw != null) {
                this.juw.cD(layoutParams.width, layoutParams.height);
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

    private void ctf() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.jup.getSupportedPreviewFpsRange()) {
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
        this.jup.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ry(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.ru(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.ru(z)) {
                    cti();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.rv(z);
            if (-1 != this.mCameraId) {
                cth();
                this.juu = new com.baidu.tieba.video.record.b(this.mCamera);
                this.adf = z;
            } else {
                cti();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cti();
            if (this.iZR != null) {
                this.iZR.av(8, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b ctg() {
        return this.juu;
    }

    private void cth() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jup = this.mCamera.getParameters();
            cte();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cti() {
        if (this.juj != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.juj.getPageContext().getPageActivity());
            aVar.ho(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.juj != null) {
                        h.this.juj.finish();
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
            aVar.b(this.juj.getPageContext());
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
                if (this.iZR != null) {
                    this.iZR.av(6, com.baidu.tieba.j.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void ctj() {
        try {
            if (this.mCamera != null) {
                if (this.jup == null) {
                    this.jup = this.mCamera.getParameters();
                }
                if ("off".equals(this.jup.getFlashMode())) {
                    this.jup.setFlashMode("torch");
                } else {
                    this.jup.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jup);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZR != null) {
                this.iZR.av(7, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    public boolean ctk() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jup == null) {
                this.jup = this.mCamera.getParameters();
            }
            return !"off".equals(this.jup.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZR != null) {
                this.iZR.av(7, com.baidu.tieba.j.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void ctl() {
        if (this.jur != null && (this.jur instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jur;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.csT();
            this.juo = this.juo == 0 ? 1 : 0;
            ry(this.juo == 1);
            gLVideoPreviewView.csU();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jur != null && (this.jur instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jur).h(this.mCamera);
            releaseCamera();
            this.juo = this.juo == 0 ? 1 : 0;
            ry(this.juo == 1);
            startPreview();
        }
    }

    public boolean ctm() {
        return this.juo == 1;
    }

    private void ctn() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cto() {
        if (this.jum != null && this.jul != null && this.jul.getParent() != null) {
            this.jum.removeView(this.jul);
        }
    }

    private void cC(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jun.contains("auto")) {
                this.jup = this.mCamera.getParameters();
                this.jup.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jup);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZR != null) {
                this.iZR.av(9, com.baidu.tieba.j.a.p(e));
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
        if (this.jur instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jur).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jur instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jur).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jur instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jur).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ry(this.juo == 1);
        if (this.jur != null && (this.jur instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jur).onResume();
        }
        if (this.jur != null && (this.jur instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jur).onResume();
        }
        if (!com.baidu.tieba.video.record.c.csO()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.juq.h(this.mCamera);
        if (this.jur != null && (this.jur instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jur).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.juw = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jtP = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.juq instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.juq != null) {
                        h.this.juq.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.juq.a(aVar);
        }
    }

    public boolean csY() {
        return this.mCameraId == 0;
    }
}
