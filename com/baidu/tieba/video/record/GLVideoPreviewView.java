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
    private static int mip = 720;
    private static int miq = TbConfig.HEAD_IMG_SIZE;
    private static boolean miu;
    private com.baidu.tieba.k.h lOv;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    protected h mir;
    private b mis;
    private com.faceunity.a.d mit;
    private a miv;
    private g.a miw;
    private boolean mix;

    /* loaded from: classes17.dex */
    public interface a {
        void vW(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lOv = lVar.cGE();
        }
        this.mir = hVar;
        this.mis = new b(context, this, this.lOv);
        setEGLContextClientVersion(2);
        setRenderer(this.mis);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.mis);
                camera.setPreviewTexture(this.mis.miA);
                this.mis.miA.setOnFrameAvailableListener(this.mis);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lOv != null) {
                    this.lOv.bp(20, com.baidu.tieba.k.a.s(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.mit = new com.faceunity.a.d();
            this.mis.a(this.mit);
            miu = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lOv != null) {
                this.lOv.bp(21, com.baidu.tieba.k.a.s(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.mit != null) {
                this.mit.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.lOv != null) {
                this.lOv.bp(19, com.baidu.tieba.k.a.s(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.mit != null) {
            this.mit.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.mis.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lOv != null) {
                this.lOv.bp(18, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mis.previewWidth = i;
            this.mis.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * mip);
            if (round % 2 == 1) {
                round--;
            }
            if (miq == 960) {
                miq = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.miw = aVar;
        this.mix = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mir == null) {
            return false;
        }
        return this.mir.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.mis == null) {
            return;
        }
        this.mis.drz();
    }

    public void drv() {
        if (this.mis == null) {
            return;
        }
        this.mis.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.mis != null) {
            this.mis.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.mis != null) {
            this.mis.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.mis != null) {
            this.mis.setSticker(stickerItem);
        }
    }

    public void drw() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.mis != null) {
                    GLVideoPreviewView.this.mis.drw();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.mis.miM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.mir.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.k.h lOv;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.faceunity.gles.c mei;
        private volatile SurfaceTexture miA;
        private GLVideoPreviewView miB;
        private int miC;
        private Handler miH;
        private boolean miI;
        private boolean miJ;
        com.faceunity.a.d miK;
        String miL;
        private boolean miM;
        private String miN;
        private com.faceunity.gles.c miz;
        protected int previewWidth = 720;
        protected int previewHeight = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int meh = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.meh};
        private boolean isNeedEffectItem = true;
        private long miD = 0;
        private int miE = 0;
        private long miF = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread miG = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.miB = gLVideoPreviewView;
            this.lOv = hVar;
            this.miG.start();
            this.miH = new a(this.miG.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Gm(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drz() {
            this.miH.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.miB.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.mei = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.miz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.miC = this.miz.createTextureObject();
            drw();
            boolean unused = GLVideoPreviewView.miu = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.miB.mSurfaceViewWidth = i;
            this.miB.mSurfaceViewHeight = i2;
        }

        public void drw() {
            if (this.miA != null) {
                faceunity.fuOnCameraChange();
                this.miA.release();
            }
            this.miA = new SurfaceTexture(this.miC);
            drB();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.mbH;
                this.mFacebeautyBlurLevel = aVar.mbI;
                this.mFacebeautyCheeckThin = aVar.mbJ;
                this.mFacebeautyEnlargeEye = aVar.mbK;
                this.mFacebeautyRedLevel = aVar.mbL;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.miM) {
                int i = this.miE + 1;
                this.miE = i;
                if (i == 100) {
                    this.miE = 0;
                    this.miD = System.currentTimeMillis();
                    this.miF = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.miA.updateTexImage();
                    this.miA.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.lOv != null) {
                        this.lOv.bp(22, com.baidu.tieba.k.a.s(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.miH.sendEmptyMessage(1);
                }
                if (this.miB.miv != null) {
                    this.miB.miv.vW(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.miJ) {
                    this.miB.requestRender();
                    return;
                }
                int i2 = (this.miB.mir.mCameraId != 1 ? 32 : 0) | 1;
                if (this.miI) {
                    faceunity.fuItemSetParam(this.meh, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.meh, "rotationAngle", drA() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", drA() ? 270.0d : 90.0d);
                }
                this.miB.mir.drA();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.miC;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.miF = (System.currentTimeMillis() - currentTimeMillis) + this.miF;
                try {
                    this.mei.drawFrame(fuDualInputToTexture, fArr);
                    if (this.miB.mix) {
                        b(gl10);
                        this.miB.mix = false;
                    }
                    if (this.miK != null && this.miK.JS(2) && this.miB.mir != null) {
                        this.miL = this.miB.mir.drD();
                        this.miK.a(new d.b(new File(this.miL), GLVideoPreviewView.mip, GLVideoPreviewView.miq, 2097152, null, this.miA.getTimestamp()));
                    }
                    if (this.miK != null && this.miK.JS(1)) {
                        this.miK.a(this.mei, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.miu) {
                            this.miK.e(this.miA);
                        }
                        boolean unused = GLVideoPreviewView.miu = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.miB.g((Camera) null);
                    if (this.lOv != null) {
                        this.lOv.bp(23, com.baidu.tieba.k.a.s(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.miK = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.miB.mSurfaceViewWidth;
                int i2 = this.miB.mSurfaceViewHeight;
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
                if (this.miB != null && (context = this.miB.getContext()) != null && (context instanceof Activity)) {
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
            this.miN = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.miB != null && this.miB.miw != null) {
                    this.miB.miw.C(false, this.miN);
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
                        b.this.miN = n.saveFileAsPic(com.baidu.tieba.video.c.mbS, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.miB != null && b.this.miB.miw != null) {
                        b.this.miB.miw.C(true, b.this.miN);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean drA() {
            return this.miB.mir.drA();
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
                                b.this.itemsArray[2] = b.this.meh = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.miI) {
                                b.this.meh = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.meh;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.meh, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.meh, "rotationAngle", b.this.drA() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.meh = 0;
                                b.this.itemsArray[2] = b.this.meh;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.drA() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.lOv != null) {
                                b.this.lOv.bp(24, com.baidu.tieba.k.a.s(e));
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
                            b.this.miJ = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.lOv != null) {
                                b.this.lOv.bp(25, com.baidu.tieba.k.a.s(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.miJ = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.lOv != null) {
                                b.this.lOv.bp(26, com.baidu.tieba.k.a.s(e3));
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
            this.miB.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mei != null) {
                        b.this.mei.release(false);
                        b.this.mei = null;
                    }
                    if (b.this.miz != null) {
                        b.this.miz.release(false);
                        b.this.miz = null;
                    }
                    if (b.this.miA != null) {
                        b.this.miA.release();
                        b.this.miA = null;
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

        private void drB() {
            if (this.miB != null) {
                Handler mainHandler = this.miB.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.meh != 0) {
                    faceunity.fuItemSetParam(this.meh, "rotationAngle", drA() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", drA() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.miI = false;
                } else {
                    this.miI = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.miH.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.miv = aVar;
        }
    }
}
