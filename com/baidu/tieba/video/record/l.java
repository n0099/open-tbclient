package com.baidu.tieba.video.record;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.tbadk.TbConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class l extends SurfaceView implements SurfaceHolder.Callback, g {
    private boolean gBM;
    private boolean gBN;
    private MediaRecorder gcV;
    private h gyY;
    private int gzh;
    private int gzi;
    private SurfaceHolder mSurfaceHolder;

    public l(Context context, h hVar) {
        super(context);
        this.gzh = 720;
        this.gzi = TbConfig.HEAD_IMG_SIZE;
        this.gyY = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bxa();
        this.gBN = true;
    }

    private void bxa() {
        Handler mainHandler = this.gyY.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gBN) {
            bxa();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // com.baidu.tieba.video.record.g
    public void d(Camera camera) {
        if (!this.gBM && camera != null) {
            this.gBM = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            this.gcV = new MediaRecorder();
            this.gcV.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gcV.setCamera(camera);
            this.gcV.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.media.MediaRecorder.OnErrorListener
                public void onError(MediaRecorder mediaRecorder, int i, int i2) {
                    if (mediaRecorder != null) {
                        try {
                            mediaRecorder.reset();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.gcV.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gcV.setVideoSource(1);
            this.gcV.setAudioSource(1);
            this.gcV.setOutputFormat(2);
            this.gcV.setVideoEncoder(2);
            this.gcV.setAudioEncoder(3);
            this.gcV.setAudioSamplingRate(48000);
            this.gcV.setAudioChannels(1);
            this.gcV.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
            this.gcV.setVideoFrameRate(20);
            if (this.gyY.gzA) {
                this.gcV.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gcV.setOrientationHint(90);
            }
            this.gcV.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gtV);
            if (!com.baidu.tbadk.core.util.k.db(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gcV.setOutputFile(this.gyY.bxc());
            try {
                this.gcV.prepare();
                this.gcV.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (this.gcV != null) {
            try {
                this.gcV.stop();
                this.gcV.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.gBM) {
            this.gBM = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gyY.a(motionEvent, getParent());
    }
}
