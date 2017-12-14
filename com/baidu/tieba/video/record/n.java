package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
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
import com.faceunity.a.c;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class n extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, h {
    private int cDh;
    private int cDi;
    private com.baidu.tieba.i.h gCP;
    private i gWA;
    private h.a gWH;
    private MediaRecorder gxU;
    private boolean haa;
    private boolean hab;
    private boolean hac;
    private SurfaceHolder mSurfaceHolder;

    public n(Context context, i iVar) {
        super(context);
        this.cDh = 720;
        this.cDi = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOk();
        }
        this.gWA = iVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bDw();
        this.hab = true;
    }

    private void bDw() {
        Handler mainHandler = this.gWA.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hab) {
            bDw();
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
        if (!this.haa && camera != null) {
            this.haa = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gCP != null) {
                    this.gCP.Q(27, com.baidu.tieba.i.a.g(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        if (camera != null) {
            this.gxU = new MediaRecorder();
            this.gxU.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gxU.setCamera(camera);
            this.gxU.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.n.1
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
                    if (n.this.gCP != null) {
                        n.this.gCP.Q(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.gxU.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gxU.setVideoSource(1);
            this.gxU.setAudioSource(1);
            this.gxU.setOutputFormat(2);
            this.gxU.setVideoEncoder(2);
            this.gxU.setAudioEncoder(3);
            this.gxU.setAudioSamplingRate(48000);
            this.gxU.setAudioChannels(1);
            this.gxU.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
            this.gxU.setVideoFrameRate(20);
            if (this.gWA.gXe) {
                this.gxU.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gxU.setOrientationHint(90);
            }
            this.gxU.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gPB);
            if (!com.baidu.tbadk.core.util.k.dh(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gxU.setOutputFile(this.gWA.bDz());
            try {
                this.gxU.prepare();
                this.gxU.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gCP != null) {
                    this.gCP.Q(28, com.baidu.tieba.i.a.g(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        if (this.gxU != null) {
            try {
                this.gxU.stop();
                this.gxU.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gCP != null) {
                    this.gCP.Q(29, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        if (this.haa) {
            this.haa = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gWA.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hac) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hac = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.gWH = aVar;
        this.hac = true;
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(c.InterfaceC0167c interfaceC0167c) {
    }

    private void k(final byte[] bArr, final int i, final int i2) {
        new BdAsyncTask<Void, Void, String>() { // from class: com.baidu.tieba.video.record.n.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: f */
            public String doInBackground(Void... voidArr) {
                Bitmap bitmap = null;
                try {
                    bitmap = com.baidu.tieba.video.editvideo.b.c.j(bArr, i, i2);
                    if (i > i2) {
                        Bitmap b = com.baidu.tieba.video.editvideo.b.c.b(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && b != null) {
                            bitmap.recycle();
                            bitmap = b;
                        }
                    }
                    return com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gPE, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (n.this.gWH != null) {
                    n.this.gWH.s(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
