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
import d.b.i0.p3.m.f;
import d.b.i0.p3.m.g;
import d.b.i0.p3.m.h;
import d.b.i0.s1.k;
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
    public h f21808e;

    /* renamed from: f  reason: collision with root package name */
    public c f21809f;

    /* renamed from: g  reason: collision with root package name */
    public d f21810g;

    /* renamed from: h  reason: collision with root package name */
    public b f21811h;
    public int i;
    public int j;
    public g.a k;
    public boolean l;
    public d.b.i0.s1.g m;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GLVideoPreviewView.this.f21809f != null) {
                GLVideoPreviewView.this.f21809f.I();
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
        public d.b.i0.s1.g L;

        /* renamed from: e  reason: collision with root package name */
        public d.e.c.c f21813e;

        /* renamed from: f  reason: collision with root package name */
        public d.e.c.c f21814f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SurfaceTexture f21815g;

        /* renamed from: h  reason: collision with root package name */
        public GLVideoPreviewView f21816h;
        public int k;
        public HandlerThread s;
        public Handler t;
        public float w;
        public float x;
        public float y;
        public float z;
        public int i = PeerConnectionClient.HD_VIDEO_HEIGHT;
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
            public final /* synthetic */ Bitmap f21817a;

            public a(Bitmap bitmap) {
                this.f21817a = bitmap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(Void r3) {
                if (c.this.f21816h == null || c.this.f21816h.k == null) {
                    return;
                }
                c.this.f21816h.k.a(true, c.this.K);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                try {
                    c.this.K = FileHelper.saveFileAsPic(d.b.i0.p3.c.f58893f, "pic_" + System.currentTimeMillis(), this.f21817a, 80, Bitmap.CompressFormat.JPEG);
                    return null;
                } finally {
                    Bitmap bitmap = this.f21817a;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f21817a.recycle();
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
                if (c.this.f21813e != null) {
                    c.this.f21813e.c(false);
                    c.this.f21813e = null;
                }
                if (c.this.f21814f != null) {
                    c.this.f21814f.c(false);
                    c.this.f21814f = null;
                }
                if (c.this.f21815g != null) {
                    c.this.f21815g.release();
                    c.this.f21815g = null;
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
        public class HandlerC0226c extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f21820a;

            public HandlerC0226c(Looper looper, Context context) {
                super(looper);
                this.f21820a = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                this.f21820a.get();
                super.handleMessage(message);
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
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
                            c.this.L.c(25, d.b.i0.s1.a.a(e2));
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
                            c.this.L.c(26, d.b.i0.s1.a.a(e3));
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
                    int i2 = c.this.o[1] != 0 ? c.this.o[1] : c.this.o[2];
                    double d2 = 270.0d;
                    if (c.this.F) {
                        c.this.n = faceunity.fuCreateItemFromPackage(bArr3);
                        c.this.o[2] = c.this.n;
                        c.this.m = 0;
                        c.this.o[1] = c.this.m;
                        faceunity.fuItemSetParam(c.this.n, "isAndroid", 1.0d);
                        int i3 = c.this.n;
                        if (!c.this.y()) {
                            d2 = 90.0d;
                        }
                        faceunity.fuItemSetParam(i3, "rotationAngle", d2);
                    } else {
                        c.this.m = faceunity.fuCreateItemFromPackage(bArr3);
                        c.this.o[1] = c.this.m;
                        c.this.n = 0;
                        c.this.o[2] = c.this.n;
                        faceunity.fuItemSetParam(c.this.m, "isAndroid", 1.0d);
                        int i4 = c.this.m;
                        if (!c.this.y()) {
                            d2 = 90.0d;
                        }
                        faceunity.fuItemSetParam(i4, "rotationAngle", d2);
                    }
                    if (i2 != 0) {
                        faceunity.fuDestroyItem(i2);
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    if (c.this.L != null) {
                        c.this.L.c(24, d.b.i0.s1.a.a(e4));
                    }
                }
            }
        }

        public c(Context context, GLVideoPreviewView gLVideoPreviewView, d.b.i0.s1.g gVar) {
            this.f21816h = gLVideoPreviewView;
            this.L = gVar;
            HandlerThread handlerThread = new HandlerThread("CreateItemThread");
            this.s = handlerThread;
            handlerThread.start();
            this.t = new HandlerC0226c(this.s.getLooper(), context);
            D(d.b.i0.p3.a.b(2));
        }

        public void A() {
            this.f21816h.queueEvent(new b());
        }

        public final void B(Bitmap bitmap) {
            this.K = null;
            if (bitmap != null && !bitmap.isRecycled()) {
                new a(bitmap).execute(new Void[0]);
                return;
            }
            GLVideoPreviewView gLVideoPreviewView = this.f21816h;
            if (gLVideoPreviewView == null || gLVideoPreviewView.k == null) {
                return;
            }
            this.f21816h.k.a(false, this.K);
        }

        public final void C() {
            GLVideoPreviewView gLVideoPreviewView = this.f21816h;
            if (gLVideoPreviewView != null) {
                Handler mainHandler = gLVideoPreviewView.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                int i = this.n;
                if (i != 0) {
                    faceunity.fuItemSetParam(i, "rotationAngle", y() ? 270.0d : 90.0d);
                }
                int i2 = this.m;
                if (i2 != 0) {
                    faceunity.fuItemSetParam(i2, "rotationAngle", y() ? 270.0d : 90.0d);
                }
            }
        }

        public void D(d.b.i0.p3.a aVar) {
            if (aVar == null) {
                return;
            }
            this.w = aVar.f58875b;
            this.x = aVar.f58876c;
            this.y = aVar.f58877d;
            this.z = aVar.f58878e;
            this.A = aVar.f58879f;
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
            if (this.f21815g != null) {
                faceunity.fuOnCameraChange();
                this.f21815g.release();
            }
            this.f21815g = new SurfaceTexture(this.k);
            C();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (this.J) {
                return;
            }
            int i = this.q + 1;
            this.q = i;
            if (i == 100) {
                this.q = 0;
                System.currentTimeMillis();
                this.r = 0L;
            }
            float[] fArr = new float[16];
            try {
                this.f21815g.updateTexImage();
                this.f21815g.getTransformMatrix(fArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.b.i0.s1.g gVar = this.L;
                if (gVar != null) {
                    gVar.c(22, d.b.i0.s1.a.a(e2));
                }
            }
            if (this.p) {
                this.p = false;
                this.t.sendEmptyMessage(1);
            }
            if (this.f21816h.f21811h != null) {
                this.f21816h.f21811h.onFaceIdentifyState(faceunity.fuIsTracking() > 0);
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
                int i2 = 1 | (this.f21816h.f21808e.l == 1 ? 0 : 32);
                if (this.F) {
                    faceunity.fuItemSetParam(this.n, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.n, "rotationAngle", y() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.m, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.m, "rotationAngle", y() ? 270.0d : 90.0d);
                }
                this.f21816h.f21808e.j();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr2 = this.E;
                int i3 = this.k;
                int i4 = this.i;
                int i5 = this.j;
                int i6 = this.D;
                this.D = i6 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr2, i3, i2, i4, i5, i6, this.o);
                this.r += System.currentTimeMillis() - currentTimeMillis;
                try {
                    this.f21813e.b(fuDualInputToTexture, fArr);
                    if (this.f21816h.l) {
                        z(gl10);
                        this.f21816h.l = false;
                    }
                    if (this.H != null && this.H.s(2) && this.f21816h.f21808e != null) {
                        this.I = this.f21816h.f21808e.o();
                        this.H.E(new d.c(new File(this.I), GLVideoPreviewView.n, GLVideoPreviewView.o, 2097152, null, this.f21815g.getTimestamp()));
                    }
                    if (this.H == null || !this.H.s(1)) {
                        return;
                    }
                    this.H.D(this.f21813e, fuDualInputToTexture, fArr);
                    if (GLVideoPreviewView.p) {
                        this.H.t(this.f21815g);
                    }
                    boolean unused = GLVideoPreviewView.p = true;
                    return;
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.f21816h.d(null);
                    d.b.i0.s1.g gVar2 = this.L;
                    if (gVar2 != null) {
                        gVar2.c(23, d.b.i0.s1.a.a(th));
                        return;
                    }
                    return;
                }
            }
            this.f21816h.requestRender();
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.E = bArr;
            this.f21816h.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.f21816h.i = i;
            this.f21816h.j = i2;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.f21813e = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            d.e.c.c cVar = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.f21814f = cVar;
            this.k = cVar.a();
            I();
            boolean unused = GLVideoPreviewView.p = false;
        }

        public boolean y() {
            return this.f21816h.f21808e.j();
        }

        public final void z(GL10 gl10) {
            Context context;
            Bitmap bitmap = null;
            try {
                System.gc();
                System.gc();
                int i = this.f21816h.i;
                int i2 = this.f21816h.j;
                int i3 = i * i2;
                int[] iArr = new int[i3];
                int[] iArr2 = new int[i3];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                gl10.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
                for (int i4 = 0; i4 < i2; i4++) {
                    int i5 = i4 * i;
                    int i6 = ((i2 - i4) - 1) * i;
                    for (int i7 = 0; i7 < i; i7++) {
                        int i8 = iArr[i5 + i7];
                        iArr2[i6 + i7] = (i8 & (-16711936)) | ((i8 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i8 >> 16) & 255);
                    }
                }
                bitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
            } catch (GLException unused) {
            } catch (OutOfMemoryError unused2) {
                GLVideoPreviewView gLVideoPreviewView = this.f21816h;
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
        this.f21808e = hVar;
        this.f21809f = new c(context, this, this.m);
        setEGLContextClientVersion(2);
        setRenderer(this.f21809f);
        setRenderMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        return this.f21808e.n();
    }

    @Override // d.b.i0.p3.m.g
    public void a(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewCallback(this.f21809f);
                camera.setPreviewTexture(this.f21809f.f21815g);
                this.f21809f.f21815g.setOnFrameAvailableListener(this.f21809f);
                camera.startPreview();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.b.i0.s1.g gVar = this.m;
                if (gVar != null) {
                    gVar.c(20, d.b.i0.s1.a.a(e2));
                }
            }
        }
    }

    @Override // d.b.i0.p3.m.g
    public void b(Camera camera) {
        try {
            d dVar = new d();
            this.f21810g = dVar;
            this.f21809f.F(dVar);
            p = false;
        } catch (Throwable th) {
            BdLog.e(th);
            d.b.i0.s1.g gVar = this.m;
            if (gVar != null) {
                gVar.c(21, d.b.i0.s1.a.a(th));
            }
        }
    }

    @Override // d.b.i0.p3.m.g
    public void c(Camera camera) {
        try {
            this.f21809f.A();
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.i0.s1.g gVar = this.m;
            if (gVar != null) {
                gVar.c(18, d.b.i0.s1.a.a(e2));
            }
        }
    }

    @Override // d.b.i0.p3.m.g
    public void d(Camera camera) {
        try {
            if (this.f21810g != null) {
                this.f21810g.F();
            }
        } catch (Throwable th) {
            BdLog.e(th);
            d.b.i0.s1.g gVar = this.m;
            if (gVar != null) {
                gVar.c(19, d.b.i0.s1.a.a(th));
            }
        }
    }

    @Override // d.b.i0.p3.m.g
    public void e(g.a aVar) {
        this.k = aVar;
        this.l = true;
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        c cVar = this.f21809f;
        if (cVar != null) {
            cVar.H();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h hVar = this.f21808e;
        if (hVar == null) {
            return false;
        }
        return hVar.w(motionEvent, getParent());
    }

    public void setBeautyLevel(d.b.i0.p3.a aVar) {
        c cVar = this.f21809f;
        if (cVar != null) {
            cVar.D(aVar);
        }
    }

    public void setFaceIdentifyStateListener(b bVar) {
        if (bVar != null) {
            this.f21811h = bVar;
        }
    }

    public void setFilter(String str) {
        c cVar = this.f21809f;
        if (cVar != null) {
            cVar.E(str);
        }
    }

    public void setIsChangingCamera(boolean z) {
        this.f21809f.J = z;
    }

    @Override // d.b.i0.p3.m.g
    public void setOnEncoderStatusUpdateListener(d.InterfaceC1805d interfaceC1805d) {
        d dVar = this.f21810g;
        if (dVar != null) {
            dVar.C(interfaceC1805d);
        }
    }

    @Override // d.b.i0.p3.m.g
    public void setPreviewSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        c cVar = this.f21809f;
        cVar.i = i;
        cVar.j = i2;
        int round = Math.round(n * ((i * 1.0f) / i2));
        if (round % 2 == 1) {
            round--;
        }
        if (o == 960) {
            o = round;
        }
    }

    public void setSticker(StickerItem stickerItem) {
        c cVar = this.f21809f;
        if (cVar != null) {
            cVar.G(stickerItem);
        }
    }

    public void t() {
        c cVar = this.f21809f;
        if (cVar != null) {
            cVar.E = null;
        }
    }

    public void u() {
        queueEvent(new a());
    }
}
