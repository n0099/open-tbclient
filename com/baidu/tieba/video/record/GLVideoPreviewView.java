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
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private static int jBc = 720;
    private static int jBd = TbConfig.HEAD_IMG_SIZE;
    private static boolean jBh;
    protected h jBe;
    private b jBf;
    private com.faceunity.a.d jBg;
    private a jBi;
    private g.a jBj;
    private boolean jBk;
    private com.baidu.tieba.j.h jhv;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void rM(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jhv = lVar.bPk();
        }
        this.jBe = hVar;
        this.jBf = new b(context, this, this.jhv);
        setEGLContextClientVersion(2);
        setRenderer(this.jBf);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jBf);
                camera.setPreviewTexture(this.jBf.jBn);
                this.jBf.jBn.setOnFrameAvailableListener(this.jBf);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jhv != null) {
                    this.jhv.av(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jBg = new com.faceunity.a.d();
            this.jBf.a(this.jBg);
            jBh = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jhv != null) {
                this.jhv.av(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jBg != null) {
                this.jBg.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jhv != null) {
                this.jhv.av(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jBg != null) {
            this.jBg.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jBf.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jhv != null) {
                this.jhv.av(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jBf.previewWidth = i;
            this.jBf.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jBc);
            if (round % 2 == 1) {
                round--;
            }
            jBd = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jBj = aVar;
        this.jBk = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jBe == null) {
            return false;
        }
        return this.jBe.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jBf == null) {
            return;
        }
        this.jBf.cwj();
    }

    public void cwf() {
        if (this.jBf == null) {
            return;
        }
        this.jBf.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jBf != null) {
            this.jBf.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jBf != null) {
            this.jBf.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jBf != null) {
            this.jBf.setSticker(stickerItem);
        }
    }

    public void cwg() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jBf != null) {
                    GLVideoPreviewView.this.jBf.cwg();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jBf.jBz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jBe.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private String jBA;
        private com.faceunity.gles.c jBm;
        private volatile SurfaceTexture jBn;
        private GLVideoPreviewView jBo;
        private int jBp;
        private Handler jBu;
        private boolean jBv;
        private boolean jBw;
        com.faceunity.a.d jBx;
        String jBy;
        private boolean jBz;
        private com.baidu.tieba.j.h jhv;
        private com.faceunity.gles.c jxe;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int jxd = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jxd};
        private boolean isNeedEffectItem = true;
        private long jBq = 0;
        private int jBr = 0;
        private long jBs = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jBt = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jBo = gLVideoPreviewView;
            this.jhv = hVar;
            this.jBt.start();
            this.jBu = new a(this.jBt.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.BZ(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cwj() {
            this.jBu.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jBo.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jxe = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jBm = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jBp = this.jBm.createTextureObject();
            cwg();
            boolean unused = GLVideoPreviewView.jBh = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jBo.mSurfaceViewWidth = i;
            this.jBo.mSurfaceViewHeight = i2;
        }

        public void cwg() {
            if (this.jBn != null) {
                faceunity.fuOnCameraChange();
                this.jBn.release();
            }
            this.jBn = new SurfaceTexture(this.jBp);
            cwl();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.juz;
                this.mFacebeautyBlurLevel = aVar.juA;
                this.mFacebeautyCheeckThin = aVar.juB;
                this.mFacebeautyEnlargeEye = aVar.juC;
                this.mFacebeautyRedLevel = aVar.juD;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jBz) {
                int i = this.jBr + 1;
                this.jBr = i;
                if (i == 100) {
                    this.jBr = 0;
                    this.jBq = System.currentTimeMillis();
                    this.jBs = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jBn.updateTexImage();
                    this.jBn.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.jhv != null) {
                        this.jhv.av(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jBu.sendEmptyMessage(1);
                }
                if (this.jBo.jBi != null) {
                    this.jBo.jBi.rM(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jBw) {
                    this.jBo.requestRender();
                    return;
                }
                int i2 = (this.jBo.jBe.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jBv) {
                    faceunity.fuItemSetParam(this.jxd, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jxd, "rotationAngle", cwk() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cwk() ? 270.0d : 90.0d);
                }
                this.jBo.jBe.cwk();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jBp;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jBs = (System.currentTimeMillis() - currentTimeMillis) + this.jBs;
                try {
                    this.jxe.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jBo.jBk) {
                        b(gl10);
                        this.jBo.jBk = false;
                    }
                    if (this.jBx != null && this.jBx.Ew(2) && this.jBo.jBe != null) {
                        this.jBy = this.jBo.jBe.cwn();
                        this.jBx.a(new d.b(new File(this.jBy), GLVideoPreviewView.jBc, GLVideoPreviewView.jBd, 2097152, null, this.jBn.getTimestamp()));
                    }
                    if (this.jBx != null && this.jBx.Ew(1)) {
                        this.jBx.a(this.jxe, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jBh) {
                            this.jBx.d(this.jBn);
                        }
                        boolean unused = GLVideoPreviewView.jBh = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jBo.g((Camera) null);
                    if (this.jhv != null) {
                        this.jhv.av(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jBx = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jBo.mSurfaceViewWidth;
                int i2 = this.jBo.mSurfaceViewHeight;
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
                if (this.jBo != null && (context = this.jBo.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                N(bitmap);
            }
        }

        private void N(final Bitmap bitmap) {
            this.jBA = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jBo != null && this.jBo.jBj != null) {
                    this.jBo.jBj.z(false, this.jBA);
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
                        b.this.jBA = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.juJ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jBo != null && b.this.jBo.jBj != null) {
                        b.this.jBo.jBj.z(true, b.this.jBA);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean cwk() {
            return this.jBo.jBe.cwk();
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
                this.mContext.get();
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        try {
                            if (StringUtils.isNull(b.this.mEffectFileName)) {
                                b.this.itemsArray[1] = b.this.mEffectItem = 0;
                                b.this.itemsArray[2] = b.this.jxd = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jBv) {
                                b.this.jxd = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jxd;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jxd, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jxd, "rotationAngle", b.this.cwk() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jxd = 0;
                                b.this.itemsArray[2] = b.this.jxd;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.cwk() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.jhv != null) {
                                b.this.jhv.av(24, com.baidu.tieba.j.a.p(e));
                                return;
                            }
                            return;
                        }
                    case 2:
                        try {
                            InputStream open = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/v3.mp3");
                            byte[] bArr2 = new byte[open.available()];
                            open.read(bArr2);
                            open.close();
                            faceunity.fuSetup(bArr2, null, f.A());
                            b.this.jBw = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.jhv != null) {
                                b.this.jhv.av(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jBw = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.jhv != null) {
                                b.this.jhv.av(26, com.baidu.tieba.j.a.p(e3));
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
            this.jBo.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jxe != null) {
                        b.this.jxe.release(false);
                        b.this.jxe = null;
                    }
                    if (b.this.jBm != null) {
                        b.this.jBm.release(false);
                        b.this.jBm = null;
                    }
                    if (b.this.jBn != null) {
                        b.this.jBn.release();
                        b.this.jBn = null;
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

        private void cwl() {
            if (this.jBo != null) {
                Handler mainHandler = this.jBo.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jxd != 0) {
                    faceunity.fuItemSetParam(this.jxd, "rotationAngle", cwk() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cwk() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jBv = false;
                } else {
                    this.jBv = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jBu.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jBi = aVar;
        }
    }
}
