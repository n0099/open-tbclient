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
    private int cSQ;
    private int cSR;
    private h gQq;
    private g.a gQx;
    private MediaRecorder gTN;
    private boolean gTO;
    private boolean gTP;
    private boolean gTQ;
    private com.baidu.tieba.j.h gxw;
    private SurfaceHolder mSurfaceHolder;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.cSQ = 720;
        this.cSR = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        this.gQq = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        byb();
        this.gTP = true;
    }

    private void byb() {
        Handler mainHandler = this.gQq.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gTP) {
            byb();
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
        if (!this.gTO && camera != null) {
            this.gTO = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gxw != null) {
                    this.gxw.ac(27, com.baidu.tieba.j.a.g(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (camera != null) {
            this.gTN = new MediaRecorder();
            this.gTN.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gTN.setCamera(camera);
            this.gTN.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.gxw != null) {
                        VideoPreviewView.this.gxw.ac(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.gTN.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gTN.setVideoSource(1);
            this.gTN.setAudioSource(1);
            this.gTN.setOutputFormat(2);
            this.gTN.setVideoEncoder(2);
            this.gTN.setAudioEncoder(3);
            this.gTN.setAudioSamplingRate(48000);
            this.gTN.setAudioChannels(1);
            this.gTN.setVideoEncodingBitRate(2097152);
            this.gTN.setVideoFrameRate(20);
            if (this.gQq.gQT) {
                this.gTN.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gTN.setOrientationHint(90);
            }
            this.gTN.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gJJ);
            if (!com.baidu.tbadk.core.util.k.dr(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gTN.setOutputFile(this.gQq.byd());
            try {
                this.gTN.prepare();
                this.gTN.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gxw != null) {
                    this.gxw.ac(28, com.baidu.tieba.j.a.g(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        if (this.gTN != null) {
            try {
                this.gTN.stop();
                this.gTN.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gxw != null) {
                    this.gxw.ac(29, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        if (this.gTO) {
            this.gTO = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gQq.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.gTQ) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.gTQ = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.gQx = aVar;
        this.gTQ = true;
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
                    return com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gJM, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.gQx != null) {
                    VideoPreviewView.this.gQx.p(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
