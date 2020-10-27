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
    private static int nmm = 720;
    private static int nmn = TbConfig.HEAD_IMG_SIZE;
    private static boolean nmr;
    private com.baidu.tieba.k.h mSh;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h nmo;
    private b nmp;
    private com.faceunity.a.d nmq;
    private a nms;
    private g.a nmt;
    private boolean nmu;

    /* loaded from: classes23.dex */
    public interface a {
        void xU(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mSh = lVar.dbR();
        }
        this.nmo = hVar;
        this.nmp = new b(context, this, this.mSh);
        setEGLContextClientVersion(2);
        setRenderer(this.nmp);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nmp);
                camera.setPreviewTexture(this.nmp.nmx);
                this.nmp.nmx.setOnFrameAvailableListener(this.nmp);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mSh != null) {
                    this.mSh.bB(20, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nmq = new com.faceunity.a.d();
            this.nmp.a(this.nmq);
            nmr = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mSh != null) {
                this.mSh.bB(21, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nmq != null) {
                this.nmq.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mSh != null) {
                this.mSh.bB(19, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nmq != null) {
            this.nmq.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nmp.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mSh != null) {
                this.mSh.bB(18, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nmp.chC = i;
            this.nmp.chD = i2;
            int round = Math.round(((i * 1.0f) / i2) * nmm);
            if (round % 2 == 1) {
                round--;
            }
            if (nmn == 960) {
                nmn = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nmt = aVar;
        this.nmu = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nmo == null) {
            return false;
        }
        return this.nmo.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nmp == null) {
            return;
        }
        this.nmp.dNR();
    }

    public void dNN() {
        if (this.nmp == null) {
            return;
        }
        this.nmp.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nmp != null) {
            this.nmp.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nmp != null) {
            this.nmp.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nmp != null) {
            this.nmp.setSticker(stickerItem);
        }
    }

    public void dNO() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nmp != null) {
                    GLVideoPreviewView.this.nmp.dNO();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nmp.nmJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nmo.getMainHandler();
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
        private com.baidu.tieba.k.h mSh;
        private com.faceunity.gles.c nik;
        private Handler nmE;
        private boolean nmF;
        private boolean nmG;
        com.faceunity.a.d nmH;
        String nmI;
        private boolean nmJ;
        private String nmK;
        private com.faceunity.gles.c nmw;
        private volatile SurfaceTexture nmx;
        private GLVideoPreviewView nmy;
        private int nmz;
        protected int chC = 720;
        protected int chD = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nij = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nij};
        private boolean isNeedEffectItem = true;
        private long nmA = 0;
        private int nmB = 0;
        private long nmC = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nmD = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.nmy = gLVideoPreviewView;
            this.mSh = hVar;
            this.nmD.start();
            this.nmE = new a(this.nmD.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Kk(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dNR() {
            this.nmE.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nmy.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nik = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nmw = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nmz = this.nmw.createTextureObject();
            dNO();
            boolean unused = GLVideoPreviewView.nmr = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nmy.mSurfaceViewWidth = i;
            this.nmy.mSurfaceViewHeight = i2;
        }

        public void dNO() {
            if (this.nmx != null) {
                faceunity.fuOnCameraChange();
                this.nmx.release();
            }
            this.nmx = new SurfaceTexture(this.nmz);
            dNT();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nfJ;
                this.mFacebeautyBlurLevel = aVar.nfK;
                this.mFacebeautyCheeckThin = aVar.nfL;
                this.mFacebeautyEnlargeEye = aVar.nfM;
                this.mFacebeautyRedLevel = aVar.nfN;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nmJ) {
                int i = this.nmB + 1;
                this.nmB = i;
                if (i == 100) {
                    this.nmB = 0;
                    this.nmA = System.currentTimeMillis();
                    this.nmC = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nmx.updateTexImage();
                    this.nmx.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mSh != null) {
                        this.mSh.bB(22, com.baidu.tieba.k.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nmE.sendEmptyMessage(1);
                }
                if (this.nmy.nms != null) {
                    this.nmy.nms.xU(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nmG) {
                    this.nmy.requestRender();
                    return;
                }
                int i2 = (this.nmy.nmo.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nmF) {
                    faceunity.fuItemSetParam(this.nij, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nij, "rotationAngle", dNS() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dNS() ? 270.0d : 90.0d);
                }
                this.nmy.nmo.dNS();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nmz;
                int i4 = this.chC;
                int i5 = this.chD;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nmC = (System.currentTimeMillis() - currentTimeMillis) + this.nmC;
                try {
                    this.nik.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nmy.nmu) {
                        b(gl10);
                        this.nmy.nmu = false;
                    }
                    if (this.nmH != null && this.nmH.Py(2) && this.nmy.nmo != null) {
                        this.nmI = this.nmy.nmo.dNV();
                        this.nmH.a(new d.b(new File(this.nmI), GLVideoPreviewView.nmm, GLVideoPreviewView.nmn, 2097152, null, this.nmx.getTimestamp()));
                    }
                    if (this.nmH != null && this.nmH.Py(1)) {
                        this.nmH.a(this.nik, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nmr) {
                            this.nmH.e(this.nmx);
                        }
                        boolean unused = GLVideoPreviewView.nmr = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nmy.g((Camera) null);
                    if (this.mSh != null) {
                        this.mSh.bB(23, com.baidu.tieba.k.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nmH = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nmy.mSurfaceViewWidth;
                int i2 = this.nmy.mSurfaceViewHeight;
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
                if (this.nmy != null && (context = this.nmy.getContext()) != null && (context instanceof Activity)) {
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
            this.nmK = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nmy != null && this.nmy.nmt != null) {
                    this.nmy.nmt.F(false, this.nmK);
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
                        b.this.nmK = n.saveFileAsPic(com.baidu.tieba.video.c.nfU, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nmy != null && b.this.nmy.nmt != null) {
                        b.this.nmy.nmt.F(true, b.this.nmK);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dNS() {
            return this.nmy.nmo.dNS();
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
                                b.this.itemsArray[2] = b.this.nij = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nmF) {
                                b.this.nij = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nij;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nij, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nij, "rotationAngle", b.this.dNS() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nij = 0;
                                b.this.itemsArray[2] = b.this.nij;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dNS() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.mSh != null) {
                                b.this.mSh.bB(24, com.baidu.tieba.k.a.r(e));
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
                            b.this.nmG = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.mSh != null) {
                                b.this.mSh.bB(25, com.baidu.tieba.k.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nmG = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.mSh != null) {
                                b.this.mSh.bB(26, com.baidu.tieba.k.a.r(e3));
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
            this.nmy.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nik != null) {
                        b.this.nik.release(false);
                        b.this.nik = null;
                    }
                    if (b.this.nmw != null) {
                        b.this.nmw.release(false);
                        b.this.nmw = null;
                    }
                    if (b.this.nmx != null) {
                        b.this.nmx.release();
                        b.this.nmx = null;
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

        private void dNT() {
            if (this.nmy != null) {
                Handler mainHandler = this.nmy.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nij != 0) {
                    faceunity.fuItemSetParam(this.nij, "rotationAngle", dNS() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dNS() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nmF = false;
                } else {
                    this.nmF = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nmE.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nms = aVar;
        }
    }
}
