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
    private static int hxn = 720;
    private static int hxo = TbConfig.HEAD_IMG_SIZE;
    private static boolean hxs;
    private com.baidu.tieba.j.h hea;
    protected h hxp;
    private b hxq;
    private com.faceunity.a.d hxr;
    private a hxt;
    private int hxu;
    private int hxv;
    private g.a hxw;
    private boolean hxx;

    /* loaded from: classes5.dex */
    public interface a {
        void nO(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hea = lVar.bbw();
        }
        this.hxp = hVar;
        this.hxq = new b(context, this, this.hea);
        setEGLContextClientVersion(2);
        setRenderer(this.hxq);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hxq);
                camera.setPreviewTexture(this.hxq.hxA);
                this.hxq.hxA.setOnFrameAvailableListener(this.hxq);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hea != null) {
                    this.hea.ab(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hxr = new com.faceunity.a.d();
            this.hxq.a(this.hxr);
            hxs = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hea != null) {
                this.hea.ab(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hxr != null) {
                this.hxr.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hea != null) {
                this.hea.ab(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hxr != null) {
            this.hxr.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hxq.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hea != null) {
                this.hea.ab(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hxq.drR = i;
            this.hxq.drS = i2;
            hxo = (int) (((i * 1.0f) / i2) * hxn);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hxw = aVar;
        this.hxx = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hxp == null) {
            return false;
        }
        return this.hxp.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hxq == null) {
            return;
        }
        this.hxq.bIt();
    }

    public void bIp() {
        if (this.hxq == null) {
            return;
        }
        this.hxq.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hxq != null) {
            this.hxq.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hxq != null) {
            this.hxq.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hxq != null) {
            this.hxq.setSticker(stickerItem);
        }
    }

    public void bIq() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hxq != null) {
                    GLVideoPreviewView.this.hxq.bIq();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hxq.hxK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hxp.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h hea;
        private com.faceunity.gles.c htk;
        private volatile SurfaceTexture hxA;
        private GLVideoPreviewView hxB;
        private int hxC;
        private Handler hxF;
        private boolean hxG;
        private boolean hxH;
        com.faceunity.a.d hxI;
        String hxJ;
        private boolean hxK;
        private String hxL;
        private com.faceunity.gles.c hxz;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int drR = 720;
        protected int drS = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int htj = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.htj};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hxD = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hxE = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hxB = gLVideoPreviewView;
            this.hea = hVar;
            this.hxE.start();
            this.hxF = new a(this.hxE.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.vu(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bIt() {
            this.hxF.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hxB.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.htk = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hxz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hxC = this.hxz.createTextureObject();
            bIq();
            boolean unused = GLVideoPreviewView.hxs = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hxB.hxu = i;
            this.hxB.hxv = i2;
        }

        public void bIq() {
            if (this.hxA != null) {
                faceunity.fuOnCameraChange();
                this.hxA.release();
            }
            this.hxA = new SurfaceTexture(this.hxC);
            bIv();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hqF;
                this.mFacebeautyBlurLevel = aVar.hqG;
                this.mFacebeautyCheeckThin = aVar.hqH;
                this.mFacebeautyEnlargeEye = aVar.hqI;
                this.mFacebeautyRedLevel = aVar.hqJ;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hxK) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hxD = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hxA.updateTexImage();
                    this.hxA.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hea != null) {
                        this.hea.ab(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hxF.sendEmptyMessage(1);
                }
                if (this.hxB.hxt != null) {
                    this.hxB.hxt.nO(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hxH) {
                    this.hxB.requestRender();
                    return;
                }
                int i2 = (this.hxB.hxp.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hxG) {
                    faceunity.fuItemSetParam(this.htj, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.htj, "rotationAngle", bIu() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bIu() ? 270.0d : 90.0d);
                }
                this.hxB.hxp.bIu();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hxC;
                int i4 = this.drR;
                int i5 = this.drS;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hxD = (System.currentTimeMillis() - currentTimeMillis) + this.hxD;
                try {
                    this.htk.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hxB.hxx) {
                        c(gl10);
                        this.hxB.hxx = false;
                    }
                    if (this.hxI != null && this.hxI.yb(2) && this.hxB.hxp != null) {
                        this.hxJ = this.hxB.hxp.bIx();
                        this.hxI.a(new d.b(new File(this.hxJ), GLVideoPreviewView.hxn, GLVideoPreviewView.hxo, 2097152, null, this.hxA.getTimestamp()));
                    }
                    if (this.hxI != null && this.hxI.yb(1)) {
                        this.hxI.a(this.htk, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hxs) {
                            this.hxI.e(this.hxA);
                        }
                        boolean unused = GLVideoPreviewView.hxs = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hxB.g((Camera) null);
                    if (this.hea != null) {
                        this.hea.ab(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hxI = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hxB.hxu;
                int i2 = this.hxB.hxv;
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
                if (this.hxB != null && (context = this.hxB.getContext()) != null && (context instanceof Activity)) {
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
            this.hxL = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hxB != null && this.hxB.hxw != null) {
                    this.hxB.hxw.u(false, this.hxL);
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
                        b.this.hxL = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hqP, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hxB != null && b.this.hxB.hxw != null) {
                        b.this.hxB.hxw.u(true, b.this.hxL);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bIu() {
            return this.hxB.hxp.bIu();
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
                                b.this.itemsArray[2] = b.this.htj = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hxG) {
                                b.this.htj = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.htj;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.htj, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.htj, "rotationAngle", b.this.bIu() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.htj = 0;
                                b.this.itemsArray[2] = b.this.htj;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bIu() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hea != null) {
                                b.this.hea.ab(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.hxH = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hea != null) {
                                b.this.hea.ab(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hxH = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hea != null) {
                                b.this.hea.ab(26, com.baidu.tieba.j.a.o(e3));
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
            this.hxB.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.htk != null) {
                        b.this.htk.release(false);
                        b.this.htk = null;
                    }
                    if (b.this.hxz != null) {
                        b.this.hxz.release(false);
                        b.this.hxz = null;
                    }
                    if (b.this.hxA != null) {
                        b.this.hxA.release();
                        b.this.hxA = null;
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

        private void bIv() {
            if (this.hxB != null) {
                Handler mainHandler = this.hxB.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.htj != 0) {
                    faceunity.fuItemSetParam(this.htj, "rotationAngle", bIu() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bIu() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hxG = false;
                } else {
                    this.hxG = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hxF.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hxt = aVar;
        }
    }
}
