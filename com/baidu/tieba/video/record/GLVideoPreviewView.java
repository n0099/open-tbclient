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
    private static int lHd = 720;
    private static int lHe = TbConfig.HEAD_IMG_SIZE;
    private static boolean lHi;
    protected h lHf;
    private b lHg;
    private com.faceunity.a.d lHh;
    private a lHj;
    private g.a lHk;
    private boolean lHl;
    private com.baidu.tieba.k.h lnq;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void va(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lnq = lVar.cyS();
        }
        this.lHf = hVar;
        this.lHg = new b(context, this, this.lnq);
        setEGLContextClientVersion(2);
        setRenderer(this.lHg);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.lHg);
                camera.setPreviewTexture(this.lHg.lHo);
                this.lHg.lHo.setOnFrameAvailableListener(this.lHg);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lnq != null) {
                    this.lnq.bj(20, com.baidu.tieba.k.a.t(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.lHh = new com.faceunity.a.d();
            this.lHg.a(this.lHh);
            lHi = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lnq != null) {
                this.lnq.bj(21, com.baidu.tieba.k.a.t(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.lHh != null) {
                this.lHh.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lnq != null) {
                this.lnq.bj(19, com.baidu.tieba.k.a.t(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.lHh != null) {
            this.lHh.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.lHg.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lnq != null) {
                this.lnq.bj(18, com.baidu.tieba.k.a.t(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.lHg.previewWidth = i;
            this.lHg.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * lHd);
            if (round % 2 == 1) {
                round--;
            }
            if (lHe == 960) {
                lHe = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.lHk = aVar;
        this.lHl = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lHf == null) {
            return false;
        }
        return this.lHf.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.lHg == null) {
            return;
        }
        this.lHg.djZ();
    }

    public void djV() {
        if (this.lHg == null) {
            return;
        }
        this.lHg.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.lHg != null) {
            this.lHg.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.lHg != null) {
            this.lHg.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.lHg != null) {
            this.lHg.setSticker(stickerItem);
        }
    }

    public void djW() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.lHg != null) {
                    GLVideoPreviewView.this.lHg.djW();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.lHg.lHA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.lHf.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c lDe;
        private boolean lHA;
        private String lHB;
        private com.faceunity.gles.c lHn;
        private volatile SurfaceTexture lHo;
        private GLVideoPreviewView lHp;
        private int lHq;
        private Handler lHv;
        private boolean lHw;
        private boolean lHx;
        com.faceunity.a.d lHy;
        String lHz;
        private com.baidu.tieba.k.h lnq;
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
        private int lDd = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.lDd};
        private boolean isNeedEffectItem = true;
        private long lHr = 0;
        private int lHs = 0;
        private long lHt = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread lHu = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.lHp = gLVideoPreviewView;
            this.lnq = hVar;
            this.lHu.start();
            this.lHv = new a(this.lHu.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.EO(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void djZ() {
            this.lHv.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.lHp.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.lDe = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.lHn = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.lHq = this.lHn.createTextureObject();
            djW();
            boolean unused = GLVideoPreviewView.lHi = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.lHp.mSurfaceViewWidth = i;
            this.lHp.mSurfaceViewHeight = i2;
        }

        public void djW() {
            if (this.lHo != null) {
                faceunity.fuOnCameraChange();
                this.lHo.release();
            }
            this.lHo = new SurfaceTexture(this.lHq);
            dkb();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.lAH;
                this.mFacebeautyBlurLevel = aVar.lAI;
                this.mFacebeautyCheeckThin = aVar.lAJ;
                this.mFacebeautyEnlargeEye = aVar.lAK;
                this.mFacebeautyRedLevel = aVar.lAL;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.lHA) {
                int i = this.lHs + 1;
                this.lHs = i;
                if (i == 100) {
                    this.lHs = 0;
                    this.lHr = System.currentTimeMillis();
                    this.lHt = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.lHo.updateTexImage();
                    this.lHo.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.lnq != null) {
                        this.lnq.bj(22, com.baidu.tieba.k.a.t(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.lHv.sendEmptyMessage(1);
                }
                if (this.lHp.lHj != null) {
                    this.lHp.lHj.va(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.lHx) {
                    this.lHp.requestRender();
                    return;
                }
                int i2 = (this.lHp.lHf.mCameraId != 1 ? 32 : 0) | 1;
                if (this.lHw) {
                    faceunity.fuItemSetParam(this.lDd, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.lDd, "rotationAngle", dka() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dka() ? 270.0d : 90.0d);
                }
                this.lHp.lHf.dka();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.lHq;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.lHt = (System.currentTimeMillis() - currentTimeMillis) + this.lHt;
                try {
                    this.lDe.drawFrame(fuDualInputToTexture, fArr);
                    if (this.lHp.lHl) {
                        b(gl10);
                        this.lHp.lHl = false;
                    }
                    if (this.lHy != null && this.lHy.Iq(2) && this.lHp.lHf != null) {
                        this.lHz = this.lHp.lHf.dkd();
                        this.lHy.a(new d.b(new File(this.lHz), GLVideoPreviewView.lHd, GLVideoPreviewView.lHe, 2097152, null, this.lHo.getTimestamp()));
                    }
                    if (this.lHy != null && this.lHy.Iq(1)) {
                        this.lHy.a(this.lDe, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.lHi) {
                            this.lHy.f(this.lHo);
                        }
                        boolean unused = GLVideoPreviewView.lHi = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.lHp.g((Camera) null);
                    if (this.lnq != null) {
                        this.lnq.bj(23, com.baidu.tieba.k.a.t(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.lHy = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.lHp.mSurfaceViewWidth;
                int i2 = this.lHp.mSurfaceViewHeight;
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
                if (this.lHp != null && (context = this.lHp.getContext()) != null && (context instanceof Activity)) {
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
            this.lHB = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.lHp != null && this.lHp.lHk != null) {
                    this.lHp.lHk.A(false, this.lHB);
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
                        b.this.lHB = com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.lAR, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.lHp != null && b.this.lHp.lHk != null) {
                        b.this.lHp.lHk.A(true, b.this.lHB);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dka() {
            return this.lHp.lHf.dka();
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
                                b.this.itemsArray[2] = b.this.lDd = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.lHw) {
                                b.this.lDd = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.lDd;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.lDd, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.lDd, "rotationAngle", b.this.dka() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.lDd = 0;
                                b.this.itemsArray[2] = b.this.lDd;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dka() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.lnq != null) {
                                b.this.lnq.bj(24, com.baidu.tieba.k.a.t(e));
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
                            b.this.lHx = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.lnq != null) {
                                b.this.lnq.bj(25, com.baidu.tieba.k.a.t(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.lHx = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.lnq != null) {
                                b.this.lnq.bj(26, com.baidu.tieba.k.a.t(e3));
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
            this.lHp.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.lDe != null) {
                        b.this.lDe.release(false);
                        b.this.lDe = null;
                    }
                    if (b.this.lHn != null) {
                        b.this.lHn.release(false);
                        b.this.lHn = null;
                    }
                    if (b.this.lHo != null) {
                        b.this.lHo.release();
                        b.this.lHo = null;
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

        private void dkb() {
            if (this.lHp != null) {
                Handler mainHandler = this.lHp.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.lDd != 0) {
                    faceunity.fuItemSetParam(this.lDd, "rotationAngle", dka() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dka() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.lHw = false;
                } else {
                    this.lHw = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.lHv.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.lHj = aVar;
        }
    }
}
