package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.faceunity.a.c;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class f extends GLSurfaceView implements g {
    private static int gyX = 720;
    private static int gyY = TbConfig.HEAD_IMG_SIZE;
    private static boolean gzc;
    protected h gyZ;
    private a gza;
    private com.faceunity.a.c gzb;

    public f(Context context, h hVar) {
        super(context);
        this.gyZ = hVar;
        this.gza = new a(context, this);
        setEGLContextClientVersion(2);
        setRenderer(this.gza);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void d(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gza);
                camera.setPreviewTexture(this.gza.gzg);
                this.gza.gzg.setOnFrameAvailableListener(this.gza);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        try {
            this.gzb = new com.faceunity.a.c();
            this.gza.a(this.gzb);
            gzc = false;
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            if (this.gzb != null) {
                this.gzb.stopRecording();
                this.gzb = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            this.gza.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        this.gza.gzi = i;
        this.gza.gzj = i2;
        gyY = i;
        gyX = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gyZ == null) {
            return false;
        }
        return this.gyZ.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gza == null) {
            return;
        }
        this.gza.bxa();
    }

    public void bwX() {
        if (this.gza == null) {
            return;
        }
        this.gza.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gza != null) {
            this.gza.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gza != null) {
            this.gza.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gza != null) {
            this.gza.setSticker(stickerItem);
        }
    }

    public void bwY() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gza != null) {
                    f.this.gza.bwY();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gza.gzt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gyZ.getMainHandler();
    }

    /* loaded from: classes2.dex */
    private static class a implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c gze;
        private com.faceunity.gles.c gzf;
        private volatile SurfaceTexture gzg;
        private f gzh;
        private int gzk;
        private Handler gzo;
        private boolean gzp;
        private boolean gzq;
        com.faceunity.a.c gzr;
        String gzs;
        private boolean gzt;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int gzi = 720;
        protected int gzj = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gzl = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gzl};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gzm = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gzn = new HandlerThread("CreateItemThread");

        public a(Context context, f fVar) {
            this.gzh = fVar;
            this.gzn.start();
            this.gzo = new HandlerC0136a(this.gzn.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.uq(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bxa() {
            this.gzo.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gzh.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gze = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gzf = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gzk = this.gzf.createTextureObject();
            bwY();
            boolean unused = f.gzc = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        public void bwY() {
            if (this.gzg != null) {
                faceunity.fuOnCameraChange();
                this.gzg.release();
            }
            this.gzg = new SurfaceTexture(this.gzk);
            bxb();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gtP;
                this.mFacebeautyBlurLevel = aVar.gtQ;
                this.mFacebeautyCheeckThin = aVar.gtR;
                this.mFacebeautyEnlargeEye = aVar.gtS;
                this.mFacebeautyRedLevel = aVar.gtT;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gzt) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gzm = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gzg.updateTexImage();
                    this.gzg.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gzo.sendEmptyMessage(1);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gzq) {
                    this.gzh.requestRender();
                    return;
                }
                int i2 = (this.gzh.gyZ.mCameraId != 1 ? 32 : 0) | 1;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gzk;
                int i4 = this.gzi;
                int i5 = this.gzj;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.gzm = (System.currentTimeMillis() - currentTimeMillis) + this.gzm;
                this.gze.drawFrame(fuDualInputToTexture, fArr);
                try {
                    if (this.gzr != null && this.gzr.vT(2) && this.gzh.gyZ != null) {
                        this.gzs = this.gzh.gyZ.bxd();
                        this.gzr.a(new c.b(new File(this.gzs), f.gyX, f.gyY, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, null, this.gzg.getTimestamp()));
                    }
                    if (this.gzr != null && this.gzr.vT(1)) {
                        this.gzr.a(this.gze, fuDualInputToTexture, fArr);
                        if (f.gzc) {
                            this.gzr.c(this.gzg);
                        }
                        boolean unused = f.gzc = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gzh.f(null);
                }
            }
        }

        public void a(com.faceunity.a.c cVar) {
            if (cVar != null) {
                this.gzr = cVar;
            }
        }

        /* renamed from: com.baidu.tieba.video.record.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class HandlerC0136a extends Handler {
            WeakReference<Context> gzv;

            HandlerC0136a(Looper looper, Context context) {
                super(looper);
                this.gzv = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Context context = this.gzv.get();
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        try {
                            if (StringUtils.isNull(a.this.mEffectFileName)) {
                                a.this.itemsArray[1] = a.this.mEffectItem = 0;
                                a.this.itemsArray[2] = a.this.gzl = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(a.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = a.this.itemsArray[1] != 0 ? a.this.itemsArray[1] : a.this.itemsArray[2];
                            if (a.this.gzp) {
                                a.this.gzl = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[2] = a.this.gzl;
                                a.this.mEffectItem = 0;
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                faceunity.fuItemSetParam(a.this.gzl, "isAndroid", 1.0d);
                            } else {
                                a.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                a.this.gzl = 0;
                                a.this.itemsArray[2] = a.this.gzl;
                                faceunity.fuItemSetParam(a.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    case 2:
                        try {
                            InputStream open = context.getAssets().open("beauty/v3.mp3");
                            byte[] bArr2 = new byte[open.available()];
                            open.read(bArr2);
                            open.close();
                            faceunity.fuSetup(bArr2, null, e.A());
                            a.this.gzq = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            a.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            a.this.itemsArray[0] = a.this.mFacebeautyItem;
                            a.this.gzq = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            }
        }

        public void releaseResource() {
            this.gzh.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gze != null) {
                        a.this.gze.release(false);
                        a.this.gze = null;
                    }
                    if (a.this.gzf != null) {
                        a.this.gzf.release(false);
                        a.this.gzf = null;
                    }
                    if (a.this.gzg != null) {
                        a.this.gzg.release();
                        a.this.gzg = null;
                    }
                    faceunity.fuDestroyItem(a.this.mEffectItem);
                    a.this.itemsArray[1] = a.this.mEffectItem = 0;
                    faceunity.fuDestroyItem(a.this.mFacebeautyItem);
                    a.this.itemsArray[0] = a.this.mFacebeautyItem = 0;
                    faceunity.fuOnDeviceLost();
                    a.this.mCameraNV21Byte = null;
                    a.this.isNeedEffectItem = true;
                }
            });
        }

        private void bxb() {
            if (this.gzh != null) {
                Handler mainHandler = this.gzh.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gzp = false;
                } else {
                    this.gzp = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gzo.sendEmptyMessage(1);
        }
    }
}
