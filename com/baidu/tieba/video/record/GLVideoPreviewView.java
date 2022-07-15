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
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.TextureMovieEncoder;
import com.faceunity.gles.FullFrameRect;
import com.faceunity.gles.GeneratedTexture;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import com.repackage.el7;
import com.repackage.em;
import com.repackage.kl7;
import com.repackage.ol7;
import com.repackage.tr8;
import com.repackage.ur8;
import com.repackage.vr8;
import com.repackage.wp8;
import com.repackage.yp8;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes4.dex */
public class GLVideoPreviewView extends GLSurfaceView implements ur8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int j = 720;
    public static int k = 960;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public vr8 a;
    public c b;
    public TextureMovieEncoder c;
    public b d;
    public int e;
    public int f;
    public ur8.a g;
    public boolean h;
    public kl7 i;

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.I();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void D0(boolean z);
    }

    /* loaded from: classes4.dex */
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
        public kl7 I;
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

        /* loaded from: classes4.dex */
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || this.b.d == null || this.b.d.g == null) {
                    return;
                }
                this.b.d.g.a(true, this.b.H);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                    try {
                        this.b.H = FileHelper.saveFileAsPic(yp8.i, "pic_" + System.currentTimeMillis(), this.a, 80, Bitmap.CompressFormat.JPEG);
                        return null;
                    } finally {
                        Bitmap bitmap = this.a;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            this.a.recycle();
                        }
                    }
                }
                return (Void) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public class HandlerC0243c extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<Context> a;
            public final /* synthetic */ c b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC0243c(c cVar, Looper looper, Context context) {
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
                byte[] bArr;
                byte[] bArr2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    this.a.get();
                    super.handleMessage(message);
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            return;
                        }
                        try {
                            String b = em.b("v3.mp3");
                            File file = new File(b);
                            if (file.exists() && file.isFile()) {
                                FileInputStream fileInputStream = new FileInputStream(b);
                                bArr2 = new byte[fileInputStream.available()];
                                fileInputStream.read(bArr2);
                                fileInputStream.close();
                            } else {
                                bArr2 = new byte[1];
                            }
                            faceunity.fuSetup(bArr2, null, tr8.a());
                            this.b.C = true;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            if (this.b.I != null) {
                                this.b.I.b(25, el7.a(th));
                            }
                        }
                        try {
                            String b2 = em.b("face_beautification.mp3");
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
                                this.b.I.b(26, el7.a(th2));
                                return;
                            }
                            return;
                        }
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
                        int i2 = this.b.k[1] != 0 ? this.b.k[1] : this.b.k[2];
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
                        if (i2 != 0) {
                            faceunity.fuDestroyItem(i2);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        if (this.b.I != null) {
                            this.b.I.b(24, el7.a(th3));
                        }
                    }
                }
            }
        }

        public c(Context context, GLVideoPreviewView gLVideoPreviewView, kl7 kl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, gLVideoPreviewView, kl7Var};
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
            this.I = kl7Var;
            this.D = new File(em.b("libnama.so")).exists();
            HandlerThread handlerThread = new HandlerThread("CreateItemThread");
            this.o = handlerThread;
            handlerThread.start();
            this.p = new HandlerC0243c(this, this.o.getLooper(), context);
            D(wp8.b(2));
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.queueEvent(new b(this));
            }
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
                if (gLVideoPreviewView == null || gLVideoPreviewView.g == null) {
                    return;
                }
                this.d.g.a(false, this.H);
            }
        }

        public final void C() {
            GLVideoPreviewView gLVideoPreviewView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.D && (gLVideoPreviewView = this.d) != null) {
                Handler mainHandler = gLVideoPreviewView.getMainHandler();
                mainHandler.sendMessage(mainHandler.obtainMessage(1));
                int i = this.j;
                if (i != 0) {
                    faceunity.fuItemSetParam(i, "rotationAngle", y() ? 270.0d : 90.0d);
                }
                int i2 = this.i;
                if (i2 != 0) {
                    faceunity.fuItemSetParam(i2, "rotationAngle", y() ? 270.0d : 90.0d);
                }
            }
        }

        public void D(wp8 wp8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, wp8Var) == null) || wp8Var == null) {
                return;
            }
            this.s = wp8Var.b;
            this.t = wp8Var.c;
            this.u = wp8Var.d;
            this.v = wp8Var.e;
            this.w = wp8Var.f;
        }

        public void E(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.r = str;
        }

        public void F(TextureMovieEncoder textureMovieEncoder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, textureMovieEncoder) == null) || textureMovieEncoder == null) {
                return;
            }
            this.E = textureMovieEncoder;
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

        public final void H() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.p.sendEmptyMessage(2);
            }
        }

        public void I() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.D) {
                if (this.c != null) {
                    faceunity.fuOnCameraChange();
                    this.c.release();
                }
                this.c = new SurfaceTexture(this.g);
                C();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, gl10) == null) && this.D && this.C && !this.G) {
                int i = this.m + 1;
                this.m = i;
                if (i == 100) {
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
                    kl7 kl7Var = this.I;
                    if (kl7Var != null) {
                        kl7Var.b(22, el7.a(e));
                    }
                }
                if (this.l) {
                    this.l = false;
                    this.p.sendEmptyMessage(1);
                }
                if (this.d.d != null) {
                    this.d.d.D0(faceunity.fuIsTracking() > 0);
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
                    int i2 = 1 | (this.d.a.l == 1 ? 0 : 32);
                    if (this.B) {
                        faceunity.fuItemSetParam(this.j, "isAndroid", 1.0d);
                        faceunity.fuItemSetParam(this.j, "rotationAngle", y() ? 270.0d : 90.0d);
                    } else {
                        faceunity.fuItemSetParam(this.i, "isAndroid", 1.0d);
                        faceunity.fuItemSetParam(this.i, "rotationAngle", y() ? 270.0d : 90.0d);
                    }
                    this.d.a.j();
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] bArr2 = this.A;
                    int i3 = this.g;
                    int i4 = this.e;
                    int i5 = this.f;
                    int i6 = this.z;
                    this.z = i6 + 1;
                    int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr2, i3, i2, i4, i5, i6, this.k);
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
                        if (this.E == null || !this.E.checkRecordingStatus(1)) {
                            return;
                        }
                        this.E.setTextureId(this.a, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.l) {
                            this.E.frameAvailable(this.c);
                        }
                        boolean unused = GLVideoPreviewView.l = true;
                        return;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        this.d.e(null);
                        kl7 kl7Var2 = this.I;
                        if (kl7Var2 != null) {
                            kl7Var2.b(23, el7.a(th));
                            return;
                        }
                        return;
                    }
                }
                this.d.requestRender();
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, surfaceTexture) == null) {
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

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.d.a.j() : invokeV.booleanValue;
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
                            iArr2[i6 + i7] = (i8 & (-16711936)) | ((i8 << 16) & 16711680) | ((i8 >> 16) & 255);
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
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                B(bitmap);
            }
        }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLVideoPreviewView(Context context, vr8 vr8Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vr8Var};
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, ol7.class);
        ol7 ol7Var = runTask != null ? (ol7) runTask.getData() : null;
        if (ol7Var != null) {
            this.i = ol7Var.get();
        }
        this.a = vr8Var;
        this.b = new c(context, this, this.i);
        setEGLContextClientVersion(2);
        setRenderer(this.b);
        setRenderMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.a.n() : (Handler) invokeV.objValue;
    }

    @Override // com.repackage.ur8
    public void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, camera) == null) || camera == null) {
            return;
        }
        try {
            camera.setPreviewCallback(this.b);
            camera.setPreviewTexture(this.b.c);
            this.b.c.setOnFrameAvailableListener(this.b);
            camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
            kl7 kl7Var = this.i;
            if (kl7Var != null) {
                kl7Var.b(20, el7.a(e));
            }
        }
    }

    @Override // com.repackage.ur8
    public void b(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, camera) == null) {
            try {
                this.b.A();
            } catch (Exception e) {
                e.printStackTrace();
                kl7 kl7Var = this.i;
                if (kl7Var != null) {
                    kl7Var.b(18, el7.a(e));
                }
            }
        }
    }

    @Override // com.repackage.ur8
    public void c(ur8.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.g = aVar;
            this.h = true;
            requestRender();
        }
    }

    @Override // com.repackage.ur8
    public void d(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, camera) == null) {
            try {
                TextureMovieEncoder textureMovieEncoder = new TextureMovieEncoder();
                this.c = textureMovieEncoder;
                this.b.F(textureMovieEncoder);
                l = false;
            } catch (Throwable th) {
                BdLog.e(th);
                kl7 kl7Var = this.i;
                if (kl7Var != null) {
                    kl7Var.b(21, el7.a(th));
                }
            }
        }
    }

    @Override // com.repackage.ur8
    public void e(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, camera) == null) {
            try {
                if (this.c != null) {
                    this.c.stopRecording();
                }
            } catch (Throwable th) {
                BdLog.e(th);
                kl7 kl7Var = this.i;
                if (kl7Var != null) {
                    kl7Var.b(19, el7.a(th));
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            c cVar = this.b;
            if (cVar != null) {
                cVar.H();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            vr8 vr8Var = this.a;
            if (vr8Var == null) {
                return false;
            }
            return vr8Var.w(motionEvent, getParent());
        }
        return invokeL.booleanValue;
    }

    public void setBeautyLevel(wp8 wp8Var) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, wp8Var) == null) || (cVar = this.b) == null) {
            return;
        }
        cVar.D(wp8Var);
    }

    public void setFaceIdentifyStateListener(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.d = bVar;
    }

    public void setFilter(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (cVar = this.b) == null) {
            return;
        }
        cVar.E(str);
    }

    public void setIsChangingCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.b.G = z;
        }
    }

    @Override // com.repackage.ur8
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        TextureMovieEncoder textureMovieEncoder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onEncoderStatusUpdateListener) == null) || (textureMovieEncoder = this.c) == null) {
            return;
        }
        textureMovieEncoder.setOnEncoderStatusUpdateListener(onEncoderStatusUpdateListener);
    }

    @Override // com.repackage.ur8
    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) || i <= 0 || i2 <= 0) {
            return;
        }
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

    public void setSticker(StickerItem stickerItem) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, stickerItem) == null) || (cVar = this.b) == null) {
            return;
        }
        cVar.G(stickerItem);
    }

    public void t() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (cVar = this.b) == null) {
            return;
        }
        cVar.A = null;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            queueEvent(new a(this));
        }
    }
}
