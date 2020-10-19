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
    private static int mZM = 720;
    private static int mZN = TbConfig.HEAD_IMG_SIZE;
    private static boolean mZR;
    private com.baidu.tieba.k.h mFB;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h mZO;
    private b mZP;
    private com.faceunity.a.d mZQ;
    private a mZS;
    private g.a mZT;
    private boolean mZU;

    /* loaded from: classes23.dex */
    public interface a {
        void xD(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mFB = lVar.cYJ();
        }
        this.mZO = hVar;
        this.mZP = new b(context, this, this.mFB);
        setEGLContextClientVersion(2);
        setRenderer(this.mZP);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.mZP);
                camera.setPreviewTexture(this.mZP.mZX);
                this.mZP.mZX.setOnFrameAvailableListener(this.mZP);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mFB != null) {
                    this.mFB.bA(20, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.mZQ = new com.faceunity.a.d();
            this.mZP.a(this.mZQ);
            mZR = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mFB != null) {
                this.mFB.bA(21, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.mZQ != null) {
                this.mZQ.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mFB != null) {
                this.mFB.bA(19, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.mZQ != null) {
            this.mZQ.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.mZP.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mFB != null) {
                this.mFB.bA(18, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mZP.bZe = i;
            this.mZP.bZf = i2;
            int round = Math.round(((i * 1.0f) / i2) * mZM);
            if (round % 2 == 1) {
                round--;
            }
            if (mZN == 960) {
                mZN = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mZT = aVar;
        this.mZU = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mZO == null) {
            return false;
        }
        return this.mZO.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.mZP == null) {
            return;
        }
        this.mZP.dKJ();
    }

    public void dKF() {
        if (this.mZP == null) {
            return;
        }
        this.mZP.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.mZP != null) {
            this.mZP.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.mZP != null) {
            this.mZP.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.mZP != null) {
            this.mZP.setSticker(stickerItem);
        }
    }

    public void dKG() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.mZP != null) {
                    GLVideoPreviewView.this.mZP.dKG();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.mZP.naj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.mZO.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private byte[] mCameraNV21Byte;
        private com.baidu.tieba.k.h mFB;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c mVJ;
        private com.faceunity.gles.c mZW;
        private volatile SurfaceTexture mZX;
        private GLVideoPreviewView mZY;
        private int mZZ;
        private Handler nae;
        private boolean naf;
        private boolean nag;
        com.faceunity.a.d nah;
        String nai;
        private boolean naj;
        private String nak;
        protected int bZe = 720;
        protected int bZf = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int mVI = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.mVI};
        private boolean isNeedEffectItem = true;
        private long naa = 0;
        private int nab = 0;
        private long nac = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nad = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.mZY = gLVideoPreviewView;
            this.mFB = hVar;
            this.nad.start();
            this.nae = new a(this.nad.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.JS(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKJ() {
            this.nae.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.mZY.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.mVJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.mZW = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mZZ = this.mZW.createTextureObject();
            dKG();
            boolean unused = GLVideoPreviewView.mZR = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.mZY.mSurfaceViewWidth = i;
            this.mZY.mSurfaceViewHeight = i2;
        }

        public void dKG() {
            if (this.mZX != null) {
                faceunity.fuOnCameraChange();
                this.mZX.release();
            }
            this.mZX = new SurfaceTexture(this.mZZ);
            dKL();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.mTg;
                this.mFacebeautyBlurLevel = aVar.mTh;
                this.mFacebeautyCheeckThin = aVar.mTi;
                this.mFacebeautyEnlargeEye = aVar.mTk;
                this.mFacebeautyRedLevel = aVar.mTl;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.naj) {
                int i = this.nab + 1;
                this.nab = i;
                if (i == 100) {
                    this.nab = 0;
                    this.naa = System.currentTimeMillis();
                    this.nac = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.mZX.updateTexImage();
                    this.mZX.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mFB != null) {
                        this.mFB.bA(22, com.baidu.tieba.k.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nae.sendEmptyMessage(1);
                }
                if (this.mZY.mZS != null) {
                    this.mZY.mZS.xD(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nag) {
                    this.mZY.requestRender();
                    return;
                }
                int i2 = (this.mZY.mZO.mCameraId != 1 ? 32 : 0) | 1;
                if (this.naf) {
                    faceunity.fuItemSetParam(this.mVI, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mVI, "rotationAngle", dKK() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dKK() ? 270.0d : 90.0d);
                }
                this.mZY.mZO.dKK();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.mZZ;
                int i4 = this.bZe;
                int i5 = this.bZf;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nac = (System.currentTimeMillis() - currentTimeMillis) + this.nac;
                try {
                    this.mVJ.drawFrame(fuDualInputToTexture, fArr);
                    if (this.mZY.mZU) {
                        b(gl10);
                        this.mZY.mZU = false;
                    }
                    if (this.nah != null && this.nah.NH(2) && this.mZY.mZO != null) {
                        this.nai = this.mZY.mZO.dKN();
                        this.nah.a(new d.b(new File(this.nai), GLVideoPreviewView.mZM, GLVideoPreviewView.mZN, 2097152, null, this.mZX.getTimestamp()));
                    }
                    if (this.nah != null && this.nah.NH(1)) {
                        this.nah.a(this.mVJ, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.mZR) {
                            this.nah.e(this.mZX);
                        }
                        boolean unused = GLVideoPreviewView.mZR = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.mZY.g((Camera) null);
                    if (this.mFB != null) {
                        this.mFB.bA(23, com.baidu.tieba.k.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nah = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.mZY.mSurfaceViewWidth;
                int i2 = this.mZY.mSurfaceViewHeight;
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
                if (this.mZY != null && (context = this.mZY.getContext()) != null && (context instanceof Activity)) {
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
            this.nak = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.mZY != null && this.mZY.mZT != null) {
                    this.mZY.mZT.D(false, this.nak);
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
                        b.this.nak = n.saveFileAsPic(com.baidu.tieba.video.c.mTt, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.mZY != null && b.this.mZY.mZT != null) {
                        b.this.mZY.mZT.D(true, b.this.nak);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dKK() {
            return this.mZY.mZO.dKK();
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
                                b.this.itemsArray[2] = b.this.mVI = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.naf) {
                                b.this.mVI = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.mVI;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.mVI, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mVI, "rotationAngle", b.this.dKK() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.mVI = 0;
                                b.this.itemsArray[2] = b.this.mVI;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dKK() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.mFB != null) {
                                b.this.mFB.bA(24, com.baidu.tieba.k.a.r(e));
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
                            b.this.nag = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.mFB != null) {
                                b.this.mFB.bA(25, com.baidu.tieba.k.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nag = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.mFB != null) {
                                b.this.mFB.bA(26, com.baidu.tieba.k.a.r(e3));
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
            this.mZY.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mVJ != null) {
                        b.this.mVJ.release(false);
                        b.this.mVJ = null;
                    }
                    if (b.this.mZW != null) {
                        b.this.mZW.release(false);
                        b.this.mZW = null;
                    }
                    if (b.this.mZX != null) {
                        b.this.mZX.release();
                        b.this.mZX = null;
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

        private void dKL() {
            if (this.mZY != null) {
                Handler mainHandler = this.mZY.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.mVI != 0) {
                    faceunity.fuItemSetParam(this.mVI, "rotationAngle", dKK() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dKK() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.naf = false;
                } else {
                    this.naf = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nae.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.mZS = aVar;
        }
    }
}
