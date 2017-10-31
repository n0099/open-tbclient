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
    private int dZC;
    protected String gDJ;
    private int gIA;
    private int gIB;
    private RecordVideoActivity gIN;
    private Bitmap gIO;
    private a gIP;
    private FrameLayout gIQ;
    private List<String> gIR;
    protected boolean gIS;
    private boolean gIV;
    private g gIW;
    private SurfaceView gIX;
    protected List<String> gIY;
    private b gIZ;
    private Camera mCamera;
    protected int mCameraId = -1;
    protected int gIT = 0;
    private Camera.Parameters gIU = null;
    private Handler mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    h.this.startPreview();
                    return;
                case 2:
                    if (h.this.gIN != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gIN, d.j.disallow_camera_permission);
                        h.this.gIN.finish();
                        return;
                    }
                    return;
                case 3:
                    if (h.this.gIN != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gIN, d.j.disallow_audio_record_permission);
                        h.this.gIN.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean fVg = true;

    /* loaded from: classes2.dex */
    public interface b {
        void ce(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        this.gIN = recordVideoActivity;
        bAv();
        this.gIO = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.dZC = displayMetrics.widthPixels;
        this.gIQ = this.gIN.bAF();
        if (Build.VERSION.SDK_INT >= 18) {
            f fVar = new f(recordVideoActivity, this);
            this.gIX = fVar;
            this.gIW = fVar;
        } else {
            m mVar = new m(recordVideoActivity, this);
            this.gIX = mVar;
            this.gIW = mVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bAF() != null) {
            recordVideoActivity.bAF().addView(this.gIX, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gIW.d(this.mCamera);
    }

    public void startRecord() {
        this.gIW.e(this.mCamera);
    }

    public void stopRecord() {
        this.gIW.f(this.mCamera);
    }

    public void bAj() {
        this.gIY = null;
    }

    public String bAk() {
        if (this.gIY == null) {
            this.gIY = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gCt);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gCt + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gIY.add(str);
        return str;
    }

    public void bAl() {
        if (this.gIY != null && this.gIY.size() != 0) {
            File file = new File(this.gIY.get(0));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String bAm() {
        File file = new File(com.baidu.tieba.video.b.gCt);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gDJ = com.baidu.tieba.video.b.gCt + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gDJ;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dZC && x >= com.baidu.adp.lib.util.l.f(this.gIN, d.e.ds60)) {
                    int width = this.gIO.getWidth();
                    int height = this.gIO.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.dZC - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dZC - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gIQ == null) {
                            this.gIQ = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gIQ.getChildCount()) {
                                if (this.gIP != this.gIQ.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gIQ.removeViewAt(i);
                                }
                            }
                        }
                        this.gIP = new a(this.gIN, clamp - (width / 2), clamp2 - (height / 2), this.gIO);
                        this.gIQ.addView(this.gIP, new ViewGroup.LayoutParams(-2, -2));
                        cd(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bAw();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bAn() {
        if (this.mCamera == null && this.gIN != null) {
            this.gIN.finish();
            return;
        }
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, TbConfig.HEAD_IMG_SIZE);
        if (a2 != null) {
            this.gIA = a2.width;
            this.gIB = a2.height;
            this.gIU.setPreviewSize(this.gIA, this.gIB);
            if (this.gIW != null) {
                this.gIW.setPreviewSize(this.gIA, this.gIB);
            }
        }
        this.gIU.setPreviewFormat(17);
        bAo();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.gIN, this.mCameraId));
        this.gIR = this.gIU.getSupportedFocusModes();
        if (this.gIR != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gIR.contains("continuous-picture")) {
                this.gIU.setFocusMode("continuous-picture");
            } else if (this.gIR.contains("continuous-video")) {
                this.gIU.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gIU);
        if (this.gIN != null && this.gIN.bAF() != null) {
            int i = (int) (this.dZC * (this.gIA / (this.gIB * 1.0f)));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gIX.getLayoutParams();
            layoutParams.width = this.dZC;
            layoutParams.height = i;
            this.gIX.setLayoutParams(layoutParams);
            this.gIX.invalidate();
            if (this.gIZ != null) {
                this.gIZ.ce(layoutParams.width, layoutParams.height);
            }
        }
    }

    private void bAo() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gIU.getSupportedPreviewFpsRange()) {
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
        this.gIU.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nb(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.mZ(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.mZ(z)) {
                    bAq();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bAp();
                this.gIS = z;
            } else {
                bAq();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bAq();
        }
    }

    private void bAp() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gIU = this.mCamera.getParameters();
            bAn();
        } catch (RuntimeException e) {
            e.printStackTrace();
            this.mMainHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    private void bAq() {
        if (this.gIN != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gIN.getPageContext().getPageActivity());
            aVar.cc(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gIN != null) {
                        h.this.gIN.finish();
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
            aVar.b(this.gIN.getPageContext());
            aVar.th();
        }
    }

    private void bAr() {
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

    public void bAs() {
        try {
            if (this.mCamera != null) {
                if (this.gIU == null) {
                    this.gIU = this.mCamera.getParameters();
                }
                if ("off".equals(this.gIU.getFlashMode())) {
                    this.gIU.setFlashMode("torch");
                    this.gIV = true;
                } else {
                    this.gIU.setFlashMode("off");
                    this.gIV = false;
                }
                this.mCamera.setParameters(this.gIU);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean bAt() {
        return this.gIV;
    }

    public void bAu() {
        if (this.gIX != null && (this.gIX instanceof f)) {
            f fVar = (f) this.gIX;
            fVar.setIsChangingCamera(true);
            bAr();
            fVar.bAd();
            this.gIT = this.gIT == 0 ? 1 : 0;
            nb(this.gIT == 1);
            fVar.bAe();
            fVar.setIsChangingCamera(false);
        } else if (this.gIX != null && (this.gIX instanceof m)) {
            ((m) this.gIX).g(this.mCamera);
            bAr();
            this.gIT = this.gIT == 0 ? 1 : 0;
            nb(this.gIT == 1);
            startPreview();
        }
        this.fVg = this.fVg ? false : true;
    }

    private void bAv() {
        this.gIA = 720;
        this.gIB = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAw() {
        if (this.gIQ != null && this.gIP != null) {
            this.gIQ.removeView(this.gIP);
        }
    }

    private void cd(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gIR.contains("auto")) {
                this.gIU.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gIU);
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
        if (this.gIX instanceof f) {
            ((f) this.gIX).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gIX instanceof f) {
            ((f) this.gIX).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gIX instanceof f) {
            ((f) this.gIX).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nb(this.gIT == 1);
        if (this.gIX != null && (this.gIX instanceof f)) {
            ((f) this.gIX).onResume();
        }
        if (this.gIX != null && (this.gIX instanceof m)) {
            ((m) this.gIX).onResume();
        }
        if (!com.baidu.tieba.video.record.b.bzY()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bAr();
        this.gIW.g(this.mCamera);
        if (this.gIX != null && (this.gIX instanceof f)) {
            ((f) this.gIX).onPause();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.gIZ = bVar;
        }
    }
}
