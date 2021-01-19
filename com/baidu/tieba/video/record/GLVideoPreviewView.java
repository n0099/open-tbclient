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
/* loaded from: classes7.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int nGg = 720;
    private static int nGh = TbConfig.HEAD_IMG_SIZE;
    private static boolean nGl;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h nGi;
    private b nGj;
    private com.faceunity.a.d nGk;
    private a nGm;
    private g.a nGn;
    private boolean nGo;
    private com.baidu.tieba.l.g noi;

    /* loaded from: classes7.dex */
    public interface a {
        void yL(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.noi = kVar.deY();
        }
        this.nGi = hVar;
        this.nGj = new b(context, this, this.noi);
        setEGLContextClientVersion(2);
        setRenderer(this.nGj);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nGj);
                camera.setPreviewTexture(this.nGj.nGr);
                this.nGj.nGr.setOnFrameAvailableListener(this.nGj);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.noi != null) {
                    this.noi.bE(20, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nGk = new com.faceunity.a.d();
            this.nGj.a(this.nGk);
            nGl = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.noi != null) {
                this.noi.bE(21, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nGk != null) {
                this.nGk.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.noi != null) {
                this.noi.bE(19, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nGk != null) {
            this.nGk.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nGj.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.noi != null) {
                this.noi.bE(18, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nGj.previewWidth = i;
            this.nGj.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nGg);
            if (round % 2 == 1) {
                round--;
            }
            if (nGh == 960) {
                nGh = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nGn = aVar;
        this.nGo = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nGi == null) {
            return false;
        }
        return this.nGi.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nGj == null) {
            return;
        }
        this.nGj.dRy();
    }

    public void dRu() {
        if (this.nGj == null) {
            return;
        }
        this.nGj.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nGj != null) {
            this.nGj.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nGj != null) {
            this.nGj.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nGj != null) {
            this.nGj.setSticker(stickerItem);
        }
    }

    public void dRv() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nGj != null) {
                    GLVideoPreviewView.this.nGj.dRv();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nGj.nGD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nGi.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c nCR;
        private boolean nGA;
        com.faceunity.a.d nGB;
        String nGC;
        private boolean nGD;
        private String nGE;
        private com.faceunity.gles.c nGq;
        private volatile SurfaceTexture nGr;
        private GLVideoPreviewView nGs;
        private int nGt;
        private Handler nGy;
        private boolean nGz;
        private com.baidu.tieba.l.g noi;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nCQ = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nCQ};
        private boolean isNeedEffectItem = true;
        private long nGu = 0;
        private int nGv = 0;
        private long nGw = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nGx = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.g gVar) {
            this.nGs = gLVideoPreviewView;
            this.noi = gVar;
            this.nGx.start();
            this.nGy = new a(this.nGx.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.JZ(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRy() {
            this.nGy.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nGs.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nCR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nGq = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nGt = this.nGq.createTextureObject();
            dRv();
            boolean unused = GLVideoPreviewView.nGl = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nGs.mSurfaceViewWidth = i;
            this.nGs.mSurfaceViewHeight = i2;
        }

        public void dRv() {
            if (this.nGr != null) {
                faceunity.fuOnCameraChange();
                this.nGr.release();
            }
            this.nGr = new SurfaceTexture(this.nGt);
            dRA();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nAu;
                this.mFacebeautyBlurLevel = aVar.nAv;
                this.mFacebeautyCheeckThin = aVar.nAw;
                this.mFacebeautyEnlargeEye = aVar.nAx;
                this.mFacebeautyRedLevel = aVar.nAy;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nGD) {
                int i = this.nGv + 1;
                this.nGv = i;
                if (i == 100) {
                    this.nGv = 0;
                    this.nGu = System.currentTimeMillis();
                    this.nGw = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nGr.updateTexImage();
                    this.nGr.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.noi != null) {
                        this.noi.bE(22, com.baidu.tieba.l.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nGy.sendEmptyMessage(1);
                }
                if (this.nGs.nGm != null) {
                    this.nGs.nGm.yL(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nGA) {
                    this.nGs.requestRender();
                    return;
                }
                int i2 = (this.nGs.nGi.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nGz) {
                    faceunity.fuItemSetParam(this.nCQ, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nCQ, "rotationAngle", dRz() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dRz() ? 270.0d : 90.0d);
                }
                this.nGs.nGi.dRz();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nGt;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nGw = (System.currentTimeMillis() - currentTimeMillis) + this.nGw;
                try {
                    this.nCR.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nGs.nGo) {
                        b(gl10);
                        this.nGs.nGo = false;
                    }
                    if (this.nGB != null && this.nGB.PX(2) && this.nGs.nGi != null) {
                        this.nGC = this.nGs.nGi.dRC();
                        this.nGB.a(new d.b(new File(this.nGC), GLVideoPreviewView.nGg, GLVideoPreviewView.nGh, 2097152, null, this.nGr.getTimestamp()));
                    }
                    if (this.nGB != null && this.nGB.PX(1)) {
                        this.nGB.a(this.nCR, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nGl) {
                            this.nGB.d(this.nGr);
                        }
                        boolean unused = GLVideoPreviewView.nGl = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nGs.g((Camera) null);
                    if (this.noi != null) {
                        this.noi.bE(23, com.baidu.tieba.l.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nGB = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nGs.mSurfaceViewWidth;
                int i2 = this.nGs.mSurfaceViewHeight;
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
                if (this.nGs != null && (context = this.nGs.getContext()) != null && (context instanceof Activity)) {
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
            this.nGE = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nGs != null && this.nGs.nGn != null) {
                    this.nGs.nGn.G(false, this.nGE);
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
                        b.this.nGE = n.saveFileAsPic(com.baidu.tieba.video.c.nAF, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nGs != null && b.this.nGs.nGn != null) {
                        b.this.nGs.nGn.G(true, b.this.nGE);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dRz() {
            return this.nGs.nGi.dRz();
        }

        /* loaded from: classes7.dex */
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
                                b.this.itemsArray[2] = b.this.nCQ = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nGz) {
                                b.this.nCQ = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nCQ;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nCQ, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nCQ, "rotationAngle", b.this.dRz() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nCQ = 0;
                                b.this.itemsArray[2] = b.this.nCQ;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dRz() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.noi != null) {
                                b.this.noi.bE(24, com.baidu.tieba.l.a.p(e));
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
                            b.this.nGA = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.noi != null) {
                                b.this.noi.bE(25, com.baidu.tieba.l.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nGA = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.noi != null) {
                                b.this.noi.bE(26, com.baidu.tieba.l.a.p(e3));
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
            this.nGs.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nCR != null) {
                        b.this.nCR.release(false);
                        b.this.nCR = null;
                    }
                    if (b.this.nGq != null) {
                        b.this.nGq.release(false);
                        b.this.nGq = null;
                    }
                    if (b.this.nGr != null) {
                        b.this.nGr.release();
                        b.this.nGr = null;
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

        private void dRA() {
            if (this.nGs != null) {
                Handler mainHandler = this.nGs.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nCQ != 0) {
                    faceunity.fuItemSetParam(this.nCQ, "rotationAngle", dRz() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dRz() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nGz = false;
                } else {
                    this.nGz = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nGy.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nGm = aVar;
        }
    }
}
