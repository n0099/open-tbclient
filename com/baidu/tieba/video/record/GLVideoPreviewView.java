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
    private static boolean jDD;
    private static int jDy = 720;
    private static int jDz = TbConfig.HEAD_IMG_SIZE;
    protected h jDA;
    private b jDB;
    private com.faceunity.a.d jDC;
    private a jDE;
    private g.a jDF;
    private boolean jDG;
    private com.baidu.tieba.j.h jjR;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void rP(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        this.jDA = hVar;
        this.jDB = new b(context, this, this.jjR);
        setEGLContextClientVersion(2);
        setRenderer(this.jDB);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jDB);
                camera.setPreviewTexture(this.jDB.jDJ);
                this.jDB.jDJ.setOnFrameAvailableListener(this.jDB);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jjR != null) {
                    this.jjR.av(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jDC = new com.faceunity.a.d();
            this.jDB.a(this.jDC);
            jDD = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jjR != null) {
                this.jjR.av(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jDC != null) {
                this.jDC.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.jjR != null) {
                this.jjR.av(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jDC != null) {
            this.jDC.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jDB.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jjR != null) {
                this.jjR.av(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jDB.previewWidth = i;
            this.jDB.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jDy);
            if (round % 2 == 1) {
                round--;
            }
            jDz = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jDF = aVar;
        this.jDG = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jDA == null) {
            return false;
        }
        return this.jDA.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jDB == null) {
            return;
        }
        this.jDB.cwX();
    }

    public void cwT() {
        if (this.jDB == null) {
            return;
        }
        this.jDB.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jDB != null) {
            this.jDB.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jDB != null) {
            this.jDB.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jDB != null) {
            this.jDB.setSticker(stickerItem);
        }
    }

    public void cwU() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jDB != null) {
                    GLVideoPreviewView.this.jDB.cwU();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jDB.jDV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jDA.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c jDI;
        private volatile SurfaceTexture jDJ;
        private GLVideoPreviewView jDK;
        private int jDL;
        private Handler jDQ;
        private boolean jDR;
        private boolean jDS;
        com.faceunity.a.d jDT;
        String jDU;
        private boolean jDV;
        private String jDW;
        private com.baidu.tieba.j.h jjR;
        private com.faceunity.gles.c jzA;
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
        private int jzz = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jzz};
        private boolean isNeedEffectItem = true;
        private long jDM = 0;
        private int jDN = 0;
        private long jDO = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jDP = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jDK = gLVideoPreviewView;
            this.jjR = hVar;
            this.jDP.start();
            this.jDQ = new a(this.jDP.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Cd(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cwX() {
            this.jDQ.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jDK.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jzA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jDI = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jDL = this.jDI.createTextureObject();
            cwU();
            boolean unused = GLVideoPreviewView.jDD = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jDK.mSurfaceViewWidth = i;
            this.jDK.mSurfaceViewHeight = i2;
        }

        public void cwU() {
            if (this.jDJ != null) {
                faceunity.fuOnCameraChange();
                this.jDJ.release();
            }
            this.jDJ = new SurfaceTexture(this.jDL);
            cwZ();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.jwV;
                this.mFacebeautyBlurLevel = aVar.jwW;
                this.mFacebeautyCheeckThin = aVar.jwX;
                this.mFacebeautyEnlargeEye = aVar.jwY;
                this.mFacebeautyRedLevel = aVar.jwZ;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jDV) {
                int i = this.jDN + 1;
                this.jDN = i;
                if (i == 100) {
                    this.jDN = 0;
                    this.jDM = System.currentTimeMillis();
                    this.jDO = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jDJ.updateTexImage();
                    this.jDJ.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.jjR != null) {
                        this.jjR.av(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jDQ.sendEmptyMessage(1);
                }
                if (this.jDK.jDE != null) {
                    this.jDK.jDE.rP(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jDS) {
                    this.jDK.requestRender();
                    return;
                }
                int i2 = (this.jDK.jDA.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jDR) {
                    faceunity.fuItemSetParam(this.jzz, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jzz, "rotationAngle", cwY() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cwY() ? 270.0d : 90.0d);
                }
                this.jDK.jDA.cwY();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jDL;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jDO = (System.currentTimeMillis() - currentTimeMillis) + this.jDO;
                try {
                    this.jzA.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jDK.jDG) {
                        b(gl10);
                        this.jDK.jDG = false;
                    }
                    if (this.jDT != null && this.jDT.EA(2) && this.jDK.jDA != null) {
                        this.jDU = this.jDK.jDA.cxb();
                        this.jDT.a(new d.b(new File(this.jDU), GLVideoPreviewView.jDy, GLVideoPreviewView.jDz, 2097152, null, this.jDJ.getTimestamp()));
                    }
                    if (this.jDT != null && this.jDT.EA(1)) {
                        this.jDT.a(this.jzA, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jDD) {
                            this.jDT.d(this.jDJ);
                        }
                        boolean unused = GLVideoPreviewView.jDD = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jDK.g((Camera) null);
                    if (this.jjR != null) {
                        this.jjR.av(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jDT = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jDK.mSurfaceViewWidth;
                int i2 = this.jDK.mSurfaceViewHeight;
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
                if (this.jDK != null && (context = this.jDK.getContext()) != null && (context instanceof Activity)) {
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
            this.jDW = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jDK != null && this.jDK.jDF != null) {
                    this.jDK.jDF.z(false, this.jDW);
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
                        b.this.jDW = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.jxf, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jDK != null && b.this.jDK.jDF != null) {
                        b.this.jDK.jDF.z(true, b.this.jDW);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean cwY() {
            return this.jDK.jDA.cwY();
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
                                b.this.itemsArray[2] = b.this.jzz = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jDR) {
                                b.this.jzz = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jzz;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jzz, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jzz, "rotationAngle", b.this.cwY() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jzz = 0;
                                b.this.itemsArray[2] = b.this.jzz;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.cwY() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.jjR != null) {
                                b.this.jjR.av(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.jDS = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.jjR != null) {
                                b.this.jjR.av(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jDS = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.jjR != null) {
                                b.this.jjR.av(26, com.baidu.tieba.j.a.p(e3));
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
            this.jDK.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jzA != null) {
                        b.this.jzA.release(false);
                        b.this.jzA = null;
                    }
                    if (b.this.jDI != null) {
                        b.this.jDI.release(false);
                        b.this.jDI = null;
                    }
                    if (b.this.jDJ != null) {
                        b.this.jDJ.release();
                        b.this.jDJ = null;
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

        private void cwZ() {
            if (this.jDK != null) {
                Handler mainHandler = this.jDK.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jzz != 0) {
                    faceunity.fuItemSetParam(this.jzz, "rotationAngle", cwY() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cwY() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jDR = false;
                } else {
                    this.jDR = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jDQ.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jDE = aVar;
        }
    }
}
