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
/* loaded from: classes23.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int nHs = 720;
    private static int nHt = TbConfig.HEAD_IMG_SIZE;
    private static boolean nHx;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private boolean nHA;
    protected h nHu;
    private b nHv;
    private com.faceunity.a.d nHw;
    private a nHy;
    private g.a nHz;
    private com.baidu.tieba.l.h nnb;

    /* loaded from: classes23.dex */
    public interface a {
        void yP(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.nnb = lVar.djb();
        }
        this.nHu = hVar;
        this.nHv = new b(context, this, this.nnb);
        setEGLContextClientVersion(2);
        setRenderer(this.nHv);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nHv);
                camera.setPreviewTexture(this.nHv.nHD);
                this.nHv.nHD.setOnFrameAvailableListener(this.nHv);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nnb != null) {
                    this.nnb.bD(20, com.baidu.tieba.l.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nHw = new com.faceunity.a.d();
            this.nHv.a(this.nHw);
            nHx = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nnb != null) {
                this.nnb.bD(21, com.baidu.tieba.l.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nHw != null) {
                this.nHw.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nnb != null) {
                this.nnb.bD(19, com.baidu.tieba.l.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nHw != null) {
            this.nHw.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nHv.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnb != null) {
                this.nnb.bD(18, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nHv.previewWidth = i;
            this.nHv.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nHs);
            if (round % 2 == 1) {
                round--;
            }
            if (nHt == 960) {
                nHt = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nHz = aVar;
        this.nHA = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nHu == null) {
            return false;
        }
        return this.nHu.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nHv == null) {
            return;
        }
        this.nHv.dVM();
    }

    public void dVI() {
        if (this.nHv == null) {
            return;
        }
        this.nHv.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nHv != null) {
            this.nHv.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nHv != null) {
            this.nHv.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nHv != null) {
            this.nHv.setSticker(stickerItem);
        }
    }

    public void dVJ() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nHv != null) {
                    GLVideoPreviewView.this.nHv.dVJ();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nHv.nHP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nHu.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c nDp;
        private com.faceunity.gles.c nHC;
        private volatile SurfaceTexture nHD;
        private GLVideoPreviewView nHE;
        private int nHF;
        private Handler nHK;
        private boolean nHL;
        private boolean nHM;
        com.faceunity.a.d nHN;
        String nHO;
        private boolean nHP;
        private String nHQ;
        private com.baidu.tieba.l.h nnb;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nDo = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nDo};
        private boolean isNeedEffectItem = true;
        private long nHG = 0;
        private int nHH = 0;
        private long nHI = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nHJ = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.h hVar) {
            this.nHE = gLVideoPreviewView;
            this.nnb = hVar;
            this.nHJ.start();
            this.nHK = new a(this.nHJ.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.LS(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVM() {
            this.nHK.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nHE.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nDp = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nHC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nHF = this.nHC.createTextureObject();
            dVJ();
            boolean unused = GLVideoPreviewView.nHx = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nHE.mSurfaceViewWidth = i;
            this.nHE.mSurfaceViewHeight = i2;
        }

        public void dVJ() {
            if (this.nHD != null) {
                faceunity.fuOnCameraChange();
                this.nHD.release();
            }
            this.nHD = new SurfaceTexture(this.nHF);
            dVO();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nAP;
                this.mFacebeautyBlurLevel = aVar.nAQ;
                this.mFacebeautyCheeckThin = aVar.nAR;
                this.mFacebeautyEnlargeEye = aVar.nAS;
                this.mFacebeautyRedLevel = aVar.nAT;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nHP) {
                int i = this.nHH + 1;
                this.nHH = i;
                if (i == 100) {
                    this.nHH = 0;
                    this.nHG = System.currentTimeMillis();
                    this.nHI = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nHD.updateTexImage();
                    this.nHD.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.nnb != null) {
                        this.nnb.bD(22, com.baidu.tieba.l.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nHK.sendEmptyMessage(1);
                }
                if (this.nHE.nHy != null) {
                    this.nHE.nHy.yP(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nHM) {
                    this.nHE.requestRender();
                    return;
                }
                int i2 = (this.nHE.nHu.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nHL) {
                    faceunity.fuItemSetParam(this.nDo, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nDo, "rotationAngle", dVN() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVN() ? 270.0d : 90.0d);
                }
                this.nHE.nHu.dVN();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nHF;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nHI = (System.currentTimeMillis() - currentTimeMillis) + this.nHI;
                try {
                    this.nDp.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nHE.nHA) {
                        b(gl10);
                        this.nHE.nHA = false;
                    }
                    if (this.nHN != null && this.nHN.Rr(2) && this.nHE.nHu != null) {
                        this.nHO = this.nHE.nHu.dVQ();
                        this.nHN.a(new d.b(new File(this.nHO), GLVideoPreviewView.nHs, GLVideoPreviewView.nHt, 2097152, null, this.nHD.getTimestamp()));
                    }
                    if (this.nHN != null && this.nHN.Rr(1)) {
                        this.nHN.a(this.nDp, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nHx) {
                            this.nHN.e(this.nHD);
                        }
                        boolean unused = GLVideoPreviewView.nHx = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nHE.g((Camera) null);
                    if (this.nnb != null) {
                        this.nnb.bD(23, com.baidu.tieba.l.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nHN = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nHE.mSurfaceViewWidth;
                int i2 = this.nHE.mSurfaceViewHeight;
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
                if (this.nHE != null && (context = this.nHE.getContext()) != null && (context instanceof Activity)) {
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
            this.nHQ = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nHE != null && this.nHE.nHz != null) {
                    this.nHE.nHz.G(false, this.nHQ);
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
                        b.this.nHQ = n.saveFileAsPic(com.baidu.tieba.video.c.nBa, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nHE != null && b.this.nHE.nHz != null) {
                        b.this.nHE.nHz.G(true, b.this.nHQ);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dVN() {
            return this.nHE.nHu.dVN();
        }

        /* loaded from: classes23.dex */
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
                                b.this.itemsArray[2] = b.this.nDo = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nHL) {
                                b.this.nDo = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nDo;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nDo, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nDo, "rotationAngle", b.this.dVN() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nDo = 0;
                                b.this.itemsArray[2] = b.this.nDo;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dVN() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.nnb != null) {
                                b.this.nnb.bD(24, com.baidu.tieba.l.a.r(e));
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
                            b.this.nHM = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.nnb != null) {
                                b.this.nnb.bD(25, com.baidu.tieba.l.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nHM = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.nnb != null) {
                                b.this.nnb.bD(26, com.baidu.tieba.l.a.r(e3));
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
            this.nHE.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nDp != null) {
                        b.this.nDp.release(false);
                        b.this.nDp = null;
                    }
                    if (b.this.nHC != null) {
                        b.this.nHC.release(false);
                        b.this.nHC = null;
                    }
                    if (b.this.nHD != null) {
                        b.this.nHD.release();
                        b.this.nHD = null;
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

        private void dVO() {
            if (this.nHE != null) {
                Handler mainHandler = this.nHE.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nDo != 0) {
                    faceunity.fuItemSetParam(this.nDo, "rotationAngle", dVN() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVN() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nHL = false;
                } else {
                    this.nHL = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nHK.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nHy = aVar;
        }
    }
}
