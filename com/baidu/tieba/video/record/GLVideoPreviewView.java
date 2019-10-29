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
/* loaded from: classes5.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    private static int jDq = 720;
    private static int jDr = TbConfig.HEAD_IMG_SIZE;
    private static boolean jDv;
    protected h jDs;
    private b jDt;
    private com.faceunity.a.d jDu;
    private a jDw;
    private g.a jDx;
    private boolean jDy;
    private com.baidu.tieba.j.h jjG;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void ry(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjG = lVar.bMY();
        }
        this.jDs = hVar;
        this.jDt = new b(context, this, this.jjG);
        setEGLContextClientVersion(2);
        setRenderer(this.jDt);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jDt);
                camera.setPreviewTexture(this.jDt.jDB);
                this.jDt.jDB.setOnFrameAvailableListener(this.jDt);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jjG != null) {
                    this.jjG.av(20, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jDu = new com.faceunity.a.d();
            this.jDt.a(this.jDu);
            jDv = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jjG != null) {
                this.jjG.av(21, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jDu != null) {
                this.jDu.yy();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jjG != null) {
                this.jjG.av(19, com.baidu.tieba.j.a.o(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jDu != null) {
            this.jDu.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jDt.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jjG != null) {
                this.jjG.av(18, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jDt.previewWidth = i;
            this.jDt.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jDq);
            if (round % 2 == 1) {
                round--;
            }
            jDr = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jDx = aVar;
        this.jDy = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jDs == null) {
            return false;
        }
        return this.jDs.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jDt == null) {
            return;
        }
        this.jDt.cuL();
    }

    public void cuH() {
        if (this.jDt == null) {
            return;
        }
        this.jDt.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jDt != null) {
            this.jDt.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jDt != null) {
            this.jDt.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jDt != null) {
            this.jDt.setSticker(stickerItem);
        }
    }

    public void cuI() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jDt != null) {
                    GLVideoPreviewView.this.jDt.cuI();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jDt.jDN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jDs.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c jDA;
        private volatile SurfaceTexture jDB;
        private GLVideoPreviewView jDC;
        private int jDD;
        private Handler jDI;
        private boolean jDJ;
        private boolean jDK;
        com.faceunity.a.d jDL;
        String jDM;
        private boolean jDN;
        private String jDO;
        private com.baidu.tieba.j.h jjG;
        private com.faceunity.gles.c jzs;
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
        private int jzr = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jzr};
        private boolean isNeedEffectItem = true;
        private long jDE = 0;
        private int jDF = 0;
        private long jDG = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jDH = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jDC = gLVideoPreviewView;
            this.jjG = hVar;
            this.jDH.start();
            this.jDI = new a(this.jDH.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.AJ(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cuL() {
            this.jDI.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jDC.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jzs = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jDA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jDD = this.jDA.createTextureObject();
            cuI();
            boolean unused = GLVideoPreviewView.jDv = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jDC.mSurfaceViewWidth = i;
            this.jDC.mSurfaceViewHeight = i2;
        }

        public void cuI() {
            if (this.jDB != null) {
                faceunity.fuOnCameraChange();
                this.jDB.release();
            }
            this.jDB = new SurfaceTexture(this.jDD);
            cuN();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.jwN;
                this.mFacebeautyBlurLevel = aVar.jwO;
                this.mFacebeautyCheeckThin = aVar.jwP;
                this.mFacebeautyEnlargeEye = aVar.jwQ;
                this.mFacebeautyRedLevel = aVar.jwR;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jDN) {
                int i = this.jDF + 1;
                this.jDF = i;
                if (i == 100) {
                    this.jDF = 0;
                    this.jDE = System.currentTimeMillis();
                    this.jDG = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jDB.updateTexImage();
                    this.jDB.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.jjG != null) {
                        this.jjG.av(22, com.baidu.tieba.j.a.o(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jDI.sendEmptyMessage(1);
                }
                if (this.jDC.jDw != null) {
                    this.jDC.jDw.ry(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jDK) {
                    this.jDC.requestRender();
                    return;
                }
                int i2 = (this.jDC.jDs.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jDJ) {
                    faceunity.fuItemSetParam(this.jzr, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jzr, "rotationAngle", cuM() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cuM() ? 270.0d : 90.0d);
                }
                this.jDC.jDs.cuM();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jDD;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jDG = (System.currentTimeMillis() - currentTimeMillis) + this.jDG;
                try {
                    this.jzs.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jDC.jDy) {
                        b(gl10);
                        this.jDC.jDy = false;
                    }
                    if (this.jDL != null && this.jDL.CW(2) && this.jDC.jDs != null) {
                        this.jDM = this.jDC.jDs.cuP();
                        this.jDL.a(new d.b(new File(this.jDM), GLVideoPreviewView.jDq, GLVideoPreviewView.jDr, 2097152, null, this.jDB.getTimestamp()));
                    }
                    if (this.jDL != null && this.jDL.CW(1)) {
                        this.jDL.a(this.jzs, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jDv) {
                            this.jDL.d(this.jDB);
                        }
                        boolean unused = GLVideoPreviewView.jDv = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jDC.g((Camera) null);
                    if (this.jjG != null) {
                        this.jjG.av(23, com.baidu.tieba.j.a.o(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jDL = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jDC.mSurfaceViewWidth;
                int i2 = this.jDC.mSurfaceViewHeight;
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
                if (this.jDC != null && (context = this.jDC.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                L(bitmap);
            }
        }

        private void L(final Bitmap bitmap) {
            this.jDO = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jDC != null && this.jDC.jDx != null) {
                    this.jDC.jDx.z(false, this.jDO);
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
                        b.this.jDO = com.baidu.tbadk.core.util.m.saveFileAsPic(com.baidu.tieba.video.c.jwX, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jDC != null && b.this.jDC.jDx != null) {
                        b.this.jDC.jDx.z(true, b.this.jDO);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean cuM() {
            return this.jDC.jDs.cuM();
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
                                b.this.itemsArray[2] = b.this.jzr = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jDJ) {
                                b.this.jzr = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jzr;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jzr, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jzr, "rotationAngle", b.this.cuM() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jzr = 0;
                                b.this.itemsArray[2] = b.this.jzr;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.cuM() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.jjG != null) {
                                b.this.jjG.av(24, com.baidu.tieba.j.a.o(e));
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
                            b.this.jDK = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.jjG != null) {
                                b.this.jjG.av(25, com.baidu.tieba.j.a.o(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jDK = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.jjG != null) {
                                b.this.jjG.av(26, com.baidu.tieba.j.a.o(e3));
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
            this.jDC.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jzs != null) {
                        b.this.jzs.release(false);
                        b.this.jzs = null;
                    }
                    if (b.this.jDA != null) {
                        b.this.jDA.release(false);
                        b.this.jDA = null;
                    }
                    if (b.this.jDB != null) {
                        b.this.jDB.release();
                        b.this.jDB = null;
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

        private void cuN() {
            if (this.jDC != null) {
                Handler mainHandler = this.jDC.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jzr != 0) {
                    faceunity.fuItemSetParam(this.jzr, "rotationAngle", cuM() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cuM() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jDJ = false;
                } else {
                    this.jDJ = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jDI.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jDw = aVar;
        }
    }
}
