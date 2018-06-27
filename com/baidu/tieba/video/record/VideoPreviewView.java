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
    private int dbe;
    private int dbf;
    private com.baidu.tieba.j.h gOa;
    private h hgX;
    private g.a hhe;
    private MediaRecorder hkw;
    private boolean hkx;
    private boolean hky;
    private boolean hkz;
    private SurfaceHolder mSurfaceHolder;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.dbe = 720;
        this.dbf = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        this.hgX = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bDF();
        this.hky = true;
    }

    private void bDF() {
        Handler mainHandler = this.hgX.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hky) {
            bDF();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (!this.hkx && camera != null) {
            this.hkx = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gOa != null) {
                    this.gOa.Z(27, com.baidu.tieba.j.a.m(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (camera != null) {
            this.hkw = new MediaRecorder();
            this.hkw.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.hkw.setCamera(camera);
            this.hkw.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.gOa != null) {
                        VideoPreviewView.this.gOa.Z(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.hkw.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.hkw.setVideoSource(1);
            this.hkw.setAudioSource(1);
            this.hkw.setOutputFormat(2);
            this.hkw.setVideoEncoder(2);
            this.hkw.setAudioEncoder(3);
            this.hkw.setAudioSamplingRate(48000);
            this.hkw.setAudioChannels(1);
            this.hkw.setVideoEncodingBitRate(2097152);
            this.hkw.setVideoFrameRate(20);
            if (this.hgX.hhA) {
                this.hkw.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.hkw.setOrientationHint(90);
            }
            this.hkw.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.haq);
            if (!com.baidu.tbadk.core.util.l.dU(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.hkw.setOutputFile(this.hgX.bDH());
            try {
                this.hkw.prepare();
                this.hkw.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gOa != null) {
                    this.gOa.Z(28, com.baidu.tieba.j.a.m(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        if (this.hkw != null) {
            try {
                this.hkw.stop();
                this.hkw.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gOa != null) {
                    this.gOa.Z(29, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        if (this.hkx) {
            this.hkx = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hgX.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hkz) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hkz = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hhe = aVar;
        this.hkz = true;
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
                    return com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.b.hat, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.hhe != null) {
                    VideoPreviewView.this.hhe.q(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
