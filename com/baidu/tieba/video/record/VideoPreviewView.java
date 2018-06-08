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
    private int ddc;
    private int ddd;
    private com.baidu.tieba.j.h gJZ;
    private h hcS;
    private g.a hcZ;
    private MediaRecorder hgp;
    private boolean hgq;
    private boolean hgr;
    private boolean hgs;
    private SurfaceHolder mSurfaceHolder;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.ddc = 720;
        this.ddd = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        this.hcS = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bDf();
        this.hgr = true;
    }

    private void bDf() {
        Handler mainHandler = this.hcS.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hgr) {
            bDf();
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
        if (!this.hgq && camera != null) {
            this.hgq = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gJZ != null) {
                    this.gJZ.ac(27, com.baidu.tieba.j.a.m(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (camera != null) {
            this.hgp = new MediaRecorder();
            this.hgp.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.hgp.setCamera(camera);
            this.hgp.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.gJZ != null) {
                        VideoPreviewView.this.gJZ.ac(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.hgp.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.hgp.setVideoSource(1);
            this.hgp.setAudioSource(1);
            this.hgp.setOutputFormat(2);
            this.hgp.setVideoEncoder(2);
            this.hgp.setAudioEncoder(3);
            this.hgp.setAudioSamplingRate(48000);
            this.hgp.setAudioChannels(1);
            this.hgp.setVideoEncodingBitRate(2097152);
            this.hgp.setVideoFrameRate(20);
            if (this.hcS.hdv) {
                this.hgp.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.hgp.setOrientationHint(90);
            }
            this.hgp.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gWl);
            if (!com.baidu.tbadk.core.util.l.dR(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.hgp.setOutputFile(this.hcS.bDh());
            try {
                this.hgp.prepare();
                this.hgp.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gJZ != null) {
                    this.gJZ.ac(28, com.baidu.tieba.j.a.m(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        if (this.hgp != null) {
            try {
                this.hgp.stop();
                this.hgp.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gJZ != null) {
                    this.gJZ.ac(29, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        if (this.hgq) {
            this.hgq = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hcS.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hgs) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hgs = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hcZ = aVar;
        this.hgs = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void k(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
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
                    return com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.b.gWo, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.hcZ != null) {
                    VideoPreviewView.this.hcZ.q(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
