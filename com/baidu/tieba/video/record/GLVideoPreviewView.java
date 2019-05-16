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
    private static int jtJ = 720;
    private static int jtK = TbConfig.HEAD_IMG_SIZE;
    private static boolean jtO;
    private com.baidu.tieba.j.h iZR;
    protected h jtL;
    private b jtM;
    private com.faceunity.a.d jtN;
    private a jtP;
    private g.a jtQ;
    private boolean jtR;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void rx(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZR = lVar.bMk();
        }
        this.jtL = hVar;
        this.jtM = new b(context, this, this.iZR);
        setEGLContextClientVersion(2);
        setRenderer(this.jtM);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jtM);
                camera.setPreviewTexture(this.jtM.jtU);
                this.jtM.jtU.setOnFrameAvailableListener(this.jtM);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iZR != null) {
                    this.iZR.av(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jtN = new com.faceunity.a.d();
            this.jtM.a(this.jtN);
            jtO = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iZR != null) {
                this.iZR.av(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jtN != null) {
                this.jtN.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iZR != null) {
                this.iZR.av(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jtN != null) {
            this.jtN.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jtM.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZR != null) {
                this.iZR.av(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jtM.previewWidth = i;
            this.jtM.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jtJ);
            if (round % 2 == 1) {
                round--;
            }
            jtK = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jtQ = aVar;
        this.jtR = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jtL == null) {
            return false;
        }
        return this.jtL.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jtM == null) {
            return;
        }
        this.jtM.csX();
    }

    public void csT() {
        if (this.jtM == null) {
            return;
        }
        this.jtM.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jtM != null) {
            this.jtM.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jtM != null) {
            this.jtM.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jtM != null) {
            this.jtM.setSticker(stickerItem);
        }
    }

    public void csU() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jtM != null) {
                    GLVideoPreviewView.this.jtM.csU();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jtM.jug = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jtL.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h iZR;
        private com.faceunity.gles.c jpL;
        private com.faceunity.gles.c jtT;
        private volatile SurfaceTexture jtU;
        private GLVideoPreviewView jtV;
        private int jtW;
        private Handler jub;
        private boolean juc;
        private boolean jud;
        com.faceunity.a.d jue;
        String juf;
        private boolean jug;
        private String juh;
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
        private int jpK = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jpK};
        private boolean isNeedEffectItem = true;
        private long jtX = 0;
        private int jtY = 0;
        private long jtZ = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jua = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jtV = gLVideoPreviewView;
            this.iZR = hVar;
            this.jua.start();
            this.jub = new a(this.jua.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Bq(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void csX() {
            this.jub.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jtV.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jpL = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jtT = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jtW = this.jtT.createTextureObject();
            csU();
            boolean unused = GLVideoPreviewView.jtO = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jtV.mSurfaceViewWidth = i;
            this.jtV.mSurfaceViewHeight = i2;
        }

        public void csU() {
            if (this.jtU != null) {
                faceunity.fuOnCameraChange();
                this.jtU.release();
            }
            this.jtU = new SurfaceTexture(this.jtW);
            csZ();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.jng;
                this.mFacebeautyBlurLevel = aVar.jnh;
                this.mFacebeautyCheeckThin = aVar.jni;
                this.mFacebeautyEnlargeEye = aVar.jnj;
                this.mFacebeautyRedLevel = aVar.jnk;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jug) {
                int i = this.jtY + 1;
                this.jtY = i;
                if (i == 100) {
                    this.jtY = 0;
                    this.jtX = System.currentTimeMillis();
                    this.jtZ = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jtU.updateTexImage();
                    this.jtU.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.iZR != null) {
                        this.iZR.av(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jub.sendEmptyMessage(1);
                }
                if (this.jtV.jtP != null) {
                    this.jtV.jtP.rx(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jud) {
                    this.jtV.requestRender();
                    return;
                }
                int i2 = (this.jtV.jtL.mCameraId != 1 ? 32 : 0) | 1;
                if (this.juc) {
                    faceunity.fuItemSetParam(this.jpK, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jpK, "rotationAngle", csY() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", csY() ? 270.0d : 90.0d);
                }
                this.jtV.jtL.csY();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jtW;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jtZ = (System.currentTimeMillis() - currentTimeMillis) + this.jtZ;
                try {
                    this.jpL.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jtV.jtR) {
                        b(gl10);
                        this.jtV.jtR = false;
                    }
                    if (this.jue != null && this.jue.DN(2) && this.jtV.jtL != null) {
                        this.juf = this.jtV.jtL.ctb();
                        this.jue.a(new d.b(new File(this.juf), GLVideoPreviewView.jtJ, GLVideoPreviewView.jtK, 2097152, null, this.jtU.getTimestamp()));
                    }
                    if (this.jue != null && this.jue.DN(1)) {
                        this.jue.a(this.jpL, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jtO) {
                            this.jue.d(this.jtU);
                        }
                        boolean unused = GLVideoPreviewView.jtO = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jtV.g((Camera) null);
                    if (this.iZR != null) {
                        this.iZR.av(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jue = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jtV.mSurfaceViewWidth;
                int i2 = this.jtV.mSurfaceViewHeight;
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
                if (this.jtV != null && (context = this.jtV.getContext()) != null && (context instanceof Activity)) {
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
            this.juh = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jtV != null && this.jtV.jtQ != null) {
                    this.jtV.jtQ.y(false, this.juh);
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
                        b.this.juh = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.jnq, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jtV != null && b.this.jtV.jtQ != null) {
                        b.this.jtV.jtQ.y(true, b.this.juh);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean csY() {
            return this.jtV.jtL.csY();
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
                                b.this.itemsArray[2] = b.this.jpK = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.juc) {
                                b.this.jpK = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jpK;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jpK, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jpK, "rotationAngle", b.this.csY() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jpK = 0;
                                b.this.itemsArray[2] = b.this.jpK;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.csY() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.iZR != null) {
                                b.this.iZR.av(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.jud = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.iZR != null) {
                                b.this.iZR.av(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jud = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.iZR != null) {
                                b.this.iZR.av(26, com.baidu.tieba.j.a.p(e3));
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
            this.jtV.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jpL != null) {
                        b.this.jpL.release(false);
                        b.this.jpL = null;
                    }
                    if (b.this.jtT != null) {
                        b.this.jtT.release(false);
                        b.this.jtT = null;
                    }
                    if (b.this.jtU != null) {
                        b.this.jtU.release();
                        b.this.jtU = null;
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

        private void csZ() {
            if (this.jtV != null) {
                Handler mainHandler = this.jtV.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jpK != 0) {
                    faceunity.fuItemSetParam(this.jpK, "rotationAngle", csY() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", csY() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.juc = false;
                } else {
                    this.juc = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jub.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jtP = aVar;
        }
    }
}
