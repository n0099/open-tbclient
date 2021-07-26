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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.faceunity.encoder.TextureMovieEncoder;
import com.faceunity.gles.FullFrameRect;
import com.faceunity.gles.GeneratedTexture;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import d.a.q0.v3.l.f;
import d.a.q0.v3.l.g;
import d.a.q0.v3.l.h;
import d.a.q0.x1.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes4.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    public static /* synthetic */ Interceptable $ic = null;
    public static int n = 720;
    public static int o = 960;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f21754e;

    /* renamed from: f  reason: collision with root package name */
    public c f21755f;

    /* renamed from: g  reason: collision with root package name */
    public TextureMovieEncoder f21756g;

    /* renamed from: h  reason: collision with root package name */
    public b f21757h;

    /* renamed from: i  reason: collision with root package name */
    public int f21758i;
    public int j;
    public g.a k;
    public boolean l;
    public d.a.q0.x1.g m;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GLVideoPreviewView f21759e;

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
            this.f21759e = gLVideoPreviewView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21759e.f21755f == null) {
                return;
            }
            this.f21759e.f21755f.I();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onFaceIdentifyState(boolean z);
    }

    /* loaded from: classes4.dex */
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
        public TextureMovieEncoder H;
        public String I;
        public boolean J;
        public String K;
        public d.a.q0.x1.g L;

        /* renamed from: e  reason: collision with root package name */
        public FullFrameRect f21760e;

        /* renamed from: f  reason: collision with root package name */
        public FullFrameRect f21761f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SurfaceTexture f21762g;

        /* renamed from: h  reason: collision with root package name */
        public GLVideoPreviewView f21763h;

        /* renamed from: i  reason: collision with root package name */
        public int f21764i;
        public int j;
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

        /* loaded from: classes4.dex */
        public class a extends BdAsyncTask<Void, Void, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Bitmap f21765a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f21766b;

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
                this.f21766b = cVar;
                this.f21765a = bitmap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(Void r5) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || this.f21766b.f21763h == null || this.f21766b.f21763h.k == null) {
                    return;
                }
                this.f21766b.f21763h.k.a(true, this.f21766b.K);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                    try {
                        this.f21766b.K = FileHelper.saveFileAsPic(d.a.q0.v3.c.f66026i, "pic_" + System.currentTimeMillis(), this.f21765a, 80, Bitmap.CompressFormat.JPEG);
                        return null;
                    } finally {
                        Bitmap bitmap = this.f21765a;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            this.f21765a.recycle();
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

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21767e;

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
                this.f21767e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f21767e.f21760e != null) {
                        this.f21767e.f21760e.release(false);
                        this.f21767e.f21760e = null;
                    }
                    if (this.f21767e.f21761f != null) {
                        this.f21767e.f21761f.release(false);
                        this.f21767e.f21761f = null;
                    }
                    if (this.f21767e.f21762g != null) {
                        this.f21767e.f21762g.release();
                        this.f21767e.f21762g = null;
                    }
                    faceunity.fuDestroyItem(this.f21767e.m);
                    int[] iArr = this.f21767e.o;
                    this.f21767e.m = 0;
                    iArr[1] = 0;
                    faceunity.fuDestroyItem(this.f21767e.l);
                    int[] iArr2 = this.f21767e.o;
                    this.f21767e.l = 0;
                    iArr2[0] = 0;
                    faceunity.fuOnDeviceLost();
                    this.f21767e.E = null;
                    this.f21767e.p = true;
                }
            }
        }

        /* renamed from: com.baidu.tieba.video.record.GLVideoPreviewView$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class HandlerC0243c extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f21768a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f21769b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC0243c(c cVar, Looper looper, Context context) {
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
                this.f21769b = cVar;
                this.f21768a = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    this.f21768a.get();
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
                            this.f21769b.G = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (this.f21769b.L != null) {
                                this.f21769b.L.b(25, d.a.q0.x1.a.a(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr2 = new byte[open2.available()];
                            open2.read(bArr2);
                            open2.close();
                            this.f21769b.l = faceunity.fuCreateItemFromPackage(bArr2);
                            this.f21769b.o[0] = this.f21769b.l;
                            this.f21769b.G = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (this.f21769b.L != null) {
                                this.f21769b.L.b(26, d.a.q0.x1.a.a(e3));
                                return;
                            }
                            return;
                        }
                    }
                    try {
                        if (StringUtils.isNull(this.f21769b.u)) {
                            int[] iArr = this.f21769b.o;
                            this.f21769b.m = 0;
                            iArr[1] = 0;
                            int[] iArr2 = this.f21769b.o;
                            this.f21769b.n = 0;
                            iArr2[2] = 0;
                            return;
                        }
                        FileInputStream fileInputStream = new FileInputStream(new File(this.f21769b.u));
                        byte[] bArr3 = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr3);
                        fileInputStream.close();
                        int i3 = this.f21769b.o[1] != 0 ? this.f21769b.o[1] : this.f21769b.o[2];
                        double d2 = 270.0d;
                        if (this.f21769b.F) {
                            this.f21769b.n = faceunity.fuCreateItemFromPackage(bArr3);
                            this.f21769b.o[2] = this.f21769b.n;
                            this.f21769b.m = 0;
                            this.f21769b.o[1] = this.f21769b.m;
                            faceunity.fuItemSetParam(this.f21769b.n, "isAndroid", 1.0d);
                            int i4 = this.f21769b.n;
                            if (!this.f21769b.y()) {
                                d2 = 90.0d;
                            }
                            faceunity.fuItemSetParam(i4, "rotationAngle", d2);
                        } else {
                            this.f21769b.m = faceunity.fuCreateItemFromPackage(bArr3);
                            this.f21769b.o[1] = this.f21769b.m;
                            this.f21769b.n = 0;
                            this.f21769b.o[2] = this.f21769b.n;
                            faceunity.fuItemSetParam(this.f21769b.m, "isAndroid", 1.0d);
                            int i5 = this.f21769b.m;
                            if (!this.f21769b.y()) {
                                d2 = 90.0d;
                            }
                            faceunity.fuItemSetParam(i5, "rotationAngle", d2);
                        }
                        if (i3 != 0) {
                            faceunity.fuDestroyItem(i3);
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        if (this.f21769b.L != null) {
                            this.f21769b.L.b(24, d.a.q0.x1.a.a(e4));
                        }
                    }
                }
            }
        }

        public c(Context context, GLVideoPreviewView gLVideoPreviewView, d.a.q0.x1.g gVar) {
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
            this.f21764i = 720;
            this.j = 960;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = new int[]{0, 0, 0};
            this.p = true;
            this.q = 0;
            this.r = 0L;
            this.u = "";
            this.v = FilterValue.DEFAULT_FILTER_VALUE;
            this.B = 3;
            this.C = 0.5f;
            this.D = 0;
            this.f21763h = gLVideoPreviewView;
            this.L = gVar;
            HandlerThread handlerThread = new HandlerThread("CreateItemThread");
            this.s = handlerThread;
            handlerThread.start();
            this.t = new HandlerC0243c(this, this.s.getLooper(), context);
            D(d.a.q0.v3.a.b(2));
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21763h.queueEvent(new b(this));
            }
        }

        public final void B(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.K = null;
                if (bitmap != null && !bitmap.isRecycled()) {
                    new a(this, bitmap).execute(new Void[0]);
                    return;
                }
                GLVideoPreviewView gLVideoPreviewView = this.f21763h;
                if (gLVideoPreviewView == null || gLVideoPreviewView.k == null) {
                    return;
                }
                this.f21763h.k.a(false, this.K);
            }
        }

        public final void C() {
            GLVideoPreviewView gLVideoPreviewView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gLVideoPreviewView = this.f21763h) == null) {
                return;
            }
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

        public void D(d.a.q0.v3.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.w = aVar.f66005b;
            this.x = aVar.f66006c;
            this.y = aVar.f66007d;
            this.z = aVar.f66008e;
            this.A = aVar.f66009f;
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
            this.H = textureMovieEncoder;
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
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.f21762g != null) {
                    faceunity.fuOnCameraChange();
                    this.f21762g.release();
                }
                this.f21762g = new SurfaceTexture(this.k);
                C();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, gl10) == null) || this.J) {
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
                this.f21762g.updateTexImage();
                this.f21762g.getTransformMatrix(fArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.q0.x1.g gVar = this.L;
                if (gVar != null) {
                    gVar.b(22, d.a.q0.x1.a.a(e2));
                }
            }
            if (this.p) {
                this.p = false;
                this.t.sendEmptyMessage(1);
            }
            if (this.f21763h.f21757h != null) {
                this.f21763h.f21757h.onFaceIdentifyState(faceunity.fuIsTracking() > 0);
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
                int i3 = 1 | (this.f21763h.f21754e.l == 1 ? 0 : 32);
                if (this.F) {
                    faceunity.fuItemSetParam(this.n, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.n, "rotationAngle", y() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.m, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.m, "rotationAngle", y() ? 270.0d : 90.0d);
                }
                this.f21763h.f21754e.j();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr2 = this.E;
                int i4 = this.k;
                int i5 = this.f21764i;
                int i6 = this.j;
                int i7 = this.D;
                this.D = i7 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr2, i4, i3, i5, i6, i7, this.o);
                this.r += System.currentTimeMillis() - currentTimeMillis;
                try {
                    this.f21760e.drawFrame(fuDualInputToTexture, fArr);
                    if (this.f21763h.l) {
                        z(gl10);
                        this.f21763h.l = false;
                    }
                    if (this.H != null && this.H.checkRecordingStatus(2) && this.f21763h.f21754e != null) {
                        this.I = this.f21763h.f21754e.o();
                        this.H.startRecording(new TextureMovieEncoder.EncoderConfig(new File(this.I), GLVideoPreviewView.n, GLVideoPreviewView.o, 2097152, null, this.f21762g.getTimestamp()));
                    }
                    if (this.H == null || !this.H.checkRecordingStatus(1)) {
                        return;
                    }
                    this.H.setTextureId(this.f21760e, fuDualInputToTexture, fArr);
                    if (GLVideoPreviewView.p) {
                        this.H.frameAvailable(this.f21762g);
                    }
                    boolean unused = GLVideoPreviewView.p = true;
                    return;
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.f21763h.e(null);
                    d.a.q0.x1.g gVar2 = this.L;
                    if (gVar2 != null) {
                        gVar2.b(23, d.a.q0.x1.a.a(th));
                        return;
                    }
                    return;
                }
            }
            this.f21763h.requestRender();
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
                this.f21763h.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048588, this, gl10, i2, i3) == null) {
                this.f21763h.f21758i = i2;
                this.f21763h.j = i3;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, gl10, eGLConfig) == null) {
                this.f21760e = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.f21761f = fullFrameRect;
                this.k = fullFrameRect.createTextureObject();
                I();
                boolean unused = GLVideoPreviewView.p = false;
            }
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f21763h.f21754e.j() : invokeV.booleanValue;
        }

        public final void z(GL10 gl10) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, gl10) == null) {
                Bitmap bitmap = null;
                try {
                    System.gc();
                    System.gc();
                    int i2 = this.f21763h.f21758i;
                    int i3 = this.f21763h.j;
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
                    GLVideoPreviewView gLVideoPreviewView = this.f21763h;
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
    public GLVideoPreviewView(Context context, h hVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hVar};
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
            this.m = kVar.get();
        }
        this.f21754e = hVar;
        this.f21755f = new c(context, this, this.m);
        setEGLContextClientVersion(2);
        setRenderer(this.f21755f);
        setRenderMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f21754e.n() : (Handler) invokeV.objValue;
    }

    @Override // d.a.q0.v3.l.g
    public void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, camera) == null) || camera == null) {
            return;
        }
        try {
            camera.setPreviewCallback(this.f21755f);
            camera.setPreviewTexture(this.f21755f.f21762g);
            this.f21755f.f21762g.setOnFrameAvailableListener(this.f21755f);
            camera.startPreview();
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.q0.x1.g gVar = this.m;
            if (gVar != null) {
                gVar.b(20, d.a.q0.x1.a.a(e2));
            }
        }
    }

    @Override // d.a.q0.v3.l.g
    public void b(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, camera) == null) {
            try {
                this.f21755f.A();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.q0.x1.g gVar = this.m;
                if (gVar != null) {
                    gVar.b(18, d.a.q0.x1.a.a(e2));
                }
            }
        }
    }

    @Override // d.a.q0.v3.l.g
    public void c(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.k = aVar;
            this.l = true;
            requestRender();
        }
    }

    @Override // d.a.q0.v3.l.g
    public void d(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, camera) == null) {
            try {
                TextureMovieEncoder textureMovieEncoder = new TextureMovieEncoder();
                this.f21756g = textureMovieEncoder;
                this.f21755f.F(textureMovieEncoder);
                p = false;
            } catch (Throwable th) {
                BdLog.e(th);
                d.a.q0.x1.g gVar = this.m;
                if (gVar != null) {
                    gVar.b(21, d.a.q0.x1.a.a(th));
                }
            }
        }
    }

    @Override // d.a.q0.v3.l.g
    public void e(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, camera) == null) {
            try {
                if (this.f21756g != null) {
                    this.f21756g.stopRecording();
                }
            } catch (Throwable th) {
                BdLog.e(th);
                d.a.q0.x1.g gVar = this.m;
                if (gVar != null) {
                    gVar.b(19, d.a.q0.x1.a.a(th));
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            c cVar = this.f21755f;
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
            h hVar = this.f21754e;
            if (hVar == null) {
                return false;
            }
            return hVar.w(motionEvent, getParent());
        }
        return invokeL.booleanValue;
    }

    public void setBeautyLevel(d.a.q0.v3.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (cVar = this.f21755f) == null) {
            return;
        }
        cVar.D(aVar);
    }

    public void setFaceIdentifyStateListener(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f21757h = bVar;
    }

    public void setFilter(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (cVar = this.f21755f) == null) {
            return;
        }
        cVar.E(str);
    }

    public void setIsChangingCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f21755f.J = z;
        }
    }

    @Override // d.a.q0.v3.l.g
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        TextureMovieEncoder textureMovieEncoder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onEncoderStatusUpdateListener) == null) || (textureMovieEncoder = this.f21756g) == null) {
            return;
        }
        textureMovieEncoder.setOnEncoderStatusUpdateListener(onEncoderStatusUpdateListener);
    }

    @Override // d.a.q0.v3.l.g
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        c cVar = this.f21755f;
        cVar.f21764i = i2;
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
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, stickerItem) == null) || (cVar = this.f21755f) == null) {
            return;
        }
        cVar.G(stickerItem);
    }

    public void t() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (cVar = this.f21755f) == null) {
            return;
        }
        cVar.E = null;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            queueEvent(new a(this));
        }
    }
}
