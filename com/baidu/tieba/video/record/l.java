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
    private boolean gBx;
    private boolean gBy;
    private MediaRecorder gcH;
    private h gyK;
    private int gyT;
    private int gyU;
    private SurfaceHolder mSurfaceHolder;

    public l(Context context, h hVar) {
        super(context);
        this.gyT = 720;
        this.gyU = TbConfig.HEAD_IMG_SIZE;
        this.gyK = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bwS();
        this.gBy = true;
    }

    private void bwS() {
        Handler mainHandler = this.gyK.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gBy) {
            bwS();
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
        if (!this.gBx && camera != null) {
            this.gBx = true;
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
            this.gcH = new MediaRecorder();
            this.gcH.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gcH.setCamera(camera);
            this.gcH.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.l.1
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
                this.gcH.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gcH.setVideoSource(1);
            this.gcH.setAudioSource(1);
            this.gcH.setOutputFormat(2);
            this.gcH.setVideoEncoder(2);
            this.gcH.setAudioEncoder(3);
            this.gcH.setAudioSamplingRate(48000);
            this.gcH.setAudioChannels(1);
            this.gcH.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
            this.gcH.setVideoFrameRate(20);
            if (this.gyK.gzl) {
                this.gcH.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gcH.setOrientationHint(90);
            }
            this.gcH.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gtH);
            if (!com.baidu.tbadk.core.util.k.da(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gcH.setOutputFile(this.gyK.bwU());
            try {
                this.gcH.prepare();
                this.gcH.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (this.gcH != null) {
            try {
                this.gcH.stop();
                this.gcH.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.gBx) {
            this.gBx = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gyK.a(motionEvent, getParent());
    }
}
