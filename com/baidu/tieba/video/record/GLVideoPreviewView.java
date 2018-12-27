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
    private static int hJt = 720;
    private static int hJu = TbConfig.HEAD_IMG_SIZE;
    private static boolean hJy;
    private int hJA;
    private int hJB;
    private g.a hJC;
    private boolean hJD;
    protected h hJv;
    private b hJw;
    private com.faceunity.a.d hJx;
    private a hJz;
    private com.baidu.tieba.j.h hpD;

    /* loaded from: classes5.dex */
    public interface a {
        void oh(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hpD = lVar.bdz();
        }
        this.hJv = hVar;
        this.hJw = new b(context, this, this.hpD);
        setEGLContextClientVersion(2);
        setRenderer(this.hJw);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hJw);
                camera.setPreviewTexture(this.hJw.hJG);
                this.hJw.hJG.setOnFrameAvailableListener(this.hJw);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hpD != null) {
                    this.hpD.Y(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hJx = new com.faceunity.a.d();
            this.hJw.a(this.hJx);
            hJy = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hpD != null) {
                this.hpD.Y(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hJx != null) {
                this.hJx.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hpD != null) {
                this.hpD.Y(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hJx != null) {
            this.hJx.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hJw.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hpD != null) {
                this.hpD.Y(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hJw.dCi = i;
            this.hJw.dCj = i2;
            hJu = (int) (((i * 1.0f) / i2) * hJt);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hJC = aVar;
        this.hJD = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hJv == null) {
            return false;
        }
        return this.hJv.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hJw == null) {
            return;
        }
        this.hJw.bKM();
    }

    public void bKI() {
        if (this.hJw == null) {
            return;
        }
        this.hJw.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hJw != null) {
            this.hJw.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hJw != null) {
            this.hJw.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hJw != null) {
            this.hJw.setSticker(stickerItem);
        }
    }

    public void bKJ() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hJw != null) {
                    GLVideoPreviewView.this.hJw.bKJ();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hJw.hJS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hJv.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c hFr;
        private com.faceunity.gles.c hJF;
        private volatile SurfaceTexture hJG;
        private GLVideoPreviewView hJH;
        private int hJI;
        private Handler hJN;
        private boolean hJO;
        private boolean hJP;
        com.faceunity.a.d hJQ;
        String hJR;
        private boolean hJS;
        private String hJT;
        private com.baidu.tieba.j.h hpD;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dCi = 720;
        protected int dCj = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hFq = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hFq};
        private boolean isNeedEffectItem = true;
        private long hJJ = 0;
        private int hJK = 0;
        private long hJL = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hJM = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hJH = gLVideoPreviewView;
            this.hpD = hVar;
            this.hJM.start();
            this.hJN = new a(this.hJM.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wx(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bKM() {
            this.hJN.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hJH.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hFr = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hJF = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hJI = this.hJF.createTextureObject();
            bKJ();
            boolean unused = GLVideoPreviewView.hJy = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hJH.hJA = i;
            this.hJH.hJB = i2;
        }

        public void bKJ() {
            if (this.hJG != null) {
                faceunity.fuOnCameraChange();
                this.hJG.release();
            }
            this.hJG = new SurfaceTexture(this.hJI);
            bKO();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hCM;
                this.mFacebeautyBlurLevel = aVar.hCN;
                this.mFacebeautyCheeckThin = aVar.hCO;
                this.mFacebeautyEnlargeEye = aVar.hCP;
                this.mFacebeautyRedLevel = aVar.hCQ;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hJS) {
                int i = this.hJK + 1;
                this.hJK = i;
                if (i == 100) {
                    this.hJK = 0;
                    this.hJJ = System.currentTimeMillis();
                    this.hJL = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hJG.updateTexImage();
                    this.hJG.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hpD != null) {
                        this.hpD.Y(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hJN.sendEmptyMessage(1);
                }
                if (this.hJH.hJz != null) {
                    this.hJH.hJz.oh(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hJP) {
                    this.hJH.requestRender();
                    return;
                }
                int i2 = (this.hJH.hJv.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hJO) {
                    faceunity.fuItemSetParam(this.hFq, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.hFq, "rotationAngle", bKN() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bKN() ? 270.0d : 90.0d);
                }
                this.hJH.hJv.bKN();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hJI;
                int i4 = this.dCi;
                int i5 = this.dCj;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hJL = (System.currentTimeMillis() - currentTimeMillis) + this.hJL;
                try {
                    this.hFr.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hJH.hJD) {
                        d(gl10);
                        this.hJH.hJD = false;
                    }
                    if (this.hJQ != null && this.hJQ.ze(2) && this.hJH.hJv != null) {
                        this.hJR = this.hJH.hJv.bKQ();
                        this.hJQ.a(new d.b(new File(this.hJR), GLVideoPreviewView.hJt, GLVideoPreviewView.hJu, 2097152, null, this.hJG.getTimestamp()));
                    }
                    if (this.hJQ != null && this.hJQ.ze(1)) {
                        this.hJQ.a(this.hFr, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hJy) {
                            this.hJQ.e(this.hJG);
                        }
                        boolean unused = GLVideoPreviewView.hJy = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hJH.g((Camera) null);
                    if (this.hpD != null) {
                        this.hpD.Y(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hJQ = dVar;
            }
        }

        private void d(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hJH.hJA;
                int i2 = this.hJH.hJB;
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
                if (this.hJH != null && (context = this.hJH.getContext()) != null && (context instanceof Activity)) {
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
            this.hJT = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hJH != null && this.hJH.hJC != null) {
                    this.hJH.hJC.u(false, this.hJT);
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
                        b.this.hJT = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hCW, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hJH != null && b.this.hJH.hJC != null) {
                        b.this.hJH.hJC.u(true, b.this.hJT);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bKN() {
            return this.hJH.hJv.bKN();
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
                                b.this.itemsArray[2] = b.this.hFq = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hJO) {
                                b.this.hFq = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hFq;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hFq, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.hFq, "rotationAngle", b.this.bKN() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hFq = 0;
                                b.this.itemsArray[2] = b.this.hFq;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bKN() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hpD != null) {
                                b.this.hpD.Y(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.hJP = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hpD != null) {
                                b.this.hpD.Y(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hJP = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hpD != null) {
                                b.this.hpD.Y(26, com.baidu.tieba.j.a.o(e3));
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
            this.hJH.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hFr != null) {
                        b.this.hFr.release(false);
                        b.this.hFr = null;
                    }
                    if (b.this.hJF != null) {
                        b.this.hJF.release(false);
                        b.this.hJF = null;
                    }
                    if (b.this.hJG != null) {
                        b.this.hJG.release();
                        b.this.hJG = null;
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

        private void bKO() {
            if (this.hJH != null) {
                Handler mainHandler = this.hJH.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.hFq != 0) {
                    faceunity.fuItemSetParam(this.hFq, "rotationAngle", bKN() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bKN() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hJO = false;
                } else {
                    this.hJO = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hJN.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hJz = aVar;
        }
    }
}
