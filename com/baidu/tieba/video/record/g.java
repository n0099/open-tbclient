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
    private static int htF = 720;
    private static int htG = TbConfig.HEAD_IMG_SIZE;
    private static boolean htK;
    private com.baidu.tieba.i.h gZD;
    protected i htH;
    private b htI;
    private com.faceunity.a.d htJ;
    private a htL;
    private int htM;
    private int htN;
    private h.a htO;
    private boolean htP;

    /* loaded from: classes2.dex */
    public interface a {
        void nk(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        this.htH = iVar;
        this.htI = new b(context, this, this.gZD);
        setEGLContextClientVersion(2);
        setRenderer(this.htI);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.htI);
                camera.setPreviewTexture(this.htI.htS);
                this.htI.htS.setOnFrameAvailableListener(this.htI);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gZD != null) {
                    this.gZD.T(20, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.htJ = new com.faceunity.a.d();
            this.htI.a(this.htJ);
            htK = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gZD != null) {
                this.gZD.T(21, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.htJ != null) {
                this.htJ.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gZD != null) {
                this.gZD.T(19, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.htJ != null) {
            this.htJ.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.htI.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZD != null) {
                this.gZD.T(18, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.htI.dxv = i;
            this.htI.dxw = i2;
            htG = (int) (((i * 1.0f) / i2) * htF);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.htO = aVar;
        this.htP = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.htH == null) {
            return false;
        }
        return this.htH.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.htI == null) {
            return;
        }
        this.htI.bCt();
    }

    public void bCq() {
        if (this.htI == null) {
            return;
        }
        this.htI.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.htI != null) {
            this.htI.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.htI != null) {
            this.htI.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.htI != null) {
            this.htI.setSticker(stickerItem);
        }
    }

    public void bCr() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.htI != null) {
                    g.this.htI.bCr();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.htI.huc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.htH.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h gZD;
        private com.faceunity.gles.c hoZ;
        private com.faceunity.gles.c htR;
        private volatile SurfaceTexture htS;
        private g htT;
        private int htU;
        private Handler htX;
        private boolean htY;
        private boolean htZ;
        com.faceunity.a.d hua;
        String hub;
        private boolean huc;
        private String hud;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dxv = 720;
        protected int dxw = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hoY = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hoY};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long htV = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread htW = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.htT = gVar;
            this.gZD = hVar;
            this.htW.start();
            this.htX = new a(this.htW.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wC(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bCt() {
            this.htX.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.htT.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hoZ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.htR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.htU = this.htR.createTextureObject();
            bCr();
            boolean unused = g.htK = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.htT.htM = i;
            this.htT.htN = i2;
        }

        public void bCr() {
            if (this.htS != null) {
                faceunity.fuOnCameraChange();
                this.htS.release();
            }
            this.htS = new SurfaceTexture(this.htU);
            bCu();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hmu;
                this.mFacebeautyBlurLevel = aVar.hmv;
                this.mFacebeautyCheeckThin = aVar.hmw;
                this.mFacebeautyEnlargeEye = aVar.hmx;
                this.mFacebeautyRedLevel = aVar.hmy;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.huc) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.htV = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.htS.updateTexImage();
                    this.htS.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gZD != null) {
                        this.gZD.T(22, com.baidu.tieba.i.a.i(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.htX.sendEmptyMessage(1);
                }
                if (this.htT.htL != null) {
                    this.htT.htL.nk(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.htZ) {
                    this.htT.requestRender();
                    return;
                }
                int i2 = this.htT.htH.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.htU;
                int i4 = this.dxv;
                int i5 = this.dxw;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.htV = (System.currentTimeMillis() - currentTimeMillis) + this.htV;
                try {
                    this.hoZ.drawFrame(fuDualInputToTexture, fArr);
                    if (this.htT.htP) {
                        c(gl10);
                        this.htT.htP = false;
                    }
                    if (this.hua != null && this.hua.yG(2) && this.htT.htH != null) {
                        this.hub = this.htT.htH.bCx();
                        this.hua.a(new d.b(new File(this.hub), g.htF, g.htG, 2097152, null, this.htS.getTimestamp()));
                    }
                    if (this.hua != null && this.hua.yG(1)) {
                        this.hua.a(this.hoZ, fuDualInputToTexture, fArr);
                        if (g.htK) {
                            this.hua.c(this.htS);
                        }
                        boolean unused = g.htK = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.htT.i(null);
                    if (this.gZD != null) {
                        this.gZD.T(23, com.baidu.tieba.i.a.i(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.hua = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.htT.htM;
                int i2 = this.htT.htN;
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
                if (this.htT != null && (context = this.htT.getContext()) != null && (context instanceof Activity)) {
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
            this.hud = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.htT != null && this.htT.htO != null) {
                    this.htT.htO.n(false, this.hud);
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
                        b.this.hud = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hmE, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.htT != null && b.this.htT.htO != null) {
                        b.this.htT.htO.n(true, b.this.hud);
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
                                b.this.itemsArray[2] = b.this.hoY = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.htY) {
                                b.this.hoY = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hoY;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hoY, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hoY = 0;
                                b.this.itemsArray[2] = b.this.hoY;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gZD != null) {
                                b.this.gZD.T(24, com.baidu.tieba.i.a.i(e));
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
                            b.this.htZ = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gZD != null) {
                                b.this.gZD.T(25, com.baidu.tieba.i.a.i(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.htZ = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gZD != null) {
                                b.this.gZD.T(26, com.baidu.tieba.i.a.i(e3));
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
            this.htT.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hoZ != null) {
                        b.this.hoZ.release(false);
                        b.this.hoZ = null;
                    }
                    if (b.this.htR != null) {
                        b.this.htR.release(false);
                        b.this.htR = null;
                    }
                    if (b.this.htS != null) {
                        b.this.htS.release();
                        b.this.htS = null;
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

        private void bCu() {
            if (this.htT != null) {
                Handler mainHandler = this.htT.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.htY = false;
                } else {
                    this.htY = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.htX.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.htL = aVar;
        }
    }
}
