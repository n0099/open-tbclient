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
/* loaded from: classes17.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int mAp = 720;
    private static int mAq = TbConfig.HEAD_IMG_SIZE;
    private static boolean mAu;
    protected h mAr;
    private b mAs;
    private com.faceunity.a.d mAt;
    private a mAv;
    private g.a mAw;
    private boolean mAx;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private com.baidu.tieba.k.h mgu;

    /* loaded from: classes17.dex */
    public interface a {
        void wN(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mgu = lVar.cRu();
        }
        this.mAr = hVar;
        this.mAs = new b(context, this, this.mgu);
        setEGLContextClientVersion(2);
        setRenderer(this.mAs);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.mAs);
                camera.setPreviewTexture(this.mAs.mAA);
                this.mAs.mAA.setOnFrameAvailableListener(this.mAs);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mgu != null) {
                    this.mgu.bm(20, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.mAt = new com.faceunity.a.d();
            this.mAs.a(this.mAt);
            mAu = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mgu != null) {
                this.mgu.bm(21, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.mAt != null) {
                this.mAt.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mgu != null) {
                this.mgu.bm(19, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.mAt != null) {
            this.mAt.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.mAs.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mgu != null) {
                this.mgu.bm(18, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mAs.bNI = i;
            this.mAs.bNJ = i2;
            int round = Math.round(((i * 1.0f) / i2) * mAp);
            if (round % 2 == 1) {
                round--;
            }
            if (mAq == 960) {
                mAq = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mAw = aVar;
        this.mAx = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mAr == null) {
            return false;
        }
        return this.mAr.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.mAs == null) {
            return;
        }
        this.mAs.dDd();
    }

    public void dCZ() {
        if (this.mAs == null) {
            return;
        }
        this.mAs.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.mAs != null) {
            this.mAs.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.mAs != null) {
            this.mAs.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.mAs != null) {
            this.mAs.setSticker(stickerItem);
        }
    }

    public void dDa() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.mAs != null) {
                    GLVideoPreviewView.this.mAs.dDa();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.mAs.mAM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.mAr.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private volatile SurfaceTexture mAA;
        private GLVideoPreviewView mAB;
        private int mAC;
        private Handler mAH;
        private boolean mAI;
        private boolean mAJ;
        com.faceunity.a.d mAK;
        String mAL;
        private boolean mAM;
        private String mAN;
        private com.faceunity.gles.c mAz;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.baidu.tieba.k.h mgu;
        private com.faceunity.gles.c mwl;
        protected int bNI = 720;
        protected int bNJ = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int mwk = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.mwk};
        private boolean isNeedEffectItem = true;
        private long mAD = 0;
        private int mAE = 0;
        private long mAF = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread mAG = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.mAB = gLVideoPreviewView;
            this.mgu = hVar;
            this.mAG.start();
            this.mAH = new a(this.mAG.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.II(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dDd() {
            this.mAH.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.mAB.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.mwl = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.mAz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mAC = this.mAz.createTextureObject();
            dDa();
            boolean unused = GLVideoPreviewView.mAu = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.mAB.mSurfaceViewWidth = i;
            this.mAB.mSurfaceViewHeight = i2;
        }

        public void dDa() {
            if (this.mAA != null) {
                faceunity.fuOnCameraChange();
                this.mAA.release();
            }
            this.mAA = new SurfaceTexture(this.mAC);
            dDf();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.mtK;
                this.mFacebeautyBlurLevel = aVar.mtL;
                this.mFacebeautyCheeckThin = aVar.mtM;
                this.mFacebeautyEnlargeEye = aVar.mtN;
                this.mFacebeautyRedLevel = aVar.mtO;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.mAM) {
                int i = this.mAE + 1;
                this.mAE = i;
                if (i == 100) {
                    this.mAE = 0;
                    this.mAD = System.currentTimeMillis();
                    this.mAF = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.mAA.updateTexImage();
                    this.mAA.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mgu != null) {
                        this.mgu.bm(22, com.baidu.tieba.k.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.mAH.sendEmptyMessage(1);
                }
                if (this.mAB.mAv != null) {
                    this.mAB.mAv.wN(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.mAJ) {
                    this.mAB.requestRender();
                    return;
                }
                int i2 = (this.mAB.mAr.mCameraId != 1 ? 32 : 0) | 1;
                if (this.mAI) {
                    faceunity.fuItemSetParam(this.mwk, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mwk, "rotationAngle", dDe() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dDe() ? 270.0d : 90.0d);
                }
                this.mAB.mAr.dDe();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.mAC;
                int i4 = this.bNI;
                int i5 = this.bNJ;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.mAF = (System.currentTimeMillis() - currentTimeMillis) + this.mAF;
                try {
                    this.mwl.drawFrame(fuDualInputToTexture, fArr);
                    if (this.mAB.mAx) {
                        b(gl10);
                        this.mAB.mAx = false;
                    }
                    if (this.mAK != null && this.mAK.Mw(2) && this.mAB.mAr != null) {
                        this.mAL = this.mAB.mAr.dDh();
                        this.mAK.a(new d.b(new File(this.mAL), GLVideoPreviewView.mAp, GLVideoPreviewView.mAq, 2097152, null, this.mAA.getTimestamp()));
                    }
                    if (this.mAK != null && this.mAK.Mw(1)) {
                        this.mAK.a(this.mwl, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.mAu) {
                            this.mAK.e(this.mAA);
                        }
                        boolean unused = GLVideoPreviewView.mAu = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.mAB.g((Camera) null);
                    if (this.mgu != null) {
                        this.mgu.bm(23, com.baidu.tieba.k.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.mAK = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.mAB.mSurfaceViewWidth;
                int i2 = this.mAB.mSurfaceViewHeight;
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
                if (this.mAB != null && (context = this.mAB.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                T(bitmap);
            }
        }

        private void T(final Bitmap bitmap) {
            this.mAN = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.mAB != null && this.mAB.mAw != null) {
                    this.mAB.mAw.D(false, this.mAN);
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
                        b.this.mAN = n.saveFileAsPic(com.baidu.tieba.video.c.mtV, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.mAB != null && b.this.mAB.mAw != null) {
                        b.this.mAB.mAw.D(true, b.this.mAN);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dDe() {
            return this.mAB.mAr.dDe();
        }

        /* loaded from: classes17.dex */
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
                                b.this.itemsArray[2] = b.this.mwk = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.mAI) {
                                b.this.mwk = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.mwk;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.mwk, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mwk, "rotationAngle", b.this.dDe() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.mwk = 0;
                                b.this.itemsArray[2] = b.this.mwk;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dDe() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.mgu != null) {
                                b.this.mgu.bm(24, com.baidu.tieba.k.a.r(e));
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
                            b.this.mAJ = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.mgu != null) {
                                b.this.mgu.bm(25, com.baidu.tieba.k.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.mAJ = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.mgu != null) {
                                b.this.mgu.bm(26, com.baidu.tieba.k.a.r(e3));
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
            this.mAB.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mwl != null) {
                        b.this.mwl.release(false);
                        b.this.mwl = null;
                    }
                    if (b.this.mAz != null) {
                        b.this.mAz.release(false);
                        b.this.mAz = null;
                    }
                    if (b.this.mAA != null) {
                        b.this.mAA.release();
                        b.this.mAA = null;
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

        private void dDf() {
            if (this.mAB != null) {
                Handler mainHandler = this.mAB.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.mwk != 0) {
                    faceunity.fuItemSetParam(this.mwk, "rotationAngle", dDe() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dDe() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.mAI = false;
                } else {
                    this.mAI = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.mAH.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.mAv = aVar;
        }
    }
}
