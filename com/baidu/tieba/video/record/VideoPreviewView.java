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
    private int ddW;
    private int ddX;
    private com.baidu.tieba.j.h gOY;
    private h him;
    private g.a hit;
    private MediaRecorder hlK;
    private boolean hlL;
    private boolean hlM;
    private boolean hlN;
    private SurfaceHolder mSurfaceHolder;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.ddW = 720;
        this.ddX = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        this.him = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bCr();
        this.hlM = true;
    }

    private void bCr() {
        Handler mainHandler = this.him.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hlM) {
            bCr();
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
        if (!this.hlL && camera != null) {
            this.hlL = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gOY != null) {
                    this.gOY.ab(27, com.baidu.tieba.j.a.m(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (camera != null) {
            this.hlK = new MediaRecorder();
            this.hlK.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.hlK.setCamera(camera);
            this.hlK.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.gOY != null) {
                        VideoPreviewView.this.gOY.ab(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.hlK.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.hlK.setVideoSource(1);
            this.hlK.setAudioSource(1);
            this.hlK.setOutputFormat(2);
            this.hlK.setVideoEncoder(2);
            this.hlK.setAudioEncoder(3);
            this.hlK.setAudioSamplingRate(48000);
            this.hlK.setAudioChannels(1);
            this.hlK.setVideoEncodingBitRate(2097152);
            this.hlK.setVideoFrameRate(20);
            if (this.him.hiP) {
                this.hlK.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.hlK.setOrientationHint(90);
            }
            this.hlK.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.hbD);
            if (!com.baidu.tbadk.core.util.l.dR(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.hlK.setOutputFile(this.him.bCt());
            try {
                this.hlK.prepare();
                this.hlK.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gOY != null) {
                    this.gOY.ab(28, com.baidu.tieba.j.a.m(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        if (this.hlK != null) {
            try {
                this.hlK.stop();
                this.hlK.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gOY != null) {
                    this.gOY.ab(29, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        if (this.hlL) {
            this.hlL = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.him.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hlN) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hlN = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hit = aVar;
        this.hlN = true;
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
                    return com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hbG, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.hit != null) {
                    VideoPreviewView.this.hit.q(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
