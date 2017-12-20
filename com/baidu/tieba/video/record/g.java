package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.record.h;
import com.faceunity.a.c;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class g extends GLSurfaceView implements h {
    private static boolean gWD;
    private static int gWy = 720;
    private static int gWz = TbConfig.HEAD_IMG_SIZE;
    private com.baidu.tieba.i.h gCP;
    protected i gWA;
    private b gWB;
    private com.faceunity.a.c gWC;
    private a gWE;
    private int gWF;
    private int gWG;
    private h.a gWH;
    private boolean gWI;

    /* loaded from: classes2.dex */
    public interface a {
        void nK(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOj();
        }
        this.gWA = iVar;
        this.gWB = new b(context, this, this.gCP);
        setEGLContextClientVersion(2);
        setRenderer(this.gWB);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gWB);
                camera.setPreviewTexture(this.gWB.gWL);
                this.gWB.gWL.setOnFrameAvailableListener(this.gWB);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gCP != null) {
                    this.gCP.Q(20, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.gWC = new com.faceunity.a.c();
            this.gWB.a(this.gWC);
            gWD = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gCP != null) {
                this.gCP.Q(21, com.baidu.tieba.i.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.gWC != null) {
                this.gWC.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gCP != null) {
                this.gCP.Q(19, com.baidu.tieba.i.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(c.InterfaceC0167c interfaceC0167c) {
        if (this.gWC != null) {
            this.gWC.setOnEncoderStatusUpdateListener(interfaceC0167c);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.gWB.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gCP != null) {
                this.gCP.Q(18, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        this.gWB.cDh = i;
        this.gWB.cDi = i2;
        gWz = (int) (((i * 1.0f) / i2) * gWy);
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.gWH = aVar;
        this.gWI = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gWA == null) {
            return false;
        }
        return this.gWA.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gWB == null) {
            return;
        }
        this.gWB.bDu();
    }

    public void bDr() {
        if (this.gWB == null) {
            return;
        }
        this.gWB.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gWB != null) {
            this.gWB.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gWB != null) {
            this.gWB.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gWB != null) {
            this.gWB.setSticker(stickerItem);
        }
    }

    public void bDs() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.gWB != null) {
                    g.this.gWB.bDs();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gWB.gWV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gWA.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h gCP;
        private com.faceunity.gles.c gRV;
        private com.faceunity.gles.c gWK;
        private volatile SurfaceTexture gWL;
        private g gWM;
        private int gWN;
        private Handler gWQ;
        private boolean gWR;
        private boolean gWS;
        com.faceunity.a.c gWT;
        String gWU;
        private boolean gWV;
        private String gWW;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int cDh = 720;
        protected int cDi = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gRU = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gRU};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gWO = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gWP = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.gWM = gVar;
            this.gCP = hVar;
            this.gWP.start();
            this.gWQ = new a(this.gWP.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.vm(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bDu() {
            this.gWQ.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gWM.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gRV = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gWK = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gWN = this.gWK.createTextureObject();
            bDs();
            boolean unused = g.gWD = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.gWM.gWF = i;
            this.gWM.gWG = i2;
        }

        public void bDs() {
            if (this.gWL != null) {
                faceunity.fuOnCameraChange();
                this.gWL.release();
            }
            this.gWL = new SurfaceTexture(this.gWN);
            bDv();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gPu;
                this.mFacebeautyBlurLevel = aVar.gPv;
                this.mFacebeautyCheeckThin = aVar.gPw;
                this.mFacebeautyEnlargeEye = aVar.gPx;
                this.mFacebeautyRedLevel = aVar.gPy;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gWV) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gWO = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gWL.updateTexImage();
                    this.gWL.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gCP != null) {
                        this.gCP.Q(22, com.baidu.tieba.i.a.g(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gWQ.sendEmptyMessage(1);
                }
                if (this.gWM.gWE != null) {
                    this.gWM.gWE.nK(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gWS) {
                    this.gWM.requestRender();
                    return;
                }
                int i2 = this.gWM.gWA.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gWN;
                int i4 = this.cDh;
                int i5 = this.cDi;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.gWO = (System.currentTimeMillis() - currentTimeMillis) + this.gWO;
                try {
                    this.gRV.drawFrame(fuDualInputToTexture, fArr);
                    if (this.gWM.gWI) {
                        c(gl10);
                        this.gWM.gWI = false;
                    }
                    if (this.gWT != null && this.gWT.xe(2) && this.gWM.gWA != null) {
                        this.gWU = this.gWM.gWA.bDy();
                        this.gWT.a(new c.b(new File(this.gWU), g.gWy, g.gWz, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END, null, this.gWL.getTimestamp()));
                    }
                    if (this.gWT != null && this.gWT.xe(1)) {
                        this.gWT.a(this.gRV, fuDualInputToTexture, fArr);
                        if (g.gWD) {
                            this.gWT.d(this.gWL);
                        }
                        boolean unused = g.gWD = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gWM.i(null);
                    if (this.gCP != null) {
                        this.gCP.Q(23, com.baidu.tieba.i.a.g(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.c cVar) {
            if (cVar != null) {
                this.gWT = cVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.gWM.gWF;
                int i2 = this.gWM.gWG;
                int[] iArr = new int[i * i2];
                int[] iArr2 = new int[i * i2];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                gl10.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = i3 * i;
                    int i5 = ((i2 - i3) - 1) * i;
                    for (int i6 = 0; i6 < i; i6++) {
                        int i7 = iArr[i4 + i6];
                        iArr2[i5 + i6] = (i7 & (-16711936)) | ((i7 << 16) & 16711680) | ((i7 >> 16) & MotionEventCompat.ACTION_MASK);
                    }
                }
                bitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
            } catch (GLException e) {
                bitmap = null;
            } catch (OutOfMemoryError e2) {
                if (0 != 0 && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                if (this.gWM != null && (context = this.gWM.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                y(bitmap);
            }
        }

        private void y(final Bitmap bitmap) {
            this.gWW = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.gWM != null && this.gWM.gWH != null) {
                    this.gWM.gWH.s(false, this.gWW);
                    return;
                }
                return;
            }
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.video.record.g.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    try {
                        b.this.gWW = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gPE, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
                        return null;
                    } finally {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r4) {
                    if (b.this.gWM != null && b.this.gWM.gWH != null) {
                        b.this.gWM.gWH.s(true, b.this.gWW);
                    }
                }
            }.execute(new Void[0]);
        }

        /* loaded from: classes2.dex */
        private class a extends Handler {
            WeakReference<Context> mContext;

            a(Looper looper, Context context) {
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
                            if (StringUtils.isNull(b.this.mEffectFileName)) {
                                b.this.itemsArray[1] = b.this.mEffectItem = 0;
                                b.this.itemsArray[2] = b.this.gRU = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.gWR) {
                                b.this.gRU = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.gRU;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.gRU, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.gRU = 0;
                                b.this.itemsArray[2] = b.this.gRU;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gCP != null) {
                                b.this.gCP.Q(24, com.baidu.tieba.i.a.g(e));
                                return;
                            }
                            return;
                        }
                    case 2:
                        try {
                            InputStream open = context.getAssets().open("beauty/v3.mp3");
                            byte[] bArr2 = new byte[open.available()];
                            open.read(bArr2);
                            open.close();
                            faceunity.fuSetup(bArr2, null, f.A());
                            b.this.gWS = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gCP != null) {
                                b.this.gCP.Q(25, com.baidu.tieba.i.a.g(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.gWS = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gCP != null) {
                                b.this.gCP.Q(26, com.baidu.tieba.i.a.g(e3));
                                return;
                            }
                            return;
                        }
                    default:
                        return;
                }
            }
        }

        public void releaseResource() {
            this.gWM.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gRV != null) {
                        b.this.gRV.release(false);
                        b.this.gRV = null;
                    }
                    if (b.this.gWK != null) {
                        b.this.gWK.release(false);
                        b.this.gWK = null;
                    }
                    if (b.this.gWL != null) {
                        b.this.gWL.release();
                        b.this.gWL = null;
                    }
                    faceunity.fuDestroyItem(b.this.mEffectItem);
                    b.this.itemsArray[1] = b.this.mEffectItem = 0;
                    faceunity.fuDestroyItem(b.this.mFacebeautyItem);
                    b.this.itemsArray[0] = b.this.mFacebeautyItem = 0;
                    faceunity.fuOnDeviceLost();
                    b.this.mCameraNV21Byte = null;
                    b.this.isNeedEffectItem = true;
                }
            });
        }

        private void bDv() {
            if (this.gWM != null) {
                Handler mainHandler = this.gWM.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gWR = false;
                } else {
                    this.gWR = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gWQ.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.gWE = aVar;
        }
    }
}
