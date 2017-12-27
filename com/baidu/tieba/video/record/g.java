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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.video.record.h;
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
/* loaded from: classes2.dex */
public class g extends GLSurfaceView implements h {
    private static int hDH = 720;
    private static int hDI = TbConfig.HEAD_IMG_SIZE;
    private static boolean hDM;
    protected i hDJ;
    private b hDK;
    private com.faceunity.a.d hDL;
    private a hDN;
    private int hDO;
    private int hDP;
    private h.a hDQ;
    private boolean hDR;
    private com.baidu.tieba.i.h hjJ;

    /* loaded from: classes2.dex */
    public interface a {
        void oe(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
        }
        this.hDJ = iVar;
        this.hDK = new b(context, this, this.hjJ);
        setEGLContextClientVersion(2);
        setRenderer(this.hDK);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hDK);
                camera.setPreviewTexture(this.hDK.hDU);
                this.hDK.hDU.setOnFrameAvailableListener(this.hDK);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hjJ != null) {
                    this.hjJ.P(20, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.hDL = new com.faceunity.a.d();
            this.hDK.a(this.hDL);
            hDM = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hjJ != null) {
                this.hjJ.P(21, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.hDL != null) {
                this.hDL.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.hjJ != null) {
                this.hjJ.P(19, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.hDL != null) {
            this.hDL.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.hDK.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hjJ != null) {
                this.hjJ.P(18, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hDK.dsA = i;
            this.hDK.dsB = i2;
            hDI = (int) (((i * 1.0f) / i2) * hDH);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.hDQ = aVar;
        this.hDR = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hDJ == null) {
            return false;
        }
        return this.hDJ.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hDK == null) {
            return;
        }
        this.hDK.bIU();
    }

    public void bIR() {
        if (this.hDK == null) {
            return;
        }
        this.hDK.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hDK != null) {
            this.hDK.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hDK != null) {
            this.hDK.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hDK != null) {
            this.hDK.setSticker(stickerItem);
        }
    }

    public void bIS() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.hDK != null) {
                    g.this.hDK.bIS();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hDK.hEe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.hDJ.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.faceunity.gles.c hDT;
        private volatile SurfaceTexture hDU;
        private g hDV;
        private int hDW;
        private Handler hDZ;
        private boolean hEa;
        private boolean hEb;
        com.faceunity.a.d hEc;
        String hEd;
        private boolean hEe;
        private String hEf;
        private com.baidu.tieba.i.h hjJ;
        private com.faceunity.gles.c hzc;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dsA = 720;
        protected int dsB = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hzb = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hzb};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long hDX = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread hDY = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.hDV = gVar;
            this.hjJ = hVar;
            this.hDY.start();
            this.hDZ = new a(this.hDY.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.ya(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bIU() {
            this.hDZ.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.hDV.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hzc = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hDT = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.hDW = this.hDT.createTextureObject();
            bIS();
            boolean unused = g.hDM = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.hDV.hDO = i;
            this.hDV.hDP = i2;
        }

        public void bIS() {
            if (this.hDU != null) {
                faceunity.fuOnCameraChange();
                this.hDU.release();
            }
            this.hDU = new SurfaceTexture(this.hDW);
            bIV();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hwx;
                this.mFacebeautyBlurLevel = aVar.hwy;
                this.mFacebeautyCheeckThin = aVar.hwz;
                this.mFacebeautyEnlargeEye = aVar.hwA;
                this.mFacebeautyRedLevel = aVar.hwB;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hEe) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.hDX = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hDU.updateTexImage();
                    this.hDU.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.hjJ != null) {
                        this.hjJ.P(22, com.baidu.tieba.i.a.i(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.hDZ.sendEmptyMessage(1);
                }
                if (this.hDV.hDN != null) {
                    this.hDV.hDN.oe(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.hEb) {
                    this.hDV.requestRender();
                    return;
                }
                int i2 = this.hDV.hDJ.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.hDW;
                int i4 = this.dsA;
                int i5 = this.dsB;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.hDX = (System.currentTimeMillis() - currentTimeMillis) + this.hDX;
                try {
                    this.hzc.drawFrame(fuDualInputToTexture, fArr);
                    if (this.hDV.hDR) {
                        c(gl10);
                        this.hDV.hDR = false;
                    }
                    if (this.hEc != null && this.hEc.zv(2) && this.hDV.hDJ != null) {
                        this.hEd = this.hDV.hDJ.bIY();
                        this.hEc.a(new d.b(new File(this.hEd), g.hDH, g.hDI, 2097152, null, this.hDU.getTimestamp()));
                    }
                    if (this.hEc != null && this.hEc.zv(1)) {
                        this.hEc.a(this.hzc, fuDualInputToTexture, fArr);
                        if (g.hDM) {
                            this.hEc.c(this.hDU);
                        }
                        boolean unused = g.hDM = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.hDV.i(null);
                    if (this.hjJ != null) {
                        this.hjJ.P(23, com.baidu.tieba.i.a.i(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hEc = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.hDV.hDO;
                int i2 = this.hDV.hDP;
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
                if (this.hDV != null && (context = this.hDV.getContext()) != null && (context instanceof Activity)) {
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
            this.hEf = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.hDV != null && this.hDV.hDQ != null) {
                    this.hDV.hDQ.r(false, this.hEf);
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
                        b.this.hEf = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hwH, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.hDV != null && b.this.hDV.hDQ != null) {
                        b.this.hDV.hDQ.r(true, b.this.hEf);
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
                                b.this.itemsArray[2] = b.this.hzb = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.hEa) {
                                b.this.hzb = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hzb;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hzb, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hzb = 0;
                                b.this.itemsArray[2] = b.this.hzb;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.hjJ != null) {
                                b.this.hjJ.P(24, com.baidu.tieba.i.a.i(e));
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
                            b.this.hEb = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.hjJ != null) {
                                b.this.hjJ.P(25, com.baidu.tieba.i.a.i(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.hEb = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.hjJ != null) {
                                b.this.hjJ.P(26, com.baidu.tieba.i.a.i(e3));
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
            this.hDV.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hzc != null) {
                        b.this.hzc.release(false);
                        b.this.hzc = null;
                    }
                    if (b.this.hDT != null) {
                        b.this.hDT.release(false);
                        b.this.hDT = null;
                    }
                    if (b.this.hDU != null) {
                        b.this.hDU.release();
                        b.this.hDU = null;
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

        private void bIV() {
            if (this.hDV != null) {
                Handler mainHandler = this.hDV.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.hEa = false;
                } else {
                    this.hEa = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.hDZ.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.hDN = aVar;
        }
    }
}
