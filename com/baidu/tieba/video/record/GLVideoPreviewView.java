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
    private static int gQl = 720;
    private static int gQm = TbConfig.HEAD_IMG_SIZE;
    private static boolean gQq;
    protected h gQn;
    private b gQo;
    private com.faceunity.a.d gQp;
    private a gQr;
    private int gQs;
    private int gQt;
    private g.a gQu;
    private boolean gQv;
    private com.baidu.tieba.j.h gxt;

    /* loaded from: classes2.dex */
    public interface a {
        void mY(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gxt = kVar.aSb();
        }
        this.gQn = hVar;
        this.gQo = new b(context, this, this.gxt);
        setEGLContextClientVersion(2);
        setRenderer(this.gQo);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gQo);
                camera.setPreviewTexture(this.gQo.gQy);
                this.gQo.gQy.setOnFrameAvailableListener(this.gQo);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gxt != null) {
                    this.gxt.ac(20, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.gQp = new com.faceunity.a.d();
            this.gQo.a(this.gQp);
            gQq = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gxt != null) {
                this.gxt.ac(21, com.baidu.tieba.j.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        try {
            if (this.gQp != null) {
                this.gQp.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gxt != null) {
                this.gxt.ac(19, com.baidu.tieba.j.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.gQp != null) {
            this.gQp.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        try {
            this.gQo.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxt != null) {
                this.gxt.ac(18, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.gQo.cSN = i;
            this.gQo.cSO = i2;
            gQm = (int) (((i * 1.0f) / i2) * gQl);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.gQu = aVar;
        this.gQv = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gQn == null) {
            return false;
        }
        return this.gQn.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gQo == null) {
            return;
        }
        this.gQo.bxZ();
    }

    public void bxW() {
        if (this.gQo == null) {
            return;
        }
        this.gQo.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gQo != null) {
            this.gQo.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gQo != null) {
            this.gQo.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gQo != null) {
            this.gQo.setSticker(stickerItem);
        }
    }

    public void bxX() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.gQo != null) {
                    GLVideoPreviewView.this.gQo.bxX();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gQo.gQI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gQn.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c gMg;
        private int gQA;
        private Handler gQD;
        private boolean gQE;
        private boolean gQF;
        com.faceunity.a.d gQG;
        String gQH;
        private boolean gQI;
        private String gQJ;
        private com.faceunity.gles.c gQx;
        private volatile SurfaceTexture gQy;
        private GLVideoPreviewView gQz;
        private com.baidu.tieba.j.h gxt;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int cSN = 720;
        protected int cSO = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gMf = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gMf};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gQB = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gQC = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.gQz = gLVideoPreviewView;
            this.gxt = hVar;
            this.gQC.start();
            this.gQD = new a(this.gQC.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.ue(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bxZ() {
            this.gQD.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gQz.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gMg = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gQx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gQA = this.gQx.createTextureObject();
            bxX();
            boolean unused = GLVideoPreviewView.gQq = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.gQz.gQs = i;
            this.gQz.gQt = i2;
        }

        public void bxX() {
            if (this.gQy != null) {
                faceunity.fuOnCameraChange();
                this.gQy.release();
            }
            this.gQy = new SurfaceTexture(this.gQA);
            byb();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gJz;
                this.mFacebeautyBlurLevel = aVar.gJA;
                this.mFacebeautyCheeckThin = aVar.gJB;
                this.mFacebeautyEnlargeEye = aVar.gJC;
                this.mFacebeautyRedLevel = aVar.gJD;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gQI) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gQB = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gQy.updateTexImage();
                    this.gQy.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gxt != null) {
                        this.gxt.ac(22, com.baidu.tieba.j.a.g(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gQD.sendEmptyMessage(1);
                }
                if (this.gQz.gQr != null) {
                    this.gQz.gQr.mY(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gQF) {
                    this.gQz.requestRender();
                    return;
                }
                int i2 = (this.gQz.gQn.mCameraId != 1 ? 32 : 0) | 1;
                if (this.gQE) {
                    faceunity.fuItemSetParam(this.gMf, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.gMf, "rotationAngle", bya() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bya() ? 270.0d : 90.0d);
                }
                this.gQz.gQn.bya();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gQA;
                int i4 = this.cSN;
                int i5 = this.cSO;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.gQB = (System.currentTimeMillis() - currentTimeMillis) + this.gQB;
                try {
                    this.gMg.drawFrame(fuDualInputToTexture, fArr);
                    if (this.gQz.gQv) {
                        e(gl10);
                        this.gQz.gQv = false;
                    }
                    if (this.gQG != null && this.gQG.wf(2) && this.gQz.gQn != null) {
                        this.gQH = this.gQz.gQn.byd();
                        this.gQG.a(new d.b(new File(this.gQH), GLVideoPreviewView.gQl, GLVideoPreviewView.gQm, 2097152, null, this.gQy.getTimestamp()));
                    }
                    if (this.gQG != null && this.gQG.wf(1)) {
                        this.gQG.a(this.gMg, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.gQq) {
                            this.gQG.c(this.gQy);
                        }
                        boolean unused = GLVideoPreviewView.gQq = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gQz.i(null);
                    if (this.gxt != null) {
                        this.gxt.ac(23, com.baidu.tieba.j.a.g(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.gQG = dVar;
            }
        }

        private void e(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.gQz.gQs;
                int i2 = this.gQz.gQt;
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
                if (this.gQz != null && (context = this.gQz.getContext()) != null && (context instanceof Activity)) {
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
            this.gQJ = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.gQz != null && this.gQz.gQu != null) {
                    this.gQz.gQu.p(false, this.gQJ);
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
                        b.this.gQJ = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gJJ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.gQz != null && b.this.gQz.gQu != null) {
                        b.this.gQz.gQu.p(true, b.this.gQJ);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bya() {
            return this.gQz.gQn.bya();
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
                                b.this.itemsArray[2] = b.this.gMf = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.gQE) {
                                b.this.gMf = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.gMf;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.gMf, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.gMf, "rotationAngle", b.this.bya() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.gMf = 0;
                                b.this.itemsArray[2] = b.this.gMf;
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
                            if (b.this.gxt != null) {
                                b.this.gxt.ac(24, com.baidu.tieba.j.a.g(e));
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
                            b.this.gQF = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gxt != null) {
                                b.this.gxt.ac(25, com.baidu.tieba.j.a.g(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.gQF = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gxt != null) {
                                b.this.gxt.ac(26, com.baidu.tieba.j.a.g(e3));
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
            this.gQz.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gMg != null) {
                        b.this.gMg.release(false);
                        b.this.gMg = null;
                    }
                    if (b.this.gQx != null) {
                        b.this.gQx.release(false);
                        b.this.gQx = null;
                    }
                    if (b.this.gQy != null) {
                        b.this.gQy.release();
                        b.this.gQy = null;
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
            if (this.gQz != null) {
                Handler mainHandler = this.gQz.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.gMf != 0) {
                    faceunity.fuItemSetParam(this.gMf, "rotationAngle", bya() ? 270.0d : 90.0d);
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
                    this.gQE = false;
                } else {
                    this.gQE = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gQD.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.gQr = aVar;
        }
    }
}
