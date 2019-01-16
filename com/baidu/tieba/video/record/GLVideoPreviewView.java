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
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.video.record.g;
import com.faceunity.a.d;
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
/* loaded from: classes5.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int hKA = 720;
    private static int hKB = TbConfig.HEAD_IMG_SIZE;
    private static boolean hKF;
    protected h hKC;
    private b hKD;
    private com.faceunity.a.d hKE;
    private a hKG;
    private int hKH;
    private int hKI;
    private g.a hKJ;
    private boolean hKK;
    private com.baidu.tieba.j.h hqL;

    /* loaded from: classes5.dex */
    public interface a {
        void oi(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hqL = lVar.bdZ();
        }
        this.hKC = hVar;
        this.hKD = new b(context, this, this.hqL);
        setEGLContextClientVersion(2);
        setRenderer(this.hKD);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hKD);
                camera.setPreviewTexture(this.hKD.hKN);
                this.hKD.hKN.setOnFrameAvailableListener(this.hKD);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hqL != null) {
                    this.hqL.aa(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hKE = new com.faceunity.a.d();
            this.hKD.a(this.hKE);
            hKF = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hqL != null) {
                this.hqL.aa(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hKE != null) {
                this.hKE.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hqL != null) {
                this.hqL.aa(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hKE != null) {
            this.hKE.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hKD.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqL != null) {
                this.hqL.aa(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hKD.dCR = i;
            this.hKD.dCS = i2;
            hKB = (int) (((i * 1.0f) / i2) * hKA);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hKJ = aVar;
        this.hKK = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hKC == null) {
            return false;
        }
        return this.hKC.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hKD == null) {
            return;
        }
        this.hKD.bLv();
    }

    public void bLr() {
        if (this.hKD == null) {
            return;
        }
        this.hKD.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hKD != null) {
            this.hKD.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hKD != null) {
            this.hKD.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hKD != null) {
            this.hKD.setSticker(stickerItem);
        }
    }

    public void bLs() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hKD != null) {
                    GLVideoPreviewView.this.hKD.bLs();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hKD.hKZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hKC.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c hGy;
        private com.faceunity.gles.c hKM;
        private volatile SurfaceTexture hKN;
        private GLVideoPreviewView hKO;
        private int hKP;
        private Handler hKU;
        private boolean hKV;
        private boolean hKW;
        com.faceunity.a.d hKX;
        String hKY;
        private boolean hKZ;
        private String hLa;
        private com.baidu.tieba.j.h hqL;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dCR = 720;
        protected int dCS = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hGx = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hGx};
        private boolean isNeedEffectItem = true;
        private long hKQ = 0;
        private int hKR = 0;
        private long hKS = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hKT = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hKO = gLVideoPreviewView;
            this.hqL = hVar;
            this.hKT.start();
            this.hKU = new a(this.hKT.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wA(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bLv() {
            this.hKU.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hKO.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hGy = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hKM = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hKP = this.hKM.createTextureObject();
            bLs();
            boolean unused = GLVideoPreviewView.hKF = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hKO.hKH = i;
            this.hKO.hKI = i2;
        }

        public void bLs() {
            if (this.hKN != null) {
                faceunity.fuOnCameraChange();
                this.hKN.release();
            }
            this.hKN = new SurfaceTexture(this.hKP);
            bLx();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hDT;
                this.mFacebeautyBlurLevel = aVar.hDU;
                this.mFacebeautyCheeckThin = aVar.hDV;
                this.mFacebeautyEnlargeEye = aVar.hDW;
                this.mFacebeautyRedLevel = aVar.hDX;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hKZ) {
                int i = this.hKR + 1;
                this.hKR = i;
                if (i == 100) {
                    this.hKR = 0;
                    this.hKQ = System.currentTimeMillis();
                    this.hKS = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hKN.updateTexImage();
                    this.hKN.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hqL != null) {
                        this.hqL.aa(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hKU.sendEmptyMessage(1);
                }
                if (this.hKO.hKG != null) {
                    this.hKO.hKG.oi(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_bright", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "tooth_whiten", 0.0d);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hKW) {
                    this.hKO.requestRender();
                    return;
                }
                int i2 = (this.hKO.hKC.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hKV) {
                    faceunity.fuItemSetParam(this.hGx, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.hGx, "rotationAngle", bLw() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bLw() ? 270.0d : 90.0d);
                }
                this.hKO.hKC.bLw();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hKP;
                int i4 = this.dCR;
                int i5 = this.dCS;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hKS = (System.currentTimeMillis() - currentTimeMillis) + this.hKS;
                try {
                    this.hGy.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hKO.hKK) {
                        d(gl10);
                        this.hKO.hKK = false;
                    }
                    if (this.hKX != null && this.hKX.zg(2) && this.hKO.hKC != null) {
                        this.hKY = this.hKO.hKC.bLz();
                        this.hKX.a(new d.b(new File(this.hKY), GLVideoPreviewView.hKA, GLVideoPreviewView.hKB, 2097152, null, this.hKN.getTimestamp()));
                    }
                    if (this.hKX != null && this.hKX.zg(1)) {
                        this.hKX.a(this.hGy, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hKF) {
                            this.hKX.e(this.hKN);
                        }
                        boolean unused = GLVideoPreviewView.hKF = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hKO.g((Camera) null);
                    if (this.hqL != null) {
                        this.hqL.aa(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hKX = dVar;
            }
        }

        private void d(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hKO.hKH;
                int i2 = this.hKO.hKI;
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
                        iArr2[i5 + i6] = (i7 & (-16711936)) | ((i7 << 16) & 16711680) | ((i7 >> 16) & 255);
                    }
                }
                bitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
            } catch (GLException e) {
                bitmap = null;
            } catch (OutOfMemoryError e2) {
                if (0 != 0 && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                if (this.hKO != null && (context = this.hKO.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                E(bitmap);
            }
        }

        private void E(final Bitmap bitmap) {
            this.hLa = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hKO != null && this.hKO.hKJ != null) {
                    this.hKO.hKJ.t(false, this.hLa);
                    return;
                }
                return;
            }
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    try {
                        b.this.hLa = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hEd, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                public void onPostExecute(Void r4) {
                    if (b.this.hKO != null && b.this.hKO.hKJ != null) {
                        b.this.hKO.hKJ.t(true, b.this.hLa);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bLw() {
            return this.hKO.hKC.bLw();
        }

        /* loaded from: classes5.dex */
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
                                b.this.itemsArray[2] = b.this.hGx = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hKV) {
                                b.this.hGx = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hGx;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hGx, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.hGx, "rotationAngle", b.this.bLw() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hGx = 0;
                                b.this.itemsArray[2] = b.this.hGx;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bLw() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hqL != null) {
                                b.this.hqL.aa(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.hKW = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hqL != null) {
                                b.this.hqL.aa(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hKW = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hqL != null) {
                                b.this.hqL.aa(26, com.baidu.tieba.j.a.o(e3));
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
            this.hKO.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hGy != null) {
                        b.this.hGy.release(false);
                        b.this.hGy = null;
                    }
                    if (b.this.hKM != null) {
                        b.this.hKM.release(false);
                        b.this.hKM = null;
                    }
                    if (b.this.hKN != null) {
                        b.this.hKN.release();
                        b.this.hKN = null;
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

        private void bLx() {
            if (this.hKO != null) {
                Handler mainHandler = this.hKO.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.hGx != 0) {
                    faceunity.fuItemSetParam(this.hGx, "rotationAngle", bLw() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bLw() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hKV = false;
                } else {
                    this.hKV = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hKU.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hKG = aVar;
        }
    }
}
