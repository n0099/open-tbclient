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
/* loaded from: classes2.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int gRp = 720;
    private static int gRq = TbConfig.HEAD_IMG_SIZE;
    private static boolean gRu;
    protected h gRr;
    private b gRs;
    private com.faceunity.a.d gRt;
    private a gRv;
    private int gRw;
    private int gRx;
    private g.a gRy;
    private boolean gRz;
    private com.baidu.tieba.j.h gyx;

    /* loaded from: classes2.dex */
    public interface a {
        void mZ(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        this.gRr = hVar;
        this.gRs = new b(context, this, this.gyx);
        setEGLContextClientVersion(2);
        setRenderer(this.gRs);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gRs);
                camera.setPreviewTexture(this.gRs.gRC);
                this.gRs.gRC.setOnFrameAvailableListener(this.gRs);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gyx != null) {
                    this.gyx.ac(20, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.gRt = new com.faceunity.a.d();
            this.gRs.a(this.gRt);
            gRu = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gyx != null) {
                this.gyx.ac(21, com.baidu.tieba.j.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        try {
            if (this.gRt != null) {
                this.gRt.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gyx != null) {
                this.gyx.ac(19, com.baidu.tieba.j.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.gRt != null) {
            this.gRt.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        try {
            this.gRs.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gyx != null) {
                this.gyx.ac(18, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.gRs.cTU = i;
            this.gRs.cTV = i2;
            gRq = (int) (((i * 1.0f) / i2) * gRp);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.gRy = aVar;
        this.gRz = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gRr == null) {
            return false;
        }
        return this.gRr.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gRs == null) {
            return;
        }
        this.gRs.bxX();
    }

    public void bxU() {
        if (this.gRs == null) {
            return;
        }
        this.gRs.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gRs != null) {
            this.gRs.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gRs != null) {
            this.gRs.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gRs != null) {
            this.gRs.setSticker(stickerItem);
        }
    }

    public void bxV() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.gRs != null) {
                    GLVideoPreviewView.this.gRs.bxV();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gRs.gRM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gRr.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c gNj;
        private com.faceunity.gles.c gRB;
        private volatile SurfaceTexture gRC;
        private GLVideoPreviewView gRD;
        private int gRE;
        private Handler gRH;
        private boolean gRI;
        private boolean gRJ;
        com.faceunity.a.d gRK;
        String gRL;
        private boolean gRM;
        private String gRN;
        private com.baidu.tieba.j.h gyx;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int cTU = 720;
        protected int cTV = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gNi = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gNi};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gRF = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gRG = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.gRD = gLVideoPreviewView;
            this.gyx = hVar;
            this.gRG.start();
            this.gRH = new a(this.gRG.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.ud(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bxX() {
            this.gRH.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gRD.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gNj = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gRB = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gRE = this.gRB.createTextureObject();
            bxV();
            boolean unused = GLVideoPreviewView.gRu = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.gRD.gRw = i;
            this.gRD.gRx = i2;
        }

        public void bxV() {
            if (this.gRC != null) {
                faceunity.fuOnCameraChange();
                this.gRC.release();
            }
            this.gRC = new SurfaceTexture(this.gRE);
            bxZ();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gKC;
                this.mFacebeautyBlurLevel = aVar.gKD;
                this.mFacebeautyCheeckThin = aVar.gKE;
                this.mFacebeautyEnlargeEye = aVar.gKF;
                this.mFacebeautyRedLevel = aVar.gKG;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gRM) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gRF = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gRC.updateTexImage();
                    this.gRC.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gyx != null) {
                        this.gyx.ac(22, com.baidu.tieba.j.a.g(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gRH.sendEmptyMessage(1);
                }
                if (this.gRD.gRv != null) {
                    this.gRD.gRv.mZ(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gRJ) {
                    this.gRD.requestRender();
                    return;
                }
                int i2 = (this.gRD.gRr.mCameraId != 1 ? 32 : 0) | 1;
                if (this.gRI) {
                    faceunity.fuItemSetParam(this.gNi, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.gNi, "rotationAngle", bxY() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bxY() ? 270.0d : 90.0d);
                }
                this.gRD.gRr.bxY();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gRE;
                int i4 = this.cTU;
                int i5 = this.cTV;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.gRF = (System.currentTimeMillis() - currentTimeMillis) + this.gRF;
                try {
                    this.gNj.drawFrame(fuDualInputToTexture, fArr);
                    if (this.gRD.gRz) {
                        e(gl10);
                        this.gRD.gRz = false;
                    }
                    if (this.gRK != null && this.gRK.we(2) && this.gRD.gRr != null) {
                        this.gRL = this.gRD.gRr.byb();
                        this.gRK.a(new d.b(new File(this.gRL), GLVideoPreviewView.gRp, GLVideoPreviewView.gRq, 2097152, null, this.gRC.getTimestamp()));
                    }
                    if (this.gRK != null && this.gRK.we(1)) {
                        this.gRK.a(this.gNj, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.gRu) {
                            this.gRK.c(this.gRC);
                        }
                        boolean unused = GLVideoPreviewView.gRu = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gRD.i(null);
                    if (this.gyx != null) {
                        this.gyx.ac(23, com.baidu.tieba.j.a.g(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.gRK = dVar;
            }
        }

        private void e(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.gRD.gRw;
                int i2 = this.gRD.gRx;
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
                if (this.gRD != null && (context = this.gRD.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                F(bitmap);
            }
        }

        private void F(final Bitmap bitmap) {
            this.gRN = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.gRD != null && this.gRD.gRy != null) {
                    this.gRD.gRy.p(false, this.gRN);
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
                        b.this.gRN = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gKM, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.gRD != null && b.this.gRD.gRy != null) {
                        b.this.gRD.gRy.p(true, b.this.gRN);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bxY() {
            return this.gRD.gRr.bxY();
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
                                b.this.itemsArray[2] = b.this.gNi = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.gRI) {
                                b.this.gNi = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.gNi;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.gNi, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.gNi, "rotationAngle", b.this.bxY() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.gNi = 0;
                                b.this.itemsArray[2] = b.this.gNi;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bxY() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gyx != null) {
                                b.this.gyx.ac(24, com.baidu.tieba.j.a.g(e));
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
                            b.this.gRJ = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gyx != null) {
                                b.this.gyx.ac(25, com.baidu.tieba.j.a.g(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.gRJ = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gyx != null) {
                                b.this.gyx.ac(26, com.baidu.tieba.j.a.g(e3));
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
            this.gRD.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gNj != null) {
                        b.this.gNj.release(false);
                        b.this.gNj = null;
                    }
                    if (b.this.gRB != null) {
                        b.this.gRB.release(false);
                        b.this.gRB = null;
                    }
                    if (b.this.gRC != null) {
                        b.this.gRC.release();
                        b.this.gRC = null;
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

        private void bxZ() {
            if (this.gRD != null) {
                Handler mainHandler = this.gRD.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.gNi != 0) {
                    faceunity.fuItemSetParam(this.gNi, "rotationAngle", bxY() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bxY() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gRI = false;
                } else {
                    this.gRI = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gRH.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.gRv = aVar;
        }
    }
}
