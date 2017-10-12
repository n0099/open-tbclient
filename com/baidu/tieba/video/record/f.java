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
    private static int gyW = 720;
    private static int gyX = TbConfig.HEAD_IMG_SIZE;
    private static boolean gzb;
    protected h gyY;
    private a gyZ;
    private com.faceunity.a.c gza;

    public f(Context context, h hVar) {
        super(context);
        this.gyY = hVar;
        this.gyZ = new a(context, this);
        setEGLContextClientVersion(2);
        setRenderer(this.gyZ);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void d(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gyZ);
                camera.setPreviewTexture(this.gyZ.gzf);
                this.gyZ.gzf.setOnFrameAvailableListener(this.gyZ);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        try {
            this.gza = new com.faceunity.a.c();
            this.gyZ.a(this.gza);
            gzb = false;
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            if (this.gza != null) {
                this.gza.stopRecording();
                this.gza = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            this.gyZ.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        this.gyZ.gzh = i;
        this.gyZ.gzi = i2;
        gyX = i;
        gyW = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gyY == null) {
            return false;
        }
        return this.gyY.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gyZ == null) {
            return;
        }
        this.gyZ.bwZ();
    }

    public void bwW() {
        if (this.gyZ == null) {
            return;
        }
        this.gyZ.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gyZ != null) {
            this.gyZ.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gyZ != null) {
            this.gyZ.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gyZ != null) {
            this.gyZ.setSticker(stickerItem);
        }
    }

    public void bwX() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gyZ != null) {
                    f.this.gyZ.bwX();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gyZ.gzs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gyY.getMainHandler();
    }

    /* loaded from: classes2.dex */
    private static class a implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c gzd;
        private com.faceunity.gles.c gze;
        private volatile SurfaceTexture gzf;
        private f gzg;
        private int gzj;
        private Handler gzn;
        private boolean gzo;
        private boolean gzp;
        com.faceunity.a.c gzq;
        String gzr;
        private boolean gzs;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int gzh = 720;
        protected int gzi = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gzk = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gzk};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gzl = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gzm = new HandlerThread("CreateItemThread");

        public a(Context context, f fVar) {
            this.gzg = fVar;
            this.gzm.start();
            this.gzn = new HandlerC0136a(this.gzm.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.uq(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bwZ() {
            this.gzn.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gzg.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gzd = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gze = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gzj = this.gze.createTextureObject();
            bwX();
            boolean unused = f.gzb = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        public void bwX() {
            if (this.gzf != null) {
                faceunity.fuOnCameraChange();
                this.gzf.release();
            }
            this.gzf = new SurfaceTexture(this.gzj);
            bxa();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gtO;
                this.mFacebeautyBlurLevel = aVar.gtP;
                this.mFacebeautyCheeckThin = aVar.gtQ;
                this.mFacebeautyEnlargeEye = aVar.gtR;
                this.mFacebeautyRedLevel = aVar.gtS;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gzs) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gzl = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gzf.updateTexImage();
                    this.gzf.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gzn.sendEmptyMessage(1);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gzp) {
                    this.gzg.requestRender();
                    return;
                }
                int i2 = (this.gzg.gyY.mCameraId != 1 ? 32 : 0) | 1;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gzj;
                int i4 = this.gzh;
                int i5 = this.gzi;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.gzl = (System.currentTimeMillis() - currentTimeMillis) + this.gzl;
                this.gzd.drawFrame(fuDualInputToTexture, fArr);
                try {
                    if (this.gzq != null && this.gzq.vT(2) && this.gzg.gyY != null) {
                        this.gzr = this.gzg.gyY.bxc();
                        this.gzq.a(new c.b(new File(this.gzr), f.gyW, f.gyX, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, null, this.gzf.getTimestamp()));
                    }
                    if (this.gzq != null && this.gzq.vT(1)) {
                        this.gzq.a(this.gzd, fuDualInputToTexture, fArr);
                        if (f.gzb) {
                            this.gzq.c(this.gzf);
                        }
                        boolean unused = f.gzb = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gzg.f(null);
                }
            }
        }

        public void a(com.faceunity.a.c cVar) {
            if (cVar != null) {
                this.gzq = cVar;
            }
        }

        /* renamed from: com.baidu.tieba.video.record.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class HandlerC0136a extends Handler {
            WeakReference<Context> gzu;

            HandlerC0136a(Looper looper, Context context) {
                super(looper);
                this.gzu = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Context context = this.gzu.get();
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        try {
                            if (StringUtils.isNull(a.this.mEffectFileName)) {
                                a.this.itemsArray[1] = a.this.mEffectItem = 0;
                                a.this.itemsArray[2] = a.this.gzk = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(a.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = a.this.itemsArray[1] != 0 ? a.this.itemsArray[1] : a.this.itemsArray[2];
                            if (a.this.gzo) {
                                a.this.gzk = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[2] = a.this.gzk;
                                a.this.mEffectItem = 0;
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                faceunity.fuItemSetParam(a.this.gzk, "isAndroid", 1.0d);
                            } else {
                                a.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                a.this.gzk = 0;
                                a.this.itemsArray[2] = a.this.gzk;
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
                            a.this.gzp = true;
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
                            a.this.gzp = true;
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
            this.gzg.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gzd != null) {
                        a.this.gzd.release(false);
                        a.this.gzd = null;
                    }
                    if (a.this.gze != null) {
                        a.this.gze.release(false);
                        a.this.gze = null;
                    }
                    if (a.this.gzf != null) {
                        a.this.gzf.release();
                        a.this.gzf = null;
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

        private void bxa() {
            if (this.gzg != null) {
                Handler mainHandler = this.gzg.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gzo = false;
                } else {
                    this.gzo = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gzn.sendEmptyMessage(1);
        }
    }
}
