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
    private MediaRecorder bgb;
    private h kAU;
    private g.a kAZ;
    private boolean kEk;
    private boolean kEl;
    private boolean kEm;
    private com.baidu.tieba.k.h khN;
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
            this.khN = lVar.cgY();
        }
        this.kAU = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        cRg();
        this.kEl = true;
    }

    private void cRg() {
        Handler mainHandler = this.kAU.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.kEl) {
            cRg();
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
        if (!this.kEk && camera != null) {
            this.kEk = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.khN != null) {
                    this.khN.aP(27, com.baidu.tieba.k.a.q(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.bgb = new MediaRecorder();
            this.bgb.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.bgb.setCamera(camera);
            this.bgb.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.khN != null) {
                        VideoPreviewView.this.khN.aP(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.bgb.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.bgb.setVideoSource(1);
            this.bgb.setAudioSource(1);
            this.bgb.setOutputFormat(2);
            this.bgb.setVideoEncoder(2);
            this.bgb.setAudioEncoder(3);
            this.bgb.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.bgb.setAudioChannels(1);
            this.bgb.setVideoEncodingBitRate(2097152);
            this.bgb.setVideoFrameRate(20);
            if (this.kAU.mFrontCamera) {
                this.bgb.setOrientationHint(270);
            } else {
                this.bgb.setOrientationHint(90);
            }
            this.bgb.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.kuN);
            if (!com.baidu.tbadk.core.util.m.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.bgb.setOutputFile(this.kAU.cRi());
            try {
                this.bgb.prepare();
                this.bgb.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.khN != null) {
                    this.khN.aP(28, com.baidu.tieba.k.a.q(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.bgb != null) {
            try {
                this.bgb.stop();
                this.bgb.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.khN != null) {
                    this.khN.aP(29, com.baidu.tieba.k.a.q(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.kEk) {
            this.kEk = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kAU.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.kEm) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                n(bArr, previewSize.width, previewSize.height);
            }
            this.kEm = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.kAZ = aVar;
        this.kEm = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void n(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.m(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a != null) {
                            bitmap.recycle();
                            bitmap = a;
                        }
                    }
                    return com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.kuQ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.kAZ != null) {
                    VideoPreviewView.this.kAZ.z(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
