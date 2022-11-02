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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.cr7;
import com.baidu.tieba.gr7;
import com.baidu.tieba.nm;
import com.baidu.tieba.qy8;
import com.baidu.tieba.ry8;
import com.baidu.tieba.sy8;
import com.baidu.tieba.tw8;
import com.baidu.tieba.vw8;
import com.baidu.tieba.wq7;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.faceunity.encoder.TextureMovieEncoder;
import com.faceunity.gles.FullFrameRect;
import com.faceunity.gles.GeneratedTexture;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public class GLVideoPreviewView extends GLSurfaceView implements ry8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int j = 720;
    public static int k = 960;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public sy8 a;
    public c b;
    public TextureMovieEncoder c;
    public b d;
    public int e;
    public int f;
    public ry8.a g;
    public boolean h;
    public cr7 i;

    /* loaded from: classes6.dex */
    public interface b {
        void B0(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2141625816, "Lcom/baidu/tieba/video/record/GLVideoPreviewView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2141625816, "Lcom/baidu/tieba/video/record/GLVideoPreviewView;");
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements GLSurfaceView.Renderer, Camera.PreviewCallback, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] A;
        public boolean B;
        public boolean C;
        public boolean D;
        public TextureMovieEncoder E;
        public String F;
        public boolean G;
        public String H;
        public cr7 I;
        public FullFrameRect a;
        public FullFrameRect b;
        public volatile SurfaceTexture c;
        public GLVideoPreviewView d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int[] k;
        public boolean l;
        public int m;
        public long n;
        public HandlerThread o;
        public Handler p;
        public String q;
        public String r;
        public float s;
        public float t;
        public float u;
        public float v;
        public float w;
        public int x;
        public float y;
        public int z;

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, surfaceTexture) == null) {
            }
        }

        /* loaded from: classes6.dex */
        public class a extends BdAsyncTask<Void, Void, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ c b;

            public a(c cVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = bitmap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(Void r5) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, r5) == null) && this.b.d != null && this.b.d.g != null) {
                    this.b.d.g.a(true, this.b.H);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Context context;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                    Bitmap bitmap = this.a;
                    try {
                        String str = "pic_" + System.currentTimeMillis();
                        if (this.b.d.getContext() != null) {
                            bitmap = BitmapHelper.getClipBitmap(bitmap, (xi.j(context) * 1.0f) / xi.l(context));
                        }
                        this.b.H = FileHelper.saveFileAsPic(vw8.i, str, bitmap, 80, Bitmap.CompressFormat.JPEG);
                        return null;
                    } finally {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                }
                return (Void) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.a != null) {
                        this.a.a.release(false);
                        this.a.a = null;
                    }
                    if (this.a.b != null) {
                        this.a.b.release(false);
                        this.a.b = null;
                    }
                    if (this.a.c != null) {
                        this.a.c.release();
                        this.a.c = null;
                    }
                    try {
                        faceunity.fuDestroyItem(this.a.i);
                        int[] iArr = this.a.k;
                        this.a.i = 0;
                        iArr[1] = 0;
                        faceunity.fuDestroyItem(this.a.h);
                        int[] iArr2 = this.a.k;
                        this.a.h = 0;
                        iArr2[0] = 0;
                        faceunity.fuOnDeviceLost();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    this.a.A = null;
                    this.a.l = true;
                }
            }
        }

        /* renamed from: com.baidu.tieba.video.record.GLVideoPreviewView$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC0446c extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<Context> a;
            public final /* synthetic */ c b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC0446c(c cVar, Looper looper, Context context) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i;
                byte[] bArr;
                byte[] bArr2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    this.a.get();
                    super.handleMessage(message);
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            try {
                                String b = nm.b("v3.mp3");
                                File file = new File(b);
                                if (file.exists() && file.isFile()) {
                                    FileInputStream fileInputStream = new FileInputStream(b);
                                    bArr2 = new byte[fileInputStream.available()];
                                    fileInputStream.read(bArr2);
                                    fileInputStream.close();
                                } else {
                                    bArr2 = new byte[1];
                                }
                                faceunity.fuSetup(bArr2, null, qy8.a());
                                this.b.C = true;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                if (this.b.I != null) {
                                    this.b.I.b(25, wq7.a(th));
                                }
                            }
                            try {
                                String b2 = nm.b("face_beautification.mp3");
                                File file2 = new File(b2);
                                if (file2.exists() && file2.isFile()) {
                                    FileInputStream fileInputStream2 = new FileInputStream(b2);
                                    bArr = new byte[fileInputStream2.available()];
                                    fileInputStream2.read(bArr);
                                    fileInputStream2.close();
                                } else {
                                    bArr = new byte[1];
                                }
                                this.b.h = faceunity.fuCreateItemFromPackage(bArr);
                                this.b.k[0] = this.b.h;
                                this.b.C = true;
                                return;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                if (this.b.I != null) {
                                    this.b.I.b(26, wq7.a(th2));
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (StringUtils.isNull(this.b.q)) {
                            int[] iArr = this.b.k;
                            this.b.i = 0;
                            iArr[1] = 0;
                            int[] iArr2 = this.b.k;
                            this.b.j = 0;
                            iArr2[2] = 0;
                            return;
                        }
                        FileInputStream fileInputStream3 = new FileInputStream(new File(this.b.q));
                        byte[] bArr3 = new byte[fileInputStream3.available()];
                        fileInputStream3.read(bArr3);
                        fileInputStream3.close();
                        if (this.b.k[1] != 0) {
                            i = this.b.k[1];
                        } else {
                            i = this.b.k[2];
                        }
                        double d = 270.0d;
                        if (this.b.B) {
                            this.b.j = faceunity.fuCreateItemFromPackage(bArr3);
                            this.b.k[2] = this.b.j;
                            this.b.i = 0;
                            this.b.k[1] = this.b.i;
                            faceunity.fuItemSetParam(this.b.j, "isAndroid", 1.0d);
                            int i3 = this.b.j;
                            if (!this.b.y()) {
                                d = 90.0d;
                            }
                            faceunity.fuItemSetParam(i3, "rotationAngle", d);
                        } else {
                            this.b.i = faceunity.fuCreateItemFromPackage(bArr3);
                            this.b.k[1] = this.b.i;
                            this.b.j = 0;
                            this.b.k[2] = this.b.j;
                            faceunity.fuItemSetParam(this.b.i, "isAndroid", 1.0d);
                            int i4 = this.b.i;
                            if (!this.b.y()) {
                                d = 90.0d;
                            }
                            faceunity.fuItemSetParam(i4, "rotationAngle", d);
                        }
                        if (i != 0) {
                            faceunity.fuDestroyItem(i);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        if (this.b.I != null) {
                            this.b.I.b(24, wq7.a(th3));
                        }
                    }
                }
            }
        }

        public c(Context context, GLVideoPreviewView gLVideoPreviewView, cr7 cr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, gLVideoPreviewView, cr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = 720;
            this.f = 960;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = new int[]{0, 0, 0};
            this.l = true;
            this.m = 0;
            this.n = 0L;
            this.q = "";
            this.r = "origin";
            this.x = 3;
            this.y = 0.5f;
            this.z = 0;
            this.d = gLVideoPreviewView;
            this.I = cr7Var;
            this.D = new File(nm.b("libnama.so")).exists();
            HandlerThread handlerThread = new HandlerThread("CreateItemThread");
            this.o = handlerThread;
            handlerThread.start();
            this.p = new HandlerC0446c(this, this.o.getLooper(), context);
            D(tw8.b(2));
        }

        public void D(tw8 tw8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, tw8Var) != null) || tw8Var == null) {
                return;
            }
            this.s = tw8Var.b;
            this.t = tw8Var.c;
            this.u = tw8Var.d;
            this.v = tw8Var.e;
            this.w = tw8Var.f;
        }

        public void E(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.r = str;
        }

        public void F(TextureMovieEncoder textureMovieEncoder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, textureMovieEncoder) == null) && textureMovieEncoder != null) {
                this.E = textureMovieEncoder;
            }
        }

        public void G(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, stickerItem) == null) {
                if (stickerItem != null) {
                    this.q = stickerItem.localPath;
                    if (StringUtils.isNull(stickerItem.desc)) {
                        this.B = false;
                    } else {
                        this.B = true;
                    }
                } else {
                    this.q = null;
                }
                this.p.sendEmptyMessage(1);
            }
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, bArr, camera) == null) {
                this.A = bArr;
                this.d.requestRender();
            }
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.queueEvent(new b(this));
            }
        }

        public final void H() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.p.sendEmptyMessage(2);
            }
        }

        public void I() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !this.D) {
                return;
            }
            if (this.c != null) {
                faceunity.fuOnCameraChange();
                this.c.release();
            }
            this.c = new SurfaceTexture(this.g);
            C();
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.d.a.j();
            }
            return invokeV.booleanValue;
        }

        public final void B(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.H = null;
                if (bitmap != null && !bitmap.isRecycled()) {
                    new a(this, bitmap).execute(new Void[0]);
                    return;
                }
                GLVideoPreviewView gLVideoPreviewView = this.d;
                if (gLVideoPreviewView != null && gLVideoPreviewView.g != null) {
                    this.d.g.a(false, this.H);
                }
            }
        }

        public final void C() {
            GLVideoPreviewView gLVideoPreviewView;
            double d;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.D && (gLVideoPreviewView = this.d) != null) {
                Handler mainHandler = gLVideoPreviewView.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                int i = this.j;
                double d2 = 270.0d;
                if (i != 0) {
                    if (y()) {
                        d = 270.0d;
                    } else {
                        d = 90.0d;
                    }
                    faceunity.fuItemSetParam(i, "rotationAngle", d);
                }
                int i2 = this.i;
                if (i2 != 0) {
                    if (!y()) {
                        d2 = 90.0d;
                    }
                    faceunity.fuItemSetParam(i2, "rotationAngle", d2);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, gl10) == null) && this.D && this.C && !this.G) {
                int i2 = this.m + 1;
                this.m = i2;
                if (i2 == 100) {
                    this.m = 0;
                    System.currentTimeMillis();
                    this.n = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.c.updateTexImage();
                    this.c.getTransformMatrix(fArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    cr7 cr7Var = this.I;
                    if (cr7Var != null) {
                        cr7Var.b(22, wq7.a(e));
                    }
                }
                if (this.l) {
                    this.l = false;
                    this.p.sendEmptyMessage(1);
                }
                if (this.d.d != null) {
                    int fuIsTracking = faceunity.fuIsTracking();
                    b bVar = this.d.d;
                    if (fuIsTracking > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar.B0(z);
                }
                faceunity.fuItemSetParam(this.h, "color_level", this.s);
                faceunity.fuItemSetParam(this.h, "blur_level", this.t);
                faceunity.fuItemSetParam(this.h, TbFileVideoActivityConfig.FILTER_NAME, this.r);
                faceunity.fuItemSetParam(this.h, "cheek_thinning", this.u);
                faceunity.fuItemSetParam(this.h, "eye_enlarging", this.v);
                faceunity.fuItemSetParam(this.h, "face_shape", this.x);
                faceunity.fuItemSetParam(this.h, "face_shape_level", this.y);
                faceunity.fuItemSetParam(this.h, "red_level", this.w);
                faceunity.fuItemSetParam(this.h, "eye_bright", 0.0d);
                faceunity.fuItemSetParam(this.h, "tooth_whiten", 0.0d);
                byte[] bArr = this.A;
                if (bArr != null && bArr.length != 0 && this.C) {
                    if (this.d.a.l == 1) {
                        i = 0;
                    } else {
                        i = 32;
                    }
                    int i3 = 1 | i;
                    double d = 270.0d;
                    if (this.B) {
                        faceunity.fuItemSetParam(this.j, "isAndroid", 1.0d);
                        int i4 = this.j;
                        if (!y()) {
                            d = 90.0d;
                        }
                        faceunity.fuItemSetParam(i4, "rotationAngle", d);
                    } else {
                        faceunity.fuItemSetParam(this.i, "isAndroid", 1.0d);
                        int i5 = this.i;
                        if (!y()) {
                            d = 90.0d;
                        }
                        faceunity.fuItemSetParam(i5, "rotationAngle", d);
                    }
                    this.d.a.j();
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] bArr2 = this.A;
                    int i6 = this.g;
                    int i7 = this.e;
                    int i8 = this.f;
                    int i9 = this.z;
                    this.z = i9 + 1;
                    int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr2, i6, i3, i7, i8, i9, this.k);
                    this.n += System.currentTimeMillis() - currentTimeMillis;
                    try {
                        this.a.drawFrame(fuDualInputToTexture, fArr);
                        if (this.d.h) {
                            z(gl10);
                            this.d.h = false;
                        }
                        if (this.E != null && this.E.checkRecordingStatus(2) && this.d.a != null) {
                            this.F = this.d.a.o();
                            this.E.startRecording(new TextureMovieEncoder.EncoderConfig(new File(this.F), GLVideoPreviewView.j, GLVideoPreviewView.k, 2097152, null, this.c.getTimestamp()));
                        }
                        if (this.E != null && this.E.checkRecordingStatus(1)) {
                            this.E.setTextureId(this.a, fuDualInputToTexture, fArr);
                            if (GLVideoPreviewView.l) {
                                this.E.frameAvailable(this.c);
                            }
                            boolean unused = GLVideoPreviewView.l = true;
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        this.d.e(null);
                        cr7 cr7Var2 = this.I;
                        if (cr7Var2 != null) {
                            cr7Var2.b(23, wq7.a(th));
                            return;
                        }
                        return;
                    }
                }
                this.d.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048588, this, gl10, i, i2) == null) {
                this.d.e = i;
                this.d.f = i2;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, gl10, eGLConfig) == null) {
                this.a = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.b = fullFrameRect;
                this.g = fullFrameRect.createTextureObject();
                I();
                boolean unused = GLVideoPreviewView.l = false;
            }
        }

        public final void z(GL10 gl10) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, gl10) == null) {
                Bitmap bitmap = null;
                try {
                    System.gc();
                    System.gc();
                    int i = this.d.e;
                    int i2 = this.d.f;
                    int i3 = i * i2;
                    int[] iArr = new int[i3];
                    int[] iArr2 = new int[i3];
                    IntBuffer wrap = IntBuffer.wrap(iArr);
                    wrap.position(0);
                    gl10.glReadPixels(0, 0, i, i2, GeneratedTexture.FORMAT, 5121, wrap);
                    for (int i4 = 0; i4 < i2; i4++) {
                        int i5 = i4 * i;
                        int i6 = ((i2 - i4) - 1) * i;
                        for (int i7 = 0; i7 < i; i7++) {
                            int i8 = iArr[i5 + i7];
                            iArr2[i6 + i7] = (i8 & DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK) | ((i8 << 16) & 16711680) | ((i8 >> 16) & 255);
                        }
                    }
                    bitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
                } catch (GLException unused) {
                } catch (OutOfMemoryError unused2) {
                    GLVideoPreviewView gLVideoPreviewView = this.d;
                    if (gLVideoPreviewView != null && (context = gLVideoPreviewView.getContext()) != null && (context instanceof Activity)) {
                        ((Activity) context).finish();
                    }
                    System.gc();
                    System.gc();
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    B(bitmap);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GLVideoPreviewView a;

        public a(GLVideoPreviewView gLVideoPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLVideoPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gLVideoPreviewView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.I();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLVideoPreviewView(Context context, sy8 sy8Var) {
        super(context);
        gr7 gr7Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sy8Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, gr7.class);
        if (runTask != null) {
            gr7Var = (gr7) runTask.getData();
        } else {
            gr7Var = null;
        }
        if (gr7Var != null) {
            this.i = gr7Var.get();
        }
        this.a = sy8Var;
        this.b = new c(context, this, this.i);
        setEGLContextClientVersion(2);
        setRenderer(this.b);
        setRenderMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return this.a.n();
        }
        return (Handler) invokeV.objValue;
    }

    public void A() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (cVar = this.b) == null) {
            return;
        }
        cVar.A = null;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            queueEvent(new a(this));
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            c cVar = this.b;
            if (cVar != null) {
                cVar.H();
            }
        }
    }

    @Override // com.baidu.tieba.ry8
    public void b(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, camera) == null) {
            try {
                this.b.A();
            } catch (Exception e) {
                e.printStackTrace();
                cr7 cr7Var = this.i;
                if (cr7Var != null) {
                    cr7Var.b(18, wq7.a(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ry8
    public void c(ry8.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.g = aVar;
            this.h = true;
            requestRender();
        }
    }

    @Override // com.baidu.tieba.ry8
    public void d(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, camera) == null) {
            try {
                TextureMovieEncoder textureMovieEncoder = new TextureMovieEncoder();
                this.c = textureMovieEncoder;
                this.b.F(textureMovieEncoder);
                l = false;
            } catch (Throwable th) {
                BdLog.e(th);
                cr7 cr7Var = this.i;
                if (cr7Var != null) {
                    cr7Var.b(21, wq7.a(th));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ry8
    public void e(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, camera) == null) {
            try {
                if (this.c != null) {
                    this.c.stopRecording();
                }
            } catch (Throwable th) {
                BdLog.e(th);
                cr7 cr7Var = this.i;
                if (cr7Var != null) {
                    cr7Var.b(19, wq7.a(th));
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            sy8 sy8Var = this.a;
            if (sy8Var == null) {
                return false;
            }
            return sy8Var.w(motionEvent, getParent());
        }
        return invokeL.booleanValue;
    }

    public void setBeautyLevel(tw8 tw8Var) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, tw8Var) == null) && (cVar = this.b) != null) {
            cVar.D(tw8Var);
        }
    }

    public void setFaceIdentifyStateListener(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) && bVar != null) {
            this.d = bVar;
        }
    }

    public void setFilter(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (cVar = this.b) != null) {
            cVar.E(str);
        }
    }

    public void setIsChangingCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.b.G = z;
        }
    }

    @Override // com.baidu.tieba.ry8
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        TextureMovieEncoder textureMovieEncoder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, onEncoderStatusUpdateListener) == null) && (textureMovieEncoder = this.c) != null) {
            textureMovieEncoder.setOnEncoderStatusUpdateListener(onEncoderStatusUpdateListener);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, stickerItem) == null) && (cVar = this.b) != null) {
            cVar.G(stickerItem);
        }
    }

    @Override // com.baidu.tieba.ry8
    public void a(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, camera) == null) && camera != null) {
            try {
                camera.setPreviewCallback(this.b);
                camera.setPreviewTexture(this.b.c);
                this.b.c.setOnFrameAvailableListener(this.b);
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                cr7 cr7Var = this.i;
                if (cr7Var != null) {
                    cr7Var.b(20, wq7.a(e));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ry8
    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) && i > 0 && i2 > 0) {
            c cVar = this.b;
            cVar.e = i;
            cVar.f = i2;
            int round = Math.round(j * ((i * 1.0f) / i2));
            if (round % 2 == 1) {
                round--;
            }
            if (k == 960) {
                k = round;
            }
        }
    }
}
