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
    private MediaRecorder cBB;
    private int cny;
    private int cnz;
    private SurfaceHolder mSurfaceHolder;
    private com.baidu.tieba.k.h mYk;
    private h nsl;
    private g.a nsq;
    private boolean nvB;
    private boolean nvC;
    private boolean nvD;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.cny = 720;
        this.cnz = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mYk = lVar.det();
        }
        this.nsl = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        dQv();
        this.nvC = true;
    }

    private void dQv() {
        Handler mainHandler = this.nsl.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.nvC) {
            dQv();
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
        if (!this.nvB && camera != null) {
            this.nvB = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.mYk != null) {
                    this.mYk.bF(27, com.baidu.tieba.k.a.r(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.cBB = new MediaRecorder();
            this.cBB.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.cBB.setCamera(camera);
            this.cBB.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.mYk != null) {
                        VideoPreviewView.this.mYk.bF(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.cBB.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.cBB.setVideoSource(1);
            this.cBB.setAudioSource(1);
            this.cBB.setOutputFormat(2);
            this.cBB.setVideoEncoder(2);
            this.cBB.setAudioEncoder(3);
            this.cBB.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.cBB.setAudioChannels(1);
            this.cBB.setVideoEncodingBitRate(2097152);
            this.cBB.setVideoFrameRate(20);
            if (this.nsl.mFrontCamera) {
                this.cBB.setOrientationHint(270);
            } else {
                this.cBB.setOrientationHint(90);
            }
            this.cBB.setVideoSize(PlatformPlugin.DEFAULT_SYSTEM_UI, 720);
            File file = new File(com.baidu.tieba.video.c.nlN);
            if (!n.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.cBB.setOutputFile(this.nsl.dQx());
            try {
                this.cBB.prepare();
                this.cBB.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.mYk != null) {
                    this.mYk.bF(28, com.baidu.tieba.k.a.r(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.cBB != null) {
            try {
                this.cBB.stop();
                this.cBB.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mYk != null) {
                    this.mYk.bF(29, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.nvB) {
            this.nvB = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nsl.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.nvD) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                u(bArr, previewSize.width, previewSize.height);
            }
            this.nvD = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nsq = aVar;
        this.nvD = true;
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
                    return n.saveFileAsPic(com.baidu.tieba.video.c.nlQ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.nsq != null) {
                    VideoPreviewView.this.nsq.F(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
