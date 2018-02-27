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
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private int dAb;
    private int dAc;
    private int dSb;
    private com.baidu.tieba.i.h hbC;
    protected String hpn;
    private g.a huN;
    private RecordVideoActivity hvh;
    private Bitmap hvi;
    private a hvj;
    private FrameLayout hvk;
    private List<String> hvl;
    protected boolean hvm;
    private h hvp;
    private SurfaceView hvq;
    protected List<String> hvr;
    private b hvs;
    private com.baidu.tieba.video.record.b hvt;
    private g.a hvu;
    private c hvv;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hvn = 0;
    private Camera.Parameters hvo = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bDt();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void cQ(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public i(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
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
                        if (i.this.hvh != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hvh, d.j.disallow_camera_permission);
                            if (i.this.hbC != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.hvh.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.hbC.U(1, string);
                            }
                            i.this.hvh.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.hvh != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hvh, d.j.disallow_audio_record_permission);
                            if (i.this.hbC != null) {
                                i.this.hbC.U(2, i.this.hvh.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.hvh.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hvu = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nr(final boolean z) {
                if (i.this.huN != null) {
                    com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.huN.nr(z);
                        }
                    });
                }
            }
        };
        this.hvh = recordVideoActivity;
        bDr();
        this.hvi = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dSb = displayMetrics.heightPixels;
        this.hvk = this.hvh.bDK();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.hvq = gVar;
            this.hvp = gVar;
            ((g) this.hvq).setFaceIdentifyStateListener(this.hvu);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.hvq = nVar;
            this.hvp = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bDK() != null) {
            recordVideoActivity.bDK().addView(this.hvq, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hvp.g(this.mCamera);
    }

    public void startRecord() {
        this.hvp.h(this.mCamera);
    }

    public void stopRecord() {
        this.hvp.i(this.mCamera);
    }

    public h bDd() {
        return this.hvp;
    }

    public void bDe() {
        this.hvr = null;
    }

    public String bDf() {
        if (this.hvr == null) {
            this.hvr = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.hnD);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.hnD + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hvr.add(str);
        return str;
    }

    public void bDg() {
        if (this.hvr != null && this.hvr.size() != 0) {
            String remove = this.hvr.remove(this.hvr.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bDh() {
        File file = new File(com.baidu.tieba.video.b.hnD);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hpn = com.baidu.tieba.video.b.hnD + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hpn;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hvs != null && motionEvent.getAction() == 0) {
            this.hvs.bDt();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bDs();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hvs = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dSb && x >= com.baidu.adp.lib.util.l.t(this.hvh, d.e.ds60)) {
                    int width = this.hvi.getWidth();
                    int height = this.hvi.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dSb - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hvk == null) {
                            this.hvk = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hvk.getChildCount()) {
                                if (this.hvj != this.hvk.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hvk.removeViewAt(i);
                                }
                            }
                        }
                        this.hvj = new a(this.hvh, clamp - (width / 2), clamp2 - (height / 2), this.hvi);
                        this.hvk.addView(this.hvj, new ViewGroup.LayoutParams(-2, -2));
                        cP(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bDs();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bDi() {
        int i;
        int i2;
        if (this.mCamera == null && this.hvh != null) {
            this.hvh.finish();
            return;
        }
        int ao = com.baidu.adp.lib.util.l.ao(this.hvh.getPageContext().getPageActivity());
        int bN = bN(this.hvh.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bN * 1.0f) / ao)));
        if (a2 != null) {
            this.dAb = a2.width;
            this.dAc = a2.height;
            this.hvo.setPreviewSize(this.dAb, this.dAc);
            if (this.hvp != null) {
                this.hvp.setPreviewSize(this.dAb, this.dAc);
            }
        }
        this.hvo.setPreviewFormat(17);
        bDj();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hvh, this.mCameraId));
        this.hvl = this.hvo.getSupportedFocusModes();
        if (this.hvl != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hvl.contains("continuous-picture")) {
                this.hvo.setFocusMode("continuous-picture");
            } else if (this.hvl.contains("continuous-video")) {
                this.hvo.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hvo);
        if (this.hvh != null && this.hvh.bDK() != null) {
            float f = (ao * 1.0f) / bN;
            float f2 = (this.dAc * 1.0f) / this.dAb;
            if (f > f2) {
                i = ao;
                i2 = (int) (ao / f2);
            } else {
                i = (int) (bN * f2);
                i2 = bN;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvq.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hvq.setLayoutParams(layoutParams);
            this.hvq.invalidate();
            if (this.hvv != null) {
                this.hvv.cQ(layoutParams.width, layoutParams.height);
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

    private void bDj() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hvo.getSupportedPreviewFpsRange()) {
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
        this.hvo.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ns(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.np(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.np(z)) {
                    bDm();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bDl();
                this.hvt = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hvm = z;
            } else {
                bDm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bDm();
            if (this.hbC != null) {
                this.hbC.U(8, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bDk() {
        return this.hvt;
    }

    private void bDl() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hvo = this.mCamera.getParameters();
            bDi();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.i(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bDm() {
        if (this.hvh != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hvh.getPageContext().getPageActivity());
            aVar.fb(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.hvh != null) {
                        i.this.hvh.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aZ(true);
            aVar.b(this.hvh.getPageContext());
            aVar.AU();
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
                if (this.hbC != null) {
                    this.hbC.U(6, com.baidu.tieba.i.a.i(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDn() {
        try {
            if (this.mCamera != null) {
                if (this.hvo == null) {
                    this.hvo = this.mCamera.getParameters();
                }
                if ("off".equals(this.hvo.getFlashMode())) {
                    this.hvo.setFlashMode("torch");
                } else {
                    this.hvo.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hvo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbC != null) {
                this.hbC.U(7, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public boolean bDo() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hvo == null) {
                this.hvo = this.mCamera.getParameters();
            }
            return !"off".equals(this.hvo.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbC != null) {
                this.hbC.U(7, com.baidu.tieba.i.a.i(e));
                return false;
            }
            return false;
        }
    }

    public void bDp() {
        if (this.hvq != null && (this.hvq instanceof g)) {
            g gVar = (g) this.hvq;
            gVar.setIsChangingCamera(true);
            releaseCamera();
            gVar.bCY();
            this.hvn = this.hvn == 0 ? 1 : 0;
            ns(this.hvn == 1);
            gVar.bCZ();
            gVar.setIsChangingCamera(false);
        } else if (this.hvq != null && (this.hvq instanceof n)) {
            ((n) this.hvq).j(this.mCamera);
            releaseCamera();
            this.hvn = this.hvn == 0 ? 1 : 0;
            ns(this.hvn == 1);
            startPreview();
        }
    }

    public boolean bDq() {
        return this.hvn == 1;
    }

    private void bDr() {
        this.dAb = 720;
        this.dAc = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDs() {
        if (this.hvk != null && this.hvj != null && this.hvj.getParent() != null) {
            this.hvk.removeView(this.hvj);
        }
    }

    private void cP(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hvl.contains("auto")) {
                this.hvo = this.mCamera.getParameters();
                this.hvo.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hvo);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbC != null) {
                this.hbC.U(9, com.baidu.tieba.i.a.i(e));
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
        if (this.hvq instanceof g) {
            ((g) this.hvq).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hvq instanceof g) {
            ((g) this.hvq).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hvq instanceof g) {
            ((g) this.hvq).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ns(this.hvn == 1);
        if (this.hvq != null && (this.hvq instanceof g)) {
            ((g) this.hvq).onResume();
        }
        if (this.hvq != null && (this.hvq instanceof n)) {
            ((n) this.hvq).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCR()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hvp.j(this.mCamera);
        if (this.hvq != null && (this.hvq instanceof g)) {
            ((g) this.hvq).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hvv = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.huN = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.hvp instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.hvp != null) {
                        i.this.hvp.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hvp.a(aVar);
        }
    }
}
