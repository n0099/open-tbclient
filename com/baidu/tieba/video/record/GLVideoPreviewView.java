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
    private static int nPP = 720;
    private static int nPQ = 960;
    private static boolean nPU;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h nPR;
    private b nPS;
    private com.faceunity.a.d nPT;
    private a nPV;
    private g.a nPW;
    private boolean nPX;
    private com.baidu.tieba.l.g nxU;

    /* loaded from: classes8.dex */
    public interface a {
        void ze(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nxU = kVar.dgY();
        }
        this.nPR = hVar;
        this.nPS = new b(context, this, this.nxU);
        setEGLContextClientVersion(2);
        setRenderer(this.nPS);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.nPS);
                camera.setPreviewTexture(this.nPS.nQa);
                this.nPS.nQa.setOnFrameAvailableListener(this.nPS);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nxU != null) {
                    this.nxU.bK(20, com.baidu.tieba.l.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.nPT = new com.faceunity.a.d();
            this.nPS.a(this.nPT);
            nPU = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nxU != null) {
                this.nxU.bK(21, com.baidu.tieba.l.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.nPT != null) {
                this.nPT.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.nxU != null) {
                this.nxU.bK(19, com.baidu.tieba.l.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.nPT != null) {
            this.nPT.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.nPS.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nxU != null) {
                this.nxU.bK(18, com.baidu.tieba.l.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.nPS.previewWidth = i;
            this.nPS.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * nPP);
            if (round % 2 == 1) {
                round--;
            }
            if (nPQ == 960) {
                nPQ = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.nPW = aVar;
        this.nPX = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nPR == null) {
            return false;
        }
        return this.nPR.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.nPS == null) {
            return;
        }
        this.nPS.dTJ();
    }

    public void dTF() {
        if (this.nPS == null) {
            return;
        }
        this.nPS.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.nPS != null) {
            this.nPS.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.nPS != null) {
            this.nPS.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.nPS != null) {
            this.nPS.setSticker(stickerItem);
        }
    }

    public void dTG() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.nPS != null) {
                    GLVideoPreviewView.this.nPS.dTG();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.nPS.nQl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.nPR.getMainHandler();
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
        private com.faceunity.gles.c nMB;
        private com.faceunity.gles.c nPZ;
        private volatile SurfaceTexture nQa;
        private GLVideoPreviewView nQb;
        private int nQc;
        private Handler nQh;
        private boolean nQi;
        private boolean nQj;
        com.faceunity.a.d nQk;
        private boolean nQl;
        private String nQm;
        private com.baidu.tieba.l.g nxU;
        String videoFileName;
        protected int previewWidth = 720;
        protected int previewHeight = 960;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nMA = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nMA};
        private boolean isNeedEffectItem = true;
        private long nQd = 0;
        private int nQe = 0;
        private long nQf = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread nQg = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.l.g gVar) {
            this.nQb = gLVideoPreviewView;
            this.nxU = gVar;
            this.nQg.start();
            this.nQh = new a(this.nQg.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Kt(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dTJ() {
            this.nQh.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.nQb.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.nMB = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nPZ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.nQc = this.nPZ.createTextureObject();
            dTG();
            boolean unused = GLVideoPreviewView.nPU = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.nQb.mSurfaceViewWidth = i;
            this.nQb.mSurfaceViewHeight = i2;
        }

        public void dTG() {
            if (this.nQa != null) {
                faceunity.fuOnCameraChange();
                this.nQa.release();
            }
            this.nQa = new SurfaceTexture(this.nQc);
            dTL();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.nKe;
                this.mFacebeautyBlurLevel = aVar.nKf;
                this.mFacebeautyCheeckThin = aVar.nKg;
                this.mFacebeautyEnlargeEye = aVar.nKh;
                this.mFacebeautyRedLevel = aVar.nKi;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nQl) {
                int i = this.nQe + 1;
                this.nQe = i;
                if (i == 100) {
                    this.nQe = 0;
                    this.nQd = System.currentTimeMillis();
                    this.nQf = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.nQa.updateTexImage();
                    this.nQa.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.nxU != null) {
                        this.nxU.bK(22, com.baidu.tieba.l.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.nQh.sendEmptyMessage(1);
                }
                if (this.nQb.nPV != null) {
                    this.nQb.nPV.ze(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.nQj) {
                    this.nQb.requestRender();
                    return;
                }
                int i2 = (this.nQb.nPR.mCameraId != 1 ? 32 : 0) | 1;
                if (this.nQi) {
                    faceunity.fuItemSetParam(this.nMA, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.nMA, "rotationAngle", dTK() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dTK() ? 270.0d : 90.0d);
                }
                this.nQb.nPR.dTK();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.nQc;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.nQf = (System.currentTimeMillis() - currentTimeMillis) + this.nQf;
                try {
                    this.nMB.drawFrame(fuDualInputToTexture, fArr);
                    if (this.nQb.nPX) {
                        b(gl10);
                        this.nQb.nPX = false;
                    }
                    if (this.nQk != null && this.nQk.Qs(2) && this.nQb.nPR != null) {
                        this.videoFileName = this.nQb.nPR.dTN();
                        this.nQk.a(new d.b(new File(this.videoFileName), GLVideoPreviewView.nPP, GLVideoPreviewView.nPQ, 2097152, null, this.nQa.getTimestamp()));
                    }
                    if (this.nQk != null && this.nQk.Qs(1)) {
                        this.nQk.a(this.nMB, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.nPU) {
                            this.nQk.d(this.nQa);
                        }
                        boolean unused = GLVideoPreviewView.nPU = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.nQb.g((Camera) null);
                    if (this.nxU != null) {
                        this.nxU.bK(23, com.baidu.tieba.l.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.nQk = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.nQb.mSurfaceViewWidth;
                int i2 = this.nQb.mSurfaceViewHeight;
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
                if (this.nQb != null && (context = this.nQb.getContext()) != null && (context instanceof Activity)) {
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
            this.nQm = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.nQb != null && this.nQb.nPW != null) {
                    this.nQb.nPW.O(false, this.nQm);
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
                        b.this.nQm = o.saveFileAsPic(com.baidu.tieba.video.c.nKp, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.nQb != null && b.this.nQb.nPW != null) {
                        b.this.nQb.nPW.O(true, b.this.nQm);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dTK() {
            return this.nQb.nPR.dTK();
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
                                b.this.itemsArray[2] = b.this.nMA = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.nQi) {
                                b.this.nMA = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.nMA;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.nMA, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.nMA, "rotationAngle", b.this.dTK() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.nMA = 0;
                                b.this.itemsArray[2] = b.this.nMA;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dTK() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.nxU != null) {
                                b.this.nxU.bK(24, com.baidu.tieba.l.a.o(e));
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
                            b.this.nQj = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.nxU != null) {
                                b.this.nxU.bK(25, com.baidu.tieba.l.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.nQj = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.nxU != null) {
                                b.this.nxU.bK(26, com.baidu.tieba.l.a.o(e3));
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
            this.nQb.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.nMB != null) {
                        b.this.nMB.release(false);
                        b.this.nMB = null;
                    }
                    if (b.this.nPZ != null) {
                        b.this.nPZ.release(false);
                        b.this.nPZ = null;
                    }
                    if (b.this.nQa != null) {
                        b.this.nQa.release();
                        b.this.nQa = null;
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

        private void dTL() {
            if (this.nQb != null) {
                Handler mainHandler = this.nQb.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.nMA != 0) {
                    faceunity.fuItemSetParam(this.nMA, "rotationAngle", dTK() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dTK() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.nQi = false;
                } else {
                    this.nQi = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.nQh.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.nPV = aVar;
        }
    }
}
