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
    private static int hvf = 720;
    private static int hvg = TbConfig.HEAD_IMG_SIZE;
    private static boolean hvk;
    private com.baidu.tieba.i.h hca;
    protected i hvh;
    private b hvi;
    private com.faceunity.a.d hvj;
    private a hvl;
    private int hvm;
    private int hvn;
    private h.a hvo;
    private boolean hvp;

    /* loaded from: classes2.dex */
    public interface a {
        void nw(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        this.hvh = iVar;
        this.hvi = new b(context, this, this.hca);
        setEGLContextClientVersion(2);
        setRenderer(this.hvi);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hvi);
                camera.setPreviewTexture(this.hvi.hvs);
                this.hvi.hvs.setOnFrameAvailableListener(this.hvi);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hca != null) {
                    this.hca.U(20, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.hvj = new com.faceunity.a.d();
            this.hvi.a(this.hvj);
            hvk = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hca != null) {
                this.hca.U(21, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.hvj != null) {
                this.hvj.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hca != null) {
                this.hca.U(19, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hvj != null) {
            this.hvj.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.hvi.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hca != null) {
                this.hca.U(18, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hvi.dAe = i;
            this.hvi.dAf = i2;
            hvg = (int) (((i * 1.0f) / i2) * hvf);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.hvo = aVar;
        this.hvp = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hvh == null) {
            return false;
        }
        return this.hvh.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hvi == null) {
            return;
        }
        this.hvi.bDg();
    }

    public void bDd() {
        if (this.hvi == null) {
            return;
        }
        this.hvi.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hvi != null) {
            this.hvi.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hvi != null) {
            this.hvi.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hvi != null) {
            this.hvi.setSticker(stickerItem);
        }
    }

    public void bDe() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.hvi != null) {
                    g.this.hvi.bDe();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hvi.hvC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hvh.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h hca;
        private com.faceunity.gles.c hqz;
        com.faceunity.a.d hvA;
        String hvB;
        private boolean hvC;
        private String hvD;
        private com.faceunity.gles.c hvr;
        private volatile SurfaceTexture hvs;
        private g hvt;
        private int hvu;
        private Handler hvx;
        private boolean hvy;
        private boolean hvz;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dAe = 720;
        protected int dAf = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hqy = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hqy};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hvv = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hvw = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.hvt = gVar;
            this.hca = hVar;
            this.hvw.start();
            this.hvx = new a(this.hvw.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wC(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bDg() {
            this.hvx.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hvt.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hqz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hvr = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hvu = this.hvr.createTextureObject();
            bDe();
            boolean unused = g.hvk = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hvt.hvm = i;
            this.hvt.hvn = i2;
        }

        public void bDe() {
            if (this.hvs != null) {
                faceunity.fuOnCameraChange();
                this.hvs.release();
            }
            this.hvs = new SurfaceTexture(this.hvu);
            bDh();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hnU;
                this.mFacebeautyBlurLevel = aVar.hnV;
                this.mFacebeautyCheeckThin = aVar.hnW;
                this.mFacebeautyEnlargeEye = aVar.hnX;
                this.mFacebeautyRedLevel = aVar.hnY;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hvC) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hvv = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hvs.updateTexImage();
                    this.hvs.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hca != null) {
                        this.hca.U(22, com.baidu.tieba.i.a.i(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hvx.sendEmptyMessage(1);
                }
                if (this.hvt.hvl != null) {
                    this.hvt.hvl.nw(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hvz) {
                    this.hvt.requestRender();
                    return;
                }
                int i2 = this.hvt.hvh.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hvu;
                int i4 = this.dAe;
                int i5 = this.dAf;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.hvv = (System.currentTimeMillis() - currentTimeMillis) + this.hvv;
                try {
                    this.hqz.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hvt.hvp) {
                        e(gl10);
                        this.hvt.hvp = false;
                    }
                    if (this.hvA != null && this.hvA.yG(2) && this.hvt.hvh != null) {
                        this.hvB = this.hvt.hvh.bDk();
                        this.hvA.a(new d.b(new File(this.hvB), g.hvf, g.hvg, 2097152, null, this.hvs.getTimestamp()));
                    }
                    if (this.hvA != null && this.hvA.yG(1)) {
                        this.hvA.a(this.hqz, fuDualInputToTexture, fArr);
                        if (g.hvk) {
                            this.hvA.c(this.hvs);
                        }
                        boolean unused = g.hvk = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hvt.i(null);
                    if (this.hca != null) {
                        this.hca.U(23, com.baidu.tieba.i.a.i(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hvA = dVar;
            }
        }

        private void e(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hvt.hvm;
                int i2 = this.hvt.hvn;
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
                if (this.hvt != null && (context = this.hvt.getContext()) != null && (context instanceof Activity)) {
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
            this.hvD = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hvt != null && this.hvt.hvo != null) {
                    this.hvt.hvo.n(false, this.hvD);
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
                        b.this.hvD = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hoe, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hvt != null && b.this.hvt.hvo != null) {
                        b.this.hvt.hvo.n(true, b.this.hvD);
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
                                b.this.itemsArray[2] = b.this.hqy = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hvy) {
                                b.this.hqy = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hqy;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hqy, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hqy = 0;
                                b.this.itemsArray[2] = b.this.hqy;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hca != null) {
                                b.this.hca.U(24, com.baidu.tieba.i.a.i(e));
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
                            b.this.hvz = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hca != null) {
                                b.this.hca.U(25, com.baidu.tieba.i.a.i(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hvz = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hca != null) {
                                b.this.hca.U(26, com.baidu.tieba.i.a.i(e3));
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
            this.hvt.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hqz != null) {
                        b.this.hqz.release(false);
                        b.this.hqz = null;
                    }
                    if (b.this.hvr != null) {
                        b.this.hvr.release(false);
                        b.this.hvr = null;
                    }
                    if (b.this.hvs != null) {
                        b.this.hvs.release();
                        b.this.hvs = null;
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

        private void bDh() {
            if (this.hvt != null) {
                Handler mainHandler = this.hvt.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hvy = false;
                } else {
                    this.hvy = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hvx.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hvl = aVar;
        }
    }
}
