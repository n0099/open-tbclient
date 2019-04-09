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
/* loaded from: classes5.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int jaO = 720;
    private static int jaP = TbConfig.HEAD_IMG_SIZE;
    private static boolean jaT;
    private com.baidu.tieba.j.h iGY;
    protected h jaQ;
    private b jaR;
    private com.faceunity.a.d jaS;
    private a jaU;
    private g.a jaV;
    private boolean jaW;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void qI(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iGY = lVar.bEz();
        }
        this.jaQ = hVar;
        this.jaR = new b(context, this, this.iGY);
        setEGLContextClientVersion(2);
        setRenderer(this.jaR);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jaR);
                camera.setPreviewTexture(this.jaR.jaZ);
                this.jaR.jaZ.setOnFrameAvailableListener(this.jaR);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iGY != null) {
                    this.iGY.as(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jaS = new com.faceunity.a.d();
            this.jaR.a(this.jaS);
            jaT = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iGY != null) {
                this.iGY.as(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jaS != null) {
                this.jaS.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iGY != null) {
                this.iGY.as(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jaS != null) {
            this.jaS.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jaR.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGY != null) {
                this.iGY.as(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jaR.previewWidth = i;
            this.jaR.previewHeight = i2;
            jaP = (int) (((i * 1.0f) / i2) * jaO);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jaV = aVar;
        this.jaW = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jaQ == null) {
            return false;
        }
        return this.jaQ.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jaR == null) {
            return;
        }
        this.jaR.ckU();
    }

    public void ckQ() {
        if (this.jaR == null) {
            return;
        }
        this.jaR.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jaR != null) {
            this.jaR.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jaR != null) {
            this.jaR.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jaR != null) {
            this.jaR.setSticker(stickerItem);
        }
    }

    public void ckR() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jaR != null) {
                    GLVideoPreviewView.this.jaR.ckR();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jaR.jbl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jaQ.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h iGY;
        private com.faceunity.gles.c iWP;
        private com.faceunity.gles.c jaY;
        private volatile SurfaceTexture jaZ;
        private GLVideoPreviewView jba;
        private int jbb;
        private Handler jbg;
        private boolean jbh;
        private boolean jbi;
        com.faceunity.a.d jbj;
        String jbk;
        private boolean jbl;
        private String jbm;
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
        private int iWO = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.iWO};
        private boolean isNeedEffectItem = true;
        private long jbc = 0;
        private int jbd = 0;
        private long jbe = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jbf = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jba = gLVideoPreviewView;
            this.iGY = hVar;
            this.jbf.start();
            this.jbg = new a(this.jbf.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Ai(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ckU() {
            this.jbg.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jba.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.iWP = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jaY = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jbb = this.jaY.createTextureObject();
            ckR();
            boolean unused = GLVideoPreviewView.jaT = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jba.mSurfaceViewWidth = i;
            this.jba.mSurfaceViewHeight = i2;
        }

        public void ckR() {
            if (this.jaZ != null) {
                faceunity.fuOnCameraChange();
                this.jaZ.release();
            }
            this.jaZ = new SurfaceTexture(this.jbb);
            ckW();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.iUj;
                this.mFacebeautyBlurLevel = aVar.iUk;
                this.mFacebeautyCheeckThin = aVar.iUl;
                this.mFacebeautyEnlargeEye = aVar.iUm;
                this.mFacebeautyRedLevel = aVar.iUn;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jbl) {
                int i = this.jbd + 1;
                this.jbd = i;
                if (i == 100) {
                    this.jbd = 0;
                    this.jbc = System.currentTimeMillis();
                    this.jbe = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jaZ.updateTexImage();
                    this.jaZ.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.iGY != null) {
                        this.iGY.as(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jbg.sendEmptyMessage(1);
                }
                if (this.jba.jaU != null) {
                    this.jba.jaU.qI(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jbi) {
                    this.jba.requestRender();
                    return;
                }
                int i2 = (this.jba.jaQ.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jbh) {
                    faceunity.fuItemSetParam(this.iWO, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.iWO, "rotationAngle", ckV() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", ckV() ? 270.0d : 90.0d);
                }
                this.jba.jaQ.ckV();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jbb;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jbe = (System.currentTimeMillis() - currentTimeMillis) + this.jbe;
                try {
                    this.iWP.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jba.jaW) {
                        b(gl10);
                        this.jba.jaW = false;
                    }
                    if (this.jbj != null && this.jbj.CJ(2) && this.jba.jaQ != null) {
                        this.jbk = this.jba.jaQ.ckY();
                        this.jbj.a(new d.b(new File(this.jbk), GLVideoPreviewView.jaO, GLVideoPreviewView.jaP, 2097152, null, this.jaZ.getTimestamp()));
                    }
                    if (this.jbj != null && this.jbj.CJ(1)) {
                        this.jbj.a(this.iWP, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jaT) {
                            this.jbj.e(this.jaZ);
                        }
                        boolean unused = GLVideoPreviewView.jaT = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jba.g((Camera) null);
                    if (this.iGY != null) {
                        this.iGY.as(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jbj = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jba.mSurfaceViewWidth;
                int i2 = this.jba.mSurfaceViewHeight;
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
                if (this.jba != null && (context = this.jba.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                M(bitmap);
            }
        }

        private void M(final Bitmap bitmap) {
            this.jbm = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jba != null && this.jba.jaV != null) {
                    this.jba.jaV.z(false, this.jbm);
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
                        b.this.jbm = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.iUt, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jba != null && b.this.jba.jaV != null) {
                        b.this.jba.jaV.z(true, b.this.jbm);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean ckV() {
            return this.jba.jaQ.ckV();
        }

        /* loaded from: classes5.dex */
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
                                b.this.itemsArray[2] = b.this.iWO = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jbh) {
                                b.this.iWO = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.iWO;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.iWO, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.iWO, "rotationAngle", b.this.ckV() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.iWO = 0;
                                b.this.itemsArray[2] = b.this.iWO;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.ckV() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.iGY != null) {
                                b.this.iGY.as(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.jbi = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.iGY != null) {
                                b.this.iGY.as(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jbi = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.iGY != null) {
                                b.this.iGY.as(26, com.baidu.tieba.j.a.p(e3));
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
            this.jba.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.iWP != null) {
                        b.this.iWP.release(false);
                        b.this.iWP = null;
                    }
                    if (b.this.jaY != null) {
                        b.this.jaY.release(false);
                        b.this.jaY = null;
                    }
                    if (b.this.jaZ != null) {
                        b.this.jaZ.release();
                        b.this.jaZ = null;
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

        private void ckW() {
            if (this.jba != null) {
                Handler mainHandler = this.jba.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.iWO != 0) {
                    faceunity.fuItemSetParam(this.iWO, "rotationAngle", ckV() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", ckV() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jbh = false;
                } else {
                    this.jbh = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jbg.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jaU = aVar;
        }
    }
}
