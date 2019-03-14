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
    private static int jaZ = 720;
    private static int jba = TbConfig.HEAD_IMG_SIZE;
    private static boolean jbe;
    private com.baidu.tieba.j.h iHn;
    protected h jbb;
    private b jbc;
    private com.faceunity.a.d jbd;
    private a jbf;
    private g.a jbg;
    private boolean jbh;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void qI(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iHn = lVar.bEC();
        }
        this.jbb = hVar;
        this.jbc = new b(context, this, this.iHn);
        setEGLContextClientVersion(2);
        setRenderer(this.jbc);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.jbc);
                camera.setPreviewTexture(this.jbc.jbk);
                this.jbc.jbk.setOnFrameAvailableListener(this.jbc);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.iHn != null) {
                    this.iHn.aq(20, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.jbd = new com.faceunity.a.d();
            this.jbc.a(this.jbd);
            jbe = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iHn != null) {
                this.iHn.aq(21, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.jbd != null) {
                this.jbd.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.iHn != null) {
                this.iHn.aq(19, com.baidu.tieba.j.a.p(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.jbd != null) {
            this.jbd.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.jbc.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.iHn != null) {
                this.iHn.aq(18, com.baidu.tieba.j.a.p(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.jbc.previewWidth = i;
            this.jbc.previewHeight = i2;
            jba = (int) (((i * 1.0f) / i2) * jaZ);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.jbg = aVar;
        this.jbh = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jbb == null) {
            return false;
        }
        return this.jbb.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.jbc == null) {
            return;
        }
        this.jbc.ckW();
    }

    public void ckS() {
        if (this.jbc == null) {
            return;
        }
        this.jbc.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.jbc != null) {
            this.jbc.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jbc != null) {
            this.jbc.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jbc != null) {
            this.jbc.setSticker(stickerItem);
        }
    }

    public void ckT() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.jbc != null) {
                    GLVideoPreviewView.this.jbc.ckT();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.jbc.jbw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.jbb.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.j.h iHn;
        private com.faceunity.gles.c iXa;
        private com.faceunity.gles.c jbj;
        private volatile SurfaceTexture jbk;
        private GLVideoPreviewView jbl;
        private int jbm;
        private Handler jbr;
        private boolean jbs;
        private boolean jbt;
        com.faceunity.a.d jbu;
        String jbv;
        private boolean jbw;
        private String jbx;
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
        private int iWZ = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.iWZ};
        private boolean isNeedEffectItem = true;
        private long jbn = 0;
        private int jbo = 0;
        private long jbp = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread jbq = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.j.h hVar) {
            this.jbl = gLVideoPreviewView;
            this.iHn = hVar;
            this.jbq.start();
            this.jbr = new a(this.jbq.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.Am(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ckW() {
            this.jbr.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.jbl.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.iXa = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.jbj = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.jbm = this.jbj.createTextureObject();
            ckT();
            boolean unused = GLVideoPreviewView.jbe = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.jbl.mSurfaceViewWidth = i;
            this.jbl.mSurfaceViewHeight = i2;
        }

        public void ckT() {
            if (this.jbk != null) {
                faceunity.fuOnCameraChange();
                this.jbk.release();
            }
            this.jbk = new SurfaceTexture(this.jbm);
            ckY();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.iUu;
                this.mFacebeautyBlurLevel = aVar.iUv;
                this.mFacebeautyCheeckThin = aVar.iUw;
                this.mFacebeautyEnlargeEye = aVar.iUx;
                this.mFacebeautyRedLevel = aVar.iUy;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.jbw) {
                int i = this.jbo + 1;
                this.jbo = i;
                if (i == 100) {
                    this.jbo = 0;
                    this.jbn = System.currentTimeMillis();
                    this.jbp = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.jbk.updateTexImage();
                    this.jbk.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.iHn != null) {
                        this.iHn.aq(22, com.baidu.tieba.j.a.p(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.jbr.sendEmptyMessage(1);
                }
                if (this.jbl.jbf != null) {
                    this.jbl.jbf.qI(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.jbt) {
                    this.jbl.requestRender();
                    return;
                }
                int i2 = (this.jbl.jbb.mCameraId != 1 ? 32 : 0) | 1;
                if (this.jbs) {
                    faceunity.fuItemSetParam(this.iWZ, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.iWZ, "rotationAngle", ckX() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", ckX() ? 270.0d : 90.0d);
                }
                this.jbl.jbb.ckX();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.jbm;
                int i4 = this.previewWidth;
                int i5 = this.previewHeight;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.jbp = (System.currentTimeMillis() - currentTimeMillis) + this.jbp;
                try {
                    this.iXa.drawFrame(fuDualInputToTexture, fArr);
                    if (this.jbl.jbh) {
                        b(gl10);
                        this.jbl.jbh = false;
                    }
                    if (this.jbu != null && this.jbu.CT(2) && this.jbl.jbb != null) {
                        this.jbv = this.jbl.jbb.cla();
                        this.jbu.a(new d.b(new File(this.jbv), GLVideoPreviewView.jaZ, GLVideoPreviewView.jba, 2097152, null, this.jbk.getTimestamp()));
                    }
                    if (this.jbu != null && this.jbu.CT(1)) {
                        this.jbu.a(this.iXa, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.jbe) {
                            this.jbu.e(this.jbk);
                        }
                        boolean unused = GLVideoPreviewView.jbe = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.jbl.g((Camera) null);
                    if (this.iHn != null) {
                        this.iHn.aq(23, com.baidu.tieba.j.a.p(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.jbu = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.jbl.mSurfaceViewWidth;
                int i2 = this.jbl.mSurfaceViewHeight;
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
                if (this.jbl != null && (context = this.jbl.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                M(bitmap);
            }
        }

        private void M(final Bitmap bitmap) {
            this.jbx = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.jbl != null && this.jbl.jbg != null) {
                    this.jbl.jbg.z(false, this.jbx);
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
                        b.this.jbx = com.baidu.tbadk.core.util.m.a(com.baidu.tieba.video.c.iUE, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.jbl != null && b.this.jbl.jbg != null) {
                        b.this.jbl.jbg.z(true, b.this.jbx);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean ckX() {
            return this.jbl.jbb.ckX();
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
                                b.this.itemsArray[2] = b.this.iWZ = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.jbs) {
                                b.this.iWZ = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.iWZ;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.iWZ, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.iWZ, "rotationAngle", b.this.ckX() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.iWZ = 0;
                                b.this.itemsArray[2] = b.this.iWZ;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.ckX() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.iHn != null) {
                                b.this.iHn.aq(24, com.baidu.tieba.j.a.p(e));
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
                            b.this.jbt = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.iHn != null) {
                                b.this.iHn.aq(25, com.baidu.tieba.j.a.p(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.jbt = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.iHn != null) {
                                b.this.iHn.aq(26, com.baidu.tieba.j.a.p(e3));
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
            this.jbl.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.iXa != null) {
                        b.this.iXa.release(false);
                        b.this.iXa = null;
                    }
                    if (b.this.jbj != null) {
                        b.this.jbj.release(false);
                        b.this.jbj = null;
                    }
                    if (b.this.jbk != null) {
                        b.this.jbk.release();
                        b.this.jbk = null;
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

        private void ckY() {
            if (this.jbl != null) {
                Handler mainHandler = this.jbl.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.iWZ != 0) {
                    faceunity.fuItemSetParam(this.iWZ, "rotationAngle", ckX() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", ckX() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.jbs = false;
                } else {
                    this.jbs = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.jbr.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.jbf = aVar;
        }
    }
}
