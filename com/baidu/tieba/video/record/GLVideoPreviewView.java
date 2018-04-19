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
    private static int gQo = 720;
    private static int gQp = TbConfig.HEAD_IMG_SIZE;
    private static boolean gQt;
    protected h gQq;
    private b gQr;
    private com.faceunity.a.d gQs;
    private a gQu;
    private int gQv;
    private int gQw;
    private g.a gQx;
    private boolean gQy;
    private com.baidu.tieba.j.h gxw;

    /* loaded from: classes2.dex */
    public interface a {
        void mY(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        this.gQq = hVar;
        this.gQr = new b(context, this, this.gxw);
        setEGLContextClientVersion(2);
        setRenderer(this.gQr);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gQr);
                camera.setPreviewTexture(this.gQr.gQB);
                this.gQr.gQB.setOnFrameAvailableListener(this.gQr);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gxw != null) {
                    this.gxw.ac(20, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.gQs = new com.faceunity.a.d();
            this.gQr.a(this.gQs);
            gQt = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gxw != null) {
                this.gxw.ac(21, com.baidu.tieba.j.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        try {
            if (this.gQs != null) {
                this.gQs.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gxw != null) {
                this.gxw.ac(19, com.baidu.tieba.j.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.gQs != null) {
            this.gQs.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        try {
            this.gQr.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxw != null) {
                this.gxw.ac(18, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.gQr.cSQ = i;
            this.gQr.cSR = i2;
            gQp = (int) (((i * 1.0f) / i2) * gQo);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.gQx = aVar;
        this.gQy = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gQq == null) {
            return false;
        }
        return this.gQq.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gQr == null) {
            return;
        }
        this.gQr.bxZ();
    }

    public void bxW() {
        if (this.gQr == null) {
            return;
        }
        this.gQr.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gQr != null) {
            this.gQr.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gQr != null) {
            this.gQr.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gQr != null) {
            this.gQr.setSticker(stickerItem);
        }
    }

    public void bxX() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.gQr != null) {
                    GLVideoPreviewView.this.gQr.bxX();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gQr.gQL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gQq.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c gMj;
        private com.faceunity.gles.c gQA;
        private volatile SurfaceTexture gQB;
        private GLVideoPreviewView gQC;
        private int gQD;
        private Handler gQG;
        private boolean gQH;
        private boolean gQI;
        com.faceunity.a.d gQJ;
        String gQK;
        private boolean gQL;
        private String gQM;
        private com.baidu.tieba.j.h gxw;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int cSQ = 720;
        protected int cSR = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gMi = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gMi};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gQE = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gQF = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.gQC = gLVideoPreviewView;
            this.gxw = hVar;
            this.gQF.start();
            this.gQG = new a(this.gQF.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.ue(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bxZ() {
            this.gQG.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gQC.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gMj = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gQA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gQD = this.gQA.createTextureObject();
            bxX();
            boolean unused = GLVideoPreviewView.gQt = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.gQC.gQv = i;
            this.gQC.gQw = i2;
        }

        public void bxX() {
            if (this.gQB != null) {
                faceunity.fuOnCameraChange();
                this.gQB.release();
            }
            this.gQB = new SurfaceTexture(this.gQD);
            byb();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gJC;
                this.mFacebeautyBlurLevel = aVar.gJD;
                this.mFacebeautyCheeckThin = aVar.gJE;
                this.mFacebeautyEnlargeEye = aVar.gJF;
                this.mFacebeautyRedLevel = aVar.gJG;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gQL) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gQE = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gQB.updateTexImage();
                    this.gQB.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gxw != null) {
                        this.gxw.ac(22, com.baidu.tieba.j.a.g(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gQG.sendEmptyMessage(1);
                }
                if (this.gQC.gQu != null) {
                    this.gQC.gQu.mY(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gQI) {
                    this.gQC.requestRender();
                    return;
                }
                int i2 = (this.gQC.gQq.mCameraId != 1 ? 32 : 0) | 1;
                if (this.gQH) {
                    faceunity.fuItemSetParam(this.gMi, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.gMi, "rotationAngle", bya() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bya() ? 270.0d : 90.0d);
                }
                this.gQC.gQq.bya();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gQD;
                int i4 = this.cSQ;
                int i5 = this.cSR;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.gQE = (System.currentTimeMillis() - currentTimeMillis) + this.gQE;
                try {
                    this.gMj.drawFrame(fuDualInputToTexture, fArr);
                    if (this.gQC.gQy) {
                        e(gl10);
                        this.gQC.gQy = false;
                    }
                    if (this.gQJ != null && this.gQJ.wf(2) && this.gQC.gQq != null) {
                        this.gQK = this.gQC.gQq.byd();
                        this.gQJ.a(new d.b(new File(this.gQK), GLVideoPreviewView.gQo, GLVideoPreviewView.gQp, 2097152, null, this.gQB.getTimestamp()));
                    }
                    if (this.gQJ != null && this.gQJ.wf(1)) {
                        this.gQJ.a(this.gMj, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.gQt) {
                            this.gQJ.c(this.gQB);
                        }
                        boolean unused = GLVideoPreviewView.gQt = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gQC.i(null);
                    if (this.gxw != null) {
                        this.gxw.ac(23, com.baidu.tieba.j.a.g(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.gQJ = dVar;
            }
        }

        private void e(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.gQC.gQv;
                int i2 = this.gQC.gQw;
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
                if (this.gQC != null && (context = this.gQC.getContext()) != null && (context instanceof Activity)) {
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
            this.gQM = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.gQC != null && this.gQC.gQx != null) {
                    this.gQC.gQx.p(false, this.gQM);
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
                        b.this.gQM = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gJM, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.gQC != null && b.this.gQC.gQx != null) {
                        b.this.gQC.gQx.p(true, b.this.gQM);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bya() {
            return this.gQC.gQq.bya();
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
                                b.this.itemsArray[2] = b.this.gMi = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.gQH) {
                                b.this.gMi = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.gMi;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.gMi, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.gMi, "rotationAngle", b.this.bya() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.gMi = 0;
                                b.this.itemsArray[2] = b.this.gMi;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bya() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gxw != null) {
                                b.this.gxw.ac(24, com.baidu.tieba.j.a.g(e));
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
                            b.this.gQI = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gxw != null) {
                                b.this.gxw.ac(25, com.baidu.tieba.j.a.g(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.gQI = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gxw != null) {
                                b.this.gxw.ac(26, com.baidu.tieba.j.a.g(e3));
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
            this.gQC.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gMj != null) {
                        b.this.gMj.release(false);
                        b.this.gMj = null;
                    }
                    if (b.this.gQA != null) {
                        b.this.gQA.release(false);
                        b.this.gQA = null;
                    }
                    if (b.this.gQB != null) {
                        b.this.gQB.release();
                        b.this.gQB = null;
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

        private void byb() {
            if (this.gQC != null) {
                Handler mainHandler = this.gQC.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.gMi != 0) {
                    faceunity.fuItemSetParam(this.gMi, "rotationAngle", bya() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bya() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gQH = false;
                } else {
                    this.gQH = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gQG.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.gQu = aVar;
        }
    }
}
