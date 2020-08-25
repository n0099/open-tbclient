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
    private static boolean mAc;
    private static int mzX = 720;
    private static int mzY = TbConfig.HEAD_IMG_SIZE;
    private b mAa;
    private com.faceunity.a.d mAb;
    private a mAd;
    private g.a mAe;
    private boolean mAf;
    private int mSurfaceViewHeight;
    private int mSurfaceViewWidth;
    private com.baidu.tieba.k.h mgf;
    protected h mzZ;

    /* loaded from: classes17.dex */
    public interface a {
        void wL(boolean z);
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mgf = lVar.cRt();
        }
        this.mzZ = hVar;
        this.mAa = new b(context, this, this.mgf);
        setEGLContextClientVersion(2);
        setRenderer(this.mAa);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.g
    public void e(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.mAa);
                camera.setPreviewTexture(this.mAa.mAi);
                this.mAa.mAi.setOnFrameAvailableListener(this.mAa);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mgf != null) {
                    this.mgf.bn(20, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void f(Camera camera) {
        try {
            this.mAb = new com.faceunity.a.d();
            this.mAa.a(this.mAb);
            mAc = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mgf != null) {
                this.mgf.bn(21, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void g(Camera camera) {
        try {
            if (this.mAb != null) {
                this.mAb.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.mgf != null) {
                this.mgf.bn(19, com.baidu.tieba.k.a.r(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.mAb != null) {
            this.mAb.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void h(Camera camera) {
        try {
            this.mAa.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mgf != null) {
                this.mgf.bn(18, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mAa.bNE = i;
            this.mAa.bNF = i2;
            int round = Math.round(((i * 1.0f) / i2) * mzX);
            if (round % 2 == 1) {
                round--;
            }
            if (mzY == 960) {
                mzY = round;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.g
    public void a(g.a aVar) {
        this.mAe = aVar;
        this.mAf = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mzZ == null) {
            return false;
        }
        return this.mzZ.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.mAa == null) {
            return;
        }
        this.mAa.dCU();
    }

    public void dCQ() {
        if (this.mAa == null) {
            return;
        }
        this.mAa.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.mAa != null) {
            this.mAa.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.mAa != null) {
            this.mAa.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.mAa != null) {
            this.mAa.setSticker(stickerItem);
        }
    }

    public void dCR() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GLVideoPreviewView.this.mAa != null) {
                    GLVideoPreviewView.this.mAa.dCR();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.mAa.mAu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.mzZ.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c mAh;
        private volatile SurfaceTexture mAi;
        private GLVideoPreviewView mAj;
        private int mAk;
        private Handler mAp;
        private boolean mAq;
        private boolean mAr;
        com.faceunity.a.d mAs;
        String mAt;
        private boolean mAu;
        private String mAv;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        private com.baidu.tieba.k.h mgf;
        private com.faceunity.gles.c mvT;
        protected int bNE = 720;
        protected int bNF = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int mvS = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.mvS};
        private boolean isNeedEffectItem = true;
        private long mAl = 0;
        private int mAm = 0;
        private long mAn = 0;
        private String mEffectFileName = "";
        private String mFilterName = "origin";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread mAo = new HandlerThread("CreateItemThread");

        public b(Context context, GLVideoPreviewView gLVideoPreviewView, com.baidu.tieba.k.h hVar) {
            this.mAj = gLVideoPreviewView;
            this.mgf = hVar;
            this.mAo.start();
            this.mAp = new a(this.mAo.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.II(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dCU() {
            this.mAp.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.mAj.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.mvT = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.mAh = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mAk = this.mAh.createTextureObject();
            dCR();
            boolean unused = GLVideoPreviewView.mAc = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.mAj.mSurfaceViewWidth = i;
            this.mAj.mSurfaceViewHeight = i2;
        }

        public void dCR() {
            if (this.mAi != null) {
                faceunity.fuOnCameraChange();
                this.mAi.release();
            }
            this.mAi = new SurfaceTexture(this.mAk);
            dCW();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.mts;
                this.mFacebeautyBlurLevel = aVar.mtt;
                this.mFacebeautyCheeckThin = aVar.mtu;
                this.mFacebeautyEnlargeEye = aVar.mtv;
                this.mFacebeautyRedLevel = aVar.mtw;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.mAu) {
                int i = this.mAm + 1;
                this.mAm = i;
                if (i == 100) {
                    this.mAm = 0;
                    this.mAl = System.currentTimeMillis();
                    this.mAn = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.mAi.updateTexImage();
                    this.mAi.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mgf != null) {
                        this.mgf.bn(22, com.baidu.tieba.k.a.r(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.mAp.sendEmptyMessage(1);
                }
                if (this.mAj.mAd != null) {
                    this.mAj.mAd.wL(faceunity.fuIsTracking() > 0);
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
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.mAr) {
                    this.mAj.requestRender();
                    return;
                }
                int i2 = (this.mAj.mzZ.mCameraId != 1 ? 32 : 0) | 1;
                if (this.mAq) {
                    faceunity.fuItemSetParam(this.mvS, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mvS, "rotationAngle", dCV() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dCV() ? 270.0d : 90.0d);
                }
                this.mAj.mzZ.dCV();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.mAk;
                int i4 = this.bNE;
                int i5 = this.bNF;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2, i4, i5, i6, this.itemsArray);
                this.mAn = (System.currentTimeMillis() - currentTimeMillis) + this.mAn;
                try {
                    this.mvT.drawFrame(fuDualInputToTexture, fArr);
                    if (this.mAj.mAf) {
                        b(gl10);
                        this.mAj.mAf = false;
                    }
                    if (this.mAs != null && this.mAs.Mw(2) && this.mAj.mzZ != null) {
                        this.mAt = this.mAj.mzZ.dCY();
                        this.mAs.a(new d.b(new File(this.mAt), GLVideoPreviewView.mzX, GLVideoPreviewView.mzY, 2097152, null, this.mAi.getTimestamp()));
                    }
                    if (this.mAs != null && this.mAs.Mw(1)) {
                        this.mAs.a(this.mvT, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.mAc) {
                            this.mAs.e(this.mAi);
                        }
                        boolean unused = GLVideoPreviewView.mAc = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.mAj.g((Camera) null);
                    if (this.mgf != null) {
                        this.mgf.bn(23, com.baidu.tieba.k.a.r(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.mAs = dVar;
            }
        }

        private void b(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.mAj.mSurfaceViewWidth;
                int i2 = this.mAj.mSurfaceViewHeight;
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
                if (this.mAj != null && (context = this.mAj.getContext()) != null && (context instanceof Activity)) {
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
            this.mAv = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.mAj != null && this.mAj.mAe != null) {
                    this.mAj.mAe.D(false, this.mAv);
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
                        b.this.mAv = n.saveFileAsPic(com.baidu.tieba.video.c.mtD, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.mAj != null && b.this.mAj.mAe != null) {
                        b.this.mAj.mAe.D(true, b.this.mAv);
                    }
                }
            }.execute(new Void[0]);
        }

        public boolean dCV() {
            return this.mAj.mzZ.dCV();
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
                                b.this.itemsArray[2] = b.this.mvS = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.mAq) {
                                b.this.mvS = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.mvS;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.mvS, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mvS, "rotationAngle", b.this.dCV() ? 270.0d : 90.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.mvS = 0;
                                b.this.itemsArray[2] = b.this.mvS;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                                faceunity.fuItemSetParam(b.this.mEffectItem, "rotationAngle", b.this.dCV() ? 270.0d : 90.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.mgf != null) {
                                b.this.mgf.bn(24, com.baidu.tieba.k.a.r(e));
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
                            b.this.mAr = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.mgf != null) {
                                b.this.mgf.bn(25, com.baidu.tieba.k.a.r(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.mAr = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.mgf != null) {
                                b.this.mgf.bn(26, com.baidu.tieba.k.a.r(e3));
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
            this.mAj.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.GLVideoPreviewView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mvT != null) {
                        b.this.mvT.release(false);
                        b.this.mvT = null;
                    }
                    if (b.this.mAh != null) {
                        b.this.mAh.release(false);
                        b.this.mAh = null;
                    }
                    if (b.this.mAi != null) {
                        b.this.mAi.release();
                        b.this.mAi = null;
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

        private void dCW() {
            if (this.mAj != null) {
                Handler mainHandler = this.mAj.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                if (this.mvS != 0) {
                    faceunity.fuItemSetParam(this.mvS, "rotationAngle", dCV() ? 270.0d : 90.0d);
                }
                if (this.mEffectItem != 0) {
                    faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", dCV() ? 270.0d : 90.0d);
                }
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.mAq = false;
                } else {
                    this.mAq = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.mAp.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.mAd = aVar;
        }
    }
}
