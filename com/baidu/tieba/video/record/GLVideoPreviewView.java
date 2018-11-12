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
    private static int hyW = 720;
    private static int hyX = TbConfig.HEAD_IMG_SIZE;
    private static boolean hzb;
    private com.baidu.tieba.j.h hfy;
    protected h hyY;
    private b hyZ;
    private com.faceunity.a.d hza;
    private a hzc;
    private int hzd;
    private int hze;
    private g.a hzf;
    private boolean hzg;

    /* loaded from: classes5.dex */
    public interface a {
        void oc(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hfy = lVar.baV();
        }
        this.hyY = hVar;
        this.hyZ = new b(context, this, this.hfy);
        setEGLContextClientVersion(2);
        setRenderer(this.hyZ);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hyZ);
                camera.setPreviewTexture(this.hyZ.hzj);
                this.hyZ.hzj.setOnFrameAvailableListener(this.hyZ);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hfy != null) {
                    this.hfy.X(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hza = new com.faceunity.a.d();
            this.hyZ.a(this.hza);
            hzb = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hfy != null) {
                this.hfy.X(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hza != null) {
                this.hza.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hfy != null) {
                this.hfy.X(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hza != null) {
            this.hza.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hyZ.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hfy != null) {
                this.hfy.X(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hyZ.dsV = i;
            this.hyZ.dsW = i2;
            hyX = (int) (((i * 1.0f) / i2) * hyW);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hzf = aVar;
        this.hzg = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hyY == null) {
            return false;
        }
        return this.hyY.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hyZ == null) {
            return;
        }
        this.hyZ.bHS();
    }

    public void bHO() {
        if (this.hyZ == null) {
            return;
        }
        this.hyZ.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hyZ != null) {
            this.hyZ.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hyZ != null) {
            this.hyZ.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hyZ != null) {
            this.hyZ.setSticker(stickerItem);
        }
    }

    public void bHP() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hyZ != null) {
                    GLVideoPreviewView.this.hyZ.bHP();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hyZ.hzv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hyY.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h hfy;
        private com.faceunity.gles.c huU;
        private com.faceunity.gles.c hzi;
        private volatile SurfaceTexture hzj;
        private GLVideoPreviewView hzk;
        private int hzl;
        private Handler hzq;
        private boolean hzr;
        private boolean hzs;
        com.faceunity.a.d hzt;
        String hzu;
        private boolean hzv;
        private String hzw;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dsV = 720;
        protected int dsW = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int huT = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.huT};
        private boolean isNeedEffectItem = true;
        private long hzm = 0;
        private int hzn = 0;
        private long hzo = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hzp = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hzk = gLVideoPreviewView;
            this.hfy = hVar;
            this.hzp.start();
            this.hzq = new a(this.hzp.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.vN(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bHS() {
            this.hzq.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hzk.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.huU = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hzi = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hzl = this.hzi.createTextureObject();
            bHP();
            boolean unused = GLVideoPreviewView.hzb = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hzk.hzd = i;
            this.hzk.hze = i2;
        }

        public void bHP() {
            if (this.hzj != null) {
                faceunity.fuOnCameraChange();
                this.hzj.release();
            }
            this.hzj = new SurfaceTexture(this.hzl);
            bHU();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hsp;
                this.mFacebeautyBlurLevel = aVar.hsq;
                this.mFacebeautyCheeckThin = aVar.hsr;
                this.mFacebeautyEnlargeEye = aVar.hss;
                this.mFacebeautyRedLevel = aVar.hst;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hzv) {
                int i = this.hzn + 1;
                this.hzn = i;
                if (i == 100) {
                    this.hzn = 0;
                    this.hzm = System.currentTimeMillis();
                    this.hzo = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hzj.updateTexImage();
                    this.hzj.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hfy != null) {
                        this.hfy.X(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hzq.sendEmptyMessage(1);
                }
                if (this.hzk.hzc != null) {
                    this.hzk.hzc.oc(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hzs) {
                    this.hzk.requestRender();
                    return;
                }
                int i2 = (this.hzk.hyY.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hzr) {
                    faceunity.fuItemSetParam(this.huT, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.huT, "rotationAngle", bHT() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bHT() ? 270.0d : 90.0d);
                }
                this.hzk.hyY.bHT();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hzl;
                int i4 = this.dsV;
                int i5 = this.dsW;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hzo = (System.currentTimeMillis() - currentTimeMillis) + this.hzo;
                try {
                    this.huU.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hzk.hzg) {
                        d(gl10);
                        this.hzk.hzg = false;
                    }
                    if (this.hzt != null && this.hzt.yu(2) && this.hzk.hyY != null) {
                        this.hzu = this.hzk.hyY.bHW();
                        this.hzt.a(new d.b(new File(this.hzu), GLVideoPreviewView.hyW, GLVideoPreviewView.hyX, 2097152, null, this.hzj.getTimestamp()));
                    }
                    if (this.hzt != null && this.hzt.yu(1)) {
                        this.hzt.a(this.huU, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hzb) {
                            this.hzt.e(this.hzj);
                        }
                        boolean unused = GLVideoPreviewView.hzb = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hzk.g((Camera) null);
                    if (this.hfy != null) {
                        this.hfy.X(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hzt = dVar;
            }
        }

        private void d(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hzk.hzd;
                int i2 = this.hzk.hze;
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
                if (this.hzk != null && (context = this.hzk.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                E(bitmap);
            }
        }

        private void E(final Bitmap bitmap) {
            this.hzw = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hzk != null && this.hzk.hzf != null) {
                    this.hzk.hzf.t(false, this.hzw);
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
                        b.this.hzw = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hsz, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hzk != null && b.this.hzk.hzf != null) {
                        b.this.hzk.hzf.t(true, b.this.hzw);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bHT() {
            return this.hzk.hyY.bHT();
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
                Context context = this.mContext.get();
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        try {
                            if (StringUtils.isNull(b.this.mEffectFileName)) {
                                b.this.itemsArray[1] = b.this.mEffectItem = 0;
                                b.this.itemsArray[2] = b.this.huT = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hzr) {
                                b.this.huT = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.huT;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.huT, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.huT, "rotationAngle", b.this.bHT() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.huT = 0;
                                b.this.itemsArray[2] = b.this.huT;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bHT() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hfy != null) {
                                b.this.hfy.X(24, com.baidu.tieba.j.a.o(e));
                                return;
                            }
                            return;
                        }
                    case 2:
                        try {
                            InputStream open = context.getAssets().open("beauty/v3.mp3");
                            byte[] bArr2 = new byte[open.available()];
                            open.read(bArr2);
                            open.close();
                            faceunity.fuSetup(bArr2, null, f.A());
                            b.this.hzs = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hfy != null) {
                                b.this.hfy.X(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hzs = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hfy != null) {
                                b.this.hfy.X(26, com.baidu.tieba.j.a.o(e3));
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
            this.hzk.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.huU != null) {
                        b.this.huU.release(false);
                        b.this.huU = null;
                    }
                    if (b.this.hzi != null) {
                        b.this.hzi.release(false);
                        b.this.hzi = null;
                    }
                    if (b.this.hzj != null) {
                        b.this.hzj.release();
                        b.this.hzj = null;
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

        private void bHU() {
            if (this.hzk != null) {
                Handler mainHandler = this.hzk.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.huT != 0) {
                    faceunity.fuItemSetParam(this.huT, "rotationAngle", bHT() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bHT() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hzr = false;
                } else {
                    this.hzr = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hzq.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hzc = aVar;
        }
    }
}
