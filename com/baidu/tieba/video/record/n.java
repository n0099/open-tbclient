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
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class n extends SurfaceView implements Camera.PreviewCallback, SurfaceHolder.Callback, h {
    private int cCZ;
    private int cDa;
    private com.baidu.tieba.i.h gAg;
    private i gTR;
    private h.a gTY;
    private boolean gXo;
    private boolean gXp;
    private boolean gXq;
    private MediaRecorder gvm;
    private SurfaceHolder mSurfaceHolder;

    public n(Context context, i iVar) {
        super(context);
        this.cCZ = 720;
        this.cDa = TbConfig.HEAD_IMG_SIZE;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        this.gTR = iVar;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        bCQ();
        this.gXp = true;
    }

    private void bCQ() {
        Handler mainHandler = this.gTR.getMainHandler();
        mainHandler.sendMessage(mainHandler.obtainMessage(1));
    }

    public void onResume() {
        if (this.gXp) {
            bCQ();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // com.baidu.tieba.video.record.h
    public void d(Camera camera) {
        if (!this.gXo && camera != null) {
            this.gXo = true;
            try {
                camera.setPreviewDisplay(this.mSurfaceHolder);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                if (this.gAg != null) {
                    this.gAg.Q(27, com.baidu.tieba.i.a.g(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void e(Camera camera) {
        if (camera != null) {
            this.gvm = new MediaRecorder();
            this.gvm.reset();
            try {
                camera.unlock();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.gvm.setCamera(camera);
            this.gvm.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.baidu.tieba.video.record.n.1
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
                    if (n.this.gAg != null) {
                        n.this.gAg.Q(28, "what-->" + i + "  extra-->" + i2);
                    }
                }
            });
            if (this.mSurfaceHolder != null) {
                this.gvm.setPreviewDisplay(this.mSurfaceHolder.getSurface());
            }
            this.gvm.setVideoSource(1);
            this.gvm.setAudioSource(1);
            this.gvm.setOutputFormat(2);
            this.gvm.setVideoEncoder(2);
            this.gvm.setAudioEncoder(3);
            this.gvm.setAudioSamplingRate(48000);
            this.gvm.setAudioChannels(1);
            this.gvm.setVideoEncodingBitRate(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
            this.gvm.setVideoFrameRate(20);
            if (this.gTR.gUv) {
                this.gvm.setOrientationHint(SubsamplingScaleImageView.ORIENTATION_270);
            } else {
                this.gvm.setOrientationHint(90);
            }
            this.gvm.setVideoSize(1280, 720);
            File file = new File(com.baidu.tieba.video.b.gMT);
            if (!com.baidu.tbadk.core.util.k.dh(file.getAbsolutePath())) {
                file.mkdirs();
            }
            this.gvm.setOutputFile(this.gTR.bCS());
            try {
                this.gvm.prepare();
                this.gvm.start();
            } catch (Throwable th2) {
                th2.printStackTrace();
                if (this.gAg != null) {
                    this.gAg.Q(28, com.baidu.tieba.i.a.g(th2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void f(Camera camera) {
        if (this.gvm != null) {
            try {
                this.gvm.stop();
                this.gvm.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gAg != null) {
                    this.gAg.Q(29, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (this.gXo) {
            this.gXo = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gTR.b(motionEvent, getParent());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.gXq) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                k(bArr, previewSize.width, previewSize.height);
            }
            this.gXq = false;
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.gTY = aVar;
        this.gXq = true;
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
                        Bitmap b = com.baidu.tieba.video.editvideo.b.c.b(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && b != null) {
                            bitmap.recycle();
                            bitmap = b;
                        }
                    }
                    return com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gMW, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                if (n.this.gTY != null) {
                    n.this.gTY.s(!TextUtils.isEmpty(str), str);
                }
            }
        }.execute(new Void[0]);
    }
}
