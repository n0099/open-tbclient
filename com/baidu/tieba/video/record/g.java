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
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.record.h;
import com.faceunity.a.c;
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
/* loaded from: classes2.dex */
public class g extends GLSurfaceView implements h {
    private static int gWD = 720;
    private static int gWE = TbConfig.HEAD_IMG_SIZE;
    private static boolean gWI;
    private com.baidu.tieba.i.h gCU;
    protected i gWF;
    private b gWG;
    private com.faceunity.a.c gWH;
    private a gWJ;
    private int gWK;
    private int gWL;
    private h.a gWM;
    private boolean gWN;

    /* loaded from: classes2.dex */
    public interface a {
        void nK(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        this.gWF = iVar;
        this.gWG = new b(context, this, this.gCU);
        setEGLContextClientVersion(2);
        setRenderer(this.gWG);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gWG);
                camera.setPreviewTexture(this.gWG.gWQ);
                this.gWG.gWQ.setOnFrameAvailableListener(this.gWG);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gCU != null) {
                    this.gCU.Q(20, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.gWH = new com.faceunity.a.c();
            this.gWG.a(this.gWH);
            gWI = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gCU != null) {
                this.gCU.Q(21, com.baidu.tieba.i.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.gWH != null) {
                this.gWH.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gCU != null) {
                this.gCU.Q(19, com.baidu.tieba.i.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(c.InterfaceC0166c interfaceC0166c) {
        if (this.gWH != null) {
            this.gWH.setOnEncoderStatusUpdateListener(interfaceC0166c);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.gWG.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gCU != null) {
                this.gCU.Q(18, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        this.gWG.cDl = i;
        this.gWG.cDm = i2;
        gWE = (int) (((i * 1.0f) / i2) * gWD);
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.gWM = aVar;
        this.gWN = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gWF == null) {
            return false;
        }
        return this.gWF.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gWG == null) {
            return;
        }
        this.gWG.bDv();
    }

    public void bDs() {
        if (this.gWG == null) {
            return;
        }
        this.gWG.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gWG != null) {
            this.gWG.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gWG != null) {
            this.gWG.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gWG != null) {
            this.gWG.setSticker(stickerItem);
        }
    }

    public void bDt() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.gWG != null) {
                    g.this.gWG.bDt();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gWG.gXa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gWF.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h gCU;
        private com.faceunity.gles.c gSa;
        private com.faceunity.gles.c gWP;
        private volatile SurfaceTexture gWQ;
        private g gWR;
        private int gWS;
        private Handler gWV;
        private boolean gWW;
        private boolean gWX;
        com.faceunity.a.c gWY;
        String gWZ;
        private boolean gXa;
        private String gXb;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int cDl = 720;
        protected int cDm = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gRZ = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gRZ};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gWT = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gWU = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.gWR = gVar;
            this.gCU = hVar;
            this.gWU.start();
            this.gWV = new a(this.gWU.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.vm(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bDv() {
            this.gWV.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gWR.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gSa = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gWP = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gWS = this.gWP.createTextureObject();
            bDt();
            boolean unused = g.gWI = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.gWR.gWK = i;
            this.gWR.gWL = i2;
        }

        public void bDt() {
            if (this.gWQ != null) {
                faceunity.fuOnCameraChange();
                this.gWQ.release();
            }
            this.gWQ = new SurfaceTexture(this.gWS);
            bDw();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gPz;
                this.mFacebeautyBlurLevel = aVar.gPA;
                this.mFacebeautyCheeckThin = aVar.gPB;
                this.mFacebeautyEnlargeEye = aVar.gPC;
                this.mFacebeautyRedLevel = aVar.gPD;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gXa) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gWT = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gWQ.updateTexImage();
                    this.gWQ.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gCU != null) {
                        this.gCU.Q(22, com.baidu.tieba.i.a.g(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gWV.sendEmptyMessage(1);
                }
                if (this.gWR.gWJ != null) {
                    this.gWR.gWJ.nK(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gWX) {
                    this.gWR.requestRender();
                    return;
                }
                int i2 = this.gWR.gWF.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gWS;
                int i4 = this.cDl;
                int i5 = this.cDm;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.gWT = (System.currentTimeMillis() - currentTimeMillis) + this.gWT;
                try {
                    this.gSa.drawFrame(fuDualInputToTexture, fArr);
                    if (this.gWR.gWN) {
                        c(gl10);
                        this.gWR.gWN = false;
                    }
                    if (this.gWY != null && this.gWY.xe(2) && this.gWR.gWF != null) {
                        this.gWZ = this.gWR.gWF.bDz();
                        this.gWY.a(new c.b(new File(this.gWZ), g.gWD, g.gWE, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END, null, this.gWQ.getTimestamp()));
                    }
                    if (this.gWY != null && this.gWY.xe(1)) {
                        this.gWY.a(this.gSa, fuDualInputToTexture, fArr);
                        if (g.gWI) {
                            this.gWY.d(this.gWQ);
                        }
                        boolean unused = g.gWI = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gWR.i(null);
                    if (this.gCU != null) {
                        this.gCU.Q(23, com.baidu.tieba.i.a.g(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.c cVar) {
            if (cVar != null) {
                this.gWY = cVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.gWR.gWK;
                int i2 = this.gWR.gWL;
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
                        iArr2[i5 + i6] = (i7 & (-16711936)) | ((i7 << 16) & 16711680) | ((i7 >> 16) & MotionEventCompat.ACTION_MASK);
                    }
                }
                bitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
            } catch (GLException e) {
                bitmap = null;
            } catch (OutOfMemoryError e2) {
                if (0 != 0 && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                if (this.gWR != null && (context = this.gWR.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                y(bitmap);
            }
        }

        private void y(final Bitmap bitmap) {
            this.gXb = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.gWR != null && this.gWR.gWM != null) {
                    this.gWR.gWM.s(false, this.gXb);
                    return;
                }
                return;
            }
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.video.record.g.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    try {
                        b.this.gXb = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gPJ, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                /* renamed from: a */
                public void onPostExecute(Void r4) {
                    if (b.this.gWR != null && b.this.gWR.gWM != null) {
                        b.this.gWR.gWM.s(true, b.this.gXb);
                    }
                }
            }.execute(new Void[0]);
        }

        /* loaded from: classes2.dex */
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
                                b.this.itemsArray[2] = b.this.gRZ = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.gWW) {
                                b.this.gRZ = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.gRZ;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.gRZ, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.gRZ = 0;
                                b.this.itemsArray[2] = b.this.gRZ;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gCU != null) {
                                b.this.gCU.Q(24, com.baidu.tieba.i.a.g(e));
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
                            b.this.gWX = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gCU != null) {
                                b.this.gCU.Q(25, com.baidu.tieba.i.a.g(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.gWX = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gCU != null) {
                                b.this.gCU.Q(26, com.baidu.tieba.i.a.g(e3));
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
            this.gWR.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gSa != null) {
                        b.this.gSa.release(false);
                        b.this.gSa = null;
                    }
                    if (b.this.gWP != null) {
                        b.this.gWP.release(false);
                        b.this.gWP = null;
                    }
                    if (b.this.gWQ != null) {
                        b.this.gWQ.release();
                        b.this.gWQ = null;
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

        private void bDw() {
            if (this.gWR != null) {
                Handler mainHandler = this.gWR.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gWW = false;
                } else {
                    this.gWW = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gWV.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.gWJ = aVar;
        }
    }
}
