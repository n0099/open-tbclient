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
import com.faceunity.a.d;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.File;
import java.io.IOException;
/* loaded from: classes23.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private MediaRecorder cGJ;
    private SurfaceHolder mSurfaceHolder;
    private g.a nHB;
    private h nHw;
    private boolean nKL;
    private boolean nKM;
    private boolean nKN;
    private com.baidu.tieba.l.h nnd;
    private int previewHeight;
    private int previewWidth;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.nnd = lVar.djc();
        }
        this.nHw = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        dVP();
        this.nKM = true;
    }

    private void dVP() {
        Handler mainHandler = this.nHw.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.nKM) {
            dVP();
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
        if (!this.nKL && camera != null) {
            this.nKL = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.nnd != null) {
                    this.nnd.bD(27, com.baidu.tieba.l.a.r(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.cGJ = new MediaRecorder();
            this.cGJ.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.cGJ.setCamera(camera);
            this.cGJ.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.nnd != null) {
                        VideoPreviewView.this.nnd.bD(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.cGJ.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.cGJ.setVideoSource(1);
            this.cGJ.setAudioSource(1);
            this.cGJ.setOutputFormat(2);
            this.cGJ.setVideoEncoder(2);
            this.cGJ.setAudioEncoder(3);
            this.cGJ.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.cGJ.setAudioChannels(1);
            this.cGJ.setVideoEncodingBitRate(2097152);
            this.cGJ.setVideoFrameRate(20);
            if (this.nHw.mFrontCamera) {
                this.cGJ.setOrientationHint(270);
            } else {
                this.cGJ.setOrientationHint(90);
            }
            this.cGJ.setVideoSize(PlatformPlugin.DEFAULT_SYSTEM_UI, 720);
            File file = new File(com.baidu.tieba.video.c.nAZ);
            if (!n.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.cGJ.setOutputFile(this.nHw.dVR());
            try {
                this.cGJ.prepare();
                this.cGJ.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.nnd != null) {
                    this.nnd.bD(28, com.baidu.tieba.l.a.r(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.cGJ != null) {
            try {
                this.cGJ.stop();
                this.cGJ.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nnd != null) {
                    this.nnd.bD(29, com.baidu.tieba.l.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.nKL) {
            this.nKL = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nHw.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.nKN) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                u(bArr, previewSize.width, previewSize.height);
            }
            this.nKN = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nHB = aVar;
        this.nKN = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void u(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.t(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a2 = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a2 != null) {
                            bitmap.recycle();
                            bitmap = a2;
                        }
                    }
                    return n.saveFileAsPic(com.baidu.tieba.video.c.nBc, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.nHB != null) {
                    VideoPreviewView.this.nHB.G(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
