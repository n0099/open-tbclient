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
    private static int gTP = 720;
    private static int gTQ = TbConfig.HEAD_IMG_SIZE;
    private static boolean gTU;
    private com.baidu.tieba.i.h gAg;
    protected i gTR;
    private b gTS;
    private com.faceunity.a.c gTT;
    private a gTV;
    private int gTW;
    private int gTX;
    private h.a gTY;
    private boolean gTZ;

    /* loaded from: classes2.dex */
    public interface a {
        void nI(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        this.gTR = iVar;
        this.gTS = new b(context, this, this.gAg);
        setEGLContextClientVersion(2);
        setRenderer(this.gTS);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void d(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.gTS);
                camera.setPreviewTexture(this.gTS.gUc);
                this.gTS.gUc.setOnFrameAvailableListener(this.gTS);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gAg != null) {
                    this.gAg.Q(20, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void e(Camera camera) {
        try {
            this.gTT = new com.faceunity.a.c();
            this.gTS.a(this.gTT);
            gTU = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gAg != null) {
                this.gAg.Q(21, com.baidu.tieba.i.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void f(Camera camera) {
        try {
            if (this.gTT != null) {
                this.gTT.stopRecording();
                this.gTT = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gAg != null) {
                this.gAg.Q(19, com.baidu.tieba.i.a.g(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        try {
            this.gTS.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gAg != null) {
                this.gAg.Q(18, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        this.gTS.cCZ = i;
        this.gTS.cDa = i2;
        gTQ = i;
        gTP = i2;
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.gTY = aVar;
        this.gTZ = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gTR == null) {
            return false;
        }
        return this.gTR.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.gTS == null) {
            return;
        }
        this.gTS.bCP();
    }

    public void bCM() {
        if (this.gTS == null) {
            return;
        }
        this.gTS.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.gTS != null) {
            this.gTS.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gTS != null) {
            this.gTS.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gTS != null) {
            this.gTS.setSticker(stickerItem);
        }
    }

    public void bCN() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.gTS != null) {
                    g.this.gTS.bCN();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.gTS.gUm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.gTR.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h gAg;
        private com.faceunity.gles.c gPm;
        private com.faceunity.gles.c gUb;
        private volatile SurfaceTexture gUc;
        private g gUd;
        private int gUe;
        private Handler gUh;
        private boolean gUi;
        private boolean gUj;
        com.faceunity.a.c gUk;
        String gUl;
        private boolean gUm;
        private String gUn;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int cCZ = 720;
        protected int cDa = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gPl = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gPl};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long gUf = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread gUg = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.gUd = gVar;
            this.gAg = hVar;
            this.gUg.start();
            this.gUh = new a(this.gUg.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.vb(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bCP() {
            this.gUh.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.gUd.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.gPm = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gUb = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.gUe = this.gUb.createTextureObject();
            bCN();
            boolean unused = g.gTU = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.gUd.gTW = i;
            this.gUd.gTX = i2;
        }

        public void bCN() {
            if (this.gUc != null) {
                faceunity.fuOnCameraChange();
                this.gUc.release();
            }
            this.gUc = new SurfaceTexture(this.gUe);
            bCQ();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.gMM;
                this.mFacebeautyBlurLevel = aVar.gMN;
                this.mFacebeautyCheeckThin = aVar.gMO;
                this.mFacebeautyEnlargeEye = aVar.gMP;
                this.mFacebeautyRedLevel = aVar.gMQ;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gUm) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.gUf = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.gUc.updateTexImage();
                    this.gUc.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gAg != null) {
                        this.gAg.Q(22, com.baidu.tieba.i.a.g(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.gUh.sendEmptyMessage(1);
                }
                if (this.gUd.gTV != null) {
                    this.gUd.gTV.nI(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.gUj) {
                    this.gUd.requestRender();
                    return;
                }
                int i2 = this.gUd.gTR.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.gUe;
                int i4 = this.cCZ;
                int i5 = this.cDa;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.gUf = (System.currentTimeMillis() - currentTimeMillis) + this.gUf;
                try {
                    this.gPm.drawFrame(fuDualInputToTexture, fArr);
                    if (this.gUd.gTZ) {
                        c(gl10);
                        this.gUd.gTZ = false;
                    }
                    if (this.gUk != null && this.gUk.wR(2) && this.gUd.gTR != null) {
                        this.gUl = this.gUd.gTR.bCS();
                        this.gUk.a(new c.b(new File(this.gUl), g.gTP, g.gTQ, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, null, this.gUc.getTimestamp()));
                    }
                    if (this.gUk != null && this.gUk.wR(1)) {
                        this.gUk.a(this.gPm, fuDualInputToTexture, fArr);
                        if (g.gTU) {
                            this.gUk.d(this.gUc);
                        }
                        boolean unused = g.gTU = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.gUd.f((Camera) null);
                    if (this.gAg != null) {
                        this.gAg.Q(23, com.baidu.tieba.i.a.g(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.c cVar) {
            if (cVar != null) {
                this.gUk = cVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.gUd.gTW;
                int i2 = this.gUd.gTX;
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
                if (this.gUd != null && (context = this.gUd.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                bitmap = null;
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                x(bitmap);
            }
        }

        private void x(final Bitmap bitmap) {
            this.gUn = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.gUd != null && this.gUd.gTY != null) {
                    this.gUd.gTY.s(false, this.gUn);
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
                        b.this.gUn = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.gMW, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.gUd != null && b.this.gUd.gTY != null) {
                        b.this.gUd.gTY.s(true, b.this.gUn);
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
                                b.this.itemsArray[2] = b.this.gPl = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.gUi) {
                                b.this.gPl = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.gPl;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.gPl, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.gPl = 0;
                                b.this.itemsArray[2] = b.this.gPl;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gAg != null) {
                                b.this.gAg.Q(24, com.baidu.tieba.i.a.g(e));
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
                            b.this.gUj = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gAg != null) {
                                b.this.gAg.Q(25, com.baidu.tieba.i.a.g(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.gUj = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gAg != null) {
                                b.this.gAg.Q(26, com.baidu.tieba.i.a.g(e3));
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
            this.gUd.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gPm != null) {
                        b.this.gPm.release(false);
                        b.this.gPm = null;
                    }
                    if (b.this.gUb != null) {
                        b.this.gUb.release(false);
                        b.this.gUb = null;
                    }
                    if (b.this.gUc != null) {
                        b.this.gUc.release();
                        b.this.gUc = null;
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

        private void bCQ() {
            if (this.gUd != null) {
                Handler mainHandler = this.gUd.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.gUi = false;
                } else {
                    this.gUi = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.gUh.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.gTV = aVar;
        }
    }
}
