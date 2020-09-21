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
/* loaded from: classes22.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private int bPI;
    private int bPJ;
    private MediaRecorder caP;
    private h mKh;
    private g.a mKm;
    private boolean mNA;
    private boolean mNy;
    private boolean mNz;
    private SurfaceHolder mSurfaceHolder;
    private com.baidu.tieba.k.h mpU;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.bPI = 720;
        this.bPJ = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
        }
        this.mKh = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        dGZ();
        this.mNz = true;
    }

    private void dGZ() {
        Handler mainHandler = this.mKh.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.mNz) {
            dGZ();
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
        if (!this.mNy && camera != null) {
            this.mNy = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.mpU != null) {
                    this.mpU.bq(27, com.baidu.tieba.k.a.r(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.caP = new MediaRecorder();
            this.caP.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.caP.setCamera(camera);
            this.caP.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.mpU != null) {
                        VideoPreviewView.this.mpU.bq(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.caP.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.caP.setVideoSource(1);
            this.caP.setAudioSource(1);
            this.caP.setOutputFormat(2);
            this.caP.setVideoEncoder(2);
            this.caP.setAudioEncoder(3);
            this.caP.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.caP.setAudioChannels(1);
            this.caP.setVideoEncodingBitRate(2097152);
            this.caP.setVideoFrameRate(20);
            if (this.mKh.mFrontCamera) {
                this.caP.setOrientationHint(270);
            } else {
                this.caP.setOrientationHint(90);
            }
            this.caP.setVideoSize(PlatformPlugin.DEFAULT_SYSTEM_UI, 720);
            File file = new File(com.baidu.tieba.video.c.mDD);
            if (!n.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.caP.setOutputFile(this.mKh.dHb());
            try {
                this.caP.prepare();
                this.caP.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.mpU != null) {
                    this.mpU.bq(28, com.baidu.tieba.k.a.r(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.caP != null) {
            try {
                this.caP.stop();
                this.caP.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mpU != null) {
                    this.mpU.bq(29, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.mNy) {
            this.mNy = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mKh.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.mNA) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                s(bArr, previewSize.width, previewSize.height);
            }
            this.mNA = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mKm = aVar;
        this.mNA = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void s(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.r(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a != null) {
                            bitmap.recycle();
                            bitmap = a;
                        }
                    }
                    return n.saveFileAsPic(com.baidu.tieba.video.c.mDG, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.mKm != null) {
                    VideoPreviewView.this.mKm.D(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
