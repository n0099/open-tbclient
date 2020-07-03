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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.n;
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
/* loaded from: classes10.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int maU = 720;
    private static int maV = TbConfig.HEAD_IMG_SIZE;
    private static boolean maZ;
    private com.baidu.tieba.k.h lHf;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h maW;
    private b maX;
    private com.faceunity.a.d maY;
    private a mba;
    private g.a mbb;
    private boolean mbc;

    /* loaded from: classes10.dex */
    public interface a {
        void vs(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCP();
        }
        this.maW = hVar;
        this.maX = new b(context, this, this.lHf);
        setEGLContextClientVersion(2);
        setRenderer(this.maX);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.maX);
                camera.setPreviewTexture(this.maX.mbf);
                this.maX.mbf.setOnFrameAvailableListener(this.maX);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lHf != null) {
                    this.lHf.bn(20, com.baidu.tieba.k.a.t(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.maY = new com.faceunity.a.d();
            this.maX.a(this.maY);
            maZ = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lHf != null) {
                this.lHf.bn(21, com.baidu.tieba.k.a.t(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.maY != null) {
                this.maY.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lHf != null) {
                this.lHf.bn(19, com.baidu.tieba.k.a.t(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.maY != null) {
            this.maY.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.maX.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(18, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.maX.previewWidth = i;
            this.maX.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * maU);
            if (round % 2 == 1) {
                round--;
            }
            if (maV == 960) {
                maV = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mbb = aVar;
        this.mbc = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.maW == null) {
            return false;
        }
        return this.maW.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.maX == null) {
            return;
        }
        this.maX.dol();
    }

    public void doh() {
        if (this.maX == null) {
            return;
        }
        this.maX.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.maX != null) {
            this.maX.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.maX != null) {
            this.maX.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.maX != null) {
            this.maX.setSticker(stickerItem);
        }
    }

    public void doi() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.maX != null) {
                    GLVideoPreviewView.this.maX.doi();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.maX.mbr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.maW.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.k.h lHf;
        private com.faceunity.gles.c lWN;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c mbe;
        private volatile SurfaceTexture mbf;
        private GLVideoPreviewView mbg;
        private int mbh;
        private Handler mbm;
        private boolean mbn;
        private boolean mbo;
        com.faceunity.a.d mbp;
        String mbq;
        private boolean mbr;
        private String mbs;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int lWM = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.lWM};
        private boolean isNeedEffectItem = true;
        private long mbi = 0;
        private int mbj = 0;
        private long mbk = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread mbl = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.mbg = gLVideoPreviewView;
            this.lHf = hVar;
            this.mbl.start();
            this.mbm = new a(this.mbl.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.FQ(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dol() {
            this.mbm.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.mbg.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.lWN = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.mbe = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mbh = this.mbe.createTextureObject();
            doi();
            boolean unused = GLVideoPreviewView.maZ = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.mbg.mSurfaceViewWidth = i;
            this.mbg.mSurfaceViewHeight = i2;
        }

        public void doi() {
            if (this.mbf != null) {
                faceunity.fuOnCameraChange();
                this.mbf.release();
            }
            this.mbf = new SurfaceTexture(this.mbh);
            don();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.lUm;
                this.mFacebeautyBlurLevel = aVar.lUn;
                this.mFacebeautyCheeckThin = aVar.lUo;
                this.mFacebeautyEnlargeEye = aVar.lUp;
                this.mFacebeautyRedLevel = aVar.lUq;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.mbr) {
                int i = this.mbj + 1;
                this.mbj = i;
                if (i == 100) {
                    this.mbj = 0;
                    this.mbi = System.currentTimeMillis();
                    this.mbk = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.mbf.updateTexImage();
                    this.mbf.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.lHf != null) {
                        this.lHf.bn(22, com.baidu.tieba.k.a.t(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.mbm.sendEmptyMessage(1);
                }
                if (this.mbg.mba != null) {
                    this.mbg.mba.vs(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.mbo) {
                    this.mbg.requestRender();
                    return;
                }
                int i2 = (this.mbg.maW.mCameraId != 1 ? 32 : 0) | 1;
                if (this.mbn) {
                    faceunity.fuItemSetParam(this.lWM, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.lWM, "rotationAngle", dom() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dom() ? 270.0d : 90.0d);
                }
                this.mbg.maW.dom();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.mbh;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.mbk = (System.currentTimeMillis() - currentTimeMillis) + this.mbk;
                try {
                    this.lWN.drawFrame(fuDualInputToTexture, fArr);
                    if (this.mbg.mbc) {
                        b(gl10);
                        this.mbg.mbc = false;
                    }
                    if (this.mbp != null && this.mbp.Jx(2) && this.mbg.maW != null) {
                        this.mbq = this.mbg.maW.dop();
                        this.mbp.a(new d.b(new File(this.mbq), GLVideoPreviewView.maU, GLVideoPreviewView.maV, 2097152, null, this.mbf.getTimestamp()));
                    }
                    if (this.mbp != null && this.mbp.Jx(1)) {
                        this.mbp.a(this.lWN, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.maZ) {
                            this.mbp.f(this.mbf);
                        }
                        boolean unused = GLVideoPreviewView.maZ = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.mbg.g((Camera) null);
                    if (this.lHf != null) {
                        this.lHf.bn(23, com.baidu.tieba.k.a.t(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.mbp = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.mbg.mSurfaceViewWidth;
                int i2 = this.mbg.mSurfaceViewHeight;
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
                if (this.mbg != null && (context = this.mbg.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                Q(bitmap);
            }
        }

        private void Q(final Bitmap bitmap) {
            this.mbs = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.mbg != null && this.mbg.mbb != null) {
                    this.mbg.mbb.C(false, this.mbs);
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
                        b.this.mbs = n.saveFileAsPic(com.baidu.tieba.video.d.lUx, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.mbg != null && b.this.mbg.mbb != null) {
                        b.this.mbg.mbb.C(true, b.this.mbs);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dom() {
            return this.mbg.maW.dom();
        }

        /* loaded from: classes10.dex */
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
                                b.this.itemsArray[2] = b.this.lWM = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.mbn) {
                                b.this.lWM = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.lWM;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.lWM, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.lWM, "rotationAngle", b.this.dom() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.lWM = 0;
                                b.this.itemsArray[2] = b.this.lWM;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dom() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.lHf != null) {
                                b.this.lHf.bn(24, com.baidu.tieba.k.a.t(e));
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
                            b.this.mbo = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.lHf != null) {
                                b.this.lHf.bn(25, com.baidu.tieba.k.a.t(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.mbo = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.lHf != null) {
                                b.this.lHf.bn(26, com.baidu.tieba.k.a.t(e3));
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
            this.mbg.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.lWN != null) {
                        b.this.lWN.release(false);
                        b.this.lWN = null;
                    }
                    if (b.this.mbe != null) {
                        b.this.mbe.release(false);
                        b.this.mbe = null;
                    }
                    if (b.this.mbf != null) {
                        b.this.mbf.release();
                        b.this.mbf = null;
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

        private void don() {
            if (this.mbg != null) {
                Handler mainHandler = this.mbg.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.lWM != 0) {
                    faceunity.fuItemSetParam(this.lWM, "rotationAngle", dom() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dom() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.mbn = false;
                } else {
                    this.mbn = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.mbm.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.mba = aVar;
        }
    }
}
