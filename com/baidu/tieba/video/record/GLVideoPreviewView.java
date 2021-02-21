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
/* loaded from: classes8.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int nQp = 720;
    private static int nQq = 960;
    private static boolean nQu;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h nQr;
    private b nQs;
    private com.faceunity.a.d nQt;
    private a nQv;
    private g.a nQw;
    private boolean nQx;
    private com.baidu.tieba.l.g nyu;

    /* loaded from: classes8.dex */
    public interface a {
        void ze(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nyu = kVar.dhf();
        }
        this.nQr = hVar;
        this.nQs = new b(context, this, this.nyu);
        setEGLContextClientVersion(2);
        setRenderer(this.nQs);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nQs);
                camera.setPreviewTexture(this.nQs.nQA);
                this.nQs.nQA.setOnFrameAvailableListener(this.nQs);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nyu != null) {
                    this.nyu.bK(20, com.baidu.tieba.l.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nQt = new com.faceunity.a.d();
            this.nQs.a(this.nQt);
            nQu = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nyu != null) {
                this.nyu.bK(21, com.baidu.tieba.l.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nQt != null) {
                this.nQt.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nyu != null) {
                this.nyu.bK(19, com.baidu.tieba.l.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nQt != null) {
            this.nQt.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nQs.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nyu != null) {
                this.nyu.bK(18, com.baidu.tieba.l.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nQs.previewWidth = i;
            this.nQs.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nQp);
            if (round % 2 == 1) {
                round--;
            }
            if (nQq == 960) {
                nQq = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nQw = aVar;
        this.nQx = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nQr == null) {
            return false;
        }
        return this.nQr.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nQs == null) {
            return;
        }
        this.nQs.dTR();
    }

    public void dTN() {
        if (this.nQs == null) {
            return;
        }
        this.nQs.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nQs != null) {
            this.nQs.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nQs != null) {
            this.nQs.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nQs != null) {
            this.nQs.setSticker(stickerItem);
        }
    }

    public void dTO() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nQs != null) {
                    GLVideoPreviewView.this.nQs.dTO();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nQs.nQL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nQr.getMainHandler();
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
        private com.faceunity.gles.c nNb;
        private volatile SurfaceTexture nQA;
        private GLVideoPreviewView nQB;
        private int nQC;
        private Handler nQH;
        private boolean nQI;
        private boolean nQJ;
        com.faceunity.a.d nQK;
        private boolean nQL;
        private String nQM;
        private com.faceunity.gles.c nQz;
        private com.baidu.tieba.l.g nyu;
        String videoFileName;
        protected int previewWidth = 720;
        protected int previewHeight = 960;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nNa = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nNa};
        private boolean isNeedEffectItem = true;
        private long nQD = 0;
        private int nQE = 0;
        private long nQF = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nQG = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.g gVar) {
            this.nQB = gLVideoPreviewView;
            this.nyu = gVar;
            this.nQG.start();
            this.nQH = new a(this.nQG.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Kt(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dTR() {
            this.nQH.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nQB.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nNb = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nQz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nQC = this.nQz.createTextureObject();
            dTO();
            boolean unused = GLVideoPreviewView.nQu = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nQB.mSurfaceViewWidth = i;
            this.nQB.mSurfaceViewHeight = i2;
        }

        public void dTO() {
            if (this.nQA != null) {
                faceunity.fuOnCameraChange();
                this.nQA.release();
            }
            this.nQA = new SurfaceTexture(this.nQC);
            dTT();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nKE;
                this.mFacebeautyBlurLevel = aVar.nKF;
                this.mFacebeautyCheeckThin = aVar.nKG;
                this.mFacebeautyEnlargeEye = aVar.nKH;
                this.mFacebeautyRedLevel = aVar.nKI;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nQL) {
                int i = this.nQE + 1;
                this.nQE = i;
                if (i == 100) {
                    this.nQE = 0;
                    this.nQD = System.currentTimeMillis();
                    this.nQF = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nQA.updateTexImage();
                    this.nQA.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.nyu != null) {
                        this.nyu.bK(22, com.baidu.tieba.l.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nQH.sendEmptyMessage(1);
                }
                if (this.nQB.nQv != null) {
                    this.nQB.nQv.ze(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nQJ) {
                    this.nQB.requestRender();
                    return;
                }
                int i2 = (this.nQB.nQr.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nQI) {
                    faceunity.fuItemSetParam(this.nNa, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nNa, "rotationAngle", dTS() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dTS() ? 270.0d : 90.0d);
                }
                this.nQB.nQr.dTS();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nQC;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nQF = (System.currentTimeMillis() - currentTimeMillis) + this.nQF;
                try {
                    this.nNb.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nQB.nQx) {
                        b(gl10);
                        this.nQB.nQx = false;
                    }
                    if (this.nQK != null && this.nQK.Qt(2) && this.nQB.nQr != null) {
                        this.videoFileName = this.nQB.nQr.dTV();
                        this.nQK.a(new d.b(new File(this.videoFileName), GLVideoPreviewView.nQp, GLVideoPreviewView.nQq, 2097152, null, this.nQA.getTimestamp()));
                    }
                    if (this.nQK != null && this.nQK.Qt(1)) {
                        this.nQK.a(this.nNb, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nQu) {
                            this.nQK.d(this.nQA);
                        }
                        boolean unused = GLVideoPreviewView.nQu = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nQB.g((Camera) null);
                    if (this.nyu != null) {
                        this.nyu.bK(23, com.baidu.tieba.l.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nQK = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nQB.mSurfaceViewWidth;
                int i2 = this.nQB.mSurfaceViewHeight;
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
                if (this.nQB != null && (context = this.nQB.getContext()) != null && (context instanceof Activity)) {
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
            this.nQM = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nQB != null && this.nQB.nQw != null) {
                    this.nQB.nQw.O(false, this.nQM);
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
                        b.this.nQM = o.saveFileAsPic(com.baidu.tieba.video.c.nKP, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nQB != null && b.this.nQB.nQw != null) {
                        b.this.nQB.nQw.O(true, b.this.nQM);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dTS() {
            return this.nQB.nQr.dTS();
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
                                b.this.itemsArray[2] = b.this.nNa = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nQI) {
                                b.this.nNa = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nNa;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nNa, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nNa, "rotationAngle", b.this.dTS() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nNa = 0;
                                b.this.itemsArray[2] = b.this.nNa;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dTS() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.nyu != null) {
                                b.this.nyu.bK(24, com.baidu.tieba.l.a.o(e));
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
                            b.this.nQJ = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.nyu != null) {
                                b.this.nyu.bK(25, com.baidu.tieba.l.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nQJ = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.nyu != null) {
                                b.this.nyu.bK(26, com.baidu.tieba.l.a.o(e3));
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
            this.nQB.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nNb != null) {
                        b.this.nNb.release(false);
                        b.this.nNb = null;
                    }
                    if (b.this.nQz != null) {
                        b.this.nQz.release(false);
                        b.this.nQz = null;
                    }
                    if (b.this.nQA != null) {
                        b.this.nQA.release();
                        b.this.nQA = null;
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

        private void dTT() {
            if (this.nQB != null) {
                Handler mainHandler = this.nQB.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nNa != 0) {
                    faceunity.fuItemSetParam(this.nNa, "rotationAngle", dTS() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dTS() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nQI = false;
                } else {
                    this.nQI = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nQH.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nQv = aVar;
        }
    }
}
