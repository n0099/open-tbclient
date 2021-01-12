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
import com.baidu.ala.helper.StreamConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.video.record.g;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.faceunity.a.d;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private MediaRecorder cGO;
    private SurfaceHolder mSurfaceHolder;
    private h nGh;
    private g.a nGm;
    private boolean nJA;
    private boolean nJB;
    private boolean nJC;
    private com.baidu.tieba.l.g noh;
    private int previewHeight;
    private int previewWidth;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.noh = kVar.deY();
        }
        this.nGh = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        dRA();
        this.nJB = true;
    }

    private void dRA() {
        Handler mainHandler = this.nGh.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.nJB) {
            dRA();
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
        if (!this.nJA && camera != null) {
            this.nJA = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.noh != null) {
                    this.noh.bE(27, com.baidu.tieba.l.a.p(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.cGO = new MediaRecorder();
            this.cGO.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.cGO.setCamera(camera);
            this.cGO.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.noh != null) {
                        VideoPreviewView.this.noh.bE(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.cGO.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.cGO.setVideoSource(1);
            this.cGO.setAudioSource(1);
            this.cGO.setOutputFormat(2);
            this.cGO.setVideoEncoder(2);
            this.cGO.setAudioEncoder(3);
            this.cGO.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.cGO.setAudioChannels(1);
            this.cGO.setVideoEncodingBitRate(2097152);
            this.cGO.setVideoFrameRate(20);
            if (this.nGh.mFrontCamera) {
                this.cGO.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.cGO.setOrientationHint(90);
            }
            this.cGO.setVideoSize(PlatformPlugin.DEFAULT_SYSTEM_UI, 720);
            File file = new File(com.baidu.tieba.video.c.nAB);
            if (!n.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.cGO.setOutputFile(this.nGh.dRC());
            try {
                this.cGO.prepare();
                this.cGO.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.noh != null) {
                    this.noh.bE(28, com.baidu.tieba.l.a.p(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.cGO != null) {
            try {
                this.cGO.stop();
                this.cGO.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.noh != null) {
                    this.noh.bE(29, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.nJA) {
            this.nJA = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nGh.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.nJC) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                t(bArr, previewSize.width, previewSize.height);
            }
            this.nJC = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nGm = aVar;
        this.nJC = true;
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
                        Bitmap a2 = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a2 != null) {
                            bitmap.recycle();
                            bitmap = a2;
                        }
                    }
                    return n.saveFileAsPic(com.baidu.tieba.video.c.nAE, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.nGm != null) {
                    VideoPreviewView.this.nGm.G(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
