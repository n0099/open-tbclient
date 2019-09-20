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
/* loaded from: classes5.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private MediaRecorder amc;
    private h jDA;
    private g.a jDF;
    private boolean jGY;
    private boolean jGZ;
    private boolean jHa;
    private com.baidu.tieba.j.h jjR;
    private SurfaceHolder mSurfaceHolder;
    private int previewHeight;
    private int previewWidth;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        this.jDA = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        cwZ();
        this.jGZ = true;
    }

    private void cwZ() {
        Handler mainHandler = this.jDA.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.jGZ) {
            cwZ();
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
        if (!this.jGY && camera != null) {
            this.jGY = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.jjR != null) {
                    this.jjR.av(27, com.baidu.tieba.j.a.p(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.amc = new MediaRecorder();
            this.amc.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.amc.setCamera(camera);
            this.amc.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.jjR != null) {
                        VideoPreviewView.this.jjR.av(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.amc.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.amc.setVideoSource(1);
            this.amc.setAudioSource(1);
            this.amc.setOutputFormat(2);
            this.amc.setVideoEncoder(2);
            this.amc.setAudioEncoder(3);
            this.amc.setAudioSamplingRate(48000);
            this.amc.setAudioChannels(1);
            this.amc.setVideoEncodingBitRate(2097152);
            this.amc.setVideoFrameRate(20);
            if (this.jDA.adC) {
                this.amc.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.amc.setOrientationHint(90);
            }
            this.amc.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.jxc);
            if (!com.baidu.tbadk.core.util.m.nj(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.amc.setOutputFile(this.jDA.cxb());
            try {
                this.amc.prepare();
                this.amc.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.jjR != null) {
                    this.jjR.av(28, com.baidu.tieba.j.a.p(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.amc != null) {
            try {
                this.amc.stop();
                this.amc.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jjR != null) {
                    this.jjR.av(29, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.jGY) {
            this.jGY = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jDA.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.jHa) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                m(bArr, previewSize.width, previewSize.height);
            }
            this.jHa = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jDF = aVar;
        this.jHa = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void m(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.l(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a != null) {
                            bitmap.recycle();
                            bitmap = a;
                        }
                    }
                    return com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.jxf, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.jDF != null) {
                    VideoPreviewView.this.jDF.z(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
