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
    private static int nsj = 720;
    private static int nsk = TbConfig.HEAD_IMG_SIZE;
    private static boolean nso;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private com.baidu.tieba.k.h mYk;
    protected h nsl;
    private b nsm;
    private com.faceunity.a.d nsn;
    private a nsp;
    private g.a nsq;
    private boolean nsr;

    /* loaded from: classes23.dex */
    public interface a {
        void yd(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mYk = lVar.det();
        }
        this.nsl = hVar;
        this.nsm = new b(context, this, this.mYk);
        setEGLContextClientVersion(2);
        setRenderer(this.nsm);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nsm);
                camera.setPreviewTexture(this.nsm.nsu);
                this.nsm.nsu.setOnFrameAvailableListener(this.nsm);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mYk != null) {
                    this.mYk.bF(20, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nsn = new com.faceunity.a.d();
            this.nsm.a(this.nsn);
            nso = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mYk != null) {
                this.mYk.bF(21, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nsn != null) {
                this.nsn.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mYk != null) {
                this.mYk.bF(19, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nsn != null) {
            this.nsn.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nsm.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mYk != null) {
                this.mYk.bF(18, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nsm.cny = i;
            this.nsm.cnz = i2;
            int round = Math.round(((i * 1.0f) / i2) * nsj);
            if (round % 2 == 1) {
                round--;
            }
            if (nsk == 960) {
                nsk = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nsq = aVar;
        this.nsr = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nsl == null) {
            return false;
        }
        return this.nsl.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nsm == null) {
            return;
        }
        this.nsm.dQt();
    }

    public void dQp() {
        if (this.nsm == null) {
            return;
        }
        this.nsm.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nsm != null) {
            this.nsm.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nsm != null) {
            this.nsm.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nsm != null) {
            this.nsm.setSticker(stickerItem);
        }
    }

    public void dQq() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nsm != null) {
                    GLVideoPreviewView.this.nsm.dQq();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nsm.nsG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nsl.getMainHandler();
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
        private com.baidu.tieba.k.h mYk;
        private com.faceunity.gles.c nof;
        private Handler nsB;
        private boolean nsC;
        private boolean nsD;
        com.faceunity.a.d nsE;
        String nsF;
        private boolean nsG;
        private String nsH;
        private com.faceunity.gles.c nst;
        private volatile SurfaceTexture nsu;
        private GLVideoPreviewView nsv;
        private int nsw;
        protected int cny = 720;
        protected int cnz = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int noe = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.noe};
        private boolean isNeedEffectItem = true;
        private long nsx = 0;
        private int nsy = 0;
        private long nsz = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nsA = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.nsv = gLVideoPreviewView;
            this.mYk = hVar;
            this.nsA.start();
            this.nsB = new a(this.nsA.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Kx(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dQt() {
            this.nsB.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nsv.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nof = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nst = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nsw = this.nst.createTextureObject();
            dQq();
            boolean unused = GLVideoPreviewView.nso = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nsv.mSurfaceViewWidth = i;
            this.nsv.mSurfaceViewHeight = i2;
        }

        public void dQq() {
            if (this.nsu != null) {
                faceunity.fuOnCameraChange();
                this.nsu.release();
            }
            this.nsu = new SurfaceTexture(this.nsw);
            dQv();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nlF;
                this.mFacebeautyBlurLevel = aVar.nlG;
                this.mFacebeautyCheeckThin = aVar.nlH;
                this.mFacebeautyEnlargeEye = aVar.nlI;
                this.mFacebeautyRedLevel = aVar.nlJ;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nsG) {
                int i = this.nsy + 1;
                this.nsy = i;
                if (i == 100) {
                    this.nsy = 0;
                    this.nsx = System.currentTimeMillis();
                    this.nsz = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nsu.updateTexImage();
                    this.nsu.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mYk != null) {
                        this.mYk.bF(22, com.baidu.tieba.k.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nsB.sendEmptyMessage(1);
                }
                if (this.nsv.nsp != null) {
                    this.nsv.nsp.yd(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nsD) {
                    this.nsv.requestRender();
                    return;
                }
                int i2 = (this.nsv.nsl.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nsC) {
                    faceunity.fuItemSetParam(this.noe, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.noe, "rotationAngle", dQu() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dQu() ? 270.0d : 90.0d);
                }
                this.nsv.nsl.dQu();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nsw;
                int i4 = this.cny;
                int i5 = this.cnz;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nsz = (System.currentTimeMillis() - currentTimeMillis) + this.nsz;
                try {
                    this.nof.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nsv.nsr) {
                        b(gl10);
                        this.nsv.nsr = false;
                    }
                    if (this.nsE != null && this.nsE.PT(2) && this.nsv.nsl != null) {
                        this.nsF = this.nsv.nsl.dQx();
                        this.nsE.a(new d.b(new File(this.nsF), GLVideoPreviewView.nsj, GLVideoPreviewView.nsk, 2097152, null, this.nsu.getTimestamp()));
                    }
                    if (this.nsE != null && this.nsE.PT(1)) {
                        this.nsE.a(this.nof, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nso) {
                            this.nsE.e(this.nsu);
                        }
                        boolean unused = GLVideoPreviewView.nso = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nsv.g((Camera) null);
                    if (this.mYk != null) {
                        this.mYk.bF(23, com.baidu.tieba.k.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nsE = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nsv.mSurfaceViewWidth;
                int i2 = this.nsv.mSurfaceViewHeight;
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
                if (this.nsv != null && (context = this.nsv.getContext()) != null && (context instanceof Activity)) {
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
            this.nsH = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nsv != null && this.nsv.nsq != null) {
                    this.nsv.nsq.F(false, this.nsH);
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
                        b.this.nsH = n.saveFileAsPic(com.baidu.tieba.video.c.nlQ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nsv != null && b.this.nsv.nsq != null) {
                        b.this.nsv.nsq.F(true, b.this.nsH);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dQu() {
            return this.nsv.nsl.dQu();
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
                                b.this.itemsArray[2] = b.this.noe = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nsC) {
                                b.this.noe = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.noe;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.noe, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.noe, "rotationAngle", b.this.dQu() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.noe = 0;
                                b.this.itemsArray[2] = b.this.noe;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dQu() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.mYk != null) {
                                b.this.mYk.bF(24, com.baidu.tieba.k.a.r(e));
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
                            b.this.nsD = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.mYk != null) {
                                b.this.mYk.bF(25, com.baidu.tieba.k.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nsD = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.mYk != null) {
                                b.this.mYk.bF(26, com.baidu.tieba.k.a.r(e3));
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
            this.nsv.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nof != null) {
                        b.this.nof.release(false);
                        b.this.nof = null;
                    }
                    if (b.this.nst != null) {
                        b.this.nst.release(false);
                        b.this.nst = null;
                    }
                    if (b.this.nsu != null) {
                        b.this.nsu.release();
                        b.this.nsu = null;
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

        private void dQv() {
            if (this.nsv != null) {
                Handler mainHandler = this.nsv.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.noe != 0) {
                    faceunity.fuItemSetParam(this.noe, "rotationAngle", dQu() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dQu() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nsC = false;
                } else {
                    this.nsC = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nsB.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nsp = aVar;
        }
    }
}
