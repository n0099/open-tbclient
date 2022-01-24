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
import c.a.d.l.i;
import c.a.t0.i2.g;
import c.a.t0.i2.k;
import c.a.t0.k4.l.e;
import c.a.t0.k4.l.f;
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
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes13.dex */
public class GLVideoPreviewView extends GLSurfaceView implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static int m = 720;
    public static int n = 960;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f48612e;

    /* renamed from: f  reason: collision with root package name */
    public TextureMovieEncoder f48613f;

    /* renamed from: g  reason: collision with root package name */
    public b f48614g;

    /* renamed from: h  reason: collision with root package name */
    public int f48615h;

    /* renamed from: i  reason: collision with root package name */
    public int f48616i;

    /* renamed from: j  reason: collision with root package name */
    public f.a f48617j;
    public boolean k;
    public g l;
    public c.a.t0.k4.l.g mPreviewController;

    /* loaded from: classes13.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GLVideoPreviewView f48618e;

        public a(GLVideoPreviewView gLVideoPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLVideoPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48618e = gLVideoPreviewView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48618e.f48612e == null) {
                return;
            }
            this.f48618e.f48612e.I();
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        void onFaceIdentifyState(boolean z);
    }

    /* loaded from: classes13.dex */
    public static class c implements GLSurfaceView.Renderer, Camera.PreviewCallback, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float A;
        public int B;
        public float C;
        public int D;
        public byte[] E;
        public boolean F;
        public boolean G;
        public boolean H;
        public TextureMovieEncoder I;
        public String J;
        public boolean K;
        public String L;
        public g M;

        /* renamed from: e  reason: collision with root package name */
        public FullFrameRect f48619e;

        /* renamed from: f  reason: collision with root package name */
        public FullFrameRect f48620f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SurfaceTexture f48621g;

        /* renamed from: h  reason: collision with root package name */
        public GLVideoPreviewView f48622h;

        /* renamed from: i  reason: collision with root package name */
        public int f48623i;

        /* renamed from: j  reason: collision with root package name */
        public int f48624j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int[] o;
        public boolean p;
        public int q;
        public long r;
        public HandlerThread s;
        public Handler t;
        public String u;
        public String v;
        public float w;
        public float x;
        public float y;
        public float z;

        /* loaded from: classes13.dex */
        public class a extends BdAsyncTask<Void, Void, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f48625b;

            public a(c cVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48625b = cVar;
                this.a = bitmap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(Void r5) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || this.f48625b.f48622h == null || this.f48625b.f48622h.f48617j == null) {
                    return;
                }
                this.f48625b.f48622h.f48617j.a(true, this.f48625b.L);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                    try {
                        this.f48625b.L = FileHelper.saveFileAsPic(c.a.t0.k4.c.f19035i, "pic_" + System.currentTimeMillis(), this.a, 80, Bitmap.CompressFormat.JPEG);
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

        /* loaded from: classes13.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f48626e;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48626e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f48626e.f48619e != null) {
                        this.f48626e.f48619e.release(false);
                        this.f48626e.f48619e = null;
                    }
                    if (this.f48626e.f48620f != null) {
                        this.f48626e.f48620f.release(false);
                        this.f48626e.f48620f = null;
                    }
                    if (this.f48626e.f48621g != null) {
                        this.f48626e.f48621g.release();
                        this.f48626e.f48621g = null;
                    }
                    try {
                        faceunity.fuDestroyItem(this.f48626e.m);
                        int[] iArr = this.f48626e.o;
                        this.f48626e.m = 0;
                        iArr[1] = 0;
                        faceunity.fuDestroyItem(this.f48626e.l);
                        int[] iArr2 = this.f48626e.o;
                        this.f48626e.l = 0;
                        iArr2[0] = 0;
                        faceunity.fuOnDeviceLost();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    this.f48626e.E = null;
                    this.f48626e.p = true;
                }
            }
        }

        /* renamed from: com.baidu.tieba.video.record.GLVideoPreviewView$c$c  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class HandlerC1965c extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<Context> a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f48627b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC1965c(c cVar, Looper looper, Context context) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48627b = cVar;
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
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return;
                        }
                        try {
                            String b2 = i.b("v3.mp3");
                            File file = new File(b2);
                            if (file.exists() && file.isFile()) {
                                FileInputStream fileInputStream = new FileInputStream(b2);
                                bArr2 = new byte[fileInputStream.available()];
                                fileInputStream.read(bArr2);
                                fileInputStream.close();
                            } else {
                                bArr2 = new byte[1];
                            }
                            faceunity.fuSetup(bArr2, null, e.a());
                            this.f48627b.G = true;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            if (this.f48627b.M != null) {
                                this.f48627b.M.b(25, c.a.t0.i2.a.a(th));
                            }
                        }
                        try {
                            String b3 = i.b("face_beautification.mp3");
                            File file2 = new File(b3);
                            if (file2.exists() && file2.isFile()) {
                                FileInputStream fileInputStream2 = new FileInputStream(b3);
                                bArr = new byte[fileInputStream2.available()];
                                fileInputStream2.read(bArr);
                                fileInputStream2.close();
                            } else {
                                bArr = new byte[1];
                            }
                            this.f48627b.l = faceunity.fuCreateItemFromPackage(bArr);
                            this.f48627b.o[0] = this.f48627b.l;
                            this.f48627b.G = true;
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            if (this.f48627b.M != null) {
                                this.f48627b.M.b(26, c.a.t0.i2.a.a(th2));
                                return;
                            }
                            return;
                        }
                    }
                    try {
                        if (StringUtils.isNull(this.f48627b.u)) {
                            int[] iArr = this.f48627b.o;
                            this.f48627b.m = 0;
                            iArr[1] = 0;
                            int[] iArr2 = this.f48627b.o;
                            this.f48627b.n = 0;
                            iArr2[2] = 0;
                            return;
                        }
                        FileInputStream fileInputStream3 = new FileInputStream(new File(this.f48627b.u));
                        byte[] bArr3 = new byte[fileInputStream3.available()];
                        fileInputStream3.read(bArr3);
                        fileInputStream3.close();
                        int i3 = this.f48627b.o[1] != 0 ? this.f48627b.o[1] : this.f48627b.o[2];
                        double d2 = 270.0d;
                        if (this.f48627b.F) {
                            this.f48627b.n = faceunity.fuCreateItemFromPackage(bArr3);
                            this.f48627b.o[2] = this.f48627b.n;
                            this.f48627b.m = 0;
                            this.f48627b.o[1] = this.f48627b.m;
                            faceunity.fuItemSetParam(this.f48627b.n, "isAndroid", 1.0d);
                            int i4 = this.f48627b.n;
                            if (!this.f48627b.y()) {
                                d2 = 90.0d;
                            }
                            faceunity.fuItemSetParam(i4, "rotationAngle", d2);
                        } else {
                            this.f48627b.m = faceunity.fuCreateItemFromPackage(bArr3);
                            this.f48627b.o[1] = this.f48627b.m;
                            this.f48627b.n = 0;
                            this.f48627b.o[2] = this.f48627b.n;
                            faceunity.fuItemSetParam(this.f48627b.m, "isAndroid", 1.0d);
                            int i5 = this.f48627b.m;
                            if (!this.f48627b.y()) {
                                d2 = 90.0d;
                            }
                            faceunity.fuItemSetParam(i5, "rotationAngle", d2);
                        }
                        if (i3 != 0) {
                            faceunity.fuDestroyItem(i3);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        if (this.f48627b.M != null) {
                            this.f48627b.M.b(24, c.a.t0.i2.a.a(th3));
                        }
                    }
                }
            }
        }

        public c(Context context, GLVideoPreviewView gLVideoPreviewView, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, gLVideoPreviewView, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48623i = 720;
            this.f48624j = 960;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = new int[]{0, 0, 0};
            this.p = true;
            this.q = 0;
            this.r = 0L;
            this.u = "";
            this.v = "origin";
            this.B = 3;
            this.C = 0.5f;
            this.D = 0;
            this.f48622h = gLVideoPreviewView;
            this.M = gVar;
            this.H = new File(i.b("libnama.so")).exists();
            HandlerThread handlerThread = new HandlerThread("CreateItemThread");
            this.s = handlerThread;
            handlerThread.start();
            this.t = new HandlerC1965c(this, this.s.getLooper(), context);
            D(c.a.t0.k4.a.b(2));
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48622h.queueEvent(new b(this));
            }
        }

        public final void B(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.L = null;
                if (bitmap != null && !bitmap.isRecycled()) {
                    new a(this, bitmap).execute(new Void[0]);
                    return;
                }
                GLVideoPreviewView gLVideoPreviewView = this.f48622h;
                if (gLVideoPreviewView == null || gLVideoPreviewView.f48617j == null) {
                    return;
                }
                this.f48622h.f48617j.a(false, this.L);
            }
        }

        public final void C() {
            GLVideoPreviewView gLVideoPreviewView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.H && (gLVideoPreviewView = this.f48622h) != null) {
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

        public void D(c.a.t0.k4.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.w = aVar.f19016b;
            this.x = aVar.f19017c;
            this.y = aVar.f19018d;
            this.z = aVar.f19019e;
            this.A = aVar.f19020f;
        }

        public void E(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.v = str;
        }

        public void F(TextureMovieEncoder textureMovieEncoder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, textureMovieEncoder) == null) || textureMovieEncoder == null) {
                return;
            }
            this.I = textureMovieEncoder;
        }

        public void G(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, stickerItem) == null) {
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
        }

        public final void H() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.t.sendEmptyMessage(2);
            }
        }

        public void I() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.H) {
                if (this.f48621g != null) {
                    faceunity.fuOnCameraChange();
                    this.f48621g.release();
                }
                this.f48621g = new SurfaceTexture(this.k);
                C();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, gl10) == null) && this.H && this.G && !this.K) {
                int i2 = this.q + 1;
                this.q = i2;
                if (i2 == 100) {
                    this.q = 0;
                    System.currentTimeMillis();
                    this.r = 0L;
                }
                float[] fArr = new float[16];
                try {
                    this.f48621g.updateTexImage();
                    this.f48621g.getTransformMatrix(fArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    g gVar = this.M;
                    if (gVar != null) {
                        gVar.b(22, c.a.t0.i2.a.a(e2));
                    }
                }
                if (this.p) {
                    this.p = false;
                    this.t.sendEmptyMessage(1);
                }
                if (this.f48622h.f48614g != null) {
                    this.f48622h.f48614g.onFaceIdentifyState(faceunity.fuIsTracking() > 0);
                }
                faceunity.fuItemSetParam(this.l, "color_level", this.w);
                faceunity.fuItemSetParam(this.l, "blur_level", this.x);
                faceunity.fuItemSetParam(this.l, TbFileVideoActivityConfig.FILTER_NAME, this.v);
                faceunity.fuItemSetParam(this.l, "cheek_thinning", this.y);
                faceunity.fuItemSetParam(this.l, "eye_enlarging", this.z);
                faceunity.fuItemSetParam(this.l, "face_shape", this.B);
                faceunity.fuItemSetParam(this.l, "face_shape_level", this.C);
                faceunity.fuItemSetParam(this.l, "red_level", this.A);
                faceunity.fuItemSetParam(this.l, "eye_bright", 0.0d);
                faceunity.fuItemSetParam(this.l, "tooth_whiten", 0.0d);
                byte[] bArr = this.E;
                if (bArr != null && bArr.length != 0 && this.G) {
                    int i3 = 1 | (this.f48622h.mPreviewController.l == 1 ? 0 : 32);
                    if (this.F) {
                        faceunity.fuItemSetParam(this.n, "isAndroid", 1.0d);
                        faceunity.fuItemSetParam(this.n, "rotationAngle", y() ? 270.0d : 90.0d);
                    } else {
                        faceunity.fuItemSetParam(this.m, "isAndroid", 1.0d);
                        faceunity.fuItemSetParam(this.m, "rotationAngle", y() ? 270.0d : 90.0d);
                    }
                    this.f48622h.mPreviewController.j();
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] bArr2 = this.E;
                    int i4 = this.k;
                    int i5 = this.f48623i;
                    int i6 = this.f48624j;
                    int i7 = this.D;
                    this.D = i7 + 1;
                    int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr2, i4, i3, i5, i6, i7, this.o);
                    this.r += System.currentTimeMillis() - currentTimeMillis;
                    try {
                        this.f48619e.drawFrame(fuDualInputToTexture, fArr);
                        if (this.f48622h.k) {
                            z(gl10);
                            this.f48622h.k = false;
                        }
                        if (this.I != null && this.I.checkRecordingStatus(2) && this.f48622h.mPreviewController != null) {
                            this.J = this.f48622h.mPreviewController.o();
                            this.I.startRecording(new TextureMovieEncoder.EncoderConfig(new File(this.J), GLVideoPreviewView.m, GLVideoPreviewView.n, 2097152, null, this.f48621g.getTimestamp()));
                        }
                        if (this.I == null || !this.I.checkRecordingStatus(1)) {
                            return;
                        }
                        this.I.setTextureId(this.f48619e, fuDualInputToTexture, fArr);
                        if (GLVideoPreviewView.o) {
                            this.I.frameAvailable(this.f48621g);
                        }
                        boolean unused = GLVideoPreviewView.o = true;
                        return;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        this.f48622h.stopRecord(null);
                        g gVar2 = this.M;
                        if (gVar2 != null) {
                            gVar2.b(23, c.a.t0.i2.a.a(th));
                            return;
                        }
                        return;
                    }
                }
                this.f48622h.requestRender();
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
                this.E = bArr;
                this.f48622h.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048588, this, gl10, i2, i3) == null) {
                this.f48622h.f48615h = i2;
                this.f48622h.f48616i = i3;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, gl10, eGLConfig) == null) {
                this.f48619e = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.f48620f = fullFrameRect;
                this.k = fullFrameRect.createTextureObject();
                I();
                boolean unused = GLVideoPreviewView.o = false;
            }
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f48622h.mPreviewController.j() : invokeV.booleanValue;
        }

        public final void z(GL10 gl10) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, gl10) == null) {
                Bitmap bitmap = null;
                try {
                    System.gc();
                    System.gc();
                    int i2 = this.f48622h.f48615h;
                    int i3 = this.f48622h.f48616i;
                    int i4 = i2 * i3;
                    int[] iArr = new int[i4];
                    int[] iArr2 = new int[i4];
                    IntBuffer wrap = IntBuffer.wrap(iArr);
                    wrap.position(0);
                    gl10.glReadPixels(0, 0, i2, i3, GeneratedTexture.FORMAT, 5121, wrap);
                    for (int i5 = 0; i5 < i3; i5++) {
                        int i6 = i5 * i2;
                        int i7 = ((i3 - i5) - 1) * i2;
                        for (int i8 = 0; i8 < i2; i8++) {
                            int i9 = iArr[i6 + i8];
                            iArr2[i7 + i8] = (i9 & (-16711936)) | ((i9 << 16) & 16711680) | ((i9 >> 16) & 255);
                        }
                    }
                    bitmap = Bitmap.createBitmap(iArr2, i2, i3, Bitmap.Config.ARGB_8888);
                } catch (GLException unused) {
                } catch (OutOfMemoryError unused2) {
                    GLVideoPreviewView gLVideoPreviewView = this.f48622h;
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
    public GLVideoPreviewView(Context context, c.a.t0.k4.l.g gVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.mPreviewController = gVar;
        this.f48612e = new c(context, this, this.l);
        setEGLContextClientVersion(2);
        setRenderer(this.f48612e);
        setRenderMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.mPreviewController.n() : (Handler) invokeV.objValue;
    }

    public void clearNV21Data() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f48612e) == null) {
            return;
        }
        cVar.E = null;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onResume();
            c cVar = this.f48612e;
            if (cVar != null) {
                cVar.H();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            c.a.t0.k4.l.g gVar = this.mPreviewController;
            if (gVar == null) {
                return false;
            }
            return gVar.w(motionEvent, getParent());
        }
        return invokeL.booleanValue;
    }

    public void setBeautyLevel(c.a.t0.k4.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (cVar = this.f48612e) == null) {
            return;
        }
        cVar.D(aVar);
    }

    public void setFaceIdentifyStateListener(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f48614g = bVar;
    }

    public void setFilter(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (cVar = this.f48612e) == null) {
            return;
        }
        cVar.E(str);
    }

    public void setIsChangingCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f48612e.K = z;
        }
    }

    @Override // c.a.t0.k4.l.f
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        TextureMovieEncoder textureMovieEncoder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, onEncoderStatusUpdateListener) == null) || (textureMovieEncoder = this.f48613f) == null) {
            return;
        }
        textureMovieEncoder.setOnEncoderStatusUpdateListener(onEncoderStatusUpdateListener);
    }

    @Override // c.a.t0.k4.l.f
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        c cVar = this.f48612e;
        cVar.f48623i = i2;
        cVar.f48624j = i3;
        int round = Math.round(m * ((i2 * 1.0f) / i3));
        if (round % 2 == 1) {
            round--;
        }
        if (n == 960) {
            n = round;
        }
    }

    public void setSticker(StickerItem stickerItem) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, stickerItem) == null) || (cVar = this.f48612e) == null) {
            return;
        }
        cVar.G(stickerItem);
    }

    @Override // c.a.t0.k4.l.f
    public void startPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, camera) == null) || camera == null) {
            return;
        }
        try {
            camera.setPreviewCallback(this.f48612e);
            camera.setPreviewTexture(this.f48612e.f48621g);
            this.f48612e.f48621g.setOnFrameAvailableListener(this.f48612e);
            camera.startPreview();
        } catch (Exception e2) {
            e2.printStackTrace();
            g gVar = this.l;
            if (gVar != null) {
                gVar.b(20, c.a.t0.i2.a.a(e2));
            }
        }
    }

    @Override // c.a.t0.k4.l.f
    public void startRecord(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, camera) == null) {
            try {
                TextureMovieEncoder textureMovieEncoder = new TextureMovieEncoder();
                this.f48613f = textureMovieEncoder;
                this.f48612e.F(textureMovieEncoder);
                o = false;
            } catch (Throwable th) {
                BdLog.e(th);
                g gVar = this.l;
                if (gVar != null) {
                    gVar.b(21, c.a.t0.i2.a.a(th));
                }
            }
        }
    }

    @Override // c.a.t0.k4.l.f
    public void stopPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, camera) == null) {
            try {
                this.f48612e.A();
            } catch (Exception e2) {
                e2.printStackTrace();
                g gVar = this.l;
                if (gVar != null) {
                    gVar.b(18, c.a.t0.i2.a.a(e2));
                }
            }
        }
    }

    @Override // c.a.t0.k4.l.f
    public void stopRecord(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, camera) == null) {
            try {
                if (this.f48613f != null) {
                    this.f48613f.stopRecording();
                }
            } catch (Throwable th) {
                BdLog.e(th);
                g gVar = this.l;
                if (gVar != null) {
                    gVar.b(19, c.a.t0.i2.a.a(th));
                }
            }
        }
    }

    public void switchCameraSurfaceTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            queueEvent(new a(this));
        }
    }

    @Override // c.a.t0.k4.l.f
    public void takePicture(f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.f48617j = aVar;
            this.k = true;
            requestRender();
        }
    }
}
