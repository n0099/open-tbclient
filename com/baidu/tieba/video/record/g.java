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
    private static int htl = 720;
    private static int htm = TbConfig.HEAD_IMG_SIZE;
    private static boolean htq;
    private com.baidu.tieba.i.h gZj;
    protected i htn;
    private b hto;
    private com.faceunity.a.d htp;
    private a htr;
    private int hts;
    private int htt;
    private h.a htu;
    private boolean htv;

    /* loaded from: classes2.dex */
    public interface a {
        void nh(boolean z);
    }

    public g(Context context, i iVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        this.htn = iVar;
        this.hto = new b(context, this, this.gZj);
        setEGLContextClientVersion(2);
        setRenderer(this.hto);
        setRenderMode(0);
    }

    @Override // com.baidu.tieba.video.record.h
    public void g(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.hto);
                camera.setPreviewTexture(this.hto.hty);
                this.hto.hty.setOnFrameAvailableListener(this.hto);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gZj != null) {
                    this.gZj.R(20, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void h(Camera camera) {
        try {
            this.htp = new com.faceunity.a.d();
            this.hto.a(this.htp);
            htq = false;
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gZj != null) {
                this.gZj.R(21, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void i(Camera camera) {
        try {
            if (this.htp != null) {
                this.htp.stopRecording();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            if (this.gZj != null) {
                this.gZj.R(19, com.baidu.tieba.i.a.i(th));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setOnEncoderStatusUpdateListener(d.c cVar) {
        if (this.htp != null) {
            this.htp.setOnEncoderStatusUpdateListener(cVar);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void j(Camera camera) {
        try {
            this.hto.releaseResource();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZj != null) {
                this.gZj.R(18, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void setPreviewSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.hto.dxa = i;
            this.hto.dxb = i2;
            htm = (int) (((i * 1.0f) / i2) * htl);
        }
    }

    @Override // com.baidu.tieba.video.record.h
    public void a(h.a aVar) {
        this.htu = aVar;
        this.htv = true;
        requestRender();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.htn == null) {
            return false;
        }
        return this.htn.a(motionEvent, getParent());
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.hto == null) {
            return;
        }
        this.hto.bCr();
    }

    public void bCo() {
        if (this.hto == null) {
            return;
        }
        this.hto.mCameraNV21Byte = null;
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hto != null) {
            this.hto.setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hto != null) {
            this.hto.setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hto != null) {
            this.hto.setSticker(stickerItem);
        }
    }

    public void bCp() {
        queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.hto != null) {
                    g.this.hto.bCp();
                }
            }
        });
    }

    public void setIsChangingCamera(boolean z) {
        this.hto.htI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.htn.getMainHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer {
        private com.baidu.tieba.i.h gZj;
        private com.faceunity.gles.c hoF;
        private int htA;
        private Handler htD;
        private boolean htE;
        private boolean htF;
        com.faceunity.a.d htG;
        String htH;
        private boolean htI;
        private String htJ;
        private com.faceunity.gles.c htx;
        private volatile SurfaceTexture hty;
        private g htz;
        private byte[] mCameraNV21Byte;
        private float mFacebeautyBlurLevel;
        private float mFacebeautyCheeckThin;
        private float mFacebeautyColorLevel;
        private float mFacebeautyEnlargeEye;
        private float mFacebeautyRedLevel;
        protected int dxa = 720;
        protected int dxb = TbConfig.HEAD_IMG_SIZE;
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int hoE = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hoE};
        private boolean isNeedEffectItem = true;
        private long lastOneHundredFrameTimeStamp = 0;
        private int currentFrameCnt = 0;
        private long htB = 0;
        private String mEffectFileName = "";
        private String mFilterName = "nature";
        private int mFaceShape = 3;
        private float mFaceShapeLevel = 0.5f;
        private int mFrameId = 0;
        private HandlerThread htC = new HandlerThread("CreateItemThread");

        public b(Context context, g gVar, com.baidu.tieba.i.h hVar) {
            this.htz = gVar;
            this.gZj = hVar;
            this.htC.start();
            this.htD = new a(this.htC.getLooper(), context);
            setBeautyLevel(com.baidu.tieba.video.a.wC(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bCr() {
            this.htD.sendEmptyMessage(2);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.mCameraNV21Byte = bArr;
            this.htz.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.hoF = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.htx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.htA = this.htx.createTextureObject();
            bCp();
            boolean unused = g.htq = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.htz.hts = i;
            this.htz.htt = i2;
        }

        public void bCp() {
            if (this.hty != null) {
                faceunity.fuOnCameraChange();
                this.hty.release();
            }
            this.hty = new SurfaceTexture(this.htA);
            bCs();
        }

        public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
            if (aVar != null) {
                this.mFacebeautyColorLevel = aVar.hma;
                this.mFacebeautyBlurLevel = aVar.hmb;
                this.mFacebeautyCheeckThin = aVar.hmc;
                this.mFacebeautyEnlargeEye = aVar.hmd;
                this.mFacebeautyRedLevel = aVar.hme;
            }
        }

        public void setFilter(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mFilterName = str;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.htI) {
                int i = this.currentFrameCnt + 1;
                this.currentFrameCnt = i;
                if (i == 100) {
                    this.currentFrameCnt = 0;
                    this.lastOneHundredFrameTimeStamp = System.currentTimeMillis();
                    this.htB = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.hty.updateTexImage();
                    this.hty.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.gZj != null) {
                        this.gZj.R(22, com.baidu.tieba.i.a.i(e));
                    }
                }
                if (this.isNeedEffectItem) {
                    this.isNeedEffectItem = false;
                    this.htD.sendEmptyMessage(1);
                }
                if (this.htz.htr != null) {
                    this.htz.htr.nh(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0 || !this.htF) {
                    this.htz.requestRender();
                    return;
                }
                int i2 = this.htz.htn.mCameraId != 1 ? 32 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = this.mCameraNV21Byte;
                int i3 = this.htA;
                int i4 = this.dxa;
                int i5 = this.dxb;
                int i6 = this.mFrameId;
                this.mFrameId = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr, i3, i2 | 1, i4, i5, i6, this.itemsArray);
                this.htB = (System.currentTimeMillis() - currentTimeMillis) + this.htB;
                try {
                    this.hoF.drawFrame(fuDualInputToTexture, fArr);
                    if (this.htz.htv) {
                        c(gl10);
                        this.htz.htv = false;
                    }
                    if (this.htG != null && this.htG.yG(2) && this.htz.htn != null) {
                        this.htH = this.htz.htn.bCv();
                        this.htG.a(new d.b(new File(this.htH), g.htl, g.htm, 2097152, null, this.hty.getTimestamp()));
                    }
                    if (this.htG != null && this.htG.yG(1)) {
                        this.htG.a(this.hoF, fuDualInputToTexture, fArr);
                        if (g.htq) {
                            this.htG.c(this.hty);
                        }
                        boolean unused = g.htq = true;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.htz.i(null);
                    if (this.gZj != null) {
                        this.gZj.R(23, com.baidu.tieba.i.a.i(th));
                    }
                }
            }
        }

        public void a(com.faceunity.a.d dVar) {
            if (dVar != null) {
                this.htG = dVar;
            }
        }

        private void c(GL10 gl10) {
            Bitmap bitmap;
            Context context;
            Bitmap bitmap2 = null;
            try {
                System.gc();
                System.gc();
                int i = this.htz.hts;
                int i2 = this.htz.htt;
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
                if (this.htz != null && (context = this.htz.getContext()) != null && (context instanceof Activity)) {
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
            this.htJ = null;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.htz != null && this.htz.htu != null) {
                    this.htz.htu.n(false, this.htJ);
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
                        b.this.htJ = com.baidu.tbadk.core.util.k.a(com.baidu.tieba.video.b.hmk, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
                    if (b.this.htz != null && b.this.htz.htu != null) {
                        b.this.htz.htu.n(true, b.this.htJ);
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
                                b.this.itemsArray[2] = b.this.hoE = 0;
                                return;
                            }
                            FileInputStream fileInputStream = new FileInputStream(new File(b.this.mEffectFileName));
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            fileInputStream.close();
                            int i = b.this.itemsArray[1] != 0 ? b.this.itemsArray[1] : b.this.itemsArray[2];
                            if (b.this.htE) {
                                b.this.hoE = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[2] = b.this.hoE;
                                b.this.mEffectItem = 0;
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                faceunity.fuItemSetParam(b.this.hoE, "isAndroid", 1.0d);
                            } else {
                                b.this.mEffectItem = faceunity.fuCreateItemFromPackage(bArr);
                                b.this.itemsArray[1] = b.this.mEffectItem;
                                b.this.hoE = 0;
                                b.this.itemsArray[2] = b.this.hoE;
                                faceunity.fuItemSetParam(b.this.mEffectItem, "isAndroid", 1.0d);
                            }
                            if (i != 0) {
                                faceunity.fuDestroyItem(i);
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (b.this.gZj != null) {
                                b.this.gZj.R(24, com.baidu.tieba.i.a.i(e));
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
                            b.this.htF = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (b.this.gZj != null) {
                                b.this.gZj.R(25, com.baidu.tieba.i.a.i(e2));
                            }
                        }
                        try {
                            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr3 = new byte[open2.available()];
                            open2.read(bArr3);
                            open2.close();
                            b.this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(bArr3);
                            b.this.itemsArray[0] = b.this.mFacebeautyItem;
                            b.this.htF = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (b.this.gZj != null) {
                                b.this.gZj.R(26, com.baidu.tieba.i.a.i(e3));
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
            this.htz.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.record.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hoF != null) {
                        b.this.hoF.release(false);
                        b.this.hoF = null;
                    }
                    if (b.this.htx != null) {
                        b.this.htx.release(false);
                        b.this.htx = null;
                    }
                    if (b.this.hty != null) {
                        b.this.hty.release();
                        b.this.hty = null;
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

        private void bCs() {
            if (this.htz != null) {
                Handler mainHandler = this.htz.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
            }
        }

        public void setSticker(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.mEffectFileName = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.htE = false;
                } else {
                    this.htE = true;
                }
            } else {
                this.mEffectFileName = null;
            }
            this.htD.sendEmptyMessage(1);
        }
    }

    public void setFaceIdentifyStateListener(a aVar) {
        if (aVar != null) {
            this.htr = aVar;
        }
    }
}
