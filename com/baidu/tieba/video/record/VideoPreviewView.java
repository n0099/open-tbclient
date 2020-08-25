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
/* loaded from: classes17.dex */
public class VideoPreviewView extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, g {
    private int bNE;
    private int bNF;
    private MediaRecorder bYK;
    private g.a mAe;
    private boolean mDt;
    private boolean mDu;
    private boolean mDv;
    private SurfaceHolder mSurfaceHolder;
    private com.baidu.tieba.k.h mgf;
    private h mzZ;

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        this.bNE = 720;
        this.bNF = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mgf = lVar.cRt();
        }
        this.mzZ = hVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        dCW();
        this.mDu = true;
    }

    private void dCW() {
        Handler mainHandler = this.mzZ.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.mDu) {
            dCW();
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
        if (!this.mDt && camera != null) {
            this.mDt = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.mgf != null) {
                    this.mgf.bn(27, com.baidu.tieba.k.a.r(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        if (camera != null) {
            this.bYK = new MediaRecorder();
            this.bYK.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.bYK.setCamera(camera);
            this.bYK.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.VideoPreviewView.1
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
                    if (VideoPreviewView.this.mgf != null) {
                        VideoPreviewView.this.mgf.bn(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.bYK.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.bYK.setVideoSource(1);
            this.bYK.setAudioSource(1);
            this.bYK.setOutputFormat(2);
            this.bYK.setVideoEncoder(2);
            this.bYK.setAudioEncoder(3);
            this.bYK.setAudioSamplingRate(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
            this.bYK.setAudioChannels(1);
            this.bYK.setVideoEncodingBitRate(2097152);
            this.bYK.setVideoFrameRate(20);
            if (this.mzZ.mFrontCamera) {
                this.bYK.setOrientationHint(270);
            } else {
                this.bYK.setOrientationHint(90);
            }
            this.bYK.setVideoSize(PlatformPlugin.DEFAULT_SYSTEM_UI, 720);
            File file = new File(com.baidu.tieba.video.c.mtA);
            if (!n.CheckTempDir(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.bYK.setOutputFile(this.mzZ.dCY());
            try {
                this.bYK.prepare();
                this.bYK.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.mgf != null) {
                    this.mgf.bn(28, com.baidu.tieba.k.a.r(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (this.bYK != null) {
            try {
                this.bYK.stop();
                this.bYK.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mgf != null) {
                    this.mgf.bn(29, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        if (this.mDt) {
            this.mDt = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mzZ.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.mDv) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                s(bArr, previewSize.width, previewSize.height);
            }
            this.mDv = false;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mAe = aVar;
        this.mDv = true;
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
                    return n.saveFileAsPic(com.baidu.tieba.video.c.mtD, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (VideoPreviewView.this.mAe != null) {
                    VideoPreviewView.this.mAe.D(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
