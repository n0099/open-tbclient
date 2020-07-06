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
    private static int maX = 720;
    private static int maY = TbConfig.HEAD_IMG_SIZE;
    private static boolean mbc;
    private com.baidu.tieba.k.h lHf;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h maZ;
    private b mba;
    private com.faceunity.a.d mbb;
    private a mbd;
    private g.a mbe;
    private boolean mbf;

    /* loaded from: classes10.dex */
    public interface a {
        void vs(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCQ();
        }
        this.maZ = hVar;
        this.mba = new b(context, this, this.lHf);
        setEGLContextClientVersion(2);
        setRenderer(this.mba);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.mba);
                camera.setPreviewTexture(this.mba.mbi);
                this.mba.mbi.setOnFrameAvailableListener(this.mba);
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
            this.mbb = new com.faceunity.a.d();
            this.mba.a(this.mbb);
            mbc = false;
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
            if (this.mbb != null) {
                this.mbb.stopRecording();
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
        if (this.mbb != null) {
            this.mbb.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.mba.releaseResource();
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
            this.mba.previewWidth = i;
            this.mba.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * maX);
            if (round % 2 == 1) {
                round--;
            }
            if (maY == 960) {
                maY = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mbe = aVar;
        this.mbf = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.maZ == null) {
            return false;
        }
        return this.maZ.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.mba == null) {
            return;
        }
        this.mba.dop();
    }

    public void dol() {
        if (this.mba == null) {
            return;
        }
        this.mba.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.mba != null) {
            this.mba.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.mba != null) {
            this.mba.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.mba != null) {
            this.mba.setSticker(stickerItem);
        }
    }

    public void dom() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.mba != null) {
                    GLVideoPreviewView.this.mba.dom();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.mba.mbu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.maZ.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.k.h lHf;
        private com.faceunity.gles.c lWQ;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c mbh;
        private volatile SurfaceTexture mbi;
        private GLVideoPreviewView mbj;
        private int mbk;
        private Handler mbp;
        private boolean mbq;
        private boolean mbr;
        com.faceunity.a.d mbs;
        String mbt;
        private boolean mbu;
        private String mbv;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int lWP = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.lWP};
        private boolean isNeedEffectItem = true;
        private long mbl = 0;
        private int mbm = 0;
        private long mbn = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread mbo = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.mbj = gLVideoPreviewView;
            this.lHf = hVar;
            this.mbo.start();
            this.mbp = new a(this.mbo.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.FQ(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dop() {
            this.mbp.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.mbj.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.lWQ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.mbh = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mbk = this.mbh.createTextureObject();
            dom();
            boolean unused = GLVideoPreviewView.mbc = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.mbj.mSurfaceViewWidth = i;
            this.mbj.mSurfaceViewHeight = i2;
        }

        public void dom() {
            if (this.mbi != null) {
                faceunity.fuOnCameraChange();
                this.mbi.release();
            }
            this.mbi = new SurfaceTexture(this.mbk);
            dor();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.lUp;
                this.mFacebeautyBlurLevel = aVar.lUq;
                this.mFacebeautyCheeckThin = aVar.lUr;
                this.mFacebeautyEnlargeEye = aVar.lUs;
                this.mFacebeautyRedLevel = aVar.lUt;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.mbu) {
                int i = this.mbm + 1;
                this.mbm = i;
                if (i == 100) {
                    this.mbm = 0;
                    this.mbl = System.currentTimeMillis();
                    this.mbn = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.mbi.updateTexImage();
                    this.mbi.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.lHf != null) {
                        this.lHf.bn(22, com.baidu.tieba.k.a.t(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.mbp.sendEmptyMessage(1);
                }
                if (this.mbj.mbd != null) {
                    this.mbj.mbd.vs(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.mbr) {
                    this.mbj.requestRender();
                    return;
                }
                int i2 = (this.mbj.maZ.mCameraId != 1 ? 32 : 0) | 1;
                if (this.mbq) {
                    faceunity.fuItemSetParam(this.lWP, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.lWP, "rotationAngle", doq() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", doq() ? 270.0d : 90.0d);
                }
                this.mbj.maZ.doq();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.mbk;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.mbn = (System.currentTimeMillis() - currentTimeMillis) + this.mbn;
                try {
                    this.lWQ.drawFrame(fuDualInputToTexture, fArr);
                    if (this.mbj.mbf) {
                        b(gl10);
                        this.mbj.mbf = false;
                    }
                    if (this.mbs != null && this.mbs.Jx(2) && this.mbj.maZ != null) {
                        this.mbt = this.mbj.maZ.dot();
                        this.mbs.a(new d.b(new File(this.mbt), GLVideoPreviewView.maX, GLVideoPreviewView.maY, 2097152, null, this.mbi.getTimestamp()));
                    }
                    if (this.mbs != null && this.mbs.Jx(1)) {
                        this.mbs.a(this.lWQ, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.mbc) {
                            this.mbs.f(this.mbi);
                        }
                        boolean unused = GLVideoPreviewView.mbc = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.mbj.g((Camera) null);
                    if (this.lHf != null) {
                        this.lHf.bn(23, com.baidu.tieba.k.a.t(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.mbs = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.mbj.mSurfaceViewWidth;
                int i2 = this.mbj.mSurfaceViewHeight;
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
                if (this.mbj != null && (context = this.mbj.getContext()) != null && (context instanceof Activity)) {
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
            this.mbv = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.mbj != null && this.mbj.mbe != null) {
                    this.mbj.mbe.C(false, this.mbv);
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
                        b.this.mbv = n.saveFileAsPic(com.baidu.tieba.video.d.lUA, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.mbj != null && b.this.mbj.mbe != null) {
                        b.this.mbj.mbe.C(true, b.this.mbv);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean doq() {
            return this.mbj.maZ.doq();
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
                                b.this.itemsArray[2] = b.this.lWP = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.mbq) {
                                b.this.lWP = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.lWP;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.lWP, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.lWP, "rotationAngle", b.this.doq() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.lWP = 0;
                                b.this.itemsArray[2] = b.this.lWP;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.doq() ? 270.0d : 90.0d);
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
                            b.this.mbr = true;
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
                            b.this.mbr = true;
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
            this.mbj.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.lWQ != null) {
                        b.this.lWQ.release(false);
                        b.this.lWQ = null;
                    }
                    if (b.this.mbh != null) {
                        b.this.mbh.release(false);
                        b.this.mbh = null;
                    }
                    if (b.this.mbi != null) {
                        b.this.mbi.release();
                        b.this.mbi = null;
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

        private void dor() {
            if (this.mbj != null) {
                Handler mainHandler = this.mbj.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.lWP != 0) {
                    faceunity.fuItemSetParam(this.lWP, "rotationAngle", doq() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", doq() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.mbq = false;
                } else {
                    this.mbq = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.mbp.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.mbd = aVar;
        }
    }
}
