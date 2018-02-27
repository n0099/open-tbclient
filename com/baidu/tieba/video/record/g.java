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
    private static int huH = 720;
    private static int huI = TbConfig.HEAD_IMG_SIZE;
    private static boolean huM;
    private com.baidu.tieba.i.h hbC;
    protected i huJ;
    private b huK;
    private com.faceunity.a.d huL;
    private a huN;
    private int huO;
    private int huP;
    private h.a huQ;
    private boolean huR;

    /* loaded from: classes2.dex */
    public interface a {
        void nr(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
        }
        this.huJ = iVar;
        this.huK = new b(context, this, this.hbC);
        setEGLContextClientVersion(2);
        setRenderer(this.huK);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.huK);
                camera.setPreviewTexture(this.huK.huU);
                this.huK.huU.setOnFrameAvailableListener(this.huK);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hbC != null) {
                    this.hbC.U(20, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.huL = new com.faceunity.a.d();
            this.huK.a(this.huL);
            huM = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hbC != null) {
                this.hbC.U(21, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.huL != null) {
                this.huL.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hbC != null) {
                this.hbC.U(19, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.huL != null) {
            this.huL.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.huK.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbC != null) {
                this.hbC.U(18, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.huK.dAb = i;
            this.huK.dAc = i2;
            huI = (int) (((i * 1.0f) / i2) * huH);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.huQ = aVar;
        this.huR = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.huJ == null) {
            return false;
        }
        return this.huJ.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.huK == null) {
            return;
        }
        this.huK.bDb();
    }

    public void bCY() {
        if (this.huK == null) {
            return;
        }
        this.huK.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.huK != null) {
            this.huK.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.huK != null) {
            this.huK.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.huK != null) {
            this.huK.setSticker(stickerItem);
        }
    }

    public void bCZ() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.huK != null) {
                    g.this.huK.bCZ();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.huK.hve = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.huJ.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h hbC;
        private com.faceunity.gles.c hqb;
        private com.faceunity.gles.c huT;
        private volatile SurfaceTexture huU;
        private g huV;
        private int huW;
        private Handler huZ;
        private boolean hva;
        private boolean hvb;
        com.faceunity.a.d hvc;
        String hvd;
        private boolean hve;
        private String hvf;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dAb = 720;
        protected int dAc = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hqa = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hqa};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long huX = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread huY = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.huV = gVar;
            this.hbC = hVar;
            this.huY.start();
            this.huZ = new a(this.huY.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wC(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bDb() {
            this.huZ.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.huV.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hqb = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.huT = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.huW = this.huT.createTextureObject();
            bCZ();
            boolean unused = g.huM = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.huV.huO = i;
            this.huV.huP = i2;
        }

        public void bCZ() {
            if (this.huU != null) {
                faceunity.fuOnCameraChange();
                this.huU.release();
            }
            this.huU = new SurfaceTexture(this.huW);
            bDc();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hnw;
                this.mFacebeautyBlurLevel = aVar.hnx;
                this.mFacebeautyCheeckThin = aVar.hny;
                this.mFacebeautyEnlargeEye = aVar.hnz;
                this.mFacebeautyRedLevel = aVar.hnA;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hve) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.huX = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.huU.updateTexImage();
                    this.huU.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hbC != null) {
                        this.hbC.U(22, com.baidu.tieba.i.a.i(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.huZ.sendEmptyMessage(1);
                }
                if (this.huV.huN != null) {
                    this.huV.huN.nr(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hvb) {
                    this.huV.requestRender();
                    return;
                }
                int i2 = this.huV.huJ.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.huW;
                int i4 = this.dAb;
                int i5 = this.dAc;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.huX = (System.currentTimeMillis() - currentTimeMillis) + this.huX;
                try {
                    this.hqb.drawFrame(fuDualInputToTexture, fArr);
                    if (this.huV.huR) {
                        e(gl10);
                        this.huV.huR = false;
                    }
                    if (this.hvc != null && this.hvc.yG(2) && this.huV.huJ != null) {
                        this.hvd = this.huV.huJ.bDf();
                        this.hvc.a(new d.b(new File(this.hvd), g.huH, g.huI, 2097152, null, this.huU.getTimestamp()));
                    }
                    if (this.hvc != null && this.hvc.yG(1)) {
                        this.hvc.a(this.hqb, fuDualInputToTexture, fArr);
                        if (g.huM) {
                            this.hvc.c(this.huU);
                        }
                        boolean unused = g.huM = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.huV.i(null);
                    if (this.hbC != null) {
                        this.hbC.U(23, com.baidu.tieba.i.a.i(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hvc = dVar;
            }
        }

        private void e(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.huV.huO;
                int i2 = this.huV.huP;
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
                if (this.huV != null && (context = this.huV.getContext()) != null && (context instanceof Activity)) {
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
            this.hvf = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.huV != null && this.huV.huQ != null) {
                    this.huV.huQ.n(false, this.hvf);
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
                        b.this.hvf = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hnG, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.huV != null && b.this.huV.huQ != null) {
                        b.this.huV.huQ.n(true, b.this.hvf);
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
                                b.this.itemsArray[2] = b.this.hqa = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hva) {
                                b.this.hqa = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hqa;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hqa, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hqa = 0;
                                b.this.itemsArray[2] = b.this.hqa;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hbC != null) {
                                b.this.hbC.U(24, com.baidu.tieba.i.a.i(e));
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
                            b.this.hvb = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hbC != null) {
                                b.this.hbC.U(25, com.baidu.tieba.i.a.i(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hvb = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hbC != null) {
                                b.this.hbC.U(26, com.baidu.tieba.i.a.i(e3));
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
            this.huV.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hqb != null) {
                        b.this.hqb.release(false);
                        b.this.hqb = null;
                    }
                    if (b.this.huT != null) {
                        b.this.huT.release(false);
                        b.this.huT = null;
                    }
                    if (b.this.huU != null) {
                        b.this.huU.release();
                        b.this.huU = null;
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

        private void bDc() {
            if (this.huV != null) {
                Handler mainHandler = this.huV.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hva = false;
                } else {
                    this.hva = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.huZ.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.huN = aVar;
        }
    }
}
