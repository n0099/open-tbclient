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
/* loaded from: classes10.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int lnl = 720;
    private static int lnm = TbConfig.HEAD_IMG_SIZE;
    private static boolean lnq;
    private com.baidu.tieba.k.h kTM;
    protected h lnn;
    private b lno;
    private com.faceunity.a.d lnp;
    private a lnr;
    private g.a lns;
    private boolean lnt;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void uC(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.kTM = lVar.crY();
        }
        this.lnn = hVar;
        this.lno = new b(context, this, this.kTM);
        setEGLContextClientVersion(2);
        setRenderer(this.lno);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.lno);
                camera.setPreviewTexture(this.lno.lnw);
                this.lno.lnw.setOnFrameAvailableListener(this.lno);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kTM != null) {
                    this.kTM.be(20, com.baidu.tieba.k.a.s(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.lnp = new com.faceunity.a.d();
            this.lno.a(this.lnp);
            lnq = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.kTM != null) {
                this.kTM.be(21, com.baidu.tieba.k.a.s(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.lnp != null) {
                this.lnp.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.kTM != null) {
                this.kTM.be(19, com.baidu.tieba.k.a.s(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.lnp != null) {
            this.lnp.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.lno.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kTM != null) {
                this.kTM.be(18, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.lno.previewWidth = i;
            this.lno.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * lnl);
            if (round % 2 == 1) {
                round--;
            }
            lnm = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.lns = aVar;
        this.lnt = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lnn == null) {
            return false;
        }
        return this.lnn.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.lno == null) {
            return;
        }
        this.lno.dcw();
    }

    public void dcs() {
        if (this.lno == null) {
            return;
        }
        this.lno.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.lno != null) {
            this.lno.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.lno != null) {
            this.lno.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.lno != null) {
            this.lno.setSticker(stickerItem);
        }
    }

    public void dct() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.lno != null) {
                    GLVideoPreviewView.this.lno.dct();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.lno.lnI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.lnn.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.k.h kTM;
        private com.faceunity.gles.c ljk;
        private Handler lnD;
        private boolean lnE;
        private boolean lnF;
        com.faceunity.a.d lnG;
        String lnH;
        private boolean lnI;
        private String lnJ;
        private com.faceunity.gles.c lnv;
        private volatile SurfaceTexture lnw;
        private GLVideoPreviewView lnx;
        private int lny;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int ljj = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.ljj};
        private boolean isNeedEffectItem = true;
        private long lnz = 0;
        private int lnA = 0;
        private long lnB = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread lnC = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.lnx = gLVideoPreviewView;
            this.kTM = hVar;
            this.lnC.start();
            this.lnD = new a(this.lnC.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Eb(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dcw() {
            this.lnD.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.lnx.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.ljk = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.lnv = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.lny = this.lnv.createTextureObject();
            dct();
            boolean unused = GLVideoPreviewView.lnq = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.lnx.mSurfaceViewWidth = i;
            this.lnx.mSurfaceViewHeight = i2;
        }

        public void dct() {
            if (this.lnw != null) {
                faceunity.fuOnCameraChange();
                this.lnw.release();
            }
            this.lnw = new SurfaceTexture(this.lny);
            dcy();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.lgN;
                this.mFacebeautyBlurLevel = aVar.lgO;
                this.mFacebeautyCheeckThin = aVar.lgP;
                this.mFacebeautyEnlargeEye = aVar.lgQ;
                this.mFacebeautyRedLevel = aVar.lgR;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.lnI) {
                int i = this.lnA + 1;
                this.lnA = i;
                if (i == 100) {
                    this.lnA = 0;
                    this.lnz = System.currentTimeMillis();
                    this.lnB = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.lnw.updateTexImage();
                    this.lnw.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.kTM != null) {
                        this.kTM.be(22, com.baidu.tieba.k.a.s(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.lnD.sendEmptyMessage(1);
                }
                if (this.lnx.lnr != null) {
                    this.lnx.lnr.uC(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.lnF) {
                    this.lnx.requestRender();
                    return;
                }
                int i2 = (this.lnx.lnn.mCameraId != 1 ? 32 : 0) | 1;
                if (this.lnE) {
                    faceunity.fuItemSetParam(this.ljj, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.ljj, "rotationAngle", dcx() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dcx() ? 270.0d : 90.0d);
                }
                this.lnx.lnn.dcx();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.lny;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.lnB = (System.currentTimeMillis() - currentTimeMillis) + this.lnB;
                try {
                    this.ljk.drawFrame(fuDualInputToTexture, fArr);
                    if (this.lnx.lnt) {
                        b(gl10);
                        this.lnx.lnt = false;
                    }
                    if (this.lnG != null && this.lnG.HC(2) && this.lnx.lnn != null) {
                        this.lnH = this.lnx.lnn.dcA();
                        this.lnG.a(new d.b(new File(this.lnH), GLVideoPreviewView.lnl, GLVideoPreviewView.lnm, 2097152, null, this.lnw.getTimestamp()));
                    }
                    if (this.lnG != null && this.lnG.HC(1)) {
                        this.lnG.a(this.ljk, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.lnq) {
                            this.lnG.e(this.lnw);
                        }
                        boolean unused = GLVideoPreviewView.lnq = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.lnx.g((Camera) null);
                    if (this.kTM != null) {
                        this.kTM.be(23, com.baidu.tieba.k.a.s(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.lnG = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.lnx.mSurfaceViewWidth;
                int i2 = this.lnx.mSurfaceViewHeight;
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
                if (this.lnx != null && (context = this.lnx.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                O(bitmap);
            }
        }

        private void O(final Bitmap bitmap) {
            this.lnJ = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.lnx != null && this.lnx.lns != null) {
                    this.lnx.lns.A(false, this.lnJ);
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
                        b.this.lnJ = com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.lgX, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.lnx != null && b.this.lnx.lns != null) {
                        b.this.lnx.lns.A(true, b.this.lnJ);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dcx() {
            return this.lnx.lnn.dcx();
        }

        /* loaded from: classes10.dex */
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
                                b.this.itemsArray[2] = b.this.ljj = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.lnE) {
                                b.this.ljj = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.ljj;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.ljj, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.ljj, "rotationAngle", b.this.dcx() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.ljj = 0;
                                b.this.itemsArray[2] = b.this.ljj;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dcx() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.kTM != null) {
                                b.this.kTM.be(24, com.baidu.tieba.k.a.s(e));
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
                            b.this.lnF = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.kTM != null) {
                                b.this.kTM.be(25, com.baidu.tieba.k.a.s(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.lnF = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.kTM != null) {
                                b.this.kTM.be(26, com.baidu.tieba.k.a.s(e3));
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
            this.lnx.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.ljk != null) {
                        b.this.ljk.release(false);
                        b.this.ljk = null;
                    }
                    if (b.this.lnv != null) {
                        b.this.lnv.release(false);
                        b.this.lnv = null;
                    }
                    if (b.this.lnw != null) {
                        b.this.lnw.release();
                        b.this.lnw = null;
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

        private void dcy() {
            if (this.lnx != null) {
                Handler mainHandler = this.lnx.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.ljj != 0) {
                    faceunity.fuItemSetParam(this.ljj, "rotationAngle", dcx() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dcx() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.lnE = false;
                } else {
                    this.lnE = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.lnD.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.lnr = aVar;
        }
    }
}
