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
    private static int hxo = 720;
    private static int hxp = TbConfig.HEAD_IMG_SIZE;
    private static boolean hxt;
    private com.baidu.tieba.j.h heb;
    protected h hxq;
    private b hxr;
    private com.faceunity.a.d hxs;
    private a hxu;
    private int hxv;
    private int hxw;
    private g.a hxx;
    private boolean hxy;

    /* loaded from: classes5.dex */
    public interface a {
        void nO(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.heb = lVar.bbw();
        }
        this.hxq = hVar;
        this.hxr = new b(context, this, this.heb);
        setEGLContextClientVersion(2);
        setRenderer(this.hxr);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hxr);
                camera.setPreviewTexture(this.hxr.hxB);
                this.hxr.hxB.setOnFrameAvailableListener(this.hxr);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.heb != null) {
                    this.heb.ab(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.hxs = new com.faceunity.a.d();
            this.hxr.a(this.hxs);
            hxt = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.heb != null) {
                this.heb.ab(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.hxs != null) {
                this.hxs.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.heb != null) {
                this.heb.ab(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hxs != null) {
            this.hxs.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.hxr.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.heb != null) {
                this.heb.ab(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hxr.drR = i;
            this.hxr.drS = i2;
            hxp = (int) (((i * 1.0f) / i2) * hxo);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.hxx = aVar;
        this.hxy = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hxq == null) {
            return false;
        }
        return this.hxq.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hxr == null) {
            return;
        }
        this.hxr.bIt();
    }

    public void bIp() {
        if (this.hxr == null) {
            return;
        }
        this.hxr.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hxr != null) {
            this.hxr.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hxr != null) {
            this.hxr.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hxr != null) {
            this.hxr.setSticker(stickerItem);
        }
    }

    public void bIq() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.hxr != null) {
                    GLVideoPreviewView.this.hxr.bIq();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hxr.hxL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hxq.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h heb;
        private com.faceunity.gles.c htl;
        private com.faceunity.gles.c hxA;
        private volatile SurfaceTexture hxB;
        private GLVideoPreviewView hxC;
        private int hxD;
        private Handler hxG;
        private boolean hxH;
        private boolean hxI;
        com.faceunity.a.d hxJ;
        String hxK;
        private boolean hxL;
        private String hxM;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int drR = 720;
        protected int drS = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int htk = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.htk};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hxE = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hxF = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.hxC = gLVideoPreviewView;
            this.heb = hVar;
            this.hxF.start();
            this.hxG = new a(this.hxF.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.vu(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bIt() {
            this.hxG.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hxC.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.htl = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hxA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hxD = this.hxA.createTextureObject();
            bIq();
            boolean unused = GLVideoPreviewView.hxt = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hxC.hxv = i;
            this.hxC.hxw = i2;
        }

        public void bIq() {
            if (this.hxB != null) {
                faceunity.fuOnCameraChange();
                this.hxB.release();
            }
            this.hxB = new SurfaceTexture(this.hxD);
            bIv();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hqG;
                this.mFacebeautyBlurLevel = aVar.hqH;
                this.mFacebeautyCheeckThin = aVar.hqI;
                this.mFacebeautyEnlargeEye = aVar.hqJ;
                this.mFacebeautyRedLevel = aVar.hqK;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hxL) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hxE = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hxB.updateTexImage();
                    this.hxB.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.heb != null) {
                        this.heb.ab(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hxG.sendEmptyMessage(1);
                }
                if (this.hxC.hxu != null) {
                    this.hxC.hxu.nO(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hxI) {
                    this.hxC.requestRender();
                    return;
                }
                int i2 = (this.hxC.hxq.mCameraId != 1 ? 32 : 0) | 1;
                if (this.hxH) {
                    faceunity.fuItemSetParam(this.htk, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.htk, "rotationAngle", bIu() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bIu() ? 270.0d : 90.0d);
                }
                this.hxC.hxq.bIu();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hxD;
                int i4 = this.drR;
                int i5 = this.drS;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.hxE = (System.currentTimeMillis() - currentTimeMillis) + this.hxE;
                try {
                    this.htl.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hxC.hxy) {
                        c(gl10);
                        this.hxC.hxy = false;
                    }
                    if (this.hxJ != null && this.hxJ.yb(2) && this.hxC.hxq != null) {
                        this.hxK = this.hxC.hxq.bIx();
                        this.hxJ.a(new d.b(new File(this.hxK), GLVideoPreviewView.hxo, GLVideoPreviewView.hxp, 2097152, null, this.hxB.getTimestamp()));
                    }
                    if (this.hxJ != null && this.hxJ.yb(1)) {
                        this.hxJ.a(this.htl, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.hxt) {
                            this.hxJ.e(this.hxB);
                        }
                        boolean unused = GLVideoPreviewView.hxt = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hxC.g((Camera) null);
                    if (this.heb != null) {
                        this.heb.ab(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hxJ = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hxC.hxv;
                int i2 = this.hxC.hxw;
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
                if (this.hxC != null && (context = this.hxC.getContext()) != null && (context instanceof Activity)) {
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
            this.hxM = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hxC != null && this.hxC.hxx != null) {
                    this.hxC.hxx.u(false, this.hxM);
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
                        b.this.hxM = com.baidu.tbadk.core.util.l.a(com.baidu.tieba.video.c.hqQ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hxC != null && b.this.hxC.hxx != null) {
                        b.this.hxC.hxx.u(true, b.this.hxM);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean bIu() {
            return this.hxC.hxq.bIu();
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
                                b.this.itemsArray[2] = b.this.htk = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hxH) {
                                b.this.htk = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.htk;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.htk, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.htk, "rotationAngle", b.this.bIu() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.htk = 0;
                                b.this.itemsArray[2] = b.this.htk;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.bIu() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.heb != null) {
                                b.this.heb.ab(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.hxI = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.heb != null) {
                                b.this.heb.ab(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hxI = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.heb != null) {
                                b.this.heb.ab(26, com.baidu.tieba.j.a.o(e3));
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
            this.hxC.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.htl != null) {
                        b.this.htl.release(false);
                        b.this.htl = null;
                    }
                    if (b.this.hxA != null) {
                        b.this.hxA.release(false);
                        b.this.hxA = null;
                    }
                    if (b.this.hxB != null) {
                        b.this.hxB.release();
                        b.this.hxB = null;
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

        private void bIv() {
            if (this.hxC != null) {
                Handler mainHandler = this.hxC.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.htk != 0) {
                    faceunity.fuItemSetParam(this.htk, "rotationAngle", bIu() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", bIu() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hxH = false;
                } else {
                    this.hxH = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hxG.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hxu = aVar;
        }
    }
}
