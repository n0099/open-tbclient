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
import c.a.p0.w3.l.f;
import c.a.p0.w3.l.g;
import c.a.p0.w3.l.h;
import c.a.p0.y1.k;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes7.dex */
public class GLVideoPreviewView extends GLSurfaceView implements g {
    public static /* synthetic */ Interceptable $ic = null;
    public static int m = 720;
    public static int n = 960;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f57319e;

    /* renamed from: f  reason: collision with root package name */
    public TextureMovieEncoder f57320f;

    /* renamed from: g  reason: collision with root package name */
    public b f57321g;

    /* renamed from: h  reason: collision with root package name */
    public int f57322h;

    /* renamed from: i  reason: collision with root package name */
    public int f57323i;

    /* renamed from: j  reason: collision with root package name */
    public g.a f57324j;
    public boolean k;
    public c.a.p0.y1.g l;
    public h mPreviewController;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GLVideoPreviewView f57325e;

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
            this.f57325e = gLVideoPreviewView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57325e.f57319e == null) {
                return;
            }
            this.f57325e.f57319e.I();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onFaceIdentifyState(boolean z);
    }

    /* loaded from: classes7.dex */
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
        public c.a.p0.y1.g L;

        /* renamed from: e  reason: collision with root package name */
        public FullFrameRect f57326e;

        /* renamed from: f  reason: collision with root package name */
        public FullFrameRect f57327f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SurfaceTexture f57328g;

        /* renamed from: h  reason: collision with root package name */
        public GLVideoPreviewView f57329h;

        /* renamed from: i  reason: collision with root package name */
        public int f57330i;

        /* renamed from: j  reason: collision with root package name */
        public int f57331j;
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

        /* loaded from: classes7.dex */
        public class a extends BdAsyncTask<Void, Void, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Bitmap f57332a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f57333b;

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
                this.f57333b = cVar;
                this.f57332a = bitmap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(Void r5) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || this.f57333b.f57329h == null || this.f57333b.f57329h.f57324j == null) {
                    return;
                }
                this.f57333b.f57329h.f57324j.a(true, this.f57333b.K);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                    try {
                        this.f57333b.K = FileHelper.saveFileAsPic(c.a.p0.w3.c.f27862i, "pic_" + System.currentTimeMillis(), this.f57332a, 80, Bitmap.CompressFormat.JPEG);
                        return null;
                    } finally {
                        Bitmap bitmap = this.f57332a;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            this.f57332a.recycle();
                        }
                    }
                }
                return (Void) invokeL.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f57334e;

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
                this.f57334e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f57334e.f57326e != null) {
                        this.f57334e.f57326e.release(false);
                        this.f57334e.f57326e = null;
                    }
                    if (this.f57334e.f57327f != null) {
                        this.f57334e.f57327f.release(false);
                        this.f57334e.f57327f = null;
                    }
                    if (this.f57334e.f57328g != null) {
                        this.f57334e.f57328g.release();
                        this.f57334e.f57328g = null;
                    }
                    faceunity.fuDestroyItem(this.f57334e.m);
                    int[] iArr = this.f57334e.o;
                    this.f57334e.m = 0;
                    iArr[1] = 0;
                    faceunity.fuDestroyItem(this.f57334e.l);
                    int[] iArr2 = this.f57334e.o;
                    this.f57334e.l = 0;
                    iArr2[0] = 0;
                    faceunity.fuOnDeviceLost();
                    this.f57334e.E = null;
                    this.f57334e.p = true;
                }
            }
        }

        /* renamed from: com.baidu.tieba.video.record.GLVideoPreviewView$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class HandlerC1796c extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f57335a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f57336b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC1796c(c cVar, Looper looper, Context context) {
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
                this.f57336b = cVar;
                this.f57335a = new WeakReference<>(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    this.f57335a.get();
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
                            this.f57336b.G = true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (this.f57336b.L != null) {
                                this.f57336b.L.b(25, c.a.p0.y1.a.a(e2));
                            }
                        }
                        try {
                            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                            byte[] bArr2 = new byte[open2.available()];
                            open2.read(bArr2);
                            open2.close();
                            this.f57336b.l = faceunity.fuCreateItemFromPackage(bArr2);
                            this.f57336b.o[0] = this.f57336b.l;
                            this.f57336b.G = true;
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            if (this.f57336b.L != null) {
                                this.f57336b.L.b(26, c.a.p0.y1.a.a(e3));
                                return;
                            }
                            return;
                        }
                    }
                    try {
                        if (StringUtils.isNull(this.f57336b.u)) {
                            int[] iArr = this.f57336b.o;
                            this.f57336b.m = 0;
                            iArr[1] = 0;
                            int[] iArr2 = this.f57336b.o;
                            this.f57336b.n = 0;
                            iArr2[2] = 0;
                            return;
                        }
                        FileInputStream fileInputStream = new FileInputStream(new File(this.f57336b.u));
                        byte[] bArr3 = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr3);
                        fileInputStream.close();
                        int i3 = this.f57336b.o[1] != 0 ? this.f57336b.o[1] : this.f57336b.o[2];
                        double d2 = 270.0d;
                        if (this.f57336b.F) {
                            this.f57336b.n = faceunity.fuCreateItemFromPackage(bArr3);
                            this.f57336b.o[2] = this.f57336b.n;
                            this.f57336b.m = 0;
                            this.f57336b.o[1] = this.f57336b.m;
                            faceunity.fuItemSetParam(this.f57336b.n, "isAndroid", 1.0d);
                            int i4 = this.f57336b.n;
                            if (!this.f57336b.y()) {
                                d2 = 90.0d;
                            }
                            faceunity.fuItemSetParam(i4, "rotationAngle", d2);
                        } else {
                            this.f57336b.m = faceunity.fuCreateItemFromPackage(bArr3);
                            this.f57336b.o[1] = this.f57336b.m;
                            this.f57336b.n = 0;
                            this.f57336b.o[2] = this.f57336b.n;
                            faceunity.fuItemSetParam(this.f57336b.m, "isAndroid", 1.0d);
                            int i5 = this.f57336b.m;
                            if (!this.f57336b.y()) {
                                d2 = 90.0d;
                            }
                            faceunity.fuItemSetParam(i5, "rotationAngle", d2);
                        }
                        if (i3 != 0) {
                            faceunity.fuDestroyItem(i3);
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        if (this.f57336b.L != null) {
                            this.f57336b.L.b(24, c.a.p0.y1.a.a(e4));
                        }
                    }
                }
            }
        }

        public c(Context context, GLVideoPreviewView gLVideoPreviewView, c.a.p0.y1.g gVar) {
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
            this.f57330i = 720;
            this.f57331j = 960;
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
            this.f57329h = gLVideoPreviewView;
            this.L = gVar;
            HandlerThread handlerThread = new HandlerThread("CreateItemThread");
            this.s = handlerThread;
            handlerThread.start();
            this.t = new HandlerC1796c(this, this.s.getLooper(), context);
            D(c.a.p0.w3.a.b(2));
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57329h.queueEvent(new b(this));
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
                GLVideoPreviewView gLVideoPreviewView = this.f57329h;
                if (gLVideoPreviewView == null || gLVideoPreviewView.f57324j == null) {
                    return;
                }
                this.f57329h.f57324j.a(false, this.K);
            }
        }

        public final void C() {
            GLVideoPreviewView gLVideoPreviewView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gLVideoPreviewView = this.f57329h) == null) {
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

        public void D(c.a.p0.w3.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.w = aVar.f27841b;
            this.x = aVar.f27842c;
            this.y = aVar.f27843d;
            this.z = aVar.f27844e;
            this.A = aVar.f27845f;
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
                if (this.f57328g != null) {
                    faceunity.fuOnCameraChange();
                    this.f57328g.release();
                }
                this.f57328g = new SurfaceTexture(this.k);
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
                this.f57328g.updateTexImage();
                this.f57328g.getTransformMatrix(fArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.p0.y1.g gVar = this.L;
                if (gVar != null) {
                    gVar.b(22, c.a.p0.y1.a.a(e2));
                }
            }
            if (this.p) {
                this.p = false;
                this.t.sendEmptyMessage(1);
            }
            if (this.f57329h.f57321g != null) {
                this.f57329h.f57321g.onFaceIdentifyState(faceunity.fuIsTracking() > 0);
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
                int i3 = 1 | (this.f57329h.mPreviewController.l == 1 ? 0 : 32);
                if (this.F) {
                    faceunity.fuItemSetParam(this.n, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.n, "rotationAngle", y() ? 270.0d : 90.0d);
                } else {
                    faceunity.fuItemSetParam(this.m, "isAndroid", 1.0d);
                    faceunity.fuItemSetParam(this.m, "rotationAngle", y() ? 270.0d : 90.0d);
                }
                this.f57329h.mPreviewController.j();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr2 = this.E;
                int i4 = this.k;
                int i5 = this.f57330i;
                int i6 = this.f57331j;
                int i7 = this.D;
                this.D = i7 + 1;
                int fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr2, i4, i3, i5, i6, i7, this.o);
                this.r += System.currentTimeMillis() - currentTimeMillis;
                try {
                    this.f57326e.drawFrame(fuDualInputToTexture, fArr);
                    if (this.f57329h.k) {
                        z(gl10);
                        this.f57329h.k = false;
                    }
                    if (this.H != null && this.H.checkRecordingStatus(2) && this.f57329h.mPreviewController != null) {
                        this.I = this.f57329h.mPreviewController.o();
                        this.H.startRecording(new TextureMovieEncoder.EncoderConfig(new File(this.I), GLVideoPreviewView.m, GLVideoPreviewView.n, 2097152, null, this.f57328g.getTimestamp()));
                    }
                    if (this.H == null || !this.H.checkRecordingStatus(1)) {
                        return;
                    }
                    this.H.setTextureId(this.f57326e, fuDualInputToTexture, fArr);
                    if (GLVideoPreviewView.o) {
                        this.H.frameAvailable(this.f57328g);
                    }
                    boolean unused = GLVideoPreviewView.o = true;
                    return;
                } catch (Throwable th) {
                    BdLog.e(th);
                    this.f57329h.stopRecord(null);
                    c.a.p0.y1.g gVar2 = this.L;
                    if (gVar2 != null) {
                        gVar2.b(23, c.a.p0.y1.a.a(th));
                        return;
                    }
                    return;
                }
            }
            this.f57329h.requestRender();
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
                this.f57329h.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048588, this, gl10, i2, i3) == null) {
                this.f57329h.f57322h = i2;
                this.f57329h.f57323i = i3;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, gl10, eGLConfig) == null) {
                this.f57326e = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.f57327f = fullFrameRect;
                this.k = fullFrameRect.createTextureObject();
                I();
                boolean unused = GLVideoPreviewView.o = false;
            }
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f57329h.mPreviewController.j() : invokeV.booleanValue;
        }

        public final void z(GL10 gl10) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, gl10) == null) {
                Bitmap bitmap = null;
                try {
                    System.gc();
                    System.gc();
                    int i2 = this.f57329h.f57322h;
                    int i3 = this.f57329h.f57323i;
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
                    GLVideoPreviewView gLVideoPreviewView = this.f57329h;
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
            this.l = kVar.get();
        }
        this.mPreviewController = hVar;
        this.f57319e = new c(context, this, this.l);
        setEGLContextClientVersion(2);
        setRenderer(this.f57319e);
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f57319e) == null) {
            return;
        }
        cVar.E = null;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onResume();
            c cVar = this.f57319e;
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
            h hVar = this.mPreviewController;
            if (hVar == null) {
                return false;
            }
            return hVar.w(motionEvent, getParent());
        }
        return invokeL.booleanValue;
    }

    public void setBeautyLevel(c.a.p0.w3.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (cVar = this.f57319e) == null) {
            return;
        }
        cVar.D(aVar);
    }

    public void setFaceIdentifyStateListener(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f57321g = bVar;
    }

    public void setFilter(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (cVar = this.f57319e) == null) {
            return;
        }
        cVar.E(str);
    }

    public void setIsChangingCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f57319e.J = z;
        }
    }

    @Override // c.a.p0.w3.l.g
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        TextureMovieEncoder textureMovieEncoder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, onEncoderStatusUpdateListener) == null) || (textureMovieEncoder = this.f57320f) == null) {
            return;
        }
        textureMovieEncoder.setOnEncoderStatusUpdateListener(onEncoderStatusUpdateListener);
    }

    @Override // c.a.p0.w3.l.g
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        c cVar = this.f57319e;
        cVar.f57330i = i2;
        cVar.f57331j = i3;
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
        if (!(interceptable == null || interceptable.invokeL(1048585, this, stickerItem) == null) || (cVar = this.f57319e) == null) {
            return;
        }
        cVar.G(stickerItem);
    }

    @Override // c.a.p0.w3.l.g
    public void startPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, camera) == null) || camera == null) {
            return;
        }
        try {
            camera.setPreviewCallback(this.f57319e);
            camera.setPreviewTexture(this.f57319e.f57328g);
            this.f57319e.f57328g.setOnFrameAvailableListener(this.f57319e);
            camera.startPreview();
        } catch (Exception e2) {
            e2.printStackTrace();
            c.a.p0.y1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(20, c.a.p0.y1.a.a(e2));
            }
        }
    }

    @Override // c.a.p0.w3.l.g
    public void startRecord(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, camera) == null) {
            try {
                TextureMovieEncoder textureMovieEncoder = new TextureMovieEncoder();
                this.f57320f = textureMovieEncoder;
                this.f57319e.F(textureMovieEncoder);
                o = false;
            } catch (Throwable th) {
                BdLog.e(th);
                c.a.p0.y1.g gVar = this.l;
                if (gVar != null) {
                    gVar.b(21, c.a.p0.y1.a.a(th));
                }
            }
        }
    }

    @Override // c.a.p0.w3.l.g
    public void stopPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, camera) == null) {
            try {
                this.f57319e.A();
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.p0.y1.g gVar = this.l;
                if (gVar != null) {
                    gVar.b(18, c.a.p0.y1.a.a(e2));
                }
            }
        }
    }

    @Override // c.a.p0.w3.l.g
    public void stopRecord(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, camera) == null) {
            try {
                if (this.f57320f != null) {
                    this.f57320f.stopRecording();
                }
            } catch (Throwable th) {
                BdLog.e(th);
                c.a.p0.y1.g gVar = this.l;
                if (gVar != null) {
                    gVar.b(19, c.a.p0.y1.a.a(th));
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

    @Override // c.a.p0.w3.l.g
    public void takePicture(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.f57324j = aVar;
            this.k = true;
            requestRender();
        }
    }
}
