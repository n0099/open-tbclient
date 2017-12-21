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
    private int cDl;
    private int cDm;
    private com.baidu.tieba.i.h gCU;
    private i gWF;
    private h.a gWM;
    private MediaRecorder gxZ;
    private boolean haf;
    private boolean hag;
    private boolean hah;
    private SurfaceHolder mSurfaceHolder;

    public n(Context context, i iVar) {
        super(context);
        this.cDl = 720;
        this.cDm = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        this.gWF = iVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bDw();
        this.hag = true;
    }

    private void bDw() {
        Handler mainHandler = this.gWF.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.hag) {
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
        if (!this.haf && camera != null) {
            this.haf = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gCU != null) {
                    this.gCU.Q(27, com.baidu.tieba.i.a.g(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        if (camera != null) {
            this.gxZ = new MediaRecorder();
            this.gxZ.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gxZ.setCamera(camera);
            this.gxZ.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.n.1
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
                    if (n.this.gCU != null) {
                        n.this.gCU.Q(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.gxZ.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gxZ.setVideoSource(1);
            this.gxZ.setAudioSource(1);
            this.gxZ.setOutputFormat(2);
            this.gxZ.setVideoEncoder(2);
            this.gxZ.setAudioEncoder(3);
            this.gxZ.setAudioSamplingRate(48000);
            this.gxZ.setAudioChannels(1);
            this.gxZ.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
            this.gxZ.setVideoFrameRate(20);
            if (this.gWF.gXj) {
                this.gxZ.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gxZ.setOrientationHint(90);
            }
            this.gxZ.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gPG);
            if (!com.baidu.tbadk.core.util.k.dh(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gxZ.setOutputFile(this.gWF.bDz());
            try {
                this.gxZ.prepare();
                this.gxZ.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gCU != null) {
                    this.gCU.Q(28, com.baidu.tieba.i.a.g(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        if (this.gxZ != null) {
            try {
                this.gxZ.stop();
                this.gxZ.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gCU != null) {
                    this.gCU.Q(29, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        if (this.haf) {
            this.haf = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gWF.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.hah) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.hah = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.gWM = aVar;
        this.hah = true;
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(c.InterfaceC0166c interfaceC0166c) {
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
                    return com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gPJ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (n.this.gWM != null) {
                    n.this.gWM.s(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
