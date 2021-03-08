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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.o;
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
/* loaded from: classes7.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int nSu = 720;
    private static int nSv = 960;
    private static boolean nSz;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private com.baidu.tieba.l.g nAz;
    private a nSA;
    private g.a nSB;
    private boolean nSC;
    protected h nSw;
    private b nSx;
    private com.faceunity.a.d nSy;

    /* loaded from: classes7.dex */
    public interface a {
        void zd(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nAz = kVar.dho();
        }
        this.nSw = hVar;
        this.nSx = new b(context, this, this.nAz);
        setEGLContextClientVersion(2);
        setRenderer(this.nSx);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nSx);
                camera.setPreviewTexture(this.nSx.nSF);
                this.nSx.nSF.setOnFrameAvailableListener(this.nSx);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nAz != null) {
                    this.nAz.bK(20, com.baidu.tieba.l.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nSy = new com.faceunity.a.d();
            this.nSx.a(this.nSy);
            nSz = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nAz != null) {
                this.nAz.bK(21, com.baidu.tieba.l.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nSy != null) {
                this.nSy.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nAz != null) {
                this.nAz.bK(19, com.baidu.tieba.l.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nSy != null) {
            this.nSy.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nSx.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nAz != null) {
                this.nAz.bK(18, com.baidu.tieba.l.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nSx.previewWidth = i;
            this.nSx.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nSu);
            if (round % 2 == 1) {
                round--;
            }
            if (nSv == 960) {
                nSv = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nSB = aVar;
        this.nSC = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nSw == null) {
            return false;
        }
        return this.nSw.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nSx == null) {
            return;
        }
        this.nSx.dTZ();
    }

    public void dTV() {
        if (this.nSx == null) {
            return;
        }
        this.nSx.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nSx != null) {
            this.nSx.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nSx != null) {
            this.nSx.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nSx != null) {
            this.nSx.setSticker(stickerItem);
        }
    }

    public void dTW() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nSx != null) {
                    GLVideoPreviewView.this.nSx.dTW();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nSx.nSQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nSw.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.baidu.tieba.l.g nAz;
        private com.faceunity.gles.c nPg;
        private com.faceunity.gles.c nSE;
        private volatile SurfaceTexture nSF;
        private GLVideoPreviewView nSG;
        private int nSH;
        private Handler nSM;
        private boolean nSN;
        private boolean nSO;
        com.faceunity.a.d nSP;
        private boolean nSQ;
        private String nSR;
        String videoFileName;
        protected int previewWidth = 720;
        protected int previewHeight = 960;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nPf = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nPf};
        private boolean isNeedEffectItem = true;
        private long nSI = 0;
        private int nSJ = 0;
        private long nSK = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nSL = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.g gVar) {
            this.nSG = gLVideoPreviewView;
            this.nAz = gVar;
            this.nSL.start();
            this.nSM = new a(this.nSL.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Ky(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dTZ() {
            this.nSM.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nSG.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nPg = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nSE = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nSH = this.nSE.createTextureObject();
            dTW();
            boolean unused = GLVideoPreviewView.nSz = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nSG.mSurfaceViewWidth = i;
            this.nSG.mSurfaceViewHeight = i2;
        }

        public void dTW() {
            if (this.nSF != null) {
                faceunity.fuOnCameraChange();
                this.nSF.release();
            }
            this.nSF = new SurfaceTexture(this.nSH);
            dUb();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nMJ;
                this.mFacebeautyBlurLevel = aVar.nMK;
                this.mFacebeautyCheeckThin = aVar.nML;
                this.mFacebeautyEnlargeEye = aVar.nMM;
                this.mFacebeautyRedLevel = aVar.nMN;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nSQ) {
                int i = this.nSJ + 1;
                this.nSJ = i;
                if (i == 100) {
                    this.nSJ = 0;
                    this.nSI = System.currentTimeMillis();
                    this.nSK = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nSF.updateTexImage();
                    this.nSF.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.nAz != null) {
                        this.nAz.bK(22, com.baidu.tieba.l.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nSM.sendEmptyMessage(1);
                }
                if (this.nSG.nSA != null) {
                    this.nSG.nSA.zd(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nSO) {
                    this.nSG.requestRender();
                    return;
                }
                int i2 = (this.nSG.nSw.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nSN) {
                    faceunity.fuItemSetParam(this.nPf, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nPf, "rotationAngle", dUa() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dUa() ? 270.0d : 90.0d);
                }
                this.nSG.nSw.dUa();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nSH;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nSK = (System.currentTimeMillis() - currentTimeMillis) + this.nSK;
                try {
                    this.nPg.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nSG.nSC) {
                        b(gl10);
                        this.nSG.nSC = false;
                    }
                    if (this.nSP != null && this.nSP.Qx(2) && this.nSG.nSw != null) {
                        this.videoFileName = this.nSG.nSw.dUd();
                        this.nSP.a(new d.b(new File(this.videoFileName), GLVideoPreviewView.nSu, GLVideoPreviewView.nSv, 2097152, null, this.nSF.getTimestamp()));
                    }
                    if (this.nSP != null && this.nSP.Qx(1)) {
                        this.nSP.a(this.nPg, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nSz) {
                            this.nSP.d(this.nSF);
                        }
                        boolean unused = GLVideoPreviewView.nSz = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nSG.g((Camera) null);
                    if (this.nAz != null) {
                        this.nAz.bK(23, com.baidu.tieba.l.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nSP = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nSG.mSurfaceViewWidth;
                int i2 = this.nSG.mSurfaceViewHeight;
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
                if (this.nSG != null && (context = this.nSG.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                R(bitmap);
            }
        }

        private void R(final Bitmap bitmap) {
            this.nSR = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nSG != null && this.nSG.nSB != null) {
                    this.nSG.nSB.O(false, this.nSR);
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
                        b.this.nSR = o.saveFileAsPic(com.baidu.tieba.video.c.nMU, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nSG != null && b.this.nSG.nSB != null) {
                        b.this.nSG.nSB.O(true, b.this.nSR);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dUa() {
            return this.nSG.nSw.dUa();
        }

        /* loaded from: classes7.dex */
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
                                b.this.itemsArray[2] = b.this.nPf = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nSN) {
                                b.this.nPf = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nPf;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nPf, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nPf, "rotationAngle", b.this.dUa() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nPf = 0;
                                b.this.itemsArray[2] = b.this.nPf;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dUa() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.nAz != null) {
                                b.this.nAz.bK(24, com.baidu.tieba.l.a.o(e));
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
                            b.this.nSO = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.nAz != null) {
                                b.this.nAz.bK(25, com.baidu.tieba.l.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nSO = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.nAz != null) {
                                b.this.nAz.bK(26, com.baidu.tieba.l.a.o(e3));
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
            this.nSG.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nPg != null) {
                        b.this.nPg.release(false);
                        b.this.nPg = null;
                    }
                    if (b.this.nSE != null) {
                        b.this.nSE.release(false);
                        b.this.nSE = null;
                    }
                    if (b.this.nSF != null) {
                        b.this.nSF.release();
                        b.this.nSF = null;
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

        private void dUb() {
            if (this.nSG != null) {
                Handler mainHandler = this.nSG.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nPf != 0) {
                    faceunity.fuItemSetParam(this.nPf, "rotationAngle", dUa() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dUa() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nSN = false;
                } else {
                    this.nSN = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nSM.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nSA = aVar;
        }
    }
}
