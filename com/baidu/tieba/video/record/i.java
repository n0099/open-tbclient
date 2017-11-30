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
    private int cCZ;
    private int cDa;
    private int efx;
    private com.baidu.tieba.i.h gAg;
    protected String gOz;
    private g.a gTV;
    private SurfaceView gUA;
    protected List<String> gUB;
    private b gUC;
    private com.baidu.tieba.video.record.b gUD;
    private g.a gUE;
    private c gUF;
    private RecordVideoActivity gUp;
    private Bitmap gUq;
    private a gUr;
    private int gUs;
    private FrameLayout gUt;
    private List<String> gUu;
    protected boolean gUv;
    private boolean gUy;
    private h gUz;
    private Camera mCamera;
    private Handler mMainHandler;
    protected int mCameraId = -1;
    protected int gUw = 0;
    private Camera.Parameters gUx = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bDh();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void ce(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public i(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
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
                        if (i.this.gUp != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.gUp, d.j.disallow_camera_permission);
                            if (i.this.gAg != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.gUp.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.gAg.Q(1, string);
                            }
                            i.this.gUp.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.gUp != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.gUp, d.j.disallow_audio_record_permission);
                            if (i.this.gAg != null) {
                                i.this.gAg.Q(2, i.this.gUp.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.gUp.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gUE = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nI(final boolean z) {
                if (i.this.gTV != null) {
                    com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.gTV.nI(z);
                        }
                    });
                }
            }
        };
        this.gUp = recordVideoActivity;
        bDf();
        this.gUq = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.efx = displayMetrics.widthPixels;
        this.gUs = displayMetrics.heightPixels;
        this.gUt = this.gUp.bDv();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.gUA = gVar;
            this.gUz = gVar;
            ((g) this.gUA).setFaceIdentifyStateListener(this.gUE);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.gUA = nVar;
            this.gUz = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bDv() != null) {
            recordVideoActivity.bDv().addView(this.gUA, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gUz.d(this.mCamera);
    }

    public void startRecord() {
        this.gUz.e(this.mCamera);
    }

    public void stopRecord() {
        this.gUz.f(this.mCamera);
    }

    public void bCR() {
        this.gUB = null;
    }

    public String bCS() {
        if (this.gUB == null) {
            this.gUB = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gMT);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gMT + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gUB.add(str);
        return str;
    }

    public void bCT() {
        if (this.gUB != null && this.gUB.size() != 0) {
            File file = new File(this.gUB.get(0));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String bCU() {
        File file = new File(com.baidu.tieba.video.b.gMT);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gOz = com.baidu.tieba.video.b.gMT + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gOz;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.gUC != null && motionEvent.getAction() == 0) {
            this.gUC.bDh();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bDg();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.gUC = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.gUs && x >= com.baidu.adp.lib.util.l.f(this.gUp, d.e.ds60)) {
                    int width = this.gUq.getWidth();
                    int height = this.gUq.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.efx - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.gUs - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gUt == null) {
                            this.gUt = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gUt.getChildCount()) {
                                if (this.gUr != this.gUt.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gUt.removeViewAt(i);
                                }
                            }
                        }
                        this.gUr = new a(this.gUp, clamp - (width / 2), clamp2 - (height / 2), this.gUq);
                        this.gUt.addView(this.gUr, new ViewGroup.LayoutParams(-2, -2));
                        cd(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bDg();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bCV() {
        int i;
        int i2;
        if (this.mCamera == null && this.gUp != null) {
            this.gUp.finish();
            return;
        }
        int ac = com.baidu.adp.lib.util.l.ac(this.gUp.getPageContext().getPageActivity());
        int bI = bI(this.gUp.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, ac, bI);
        if (a2 != null) {
            this.cCZ = a2.width;
            this.cDa = a2.height;
            this.gUx.setPreviewSize(this.cCZ, this.cDa);
            if (this.gUz != null) {
                this.gUz.setPreviewSize(this.cCZ, this.cDa);
            }
        }
        this.gUx.setPreviewFormat(17);
        bCW();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.gUp, this.mCameraId));
        this.gUu = this.gUx.getSupportedFocusModes();
        if (this.gUu != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gUu.contains("continuous-picture")) {
                this.gUx.setFocusMode("continuous-picture");
            } else if (this.gUu.contains("continuous-video")) {
                this.gUx.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gUx);
        if (this.gUp != null && this.gUp.bDv() != null) {
            float f = (ac * 1.0f) / bI;
            float f2 = (this.cDa * 1.0f) / this.cCZ;
            if (f > f2) {
                i = ac;
                i2 = (int) (ac / f2);
            } else {
                i = (int) (bI * f2);
                i2 = bI;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gUA.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gUA.setLayoutParams(layoutParams);
            this.gUA.invalidate();
            if (this.gUF != null) {
                this.gUF.ce(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bI(Context context) {
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
            return com.baidu.adp.lib.util.l.ae(context);
        }
        return i;
    }

    private void bCW() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gUx.getSupportedPreviewFpsRange()) {
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
        this.gUx.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nJ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nG(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nG(z)) {
                    bCZ();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bCY();
                this.gUD = new com.baidu.tieba.video.record.b(this.mCamera);
                this.gUv = z;
            } else {
                bCZ();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bCZ();
            if (this.gAg != null) {
                this.gAg.Q(8, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bCX() {
        return this.gUD;
    }

    private void bCY() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gUx = this.mCamera.getParameters();
            bCV();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.g(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bCZ() {
        if (this.gUp != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gUp.getPageContext().getPageActivity());
            aVar.cd(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.gUp != null) {
                        i.this.gUp.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ao(true);
            aVar.b(this.gUp.getPageContext());
            aVar.tk();
        }
    }

    private void bDa() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gAg != null) {
                    this.gAg.Q(6, com.baidu.tieba.i.a.g(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDb() {
        try {
            if (this.mCamera != null) {
                if (this.gUx == null) {
                    this.gUx = this.mCamera.getParameters();
                }
                if ("off".equals(this.gUx.getFlashMode())) {
                    this.gUx.setFlashMode("torch");
                    this.gUy = true;
                } else {
                    this.gUx.setFlashMode("off");
                    this.gUy = false;
                }
                this.mCamera.setParameters(this.gUx);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gAg != null) {
                this.gAg.Q(7, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    public boolean bDc() {
        return this.gUy;
    }

    public void bDd() {
        if (this.gUA != null && (this.gUA instanceof g)) {
            g gVar = (g) this.gUA;
            gVar.setIsChangingCamera(true);
            bDa();
            gVar.bCM();
            this.gUw = this.gUw == 0 ? 1 : 0;
            nJ(this.gUw == 1);
            gVar.bCN();
            gVar.setIsChangingCamera(false);
        } else if (this.gUA != null && (this.gUA instanceof n)) {
            ((n) this.gUA).g(this.mCamera);
            bDa();
            this.gUw = this.gUw == 0 ? 1 : 0;
            nJ(this.gUw == 1);
            startPreview();
        }
    }

    public boolean bDe() {
        return this.gUw == 1;
    }

    private void bDf() {
        this.cCZ = 720;
        this.cDa = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDg() {
        if (this.gUt != null && this.gUr != null && this.gUr.getParent() != null) {
            this.gUt.removeView(this.gUr);
        }
    }

    private void cd(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gUu.contains("auto")) {
                this.gUx = this.mCamera.getParameters();
                this.gUx.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gUx);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gAg != null) {
                this.gAg.Q(9, com.baidu.tieba.i.a.g(e));
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
        if (this.gUA instanceof g) {
            ((g) this.gUA).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gUA instanceof g) {
            ((g) this.gUA).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gUA instanceof g) {
            ((g) this.gUA).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nJ(this.gUw == 1);
        if (this.gUA != null && (this.gUA instanceof g)) {
            ((g) this.gUA).onResume();
        }
        if (this.gUA != null && (this.gUA instanceof n)) {
            ((n) this.gUA).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCH()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bDa();
        this.gUz.g(this.mCamera);
        if (this.gUA != null && (this.gUA instanceof g)) {
            ((g) this.gUA).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gUF = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.gTV = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.gUz instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.gUz != null) {
                        i.this.gUz.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.gUz.a(aVar);
        }
    }
}
