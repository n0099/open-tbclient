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
    private static int hgV = 720;
    private static int hgW = TbConfig.HEAD_IMG_SIZE;
    private static boolean hha;
    private com.baidu.tieba.j.h gOa;
    protected h hgX;
    private b hgY;
    private com.faceunity.a.d hgZ;
    private a hhb;
    private int hhc;
    private int hhd;
    private g.a hhe;
    private boolean hhf;

    /* loaded from: classes2.dex */
    public interface a {
        void nn(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        this.hgX = hVar;
        this.hgY = new b(context, this, this.gOa);
        setEGLContextClientVersion(2);
        setRenderer(this.hgY);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hgY);
                camera.setPreviewTexture(this.hgY.hhi);
                this.hgY.hhi.setOnFrameAvailableListener(this.hgY);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gOa != null) {
                    this.gOa.Z(20, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hgZ = new com.faceunity.a.d();
            this.hgY.a(this.hgZ);
            hha = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gOa != null) {
                this.gOa.Z(21, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        try {
            if (this.hgZ != null) {
                this.hgZ.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gOa != null) {
                this.gOa.Z(19, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hgZ != null) {
            this.hgZ.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        try {
            this.hgY.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOa != null) {
                this.gOa.Z(18, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hgY.dbe = i;
            this.hgY.dbf = i2;
            hgW = (int) (((i * 1.0f) / i2) * hgV);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hhe = aVar;
        this.hhf = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hgX == null) {
            return false;
        }
        return this.hgX.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hgY == null) {
            return;
        }
        this.hgY.bDD();
    }

    public void bDA() {
        if (this.hgY == null) {
            return;
        }
        this.hgY.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hgY != null) {
            this.hgY.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hgY != null) {
            this.hgY.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hgY != null) {
            this.hgY.setSticker(stickerItem);
        }
    }

    public void bDB() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hgY != null) {
                    GLVideoPreviewView.this.hgY.bDB();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hgY.hhs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hgX.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h gOa;
        private com.faceunity.gles.c hcQ;
        private com.faceunity.gles.c hhh;
        private volatile SurfaceTexture hhi;
        private GLVideoPreviewView hhj;
        private int hhk;
        private Handler hhn;
        private boolean hho;
        private boolean hhp;
        com.faceunity.a.d hhq;
        String hhr;
        private boolean hhs;
        private String hht;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dbe = 720;
        protected int dbf = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hcP = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hcP};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hhl = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hhm = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hhj = gLVideoPreviewView;
            this.gOa = hVar;
            this.hhm.start();
            this.hhn = new a(this.hhm.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.uy(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bDD() {
            this.hhn.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hhj.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hcQ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hhh = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hhk = this.hhh.createTextureObject();
            bDB();
            boolean unused = GLVideoPreviewView.hha = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hhj.hhc = i;
            this.hhj.hhd = i2;
        }

        public void bDB() {
            if (this.hhi != null) {
                faceunity.fuOnCameraChange();
                this.hhi.release();
            }
            this.hhi = new SurfaceTexture(this.hhk);
            bDF();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.haj;
                this.mFacebeautyBlurLevel = aVar.hak;
                this.mFacebeautyCheeckThin = aVar.hal;
                this.mFacebeautyEnlargeEye = aVar.ham;
                this.mFacebeautyRedLevel = aVar.han;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hhs) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hhl = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hhi.updateTexImage();
                    this.hhi.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gOa != null) {
                        this.gOa.Z(22, com.baidu.tieba.j.a.m(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hhn.sendEmptyMessage(1);
                }
                if (this.hhj.hhb != null) {
                    this.hhj.hhb.nn(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hhp) {
                    this.hhj.requestRender();
                    return;
                }
                int i2 = (this.hhj.hgX.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hho) {
                    faceunity.fuItemSetParam(this.hcP, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.hcP, "rotationAngle", bDE() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bDE() ? 270.0d : 90.0d);
                }
                this.hhj.hgX.bDE();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hhk;
                int i4 = this.dbe;
                int i5 = this.dbf;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hhl = (System.currentTimeMillis() - currentTimeMillis) + this.hhl;
                try {
                    this.hcQ.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hhj.hhf) {
                        c(gl10);
                        this.hhj.hhf = false;
                    }
                    if (this.hhq != null && this.hhq.wF(2) && this.hhj.hgX != null) {
                        this.hhr = this.hhj.hgX.bDH();
                        this.hhq.a(new d.b(new File(this.hhr), GLVideoPreviewView.hgV, GLVideoPreviewView.hgW, 2097152, null, this.hhi.getTimestamp()));
                    }
                    if (this.hhq != null && this.hhq.wF(1)) {
                        this.hhq.a(this.hcQ, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hha) {
                            this.hhq.d(this.hhi);
                        }
                        boolean unused = GLVideoPreviewView.hha = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hhj.i(null);
                    if (this.gOa != null) {
                        this.gOa.Z(23, com.baidu.tieba.j.a.m(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hhq = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hhj.hhc;
                int i2 = this.hhj.hhd;
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
                if (this.hhj != null && (context = this.hhj.getContext()) != null && (context instanceof Activity)) {
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
            this.hht = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hhj != null && this.hhj.hhe != null) {
                    this.hhj.hhe.q(false, this.hht);
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
                        b.this.hht = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.b.hat, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hhj != null && b.this.hhj.hhe != null) {
                        b.this.hhj.hhe.q(true, b.this.hht);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bDE() {
            return this.hhj.hgX.bDE();
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
                                b.this.itemsArray[2] = b.this.hcP = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hho) {
                                b.this.hcP = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hcP;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hcP, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.hcP, "rotationAngle", b.this.bDE() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hcP = 0;
                                b.this.itemsArray[2] = b.this.hcP;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bDE() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gOa != null) {
                                b.this.gOa.Z(24, com.baidu.tieba.j.a.m(e));
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
                            b.this.hhp = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gOa != null) {
                                b.this.gOa.Z(25, com.baidu.tieba.j.a.m(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hhp = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gOa != null) {
                                b.this.gOa.Z(26, com.baidu.tieba.j.a.m(e3));
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
            this.hhj.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hcQ != null) {
                        b.this.hcQ.release(false);
                        b.this.hcQ = null;
                    }
                    if (b.this.hhh != null) {
                        b.this.hhh.release(false);
                        b.this.hhh = null;
                    }
                    if (b.this.hhi != null) {
                        b.this.hhi.release();
                        b.this.hhi = null;
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

        private void bDF() {
            if (this.hhj != null) {
                Handler mainHandler = this.hhj.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.hcP != 0) {
                    faceunity.fuItemSetParam(this.hcP, "rotationAngle", bDE() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bDE() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hho = false;
                } else {
                    this.hho = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hhn.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hhb = aVar;
        }
    }
}
