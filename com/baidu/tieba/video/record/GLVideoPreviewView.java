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
/* loaded from: classes17.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int mim = 720;
    private static int mio = TbConfig.HEAD_IMG_SIZE;
    private static boolean mis;
    private com.baidu.tieba.k.h lOt;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h mip;
    private b miq;
    private com.faceunity.a.d mir;
    private a mit;
    private g.a miu;
    private boolean miv;

    /* loaded from: classes17.dex */
    public interface a {
        void vW(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lOt = lVar.cGE();
        }
        this.mip = hVar;
        this.miq = new b(context, this, this.lOt);
        setEGLContextClientVersion(2);
        setRenderer(this.miq);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.miq);
                camera.setPreviewTexture(this.miq.miy);
                this.miq.miy.setOnFrameAvailableListener(this.miq);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lOt != null) {
                    this.lOt.bp(20, com.baidu.tieba.k.a.s(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.mir = new com.faceunity.a.d();
            this.miq.a(this.mir);
            mis = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lOt != null) {
                this.lOt.bp(21, com.baidu.tieba.k.a.s(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.mir != null) {
                this.mir.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lOt != null) {
                this.lOt.bp(19, com.baidu.tieba.k.a.s(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.mir != null) {
            this.mir.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.miq.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lOt != null) {
                this.lOt.bp(18, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.miq.previewWidth = i;
            this.miq.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * mim);
            if (round % 2 == 1) {
                round--;
            }
            if (mio == 960) {
                mio = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.miu = aVar;
        this.miv = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mip == null) {
            return false;
        }
        return this.mip.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.miq == null) {
            return;
        }
        this.miq.dry();
    }

    public void dru() {
        if (this.miq == null) {
            return;
        }
        this.miq.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.miq != null) {
            this.miq.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.miq != null) {
            this.miq.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.miq != null) {
            this.miq.setSticker(stickerItem);
        }
    }

    public void drv() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.miq != null) {
                    GLVideoPreviewView.this.miq.drv();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.miq.miK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.mip.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.k.h lOt;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c meg;
        private int miA;
        private Handler miF;
        private boolean miG;
        private boolean miH;
        com.faceunity.a.d miI;
        String miJ;
        private boolean miK;
        private String miL;
        private com.faceunity.gles.c mix;
        private volatile SurfaceTexture miy;
        private GLVideoPreviewView miz;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int mef = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.mef};
        private boolean isNeedEffectItem = true;
        private long miB = 0;
        private int miC = 0;
        private long miD = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread miE = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.miz = gLVideoPreviewView;
            this.lOt = hVar;
            this.miE.start();
            this.miF = new a(this.miE.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Gm(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dry() {
            this.miF.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.miz.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.meg = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.mix = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.miA = this.mix.createTextureObject();
            drv();
            boolean unused = GLVideoPreviewView.mis = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.miz.mSurfaceViewWidth = i;
            this.miz.mSurfaceViewHeight = i2;
        }

        public void drv() {
            if (this.miy != null) {
                faceunity.fuOnCameraChange();
                this.miy.release();
            }
            this.miy = new SurfaceTexture(this.miA);
            drA();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.mbF;
                this.mFacebeautyBlurLevel = aVar.mbG;
                this.mFacebeautyCheeckThin = aVar.mbH;
                this.mFacebeautyEnlargeEye = aVar.mbI;
                this.mFacebeautyRedLevel = aVar.mbJ;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.miK) {
                int i = this.miC + 1;
                this.miC = i;
                if (i == 100) {
                    this.miC = 0;
                    this.miB = System.currentTimeMillis();
                    this.miD = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.miy.updateTexImage();
                    this.miy.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.lOt != null) {
                        this.lOt.bp(22, com.baidu.tieba.k.a.s(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.miF.sendEmptyMessage(1);
                }
                if (this.miz.mit != null) {
                    this.miz.mit.vW(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.miH) {
                    this.miz.requestRender();
                    return;
                }
                int i2 = (this.miz.mip.mCameraId != 1 ? 32 : 0) | 1;
                if (this.miG) {
                    faceunity.fuItemSetParam(this.mef, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mef, "rotationAngle", drz() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", drz() ? 270.0d : 90.0d);
                }
                this.miz.mip.drz();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.miA;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.miD = (System.currentTimeMillis() - currentTimeMillis) + this.miD;
                try {
                    this.meg.drawFrame(fuDualInputToTexture, fArr);
                    if (this.miz.miv) {
                        b(gl10);
                        this.miz.miv = false;
                    }
                    if (this.miI != null && this.miI.JS(2) && this.miz.mip != null) {
                        this.miJ = this.miz.mip.drC();
                        this.miI.a(new d.b(new File(this.miJ), GLVideoPreviewView.mim, GLVideoPreviewView.mio, 2097152, null, this.miy.getTimestamp()));
                    }
                    if (this.miI != null && this.miI.JS(1)) {
                        this.miI.a(this.meg, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.mis) {
                            this.miI.e(this.miy);
                        }
                        boolean unused = GLVideoPreviewView.mis = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.miz.g((Camera) null);
                    if (this.lOt != null) {
                        this.lOt.bp(23, com.baidu.tieba.k.a.s(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.miI = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.miz.mSurfaceViewWidth;
                int i2 = this.miz.mSurfaceViewHeight;
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
                if (this.miz != null && (context = this.miz.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                T(bitmap);
            }
        }

        private void T(final Bitmap bitmap) {
            this.miL = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.miz != null && this.miz.miu != null) {
                    this.miz.miu.C(false, this.miL);
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
                        b.this.miL = n.saveFileAsPic(com.baidu.tieba.video.c.mbQ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.miz != null && b.this.miz.miu != null) {
                        b.this.miz.miu.C(true, b.this.miL);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean drz() {
            return this.miz.mip.drz();
        }

        /* loaded from: classes17.dex */
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
                                b.this.itemsArray[2] = b.this.mef = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.miG) {
                                b.this.mef = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.mef;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.mef, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mef, "rotationAngle", b.this.drz() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.mef = 0;
                                b.this.itemsArray[2] = b.this.mef;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.drz() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.lOt != null) {
                                b.this.lOt.bp(24, com.baidu.tieba.k.a.s(e));
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
                            b.this.miH = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.lOt != null) {
                                b.this.lOt.bp(25, com.baidu.tieba.k.a.s(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.miH = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.lOt != null) {
                                b.this.lOt.bp(26, com.baidu.tieba.k.a.s(e3));
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
            this.miz.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.meg != null) {
                        b.this.meg.release(false);
                        b.this.meg = null;
                    }
                    if (b.this.mix != null) {
                        b.this.mix.release(false);
                        b.this.mix = null;
                    }
                    if (b.this.miy != null) {
                        b.this.miy.release();
                        b.this.miy = null;
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

        private void drA() {
            if (this.miz != null) {
                Handler mainHandler = this.miz.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.mef != 0) {
                    faceunity.fuItemSetParam(this.mef, "rotationAngle", drz() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", drz() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.miG = false;
                } else {
                    this.miG = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.miF.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.mit = aVar;
        }
    }
}
