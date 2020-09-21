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
/* loaded from: classes22.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int mKf = 720;
    private static int mKg = TbConfig.HEAD_IMG_SIZE;
    private static boolean mKk;
    protected h mKh;
    private b mKi;
    private com.faceunity.a.d mKj;
    private a mKl;
    private g.a mKm;
    private boolean mKn;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private com.baidu.tieba.k.h mpU;

    /* loaded from: classes22.dex */
    public interface a {
        void wW(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
        }
        this.mKh = hVar;
        this.mKi = new b(context, this, this.mpU);
        setEGLContextClientVersion(2);
        setRenderer(this.mKi);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.mKi);
                camera.setPreviewTexture(this.mKi.mKq);
                this.mKi.mKq.setOnFrameAvailableListener(this.mKi);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mpU != null) {
                    this.mpU.bq(20, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.mKj = new com.faceunity.a.d();
            this.mKi.a(this.mKj);
            mKk = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mpU != null) {
                this.mpU.bq(21, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.mKj != null) {
                this.mKj.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mpU != null) {
                this.mpU.bq(19, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.mKj != null) {
            this.mKj.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.mKi.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mpU != null) {
                this.mpU.bq(18, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mKi.bPI = i;
            this.mKi.bPJ = i2;
            int round = Math.round(((i * 1.0f) / i2) * mKf);
            if (round % 2 == 1) {
                round--;
            }
            if (mKg == 960) {
                mKg = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mKm = aVar;
        this.mKn = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mKh == null) {
            return false;
        }
        return this.mKh.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.mKi == null) {
            return;
        }
        this.mKi.dGX();
    }

    public void dGT() {
        if (this.mKi == null) {
            return;
        }
        this.mKi.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.mKi != null) {
            this.mKi.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.mKi != null) {
            this.mKi.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.mKi != null) {
            this.mKi.setSticker(stickerItem);
        }
    }

    public void dGU() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.mKi != null) {
                    GLVideoPreviewView.this.mKi.dGU();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.mKi.mKC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.mKh.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private byte[] mCameraNV21Byte;
        private com.faceunity.gles.c mFW;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        com.faceunity.a.d mKA;
        String mKB;
        private boolean mKC;
        private String mKD;
        private com.faceunity.gles.c mKp;
        private volatile SurfaceTexture mKq;
        private GLVideoPreviewView mKr;
        private int mKs;
        private Handler mKx;
        private boolean mKy;
        private boolean mKz;
        private com.baidu.tieba.k.h mpU;
        protected int bPI = 720;
        protected int bPJ = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int mFV = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.mFV};
        private boolean isNeedEffectItem = true;
        private long mKt = 0;
        private int mKu = 0;
        private long mKv = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread mKw = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.mKr = gLVideoPreviewView;
            this.mpU = hVar;
            this.mKw.start();
            this.mKx = new a(this.mKw.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Jm(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dGX() {
            this.mKx.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.mKr.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.mFW = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.mKp = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mKs = this.mKp.createTextureObject();
            dGU();
            boolean unused = GLVideoPreviewView.mKk = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.mKr.mSurfaceViewWidth = i;
            this.mKr.mSurfaceViewHeight = i2;
        }

        public void dGU() {
            if (this.mKq != null) {
                faceunity.fuOnCameraChange();
                this.mKq.release();
            }
            this.mKq = new SurfaceTexture(this.mKs);
            dGZ();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.mDt;
                this.mFacebeautyBlurLevel = aVar.mDu;
                this.mFacebeautyCheeckThin = aVar.mDv;
                this.mFacebeautyEnlargeEye = aVar.mDw;
                this.mFacebeautyRedLevel = aVar.mDz;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.mKC) {
                int i = this.mKu + 1;
                this.mKu = i;
                if (i == 100) {
                    this.mKu = 0;
                    this.mKt = System.currentTimeMillis();
                    this.mKv = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.mKq.updateTexImage();
                    this.mKq.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mpU != null) {
                        this.mpU.bq(22, com.baidu.tieba.k.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.mKx.sendEmptyMessage(1);
                }
                if (this.mKr.mKl != null) {
                    this.mKr.mKl.wW(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.mKz) {
                    this.mKr.requestRender();
                    return;
                }
                int i2 = (this.mKr.mKh.mCameraId != 1 ? 32 : 0) | 1;
                if (this.mKy) {
                    faceunity.fuItemSetParam(this.mFV, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mFV, "rotationAngle", dGY() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dGY() ? 270.0d : 90.0d);
                }
                this.mKr.mKh.dGY();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.mKs;
                int i4 = this.bPI;
                int i5 = this.bPJ;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.mKv = (System.currentTimeMillis() - currentTimeMillis) + this.mKv;
                try {
                    this.mFW.drawFrame(fuDualInputToTexture, fArr);
                    if (this.mKr.mKn) {
                        b(gl10);
                        this.mKr.mKn = false;
                    }
                    if (this.mKA != null && this.mKA.Nb(2) && this.mKr.mKh != null) {
                        this.mKB = this.mKr.mKh.dHb();
                        this.mKA.a(new d.b(new File(this.mKB), GLVideoPreviewView.mKf, GLVideoPreviewView.mKg, 2097152, null, this.mKq.getTimestamp()));
                    }
                    if (this.mKA != null && this.mKA.Nb(1)) {
                        this.mKA.a(this.mFW, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.mKk) {
                            this.mKA.e(this.mKq);
                        }
                        boolean unused = GLVideoPreviewView.mKk = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.mKr.g((Camera) null);
                    if (this.mpU != null) {
                        this.mpU.bq(23, com.baidu.tieba.k.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.mKA = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.mKr.mSurfaceViewWidth;
                int i2 = this.mKr.mSurfaceViewHeight;
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
                if (this.mKr != null && (context = this.mKr.getContext()) != null && (context instanceof Activity)) {
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
            this.mKD = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.mKr != null && this.mKr.mKm != null) {
                    this.mKr.mKm.D(false, this.mKD);
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
                        b.this.mKD = n.saveFileAsPic(com.baidu.tieba.video.c.mDG, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.mKr != null && b.this.mKr.mKm != null) {
                        b.this.mKr.mKm.D(true, b.this.mKD);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dGY() {
            return this.mKr.mKh.dGY();
        }

        /* loaded from: classes22.dex */
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
                                b.this.itemsArray[2] = b.this.mFV = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.mKy) {
                                b.this.mFV = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.mFV;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.mFV, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mFV, "rotationAngle", b.this.dGY() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.mFV = 0;
                                b.this.itemsArray[2] = b.this.mFV;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dGY() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.mpU != null) {
                                b.this.mpU.bq(24, com.baidu.tieba.k.a.r(e));
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
                            b.this.mKz = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.mpU != null) {
                                b.this.mpU.bq(25, com.baidu.tieba.k.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.mKz = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.mpU != null) {
                                b.this.mpU.bq(26, com.baidu.tieba.k.a.r(e3));
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
            this.mKr.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mFW != null) {
                        b.this.mFW.release(false);
                        b.this.mFW = null;
                    }
                    if (b.this.mKp != null) {
                        b.this.mKp.release(false);
                        b.this.mKp = null;
                    }
                    if (b.this.mKq != null) {
                        b.this.mKq.release();
                        b.this.mKq = null;
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

        private void dGZ() {
            if (this.mKr != null) {
                Handler mainHandler = this.mKr.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.mFV != 0) {
                    faceunity.fuItemSetParam(this.mFV, "rotationAngle", dGY() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dGY() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.mKy = false;
                } else {
                    this.mKy = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.mKx.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.mKl = aVar;
        }
    }
}
