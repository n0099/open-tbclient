package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private int dZG;
    protected String gER;
    private int gJI;
    private int gJJ;
    private RecordVideoActivity gJV;
    private Bitmap gJW;
    private a gJX;
    private FrameLayout gJY;
    private List<String> gJZ;
    protected boolean gKa;
    private boolean gKd;
    private g gKe;
    private SurfaceView gKf;
    protected List<String> gKg;
    private b gKh;
    private Camera mCamera;
    protected int mCameraId = -1;
    protected int gKb = 0;
    private Camera.Parameters gKc = null;
    private Handler mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    h.this.startPreview();
                    return;
                case 2:
                    if (h.this.gJV != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gJV, d.j.disallow_camera_permission);
                        h.this.gJV.finish();
                        return;
                    }
                    return;
                case 3:
                    if (h.this.gJV != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gJV, d.j.disallow_audio_record_permission);
                        h.this.gJV.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean fWi = true;

    /* loaded from: classes2.dex */
    public interface b {
        void cd(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        this.gJV = recordVideoActivity;
        bAH();
        this.gJW = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.dZG = displayMetrics.widthPixels;
        this.gJY = this.gJV.bAR();
        if (Build.VERSION.SDK_INT >= 18) {
            f fVar = new f(recordVideoActivity, this);
            this.gKf = fVar;
            this.gKe = fVar;
        } else {
            m mVar = new m(recordVideoActivity, this);
            this.gKf = mVar;
            this.gKe = mVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bAR() != null) {
            recordVideoActivity.bAR().addView(this.gKf, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gKe.d(this.mCamera);
    }

    public void startRecord() {
        this.gKe.e(this.mCamera);
    }

    public void stopRecord() {
        this.gKe.f(this.mCamera);
    }

    public void bAv() {
        this.gKg = null;
    }

    public String bAw() {
        if (this.gKg == null) {
            this.gKg = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gDB);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gDB + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gKg.add(str);
        return str;
    }

    public void bAx() {
        if (this.gKg != null && this.gKg.size() != 0) {
            File file = new File(this.gKg.get(0));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String bAy() {
        File file = new File(com.baidu.tieba.video.b.gDB);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gER = com.baidu.tieba.video.b.gDB + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gER;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dZG && x >= com.baidu.adp.lib.util.l.f(this.gJV, d.e.ds60)) {
                    int width = this.gJW.getWidth();
                    int height = this.gJW.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.dZG - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dZG - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gJY == null) {
                            this.gJY = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gJY.getChildCount()) {
                                if (this.gJX != this.gJY.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gJY.removeViewAt(i);
                                }
                            }
                        }
                        this.gJX = new a(this.gJV, clamp - (width / 2), clamp2 - (height / 2), this.gJW);
                        this.gJY.addView(this.gJX, new ViewGroup.LayoutParams(-2, -2));
                        cc(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bAI();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bAz() {
        if (this.mCamera == null && this.gJV != null) {
            this.gJV.finish();
            return;
        }
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, TbConfig.HEAD_IMG_SIZE);
        if (a2 != null) {
            this.gJI = a2.width;
            this.gJJ = a2.height;
            this.gKc.setPreviewSize(this.gJI, this.gJJ);
            if (this.gKe != null) {
                this.gKe.setPreviewSize(this.gJI, this.gJJ);
            }
        }
        this.gKc.setPreviewFormat(17);
        bAA();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.gJV, this.mCameraId));
        this.gJZ = this.gKc.getSupportedFocusModes();
        if (this.gJZ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gJZ.contains("continuous-picture")) {
                this.gKc.setFocusMode("continuous-picture");
            } else if (this.gJZ.contains("continuous-video")) {
                this.gKc.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gKc);
        if (this.gJV != null && this.gJV.bAR() != null) {
            int i = (int) (this.dZG * (this.gJI / (this.gJJ * 1.0f)));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gKf.getLayoutParams();
            layoutParams.width = this.dZG;
            layoutParams.height = i;
            this.gKf.setLayoutParams(layoutParams);
            this.gKf.invalidate();
            if (this.gKh != null) {
                this.gKh.cd(layoutParams.width, layoutParams.height);
            }
        }
    }

    private void bAA() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gKc.getSupportedPreviewFpsRange()) {
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
        this.gKc.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nj(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nh(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nh(z)) {
                    bAC();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bAB();
                this.gKa = z;
            } else {
                bAC();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bAC();
        }
    }

    private void bAB() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gKc = this.mCamera.getParameters();
            bAz();
        } catch (RuntimeException e) {
            e.printStackTrace();
            this.mMainHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    private void bAC() {
        if (this.gJV != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gJV.getPageContext().getPageActivity());
            aVar.cc(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gJV != null) {
                        h.this.gJV.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ao(true);
            aVar.b(this.gJV.getPageContext());
            aVar.th();
        }
    }

    private void bAD() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCamera = null;
        }
    }

    public void bAE() {
        try {
            if (this.mCamera != null) {
                if (this.gKc == null) {
                    this.gKc = this.mCamera.getParameters();
                }
                if ("off".equals(this.gKc.getFlashMode())) {
                    this.gKc.setFlashMode("torch");
                    this.gKd = true;
                } else {
                    this.gKc.setFlashMode("off");
                    this.gKd = false;
                }
                this.mCamera.setParameters(this.gKc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean bAF() {
        return this.gKd;
    }

    public void bAG() {
        if (this.gKf != null && (this.gKf instanceof f)) {
            f fVar = (f) this.gKf;
            fVar.setIsChangingCamera(true);
            bAD();
            fVar.bAp();
            this.gKb = this.gKb == 0 ? 1 : 0;
            nj(this.gKb == 1);
            fVar.bAq();
            fVar.setIsChangingCamera(false);
        } else if (this.gKf != null && (this.gKf instanceof m)) {
            ((m) this.gKf).g(this.mCamera);
            bAD();
            this.gKb = this.gKb == 0 ? 1 : 0;
            nj(this.gKb == 1);
            startPreview();
        }
        this.fWi = this.fWi ? false : true;
    }

    private void bAH() {
        this.gJI = 720;
        this.gJJ = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAI() {
        if (this.gJY != null && this.gJX != null) {
            this.gJY.removeView(this.gJX);
        }
    }

    private void cc(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gJZ.contains("auto")) {
                this.gKc.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gKc);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
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
        if (this.gKf instanceof f) {
            ((f) this.gKf).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gKf instanceof f) {
            ((f) this.gKf).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gKf instanceof f) {
            ((f) this.gKf).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nj(this.gKb == 1);
        if (this.gKf != null && (this.gKf instanceof f)) {
            ((f) this.gKf).onResume();
        }
        if (this.gKf != null && (this.gKf instanceof m)) {
            ((m) this.gKf).onResume();
        }
        if (!com.baidu.tieba.video.record.b.bAk()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bAD();
        this.gKe.g(this.mCamera);
        if (this.gKf != null && (this.gKf instanceof f)) {
            ((f) this.gKf).onPause();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.gKh = bVar;
        }
    }
}
