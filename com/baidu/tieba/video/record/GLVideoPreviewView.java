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
    private static int jtN = 720;
    private static int jtO = TbConfig.HEAD_IMG_SIZE;
    private static boolean jtS;
    private com.baidu.tieba.j.h iZX;
    protected h jtP;
    private b jtQ;
    private com.faceunity.a.d jtR;
    private a jtT;
    private g.a jtU;
    private boolean jtV;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void ry(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZX = lVar.bMo();
        }
        this.jtP = hVar;
        this.jtQ = new b(context, this, this.iZX);
        setEGLContextClientVersion(2);
        setRenderer(this.jtQ);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jtQ);
                camera.setPreviewTexture(this.jtQ.jtY);
                this.jtQ.jtY.setOnFrameAvailableListener(this.jtQ);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iZX != null) {
                    this.iZX.av(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jtR = new com.faceunity.a.d();
            this.jtQ.a(this.jtR);
            jtS = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iZX != null) {
                this.iZX.av(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jtR != null) {
                this.jtR.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iZX != null) {
                this.iZX.av(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jtR != null) {
            this.jtR.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jtQ.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iZX != null) {
                this.iZX.av(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jtQ.previewWidth = i;
            this.jtQ.previewHeight = i2;
            int round = Math.round(((i * 1.0f) / i2) * jtN);
            if (round % 2 == 1) {
                round--;
            }
            jtO = round;
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jtU = aVar;
        this.jtV = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jtP == null) {
            return false;
        }
        return this.jtP.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jtQ == null) {
            return;
        }
        this.jtQ.csY();
    }

    public void csU() {
        if (this.jtQ == null) {
            return;
        }
        this.jtQ.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jtQ != null) {
            this.jtQ.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jtQ != null) {
            this.jtQ.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jtQ != null) {
            this.jtQ.setSticker(stickerItem);
        }
    }

    public void csV() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jtQ != null) {
                    GLVideoPreviewView.this.jtQ.csV();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jtQ.juk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jtP.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h iZX;
        private com.faceunity.gles.c jpP;
        private com.faceunity.gles.c jtX;
        private volatile SurfaceTexture jtY;
        private GLVideoPreviewView jtZ;
        private int jua;
        private Handler juf;
        private boolean jug;
        private boolean juh;
        com.faceunity.a.d jui;
        String juj;
        private boolean juk;
        private String jul;
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
        private int jpO = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.jpO};
        private boolean isNeedEffectItem = true;
        private long jub = 0;
        private int juc = 0;
        private long jud = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jue = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jtZ = gLVideoPreviewView;
            this.iZX = hVar;
            this.jue.start();
            this.juf = new a(this.jue.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Bq(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void csY() {
            this.juf.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jtZ.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.jpP = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jtX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jua = this.jtX.createTextureObject();
            csV();
            boolean unused = GLVideoPreviewView.jtS = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jtZ.mSurfaceViewWidth = i;
            this.jtZ.mSurfaceViewHeight = i2;
        }

        public void csV() {
            if (this.jtY != null) {
                faceunity.fuOnCameraChange();
                this.jtY.release();
            }
            this.jtY = new SurfaceTexture(this.jua);
            cta();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.jnl;
                this.mFacebeautyBlurLevel = aVar.jnm;
                this.mFacebeautyCheeckThin = aVar.jnn;
                this.mFacebeautyEnlargeEye = aVar.jno;
                this.mFacebeautyRedLevel = aVar.jnp;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.juk) {
                int i = this.juc + 1;
                this.juc = i;
                if (i == 100) {
                    this.juc = 0;
                    this.jub = System.currentTimeMillis();
                    this.jud = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jtY.updateTexImage();
                    this.jtY.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.iZX != null) {
                        this.iZX.av(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.juf.sendEmptyMessage(1);
                }
                if (this.jtZ.jtT != null) {
                    this.jtZ.jtT.ry(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.juh) {
                    this.jtZ.requestRender();
                    return;
                }
                int i2 = (this.jtZ.jtP.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jug) {
                    faceunity.fuItemSetParam(this.jpO, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.jpO, "rotationAngle", csZ() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", csZ() ? 270.0d : 90.0d);
                }
                this.jtZ.jtP.csZ();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jua;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jud = (System.currentTimeMillis() - currentTimeMillis) + this.jud;
                try {
                    this.jpP.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jtZ.jtV) {
                        b(gl10);
                        this.jtZ.jtV = false;
                    }
                    if (this.jui != null && this.jui.DN(2) && this.jtZ.jtP != null) {
                        this.juj = this.jtZ.jtP.ctc();
                        this.jui.a(new d.b(new File(this.juj), GLVideoPreviewView.jtN, GLVideoPreviewView.jtO, 2097152, null, this.jtY.getTimestamp()));
                    }
                    if (this.jui != null && this.jui.DN(1)) {
                        this.jui.a(this.jpP, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jtS) {
                            this.jui.d(this.jtY);
                        }
                        boolean unused = GLVideoPreviewView.jtS = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jtZ.g((Camera) null);
                    if (this.iZX != null) {
                        this.iZX.av(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jui = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jtZ.mSurfaceViewWidth;
                int i2 = this.jtZ.mSurfaceViewHeight;
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
                if (this.jtZ != null && (context = this.jtZ.getContext()) != null && (context instanceof Activity)) {
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
            this.jul = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jtZ != null && this.jtZ.jtU != null) {
                    this.jtZ.jtU.y(false, this.jul);
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
                        b.this.jul = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.jnv, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jtZ != null && b.this.jtZ.jtU != null) {
                        b.this.jtZ.jtU.y(true, b.this.jul);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean csZ() {
            return this.jtZ.jtP.csZ();
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
                                b.this.itemsArray[2] = b.this.jpO = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jug) {
                                b.this.jpO = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.jpO;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.jpO, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.jpO, "rotationAngle", b.this.csZ() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.jpO = 0;
                                b.this.itemsArray[2] = b.this.jpO;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.csZ() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.iZX != null) {
                                b.this.iZX.av(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.juh = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.iZX != null) {
                                b.this.iZX.av(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.juh = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.iZX != null) {
                                b.this.iZX.av(26, com.baidu.tieba.j.a.p(e3));
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
            this.jtZ.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.jpP != null) {
                        b.this.jpP.release(false);
                        b.this.jpP = null;
                    }
                    if (b.this.jtX != null) {
                        b.this.jtX.release(false);
                        b.this.jtX = null;
                    }
                    if (b.this.jtY != null) {
                        b.this.jtY.release();
                        b.this.jtY = null;
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

        private void cta() {
            if (this.jtZ != null) {
                Handler mainHandler = this.jtZ.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.jpO != 0) {
                    faceunity.fuItemSetParam(this.jpO, "rotationAngle", csZ() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", csZ() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jug = false;
                } else {
                    this.jug = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.juf.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jtT = aVar;
        }
    }
}
