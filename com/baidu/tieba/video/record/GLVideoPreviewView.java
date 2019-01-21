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
    private static int hKB = 720;
    private static int hKC = TbConfig.HEAD_IMG_SIZE;
    private static boolean hKG;
    protected h hKD;
    private b hKE;
    private com.faceunity.a.d hKF;
    private a hKH;
    private int hKI;
    private int hKJ;
    private g.a hKK;
    private boolean hKL;
    private com.baidu.tieba.j.h hqM;

    /* loaded from: classes5.dex */
    public interface a {
        void oi(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hqM = lVar.bdZ();
        }
        this.hKD = hVar;
        this.hKE = new b(context, this, this.hqM);
        setEGLContextClientVersion(2);
        setRenderer(this.hKE);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hKE);
                camera.setPreviewTexture(this.hKE.hKO);
                this.hKE.hKO.setOnFrameAvailableListener(this.hKE);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hqM != null) {
                    this.hqM.aa(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hKF = new com.faceunity.a.d();
            this.hKE.a(this.hKF);
            hKG = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hqM != null) {
                this.hqM.aa(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hKF != null) {
                this.hKF.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hqM != null) {
                this.hqM.aa(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hKF != null) {
            this.hKF.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hKE.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hqM != null) {
                this.hqM.aa(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hKE.dCS = i;
            this.hKE.dCT = i2;
            hKC = (int) (((i * 1.0f) / i2) * hKB);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hKK = aVar;
        this.hKL = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hKD == null) {
            return false;
        }
        return this.hKD.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hKE == null) {
            return;
        }
        this.hKE.bLv();
    }

    public void bLr() {
        if (this.hKE == null) {
            return;
        }
        this.hKE.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hKE != null) {
            this.hKE.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hKE != null) {
            this.hKE.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hKE != null) {
            this.hKE.setSticker(stickerItem);
        }
    }

    public void bLs() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hKE != null) {
                    GLVideoPreviewView.this.hKE.bLs();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hKE.hLa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hKD.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c hGz;
        private com.faceunity.gles.c hKN;
        private volatile SurfaceTexture hKO;
        private GLVideoPreviewView hKP;
        private int hKQ;
        private Handler hKV;
        private boolean hKW;
        private boolean hKX;
        com.faceunity.a.d hKY;
        String hKZ;
        private boolean hLa;
        private String hLb;
        private com.baidu.tieba.j.h hqM;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dCS = 720;
        protected int dCT = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hGy = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hGy};
        private boolean isNeedEffectItem = true;
        private long hKR = 0;
        private int hKS = 0;
        private long hKT = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hKU = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hKP = gLVideoPreviewView;
            this.hqM = hVar;
            this.hKU.start();
            this.hKV = new a(this.hKU.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wA(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bLv() {
            this.hKV.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hKP.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hGz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hKN = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hKQ = this.hKN.createTextureObject();
            bLs();
            boolean unused = GLVideoPreviewView.hKG = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hKP.hKI = i;
            this.hKP.hKJ = i2;
        }

        public void bLs() {
            if (this.hKO != null) {
                faceunity.fuOnCameraChange();
                this.hKO.release();
            }
            this.hKO = new SurfaceTexture(this.hKQ);
            bLx();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hDU;
                this.mFacebeautyBlurLevel = aVar.hDV;
                this.mFacebeautyCheeckThin = aVar.hDW;
                this.mFacebeautyEnlargeEye = aVar.hDX;
                this.mFacebeautyRedLevel = aVar.hDY;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hLa) {
                int i = this.hKS + 1;
                this.hKS = i;
                if (i == 100) {
                    this.hKS = 0;
                    this.hKR = System.currentTimeMillis();
                    this.hKT = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hKO.updateTexImage();
                    this.hKO.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hqM != null) {
                        this.hqM.aa(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hKV.sendEmptyMessage(1);
                }
                if (this.hKP.hKH != null) {
                    this.hKP.hKH.oi(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hKX) {
                    this.hKP.requestRender();
                    return;
                }
                int i2 = (this.hKP.hKD.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hKW) {
                    faceunity.fuItemSetParam(this.hGy, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.hGy, "rotationAngle", bLw() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bLw() ? 270.0d : 90.0d);
                }
                this.hKP.hKD.bLw();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hKQ;
                int i4 = this.dCS;
                int i5 = this.dCT;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hKT = (System.currentTimeMillis() - currentTimeMillis) + this.hKT;
                try {
                    this.hGz.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hKP.hKL) {
                        d(gl10);
                        this.hKP.hKL = false;
                    }
                    if (this.hKY != null && this.hKY.zg(2) && this.hKP.hKD != null) {
                        this.hKZ = this.hKP.hKD.bLz();
                        this.hKY.a(new d.b(new File(this.hKZ), GLVideoPreviewView.hKB, GLVideoPreviewView.hKC, 2097152, null, this.hKO.getTimestamp()));
                    }
                    if (this.hKY != null && this.hKY.zg(1)) {
                        this.hKY.a(this.hGz, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hKG) {
                            this.hKY.e(this.hKO);
                        }
                        boolean unused = GLVideoPreviewView.hKG = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hKP.g((Camera) null);
                    if (this.hqM != null) {
                        this.hqM.aa(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hKY = dVar;
            }
        }

        private void d(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hKP.hKI;
                int i2 = this.hKP.hKJ;
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
                if (this.hKP != null && (context = this.hKP.getContext()) != null && (context instanceof Activity)) {
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
            this.hLb = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hKP != null && this.hKP.hKK != null) {
                    this.hKP.hKK.t(false, this.hLb);
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
                        b.this.hLb = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hEe, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hKP != null && b.this.hKP.hKK != null) {
                        b.this.hKP.hKK.t(true, b.this.hLb);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bLw() {
            return this.hKP.hKD.bLw();
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
                                b.this.itemsArray[2] = b.this.hGy = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hKW) {
                                b.this.hGy = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hGy;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hGy, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.hGy, "rotationAngle", b.this.bLw() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hGy = 0;
                                b.this.itemsArray[2] = b.this.hGy;
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
                            if (b.this.hqM != null) {
                                b.this.hqM.aa(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.hKX = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hqM != null) {
                                b.this.hqM.aa(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hKX = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hqM != null) {
                                b.this.hqM.aa(26, com.baidu.tieba.j.a.o(e3));
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
            this.hKP.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hGz != null) {
                        b.this.hGz.release(false);
                        b.this.hGz = null;
                    }
                    if (b.this.hKN != null) {
                        b.this.hKN.release(false);
                        b.this.hKN = null;
                    }
                    if (b.this.hKO != null) {
                        b.this.hKO.release();
                        b.this.hKO = null;
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
            if (this.hKP != null) {
                Handler mainHandler = this.hKP.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.hGy != 0) {
                    faceunity.fuItemSetParam(this.hGy, "rotationAngle", bLw() ? 270.0d : 90.0d);
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
                    this.hKW = false;
                } else {
                    this.hKW = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hKV.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hKH = aVar;
        }
    }
}
