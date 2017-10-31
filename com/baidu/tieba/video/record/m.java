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
    private int gIA;
    private int gIB;
    private h gIr;
    private boolean gLn;
    private boolean gLo;
    private MediaRecorder glt;
    private SurfaceHolder mSurfaceHolder;

    public m(Context context, h hVar) {
        super(context);
        this.gIA = 720;
        this.gIB = TbConfig.HEAD_IMG_SIZE;
        this.gIr = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bAi();
        this.gLo = true;
    }

    private void bAi() {
        Handler mainHandler = this.gIr.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gLo) {
            bAi();
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
        if (!this.gLn && camera != null) {
            this.gLn = true;
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
            this.glt = new MediaRecorder();
            this.glt.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.glt.setCamera(camera);
            this.glt.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.m.1
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
                this.glt.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.glt.setVideoSource(1);
            this.glt.setAudioSource(1);
            this.glt.setOutputFormat(2);
            this.glt.setVideoEncoder(2);
            this.glt.setAudioEncoder(3);
            this.glt.setAudioSamplingRate(48000);
            this.glt.setAudioChannels(1);
            this.glt.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
            this.glt.setVideoFrameRate(20);
            if (this.gIr.gIS) {
                this.glt.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.glt.setOrientationHint(90);
            }
            this.glt.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gCt);
            if (!com.baidu.tbadk.core.util.k.dh(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.glt.setOutputFile(this.gIr.bAk());
            try {
                this.glt.prepare();
                this.glt.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (this.glt != null) {
            try {
                this.glt.stop();
                this.glt.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.gLn) {
            this.gLn = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gIr.a(motionEvent, getParent());
    }
}
