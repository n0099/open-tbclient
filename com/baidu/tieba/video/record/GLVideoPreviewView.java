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
/* loaded from: classes10.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int kAQ = 720;
    private static int kAR = TbConfig.HEAD_IMG_SIZE;
    private static boolean kAV;
    protected h kAS;
    private b kAT;
    private com.faceunity.a.d kAU;
    private a kAW;
    private g.a kAX;
    private boolean kAY;
    private com.baidu.tieba.k.h khL;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void tu(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.khL = lVar.cgW();
        }
        this.kAS = hVar;
        this.kAT = new b(context, this, this.khL);
        setEGLContextClientVersion(2);
        setRenderer(this.kAT);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.kAT);
                camera.setPreviewTexture(this.kAT.kBb);
                this.kAT.kBb.setOnFrameAvailableListener(this.kAT);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.khL != null) {
                    this.khL.aP(20, com.baidu.tieba.k.a.q(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.kAU = new com.faceunity.a.d();
            this.kAT.a(this.kAU);
            kAV = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.khL != null) {
                this.khL.aP(21, com.baidu.tieba.k.a.q(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.kAU != null) {
                this.kAU.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.khL != null) {
                this.khL.aP(19, com.baidu.tieba.k.a.q(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.kAU != null) {
            this.kAU.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.kAT.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.khL != null) {
                this.khL.aP(18, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.kAT.previewWidth = i;
            this.kAT.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * kAQ);
            if (round % 2 == 1) {
                round--;
            }
            kAR = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.kAX = aVar;
        this.kAY = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kAS == null) {
            return false;
        }
        return this.kAS.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.kAT == null) {
            return;
        }
        this.kAT.cRd();
    }

    public void cQZ() {
        if (this.kAT == null) {
            return;
        }
        this.kAT.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.kAT != null) {
            this.kAT.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.kAT != null) {
            this.kAT.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.kAT != null) {
            this.kAT.setSticker(stickerItem);
        }
    }

    public void cRa() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.kAT != null) {
                    GLVideoPreviewView.this.kAT.cRa();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.kAT.kBl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.kAS.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c kBa;
        private volatile SurfaceTexture kBb;
        private GLVideoPreviewView kBc;
        private int kBd;
        private Handler kBh;
        private boolean kBi;
        com.faceunity.a.d kBj;
        String kBk;
        private boolean kBl;
        private String kBm;
        private com.baidu.tieba.k.h khL;
        private com.faceunity.gles.c kwX;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private boolean mIsGestureItem;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int mGestureItem = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.mGestureItem};
        private boolean isNeedEffectItem = true;
        private long kBe = 0;
        private int kBf = 0;
        private long kBg = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread mCreateItemThread = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.kBc = gLVideoPreviewView;
            this.khL = hVar;
            this.mCreateItemThread.start();
            this.kBh = new a(this.mCreateItemThread.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Dp(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cRd() {
            this.kBh.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.kBc.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.kwX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.kBa = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.kBd = this.kBa.createTextureObject();
            cRa();
            boolean unused = GLVideoPreviewView.kAV = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.kBc.mSurfaceViewWidth = i;
            this.kBc.mSurfaceViewHeight = i2;
        }

        public void cRa() {
            if (this.kBb != null) {
                faceunity.fuOnCameraChange();
                this.kBb.release();
            }
            this.kBb = new SurfaceTexture(this.kBd);
            cRe();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.beautyColorLevel;
                this.mFacebeautyBlurLevel = aVar.beautyBlurLevel;
                this.mFacebeautyCheeckThin = aVar.beautyCheeckThin;
                this.mFacebeautyEnlargeEye = aVar.beautyEnlargeEye;
                this.mFacebeautyRedLevel = aVar.beautyRedLevel;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.kBl) {
                int i = this.kBf + 1;
                this.kBf = i;
                if (i == 100) {
                    this.kBf = 0;
                    this.kBe = System.currentTimeMillis();
                    this.kBg = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.kBb.updateTexImage();
                    this.kBb.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.khL != null) {
                        this.khL.aP(22, com.baidu.tieba.k.a.q(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.kBh.sendEmptyMessage(1);
                }
                if (this.kBc.kAW != null) {
                    this.kBc.kAW.tu(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.kBi) {
                    this.kBc.requestRender();
                    return;
                }
                int i2 = (this.kBc.kAS.mCameraId != 1 ? 32 : 0) | 1;
                if (this.mIsGestureItem) {
                    faceunity.fuItemSetParam(this.mGestureItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mGestureItem, "rotationAngle", getCameraIsBack() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", getCameraIsBack() ? 270.0d : 90.0d);
                }
                this.kBc.kAS.getCameraIsBack();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.kBd;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.kBg = (System.currentTimeMillis() - currentTimeMillis) + this.kBg;
                try {
                    this.kwX.drawFrame(fuDualInputToTexture, fArr);
                    if (this.kBc.kAY) {
                        b(gl10);
                        this.kBc.kAY = false;
                    }
                    if (this.kBj != null && this.kBj.checkRecordingStatus(2) && this.kBc.kAS != null) {
                        this.kBk = this.kBc.kAS.cRg();
                        this.kBj.a(new d.b(new File(this.kBk), GLVideoPreviewView.kAQ, GLVideoPreviewView.kAR, 2097152, null, this.kBb.getTimestamp()));
                    }
                    if (this.kBj != null && this.kBj.checkRecordingStatus(1)) {
                        this.kBj.a(this.kwX, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.kAV) {
                            this.kBj.frameAvailable(this.kBb);
                        }
                        boolean unused = GLVideoPreviewView.kAV = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.kBc.g((Camera) null);
                    if (this.khL != null) {
                        this.khL.aP(23, com.baidu.tieba.k.a.q(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.kBj = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.kBc.mSurfaceViewWidth;
                int i2 = this.kBc.mSurfaceViewHeight;
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
                if (this.kBc != null && (context = this.kBc.getContext()) != null && (context instanceof Activity)) {
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
            this.kBm = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.kBc != null && this.kBc.kAX != null) {
                    this.kBc.kAX.z(false, this.kBm);
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
                        b.this.kBm = com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.kuO, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.kBc != null && b.this.kBc.kAX != null) {
                        b.this.kBc.kAX.z(true, b.this.kBm);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean getCameraIsBack() {
            return this.kBc.kAS.getCameraIsBack();
        }

        /* loaded from: classes10.dex */
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
                                b.this.itemsArray[2] = b.this.mGestureItem = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.mIsGestureItem) {
                                b.this.mGestureItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.mGestureItem;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.mGestureItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mGestureItem, "rotationAngle", b.this.getCameraIsBack() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.mGestureItem = 0;
                                b.this.itemsArray[2] = b.this.mGestureItem;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.getCameraIsBack() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.khL != null) {
                                b.this.khL.aP(24, com.baidu.tieba.k.a.q(e));
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
                            b.this.kBi = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.khL != null) {
                                b.this.khL.aP(25, com.baidu.tieba.k.a.q(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.kBi = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.khL != null) {
                                b.this.khL.aP(26, com.baidu.tieba.k.a.q(e3));
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
            this.kBc.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.kwX != null) {
                        b.this.kwX.release(false);
                        b.this.kwX = null;
                    }
                    if (b.this.kBa != null) {
                        b.this.kBa.release(false);
                        b.this.kBa = null;
                    }
                    if (b.this.kBb != null) {
                        b.this.kBb.release();
                        b.this.kBb = null;
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

        private void cRe() {
            if (this.kBc != null) {
                Handler mainHandler = this.kBc.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.mGestureItem != 0) {
                    faceunity.fuItemSetParam(this.mGestureItem, "rotationAngle", getCameraIsBack() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", getCameraIsBack() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.mIsGestureItem = false;
                } else {
                    this.mIsGestureItem = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.kBh.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.kAW = aVar;
        }
    }
}
