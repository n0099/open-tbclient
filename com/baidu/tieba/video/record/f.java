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
    private static int gIp = 720;
    private static int gIq = TbConfig.HEAD_IMG_SIZE;
    private static boolean gIu;
    protected h gIr;
    private a gIs;
    private com.faceunity.a.c gIt;

    public f(Context context, h hVar) {
        super(context);
        this.gIr = hVar;
        this.gIs = new a(context, this);
        setEGLContextClientVersion(2);
        setRenderer(this.gIs);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void d(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gIs);
                camera.setPreviewTexture(this.gIs.gIy);
                this.gIs.gIy.setOnFrameAvailableListener(this.gIs);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        try {
            this.gIt = new com.faceunity.a.c();
            this.gIs.a(this.gIt);
            gIu = false;
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            if (this.gIt != null) {
                this.gIt.stopRecording();
                this.gIt = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            this.gIs.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        this.gIs.gIA = i;
        this.gIs.gIB = i2;
        gIq = i;
        gIp = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gIr == null) {
            return false;
        }
        return this.gIr.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gIs == null) {
            return;
        }
        this.gIs.bAh();
    }

    public void bAd() {
        if (this.gIs == null) {
            return;
        }
        this.gIs.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gIs != null) {
            this.gIs.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gIs != null) {
            this.gIs.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gIs != null) {
            this.gIs.setSticker(stickerItem);
        }
    }

    public void bAe() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gIs != null) {
                    f.this.gIs.bAe();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gIs.gIL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gIr.getMainHandler();
    }

    /* loaded from: classes2.dex */
    private static class a implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private int gIC;
        private Handler gIG;
        private boolean gIH;
        private boolean gII;
        com.faceunity.a.c gIJ;
        String gIK;
        private boolean gIL;
        private com.faceunity.gles.c gIw;
        private com.faceunity.gles.c gIx;
        private volatile SurfaceTexture gIy;
        private f gIz;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int gIA = 720;
        protected int gIB = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gID = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gID};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gIE = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gIF = new HandlerThread("CreateItemThread");

        public a(Context context, f fVar) {
            this.gIz = fVar;
            this.gIF.start();
            this.gIG = new HandlerC0136a(this.gIF.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.uG(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bAh() {
            this.gIG.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gIz.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gIw = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gIx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gIC = this.gIx.createTextureObject();
            bAe();
            boolean unused = f.gIu = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        public void bAe() {
            if (this.gIy != null) {
                faceunity.fuOnCameraChange();
                this.gIy.release();
            }
            this.gIy = new SurfaceTexture(this.gIC);
            bAi();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gCm;
                this.mFacebeautyBlurLevel = aVar.gCn;
                this.mFacebeautyCheeckThin = aVar.gCo;
                this.mFacebeautyEnlargeEye = aVar.gCp;
                this.mFacebeautyRedLevel = aVar.gCq;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gIL) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gIE = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gIy.updateTexImage();
                    this.gIy.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gIG.sendEmptyMessage(1);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gII) {
                    this.gIz.requestRender();
                    return;
                }
                int i2 = (this.gIz.gIr.mCameraId != 1 ? 32 : 0) | 1;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gIC;
                int i4 = this.gIA;
                int i5 = this.gIB;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.gIE = (System.currentTimeMillis() - currentTimeMillis) + this.gIE;
                try {
                    this.gIw.drawFrame(fuDualInputToTexture, fArr);
                    if (this.gIJ != null && this.gIJ.wp(2) && this.gIz.gIr != null) {
                        this.gIK = this.gIz.gIr.bAk();
                        this.gIJ.a(new c.b(new File(this.gIK), f.gIp, f.gIq, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, null, this.gIy.getTimestamp()));
                    }
                    if (this.gIJ != null && this.gIJ.wp(1)) {
                        this.gIJ.a(this.gIw, fuDualInputToTexture, fArr);
                        if (f.gIu) {
                            this.gIJ.c(this.gIy);
                        }
                        boolean unused = f.gIu = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gIz.f(null);
                }
            }
        }

        public void a(com.faceunity.a.c cVar) {
            if (cVar != null) {
                this.gIJ = cVar;
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
                                a.this.itemsArray[2] = a.this.gID = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(a.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = a.this.itemsArray[1] != 0 ? a.this.itemsArray[1] : a.this.itemsArray[2];
                            if (a.this.gIH) {
                                a.this.gID = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[2] = a.this.gID;
                                a.this.mEffectItem = 0;
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                faceunity.fuItemSetParam(a.this.gID, "isAndroid", 1.0d);
                            } else {
                                a.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                a.this.itemsArray[1] = a.this.mEffectItem;
                                a.this.gID = 0;
                                a.this.itemsArray[2] = a.this.gID;
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
                            a.this.gII = true;
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
                            a.this.gII = true;
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
            this.gIz.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gIw != null) {
                        a.this.gIw.release(false);
                        a.this.gIw = null;
                    }
                    if (a.this.gIx != null) {
                        a.this.gIx.release(false);
                        a.this.gIx = null;
                    }
                    if (a.this.gIy != null) {
                        a.this.gIy.release();
                        a.this.gIy = null;
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

        private void bAi() {
            if (this.gIz != null) {
                Handler mainHandler = this.gIz.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gIH = false;
                } else {
                    this.gIH = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gIG.sendEmptyMessage(1);
        }
    }
}
