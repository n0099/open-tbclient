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
import com.baidu.ala.player.StreamConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.video.record.g;
import com.faceunity.a.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private MediaRecorder bNw;
    private h lFW;
    private g.a lGb;
    private boolean lJo;
    private boolean lJp;
    private boolean lJq;
    private com.baidu.tieba.k.h lmg;
    private SurfaceHolder mSurfaceHolder;
    private int previewHeight;
    private int previewWidth;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lmg = lVar.cyB();
        }
        this.lFW = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        djM();
        this.lJp = true;
    }

    private void djM() {
        Handler mainHandler = this.lFW.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.lJp) {
            djM();
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
        if (!this.lJo && camera != null) {
            this.lJo = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.lmg != null) {
                    this.lmg.bj(27, com.baidu.tieba.k.a.t(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.bNw = new MediaRecorder();
            this.bNw.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.bNw.setCamera(camera);
            this.bNw.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.lmg != null) {
                        VideoPreviewView.this.lmg.bj(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.bNw.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.bNw.setVideoSource(1);
            this.bNw.setAudioSource(1);
            this.bNw.setOutputFormat(2);
            this.bNw.setVideoEncoder(2);
            this.bNw.setAudioEncoder(3);
            this.bNw.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.bNw.setAudioChannels(1);
            this.bNw.setVideoEncodingBitRate(2097152);
            this.bNw.setVideoFrameRate(20);
            if (this.lFW.mFrontCamera) {
                this.bNw.setOrientationHint(270);
            } else {
                this.bNw.setOrientationHint(90);
            }
            this.bNw.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.lzF);
            if (!com.baidu.tbadk.core.util.m.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.bNw.setOutputFile(this.lFW.djO());
            try {
                this.bNw.prepare();
                this.bNw.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.lmg != null) {
                    this.lmg.bj(28, com.baidu.tieba.k.a.t(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.bNw != null) {
            try {
                this.bNw.stop();
                this.bNw.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lmg != null) {
                    this.lmg.bj(29, com.baidu.tieba.k.a.t(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.lJo) {
            this.lJo = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.lFW.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.lJq) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                q(bArr, previewSize.width, previewSize.height);
            }
            this.lJq = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.lGb = aVar;
        this.lJq = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void q(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.p(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a != null) {
                            bitmap.recycle();
                            bitmap = a;
                        }
                    }
                    return com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.lzI, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.lGb != null) {
                    VideoPreviewView.this.lGb.A(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
