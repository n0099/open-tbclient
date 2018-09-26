package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.video.record.g;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.faceunity.a.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private int djN;
    private int djO;
    private com.baidu.tieba.j.h gWF;
    private h hqc;
    private g.a hqj;
    private MediaRecorder htA;
    private boolean htB;
    private boolean htC;
    private boolean htD;
    private SurfaceHolder mSurfaceHolder;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.djN = 720;
        this.djO = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        this.hqc = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bFi();
        this.htC = true;
    }

    private void bFi() {
        Handler mainHandler = this.hqc.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.htC) {
            bFi();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (!this.htB && camera != null) {
            this.htB = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gWF != null) {
                    this.gWF.ab(27, com.baidu.tieba.j.a.m(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.htA = new MediaRecorder();
            this.htA.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.htA.setCamera(camera);
            this.htA.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.gWF != null) {
                        VideoPreviewView.this.gWF.ab(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.htA.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.htA.setVideoSource(1);
            this.htA.setAudioSource(1);
            this.htA.setOutputFormat(2);
            this.htA.setVideoEncoder(2);
            this.htA.setAudioEncoder(3);
            this.htA.setAudioSamplingRate(48000);
            this.htA.setAudioChannels(1);
            this.htA.setVideoEncodingBitRate(2097152);
            this.htA.setVideoFrameRate(20);
            if (this.hqc.hqF) {
                this.htA.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.htA.setOrientationHint(90);
            }
            this.htA.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.hjw);
            if (!com.baidu.tbadk.core.util.l.ej(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.htA.setOutputFile(this.hqc.bFk());
            try {
                this.htA.prepare();
                this.htA.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gWF != null) {
                    this.gWF.ab(28, com.baidu.tieba.j.a.m(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.htA != null) {
            try {
                this.htA.stop();
                this.htA.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gWF != null) {
                    this.gWF.ab(29, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.htB) {
            this.htB = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hqc.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.htD) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.htD = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hqj = aVar;
        this.htD = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void k(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.j(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a != null) {
                            bitmap.recycle();
                            bitmap = a;
                        }
                    }
                    return com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hjz, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
                } finally {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(String str) {
                if (VideoPreviewView.this.hqj != null) {
                    VideoPreviewView.this.hqj.u(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
