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
    private static int lFU = 720;
    private static int lFV = TbConfig.HEAD_IMG_SIZE;
    private static boolean lFZ;
    protected h lFW;
    private b lFX;
    private com.faceunity.a.d lFY;
    private a lGa;
    private g.a lGb;
    private boolean lGc;
    private com.baidu.tieba.k.h lmg;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void va(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lmg = lVar.cyB();
        }
        this.lFW = hVar;
        this.lFX = new b(context, this, this.lmg);
        setEGLContextClientVersion(2);
        setRenderer(this.lFX);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.lFX);
                camera.setPreviewTexture(this.lFX.lGf);
                this.lFX.lGf.setOnFrameAvailableListener(this.lFX);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lmg != null) {
                    this.lmg.bj(20, com.baidu.tieba.k.a.t(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.lFY = new com.faceunity.a.d();
            this.lFX.a(this.lFY);
            lFZ = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lmg != null) {
                this.lmg.bj(21, com.baidu.tieba.k.a.t(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.lFY != null) {
                this.lFY.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lmg != null) {
                this.lmg.bj(19, com.baidu.tieba.k.a.t(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.lFY != null) {
            this.lFY.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.lFX.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lmg != null) {
                this.lmg.bj(18, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.lFX.previewWidth = i;
            this.lFX.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * lFU);
            if (round % 2 == 1) {
                round--;
            }
            if (lFV == 960) {
                lFV = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.lGb = aVar;
        this.lGc = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lFW == null) {
            return false;
        }
        return this.lFW.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.lFX == null) {
            return;
        }
        this.lFX.djK();
    }

    public void djG() {
        if (this.lFX == null) {
            return;
        }
        this.lFX.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.lFX != null) {
            this.lFX.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.lFX != null) {
            this.lFX.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.lFX != null) {
            this.lFX.setSticker(stickerItem);
        }
    }

    public void djH() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.lFX != null) {
                    GLVideoPreviewView.this.lFX.djH();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.lFX.lGr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.lFW.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c lBV;
        private com.faceunity.gles.c lGe;
        private volatile SurfaceTexture lGf;
        private GLVideoPreviewView lGg;
        private int lGh;
        private Handler lGm;
        private boolean lGn;
        private boolean lGo;
        com.faceunity.a.d lGp;
        String lGq;
        private boolean lGr;
        private String lGs;
        private com.baidu.tieba.k.h lmg;
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
        private int lBU = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.lBU};
        private boolean isNeedEffectItem = true;
        private long lGi = 0;
        private int lGj = 0;
        private long lGk = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread lGl = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.lGg = gLVideoPreviewView;
            this.lmg = hVar;
            this.lGl.start();
            this.lGm = new a(this.lGl.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.EM(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void djK() {
            this.lGm.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.lGg.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.lBV = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.lGe = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.lGh = this.lGe.createTextureObject();
            djH();
            boolean unused = GLVideoPreviewView.lFZ = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.lGg.mSurfaceViewWidth = i;
            this.lGg.mSurfaceViewHeight = i2;
        }

        public void djH() {
            if (this.lGf != null) {
                faceunity.fuOnCameraChange();
                this.lGf.release();
            }
            this.lGf = new SurfaceTexture(this.lGh);
            djM();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.lzy;
                this.mFacebeautyBlurLevel = aVar.lzz;
                this.mFacebeautyCheeckThin = aVar.lzA;
                this.mFacebeautyEnlargeEye = aVar.lzB;
                this.mFacebeautyRedLevel = aVar.lzC;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.lGr) {
                int i = this.lGj + 1;
                this.lGj = i;
                if (i == 100) {
                    this.lGj = 0;
                    this.lGi = System.currentTimeMillis();
                    this.lGk = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.lGf.updateTexImage();
                    this.lGf.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.lmg != null) {
                        this.lmg.bj(22, com.baidu.tieba.k.a.t(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.lGm.sendEmptyMessage(1);
                }
                if (this.lGg.lGa != null) {
                    this.lGg.lGa.va(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.lGo) {
                    this.lGg.requestRender();
                    return;
                }
                int i2 = (this.lGg.lFW.mCameraId != 1 ? 32 : 0) | 1;
                if (this.lGn) {
                    faceunity.fuItemSetParam(this.lBU, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.lBU, "rotationAngle", djL() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", djL() ? 270.0d : 90.0d);
                }
                this.lGg.lFW.djL();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.lGh;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.lGk = (System.currentTimeMillis() - currentTimeMillis) + this.lGk;
                try {
                    this.lBV.drawFrame(fuDualInputToTexture, fArr);
                    if (this.lGg.lGc) {
                        b(gl10);
                        this.lGg.lGc = false;
                    }
                    if (this.lGp != null && this.lGp.Io(2) && this.lGg.lFW != null) {
                        this.lGq = this.lGg.lFW.djO();
                        this.lGp.a(new d.b(new File(this.lGq), GLVideoPreviewView.lFU, GLVideoPreviewView.lFV, 2097152, null, this.lGf.getTimestamp()));
                    }
                    if (this.lGp != null && this.lGp.Io(1)) {
                        this.lGp.a(this.lBV, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.lFZ) {
                            this.lGp.f(this.lGf);
                        }
                        boolean unused = GLVideoPreviewView.lFZ = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.lGg.g((Camera) null);
                    if (this.lmg != null) {
                        this.lmg.bj(23, com.baidu.tieba.k.a.t(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.lGp = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.lGg.mSurfaceViewWidth;
                int i2 = this.lGg.mSurfaceViewHeight;
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
                if (this.lGg != null && (context = this.lGg.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                Q(bitmap);
            }
        }

        private void Q(final Bitmap bitmap) {
            this.lGs = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.lGg != null && this.lGg.lGb != null) {
                    this.lGg.lGb.A(false, this.lGs);
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
                        b.this.lGs = com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.lzI, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.lGg != null && b.this.lGg.lGb != null) {
                        b.this.lGg.lGb.A(true, b.this.lGs);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean djL() {
            return this.lGg.lFW.djL();
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
                                b.this.itemsArray[2] = b.this.lBU = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.lGn) {
                                b.this.lBU = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.lBU;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.lBU, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.lBU, "rotationAngle", b.this.djL() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.lBU = 0;
                                b.this.itemsArray[2] = b.this.lBU;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.djL() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.lmg != null) {
                                b.this.lmg.bj(24, com.baidu.tieba.k.a.t(e));
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
                            b.this.lGo = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.lmg != null) {
                                b.this.lmg.bj(25, com.baidu.tieba.k.a.t(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.lGo = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.lmg != null) {
                                b.this.lmg.bj(26, com.baidu.tieba.k.a.t(e3));
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
            this.lGg.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.lBV != null) {
                        b.this.lBV.release(false);
                        b.this.lBV = null;
                    }
                    if (b.this.lGe != null) {
                        b.this.lGe.release(false);
                        b.this.lGe = null;
                    }
                    if (b.this.lGf != null) {
                        b.this.lGf.release();
                        b.this.lGf = null;
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

        private void djM() {
            if (this.lGg != null) {
                Handler mainHandler = this.lGg.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.lBU != 0) {
                    faceunity.fuItemSetParam(this.lBU, "rotationAngle", djL() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", djL() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.lGn = false;
                } else {
                    this.lGn = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.lGm.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.lGa = aVar;
        }
    }
}
