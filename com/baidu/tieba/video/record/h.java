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
    private int dSd;
    protected String gve;
    protected boolean gzA;
    private boolean gzD;
    private g gzE;
    private SurfaceView gzF;
    protected List<String> gzG;
    private b gzH;
    private int gzh;
    private int gzi;
    private RecordVideoActivity gzv;
    private Bitmap gzw;
    private a gzx;
    private FrameLayout gzy;
    private List<String> gzz;
    private Camera mCamera;
    protected int mCameraId = -1;
    protected int gzB = 0;
    private Camera.Parameters gzC = null;
    private Handler mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    h.this.startPreview();
                    return;
                case 2:
                    if (h.this.gzv != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gzv, d.l.disallow_camera_permission);
                        h.this.gzv.finish();
                        return;
                    }
                    return;
                case 3:
                    if (h.this.gzv != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gzv, d.l.disallow_audio_record_permission);
                        h.this.gzv.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean fMK = true;

    /* loaded from: classes2.dex */
    public interface b {
        void cc(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        this.gzv = recordVideoActivity;
        bxn();
        this.gzw = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.g.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.dSd = displayMetrics.widthPixels;
        this.gzy = this.gzv.bxu();
        if (Build.VERSION.SDK_INT >= 18) {
            f fVar = new f(recordVideoActivity, this);
            this.gzF = fVar;
            this.gzE = fVar;
        } else {
            l lVar = new l(recordVideoActivity, this);
            this.gzF = lVar;
            this.gzE = lVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bxu() != null) {
            recordVideoActivity.bxu().addView(this.gzF, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gzE.d(this.mCamera);
    }

    public void startRecord() {
        this.gzE.e(this.mCamera);
    }

    public void stopRecord() {
        this.gzE.f(this.mCamera);
    }

    public void bxb() {
        this.gzG = null;
    }

    public String bxc() {
        if (this.gzG == null) {
            this.gzG = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gtV);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gtV + System.currentTimeMillis() + ".mp4";
        this.gzG.add(str);
        return str;
    }

    public void bxd() {
        if (this.gzG != null && this.gzG.size() != 0) {
            File file = new File(this.gzG.get(0));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String bxe() {
        File file = new File(com.baidu.tieba.video.b.gtV);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gve = com.baidu.tieba.video.b.gtV + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gve;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dSd && x >= com.baidu.adp.lib.util.l.f(this.gzv, d.f.ds60)) {
                    int width = this.gzw.getWidth();
                    int height = this.gzw.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.dSd - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dSd - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gzy == null) {
                            this.gzy = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gzy.getChildCount()) {
                                if (this.gzx != this.gzy.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gzy.removeViewAt(i);
                                }
                            }
                        }
                        this.gzx = new a(this.gzv, clamp - (width / 2), clamp2 - (height / 2), this.gzw);
                        this.gzy.addView(this.gzx, new ViewGroup.LayoutParams(-2, -2));
                        cb(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bxo();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bxf() {
        if (this.mCamera == null && this.gzv != null) {
            this.gzv.finish();
            return;
        }
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, TbConfig.HEAD_IMG_SIZE);
        if (a2 != null) {
            this.gzh = a2.width;
            this.gzi = a2.height;
            this.gzC.setPreviewSize(this.gzh, this.gzi);
            if (this.gzE != null) {
                this.gzE.setPreviewSize(this.gzh, this.gzi);
            }
        }
        this.gzC.setPreviewFormat(17);
        bxg();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.gzv, this.mCameraId));
        this.gzz = this.gzC.getSupportedFocusModes();
        if (this.gzz != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gzz.contains("continuous-picture")) {
                this.gzC.setFocusMode("continuous-picture");
            } else if (this.gzz.contains("continuous-video")) {
                this.gzC.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gzC);
        if (this.gzv != null && this.gzv.bxu() != null) {
            int i = (int) (this.dSd * (this.gzh / (this.gzi * 1.0f)));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gzF.getLayoutParams();
            layoutParams.width = this.dSd;
            layoutParams.height = i;
            this.gzF.setLayoutParams(layoutParams);
            this.gzF.invalidate();
            if (this.gzH != null) {
                this.gzH.cc(layoutParams.width, layoutParams.height);
            }
        }
    }

    private void bxg() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gzC.getSupportedPreviewFpsRange()) {
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
        this.gzC.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nh(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nf(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nf(z)) {
                    bxi();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bxh();
                this.gzA = z;
            } else {
                bxi();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bxi();
        }
    }

    private void bxh() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gzC = this.mCamera.getParameters();
            bxf();
        } catch (RuntimeException e) {
            e.printStackTrace();
            this.mMainHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    private void bxi() {
        if (this.gzv != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gzv.getPageContext().getPageActivity());
            aVar.cd(d.l.video_quit_confirm);
            aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gzv != null) {
                        h.this.gzv.finish();
                    }
                }
            });
            aVar.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ar(true);
            aVar.b(this.gzv.getPageContext());
            aVar.ti();
        }
    }

    private void bxj() {
        if (this.mCamera != null) {
            this.mCamera.stopPreview();
            this.mCamera.setPreviewCallback(null);
            try {
                this.mCamera.setPreviewTexture(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void bxk() {
        try {
            if (this.mCamera != null) {
                if (this.gzC == null) {
                    this.gzC = this.mCamera.getParameters();
                }
                if ("off".equals(this.gzC.getFlashMode())) {
                    this.gzC.setFlashMode("torch");
                    this.gzD = true;
                } else {
                    this.gzC.setFlashMode("off");
                    this.gzD = false;
                }
                this.mCamera.setParameters(this.gzC);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean bxl() {
        return this.gzD;
    }

    public void bxm() {
        if (this.gzF != null && (this.gzF instanceof f)) {
            f fVar = (f) this.gzF;
            fVar.setIsChangingCamera(true);
            bxj();
            fVar.bwW();
            this.gzB = this.gzB == 0 ? 1 : 0;
            nh(this.gzB == 1);
            fVar.bwX();
            fVar.setIsChangingCamera(false);
        } else if (this.gzF != null && (this.gzF instanceof l)) {
            ((l) this.gzF).g(this.mCamera);
            bxj();
            this.gzB = this.gzB == 0 ? 1 : 0;
            nh(this.gzB == 1);
            startPreview();
        }
        this.fMK = this.fMK ? false : true;
    }

    private void bxn() {
        this.gzh = 720;
        this.gzi = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxo() {
        if (this.gzy != null && this.gzx != null) {
            this.gzy.removeView(this.gzx);
        }
    }

    private void cb(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gzz.contains("auto")) {
                this.gzC.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gzC);
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
        if (this.gzF instanceof f) {
            ((f) this.gzF).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gzF instanceof f) {
            ((f) this.gzF).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gzF instanceof f) {
            ((f) this.gzF).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nh(this.gzB == 1);
        if (this.gzF != null && (this.gzF instanceof f)) {
            ((f) this.gzF).onResume();
        }
        if (this.gzF != null && (this.gzF instanceof l)) {
            ((l) this.gzF).onResume();
        }
        if (!com.baidu.tieba.video.record.b.bwT()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bxj();
        this.gzE.g(this.mCamera);
        if (this.gzF != null && (this.gzF instanceof f)) {
            ((f) this.gzF).onPause();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.gzH = bVar;
        }
    }
}
