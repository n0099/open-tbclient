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
    private int chC;
    private int chD;
    private MediaRecorder cvI;
    private com.baidu.tieba.k.h mSh;
    private SurfaceHolder mSurfaceHolder;
    private h nmo;
    private g.a nmt;
    private boolean npG;
    private boolean npH;
    private boolean npI;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.chC = 720;
        this.chD = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mSh = lVar.dbR();
        }
        this.nmo = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        dNT();
        this.npH = true;
    }

    private void dNT() {
        Handler mainHandler = this.nmo.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.npH) {
            dNT();
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
        if (!this.npG && camera != null) {
            this.npG = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.mSh != null) {
                    this.mSh.bB(27, com.baidu.tieba.k.a.r(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.cvI = new MediaRecorder();
            this.cvI.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.cvI.setCamera(camera);
            this.cvI.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.mSh != null) {
                        VideoPreviewView.this.mSh.bB(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.cvI.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.cvI.setVideoSource(1);
            this.cvI.setAudioSource(1);
            this.cvI.setOutputFormat(2);
            this.cvI.setVideoEncoder(2);
            this.cvI.setAudioEncoder(3);
            this.cvI.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.cvI.setAudioChannels(1);
            this.cvI.setVideoEncodingBitRate(2097152);
            this.cvI.setVideoFrameRate(20);
            if (this.nmo.mFrontCamera) {
                this.cvI.setOrientationHint(270);
            } else {
                this.cvI.setOrientationHint(90);
            }
            this.cvI.setVideoSize(PlatformPlugin.DEFAULT_SYSTEM_UI, 720);
            File file = new File(com.baidu.tieba.video.c.nfR);
            if (!n.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.cvI.setOutputFile(this.nmo.dNV());
            try {
                this.cvI.prepare();
                this.cvI.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.mSh != null) {
                    this.mSh.bB(28, com.baidu.tieba.k.a.r(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.cvI != null) {
            try {
                this.cvI.stop();
                this.cvI.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mSh != null) {
                    this.mSh.bB(29, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.npG) {
            this.npG = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nmo.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.npI) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                u(bArr, previewSize.width, previewSize.height);
            }
            this.npI = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nmt = aVar;
        this.npI = true;
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
                    return n.saveFileAsPic(com.baidu.tieba.video.c.nfU, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.nmt != null) {
                    VideoPreviewView.this.nmt.F(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
