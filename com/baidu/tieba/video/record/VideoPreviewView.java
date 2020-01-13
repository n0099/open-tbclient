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
/* loaded from: classes8.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private MediaRecorder bbM;
    private boolean kDi;
    private boolean kDj;
    private boolean kDk;
    private com.baidu.tieba.j.h kgF;
    private h kzS;
    private g.a kzX;
    private SurfaceHolder mSurfaceHolder;
    private int previewHeight;
    private int previewWidth;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kgF = lVar.cfr();
        }
        this.kzS = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        cPJ();
        this.kDj = true;
    }

    private void cPJ() {
        Handler mainHandler = this.kzS.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.kDj) {
            cPJ();
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
        if (!this.kDi && camera != null) {
            this.kDi = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.kgF != null) {
                    this.kgF.aP(27, com.baidu.tieba.j.a.r(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.bbM = new MediaRecorder();
            this.bbM.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.bbM.setCamera(camera);
            this.bbM.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.kgF != null) {
                        VideoPreviewView.this.kgF.aP(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.bbM.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.bbM.setVideoSource(1);
            this.bbM.setAudioSource(1);
            this.bbM.setOutputFormat(2);
            this.bbM.setVideoEncoder(2);
            this.bbM.setAudioEncoder(3);
            this.bbM.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.bbM.setAudioChannels(1);
            this.bbM.setVideoEncodingBitRate(2097152);
            this.bbM.setVideoFrameRate(20);
            if (this.kzS.mFrontCamera) {
                this.bbM.setOrientationHint(270);
            } else {
                this.bbM.setOrientationHint(90);
            }
            this.bbM.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.c.ktJ);
            if (!com.baidu.tbadk.core.util.m.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.bbM.setOutputFile(this.kzS.cPL());
            try {
                this.bbM.prepare();
                this.bbM.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.kgF != null) {
                    this.kgF.aP(28, com.baidu.tieba.j.a.r(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.bbM != null) {
            try {
                this.bbM.stop();
                this.bbM.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kgF != null) {
                    this.kgF.aP(29, com.baidu.tieba.j.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.kDi) {
            this.kDi = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kzS.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.kDk) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                j(bArr, previewSize.width, previewSize.height);
            }
            this.kDk = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.kzX = aVar;
        this.kDk = true;
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void j(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.VideoPreviewView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.i(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a != null) {
                            bitmap.recycle();
                            bitmap = a;
                        }
                    }
                    return com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.ktM, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.kzX != null) {
                    VideoPreviewView.this.kzX.z(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
