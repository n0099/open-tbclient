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
    private static int nGf = 720;
    private static int nGg = TbConfig.HEAD_IMG_SIZE;
    private static boolean nGk;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h nGh;
    private b nGi;
    private com.faceunity.a.d nGj;
    private a nGl;
    private g.a nGm;
    private boolean nGn;
    private com.baidu.tieba.l.g noh;

    /* loaded from: classes7.dex */
    public interface a {
        void yL(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.noh = kVar.deY();
        }
        this.nGh = hVar;
        this.nGi = new b(context, this, this.noh);
        setEGLContextClientVersion(2);
        setRenderer(this.nGi);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nGi);
                camera.setPreviewTexture(this.nGi.nGq);
                this.nGi.nGq.setOnFrameAvailableListener(this.nGi);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.noh != null) {
                    this.noh.bE(20, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nGj = new com.faceunity.a.d();
            this.nGi.a(this.nGj);
            nGk = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.noh != null) {
                this.noh.bE(21, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nGj != null) {
                this.nGj.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.noh != null) {
                this.noh.bE(19, com.baidu.tieba.l.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nGj != null) {
            this.nGj.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nGi.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.noh != null) {
                this.noh.bE(18, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nGi.previewWidth = i;
            this.nGi.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nGf);
            if (round % 2 == 1) {
                round--;
            }
            if (nGg == 960) {
                nGg = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nGm = aVar;
        this.nGn = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nGh == null) {
            return false;
        }
        return this.nGh.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nGi == null) {
            return;
        }
        this.nGi.dRy();
    }

    public void dRu() {
        if (this.nGi == null) {
            return;
        }
        this.nGi.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nGi != null) {
            this.nGi.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nGi != null) {
            this.nGi.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nGi != null) {
            this.nGi.setSticker(stickerItem);
        }
    }

    public void dRv() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nGi != null) {
                    GLVideoPreviewView.this.nGi.dRv();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nGi.nGC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nGh.getMainHandler();
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
        private com.faceunity.gles.c nCQ;
        com.faceunity.a.d nGA;
        String nGB;
        private boolean nGC;
        private String nGD;
        private com.faceunity.gles.c nGp;
        private volatile SurfaceTexture nGq;
        private GLVideoPreviewView nGr;
        private int nGs;
        private Handler nGx;
        private boolean nGy;
        private boolean nGz;
        private com.baidu.tieba.l.g noh;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nCP = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nCP};
        private boolean isNeedEffectItem = true;
        private long nGt = 0;
        private int nGu = 0;
        private long nGv = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nGw = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.g gVar) {
            this.nGr = gLVideoPreviewView;
            this.noh = gVar;
            this.nGw.start();
            this.nGx = new a(this.nGw.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.JZ(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dRy() {
            this.nGx.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nGr.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nCQ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nGp = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nGs = this.nGp.createTextureObject();
            dRv();
            boolean unused = GLVideoPreviewView.nGk = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nGr.mSurfaceViewWidth = i;
            this.nGr.mSurfaceViewHeight = i2;
        }

        public void dRv() {
            if (this.nGq != null) {
                faceunity.fuOnCameraChange();
                this.nGq.release();
            }
            this.nGq = new SurfaceTexture(this.nGs);
            dRA();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nAt;
                this.mFacebeautyBlurLevel = aVar.nAu;
                this.mFacebeautyCheeckThin = aVar.nAv;
                this.mFacebeautyEnlargeEye = aVar.nAw;
                this.mFacebeautyRedLevel = aVar.nAx;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nGC) {
                int i = this.nGu + 1;
                this.nGu = i;
                if (i == 100) {
                    this.nGu = 0;
                    this.nGt = System.currentTimeMillis();
                    this.nGv = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nGq.updateTexImage();
                    this.nGq.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.noh != null) {
                        this.noh.bE(22, com.baidu.tieba.l.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nGx.sendEmptyMessage(1);
                }
                if (this.nGr.nGl != null) {
                    this.nGr.nGl.yL(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nGz) {
                    this.nGr.requestRender();
                    return;
                }
                int i2 = (this.nGr.nGh.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nGy) {
                    faceunity.fuItemSetParam(this.nCP, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nCP, "rotationAngle", dRz() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dRz() ? 270.0d : 90.0d);
                }
                this.nGr.nGh.dRz();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nGs;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nGv = (System.currentTimeMillis() - currentTimeMillis) + this.nGv;
                try {
                    this.nCQ.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nGr.nGn) {
                        b(gl10);
                        this.nGr.nGn = false;
                    }
                    if (this.nGA != null && this.nGA.PX(2) && this.nGr.nGh != null) {
                        this.nGB = this.nGr.nGh.dRC();
                        this.nGA.a(new d.b(new File(this.nGB), GLVideoPreviewView.nGf, GLVideoPreviewView.nGg, 2097152, null, this.nGq.getTimestamp()));
                    }
                    if (this.nGA != null && this.nGA.PX(1)) {
                        this.nGA.a(this.nCQ, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nGk) {
                            this.nGA.d(this.nGq);
                        }
                        boolean unused = GLVideoPreviewView.nGk = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nGr.g((Camera) null);
                    if (this.noh != null) {
                        this.noh.bE(23, com.baidu.tieba.l.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nGA = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nGr.mSurfaceViewWidth;
                int i2 = this.nGr.mSurfaceViewHeight;
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
                if (this.nGr != null && (context = this.nGr.getContext()) != null && (context instanceof Activity)) {
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
            this.nGD = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nGr != null && this.nGr.nGm != null) {
                    this.nGr.nGm.G(false, this.nGD);
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
                        b.this.nGD = n.saveFileAsPic(com.baidu.tieba.video.c.nAE, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nGr != null && b.this.nGr.nGm != null) {
                        b.this.nGr.nGm.G(true, b.this.nGD);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dRz() {
            return this.nGr.nGh.dRz();
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
                                b.this.itemsArray[2] = b.this.nCP = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nGy) {
                                b.this.nCP = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nCP;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nCP, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nCP, "rotationAngle", b.this.dRz() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nCP = 0;
                                b.this.itemsArray[2] = b.this.nCP;
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
                            if (b.this.noh != null) {
                                b.this.noh.bE(24, com.baidu.tieba.l.a.p(e));
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
                            b.this.nGz = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.noh != null) {
                                b.this.noh.bE(25, com.baidu.tieba.l.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nGz = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.noh != null) {
                                b.this.noh.bE(26, com.baidu.tieba.l.a.p(e3));
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
            this.nGr.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nCQ != null) {
                        b.this.nCQ.release(false);
                        b.this.nCQ = null;
                    }
                    if (b.this.nGp != null) {
                        b.this.nGp.release(false);
                        b.this.nGp = null;
                    }
                    if (b.this.nGq != null) {
                        b.this.nGq.release();
                        b.this.nGq = null;
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
            if (this.nGr != null) {
                Handler mainHandler = this.nGr.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nCP != 0) {
                    faceunity.fuItemSetParam(this.nCP, "rotationAngle", dRz() ? 270.0d : 90.0d);
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
                    this.nGy = false;
                } else {
                    this.nGy = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nGx.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nGl = aVar;
        }
    }
}
