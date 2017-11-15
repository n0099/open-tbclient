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
public class m extends SurfaceView implements SurfaceHolder.Callback, g {
    private int gJI;
    private int gJJ;
    private h gJz;
    private boolean gMv;
    private boolean gMw;
    private MediaRecorder gmv;
    private SurfaceHolder mSurfaceHolder;

    public m(Context context, h hVar) {
        super(context);
        this.gJI = 720;
        this.gJJ = TbConfig.HEAD_IMG_SIZE;
        this.gJz = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bAu();
        this.gMw = true;
    }

    private void bAu() {
        Handler mainHandler = this.gJz.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gMw) {
            bAu();
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
        if (!this.gMv && camera != null) {
            this.gMv = true;
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
            this.gmv = new MediaRecorder();
            this.gmv.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gmv.setCamera(camera);
            this.gmv.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.m.1
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
                this.gmv.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gmv.setVideoSource(1);
            this.gmv.setAudioSource(1);
            this.gmv.setOutputFormat(2);
            this.gmv.setVideoEncoder(2);
            this.gmv.setAudioEncoder(3);
            this.gmv.setAudioSamplingRate(48000);
            this.gmv.setAudioChannels(1);
            this.gmv.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
            this.gmv.setVideoFrameRate(20);
            if (this.gJz.gKa) {
                this.gmv.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gmv.setOrientationHint(90);
            }
            this.gmv.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gDB);
            if (!com.baidu.tbadk.core.util.k.dh(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gmv.setOutputFile(this.gJz.bAw());
            try {
                this.gmv.prepare();
                this.gmv.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (this.gmv != null) {
            try {
                this.gmv.stop();
                this.gmv.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.gMv) {
            this.gMv = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gJz.a(motionEvent, getParent());
    }
}
