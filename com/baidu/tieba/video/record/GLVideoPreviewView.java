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
    private static int nHu = 720;
    private static int nHv = TbConfig.HEAD_IMG_SIZE;
    private static boolean nHz;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private a nHA;
    private g.a nHB;
    private boolean nHC;
    protected h nHw;
    private b nHx;
    private com.faceunity.a.d nHy;
    private com.baidu.tieba.l.h nnd;

    /* loaded from: classes23.dex */
    public interface a {
        void yP(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.nnd = lVar.djc();
        }
        this.nHw = hVar;
        this.nHx = new b(context, this, this.nnd);
        setEGLContextClientVersion(2);
        setRenderer(this.nHx);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nHx);
                camera.setPreviewTexture(this.nHx.nHF);
                this.nHx.nHF.setOnFrameAvailableListener(this.nHx);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nnd != null) {
                    this.nnd.bD(20, com.baidu.tieba.l.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nHy = new com.faceunity.a.d();
            this.nHx.a(this.nHy);
            nHz = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nnd != null) {
                this.nnd.bD(21, com.baidu.tieba.l.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nHy != null) {
                this.nHy.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nnd != null) {
                this.nnd.bD(19, com.baidu.tieba.l.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nHy != null) {
            this.nHy.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nHx.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnd != null) {
                this.nnd.bD(18, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nHx.previewWidth = i;
            this.nHx.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nHu);
            if (round % 2 == 1) {
                round--;
            }
            if (nHv == 960) {
                nHv = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nHB = aVar;
        this.nHC = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nHw == null) {
            return false;
        }
        return this.nHw.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nHx == null) {
            return;
        }
        this.nHx.dVN();
    }

    public void dVJ() {
        if (this.nHx == null) {
            return;
        }
        this.nHx.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nHx != null) {
            this.nHx.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nHx != null) {
            this.nHx.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nHx != null) {
            this.nHx.setSticker(stickerItem);
        }
    }

    public void dVK() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nHx != null) {
                    GLVideoPreviewView.this.nHx.dVK();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nHx.nHR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nHw.getMainHandler();
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
        private com.faceunity.gles.c nDr;
        private com.faceunity.gles.c nHE;
        private volatile SurfaceTexture nHF;
        private GLVideoPreviewView nHG;
        private int nHH;
        private Handler nHM;
        private boolean nHN;
        private boolean nHO;
        com.faceunity.a.d nHP;
        String nHQ;
        private boolean nHR;
        private String nHS;
        private com.baidu.tieba.l.h nnd;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nDq = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nDq};
        private boolean isNeedEffectItem = true;
        private long nHI = 0;
        private int nHJ = 0;
        private long nHK = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nHL = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.h hVar) {
            this.nHG = gLVideoPreviewView;
            this.nnd = hVar;
            this.nHL.start();
            this.nHM = new a(this.nHL.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.LS(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVN() {
            this.nHM.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nHG.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nDr = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nHE = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nHH = this.nHE.createTextureObject();
            dVK();
            boolean unused = GLVideoPreviewView.nHz = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nHG.mSurfaceViewWidth = i;
            this.nHG.mSurfaceViewHeight = i2;
        }

        public void dVK() {
            if (this.nHF != null) {
                faceunity.fuOnCameraChange();
                this.nHF.release();
            }
            this.nHF = new SurfaceTexture(this.nHH);
            dVP();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nAR;
                this.mFacebeautyBlurLevel = aVar.nAS;
                this.mFacebeautyCheeckThin = aVar.nAT;
                this.mFacebeautyEnlargeEye = aVar.nAU;
                this.mFacebeautyRedLevel = aVar.nAV;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nHR) {
                int i = this.nHJ + 1;
                this.nHJ = i;
                if (i == 100) {
                    this.nHJ = 0;
                    this.nHI = System.currentTimeMillis();
                    this.nHK = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nHF.updateTexImage();
                    this.nHF.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.nnd != null) {
                        this.nnd.bD(22, com.baidu.tieba.l.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nHM.sendEmptyMessage(1);
                }
                if (this.nHG.nHA != null) {
                    this.nHG.nHA.yP(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nHO) {
                    this.nHG.requestRender();
                    return;
                }
                int i2 = (this.nHG.nHw.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nHN) {
                    faceunity.fuItemSetParam(this.nDq, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nDq, "rotationAngle", dVO() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVO() ? 270.0d : 90.0d);
                }
                this.nHG.nHw.dVO();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nHH;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nHK = (System.currentTimeMillis() - currentTimeMillis) + this.nHK;
                try {
                    this.nDr.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nHG.nHC) {
                        b(gl10);
                        this.nHG.nHC = false;
                    }
                    if (this.nHP != null && this.nHP.Rr(2) && this.nHG.nHw != null) {
                        this.nHQ = this.nHG.nHw.dVR();
                        this.nHP.a(new d.b(new File(this.nHQ), GLVideoPreviewView.nHu, GLVideoPreviewView.nHv, 2097152, null, this.nHF.getTimestamp()));
                    }
                    if (this.nHP != null && this.nHP.Rr(1)) {
                        this.nHP.a(this.nDr, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nHz) {
                            this.nHP.e(this.nHF);
                        }
                        boolean unused = GLVideoPreviewView.nHz = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nHG.g((Camera) null);
                    if (this.nnd != null) {
                        this.nnd.bD(23, com.baidu.tieba.l.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nHP = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nHG.mSurfaceViewWidth;
                int i2 = this.nHG.mSurfaceViewHeight;
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
                if (this.nHG != null && (context = this.nHG.getContext()) != null && (context instanceof Activity)) {
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
            this.nHS = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nHG != null && this.nHG.nHB != null) {
                    this.nHG.nHB.G(false, this.nHS);
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
                        b.this.nHS = n.saveFileAsPic(com.baidu.tieba.video.c.nBc, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nHG != null && b.this.nHG.nHB != null) {
                        b.this.nHG.nHB.G(true, b.this.nHS);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dVO() {
            return this.nHG.nHw.dVO();
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
                                b.this.itemsArray[2] = b.this.nDq = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nHN) {
                                b.this.nDq = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nDq;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nDq, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nDq, "rotationAngle", b.this.dVO() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nDq = 0;
                                b.this.itemsArray[2] = b.this.nDq;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dVO() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.nnd != null) {
                                b.this.nnd.bD(24, com.baidu.tieba.l.a.r(e));
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
                            b.this.nHO = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.nnd != null) {
                                b.this.nnd.bD(25, com.baidu.tieba.l.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nHO = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.nnd != null) {
                                b.this.nnd.bD(26, com.baidu.tieba.l.a.r(e3));
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
            this.nHG.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nDr != null) {
                        b.this.nDr.release(false);
                        b.this.nDr = null;
                    }
                    if (b.this.nHE != null) {
                        b.this.nHE.release(false);
                        b.this.nHE = null;
                    }
                    if (b.this.nHF != null) {
                        b.this.nHF.release();
                        b.this.nHF = null;
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

        private void dVP() {
            if (this.nHG != null) {
                Handler mainHandler = this.nHG.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nDq != 0) {
                    faceunity.fuItemSetParam(this.nDq, "rotationAngle", dVO() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dVO() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nHN = false;
                } else {
                    this.nHN = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nHM.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nHA = aVar;
        }
    }
}
