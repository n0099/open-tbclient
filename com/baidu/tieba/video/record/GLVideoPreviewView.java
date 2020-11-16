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
    private static int ntq = 720;
    private static int ntr = TbConfig.HEAD_IMG_SIZE;
    private static boolean ntv;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private com.baidu.tieba.l.h mZc;
    protected h nts;
    private b ntt;
    private com.faceunity.a.d ntu;
    private a ntw;
    private g.a ntx;
    private boolean nty;

    /* loaded from: classes22.dex */
    public interface a {
        void yk(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.mZc = lVar.ddQ();
        }
        this.nts = hVar;
        this.ntt = new b(context, this, this.mZc);
        setEGLContextClientVersion(2);
        setRenderer(this.ntt);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.ntt);
                camera.setPreviewTexture(this.ntt.ntB);
                this.ntt.ntB.setOnFrameAvailableListener(this.ntt);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mZc != null) {
                    this.mZc.bD(20, com.baidu.tieba.l.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.ntu = new com.faceunity.a.d();
            this.ntt.a(this.ntu);
            ntv = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mZc != null) {
                this.mZc.bD(21, com.baidu.tieba.l.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.ntu != null) {
                this.ntu.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mZc != null) {
                this.mZc.bD(19, com.baidu.tieba.l.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.ntu != null) {
            this.ntu.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.ntt.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mZc != null) {
                this.mZc.bD(18, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.ntt.clM = i;
            this.ntt.clN = i2;
            int round = Math.round(((i * 1.0f) / i2) * ntq);
            if (round % 2 == 1) {
                round--;
            }
            if (ntr == 960) {
                ntr = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.ntx = aVar;
        this.nty = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nts == null) {
            return false;
        }
        return this.nts.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.ntt == null) {
            return;
        }
        this.ntt.dQs();
    }

    public void dQo() {
        if (this.ntt == null) {
            return;
        }
        this.ntt.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.ntt != null) {
            this.ntt.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.ntt != null) {
            this.ntt.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.ntt != null) {
            this.ntt.setSticker(stickerItem);
        }
    }

    public void dQp() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.ntt != null) {
                    GLVideoPreviewView.this.ntt.dQp();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.ntt.ntN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nts.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.baidu.tieba.l.h mZc;
        private com.faceunity.gles.c npo;
        private com.faceunity.gles.c ntA;
        private volatile SurfaceTexture ntB;
        private GLVideoPreviewView ntC;
        private int ntD;
        private Handler ntI;
        private boolean ntJ;
        private boolean ntK;
        com.faceunity.a.d ntL;
        String ntM;
        private boolean ntN;
        private String ntO;
        protected int clM = 720;
        protected int clN = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int npn = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.npn};
        private boolean isNeedEffectItem = true;
        private long ntE = 0;
        private int ntF = 0;
        private long ntG = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread ntH = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.h hVar) {
            this.ntC = gLVideoPreviewView;
            this.mZc = hVar;
            this.ntH.start();
            this.ntI = new a(this.ntH.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.La(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dQs() {
            this.ntI.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.ntC.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.npo = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.ntA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.ntD = this.ntA.createTextureObject();
            dQp();
            boolean unused = GLVideoPreviewView.ntv = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.ntC.mSurfaceViewWidth = i;
            this.ntC.mSurfaceViewHeight = i2;
        }

        public void dQp() {
            if (this.ntB != null) {
                faceunity.fuOnCameraChange();
                this.ntB.release();
            }
            this.ntB = new SurfaceTexture(this.ntD);
            dQu();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nmM;
                this.mFacebeautyBlurLevel = aVar.nmN;
                this.mFacebeautyCheeckThin = aVar.nmO;
                this.mFacebeautyEnlargeEye = aVar.nmP;
                this.mFacebeautyRedLevel = aVar.nmQ;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.ntN) {
                int i = this.ntF + 1;
                this.ntF = i;
                if (i == 100) {
                    this.ntF = 0;
                    this.ntE = System.currentTimeMillis();
                    this.ntG = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.ntB.updateTexImage();
                    this.ntB.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mZc != null) {
                        this.mZc.bD(22, com.baidu.tieba.l.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.ntI.sendEmptyMessage(1);
                }
                if (this.ntC.ntw != null) {
                    this.ntC.ntw.yk(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.ntK) {
                    this.ntC.requestRender();
                    return;
                }
                int i2 = (this.ntC.nts.mCameraId != 1 ? 32 : 0) | 1;
                if (this.ntJ) {
                    faceunity.fuItemSetParam(this.npn, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.npn, "rotationAngle", dQt() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dQt() ? 270.0d : 90.0d);
                }
                this.ntC.nts.dQt();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.ntD;
                int i4 = this.clM;
                int i5 = this.clN;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.ntG = (System.currentTimeMillis() - currentTimeMillis) + this.ntG;
                try {
                    this.npo.drawFrame(fuDualInputToTexture, fArr);
                    if (this.ntC.nty) {
                        b(gl10);
                        this.ntC.nty = false;
                    }
                    if (this.ntL != null && this.ntL.Qw(2) && this.ntC.nts != null) {
                        this.ntM = this.ntC.nts.dQw();
                        this.ntL.a(new d.b(new File(this.ntM), GLVideoPreviewView.ntq, GLVideoPreviewView.ntr, 2097152, null, this.ntB.getTimestamp()));
                    }
                    if (this.ntL != null && this.ntL.Qw(1)) {
                        this.ntL.a(this.npo, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.ntv) {
                            this.ntL.e(this.ntB);
                        }
                        boolean unused = GLVideoPreviewView.ntv = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.ntC.g((Camera) null);
                    if (this.mZc != null) {
                        this.mZc.bD(23, com.baidu.tieba.l.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.ntL = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.ntC.mSurfaceViewWidth;
                int i2 = this.ntC.mSurfaceViewHeight;
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
                if (this.ntC != null && (context = this.ntC.getContext()) != null && (context instanceof Activity)) {
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
            this.ntO = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.ntC != null && this.ntC.ntx != null) {
                    this.ntC.ntx.G(false, this.ntO);
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
                        b.this.ntO = n.saveFileAsPic(com.baidu.tieba.video.c.nmX, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.ntC != null && b.this.ntC.ntx != null) {
                        b.this.ntC.ntx.G(true, b.this.ntO);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dQt() {
            return this.ntC.nts.dQt();
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
                                b.this.itemsArray[2] = b.this.npn = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.ntJ) {
                                b.this.npn = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.npn;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.npn, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.npn, "rotationAngle", b.this.dQt() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.npn = 0;
                                b.this.itemsArray[2] = b.this.npn;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dQt() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.mZc != null) {
                                b.this.mZc.bD(24, com.baidu.tieba.l.a.r(e));
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
                            b.this.ntK = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.mZc != null) {
                                b.this.mZc.bD(25, com.baidu.tieba.l.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.ntK = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.mZc != null) {
                                b.this.mZc.bD(26, com.baidu.tieba.l.a.r(e3));
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
            this.ntC.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.npo != null) {
                        b.this.npo.release(false);
                        b.this.npo = null;
                    }
                    if (b.this.ntA != null) {
                        b.this.ntA.release(false);
                        b.this.ntA = null;
                    }
                    if (b.this.ntB != null) {
                        b.this.ntB.release();
                        b.this.ntB = null;
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

        private void dQu() {
            if (this.ntC != null) {
                Handler mainHandler = this.ntC.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.npn != 0) {
                    faceunity.fuItemSetParam(this.npn, "rotationAngle", dQt() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dQt() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.ntJ = false;
                } else {
                    this.ntJ = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.ntI.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.ntw = aVar;
        }
    }
}
