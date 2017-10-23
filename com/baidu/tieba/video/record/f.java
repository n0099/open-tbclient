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
    private static int gyI = 720;
    private static int gyJ = TbConfig.HEAD_IMG_SIZE;
    private static boolean gyN;
    protected h gyK;
    private a gyL;
    private com.faceunity.a.c gyM;

    public f(Context context, h hVar) {
        super(context);
        this.gyK = hVar;
        this.gyL = new a(context, this);
        setEGLContextClientVersion(2);
        setRenderer(this.gyL);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void d(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gyL);
                camera.setPreviewTexture(this.gyL.gyR);
                this.gyL.gyR.setOnFrameAvailableListener(this.gyL);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        try {
            this.gyM = new com.faceunity.a.c();
            this.gyL.a(this.gyM);
            gyN = false;
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            if (this.gyM != null) {
                this.gyM.stopRecording();
                this.gyM = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            this.gyL.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        this.gyL.gyT = i;
        this.gyL.gyU = i2;
        gyJ = i;
        gyI = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gyK == null) {
            return false;
        }
        return this.gyK.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gyL == null) {
            return;
        }
        this.gyL.bwR();
    }

    public void bwO() {
        if (this.gyL == null) {
            return;
        }
        this.gyL.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gyL != null) {
            this.gyL.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gyL != null) {
            this.gyL.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gyL != null) {
            this.gyL.setSticker(stickerItem);
        }
    }

    public void bwP() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gyL != null) {
                    f.this.gyL.bwP();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gyL.gze = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gyK.getMainHandler();
    }

    /* loaded from: classes2.dex */
    private static class a implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c gyP;
        private com.faceunity.gles.c gyQ;
        private volatile SurfaceTexture gyR;
        private f gyS;
        private int gyV;
        private Handler gyZ;
        private boolean gza;
        private boolean gzb;
        com.faceunity.a.c gzc;
        String gzd;
        private boolean gze;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int gyT = 720;
        protected int gyU = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gyW = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gyW};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gyX = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gyY = new HandlerThread("CreateItemThread");

        public a(Context context, f fVar) {
            this.gyS = fVar;
            this.gyY.start();
            this.gyZ = new HandlerC0136a(this.gyY.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.up(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bwR() {
            this.gyZ.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gyS.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gyP = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gyQ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gyV = this.gyQ.createTextureObject();
            bwP();
            boolean unused = f.gyN = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        public void bwP() {
            if (this.gyR != null) {
                faceunity.fuOnCameraChange();
                this.gyR.release();
            }
            this.gyR = new SurfaceTexture(this.gyV);
            bwS();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gtA;
                this.mFacebeautyBlurLevel = aVar.gtB;
                this.mFacebeautyCheeckThin = aVar.gtC;
                this.mFacebeautyEnlargeEye = aVar.gtD;
                this.mFacebeautyRedLevel = aVar.gtE;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gze) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gyX = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gyR.updateTexImage();
                    this.gyR.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gyZ.sendEmptyMessage(1);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gzb) {
                    this.gyS.requestRender();
                    return;
                }
                int i2 = (this.gyS.gyK.mCameraId != 1 ? 32 : 0) | 1;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gyV;
                int i4 = this.gyT;
                int i5 = this.gyU;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.gyX = (System.currentTimeMillis() - currentTimeMillis) + this.gyX;
                this.gyP.drawFrame(fuDualInputToTexture, fArr);
                try {
                    if (this.gzc != null && this.gzc.vS(2) && this.gyS.gyK != null) {
                        this.gzd = this.gyS.gyK.bwU();
                        this.gzc.a(new c.b(new File(this.gzd), f.gyI, f.gyJ, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, null, this.gyR.getTimestamp()));
                    }
                    if (this.gzc != null && this.gzc.vS(1)) {
                        this.gzc.a(this.gyP, fuDualInputToTexture, fArr);
                        if (f.gyN) {
                            this.gzc.c(this.gyR);
                        }
                        boolean unused = f.gyN = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gyS.f(null);
                }
            }
        }

        public void a(com.faceunity.a.c cVar) {
            if (cVar != null) {
                this.gzc = cVar;
            }
        }

        /* renamed from: com.baidu.tieba.video.record.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class HandlerC0136a extends Handler {
            WeakReference<Context> mContext;

            HandlerC0136a(Looper looper, Context context) {
                super(looper);
                this.mContext = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Context context = this.mContext.get();
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        try {
                            if (StringUtils.isNull(a.this.mEffectFileName)) {
                                a.this.itemsArray[1] = a.this.mEffectItem = 0;
                                a.this.itemsArray[2] = a.this.gyW = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(a.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = a.this.itemsArray[1] != 0 ? a.this.itemsArray[1] : a.this.itemsArray[2];
                            if (a.this.gza) {
                                a.this.gyW = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[2] = a.this.gyW;
                                a.this.mEffectItem = 0;
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                faceunity.fuItemSetParam(a.this.gyW, "isAndroid", 1.0d);
                            } else {
                                a.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                a.this.gyW = 0;
                                a.this.itemsArray[2] = a.this.gyW;
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
                            a.this.gzb = true;
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
                            a.this.gzb = true;
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
            this.gyS.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gyP != null) {
                        a.this.gyP.release(false);
                        a.this.gyP = null;
                    }
                    if (a.this.gyQ != null) {
                        a.this.gyQ.release(false);
                        a.this.gyQ = null;
                    }
                    if (a.this.gyR != null) {
                        a.this.gyR.release();
                        a.this.gyR = null;
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

        private void bwS() {
            if (this.gyS != null) {
                Handler mainHandler = this.gyS.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gza = false;
                } else {
                    this.gza = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gyZ.sendEmptyMessage(1);
        }
    }
}
