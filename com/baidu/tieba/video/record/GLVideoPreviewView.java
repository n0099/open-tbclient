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
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import d.a.o0.r3.l.f;
import d.a.o0.r3.l.g;
import d.a.o0.r3.l.h;
import d.a.o0.u1.k;
import d.e.b.d;
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
    public static int n = 720;
    public static int o = 960;
    public static boolean p;

    /* renamed from: e  reason: collision with root package name */
    public h f21461e;

    /* renamed from: f  reason: collision with root package name */
    public c f21462f;

    /* renamed from: g  reason: collision with root package name */
    public d f21463g;

    /* renamed from: h  reason: collision with root package name */
    public b f21464h;

    /* renamed from: i  reason: collision with root package name */
    public int f21465i;
    public int j;
    public g.a k;
    public boolean l;
    public d.a.o0.u1.g m;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GLVideoPreviewView.this.f21462f != null) {
                GLVideoPreviewView.this.f21462f.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onFaceIdentifyState(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class c implements GLSurfaceView.Renderer, Camera.PreviewCallback, SurfaceTexture.OnFrameAvailableListener {
        public float A;
        public byte[] E;
        public boolean F;
        public boolean G;
        public d H;
        public String I;
        public boolean J;
        public String K;
        public d.a.o0.u1.g L;

        /* renamed from: e  reason: collision with root package name */
        public d.e.c.c f21467e;

        /* renamed from: f  reason: collision with root package name */
        public d.e.c.c f21468f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SurfaceTexture f21469g;

        /* renamed from: h  reason: collision with root package name */
        public GLVideoPreviewView f21470h;
        public int k;
        public HandlerThread s;
        public Handler t;
        public float w;
        public float x;
        public float y;
        public float z;

        /* renamed from: i  reason: collision with root package name */
        public int f21471i = PeerConnectionClient.HD_VIDEO_HEIGHT;
        public int j = TbConfig.HEAD_IMG_SIZE;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int[] o = {0, 0, 0};
        public boolean p = true;
        public int q = 0;
        public long r = 0;
        public String u = "";
        public String v = "origin";
        public int B = 3;
        public float C = 0.5f;
        public int D = 0;

        /* loaded from: classes5.dex */
        public class a extends BdAsyncTask<Void, Void, Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Bitmap f21472a;

            public a(Bitmap bitmap) {
                this.f21472a = bitmap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(Void r3) {
                if (c.this.f21470h == null || c.this.f21470h.k == null) {
                    return;
                }
                c.this.f21470h.k.a(true, c.this.K);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                try {
                    c.this.K = FileHelper.saveFileAsPic(d.a.o0.r3.c.f63814f, "pic_" + System.currentTimeMillis(), this.f21472a, 80, Bitmap.CompressFormat.JPEG);
                    return null;
                } finally {
                    Bitmap bitmap = this.f21472a;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f21472a.recycle();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f21467e != null) {
                    c.this.f21467e.c(false);
                    c.this.f21467e = null;
                }
                if (c.this.f21468f != null) {
                    c.this.f21468f.c(false);
                    c.this.f21468f = null;
                }
                if (c.this.f21469g != null) {
                    c.this.f21469g.release();
                    c.this.f21469g = null;
                }
                faceunity.fuDestroyItem(c.this.m);
                int[] iArr = c.this.o;
                c.this.m = 0;
                iArr[1] = 0;
                faceunity.fuDestroyItem(c.this.l);
                int[] iArr2 = c.this.o;
                c.this.l = 0;
                iArr2[0] = 0;
                faceunity.fuOnDeviceLost();
                c.this.E = null;
                c.this.p = true;
            }
        }

        /* renamed from: com.baidu.tieba.video.record.GLVideoPreviewView$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0219c extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f21475a;

            public HandlerC0219c(Looper looper, Context context) {
                super(looper);
                this.f21475a = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                this.f21475a.get();
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    try {
                        InputStream open = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/v3.mp3");
                        byte[] bArr = new byte[open.available()];
                        open.read(bArr);
                        open.close();
                        faceunity.fuSetup(bArr, null, f.a());
                        c.this.G = true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        if (c.this.L != null) {
                            c.this.L.b(25, d.a.o0.u1.a.a(e2));
                        }
                    }
                    try {
                        InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                        byte[] bArr2 = new byte[open2.available()];
                        open2.read(bArr2);
                        open2.close();
                        c.this.l = faceunity.fuCreateItemFromPackage(bArr2);
                        c.this.o[0] = c.this.l;
                        c.this.G = true;
                        return;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        if (c.this.L != null) {
                            c.this.L.b(26, d.a.o0.u1.a.a(e3));
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (StringUtils.isNull(c.this.u)) {
                        int[] iArr = c.this.o;
                        c.this.m = 0;
                        iArr[1] = 0;
                        int[] iArr2 = c.this.o;
                        c.this.n = 0;
                        iArr2[2] = 0;
                        return;
                    }
                    FileInputStream fileInputStream = new FileInputStream(new File(c.this.u));
                    byte[] bArr3 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr3);
                    fileInputStream.close();
                    int i3 = c.this.o[1] != 0 ? c.this.o[1] : c.this.o[2];
                    double d2 = 270.0d;
                    if (c.this.F) {
                        c.this.n = faceunity.fuCreateItemFromPackage(bArr3);
                        c.this.o[2] = c.this.n;
                        c.this.m = 0;
                        c.this.o[1] = c.this.m;
                        faceunity.fuItemSetParam(c.this.n, "isAndroid", 1.0d);
                        int i4 = c.this.n;
                        if (!c.this.y()) {
                            d2 = 90.0d;
                        }
                        faceunity.fuItemSetParam(i4, "rotationAngle", d2);
                    } else {
                        c.this.m = faceunity.fuCreateItemFromPackage(bArr3);
                        c.this.o[1] = c.this.m;
                        c.this.n = 0;
                        c.this.o[2] = c.this.n;
                        faceunity.fuItemSetParam(c.this.m, "isAndroid", 1.0d);
                        int i5 = c.this.m;
                        if (!c.this.y()) {
                            d2 = 90.0d;
                        }
                        faceunity.fuItemSetParam(i5, "rotationAngle", d2);
                    }
                    if (i3 != 0) {
                        faceunity.fuDestroyItem(i3);
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    if (c.this.L != null) {
                        c.this.L.b(24, d.a.o0.u1.a.a(e4));
                    }
                }
            }
        }

        public c(Context context, GLVideoPreviewView gLVideoPreviewView, d.a.o0.u1.g gVar) {
            this.f21470h = gLVideoPreviewView;
            this.L = gVar;
            HandlerThread handlerThread = new HandlerThread("CreateItemThread");
            this.s = handlerThread;
            handlerThread.start();
            this.t = new HandlerC0219c(this.s.getLooper(), context);
            D(d.a.o0.r3.a.b(2));
        }

        public void A() {
            this.f21470h.queueEvent(new b());
        }

        public final void B(Bitmap bitmap) {
            this.K = null;
            if (bitmap != null && !bitmap.isRecycled()) {
                new a(bitmap).execute(new Void[0]);
                return;
            }
            GLVideoPreviewView gLVideoPreviewView = this.f21470h;
            if (gLVideoPreviewView == null || gLVideoPreviewView.k == null) {
                return;
            }
            this.f21470h.k.a(false, this.K);
        }

        public final void C() {
            GLVideoPreviewView gLVideoPreviewView = this.f21470h;
            if (gLVideoPreviewView != null) {
                Handler mainHandler = gLVideoPreviewView.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                int i2 = this.n;
                if (i2 != 0) {
                    faceunity.fuItemSetParam(i2, "rotationAngle", y() ? 270.0d : 90.0d);
                }
                int i3 = this.m;
                if (i3 != 0) {
                    faceunity.fuItemSetParam(i3, "rotationAngle", y() ? 270.0d : 90.0d);
                }
            }
        }

        public void D(d.a.o0.r3.a aVar) {
            if (aVar == null) {
                return;
            }
            this.w = aVar.f63796b;
            this.x = aVar.f63797c;
            this.y = aVar.f63798d;
            this.z = aVar.f63799e;
            this.A = aVar.f63800f;
        }

        public void E(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.v = str;
        }

        public void F(d dVar) {
            if (dVar != null) {
                this.H = dVar;
            }
        }

        public void G(StickerItem stickerItem) {
            if (stickerItem != null) {
                this.u = stickerItem.localPath;
                if (StringUtils.isNull(stickerItem.desc)) {
                    this.F = false;
                } else {
                    this.F = true;
                }
            } else {
                this.u = null;
            }
            this.t.sendEmptyMessage(1);
        }

        public final void H() {
            this.t.sendEmptyMessage(2);
        }

        public void I() {
            if (this.f21469g != null) {
                faceunity.fuOnCameraChange();
                this.f21469g.release();
            }
            this.f21469g = new SurfaceTexture(this.k);
            C();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (this.J) {
                return;
            }
            int i2 = this.q + 1;
            this.q = i2;
            if (i2 == 100) {
                this.q = 0;
                System.currentTimeMillis();
                this.r = 0L;
            }
            float[] fArr = new float[16];
            try {
                this.f21469g.updateTexImage();
                this.f21469g.getTransformMatrix(fArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.o0.u1.g gVar = this.L;
                if (gVar != null) {
                    gVar.b(22, d.a.o0.u1.a.a(e2));
                }
            }
            if (this.p) {
                this.p = false;
                this.t.sendEmptyMessage(1);
            }
            if (this.f21470h.f21464h != null) {
                this.f21470h.f21464h.onFaceIdentifyState(faceunity.fuIsTracking() > 0);
            }
            faceunity.fuItemSetParam(this.l, "color_level", this.w);
            faceunity.fuItemSetParam(this.l, "blur_level", this.x);
            faceunity.fuItemSetParam(this.l, "filter_name", this.v);
            faceunity.fuItemSetParam(this.l, "cheek_thinning", this.y);
            faceunity.fuItemSetParam(this.l, "eye_enlarging", this.z);
            faceunity.fuItemSetParam(this.l, "face_shape", this.B);
            faceunity.fuItemSetParam(this.l, "face_shape_level", this.C);
            faceunity.fuItemSetParam(this.l, "red_level", this.A);
            faceunity.fuItemSetParam(this.l, "eye_bright", 0.0d);
            faceunity.fuItemSetParam(this.l, "tooth_whiten", 0.0d);
            byte[] bArr = this.E;
            if (bArr != null && bArr.length != 0 && this.G) {
                int i3 = 1 | (this.f21470h.f21461e.l == 1 ? 0 : 32);
                if (this.F) {
                    faceunity.fuItemSetParam(this.n, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.n, "rotationAngle", y() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.m, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.m, "rotationAngle", y() ? 270.0d : 90.0d);
                }
                this.f21470h.f21461e.j();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr2 = this.E;
                int i4 = this.k;
                int i5 = this.f21471i;
                int i6 = this.j;
                int i7 = this.D;
                this.D = i7 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr2, i4, i3, i5, i6, i7, this.o);
                this.r += System.currentTimeMillis() - currentTimeMillis;
                try {
                    this.f21467e.b(fuDualInputToTexture, fArr);
                    if (this.f21470h.l) {
                        z(gl10);
                        this.f21470h.l = false;
                    }
                    if (this.H != null && this.H.s(2) && this.f21470h.f21461e != null) {
                        this.I = this.f21470h.f21461e.o();
                        this.H.E(new d.c(new File(this.I), GLVideoPreviewView.n, GLVideoPreviewView.o, 2097152, null, this.f21469g.getTimestamp()));
                    }
                    if (this.H == null || !this.H.s(1)) {
                        return;
                    }
                    this.H.D(this.f21467e, fuDualInputToTexture, fArr);
                    if (GLVideoPreviewView.p) {
                        this.H.t(this.f21469g);
                    }
                    boolean unused = GLVideoPreviewView.p = true;
                    return;
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.f21470h.e(null);
                    d.a.o0.u1.g gVar2 = this.L;
                    if (gVar2 != null) {
                        gVar2.b(23, d.a.o0.u1.a.a(th));
                        return;
                    }
                    return;
                }
            }
            this.f21470h.requestRender();
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.E = bArr;
            this.f21470h.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            this.f21470h.f21465i = i2;
            this.f21470h.j = i3;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.f21467e = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            d.e.c.c cVar = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.f21468f = cVar;
            this.k = cVar.a();
            I();
            boolean unused = GLVideoPreviewView.p = false;
        }

        public boolean y() {
            return this.f21470h.f21461e.j();
        }

        public final void z(GL10 gl10) {
            Context context;
            Bitmap bitmap = null;
            try {
                System.gc();
                System.gc();
                int i2 = this.f21470h.f21465i;
                int i3 = this.f21470h.j;
                int i4 = i2 * i3;
                int[] iArr = new int[i4];
                int[] iArr2 = new int[i4];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                gl10.glReadPixels(0, 0, i2, i3, 6408, 5121, wrap);
                for (int i5 = 0; i5 < i3; i5++) {
                    int i6 = i5 * i2;
                    int i7 = ((i3 - i5) - 1) * i2;
                    for (int i8 = 0; i8 < i2; i8++) {
                        int i9 = iArr[i6 + i8];
                        iArr2[i7 + i8] = (i9 & (-16711936)) | ((i9 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i9 >> 16) & 255);
                    }
                }
                bitmap = Bitmap.createBitmap(iArr2, i2, i3, Bitmap.Config.ARGB_8888);
            } catch (GLException unused) {
            } catch (OutOfMemoryError unused2) {
                GLVideoPreviewView gLVideoPreviewView = this.f21470h;
                if (gLVideoPreviewView != null && (context = gLVideoPreviewView.getContext()) != null && (context instanceof Activity)) {
                    ((Activity) context).finish();
                }
                System.gc();
                System.gc();
            }
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            B(bitmap);
        }
    }

    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.m = kVar.get();
        }
        this.f21461e = hVar;
        this.f21462f = new c(context, this, this.m);
        setEGLContextClientVersion(2);
        setRenderer(this.f21462f);
        setRenderMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.f21461e.n();
    }

    @Override // d.a.o0.r3.l.g
    public void a(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.f21462f);
                camera.setPreviewTexture(this.f21462f.f21469g);
                this.f21462f.f21469g.setOnFrameAvailableListener(this.f21462f);
                camera.startPreview();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.o0.u1.g gVar = this.m;
                if (gVar != null) {
                    gVar.b(20, d.a.o0.u1.a.a(e2));
                }
            }
        }
    }

    @Override // d.a.o0.r3.l.g
    public void b(Camera camera) {
        try {
            this.f21462f.A();
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.o0.u1.g gVar = this.m;
            if (gVar != null) {
                gVar.b(18, d.a.o0.u1.a.a(e2));
            }
        }
    }

    @Override // d.a.o0.r3.l.g
    public void c(g.a aVar) {
        this.k = aVar;
        this.l = true;
        requestRender();
    }

    @Override // d.a.o0.r3.l.g
    public void d(Camera camera) {
        try {
            d dVar = new d();
            this.f21463g = dVar;
            this.f21462f.F(dVar);
            p = false;
        } catch (Throwable th) {
            BdLog.e(th);
            d.a.o0.u1.g gVar = this.m;
            if (gVar != null) {
                gVar.b(21, d.a.o0.u1.a.a(th));
            }
        }
    }

    @Override // d.a.o0.r3.l.g
    public void e(Camera camera) {
        try {
            if (this.f21463g != null) {
                this.f21463g.F();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            d.a.o0.u1.g gVar = this.m;
            if (gVar != null) {
                gVar.b(19, d.a.o0.u1.a.a(th));
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        c cVar = this.f21462f;
        if (cVar != null) {
            cVar.H();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h hVar = this.f21461e;
        if (hVar == null) {
            return false;
        }
        return hVar.w(motionEvent, getParent());
    }

    public void setBeautyLevel(d.a.o0.r3.a aVar) {
        c cVar = this.f21462f;
        if (cVar != null) {
            cVar.D(aVar);
        }
    }

    public void setFaceIdentifyStateListener(b bVar) {
        if (bVar != null) {
            this.f21464h = bVar;
        }
    }

    public void setFilter(String str) {
        c cVar = this.f21462f;
        if (cVar != null) {
            cVar.E(str);
        }
    }

    public void setIsChangingCamera(boolean z) {
        this.f21462f.J = z;
    }

    @Override // d.a.o0.r3.l.g
    public void setOnEncoderStatusUpdateListener(d.InterfaceC1907d interfaceC1907d) {
        d dVar = this.f21463g;
        if (dVar != null) {
            dVar.C(interfaceC1907d);
        }
    }

    @Override // d.a.o0.r3.l.g
    public void setPreviewSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        c cVar = this.f21462f;
        cVar.f21471i = i2;
        cVar.j = i3;
        int round = Math.round(n * ((i2 * 1.0f) / i3));
        if (round % 2 == 1) {
            round--;
        }
        if (o == 960) {
            o = round;
        }
    }

    public void setSticker(StickerItem stickerItem) {
        c cVar = this.f21462f;
        if (cVar != null) {
            cVar.G(stickerItem);
        }
    }

    public void t() {
        c cVar = this.f21462f;
        if (cVar != null) {
            cVar.E = null;
        }
    }

    public void u() {
        queueEvent(new a());
    }
}
