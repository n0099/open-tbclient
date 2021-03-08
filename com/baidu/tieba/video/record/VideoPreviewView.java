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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.video.record.g;
import com.faceunity.a.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private MediaRecorder cKJ;
    private SurfaceHolder mSurfaceHolder;
    private com.baidu.tieba.l.g nAz;
    private g.a nSB;
    private h nSw;
    private boolean nVN;
    private boolean nVO;
    private boolean nVP;
    private int previewHeight;
    private int previewWidth;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.previewWidth = 720;
        this.previewHeight = 960;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nAz = kVar.dho();
        }
        this.nSw = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        dUb();
        this.nVO = true;
    }

    private void dUb() {
        Handler mainHandler = this.nSw.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.nVO) {
            dUb();
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
        if (!this.nVN && camera != null) {
            this.nVN = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.nAz != null) {
                    this.nAz.bK(27, com.baidu.tieba.l.a.o(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.cKJ = new MediaRecorder();
            this.cKJ.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.cKJ.setCamera(camera);
            this.cKJ.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.nAz != null) {
                        VideoPreviewView.this.nAz.bK(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.cKJ.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.cKJ.setVideoSource(1);
            this.cKJ.setAudioSource(1);
            this.cKJ.setOutputFormat(2);
            this.cKJ.setVideoEncoder(2);
            this.cKJ.setAudioEncoder(3);
            this.cKJ.setAudioSamplingRate(48000);
            this.cKJ.setAudioChannels(1);
            this.cKJ.setVideoEncodingBitRate(2097152);
            this.cKJ.setVideoFrameRate(20);
            if (this.nSw.mFrontCamera) {
                this.cKJ.setOrientationHint(270);
            } else {
                this.cKJ.setOrientationHint(90);
            }
            this.cKJ.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.nMR);
            if (!o.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.cKJ.setOutputFile(this.nSw.dUd());
            try {
                this.cKJ.prepare();
                this.cKJ.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.nAz != null) {
                    this.nAz.bK(28, com.baidu.tieba.l.a.o(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.cKJ != null) {
            try {
                this.cKJ.stop();
                this.cKJ.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nAz != null) {
                    this.nAz.bK(29, com.baidu.tieba.l.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.nVN) {
            this.nVN = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nSw.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.nVP) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                t(bArr, previewSize.width, previewSize.height);
            }
            this.nVP = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nSB = aVar;
        this.nVP = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void t(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.s(bArr, i, i2);
                    if (i > i2) {
                        Bitmap rotateBitmap = com.baidu.tieba.video.editvideo.b.c.rotateBitmap(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && rotateBitmap != null) {
                            bitmap.recycle();
                            bitmap = rotateBitmap;
                        }
                    }
                    return o.saveFileAsPic(com.baidu.tieba.video.c.nMU, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.nSB != null) {
                    VideoPreviewView.this.nSB.O(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
