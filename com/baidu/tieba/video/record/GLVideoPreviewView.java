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
    private static int jtK = 720;
    private static int jtL = TbConfig.HEAD_IMG_SIZE;
    private static boolean jtP;
    private com.baidu.tieba.j.h iZT;
    protected h jtM;
    private b jtN;
    private com.faceunity.a.d jtO;
    private a jtQ;
    private g.a jtR;
    private boolean jtS;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void rx(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZT = lVar.bMn();
        }
        this.jtM = hVar;
        this.jtN = new b(context, this, this.iZT);
        setEGLContextClientVersion(2);
        setRenderer(this.jtN);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jtN);
                camera.setPreviewTexture(this.jtN.jtV);
                this.jtN.jtV.setOnFrameAvailableListener(this.jtN);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iZT != null) {
                    this.iZT.av(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jtO = new com.faceunity.a.d();
            this.jtN.a(this.jtO);
            jtP = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iZT != null) {
                this.iZT.av(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jtO != null) {
                this.jtO.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iZT != null) {
                this.iZT.av(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jtO != null) {
            this.jtO.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jtN.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZT != null) {
                this.iZT.av(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jtN.previewWidth = i;
            this.jtN.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jtK);
            if (round % 2 == 1) {
                round--;
            }
            jtL = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jtR = aVar;
        this.jtS = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jtM == null) {
            return false;
        }
        return this.jtM.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jtN == null) {
            return;
        }
        this.jtN.csZ();
    }

    public void csV() {
        if (this.jtN == null) {
            return;
        }
        this.jtN.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jtN != null) {
            this.jtN.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jtN != null) {
            this.jtN.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jtN != null) {
            this.jtN.setSticker(stickerItem);
        }
    }

    public void csW() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jtN != null) {
                    GLVideoPreviewView.this.jtN.csW();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jtN.juh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jtM.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h iZT;
        private com.faceunity.gles.c jpM;
        private com.faceunity.gles.c jtU;
        private volatile SurfaceTexture jtV;
        private GLVideoPreviewView jtW;
        private int jtX;
        private Handler juc;
        private boolean jud;
        private boolean jue;
        com.faceunity.a.d juf;
        String jug;
        private boolean juh;
        private String jui;
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
        private int jpL = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jpL};
        private boolean isNeedEffectItem = true;
        private long jtY = 0;
        private int jtZ = 0;
        private long jua = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jub = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jtW = gLVideoPreviewView;
            this.iZT = hVar;
            this.jub.start();
            this.juc = new a(this.jub.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Bq(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void csZ() {
            this.juc.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jtW.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jpM = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jtU = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jtX = this.jtU.createTextureObject();
            csW();
            boolean unused = GLVideoPreviewView.jtP = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jtW.mSurfaceViewWidth = i;
            this.jtW.mSurfaceViewHeight = i2;
        }

        public void csW() {
            if (this.jtV != null) {
                faceunity.fuOnCameraChange();
                this.jtV.release();
            }
            this.jtV = new SurfaceTexture(this.jtX);
            ctb();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.jnh;
                this.mFacebeautyBlurLevel = aVar.jni;
                this.mFacebeautyCheeckThin = aVar.jnj;
                this.mFacebeautyEnlargeEye = aVar.jnk;
                this.mFacebeautyRedLevel = aVar.jnl;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.juh) {
                int i = this.jtZ + 1;
                this.jtZ = i;
                if (i == 100) {
                    this.jtZ = 0;
                    this.jtY = System.currentTimeMillis();
                    this.jua = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jtV.updateTexImage();
                    this.jtV.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.iZT != null) {
                        this.iZT.av(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.juc.sendEmptyMessage(1);
                }
                if (this.jtW.jtQ != null) {
                    this.jtW.jtQ.rx(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jue) {
                    this.jtW.requestRender();
                    return;
                }
                int i2 = (this.jtW.jtM.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jud) {
                    faceunity.fuItemSetParam(this.jpL, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jpL, "rotationAngle", cta() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cta() ? 270.0d : 90.0d);
                }
                this.jtW.jtM.cta();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jtX;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jua = (System.currentTimeMillis() - currentTimeMillis) + this.jua;
                try {
                    this.jpM.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jtW.jtS) {
                        b(gl10);
                        this.jtW.jtS = false;
                    }
                    if (this.juf != null && this.juf.DN(2) && this.jtW.jtM != null) {
                        this.jug = this.jtW.jtM.ctd();
                        this.juf.a(new d.b(new File(this.jug), GLVideoPreviewView.jtK, GLVideoPreviewView.jtL, 2097152, null, this.jtV.getTimestamp()));
                    }
                    if (this.juf != null && this.juf.DN(1)) {
                        this.juf.a(this.jpM, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jtP) {
                            this.juf.d(this.jtV);
                        }
                        boolean unused = GLVideoPreviewView.jtP = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jtW.g((Camera) null);
                    if (this.iZT != null) {
                        this.iZT.av(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.juf = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jtW.mSurfaceViewWidth;
                int i2 = this.jtW.mSurfaceViewHeight;
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
                if (this.jtW != null && (context = this.jtW.getContext()) != null && (context instanceof Activity)) {
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
            this.jui = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jtW != null && this.jtW.jtR != null) {
                    this.jtW.jtR.y(false, this.jui);
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
                        b.this.jui = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.jnr, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jtW != null && b.this.jtW.jtR != null) {
                        b.this.jtW.jtR.y(true, b.this.jui);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean cta() {
            return this.jtW.jtM.cta();
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
                                b.this.itemsArray[2] = b.this.jpL = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jud) {
                                b.this.jpL = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jpL;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jpL, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jpL, "rotationAngle", b.this.cta() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jpL = 0;
                                b.this.itemsArray[2] = b.this.jpL;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.cta() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.iZT != null) {
                                b.this.iZT.av(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.jue = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.iZT != null) {
                                b.this.iZT.av(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jue = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.iZT != null) {
                                b.this.iZT.av(26, com.baidu.tieba.j.a.p(e3));
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
            this.jtW.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jpM != null) {
                        b.this.jpM.release(false);
                        b.this.jpM = null;
                    }
                    if (b.this.jtU != null) {
                        b.this.jtU.release(false);
                        b.this.jtU = null;
                    }
                    if (b.this.jtV != null) {
                        b.this.jtV.release();
                        b.this.jtV = null;
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

        private void ctb() {
            if (this.jtW != null) {
                Handler mainHandler = this.jtW.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jpL != 0) {
                    faceunity.fuItemSetParam(this.jpL, "rotationAngle", cta() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", cta() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jud = false;
                } else {
                    this.jud = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.juc.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jtQ = aVar;
        }
    }
}
