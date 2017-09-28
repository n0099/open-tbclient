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
    private boolean gBN;
    private boolean gBO;
    private MediaRecorder gcW;
    private h gyZ;
    private int gzi;
    private int gzj;
    private SurfaceHolder mSurfaceHolder;

    public l(Context context, h hVar) {
        super(context);
        this.gzi = 720;
        this.gzj = TbConfig.HEAD_IMG_SIZE;
        this.gyZ = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bxb();
        this.gBO = true;
    }

    private void bxb() {
        Handler mainHandler = this.gyZ.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gBO) {
            bxb();
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
        if (!this.gBN && camera != null) {
            this.gBN = true;
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
            this.gcW = new MediaRecorder();
            this.gcW.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gcW.setCamera(camera);
            this.gcW.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.l.1
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
                this.gcW.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gcW.setVideoSource(1);
            this.gcW.setAudioSource(1);
            this.gcW.setOutputFormat(2);
            this.gcW.setVideoEncoder(2);
            this.gcW.setAudioEncoder(3);
            this.gcW.setAudioSamplingRate(48000);
            this.gcW.setAudioChannels(1);
            this.gcW.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
            this.gcW.setVideoFrameRate(20);
            if (this.gyZ.gzB) {
                this.gcW.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gcW.setOrientationHint(90);
            }
            this.gcW.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gtW);
            if (!com.baidu.tbadk.core.util.k.db(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gcW.setOutputFile(this.gyZ.bxd());
            try {
                this.gcW.prepare();
                this.gcW.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (this.gcW != null) {
            try {
                this.gcW.stop();
                this.gcW.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.gBN) {
            this.gBN = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gyZ.a(motionEvent, getParent());
    }
}
