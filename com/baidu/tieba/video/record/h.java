package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
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
/* loaded from: classes2.dex */
public class h {
    private int ddc;
    private int ddd;
    private int dwM;
    private com.baidu.tieba.j.h gJZ;
    protected String gXX;
    private GLVideoPreviewView.a hcW;
    protected List<String> hdA;
    private b hdB;
    private com.baidu.tieba.video.record.b hdC;
    private GLVideoPreviewView.a hdD;
    private c hdE;
    private RecordVideoActivity hdq;
    private Bitmap hdr;
    private a hds;
    private FrameLayout hdt;
    private List<String> hdu;
    protected boolean hdv;
    private g hdy;
    private SurfaceView hdz;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hdw = 0;
    private Camera.Parameters hdx = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bDv();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void bS(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
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
                        if (h.this.hdq != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hdq, d.k.disallow_camera_permission);
                            if (h.this.gJZ != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hdq.getResources().getString(d.k.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gJZ.ac(1, string);
                            }
                            h.this.hdq.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hdq != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hdq, d.k.disallow_audio_record_permission);
                            if (h.this.gJZ != null) {
                                h.this.gJZ.ac(2, h.this.hdq.getResources().getString(d.k.disallow_audio_record_permission));
                            }
                            h.this.hdq.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hdD = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void nf(final boolean z) {
                if (h.this.hcW != null) {
                    com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hcW.nf(z);
                        }
                    });
                }
            }
        };
        this.hdq = recordVideoActivity;
        bDt();
        this.hdr = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dwM = displayMetrics.heightPixels;
        this.hdt = this.hdq.bDN();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hdz = gLVideoPreviewView;
            this.hdy = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hdz).setFaceIdentifyStateListener(this.hdD);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hdz = videoPreviewView;
            this.hdy = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bDN() != null) {
            recordVideoActivity.bDN().addView(this.hdz, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hdy.g(this.mCamera);
    }

    public void startRecord() {
        this.hdy.h(this.mCamera);
    }

    public void stopRecord() {
        this.hdy.i(this.mCamera);
    }

    public g bDg() {
        return this.hdy;
    }

    public String bDh() {
        if (this.hdA == null) {
            this.hdA = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gWl);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gWl + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hdA.add(str);
        return str;
    }

    public void bDi() {
        if (this.hdA != null && this.hdA.size() != 0) {
            String remove = this.hdA.remove(this.hdA.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bDj() {
        File file = new File(com.baidu.tieba.video.b.gWl);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gXX = com.baidu.tieba.video.b.gWl + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gXX;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hdB != null && motionEvent.getAction() == 0) {
            this.hdB.bDv();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bDu();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hdB = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dwM && x >= com.baidu.adp.lib.util.l.e(this.hdq, d.e.ds60)) {
                    int width = this.hdr.getWidth();
                    int height = this.hdr.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dwM - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hdt == null) {
                            this.hdt = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hdt.getChildCount()) {
                                if (this.hds != this.hdt.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hdt.removeViewAt(i);
                                }
                            }
                        }
                        this.hds = new a(this.hdq, clamp - (width / 2), clamp2 - (height / 2), this.hdr);
                        this.hdt.addView(this.hds, new ViewGroup.LayoutParams(-2, -2));
                        bR(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bDu();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bDk() {
        int i;
        int i2;
        if (this.mCamera == null && this.hdq != null) {
            this.hdq.finish();
            return;
        }
        int ah = com.baidu.adp.lib.util.l.ah(this.hdq.getPageContext().getPageActivity());
        int bM = bM(this.hdq.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bM * 1.0f) / ah)));
        if (a2 != null) {
            this.ddc = a2.width;
            this.ddd = a2.height;
            this.hdx.setPreviewSize(this.ddc, this.ddd);
            if (this.hdy != null) {
                this.hdy.setPreviewSize(this.ddc, this.ddd);
            }
        }
        this.hdx.setPreviewFormat(17);
        bDl();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hdq, this.mCameraId));
        this.hdu = this.hdx.getSupportedFocusModes();
        if (this.hdu != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hdu.contains("continuous-picture")) {
                this.hdx.setFocusMode("continuous-picture");
            } else if (this.hdu.contains("continuous-video")) {
                this.hdx.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hdx);
        if (this.hdq != null && this.hdq.bDN() != null) {
            float f = (ah * 1.0f) / bM;
            float f2 = (this.ddd * 1.0f) / this.ddc;
            if (f > f2) {
                i = ah;
                i2 = (int) (ah / f2);
            } else {
                i = (int) (bM * f2);
                i2 = bM;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdz.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hdz.setLayoutParams(layoutParams);
            this.hdz.invalidate();
            if (this.hdE != null) {
                this.hdE.bS(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bM(Context context) {
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
            return com.baidu.adp.lib.util.l.aj(context);
        }
        return i;
    }

    private void bDl() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hdx.getSupportedPreviewFpsRange()) {
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
        this.hdx.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ng(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nd(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nd(z)) {
                    bDo();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bDn();
                this.hdC = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hdv = z;
            } else {
                bDo();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bDo();
            if (this.gJZ != null) {
                this.gJZ.ac(8, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bDm() {
        return this.hdC;
    }

    private void bDn() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hdx = this.mCamera.getParameters();
            bDk();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.m(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bDo() {
        if (this.hdq != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hdq.getPageContext().getPageActivity());
            aVar.cc(d.k.video_quit_confirm);
            aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hdq != null) {
                        h.this.hdq.finish();
                    }
                }
            });
            aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.au(true);
            aVar.b(this.hdq.getPageContext());
            aVar.xa();
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
                if (this.gJZ != null) {
                    this.gJZ.ac(6, com.baidu.tieba.j.a.m(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDp() {
        try {
            if (this.mCamera != null) {
                if (this.hdx == null) {
                    this.hdx = this.mCamera.getParameters();
                }
                if ("off".equals(this.hdx.getFlashMode())) {
                    this.hdx.setFlashMode("torch");
                } else {
                    this.hdx.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hdx);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gJZ != null) {
                this.gJZ.ac(7, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public boolean bDq() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hdx == null) {
                this.hdx = this.mCamera.getParameters();
            }
            return !"off".equals(this.hdx.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gJZ != null) {
                this.gJZ.ac(7, com.baidu.tieba.j.a.m(e));
                return false;
            }
            return false;
        }
    }

    public void bDr() {
        if (this.hdz != null && (this.hdz instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hdz;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bDa();
            this.hdw = this.hdw == 0 ? 1 : 0;
            ng(this.hdw == 1);
            gLVideoPreviewView.bDb();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hdz != null && (this.hdz instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hdz).j(this.mCamera);
            releaseCamera();
            this.hdw = this.hdw == 0 ? 1 : 0;
            ng(this.hdw == 1);
            startPreview();
        }
    }

    public boolean bDs() {
        return this.hdw == 1;
    }

    private void bDt() {
        this.ddc = 720;
        this.ddd = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDu() {
        if (this.hdt != null && this.hds != null && this.hds.getParent() != null) {
            this.hdt.removeView(this.hds);
        }
    }

    private void bR(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hdu.contains("auto")) {
                this.hdx = this.mCamera.getParameters();
                this.hdx.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hdx);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gJZ != null) {
                this.gJZ.ac(9, com.baidu.tieba.j.a.m(e));
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
        if (this.hdz instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hdz).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hdz instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hdz).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hdz instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hdz).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ng(this.hdw == 1);
        if (this.hdz != null && (this.hdz instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hdz).onResume();
        }
        if (this.hdz != null && (this.hdz instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hdz).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCV()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hdy.j(this.mCamera);
        if (this.hdz != null && (this.hdz instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hdz).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hdE = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hcW = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hdy instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.7
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hdy != null) {
                        h.this.hdy.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hdy.a(aVar);
        }
    }

    public boolean bDe() {
        return this.mCameraId == 0;
    }
}
