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
    private static int hik = 720;
    private static int hil = TbConfig.HEAD_IMG_SIZE;
    private static boolean hip;
    private com.baidu.tieba.j.h gOY;
    protected h him;
    private b hin;
    private com.faceunity.a.d hio;
    private a hiq;
    private int hir;
    private int his;
    private g.a hit;
    private boolean hiu;

    /* loaded from: classes2.dex */
    public interface a {
        void na(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        this.him = hVar;
        this.hin = new b(context, this, this.gOY);
        setEGLContextClientVersion(2);
        setRenderer(this.hin);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hin);
                camera.setPreviewTexture(this.hin.hix);
                this.hin.hix.setOnFrameAvailableListener(this.hin);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gOY != null) {
                    this.gOY.ab(20, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hio = new com.faceunity.a.d();
            this.hin.a(this.hio);
            hip = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gOY != null) {
                this.gOY.ab(21, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void i(Camera camera) {
        try {
            if (this.hio != null) {
                this.hio.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gOY != null) {
                this.gOY.ab(19, com.baidu.tieba.j.a.m(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hio != null) {
            this.hio.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void j(Camera camera) {
        try {
            this.hin.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOY != null) {
                this.gOY.ab(18, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hin.ddW = i;
            this.hin.ddX = i2;
            hil = (int) (((i * 1.0f) / i2) * hik);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hit = aVar;
        this.hiu = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.him == null) {
            return false;
        }
        return this.him.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hin == null) {
            return;
        }
        this.hin.bCp();
    }

    public void bCl() {
        if (this.hin == null) {
            return;
        }
        this.hin.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hin != null) {
            this.hin.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hin != null) {
            this.hin.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hin != null) {
            this.hin.setSticker(stickerItem);
        }
    }

    public void bCm() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hin != null) {
                    GLVideoPreviewView.this.hin.bCm();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hin.hiH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.him.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h gOY;
        private com.faceunity.gles.c hec;
        private Handler hiC;
        private boolean hiD;
        private boolean hiE;
        com.faceunity.a.d hiF;
        String hiG;
        private boolean hiH;
        private String hiI;
        private com.faceunity.gles.c hiw;
        private volatile SurfaceTexture hix;
        private GLVideoPreviewView hiy;
        private int hiz;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int ddW = 720;
        protected int ddX = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int heb = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.heb};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hiA = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hiB = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hiy = gLVideoPreviewView;
            this.gOY = hVar;
            this.hiB.start();
            this.hiC = new a(this.hiB.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.ux(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bCp() {
            this.hiC.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hiy.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hec = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hiw = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hiz = this.hiw.createTextureObject();
            bCm();
            boolean unused = GLVideoPreviewView.hip = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hiy.hir = i;
            this.hiy.his = i2;
        }

        public void bCm() {
            if (this.hix != null) {
                faceunity.fuOnCameraChange();
                this.hix.release();
            }
            this.hix = new SurfaceTexture(this.hiz);
            bCr();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hbw;
                this.mFacebeautyBlurLevel = aVar.hbx;
                this.mFacebeautyCheeckThin = aVar.hby;
                this.mFacebeautyEnlargeEye = aVar.hbz;
                this.mFacebeautyRedLevel = aVar.hbA;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hiH) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hiA = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hix.updateTexImage();
                    this.hix.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gOY != null) {
                        this.gOY.ab(22, com.baidu.tieba.j.a.m(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hiC.sendEmptyMessage(1);
                }
                if (this.hiy.hiq != null) {
                    this.hiy.hiq.na(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hiE) {
                    this.hiy.requestRender();
                    return;
                }
                int i2 = (this.hiy.him.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hiD) {
                    faceunity.fuItemSetParam(this.heb, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.heb, "rotationAngle", bCq() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bCq() ? 270.0d : 90.0d);
                }
                this.hiy.him.bCq();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hiz;
                int i4 = this.ddW;
                int i5 = this.ddX;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hiA = (System.currentTimeMillis() - currentTimeMillis) + this.hiA;
                try {
                    this.hec.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hiy.hiu) {
                        c(gl10);
                        this.hiy.hiu = false;
                    }
                    if (this.hiF != null && this.hiF.vV(2) && this.hiy.him != null) {
                        this.hiG = this.hiy.him.bCt();
                        this.hiF.a(new d.b(new File(this.hiG), GLVideoPreviewView.hik, GLVideoPreviewView.hil, 2097152, null, this.hix.getTimestamp()));
                    }
                    if (this.hiF != null && this.hiF.vV(1)) {
                        this.hiF.a(this.hec, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hip) {
                            this.hiF.d(this.hix);
                        }
                        boolean unused = GLVideoPreviewView.hip = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hiy.i(null);
                    if (this.gOY != null) {
                        this.gOY.ab(23, com.baidu.tieba.j.a.m(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hiF = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hiy.hir;
                int i2 = this.hiy.his;
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
                if (this.hiy != null && (context = this.hiy.getContext()) != null && (context instanceof Activity)) {
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
            this.hiI = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hiy != null && this.hiy.hit != null) {
                    this.hiy.hit.q(false, this.hiI);
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
                        b.this.hiI = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hbG, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hiy != null && b.this.hiy.hit != null) {
                        b.this.hiy.hit.q(true, b.this.hiI);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bCq() {
            return this.hiy.him.bCq();
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
                                b.this.itemsArray[2] = b.this.heb = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hiD) {
                                b.this.heb = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.heb;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.heb, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.heb, "rotationAngle", b.this.bCq() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.heb = 0;
                                b.this.itemsArray[2] = b.this.heb;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bCq() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gOY != null) {
                                b.this.gOY.ab(24, com.baidu.tieba.j.a.m(e));
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
                            b.this.hiE = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gOY != null) {
                                b.this.gOY.ab(25, com.baidu.tieba.j.a.m(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hiE = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gOY != null) {
                                b.this.gOY.ab(26, com.baidu.tieba.j.a.m(e3));
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
            this.hiy.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hec != null) {
                        b.this.hec.release(false);
                        b.this.hec = null;
                    }
                    if (b.this.hiw != null) {
                        b.this.hiw.release(false);
                        b.this.hiw = null;
                    }
                    if (b.this.hix != null) {
                        b.this.hix.release();
                        b.this.hix = null;
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

        private void bCr() {
            if (this.hiy != null) {
                Handler mainHandler = this.hiy.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.heb != 0) {
                    faceunity.fuItemSetParam(this.heb, "rotationAngle", bCq() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bCq() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hiD = false;
                } else {
                    this.hiD = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hiC.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hiq = aVar;
        }
    }
}
