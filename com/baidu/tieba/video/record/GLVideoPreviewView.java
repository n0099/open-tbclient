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
    private static int jaN = 720;
    private static int jaO = TbConfig.HEAD_IMG_SIZE;
    private static boolean jaS;
    private com.baidu.tieba.j.h iGX;
    protected h jaP;
    private b jaQ;
    private com.faceunity.a.d jaR;
    private a jaT;
    private g.a jaU;
    private boolean jaV;
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
            this.iGX = lVar.bEz();
        }
        this.jaP = hVar;
        this.jaQ = new b(context, this, this.iGX);
        setEGLContextClientVersion(2);
        setRenderer(this.jaQ);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jaQ);
                camera.setPreviewTexture(this.jaQ.jaY);
                this.jaQ.jaY.setOnFrameAvailableListener(this.jaQ);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iGX != null) {
                    this.iGX.as(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jaR = new com.faceunity.a.d();
            this.jaQ.a(this.jaR);
            jaS = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iGX != null) {
                this.iGX.as(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jaR != null) {
                this.jaR.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iGX != null) {
                this.iGX.as(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jaR != null) {
            this.jaR.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jaQ.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iGX != null) {
                this.iGX.as(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jaQ.previewWidth = i;
            this.jaQ.previewHeight = i2;
            jaO = (int) (((i * 1.0f) / i2) * jaN);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jaU = aVar;
        this.jaV = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jaP == null) {
            return false;
        }
        return this.jaP.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jaQ == null) {
            return;
        }
        this.jaQ.ckU();
    }

    public void ckQ() {
        if (this.jaQ == null) {
            return;
        }
        this.jaQ.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jaQ != null) {
            this.jaQ.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jaQ != null) {
            this.jaQ.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jaQ != null) {
            this.jaQ.setSticker(stickerItem);
        }
    }

    public void ckR() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jaQ != null) {
                    GLVideoPreviewView.this.jaQ.ckR();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jaQ.jbk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jaP.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h iGX;
        private com.faceunity.gles.c iWO;
        private com.faceunity.gles.c jaX;
        private volatile SurfaceTexture jaY;
        private GLVideoPreviewView jaZ;
        private int jba;
        private Handler jbf;
        private boolean jbg;
        private boolean jbh;
        com.faceunity.a.d jbi;
        String jbj;
        private boolean jbk;
        private String jbl;
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
        private int iWN = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.iWN};
        private boolean isNeedEffectItem = true;
        private long jbb = 0;
        private int jbc = 0;
        private long jbd = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jbe = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jaZ = gLVideoPreviewView;
            this.iGX = hVar;
            this.jbe.start();
            this.jbf = new a(this.jbe.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Ai(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ckU() {
            this.jbf.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jaZ.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.iWO = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jaX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jba = this.jaX.createTextureObject();
            ckR();
            boolean unused = GLVideoPreviewView.jaS = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jaZ.mSurfaceViewWidth = i;
            this.jaZ.mSurfaceViewHeight = i2;
        }

        public void ckR() {
            if (this.jaY != null) {
                faceunity.fuOnCameraChange();
                this.jaY.release();
            }
            this.jaY = new SurfaceTexture(this.jba);
            ckW();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.iUi;
                this.mFacebeautyBlurLevel = aVar.iUj;
                this.mFacebeautyCheeckThin = aVar.iUk;
                this.mFacebeautyEnlargeEye = aVar.iUl;
                this.mFacebeautyRedLevel = aVar.iUm;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jbk) {
                int i = this.jbc + 1;
                this.jbc = i;
                if (i == 100) {
                    this.jbc = 0;
                    this.jbb = System.currentTimeMillis();
                    this.jbd = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jaY.updateTexImage();
                    this.jaY.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.iGX != null) {
                        this.iGX.as(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jbf.sendEmptyMessage(1);
                }
                if (this.jaZ.jaT != null) {
                    this.jaZ.jaT.qI(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jbh) {
                    this.jaZ.requestRender();
                    return;
                }
                int i2 = (this.jaZ.jaP.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jbg) {
                    faceunity.fuItemSetParam(this.iWN, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.iWN, "rotationAngle", ckV() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", ckV() ? 270.0d : 90.0d);
                }
                this.jaZ.jaP.ckV();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jba;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jbd = (System.currentTimeMillis() - currentTimeMillis) + this.jbd;
                try {
                    this.iWO.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jaZ.jaV) {
                        b(gl10);
                        this.jaZ.jaV = false;
                    }
                    if (this.jbi != null && this.jbi.CJ(2) && this.jaZ.jaP != null) {
                        this.jbj = this.jaZ.jaP.ckY();
                        this.jbi.a(new d.b(new File(this.jbj), GLVideoPreviewView.jaN, GLVideoPreviewView.jaO, 2097152, null, this.jaY.getTimestamp()));
                    }
                    if (this.jbi != null && this.jbi.CJ(1)) {
                        this.jbi.a(this.iWO, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jaS) {
                            this.jbi.e(this.jaY);
                        }
                        boolean unused = GLVideoPreviewView.jaS = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jaZ.g((Camera) null);
                    if (this.iGX != null) {
                        this.iGX.as(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jbi = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jaZ.mSurfaceViewWidth;
                int i2 = this.jaZ.mSurfaceViewHeight;
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
                if (this.jaZ != null && (context = this.jaZ.getContext()) != null && (context instanceof Activity)) {
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
            this.jbl = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jaZ != null && this.jaZ.jaU != null) {
                    this.jaZ.jaU.z(false, this.jbl);
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
                        b.this.jbl = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.iUs, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jaZ != null && b.this.jaZ.jaU != null) {
                        b.this.jaZ.jaU.z(true, b.this.jbl);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean ckV() {
            return this.jaZ.jaP.ckV();
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
                                b.this.itemsArray[2] = b.this.iWN = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jbg) {
                                b.this.iWN = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.iWN;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.iWN, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.iWN, "rotationAngle", b.this.ckV() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.iWN = 0;
                                b.this.itemsArray[2] = b.this.iWN;
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
                            if (b.this.iGX != null) {
                                b.this.iGX.as(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.jbh = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.iGX != null) {
                                b.this.iGX.as(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jbh = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.iGX != null) {
                                b.this.iGX.as(26, com.baidu.tieba.j.a.p(e3));
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
            this.jaZ.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.iWO != null) {
                        b.this.iWO.release(false);
                        b.this.iWO = null;
                    }
                    if (b.this.jaX != null) {
                        b.this.jaX.release(false);
                        b.this.jaX = null;
                    }
                    if (b.this.jaY != null) {
                        b.this.jaY.release();
                        b.this.jaY = null;
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
            if (this.jaZ != null) {
                Handler mainHandler = this.jaZ.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.iWN != 0) {
                    faceunity.fuItemSetParam(this.iWN, "rotationAngle", ckV() ? 270.0d : 90.0d);
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
                    this.jbg = false;
                } else {
                    this.jbg = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jbf.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jaT = aVar;
        }
    }
}
