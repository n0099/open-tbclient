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
    private static boolean jCE;
    protected h jCB;
    private b jCC;
    private com.faceunity.a.d jCD;
    private a jCF;
    private g.a jCG;
    private boolean jCH;
    private com.baidu.tieba.j.h jiP;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private static int jCz = 720;
    private static int jCA = TbConfig.HEAD_IMG_SIZE;

    /* loaded from: classes5.dex */
    public interface a {
        void ry(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jiP = lVar.bMW();
        }
        this.jCB = hVar;
        this.jCC = new b(context, this, this.jiP);
        setEGLContextClientVersion(2);
        setRenderer(this.jCC);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jCC);
                camera.setPreviewTexture(this.jCC.jCK);
                this.jCC.jCK.setOnFrameAvailableListener(this.jCC);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jiP != null) {
                    this.jiP.au(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jCD = new com.faceunity.a.d();
            this.jCC.a(this.jCD);
            jCE = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jiP != null) {
                this.jiP.au(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jCD != null) {
                this.jCD.yz();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jiP != null) {
                this.jiP.au(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jCD != null) {
            this.jCD.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jCC.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jiP != null) {
                this.jiP.au(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jCC.previewWidth = i;
            this.jCC.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jCz);
            if (round % 2 == 1) {
                round--;
            }
            jCA = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jCG = aVar;
        this.jCH = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jCB == null) {
            return false;
        }
        return this.jCB.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jCC == null) {
            return;
        }
        this.jCC.cuJ();
    }

    public void cuF() {
        if (this.jCC == null) {
            return;
        }
        this.jCC.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jCC != null) {
            this.jCC.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jCC != null) {
            this.jCC.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jCC != null) {
            this.jCC.setSticker(stickerItem);
        }
    }

    public void cuG() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jCC != null) {
                    GLVideoPreviewView.this.jCC.cuG();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jCC.jCW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jCB.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c jCJ;
        private volatile SurfaceTexture jCK;
        private GLVideoPreviewView jCL;
        private int jCM;
        private Handler jCR;
        private boolean jCS;
        private boolean jCT;
        com.faceunity.a.d jCU;
        String jCV;
        private boolean jCW;
        private String jCX;
        private com.baidu.tieba.j.h jiP;
        private com.faceunity.gles.c jyB;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int jyA = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jyA};
        private boolean isNeedEffectItem = true;
        private long jCN = 0;
        private int jCO = 0;
        private long jCP = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jCQ = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jCL = gLVideoPreviewView;
            this.jiP = hVar;
            this.jCQ.start();
            this.jCR = new a(this.jCQ.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.AI(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cuJ() {
            this.jCR.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jCL.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jyB = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jCJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jCM = this.jCJ.createTextureObject();
            cuG();
            boolean unused = GLVideoPreviewView.jCE = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jCL.mSurfaceViewWidth = i;
            this.jCL.mSurfaceViewHeight = i2;
        }

        public void cuG() {
            if (this.jCK != null) {
                faceunity.fuOnCameraChange();
                this.jCK.release();
            }
            this.jCK = new SurfaceTexture(this.jCM);
            cuL();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.jvW;
                this.mFacebeautyBlurLevel = aVar.jvX;
                this.mFacebeautyCheeckThin = aVar.jvY;
                this.mFacebeautyEnlargeEye = aVar.jvZ;
                this.mFacebeautyRedLevel = aVar.jwa;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jCW) {
                int i = this.jCO + 1;
                this.jCO = i;
                if (i == 100) {
                    this.jCO = 0;
                    this.jCN = System.currentTimeMillis();
                    this.jCP = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jCK.updateTexImage();
                    this.jCK.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.jiP != null) {
                        this.jiP.au(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jCR.sendEmptyMessage(1);
                }
                if (this.jCL.jCF != null) {
                    this.jCL.jCF.ry(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jCT) {
                    this.jCL.requestRender();
                    return;
                }
                int i2 = (this.jCL.jCB.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jCS) {
                    faceunity.fuItemSetParam(this.jyA, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jyA, "rotationAngle", cuK() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cuK() ? 270.0d : 90.0d);
                }
                this.jCL.jCB.cuK();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jCM;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jCP = (System.currentTimeMillis() - currentTimeMillis) + this.jCP;
                try {
                    this.jyB.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jCL.jCH) {
                        b(gl10);
                        this.jCL.jCH = false;
                    }
                    if (this.jCU != null && this.jCU.CV(2) && this.jCL.jCB != null) {
                        this.jCV = this.jCL.jCB.cuN();
                        this.jCU.a(new d.b(new File(this.jCV), GLVideoPreviewView.jCz, GLVideoPreviewView.jCA, 2097152, null, this.jCK.getTimestamp()));
                    }
                    if (this.jCU != null && this.jCU.CV(1)) {
                        this.jCU.a(this.jyB, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jCE) {
                            this.jCU.d(this.jCK);
                        }
                        boolean unused = GLVideoPreviewView.jCE = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jCL.g((Camera) null);
                    if (this.jiP != null) {
                        this.jiP.au(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jCU = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jCL.mSurfaceViewWidth;
                int i2 = this.jCL.mSurfaceViewHeight;
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
                if (this.jCL != null && (context = this.jCL.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                L(bitmap);
            }
        }

        private void L(final Bitmap bitmap) {
            this.jCX = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jCL != null && this.jCL.jCG != null) {
                    this.jCL.jCG.z(false, this.jCX);
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
                        b.this.jCX = com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.jwg, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jCL != null && b.this.jCL.jCG != null) {
                        b.this.jCL.jCG.z(true, b.this.jCX);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean cuK() {
            return this.jCL.jCB.cuK();
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
                this.mContext.get();
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        try {
                            if (StringUtils.isNull(b.this.mEffectFileName)) {
                                b.this.itemsArray[1] = b.this.mEffectItem = 0;
                                b.this.itemsArray[2] = b.this.jyA = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jCS) {
                                b.this.jyA = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jyA;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jyA, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jyA, "rotationAngle", b.this.cuK() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jyA = 0;
                                b.this.itemsArray[2] = b.this.jyA;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.cuK() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.jiP != null) {
                                b.this.jiP.au(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.jCT = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.jiP != null) {
                                b.this.jiP.au(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jCT = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.jiP != null) {
                                b.this.jiP.au(26, com.baidu.tieba.j.a.o(e3));
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
            this.jCL.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jyB != null) {
                        b.this.jyB.release(false);
                        b.this.jyB = null;
                    }
                    if (b.this.jCJ != null) {
                        b.this.jCJ.release(false);
                        b.this.jCJ = null;
                    }
                    if (b.this.jCK != null) {
                        b.this.jCK.release();
                        b.this.jCK = null;
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

        private void cuL() {
            if (this.jCL != null) {
                Handler mainHandler = this.jCL.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jyA != 0) {
                    faceunity.fuItemSetParam(this.jyA, "rotationAngle", cuK() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cuK() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jCS = false;
                } else {
                    this.jCS = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jCR.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jCF = aVar;
        }
    }
}
