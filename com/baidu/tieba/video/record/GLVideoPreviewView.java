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
    private static int hqa = 720;
    private static int hqb = TbConfig.HEAD_IMG_SIZE;
    private static boolean hqf;
    private com.baidu.tieba.j.h gWF;
    protected h hqc;
    private b hqd;
    private com.faceunity.a.d hqe;
    private a hqg;
    private int hqh;
    private int hqi;
    private g.a hqj;
    private boolean hqk;

    /* loaded from: classes2.dex */
    public interface a {
        void nx(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        this.hqc = hVar;
        this.hqd = new b(context, this, this.gWF);
        setEGLContextClientVersion(2);
        setRenderer(this.hqd);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hqd);
                camera.setPreviewTexture(this.hqd.hqn);
                this.hqd.hqn.setOnFrameAvailableListener(this.hqd);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gWF != null) {
                    this.gWF.ab(20, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hqe = new com.faceunity.a.d();
            this.hqd.a(this.hqe);
            hqf = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gWF != null) {
                this.gWF.ab(21, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hqe != null) {
                this.hqe.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gWF != null) {
                this.gWF.ab(19, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hqe != null) {
            this.hqe.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hqd.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gWF != null) {
                this.gWF.ab(18, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hqd.djN = i;
            this.hqd.djO = i2;
            hqb = (int) (((i * 1.0f) / i2) * hqa);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hqj = aVar;
        this.hqk = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hqc == null) {
            return false;
        }
        return this.hqc.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hqd == null) {
            return;
        }
        this.hqd.bFg();
    }

    public void bFc() {
        if (this.hqd == null) {
            return;
        }
        this.hqd.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hqd != null) {
            this.hqd.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hqd != null) {
            this.hqd.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hqd != null) {
            this.hqd.setSticker(stickerItem);
        }
    }

    public void bFd() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hqd != null) {
                    GLVideoPreviewView.this.hqd.bFd();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hqd.hqx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hqc.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h gWF;
        private com.faceunity.gles.c hlV;
        private com.faceunity.gles.c hqm;
        private volatile SurfaceTexture hqn;
        private GLVideoPreviewView hqo;
        private int hqp;
        private Handler hqs;
        private boolean hqt;
        private boolean hqu;
        com.faceunity.a.d hqv;
        String hqw;
        private boolean hqx;
        private String hqy;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int djN = 720;
        protected int djO = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hlU = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hlU};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hqq = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hqr = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hqo = gLVideoPreviewView;
            this.gWF = hVar;
            this.hqr.start();
            this.hqs = new a(this.hqr.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.uX(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bFg() {
            this.hqs.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hqo.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hlV = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hqm = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hqp = this.hqm.createTextureObject();
            bFd();
            boolean unused = GLVideoPreviewView.hqf = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hqo.hqh = i;
            this.hqo.hqi = i2;
        }

        public void bFd() {
            if (this.hqn != null) {
                faceunity.fuOnCameraChange();
                this.hqn.release();
            }
            this.hqn = new SurfaceTexture(this.hqp);
            bFi();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hjp;
                this.mFacebeautyBlurLevel = aVar.hjq;
                this.mFacebeautyCheeckThin = aVar.hjr;
                this.mFacebeautyEnlargeEye = aVar.hjs;
                this.mFacebeautyRedLevel = aVar.hjt;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hqx) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hqq = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hqn.updateTexImage();
                    this.hqn.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gWF != null) {
                        this.gWF.ab(22, com.baidu.tieba.j.a.m(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hqs.sendEmptyMessage(1);
                }
                if (this.hqo.hqg != null) {
                    this.hqo.hqg.nx(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hqu) {
                    this.hqo.requestRender();
                    return;
                }
                int i2 = (this.hqo.hqc.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hqt) {
                    faceunity.fuItemSetParam(this.hlU, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.hlU, "rotationAngle", bFh() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bFh() ? 270.0d : 90.0d);
                }
                this.hqo.hqc.bFh();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hqp;
                int i4 = this.djN;
                int i5 = this.djO;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hqq = (System.currentTimeMillis() - currentTimeMillis) + this.hqq;
                try {
                    this.hlV.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hqo.hqk) {
                        c(gl10);
                        this.hqo.hqk = false;
                    }
                    if (this.hqv != null && this.hqv.wu(2) && this.hqo.hqc != null) {
                        this.hqw = this.hqo.hqc.bFk();
                        this.hqv.a(new d.b(new File(this.hqw), GLVideoPreviewView.hqa, GLVideoPreviewView.hqb, 2097152, null, this.hqn.getTimestamp()));
                    }
                    if (this.hqv != null && this.hqv.wu(1)) {
                        this.hqv.a(this.hlV, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hqf) {
                            this.hqv.d(this.hqn);
                        }
                        boolean unused = GLVideoPreviewView.hqf = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hqo.g((Camera) null);
                    if (this.gWF != null) {
                        this.gWF.ab(23, com.baidu.tieba.j.a.m(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hqv = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hqo.hqh;
                int i2 = this.hqo.hqi;
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
                if (this.hqo != null && (context = this.hqo.getContext()) != null && (context instanceof Activity)) {
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
            this.hqy = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hqo != null && this.hqo.hqj != null) {
                    this.hqo.hqj.u(false, this.hqy);
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
                        b.this.hqy = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hjz, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hqo != null && b.this.hqo.hqj != null) {
                        b.this.hqo.hqj.u(true, b.this.hqy);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bFh() {
            return this.hqo.hqc.bFh();
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
                                b.this.itemsArray[2] = b.this.hlU = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hqt) {
                                b.this.hlU = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hlU;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hlU, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.hlU, "rotationAngle", b.this.bFh() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hlU = 0;
                                b.this.itemsArray[2] = b.this.hlU;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bFh() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gWF != null) {
                                b.this.gWF.ab(24, com.baidu.tieba.j.a.m(e));
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
                            b.this.hqu = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gWF != null) {
                                b.this.gWF.ab(25, com.baidu.tieba.j.a.m(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hqu = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gWF != null) {
                                b.this.gWF.ab(26, com.baidu.tieba.j.a.m(e3));
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
            this.hqo.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hlV != null) {
                        b.this.hlV.release(false);
                        b.this.hlV = null;
                    }
                    if (b.this.hqm != null) {
                        b.this.hqm.release(false);
                        b.this.hqm = null;
                    }
                    if (b.this.hqn != null) {
                        b.this.hqn.release();
                        b.this.hqn = null;
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

        private void bFi() {
            if (this.hqo != null) {
                Handler mainHandler = this.hqo.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.hlU != 0) {
                    faceunity.fuItemSetParam(this.hlU, "rotationAngle", bFh() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bFh() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hqt = false;
                } else {
                    this.hqt = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hqs.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hqg = aVar;
        }
    }
}
