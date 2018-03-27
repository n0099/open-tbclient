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
import com.baidu.tieba.video.record.h;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.faceunity.a.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class n extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, h {
    private int dAe;
    private int dAf;
    private com.baidu.tieba.i.h hca;
    private i hvh;
    private h.a hvo;
    private MediaRecorder hyF;
    private boolean hyG;
    private boolean hyH;
    private boolean hyI;
    private SurfaceHolder mSurfaceHolder;

    public n(Context context, i iVar) {
        super(context);
        this.dAe = 720;
        this.dAf = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        this.hvh = iVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bDh();
        this.hyH = true;
    }

    private void bDh() {
        Handler mainHandler = this.hvh.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hyH) {
            bDh();
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
        if (!this.hyG && camera != null) {
            this.hyG = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.hca != null) {
                    this.hca.U(27, com.baidu.tieba.i.a.i(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        if (camera != null) {
            this.hyF = new MediaRecorder();
            this.hyF.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.hyF.setCamera(camera);
            this.hyF.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.n.1
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
                    if (n.this.hca != null) {
                        n.this.hca.U(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.hyF.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.hyF.setVideoSource(1);
            this.hyF.setAudioSource(1);
            this.hyF.setOutputFormat(2);
            this.hyF.setVideoEncoder(2);
            this.hyF.setAudioEncoder(3);
            this.hyF.setAudioSamplingRate(48000);
            this.hyF.setAudioChannels(1);
            this.hyF.setVideoEncodingBitRate(2097152);
            this.hyF.setVideoFrameRate(20);
            if (this.hvh.hvK) {
                this.hyF.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.hyF.setOrientationHint(90);
            }
            this.hyF.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.hob);
            if (!com.baidu.tbadk.core.util.k.dz(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.hyF.setOutputFile(this.hvh.bDk());
            try {
                this.hyF.prepare();
                this.hyF.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.hca != null) {
                    this.hca.U(28, com.baidu.tieba.i.a.i(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        if (this.hyF != null) {
            try {
                this.hyF.stop();
                this.hyF.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hca != null) {
                    this.hca.U(29, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        if (this.hyG) {
            this.hyG = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hvh.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hyI) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hyI = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.hvo = aVar;
        this.hyI = true;
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
    }

    private void k(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.n.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
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
                    return com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hoe, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (n.this.hvo != null) {
                    n.this.hvo.n(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
