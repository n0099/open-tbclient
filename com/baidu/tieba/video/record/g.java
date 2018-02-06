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
import com.baidu.tieba.video.record.h;
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
public class g extends GLSurfaceView implements h {
    private static int huU = 720;
    private static int huV = TbConfig.HEAD_IMG_SIZE;
    private static boolean huZ;
    private com.baidu.tieba.i.h hbR;
    protected i huW;
    private b huX;
    private com.faceunity.a.d huY;
    private a hva;
    private int hvb;
    private int hvc;
    private h.a hvd;
    private boolean hve;

    /* loaded from: classes2.dex */
    public interface a {
        void nr(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        this.huW = iVar;
        this.huX = new b(context, this, this.hbR);
        setEGLContextClientVersion(2);
        setRenderer(this.huX);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.huX);
                camera.setPreviewTexture(this.huX.hvh);
                this.huX.hvh.setOnFrameAvailableListener(this.huX);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hbR != null) {
                    this.hbR.U(20, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.huY = new com.faceunity.a.d();
            this.huX.a(this.huY);
            huZ = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hbR != null) {
                this.hbR.U(21, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.huY != null) {
                this.huY.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hbR != null) {
                this.hbR.U(19, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.huY != null) {
            this.huY.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.huX.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbR != null) {
                this.hbR.U(18, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.huX.dAn = i;
            this.huX.dAo = i2;
            huV = (int) (((i * 1.0f) / i2) * huU);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.hvd = aVar;
        this.hve = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.huW == null) {
            return false;
        }
        return this.huW.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.huX == null) {
            return;
        }
        this.huX.bDc();
    }

    public void bCZ() {
        if (this.huX == null) {
            return;
        }
        this.huX.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.huX != null) {
            this.huX.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.huX != null) {
            this.huX.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.huX != null) {
            this.huX.setSticker(stickerItem);
        }
    }

    public void bDa() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.huX != null) {
                    g.this.huX.bDa();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.huX.hvr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.huW.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h hbR;
        private com.faceunity.gles.c hqo;
        private com.faceunity.gles.c hvg;
        private volatile SurfaceTexture hvh;
        private g hvi;
        private int hvj;
        private Handler hvm;
        private boolean hvn;
        private boolean hvo;
        com.faceunity.a.d hvp;
        String hvq;
        private boolean hvr;
        private String hvs;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dAn = 720;
        protected int dAo = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hqn = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hqn};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hvk = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hvl = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.hvi = gVar;
            this.hbR = hVar;
            this.hvl.start();
            this.hvm = new a(this.hvl.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wB(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bDc() {
            this.hvm.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hvi.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hqo = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hvg = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hvj = this.hvg.createTextureObject();
            bDa();
            boolean unused = g.huZ = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hvi.hvb = i;
            this.hvi.hvc = i2;
        }

        public void bDa() {
            if (this.hvh != null) {
                faceunity.fuOnCameraChange();
                this.hvh.release();
            }
            this.hvh = new SurfaceTexture(this.hvj);
            bDd();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hnJ;
                this.mFacebeautyBlurLevel = aVar.hnK;
                this.mFacebeautyCheeckThin = aVar.hnL;
                this.mFacebeautyEnlargeEye = aVar.hnM;
                this.mFacebeautyRedLevel = aVar.hnN;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hvr) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hvk = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hvh.updateTexImage();
                    this.hvh.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hbR != null) {
                        this.hbR.U(22, com.baidu.tieba.i.a.i(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hvm.sendEmptyMessage(1);
                }
                if (this.hvi.hva != null) {
                    this.hvi.hva.nr(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hvo) {
                    this.hvi.requestRender();
                    return;
                }
                int i2 = this.hvi.huW.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hvj;
                int i4 = this.dAn;
                int i5 = this.dAo;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.hvk = (System.currentTimeMillis() - currentTimeMillis) + this.hvk;
                try {
                    this.hqo.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hvi.hve) {
                        e(gl10);
                        this.hvi.hve = false;
                    }
                    if (this.hvp != null && this.hvp.yF(2) && this.hvi.huW != null) {
                        this.hvq = this.hvi.huW.bDg();
                        this.hvp.a(new d.b(new File(this.hvq), g.huU, g.huV, 2097152, null, this.hvh.getTimestamp()));
                    }
                    if (this.hvp != null && this.hvp.yF(1)) {
                        this.hvp.a(this.hqo, fuDualInputToTexture, fArr);
                        if (g.huZ) {
                            this.hvp.c(this.hvh);
                        }
                        boolean unused = g.huZ = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hvi.i(null);
                    if (this.hbR != null) {
                        this.hbR.U(23, com.baidu.tieba.i.a.i(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hvp = dVar;
            }
        }

        private void e(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hvi.hvb;
                int i2 = this.hvi.hvc;
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
                if (this.hvi != null && (context = this.hvi.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                B(bitmap);
            }
        }

        private void B(final Bitmap bitmap) {
            this.hvs = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hvi != null && this.hvi.hvd != null) {
                    this.hvi.hvd.n(false, this.hvs);
                    return;
                }
                return;
            }
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.video.record.g.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    try {
                        b.this.hvs = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hnT, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                /* renamed from: a */
                public void onPostExecute(Void r4) {
                    if (b.this.hvi != null && b.this.hvi.hvd != null) {
                        b.this.hvi.hvd.n(true, b.this.hvs);
                    }
                }
            }.execute(new Void[0]);
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
                                b.this.itemsArray[2] = b.this.hqn = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hvn) {
                                b.this.hqn = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hqn;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hqn, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hqn = 0;
                                b.this.itemsArray[2] = b.this.hqn;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hbR != null) {
                                b.this.hbR.U(24, com.baidu.tieba.i.a.i(e));
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
                            b.this.hvo = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hbR != null) {
                                b.this.hbR.U(25, com.baidu.tieba.i.a.i(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hvo = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hbR != null) {
                                b.this.hbR.U(26, com.baidu.tieba.i.a.i(e3));
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
            this.hvi.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hqo != null) {
                        b.this.hqo.release(false);
                        b.this.hqo = null;
                    }
                    if (b.this.hvg != null) {
                        b.this.hvg.release(false);
                        b.this.hvg = null;
                    }
                    if (b.this.hvh != null) {
                        b.this.hvh.release();
                        b.this.hvh = null;
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

        private void bDd() {
            if (this.hvi != null) {
                Handler mainHandler = this.hvi.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hvn = false;
                } else {
                    this.hvn = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hvm.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hva = aVar;
        }
    }
}
