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
    private int cTU;
    private int cTV;
    private h gRr;
    private g.a gRy;
    private MediaRecorder gUO;
    private boolean gUP;
    private boolean gUQ;
    private boolean gUR;
    private com.baidu.tieba.j.h gyx;
    private SurfaceHolder mSurfaceHolder;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.cTU = 720;
        this.cTV = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        this.gRr = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bxZ();
        this.gUQ = true;
    }

    private void bxZ() {
        Handler mainHandler = this.gRr.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gUQ) {
            bxZ();
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
        if (!this.gUP && camera != null) {
            this.gUP = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gyx != null) {
                    this.gyx.ac(27, com.baidu.tieba.j.a.g(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (camera != null) {
            this.gUO = new MediaRecorder();
            this.gUO.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gUO.setCamera(camera);
            this.gUO.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.gyx != null) {
                        VideoPreviewView.this.gyx.ac(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.gUO.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gUO.setVideoSource(1);
            this.gUO.setAudioSource(1);
            this.gUO.setOutputFormat(2);
            this.gUO.setVideoEncoder(2);
            this.gUO.setAudioEncoder(3);
            this.gUO.setAudioSamplingRate(48000);
            this.gUO.setAudioChannels(1);
            this.gUO.setVideoEncodingBitRate(2097152);
            this.gUO.setVideoFrameRate(20);
            if (this.gRr.gRU) {
                this.gUO.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gUO.setOrientationHint(90);
            }
            this.gUO.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gKJ);
            if (!com.baidu.tbadk.core.util.k.dr(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gUO.setOutputFile(this.gRr.byb());
            try {
                this.gUO.prepare();
                this.gUO.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gyx != null) {
                    this.gyx.ac(28, com.baidu.tieba.j.a.g(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        if (this.gUO != null) {
            try {
                this.gUO.stop();
                this.gUO.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gyx != null) {
                    this.gyx.ac(29, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        if (this.gUP) {
            this.gUP = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gRr.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.gUR) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.gUR = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.gRy = aVar;
        this.gUR = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void k(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
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
                    return com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gKM, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.gRy != null) {
                    VideoPreviewView.this.gRy.p(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
