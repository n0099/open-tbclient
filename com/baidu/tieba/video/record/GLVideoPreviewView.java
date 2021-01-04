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
    private static int nKL = 720;
    private static int nKM = TbConfig.HEAD_IMG_SIZE;
    private static boolean nKQ;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h nKN;
    private b nKO;
    private com.faceunity.a.d nKP;
    private a nKR;
    private g.a nKS;
    private boolean nKT;
    private com.baidu.tieba.l.g nsP;

    /* loaded from: classes8.dex */
    public interface a {
        void yP(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nsP = kVar.diP();
        }
        this.nKN = hVar;
        this.nKO = new b(context, this, this.nsP);
        setEGLContextClientVersion(2);
        setRenderer(this.nKO);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nKO);
                camera.setPreviewTexture(this.nKO.nKW);
                this.nKO.nKW.setOnFrameAvailableListener(this.nKO);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nsP != null) {
                    this.nsP.bD(20, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nKP = new com.faceunity.a.d();
            this.nKO.a(this.nKP);
            nKQ = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nsP != null) {
                this.nsP.bD(21, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nKP != null) {
                this.nKP.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nsP != null) {
                this.nsP.bD(19, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nKP != null) {
            this.nKP.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nKO.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsP != null) {
                this.nsP.bD(18, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nKO.previewWidth = i;
            this.nKO.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nKL);
            if (round % 2 == 1) {
                round--;
            }
            if (nKM == 960) {
                nKM = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nKS = aVar;
        this.nKT = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nKN == null) {
            return false;
        }
        return this.nKN.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nKO == null) {
            return;
        }
        this.nKO.dVp();
    }

    public void dVl() {
        if (this.nKO == null) {
            return;
        }
        this.nKO.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nKO != null) {
            this.nKO.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nKO != null) {
            this.nKO.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nKO != null) {
            this.nKO.setSticker(stickerItem);
        }
    }

    public void dVm() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nKO != null) {
                    GLVideoPreviewView.this.nKO.dVm();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nKO.nLi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nKN.getMainHandler();
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
        private com.faceunity.gles.c nHw;
        private com.faceunity.gles.c nKV;
        private volatile SurfaceTexture nKW;
        private GLVideoPreviewView nKX;
        private int nKY;
        private Handler nLd;
        private boolean nLe;
        private boolean nLf;
        com.faceunity.a.d nLg;
        String nLh;
        private boolean nLi;
        private String nLj;
        private com.baidu.tieba.l.g nsP;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nHv = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nHv};
        private boolean isNeedEffectItem = true;
        private long nKZ = 0;
        private int nLa = 0;
        private long nLb = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nLc = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.g gVar) {
            this.nKX = gLVideoPreviewView;
            this.nsP = gVar;
            this.nLc.start();
            this.nLd = new a(this.nLc.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.LG(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVp() {
            this.nLd.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nKX.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nHw = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nKV = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nKY = this.nKV.createTextureObject();
            dVm();
            boolean unused = GLVideoPreviewView.nKQ = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nKX.mSurfaceViewWidth = i;
            this.nKX.mSurfaceViewHeight = i2;
        }

        public void dVm() {
            if (this.nKW != null) {
                faceunity.fuOnCameraChange();
                this.nKW.release();
            }
            this.nKW = new SurfaceTexture(this.nKY);
            dVr();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nEZ;
                this.mFacebeautyBlurLevel = aVar.nFa;
                this.mFacebeautyCheeckThin = aVar.nFb;
                this.mFacebeautyEnlargeEye = aVar.nFc;
                this.mFacebeautyRedLevel = aVar.nFd;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nLi) {
                int i = this.nLa + 1;
                this.nLa = i;
                if (i == 100) {
                    this.nLa = 0;
                    this.nKZ = System.currentTimeMillis();
                    this.nLb = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nKW.updateTexImage();
                    this.nKW.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.nsP != null) {
                        this.nsP.bD(22, com.baidu.tieba.l.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nLd.sendEmptyMessage(1);
                }
                if (this.nKX.nKR != null) {
                    this.nKX.nKR.yP(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nLf) {
                    this.nKX.requestRender();
                    return;
                }
                int i2 = (this.nKX.nKN.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nLe) {
                    faceunity.fuItemSetParam(this.nHv, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nHv, "rotationAngle", dVq() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVq() ? 270.0d : 90.0d);
                }
                this.nKX.nKN.dVq();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nKY;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nLb = (System.currentTimeMillis() - currentTimeMillis) + this.nLb;
                try {
                    this.nHw.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nKX.nKT) {
                        b(gl10);
                        this.nKX.nKT = false;
                    }
                    if (this.nLg != null && this.nLg.Ro(2) && this.nKX.nKN != null) {
                        this.nLh = this.nKX.nKN.dVt();
                        this.nLg.a(new d.b(new File(this.nLh), GLVideoPreviewView.nKL, GLVideoPreviewView.nKM, 2097152, null, this.nKW.getTimestamp()));
                    }
                    if (this.nLg != null && this.nLg.Ro(1)) {
                        this.nLg.a(this.nHw, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nKQ) {
                            this.nLg.d(this.nKW);
                        }
                        boolean unused = GLVideoPreviewView.nKQ = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nKX.g((Camera) null);
                    if (this.nsP != null) {
                        this.nsP.bD(23, com.baidu.tieba.l.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nLg = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nKX.mSurfaceViewWidth;
                int i2 = this.nKX.mSurfaceViewHeight;
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
                if (this.nKX != null && (context = this.nKX.getContext()) != null && (context instanceof Activity)) {
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
            this.nLj = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nKX != null && this.nKX.nKS != null) {
                    this.nKX.nKS.G(false, this.nLj);
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
                        b.this.nLj = n.saveFileAsPic(com.baidu.tieba.video.c.nFk, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nKX != null && b.this.nKX.nKS != null) {
                        b.this.nKX.nKS.G(true, b.this.nLj);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dVq() {
            return this.nKX.nKN.dVq();
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
                                b.this.itemsArray[2] = b.this.nHv = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nLe) {
                                b.this.nHv = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nHv;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nHv, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nHv, "rotationAngle", b.this.dVq() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nHv = 0;
                                b.this.itemsArray[2] = b.this.nHv;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dVq() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.nsP != null) {
                                b.this.nsP.bD(24, com.baidu.tieba.l.a.p(e));
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
                            b.this.nLf = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.nsP != null) {
                                b.this.nsP.bD(25, com.baidu.tieba.l.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nLf = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.nsP != null) {
                                b.this.nsP.bD(26, com.baidu.tieba.l.a.p(e3));
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
            this.nKX.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nHw != null) {
                        b.this.nHw.release(false);
                        b.this.nHw = null;
                    }
                    if (b.this.nKV != null) {
                        b.this.nKV.release(false);
                        b.this.nKV = null;
                    }
                    if (b.this.nKW != null) {
                        b.this.nKW.release();
                        b.this.nKW = null;
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

        private void dVr() {
            if (this.nKX != null) {
                Handler mainHandler = this.nKX.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nHv != 0) {
                    faceunity.fuItemSetParam(this.nHv, "rotationAngle", dVq() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVq() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nLe = false;
                } else {
                    this.nLe = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nLd.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nKR = aVar;
        }
    }
}
