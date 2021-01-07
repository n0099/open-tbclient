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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.n;
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
/* loaded from: classes8.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int nKK = 720;
    private static int nKL = TbConfig.HEAD_IMG_SIZE;
    private static boolean nKP;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h nKM;
    private b nKN;
    private com.faceunity.a.d nKO;
    private a nKQ;
    private g.a nKR;
    private boolean nKS;
    private com.baidu.tieba.l.g nsO;

    /* loaded from: classes8.dex */
    public interface a {
        void yP(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nsO = kVar.diQ();
        }
        this.nKM = hVar;
        this.nKN = new b(context, this, this.nsO);
        setEGLContextClientVersion(2);
        setRenderer(this.nKN);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nKN);
                camera.setPreviewTexture(this.nKN.nKV);
                this.nKN.nKV.setOnFrameAvailableListener(this.nKN);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nsO != null) {
                    this.nsO.bD(20, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nKO = new com.faceunity.a.d();
            this.nKN.a(this.nKO);
            nKP = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nsO != null) {
                this.nsO.bD(21, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nKO != null) {
                this.nKO.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nsO != null) {
                this.nsO.bD(19, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nKO != null) {
            this.nKO.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nKN.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsO != null) {
                this.nsO.bD(18, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nKN.previewWidth = i;
            this.nKN.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nKK);
            if (round % 2 == 1) {
                round--;
            }
            if (nKL == 960) {
                nKL = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nKR = aVar;
        this.nKS = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nKM == null) {
            return false;
        }
        return this.nKM.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nKN == null) {
            return;
        }
        this.nKN.dVq();
    }

    public void dVm() {
        if (this.nKN == null) {
            return;
        }
        this.nKN.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nKN != null) {
            this.nKN.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nKN != null) {
            this.nKN.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nKN != null) {
            this.nKN.setSticker(stickerItem);
        }
    }

    public void dVn() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nKN != null) {
                    GLVideoPreviewView.this.nKN.dVn();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nKN.nLh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nKM.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c nHv;
        private com.faceunity.gles.c nKU;
        private volatile SurfaceTexture nKV;
        private GLVideoPreviewView nKW;
        private int nKX;
        private Handler nLc;
        private boolean nLd;
        private boolean nLe;
        com.faceunity.a.d nLf;
        String nLg;
        private boolean nLh;
        private String nLi;
        private com.baidu.tieba.l.g nsO;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nHu = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nHu};
        private boolean isNeedEffectItem = true;
        private long nKY = 0;
        private int nKZ = 0;
        private long nLa = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nLb = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.g gVar) {
            this.nKW = gLVideoPreviewView;
            this.nsO = gVar;
            this.nLb.start();
            this.nLc = new a(this.nLb.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.LG(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVq() {
            this.nLc.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nKW.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nHv = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nKU = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nKX = this.nKU.createTextureObject();
            dVn();
            boolean unused = GLVideoPreviewView.nKP = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nKW.mSurfaceViewWidth = i;
            this.nKW.mSurfaceViewHeight = i2;
        }

        public void dVn() {
            if (this.nKV != null) {
                faceunity.fuOnCameraChange();
                this.nKV.release();
            }
            this.nKV = new SurfaceTexture(this.nKX);
            dVs();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nEY;
                this.mFacebeautyBlurLevel = aVar.nEZ;
                this.mFacebeautyCheeckThin = aVar.nFa;
                this.mFacebeautyEnlargeEye = aVar.nFb;
                this.mFacebeautyRedLevel = aVar.nFc;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nLh) {
                int i = this.nKZ + 1;
                this.nKZ = i;
                if (i == 100) {
                    this.nKZ = 0;
                    this.nKY = System.currentTimeMillis();
                    this.nLa = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nKV.updateTexImage();
                    this.nKV.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.nsO != null) {
                        this.nsO.bD(22, com.baidu.tieba.l.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nLc.sendEmptyMessage(1);
                }
                if (this.nKW.nKQ != null) {
                    this.nKW.nKQ.yP(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nLe) {
                    this.nKW.requestRender();
                    return;
                }
                int i2 = (this.nKW.nKM.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nLd) {
                    faceunity.fuItemSetParam(this.nHu, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nHu, "rotationAngle", dVr() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVr() ? 270.0d : 90.0d);
                }
                this.nKW.nKM.dVr();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nKX;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nLa = (System.currentTimeMillis() - currentTimeMillis) + this.nLa;
                try {
                    this.nHv.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nKW.nKS) {
                        b(gl10);
                        this.nKW.nKS = false;
                    }
                    if (this.nLf != null && this.nLf.RE(2) && this.nKW.nKM != null) {
                        this.nLg = this.nKW.nKM.dVu();
                        this.nLf.a(new d.b(new File(this.nLg), GLVideoPreviewView.nKK, GLVideoPreviewView.nKL, 2097152, null, this.nKV.getTimestamp()));
                    }
                    if (this.nLf != null && this.nLf.RE(1)) {
                        this.nLf.a(this.nHv, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nKP) {
                            this.nLf.d(this.nKV);
                        }
                        boolean unused = GLVideoPreviewView.nKP = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nKW.g((Camera) null);
                    if (this.nsO != null) {
                        this.nsO.bD(23, com.baidu.tieba.l.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nLf = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nKW.mSurfaceViewWidth;
                int i2 = this.nKW.mSurfaceViewHeight;
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
                if (this.nKW != null && (context = this.nKW.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                S(bitmap);
            }
        }

        private void S(final Bitmap bitmap) {
            this.nLi = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nKW != null && this.nKW.nKR != null) {
                    this.nKW.nKR.G(false, this.nLi);
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
                        b.this.nLi = n.saveFileAsPic(com.baidu.tieba.video.c.nFj, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nKW != null && b.this.nKW.nKR != null) {
                        b.this.nKW.nKR.G(true, b.this.nLi);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dVr() {
            return this.nKW.nKM.dVr();
        }

        /* loaded from: classes8.dex */
        private class a extends Handler {
            WeakReference<Context> mContext;

            a(Looper looper, Context context) {
                super(looper);
                this.mContext = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                this.mContext.get();
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        try {
                            if (StringUtils.isNull(b.this.mEffectFileName)) {
                                b.this.itemsArray[1] = b.this.mEffectItem = 0;
                                b.this.itemsArray[2] = b.this.nHu = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nLd) {
                                b.this.nHu = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nHu;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nHu, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nHu, "rotationAngle", b.this.dVr() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nHu = 0;
                                b.this.itemsArray[2] = b.this.nHu;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dVr() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.nsO != null) {
                                b.this.nsO.bD(24, com.baidu.tieba.l.a.p(e));
                                return;
                            }
                            return;
                        }
                    case 2:
                        try {
                            InputStream open = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/v3.mp3");
                            byte[] bArr2 = new byte[open.available()];
                            open.read(bArr2);
                            open.close();
                            faceunity.fuSetup(bArr2, null, f.A());
                            b.this.nLe = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.nsO != null) {
                                b.this.nsO.bD(25, com.baidu.tieba.l.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nLe = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.nsO != null) {
                                b.this.nsO.bD(26, com.baidu.tieba.l.a.p(e3));
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
            this.nKW.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nHv != null) {
                        b.this.nHv.release(false);
                        b.this.nHv = null;
                    }
                    if (b.this.nKU != null) {
                        b.this.nKU.release(false);
                        b.this.nKU = null;
                    }
                    if (b.this.nKV != null) {
                        b.this.nKV.release();
                        b.this.nKV = null;
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

        private void dVs() {
            if (this.nKW != null) {
                Handler mainHandler = this.nKW.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nHu != 0) {
                    faceunity.fuItemSetParam(this.nHu, "rotationAngle", dVr() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVr() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nLd = false;
                } else {
                    this.nLd = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nLc.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nKQ = aVar;
        }
    }
}
