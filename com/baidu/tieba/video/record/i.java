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
    private int dsA;
    private int dsB;
    private g.a hDN;
    private RecordVideoActivity hEh;
    private Bitmap hEi;
    private a hEj;
    private int hEk;
    private FrameLayout hEl;
    private List<String> hEm;
    protected boolean hEn;
    private h hEq;
    private SurfaceView hEr;
    protected List<String> hEs;
    private b hEt;
    private com.baidu.tieba.video.record.b hEu;
    private g.a hEv;
    private c hEw;
    private com.baidu.tieba.i.h hjJ;
    protected String hyo;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hEo = 0;
    private Camera.Parameters hEp = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bJn();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void dc(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public i(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
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
                        if (i.this.hEh != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hEh, d.j.disallow_camera_permission);
                            if (i.this.hjJ != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.hEh.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.hjJ.P(1, string);
                            }
                            i.this.hEh.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.hEh != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hEh, d.j.disallow_audio_record_permission);
                            if (i.this.hjJ != null) {
                                i.this.hjJ.P(2, i.this.hEh.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.hEh.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hEv = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void oe(final boolean z) {
                if (i.this.hDN != null) {
                    com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.hDN.oe(z);
                        }
                    });
                }
            }
        };
        this.hEh = recordVideoActivity;
        bJl();
        this.hEi = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.hEk = displayMetrics.heightPixels;
        this.hEl = this.hEh.bJE();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.hEr = gVar;
            this.hEq = gVar;
            ((g) this.hEr).setFaceIdentifyStateListener(this.hEv);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.hEr = nVar;
            this.hEq = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bJE() != null) {
            recordVideoActivity.bJE().addView(this.hEr, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hEq.g(this.mCamera);
    }

    public void startRecord() {
        this.hEq.h(this.mCamera);
    }

    public void stopRecord() {
        this.hEq.i(this.mCamera);
    }

    public h bIW() {
        return this.hEq;
    }

    public void bIX() {
        this.hEs = null;
    }

    public String bIY() {
        if (this.hEs == null) {
            this.hEs = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.hwE);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.hwE + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hEs.add(str);
        return str;
    }

    public void bIZ() {
        if (this.hEs != null && this.hEs.size() != 0) {
            String remove = this.hEs.remove(this.hEs.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bJa() {
        File file = new File(com.baidu.tieba.video.b.hwE);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hyo = com.baidu.tieba.video.b.hwE + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hyo;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hEt != null && motionEvent.getAction() == 0) {
            this.hEt.bJn();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bJm();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hEt = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.hEk && x >= com.baidu.adp.lib.util.l.s(this.hEh, d.e.ds60)) {
                    int width = this.hEi.getWidth();
                    int height = this.hEi.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.hEk - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hEl == null) {
                            this.hEl = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hEl.getChildCount()) {
                                if (this.hEj != this.hEl.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hEl.removeViewAt(i);
                                }
                            }
                        }
                        this.hEj = new a(this.hEh, clamp - (width / 2), clamp2 - (height / 2), this.hEi);
                        this.hEl.addView(this.hEj, new ViewGroup.LayoutParams(-2, -2));
                        db(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bJm();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bJb() {
        int i;
        int i2;
        if (this.mCamera == null && this.hEh != null) {
            this.hEh.finish();
            return;
        }
        int ao = com.baidu.adp.lib.util.l.ao(this.hEh.getPageContext().getPageActivity());
        int bQ = bQ(this.hEh.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bQ * 1.0f) / ao)));
        if (a2 != null) {
            this.dsA = a2.width;
            this.dsB = a2.height;
            this.hEp.setPreviewSize(this.dsA, this.dsB);
            if (this.hEq != null) {
                this.hEq.setPreviewSize(this.dsA, this.dsB);
            }
        }
        this.hEp.setPreviewFormat(17);
        bJc();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.i(this.hEh, this.mCameraId));
        this.hEm = this.hEp.getSupportedFocusModes();
        if (this.hEm != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hEm.contains("continuous-picture")) {
                this.hEp.setFocusMode("continuous-picture");
            } else if (this.hEm.contains("continuous-video")) {
                this.hEp.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hEp);
        if (this.hEh != null && this.hEh.bJE() != null) {
            float f = (ao * 1.0f) / bQ;
            float f2 = (this.dsB * 1.0f) / this.dsA;
            if (f > f2) {
                i = ao;
                i2 = (int) (ao / f2);
            } else {
                i = (int) (bQ * f2);
                i2 = bQ;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hEr.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hEr.setLayoutParams(layoutParams);
            this.hEr.invalidate();
            if (this.hEw != null) {
                this.hEw.dc(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bQ(Context context) {
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

    private void bJc() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hEp.getSupportedPreviewFpsRange()) {
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
        this.hEp.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void of(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.oc(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.oc(z)) {
                    bJf();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bJe();
                this.hEu = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hEn = z;
            } else {
                bJf();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bJf();
            if (this.hjJ != null) {
                this.hjJ.P(8, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bJd() {
        return this.hEu;
    }

    private void bJe() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hEp = this.mCamera.getParameters();
            bJb();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.i(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bJf() {
        if (this.hEh != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEh.getPageContext().getPageActivity());
            aVar.fd(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.hEh != null) {
                        i.this.hEh.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aV(true);
            aVar.b(this.hEh.getPageContext());
            aVar.AI();
        }
    }

    private void bJg() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hjJ != null) {
                    this.hjJ.P(6, com.baidu.tieba.i.a.i(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bJh() {
        try {
            if (this.mCamera != null) {
                if (this.hEp == null) {
                    this.hEp = this.mCamera.getParameters();
                }
                if ("off".equals(this.hEp.getFlashMode())) {
                    this.hEp.setFlashMode("torch");
                } else {
                    this.hEp.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hEp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hjJ != null) {
                this.hjJ.P(7, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public boolean bJi() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hEp == null) {
                this.hEp = this.mCamera.getParameters();
            }
            return !"off".equals(this.hEp.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hjJ != null) {
                this.hjJ.P(7, com.baidu.tieba.i.a.i(e));
                return false;
            }
            return false;
        }
    }

    public void bJj() {
        if (this.hEr != null && (this.hEr instanceof g)) {
            g gVar = (g) this.hEr;
            gVar.setIsChangingCamera(true);
            bJg();
            gVar.bIR();
            this.hEo = this.hEo == 0 ? 1 : 0;
            of(this.hEo == 1);
            gVar.bIS();
            gVar.setIsChangingCamera(false);
        } else if (this.hEr != null && (this.hEr instanceof n)) {
            ((n) this.hEr).j(this.mCamera);
            bJg();
            this.hEo = this.hEo == 0 ? 1 : 0;
            of(this.hEo == 1);
            startPreview();
        }
    }

    public boolean bJk() {
        return this.hEo == 1;
    }

    private void bJl() {
        this.dsA = 720;
        this.dsB = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        if (this.hEl != null && this.hEj != null && this.hEj.getParent() != null) {
            this.hEl.removeView(this.hEj);
        }
    }

    private void db(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hEm.contains("auto")) {
                this.hEp = this.mCamera.getParameters();
                this.hEp.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hEp);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hjJ != null) {
                this.hjJ.P(9, com.baidu.tieba.i.a.i(e));
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
        if (this.hEr instanceof g) {
            ((g) this.hEr).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hEr instanceof g) {
            ((g) this.hEr).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hEr instanceof g) {
            ((g) this.hEr).setSticker(stickerItem);
        }
    }

    public void onResume() {
        of(this.hEo == 1);
        if (this.hEr != null && (this.hEr instanceof g)) {
            ((g) this.hEr).onResume();
        }
        if (this.hEr != null && (this.hEr instanceof n)) {
            ((n) this.hEr).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bIK()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bJg();
        this.hEq.j(this.mCamera);
        if (this.hEr != null && (this.hEr instanceof g)) {
            ((g) this.hEr).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hEw = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.hDN = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.hEq instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.hEq != null) {
                        i.this.hEq.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hEq.a(aVar);
        }
    }
}
