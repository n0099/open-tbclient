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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.record.h;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.faceunity.a.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class n extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, h {
    private int dxa;
    private int dxb;
    private com.baidu.tieba.i.h gZj;
    private i htn;
    private h.a htu;
    private MediaRecorder hwM;
    private boolean hwN;
    private boolean hwO;
    private boolean hwP;
    private SurfaceHolder mSurfaceHolder;

    public n(Context context, i iVar) {
        super(context);
        this.dxa = 720;
        this.dxb = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        this.htn = iVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bCs();
        this.hwO = true;
    }

    private void bCs() {
        Handler mainHandler = this.htn.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hwO) {
            bCs();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (!this.hwN && camera != null) {
            this.hwN = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gZj != null) {
                    this.gZj.R(27, com.baidu.tieba.i.a.i(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        if (camera != null) {
            this.hwM = new MediaRecorder();
            this.hwM.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.hwM.setCamera(camera);
            this.hwM.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.n.1
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
                    if (n.this.gZj != null) {
                        n.this.gZj.R(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.hwM.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.hwM.setVideoSource(1);
            this.hwM.setAudioSource(1);
            this.hwM.setOutputFormat(2);
            this.hwM.setVideoEncoder(2);
            this.hwM.setAudioEncoder(3);
            this.hwM.setAudioSamplingRate(48000);
            this.hwM.setAudioChannels(1);
            this.hwM.setVideoEncodingBitRate(2097152);
            this.hwM.setVideoFrameRate(20);
            if (this.htn.htR) {
                this.hwM.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.hwM.setOrientationHint(90);
            }
            this.hwM.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.hmh);
            if (!com.baidu.tbadk.core.util.k.m12do(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.hwM.setOutputFile(this.htn.bCv());
            try {
                this.hwM.prepare();
                this.hwM.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gZj != null) {
                    this.gZj.R(28, com.baidu.tieba.i.a.i(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        if (this.hwM != null) {
            try {
                this.hwM.stop();
                this.hwM.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gZj != null) {
                    this.gZj.R(29, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        if (this.hwN) {
            this.hwN = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.htn.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hwP) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hwP = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.htu = aVar;
        this.hwP = true;
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void k(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.n.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.j(bArr, i, i2);
                    if (i > i2) {
                        Bitmap a = com.baidu.tieba.video.editvideo.b.c.a(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && a != null) {
                            bitmap.recycle();
                            bitmap = a;
                        }
                    }
                    return com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hmk, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (n.this.htu != null) {
                    n.this.htu.n(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
