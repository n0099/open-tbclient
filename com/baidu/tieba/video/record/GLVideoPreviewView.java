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
/* loaded from: classes8.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int kzQ = 720;
    private static int kzR = TbConfig.HEAD_IMG_SIZE;
    private static boolean kzV;
    private com.baidu.tieba.j.h kgF;
    protected h kzS;
    private b kzT;
    private com.faceunity.a.d kzU;
    private a kzW;
    private g.a kzX;
    private boolean kzY;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void tq(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kgF = lVar.cfr();
        }
        this.kzS = hVar;
        this.kzT = new b(context, this, this.kgF);
        setEGLContextClientVersion(2);
        setRenderer(this.kzT);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.kzT);
                camera.setPreviewTexture(this.kzT.kAb);
                this.kzT.kAb.setOnFrameAvailableListener(this.kzT);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kgF != null) {
                    this.kgF.aP(20, com.baidu.tieba.j.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.kzU = new com.faceunity.a.d();
            this.kzT.a(this.kzU);
            kzV = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.kgF != null) {
                this.kgF.aP(21, com.baidu.tieba.j.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.kzU != null) {
                this.kzU.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.kgF != null) {
                this.kgF.aP(19, com.baidu.tieba.j.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.kzU != null) {
            this.kzU.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.kzT.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kgF != null) {
                this.kgF.aP(18, com.baidu.tieba.j.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.kzT.previewWidth = i;
            this.kzT.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * kzQ);
            if (round % 2 == 1) {
                round--;
            }
            kzR = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.kzX = aVar;
        this.kzY = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kzS == null) {
            return false;
        }
        return this.kzS.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.kzT == null) {
            return;
        }
        this.kzT.cPI();
    }

    public void cPE() {
        if (this.kzT == null) {
            return;
        }
        this.kzT.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.kzT != null) {
            this.kzT.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.kzT != null) {
            this.kzT.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.kzT != null) {
            this.kzT.setSticker(stickerItem);
        }
    }

    public void cPF() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.kzT != null) {
                    GLVideoPreviewView.this.kzT.cPF();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.kzT.kAl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.kzS.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c kAa;
        private volatile SurfaceTexture kAb;
        private GLVideoPreviewView kAc;
        private int kAd;
        private Handler kAh;
        private boolean kAi;
        com.faceunity.a.d kAj;
        String kAk;
        private boolean kAl;
        private String kAm;
        private com.baidu.tieba.j.h kgF;
        private com.faceunity.gles.c kvX;
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
        private long kAe = 0;
        private int kAf = 0;
        private long kAg = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread mCreateItemThread = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.kAc = gLVideoPreviewView;
            this.kgF = hVar;
            this.mCreateItemThread.start();
            this.kAh = new a(this.mCreateItemThread.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Dj(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cPI() {
            this.kAh.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.kAc.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.kvX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.kAa = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.kAd = this.kAa.createTextureObject();
            cPF();
            boolean unused = GLVideoPreviewView.kzV = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.kAc.mSurfaceViewWidth = i;
            this.kAc.mSurfaceViewHeight = i2;
        }

        public void cPF() {
            if (this.kAb != null) {
                faceunity.fuOnCameraChange();
                this.kAb.release();
            }
            this.kAb = new SurfaceTexture(this.kAd);
            cPJ();
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
            if (!this.kAl) {
                int i = this.kAf + 1;
                this.kAf = i;
                if (i == 100) {
                    this.kAf = 0;
                    this.kAe = System.currentTimeMillis();
                    this.kAg = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.kAb.updateTexImage();
                    this.kAb.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.kgF != null) {
                        this.kgF.aP(22, com.baidu.tieba.j.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.kAh.sendEmptyMessage(1);
                }
                if (this.kAc.kzW != null) {
                    this.kAc.kzW.tq(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.kAi) {
                    this.kAc.requestRender();
                    return;
                }
                int i2 = (this.kAc.kzS.mCameraId != 1 ? 32 : 0) | 1;
                if (this.mIsGestureItem) {
                    faceunity.fuItemSetParam(this.mGestureItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mGestureItem, "rotationAngle", getCameraIsBack() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", getCameraIsBack() ? 270.0d : 90.0d);
                }
                this.kAc.kzS.getCameraIsBack();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.kAd;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.kAg = (System.currentTimeMillis() - currentTimeMillis) + this.kAg;
                try {
                    this.kvX.drawFrame(fuDualInputToTexture, fArr);
                    if (this.kAc.kzY) {
                        b(gl10);
                        this.kAc.kzY = false;
                    }
                    if (this.kAj != null && this.kAj.checkRecordingStatus(2) && this.kAc.kzS != null) {
                        this.kAk = this.kAc.kzS.cPL();
                        this.kAj.a(new d.b(new File(this.kAk), GLVideoPreviewView.kzQ, GLVideoPreviewView.kzR, 2097152, null, this.kAb.getTimestamp()));
                    }
                    if (this.kAj != null && this.kAj.checkRecordingStatus(1)) {
                        this.kAj.a(this.kvX, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.kzV) {
                            this.kAj.frameAvailable(this.kAb);
                        }
                        boolean unused = GLVideoPreviewView.kzV = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.kAc.g((Camera) null);
                    if (this.kgF != null) {
                        this.kgF.aP(23, com.baidu.tieba.j.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.kAj = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.kAc.mSurfaceViewWidth;
                int i2 = this.kAc.mSurfaceViewHeight;
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
                if (this.kAc != null && (context = this.kAc.getContext()) != null && (context instanceof Activity)) {
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
            this.kAm = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.kAc != null && this.kAc.kzX != null) {
                    this.kAc.kzX.z(false, this.kAm);
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
                        b.this.kAm = com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.ktM, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.kAc != null && b.this.kAc.kzX != null) {
                        b.this.kAc.kzX.z(true, b.this.kAm);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean getCameraIsBack() {
            return this.kAc.kzS.getCameraIsBack();
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
                            if (b.this.kgF != null) {
                                b.this.kgF.aP(24, com.baidu.tieba.j.a.r(e));
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
                            b.this.kAi = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.kgF != null) {
                                b.this.kgF.aP(25, com.baidu.tieba.j.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.kAi = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.kgF != null) {
                                b.this.kgF.aP(26, com.baidu.tieba.j.a.r(e3));
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
            this.kAc.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.kvX != null) {
                        b.this.kvX.release(false);
                        b.this.kvX = null;
                    }
                    if (b.this.kAa != null) {
                        b.this.kAa.release(false);
                        b.this.kAa = null;
                    }
                    if (b.this.kAb != null) {
                        b.this.kAb.release();
                        b.this.kAb = null;
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

        private void cPJ() {
            if (this.kAc != null) {
                Handler mainHandler = this.kAc.getMainHandler();
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
            this.kAh.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.kzW = aVar;
        }
    }
}
