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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private int dxv;
    private int dxw;
    private com.baidu.tieba.i.h gZD;
    protected String hol;
    private g.a htL;
    private RecordVideoActivity huf;
    private Bitmap hug;
    private a huh;
    private int hui;
    private FrameLayout huj;
    private List<String> huk;
    protected boolean hul;
    private h huo;
    private SurfaceView hup;
    protected List<String> huq;
    private b hur;
    private com.baidu.tieba.video.record.b hus;
    private g.a hut;
    private c huu;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hum = 0;
    private Camera.Parameters hun = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bCM();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void cV(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public i(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        this.mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String string;
                switch (message.what) {
                    case 1:
                        i.this.startPreview();
                        return;
                    case 2:
                        if (i.this.huf != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.huf, d.j.disallow_camera_permission);
                            if (i.this.gZD != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.huf.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.gZD.T(1, string);
                            }
                            i.this.huf.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.huf != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.huf, d.j.disallow_audio_record_permission);
                            if (i.this.gZD != null) {
                                i.this.gZD.T(2, i.this.huf.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.huf.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hut = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nk(final boolean z) {
                if (i.this.htL != null) {
                    com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.htL.nk(z);
                        }
                    });
                }
            }
        };
        this.huf = recordVideoActivity;
        bCK();
        this.hug = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.hui = displayMetrics.heightPixels;
        this.huj = this.huf.bDd();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.hup = gVar;
            this.huo = gVar;
            ((g) this.hup).setFaceIdentifyStateListener(this.hut);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.hup = nVar;
            this.huo = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bDd() != null) {
            recordVideoActivity.bDd().addView(this.hup, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.huo.g(this.mCamera);
    }

    public void startRecord() {
        this.huo.h(this.mCamera);
    }

    public void stopRecord() {
        this.huo.i(this.mCamera);
    }

    public h bCv() {
        return this.huo;
    }

    public void bCw() {
        this.huq = null;
    }

    public String bCx() {
        if (this.huq == null) {
            this.huq = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.hmB);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.hmB + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.huq.add(str);
        return str;
    }

    public void bCy() {
        if (this.huq != null && this.huq.size() != 0) {
            String remove = this.huq.remove(this.huq.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bCz() {
        File file = new File(com.baidu.tieba.video.b.hmB);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hol = com.baidu.tieba.video.b.hmB + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hol;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hur != null && motionEvent.getAction() == 0) {
            this.hur.bCM();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bCL();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hur = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.hui && x >= com.baidu.adp.lib.util.l.s(this.huf, d.e.ds60)) {
                    int width = this.hug.getWidth();
                    int height = this.hug.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.hui - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.huj == null) {
                            this.huj = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.huj.getChildCount()) {
                                if (this.huh != this.huj.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.huj.removeViewAt(i);
                                }
                            }
                        }
                        this.huh = new a(this.huf, clamp - (width / 2), clamp2 - (height / 2), this.hug);
                        this.huj.addView(this.huh, new ViewGroup.LayoutParams(-2, -2));
                        cU(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bCL();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bCA() {
        int i;
        int i2;
        if (this.mCamera == null && this.huf != null) {
            this.huf.finish();
            return;
        }
        int ao = com.baidu.adp.lib.util.l.ao(this.huf.getPageContext().getPageActivity());
        int bN = bN(this.huf.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bN * 1.0f) / ao)));
        if (a2 != null) {
            this.dxv = a2.width;
            this.dxw = a2.height;
            this.hun.setPreviewSize(this.dxv, this.dxw);
            if (this.huo != null) {
                this.huo.setPreviewSize(this.dxv, this.dxw);
            }
        }
        this.hun.setPreviewFormat(17);
        bCB();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.huf, this.mCameraId));
        this.huk = this.hun.getSupportedFocusModes();
        if (this.huk != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.huk.contains("continuous-picture")) {
                this.hun.setFocusMode("continuous-picture");
            } else if (this.huk.contains("continuous-video")) {
                this.hun.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hun);
        if (this.huf != null && this.huf.bDd() != null) {
            float f = (ao * 1.0f) / bN;
            float f2 = (this.dxw * 1.0f) / this.dxv;
            if (f > f2) {
                i = ao;
                i2 = (int) (ao / f2);
            } else {
                i = (int) (bN * f2);
                i2 = bN;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hup.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hup.setLayoutParams(layoutParams);
            this.hup.invalidate();
            if (this.huu != null) {
                this.huu.cV(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bN(Context context) {
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
            return com.baidu.adp.lib.util.l.aq(context);
        }
        return i;
    }

    private void bCB() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hun.getSupportedPreviewFpsRange()) {
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
        this.hun.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nl(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.ni(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.ni(z)) {
                    bCE();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bCD();
                this.hus = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hul = z;
            } else {
                bCE();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bCE();
            if (this.gZD != null) {
                this.gZD.T(8, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bCC() {
        return this.hus;
    }

    private void bCD() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hun = this.mCamera.getParameters();
            bCA();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.i(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bCE() {
        if (this.huf != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.huf.getPageContext().getPageActivity());
            aVar.fb(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.huf != null) {
                        i.this.huf.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(this.huf.getPageContext());
            aVar.AB();
        }
    }

    private void bCF() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gZD != null) {
                    this.gZD.T(6, com.baidu.tieba.i.a.i(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bCG() {
        try {
            if (this.mCamera != null) {
                if (this.hun == null) {
                    this.hun = this.mCamera.getParameters();
                }
                if ("off".equals(this.hun.getFlashMode())) {
                    this.hun.setFlashMode("torch");
                } else {
                    this.hun.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hun);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZD != null) {
                this.gZD.T(7, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public boolean bCH() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hun == null) {
                this.hun = this.mCamera.getParameters();
            }
            return !"off".equals(this.hun.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZD != null) {
                this.gZD.T(7, com.baidu.tieba.i.a.i(e));
                return false;
            }
            return false;
        }
    }

    public void bCI() {
        if (this.hup != null && (this.hup instanceof g)) {
            g gVar = (g) this.hup;
            gVar.setIsChangingCamera(true);
            bCF();
            gVar.bCq();
            this.hum = this.hum == 0 ? 1 : 0;
            nl(this.hum == 1);
            gVar.bCr();
            gVar.setIsChangingCamera(false);
        } else if (this.hup != null && (this.hup instanceof n)) {
            ((n) this.hup).j(this.mCamera);
            bCF();
            this.hum = this.hum == 0 ? 1 : 0;
            nl(this.hum == 1);
            startPreview();
        }
    }

    public boolean bCJ() {
        return this.hum == 1;
    }

    private void bCK() {
        this.dxv = 720;
        this.dxw = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCL() {
        if (this.huj != null && this.huh != null && this.huh.getParent() != null) {
            this.huj.removeView(this.huh);
        }
    }

    private void cU(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.huk.contains("auto")) {
                this.hun = this.mCamera.getParameters();
                this.hun.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hun);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZD != null) {
                this.gZD.T(9, com.baidu.tieba.i.a.i(e));
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
        if (this.hup instanceof g) {
            ((g) this.hup).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hup instanceof g) {
            ((g) this.hup).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hup instanceof g) {
            ((g) this.hup).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nl(this.hum == 1);
        if (this.hup != null && (this.hup instanceof g)) {
            ((g) this.hup).onResume();
        }
        if (this.hup != null && (this.hup instanceof n)) {
            ((n) this.hup).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCj()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bCF();
        this.huo.j(this.mCamera);
        if (this.hup != null && (this.hup instanceof g)) {
            ((g) this.hup).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.huu = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.htL = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.huo instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.huo != null) {
                        i.this.huo.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.huo.a(aVar);
        }
    }
}
