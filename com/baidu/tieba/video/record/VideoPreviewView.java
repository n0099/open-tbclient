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
    private int ddU;
    private int ddV;
    private com.baidu.tieba.j.h gPa;
    private h hin;
    private g.a hiu;
    private MediaRecorder hlL;
    private boolean hlM;
    private boolean hlN;
    private boolean hlO;
    private SurfaceHolder mSurfaceHolder;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.ddU = 720;
        this.ddV = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
        }
        this.hin = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bCt();
        this.hlN = true;
    }

    private void bCt() {
        Handler mainHandler = this.hin.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hlN) {
            bCt();
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
        if (!this.hlM && camera != null) {
            this.hlM = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gPa != null) {
                    this.gPa.ab(27, com.baidu.tieba.j.a.m(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.hlL = new MediaRecorder();
            this.hlL.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.hlL.setCamera(camera);
            this.hlL.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.gPa != null) {
                        VideoPreviewView.this.gPa.ab(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.hlL.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.hlL.setVideoSource(1);
            this.hlL.setAudioSource(1);
            this.hlL.setOutputFormat(2);
            this.hlL.setVideoEncoder(2);
            this.hlL.setAudioEncoder(3);
            this.hlL.setAudioSamplingRate(48000);
            this.hlL.setAudioChannels(1);
            this.hlL.setVideoEncodingBitRate(2097152);
            this.hlL.setVideoFrameRate(20);
            if (this.hin.hiQ) {
                this.hlL.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.hlL.setOrientationHint(90);
            }
            this.hlL.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.hbE);
            if (!com.baidu.tbadk.core.util.l.dR(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.hlL.setOutputFile(this.hin.bCv());
            try {
                this.hlL.prepare();
                this.hlL.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gPa != null) {
                    this.gPa.ab(28, com.baidu.tieba.j.a.m(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.hlL != null) {
            try {
                this.hlL.stop();
                this.hlL.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gPa != null) {
                    this.gPa.ab(29, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.hlM) {
            this.hlM = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hin.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hlO) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hlO = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hiu = aVar;
        this.hlO = true;
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
                    return com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hbH, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.hiu != null) {
                    VideoPreviewView.this.hiu.p(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
