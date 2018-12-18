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
    private static int hGi = 720;
    private static int hGj = TbConfig.HEAD_IMG_SIZE;
    private static boolean hGn;
    protected h hGk;
    private b hGl;
    private com.faceunity.a.d hGm;
    private a hGo;
    private int hGp;
    private int hGq;
    private g.a hGr;
    private boolean hGs;
    private com.baidu.tieba.j.h hms;

    /* loaded from: classes5.dex */
    public interface a {
        void oe(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hms = lVar.bcL();
        }
        this.hGk = hVar;
        this.hGl = new b(context, this, this.hms);
        setEGLContextClientVersion(2);
        setRenderer(this.hGl);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hGl);
                camera.setPreviewTexture(this.hGl.hGv);
                this.hGl.hGv.setOnFrameAvailableListener(this.hGl);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hms != null) {
                    this.hms.X(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hGm = new com.faceunity.a.d();
            this.hGl.a(this.hGm);
            hGn = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hms != null) {
                this.hms.X(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hGm != null) {
                this.hGm.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hms != null) {
                this.hms.X(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hGm != null) {
            this.hGm.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hGl.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hms != null) {
                this.hms.X(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hGl.dzv = i;
            this.hGl.dzw = i2;
            hGj = (int) (((i * 1.0f) / i2) * hGi);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hGr = aVar;
        this.hGs = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hGk == null) {
            return false;
        }
        return this.hGk.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hGl == null) {
            return;
        }
        this.hGl.bJW();
    }

    public void bJS() {
        if (this.hGl == null) {
            return;
        }
        this.hGl.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hGl != null) {
            this.hGl.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hGl != null) {
            this.hGl.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hGl != null) {
            this.hGl.setSticker(stickerItem);
        }
    }

    public void bJT() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hGl != null) {
                    GLVideoPreviewView.this.hGl.bJT();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hGl.hGH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hGk.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c hCg;
        private Handler hGC;
        private boolean hGD;
        private boolean hGE;
        com.faceunity.a.d hGF;
        String hGG;
        private boolean hGH;
        private String hGI;
        private com.faceunity.gles.c hGu;
        private volatile SurfaceTexture hGv;
        private GLVideoPreviewView hGw;
        private int hGx;
        private com.baidu.tieba.j.h hms;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dzv = 720;
        protected int dzw = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hCf = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hCf};
        private boolean isNeedEffectItem = true;
        private long hGy = 0;
        private int hGz = 0;
        private long hGA = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hGB = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hGw = gLVideoPreviewView;
            this.hms = hVar;
            this.hGB.start();
            this.hGC = new a(this.hGB.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wk(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bJW() {
            this.hGC.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hGw.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hCg = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hGu = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hGx = this.hGu.createTextureObject();
            bJT();
            boolean unused = GLVideoPreviewView.hGn = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hGw.hGp = i;
            this.hGw.hGq = i2;
        }

        public void bJT() {
            if (this.hGv != null) {
                faceunity.fuOnCameraChange();
                this.hGv.release();
            }
            this.hGv = new SurfaceTexture(this.hGx);
            bJY();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hzB;
                this.mFacebeautyBlurLevel = aVar.hzC;
                this.mFacebeautyCheeckThin = aVar.hzD;
                this.mFacebeautyEnlargeEye = aVar.hzE;
                this.mFacebeautyRedLevel = aVar.hzF;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hGH) {
                int i = this.hGz + 1;
                this.hGz = i;
                if (i == 100) {
                    this.hGz = 0;
                    this.hGy = System.currentTimeMillis();
                    this.hGA = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hGv.updateTexImage();
                    this.hGv.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hms != null) {
                        this.hms.X(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hGC.sendEmptyMessage(1);
                }
                if (this.hGw.hGo != null) {
                    this.hGw.hGo.oe(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hGE) {
                    this.hGw.requestRender();
                    return;
                }
                int i2 = (this.hGw.hGk.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hGD) {
                    faceunity.fuItemSetParam(this.hCf, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.hCf, "rotationAngle", bJX() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bJX() ? 270.0d : 90.0d);
                }
                this.hGw.hGk.bJX();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hGx;
                int i4 = this.dzv;
                int i5 = this.dzw;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hGA = (System.currentTimeMillis() - currentTimeMillis) + this.hGA;
                try {
                    this.hCg.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hGw.hGs) {
                        d(gl10);
                        this.hGw.hGs = false;
                    }
                    if (this.hGF != null && this.hGF.yR(2) && this.hGw.hGk != null) {
                        this.hGG = this.hGw.hGk.bKa();
                        this.hGF.a(new d.b(new File(this.hGG), GLVideoPreviewView.hGi, GLVideoPreviewView.hGj, 2097152, null, this.hGv.getTimestamp()));
                    }
                    if (this.hGF != null && this.hGF.yR(1)) {
                        this.hGF.a(this.hCg, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hGn) {
                            this.hGF.e(this.hGv);
                        }
                        boolean unused = GLVideoPreviewView.hGn = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hGw.g((Camera) null);
                    if (this.hms != null) {
                        this.hms.X(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hGF = dVar;
            }
        }

        private void d(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hGw.hGp;
                int i2 = this.hGw.hGq;
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
                if (this.hGw != null && (context = this.hGw.getContext()) != null && (context instanceof Activity)) {
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
            this.hGI = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hGw != null && this.hGw.hGr != null) {
                    this.hGw.hGr.t(false, this.hGI);
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
                        b.this.hGI = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hzL, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hGw != null && b.this.hGw.hGr != null) {
                        b.this.hGw.hGr.t(true, b.this.hGI);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bJX() {
            return this.hGw.hGk.bJX();
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
                                b.this.itemsArray[2] = b.this.hCf = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hGD) {
                                b.this.hCf = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hCf;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hCf, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.hCf, "rotationAngle", b.this.bJX() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hCf = 0;
                                b.this.itemsArray[2] = b.this.hCf;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bJX() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hms != null) {
                                b.this.hms.X(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.hGE = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hms != null) {
                                b.this.hms.X(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hGE = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hms != null) {
                                b.this.hms.X(26, com.baidu.tieba.j.a.o(e3));
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
            this.hGw.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hCg != null) {
                        b.this.hCg.release(false);
                        b.this.hCg = null;
                    }
                    if (b.this.hGu != null) {
                        b.this.hGu.release(false);
                        b.this.hGu = null;
                    }
                    if (b.this.hGv != null) {
                        b.this.hGv.release();
                        b.this.hGv = null;
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

        private void bJY() {
            if (this.hGw != null) {
                Handler mainHandler = this.hGw.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.hCf != 0) {
                    faceunity.fuItemSetParam(this.hCf, "rotationAngle", bJX() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bJX() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hGD = false;
                } else {
                    this.hGD = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hGC.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hGo = aVar;
        }
    }
}
