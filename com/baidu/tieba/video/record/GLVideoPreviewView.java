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
/* loaded from: classes2.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int hcQ = 720;
    private static int hcR = TbConfig.HEAD_IMG_SIZE;
    private static boolean hcV;
    private com.baidu.tieba.j.h gJZ;
    protected h hcS;
    private b hcT;
    private com.faceunity.a.d hcU;
    private a hcW;
    private int hcX;
    private int hcY;
    private g.a hcZ;
    private boolean hda;

    /* loaded from: classes2.dex */
    public interface a {
        void nf(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        this.hcS = hVar;
        this.hcT = new b(context, this, this.gJZ);
        setEGLContextClientVersion(2);
        setRenderer(this.hcT);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hcT);
                camera.setPreviewTexture(this.hcT.hdd);
                this.hcT.hdd.setOnFrameAvailableListener(this.hcT);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gJZ != null) {
                    this.gJZ.ac(20, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hcU = new com.faceunity.a.d();
            this.hcT.a(this.hcU);
            hcV = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gJZ != null) {
                this.gJZ.ac(21, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        try {
            if (this.hcU != null) {
                this.hcU.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gJZ != null) {
                this.gJZ.ac(19, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hcU != null) {
            this.hcU.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        try {
            this.hcT.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gJZ != null) {
                this.gJZ.ac(18, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hcT.ddc = i;
            this.hcT.ddd = i2;
            hcR = (int) (((i * 1.0f) / i2) * hcQ);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hcZ = aVar;
        this.hda = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hcS == null) {
            return false;
        }
        return this.hcS.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hcT == null) {
            return;
        }
        this.hcT.bDd();
    }

    public void bDa() {
        if (this.hcT == null) {
            return;
        }
        this.hcT.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hcT != null) {
            this.hcT.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hcT != null) {
            this.hcT.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hcT != null) {
            this.hcT.setSticker(stickerItem);
        }
    }

    public void bDb() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hcT != null) {
                    GLVideoPreviewView.this.hcT.bDb();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hcT.hdn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hcS.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h gJZ;
        private com.faceunity.gles.c gYL;
        private com.faceunity.gles.c hdc;
        private volatile SurfaceTexture hdd;
        private GLVideoPreviewView hde;
        private int hdf;
        private Handler hdi;
        private boolean hdj;
        private boolean hdk;
        com.faceunity.a.d hdl;
        String hdm;
        private boolean hdn;
        private String hdo;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int ddc = 720;
        protected int ddd = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gYK = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gYK};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hdg = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hdh = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hde = gLVideoPreviewView;
            this.gJZ = hVar;
            this.hdh.start();
            this.hdi = new a(this.hdh.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.uq(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bDd() {
            this.hdi.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hde.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gYL = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hdc = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hdf = this.hdc.createTextureObject();
            bDb();
            boolean unused = GLVideoPreviewView.hcV = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hde.hcX = i;
            this.hde.hcY = i2;
        }

        public void bDb() {
            if (this.hdd != null) {
                faceunity.fuOnCameraChange();
                this.hdd.release();
            }
            this.hdd = new SurfaceTexture(this.hdf);
            bDf();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gWe;
                this.mFacebeautyBlurLevel = aVar.gWf;
                this.mFacebeautyCheeckThin = aVar.gWg;
                this.mFacebeautyEnlargeEye = aVar.gWh;
                this.mFacebeautyRedLevel = aVar.gWi;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hdn) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hdg = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hdd.updateTexImage();
                    this.hdd.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gJZ != null) {
                        this.gJZ.ac(22, com.baidu.tieba.j.a.m(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hdi.sendEmptyMessage(1);
                }
                if (this.hde.hcW != null) {
                    this.hde.hcW.nf(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hdk) {
                    this.hde.requestRender();
                    return;
                }
                int i2 = (this.hde.hcS.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hdj) {
                    faceunity.fuItemSetParam(this.gYK, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.gYK, "rotationAngle", bDe() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bDe() ? 270.0d : 90.0d);
                }
                this.hde.hcS.bDe();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hdf;
                int i4 = this.ddc;
                int i5 = this.ddd;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hdg = (System.currentTimeMillis() - currentTimeMillis) + this.hdg;
                try {
                    this.gYL.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hde.hda) {
                        c(gl10);
                        this.hde.hda = false;
                    }
                    if (this.hdl != null && this.hdl.ww(2) && this.hde.hcS != null) {
                        this.hdm = this.hde.hcS.bDh();
                        this.hdl.a(new d.b(new File(this.hdm), GLVideoPreviewView.hcQ, GLVideoPreviewView.hcR, 2097152, null, this.hdd.getTimestamp()));
                    }
                    if (this.hdl != null && this.hdl.ww(1)) {
                        this.hdl.a(this.gYL, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hcV) {
                            this.hdl.d(this.hdd);
                        }
                        boolean unused = GLVideoPreviewView.hcV = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hde.i(null);
                    if (this.gJZ != null) {
                        this.gJZ.ac(23, com.baidu.tieba.j.a.m(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hdl = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hde.hcX;
                int i2 = this.hde.hcY;
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
                if (this.hde != null && (context = this.hde.getContext()) != null && (context instanceof Activity)) {
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
            this.hdo = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hde != null && this.hde.hcZ != null) {
                    this.hde.hcZ.q(false, this.hdo);
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
                        b.this.hdo = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.b.gWo, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hde != null && b.this.hde.hcZ != null) {
                        b.this.hde.hcZ.q(true, b.this.hdo);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bDe() {
            return this.hde.hcS.bDe();
        }

        /* loaded from: classes2.dex */
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
                                b.this.itemsArray[2] = b.this.gYK = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hdj) {
                                b.this.gYK = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.gYK;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.gYK, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.gYK, "rotationAngle", b.this.bDe() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.gYK = 0;
                                b.this.itemsArray[2] = b.this.gYK;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bDe() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gJZ != null) {
                                b.this.gJZ.ac(24, com.baidu.tieba.j.a.m(e));
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
                            b.this.hdk = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gJZ != null) {
                                b.this.gJZ.ac(25, com.baidu.tieba.j.a.m(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hdk = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gJZ != null) {
                                b.this.gJZ.ac(26, com.baidu.tieba.j.a.m(e3));
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
            this.hde.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gYL != null) {
                        b.this.gYL.release(false);
                        b.this.gYL = null;
                    }
                    if (b.this.hdc != null) {
                        b.this.hdc.release(false);
                        b.this.hdc = null;
                    }
                    if (b.this.hdd != null) {
                        b.this.hdd.release();
                        b.this.hdd = null;
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

        private void bDf() {
            if (this.hde != null) {
                Handler mainHandler = this.hde.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.gYK != 0) {
                    faceunity.fuItemSetParam(this.gYK, "rotationAngle", bDe() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bDe() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hdj = false;
                } else {
                    this.hdj = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hdi.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hcW = aVar;
        }
    }
}
