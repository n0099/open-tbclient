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
    private static int hil = 720;
    private static int him = TbConfig.HEAD_IMG_SIZE;
    private static boolean hiq;
    private com.baidu.tieba.j.h gPa;
    protected h hin;
    private b hio;
    private com.faceunity.a.d hip;
    private a hir;
    private int his;
    private int hit;
    private g.a hiu;
    private boolean hiv;

    /* loaded from: classes2.dex */
    public interface a {
        void na(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
        }
        this.hin = hVar;
        this.hio = new b(context, this, this.gPa);
        setEGLContextClientVersion(2);
        setRenderer(this.hio);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hio);
                camera.setPreviewTexture(this.hio.hiy);
                this.hio.hiy.setOnFrameAvailableListener(this.hio);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gPa != null) {
                    this.gPa.ab(20, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hip = new com.faceunity.a.d();
            this.hio.a(this.hip);
            hiq = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gPa != null) {
                this.gPa.ab(21, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hip != null) {
                this.hip.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gPa != null) {
                this.gPa.ab(19, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hip != null) {
            this.hip.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hio.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gPa != null) {
                this.gPa.ab(18, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hio.ddU = i;
            this.hio.ddV = i2;
            him = (int) (((i * 1.0f) / i2) * hil);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hiu = aVar;
        this.hiv = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hin == null) {
            return false;
        }
        return this.hin.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hio == null) {
            return;
        }
        this.hio.bCr();
    }

    public void bCn() {
        if (this.hio == null) {
            return;
        }
        this.hio.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hio != null) {
            this.hio.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hio != null) {
            this.hio.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hio != null) {
            this.hio.setSticker(stickerItem);
        }
    }

    public void bCo() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hio != null) {
                    GLVideoPreviewView.this.hio.bCo();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hio.hiI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hin.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h gPa;
        private com.faceunity.gles.c hed;
        private int hiA;
        private Handler hiD;
        private boolean hiE;
        private boolean hiF;
        com.faceunity.a.d hiG;
        String hiH;
        private boolean hiI;
        private String hiJ;
        private com.faceunity.gles.c hix;
        private volatile SurfaceTexture hiy;
        private GLVideoPreviewView hiz;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int ddU = 720;
        protected int ddV = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hec = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hec};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hiB = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hiC = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hiz = gLVideoPreviewView;
            this.gPa = hVar;
            this.hiC.start();
            this.hiD = new a(this.hiC.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.ux(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bCr() {
            this.hiD.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hiz.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hed = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hix = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hiA = this.hix.createTextureObject();
            bCo();
            boolean unused = GLVideoPreviewView.hiq = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hiz.his = i;
            this.hiz.hit = i2;
        }

        public void bCo() {
            if (this.hiy != null) {
                faceunity.fuOnCameraChange();
                this.hiy.release();
            }
            this.hiy = new SurfaceTexture(this.hiA);
            bCt();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hbx;
                this.mFacebeautyBlurLevel = aVar.hby;
                this.mFacebeautyCheeckThin = aVar.hbz;
                this.mFacebeautyEnlargeEye = aVar.hbA;
                this.mFacebeautyRedLevel = aVar.hbB;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hiI) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hiB = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hiy.updateTexImage();
                    this.hiy.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gPa != null) {
                        this.gPa.ab(22, com.baidu.tieba.j.a.m(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hiD.sendEmptyMessage(1);
                }
                if (this.hiz.hir != null) {
                    this.hiz.hir.na(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hiF) {
                    this.hiz.requestRender();
                    return;
                }
                int i2 = (this.hiz.hin.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hiE) {
                    faceunity.fuItemSetParam(this.hec, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.hec, "rotationAngle", bCs() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bCs() ? 270.0d : 90.0d);
                }
                this.hiz.hin.bCs();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hiA;
                int i4 = this.ddU;
                int i5 = this.ddV;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hiB = (System.currentTimeMillis() - currentTimeMillis) + this.hiB;
                try {
                    this.hed.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hiz.hiv) {
                        c(gl10);
                        this.hiz.hiv = false;
                    }
                    if (this.hiG != null && this.hiG.vV(2) && this.hiz.hin != null) {
                        this.hiH = this.hiz.hin.bCv();
                        this.hiG.a(new d.b(new File(this.hiH), GLVideoPreviewView.hil, GLVideoPreviewView.him, 2097152, null, this.hiy.getTimestamp()));
                    }
                    if (this.hiG != null && this.hiG.vV(1)) {
                        this.hiG.a(this.hed, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hiq) {
                            this.hiG.d(this.hiy);
                        }
                        boolean unused = GLVideoPreviewView.hiq = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hiz.g((Camera) null);
                    if (this.gPa != null) {
                        this.gPa.ab(23, com.baidu.tieba.j.a.m(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hiG = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hiz.his;
                int i2 = this.hiz.hit;
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
                if (this.hiz != null && (context = this.hiz.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                D(bitmap);
            }
        }

        private void D(final Bitmap bitmap) {
            this.hiJ = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hiz != null && this.hiz.hiu != null) {
                    this.hiz.hiu.p(false, this.hiJ);
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
                        b.this.hiJ = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hbH, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hiz != null && b.this.hiz.hiu != null) {
                        b.this.hiz.hiu.p(true, b.this.hiJ);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bCs() {
            return this.hiz.hin.bCs();
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
                                b.this.itemsArray[2] = b.this.hec = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hiE) {
                                b.this.hec = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hec;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hec, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.hec, "rotationAngle", b.this.bCs() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hec = 0;
                                b.this.itemsArray[2] = b.this.hec;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bCs() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gPa != null) {
                                b.this.gPa.ab(24, com.baidu.tieba.j.a.m(e));
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
                            b.this.hiF = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gPa != null) {
                                b.this.gPa.ab(25, com.baidu.tieba.j.a.m(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hiF = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gPa != null) {
                                b.this.gPa.ab(26, com.baidu.tieba.j.a.m(e3));
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
            this.hiz.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hed != null) {
                        b.this.hed.release(false);
                        b.this.hed = null;
                    }
                    if (b.this.hix != null) {
                        b.this.hix.release(false);
                        b.this.hix = null;
                    }
                    if (b.this.hiy != null) {
                        b.this.hiy.release();
                        b.this.hiy = null;
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

        private void bCt() {
            if (this.hiz != null) {
                Handler mainHandler = this.hiz.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.hec != 0) {
                    faceunity.fuItemSetParam(this.hec, "rotationAngle", bCs() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bCs() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hiE = false;
                } else {
                    this.hiE = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hiD.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hir = aVar;
        }
    }
}
