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
    private static boolean jAa;
    private static int jzV = 720;
    private static int jzW = TbConfig.HEAD_IMG_SIZE;
    private a jAb;
    private g.a jAc;
    private boolean jAd;
    private com.baidu.tieba.j.h jgo;
    protected h jzX;
    private b jzY;
    private com.faceunity.a.d jzZ;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void rL(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jgo = lVar.bOW();
        }
        this.jzX = hVar;
        this.jzY = new b(context, this, this.jgo);
        setEGLContextClientVersion(2);
        setRenderer(this.jzY);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jzY);
                camera.setPreviewTexture(this.jzY.jAg);
                this.jzY.jAg.setOnFrameAvailableListener(this.jzY);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jgo != null) {
                    this.jgo.av(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jzZ = new com.faceunity.a.d();
            this.jzY.a(this.jzZ);
            jAa = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jgo != null) {
                this.jgo.av(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jzZ != null) {
                this.jzZ.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jgo != null) {
                this.jgo.av(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jzZ != null) {
            this.jzZ.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jzY.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jgo != null) {
                this.jgo.av(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jzY.previewWidth = i;
            this.jzY.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jzV);
            if (round % 2 == 1) {
                round--;
            }
            jzW = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jAc = aVar;
        this.jAd = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jzX == null) {
            return false;
        }
        return this.jzX.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jzY == null) {
            return;
        }
        this.jzY.cvN();
    }

    public void cvJ() {
        if (this.jzY == null) {
            return;
        }
        this.jzY.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jzY != null) {
            this.jzY.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jzY != null) {
            this.jzY.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jzY != null) {
            this.jzY.setSticker(stickerItem);
        }
    }

    public void cvK() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jzY != null) {
                    GLVideoPreviewView.this.jzY.cvK();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jzY.jAs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jzX.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c jAf;
        private volatile SurfaceTexture jAg;
        private GLVideoPreviewView jAh;
        private int jAi;
        private Handler jAn;
        private boolean jAo;
        private boolean jAp;
        com.faceunity.a.d jAq;
        String jAr;
        private boolean jAs;
        private String jAt;
        private com.baidu.tieba.j.h jgo;
        private com.faceunity.gles.c jvX;
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
        private int jvW = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jvW};
        private boolean isNeedEffectItem = true;
        private long jAj = 0;
        private int jAk = 0;
        private long jAl = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jAm = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jAh = gLVideoPreviewView;
            this.jgo = hVar;
            this.jAm.start();
            this.jAn = new a(this.jAm.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.BX(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cvN() {
            this.jAn.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jAh.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jvX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jAf = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jAi = this.jAf.createTextureObject();
            cvK();
            boolean unused = GLVideoPreviewView.jAa = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jAh.mSurfaceViewWidth = i;
            this.jAh.mSurfaceViewHeight = i2;
        }

        public void cvK() {
            if (this.jAg != null) {
                faceunity.fuOnCameraChange();
                this.jAg.release();
            }
            this.jAg = new SurfaceTexture(this.jAi);
            cvP();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.jts;
                this.mFacebeautyBlurLevel = aVar.jtt;
                this.mFacebeautyCheeckThin = aVar.jtu;
                this.mFacebeautyEnlargeEye = aVar.jtv;
                this.mFacebeautyRedLevel = aVar.jtw;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jAs) {
                int i = this.jAk + 1;
                this.jAk = i;
                if (i == 100) {
                    this.jAk = 0;
                    this.jAj = System.currentTimeMillis();
                    this.jAl = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jAg.updateTexImage();
                    this.jAg.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.jgo != null) {
                        this.jgo.av(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jAn.sendEmptyMessage(1);
                }
                if (this.jAh.jAb != null) {
                    this.jAh.jAb.rL(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jAp) {
                    this.jAh.requestRender();
                    return;
                }
                int i2 = (this.jAh.jzX.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jAo) {
                    faceunity.fuItemSetParam(this.jvW, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jvW, "rotationAngle", cvO() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cvO() ? 270.0d : 90.0d);
                }
                this.jAh.jzX.cvO();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jAi;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jAl = (System.currentTimeMillis() - currentTimeMillis) + this.jAl;
                try {
                    this.jvX.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jAh.jAd) {
                        b(gl10);
                        this.jAh.jAd = false;
                    }
                    if (this.jAq != null && this.jAq.Eu(2) && this.jAh.jzX != null) {
                        this.jAr = this.jAh.jzX.cvR();
                        this.jAq.a(new d.b(new File(this.jAr), GLVideoPreviewView.jzV, GLVideoPreviewView.jzW, 2097152, null, this.jAg.getTimestamp()));
                    }
                    if (this.jAq != null && this.jAq.Eu(1)) {
                        this.jAq.a(this.jvX, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jAa) {
                            this.jAq.d(this.jAg);
                        }
                        boolean unused = GLVideoPreviewView.jAa = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jAh.g((Camera) null);
                    if (this.jgo != null) {
                        this.jgo.av(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jAq = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jAh.mSurfaceViewWidth;
                int i2 = this.jAh.mSurfaceViewHeight;
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
                if (this.jAh != null && (context = this.jAh.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                N(bitmap);
            }
        }

        private void N(final Bitmap bitmap) {
            this.jAt = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jAh != null && this.jAh.jAc != null) {
                    this.jAh.jAc.z(false, this.jAt);
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
                        b.this.jAt = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.jtC, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jAh != null && b.this.jAh.jAc != null) {
                        b.this.jAh.jAc.z(true, b.this.jAt);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean cvO() {
            return this.jAh.jzX.cvO();
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
                                b.this.itemsArray[2] = b.this.jvW = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jAo) {
                                b.this.jvW = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jvW;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jvW, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jvW, "rotationAngle", b.this.cvO() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jvW = 0;
                                b.this.itemsArray[2] = b.this.jvW;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.cvO() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.jgo != null) {
                                b.this.jgo.av(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.jAp = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.jgo != null) {
                                b.this.jgo.av(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jAp = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.jgo != null) {
                                b.this.jgo.av(26, com.baidu.tieba.j.a.p(e3));
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
            this.jAh.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jvX != null) {
                        b.this.jvX.release(false);
                        b.this.jvX = null;
                    }
                    if (b.this.jAf != null) {
                        b.this.jAf.release(false);
                        b.this.jAf = null;
                    }
                    if (b.this.jAg != null) {
                        b.this.jAg.release();
                        b.this.jAg = null;
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

        private void cvP() {
            if (this.jAh != null) {
                Handler mainHandler = this.jAh.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jvW != 0) {
                    faceunity.fuItemSetParam(this.jvW, "rotationAngle", cvO() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cvO() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jAo = false;
                } else {
                    this.jAo = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jAn.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jAb = aVar;
        }
    }
}
