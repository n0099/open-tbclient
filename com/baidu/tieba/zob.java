package com.baidu.tieba;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public abstract class zob implements wob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;
    public int E;
    public int F;
    public int G;
    public ReentrantLock H;
    public AtomicBoolean I;
    public WeakReference<k> J;
    public vob a;
    public xob b;
    public SurfaceTexture c;
    public rmb d;
    public MediaInfo e;
    public ByteBuffer[] f;
    public WeakReference<SurfaceTexture.OnFrameAvailableListener> g;
    public AtomicBoolean h;
    public Object i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public float[] q;
    public int r;
    public int s;
    public knb t;
    public boolean u;
    public boolean v;
    public boolean w;
    public Object x;
    public Executor y;
    public int z;

    /* loaded from: classes8.dex */
    public interface k {
        void a(MediaSample mediaSample, int i, int i2, long j, int i3);

        void b();

        void c(MediaSample mediaSample, int i, int i2, long j, int i3);

        void d();

        void onSurfaceChanged(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cnb a;
        public final /* synthetic */ zob b;

        public a(zob zobVar, cnb cnbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, cnbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zobVar;
            this.a = cnbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.b == null) {
                return;
            }
            TLog.g(this, "run setEffectResources");
            this.b.b.I(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ smb a;
        public final /* synthetic */ zob b;

        public b(zob zobVar, smb smbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, smbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zobVar;
            this.a = smbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b != null) {
                TLog.g(this, " mPlayerUID:" + this.b.r + " run enableJoyPkPipMode");
                this.b.b.K(true);
                this.b.b.L(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zob a;

        public c(zob zobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zobVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                TLog.g(this, " mPlayerUID:" + this.a.r + " run disableJoyPkPipMode");
                this.a.b.K(false);
                this.a.b.L(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Executor a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ zob c;

        public d(zob zobVar, Executor executor, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, executor, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zobVar;
            this.a = executor;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.w = true;
                this.c.y = this.a;
                this.c.x = this.b;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ zob b;

        public e(zob zobVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zobVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.b.D();
                        if (this.b.I.get()) {
                            this.b.E(true);
                            this.b.b.H(this.a);
                            this.b.b.C();
                            this.b.a.swapBuffer();
                        }
                        this.b.U();
                    } catch (Exception e) {
                        TLog.c(this, " mPlayerUID:" + this.b.r + " setDisplayMode:" + e.toString());
                    }
                } finally {
                    this.b.U();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ zob b;

        public f(zob zobVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zobVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.b.D();
                        if (this.b.I.get()) {
                            this.b.E(true);
                            this.b.b.J(this.a);
                            this.b.b.C();
                            this.b.a.swapBuffer();
                        }
                        this.b.U();
                    } catch (Exception e) {
                        TLog.c(this, " mPlayerUID:" + this.b.r + " setIsSpecialMp4WithAlpha:" + e.toString());
                    }
                } finally {
                    this.b.U();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ zob b;

        public g(zob zobVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zobVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.b.D();
                        if (this.b.I.get()) {
                            this.b.E(true);
                            this.b.b.N(this.a);
                            this.b.b.C();
                            this.b.a.swapBuffer();
                        }
                        this.b.U();
                    } catch (Exception e) {
                        TLog.c(this, " mPlayerUID:" + this.b.r + " setRotateMode:" + e.toString());
                    }
                } finally {
                    this.b.U();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ zob b;

        public h(zob zobVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zobVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.b.D();
                        if (this.b.I.get()) {
                            this.b.E(true);
                            this.b.b.O(this.a);
                            this.b.b.C();
                            this.b.a.swapBuffer();
                        }
                        this.b.U();
                    } catch (Exception e) {
                        TLog.c(this, " mPlayerUID:" + this.b.r + " setVideoRotateMode:" + e.toString());
                    }
                } finally {
                    this.b.U();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ zob b;

        public i(zob zobVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zobVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.b.D();
                        if (this.b.I.get()) {
                            this.b.E(true);
                            this.b.b.M(this.a);
                            this.b.b.C();
                            this.b.a.swapBuffer();
                        }
                        this.b.U();
                    } catch (Exception e) {
                        TLog.c(this, " mPlayerUID:" + this.b.r + " setOrientateMode:" + e.toString());
                    }
                } finally {
                    this.b.U();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zob a;

        public j(zob zobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zobVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zobVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            xob xobVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (xobVar = this.a.b) == null) {
                return;
            }
            xobVar.f();
        }
    }

    public zob() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = MediaInfo.a();
        this.f = new ByteBuffer[3];
        this.g = new WeakReference<>(null);
        this.h = new AtomicBoolean(true);
        this.i = new Object();
        this.j = 1;
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 1;
        this.p = 1;
        this.q = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
        this.r = 0;
        this.s = -1;
        this.t = new knb();
        this.u = false;
        this.v = false;
        new WeakReference(null);
        this.w = false;
        this.x = null;
        this.y = null;
        this.z = 0;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = new ReentrantLock(true);
        this.I = new AtomicBoolean(false);
        this.J = new WeakReference<>(null);
    }

    public void F(Executor executor, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, executor, obj) == null) && m()) {
            this.d.e(new d(this, executor, obj));
        }
    }

    public void A(Context context, Object obj, int i2, int i3, jnb jnbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, obj, Integer.valueOf(i2), Integer.valueOf(i3), jnbVar}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.a = new oob();
            } else {
                this.a = new pob();
            }
            this.b = new xob(i3);
            this.r = i2;
            new WeakReference(jnbVar);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.a();
            boolean e2 = this.a.e(Boolean.FALSE);
            if (!e2) {
                TLog.c(this, "OpenGLRender.create offscreen surface failed!!");
            }
            k kVar = this.J.get();
            if (!e2 && kVar != null) {
                kVar.b();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TLog.g(this, "OpenGLRender.internalRelease enter.");
            if (this.c != null) {
                TLog.g(this, "mSurfaceTexture release " + this.c);
                this.c = null;
            }
            xob xobVar = this.b;
            if (xobVar != null) {
                xobVar.E();
            }
            vob vobVar = this.a;
            if (vobVar != null) {
                vobVar.release();
            }
            c();
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b.J(this.k);
            this.b.H(this.j);
            this.b.N(this.l);
            this.b.O(this.m);
            this.b.M(this.n);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.h.get() && this.a.available() && this.b.b() && this.d.getStatus() != 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        ReentrantLock reentrantLock;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (reentrantLock = this.H) != null && reentrantLock.getHoldCount() == 0) {
            this.H.lock();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.A = 0L;
            this.B = 0L;
            this.E = 0;
            this.F = 0;
            this.G = 0;
            this.z = 0;
            this.C = 0L;
            this.D = 0L;
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.w = false;
            this.y = null;
            this.x = null;
            if (this.B > 0) {
                o(true);
            }
            G();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.H != null) {
            while (this.H.getHoldCount() != 0) {
                this.H.unlock();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int f2 = this.a.f();
            int c2 = this.a.c();
            if (f2 != this.o || c2 != this.p) {
                this.b.Y(f2, c2);
                this.o = f2;
                this.p = c2;
            }
        }
    }

    public void p() {
        rmb rmbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (rmbVar = this.d) != null) {
            rmbVar.e(new j(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.a.d(true);
            TLog.g(this, "destroySurface  mVideoIDTagForFirstFrame:" + this.s);
            this.s = -1;
        }
    }

    public void s() {
        rmb rmbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (rmbVar = this.d) != null) {
            rmbVar.e(new c(this));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && m()) {
            D();
            E(true);
            this.b.o();
            this.a.swapBuffer();
            U();
        }
    }

    public int w() {
        InterceptResult invokeV;
        apb x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            xob xobVar = this.b;
            if (xobVar == null || (x = xobVar.x()) == null) {
                return 0;
            }
            return x.a;
        }
        return invokeV.intValue;
    }

    public SurfaceTexture y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.c;
        }
        return (SurfaceTexture) invokeV.objValue;
    }

    public void E(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.a.b(i2, true);
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && this.j != i2) {
            this.j = i2;
            rmb rmbVar = this.d;
            if (rmbVar != null) {
                rmbVar.e(new e(this, i2));
            }
        }
    }

    public void I(cnb cnbVar) {
        rmb rmbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cnbVar) == null) && (rmbVar = this.d) != null) {
            rmbVar.e(new a(this, cnbVar));
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.s = -1;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.k != z) {
            this.k = z;
            rmb rmbVar = this.d;
            if (rmbVar != null) {
                rmbVar.e(new f(this, z));
            }
        }
    }

    public void L(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onFrameAvailableListener) == null) {
            this.g = new WeakReference<>(onFrameAvailableListener);
        }
    }

    public void M(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, kVar) == null) {
            this.J = new WeakReference<>(kVar);
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && this.n != i2) {
            this.n = i2;
            rmb rmbVar = this.d;
            if (rmbVar != null) {
                rmbVar.e(new i(this, i2));
            }
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && this.l != i2) {
            this.l = i2;
            rmb rmbVar = this.d;
            if (rmbVar != null) {
                rmbVar.e(new g(this, i2));
            }
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && this.m != i2) {
            this.m = i2;
            rmb rmbVar = this.d;
            if (rmbVar != null) {
                rmbVar.e(new h(this, i2));
            }
        }
    }

    public void Q(rmb rmbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rmbVar) == null) {
            xob xobVar = this.b;
            if (xobVar != null) {
                xobVar.F();
            }
            this.d = rmbVar;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.h.set(z);
        }
    }

    public void v(smb smbVar) {
        rmb rmbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, smbVar) == null) && (rmbVar = this.d) != null) {
            rmbVar.e(new b(this, smbVar));
        }
    }

    public void x(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, mediaSample) == null) {
            if (this.t.a(true, false)) {
                mediaSample.Q = this.t.b();
                mediaSample.O = true;
                TLog.g(this, "[surface] surface stats changed");
            }
            mediaSample.P = this.t.c();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.o = this.a.f();
            int c2 = this.a.c();
            this.p = c2;
            this.b.P(this.o, c2);
            if (this.e.f()) {
                this.b.V(this.e);
                TLog.g(this, "setupOpenGL :: updateFrameSize");
            }
            W();
            xob xobVar = this.b;
            float[] fArr = this.q;
            xobVar.G(fArr[0], fArr[1], fArr[2], fArr[3]);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.b.Q();
            if (this.c == null) {
                this.c = new SurfaceTexture(this.b.a());
                TLog.g(this, "mSurfaceTexture " + this.c);
                SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.g.get();
                if (onFrameAvailableListener != null) {
                    this.c.setOnFrameAvailableListener(onFrameAvailableListener);
                }
            }
        }
    }

    public void V(MediaInfo mediaInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, mediaInfo) == null) {
            if (!this.e.e(mediaInfo)) {
                TLog.g(this, " mPlayerUID:" + this.r + " mediaInfo is same, return");
                return;
            }
            this.e.c(mediaInfo);
            MediaInfo mediaInfo2 = this.e;
            int i2 = mediaInfo2.a;
            if (i2 == 4) {
                this.f[0] = ByteBuffer.allocateDirect(mediaInfo2.i * 3).order(ByteOrder.nativeOrder());
                TLog.g(this, String.format("FRAME_TYPE_RGB24 , mFrameData[0] size =  %d", Integer.valueOf(this.e.i * 3)));
            } else if (i2 == 2) {
                this.f[0] = ByteBuffer.allocateDirect(mediaInfo2.i).order(ByteOrder.nativeOrder());
                this.f[1] = ByteBuffer.allocateDirect(this.e.i >> 2).order(ByteOrder.nativeOrder());
                this.f[2] = ByteBuffer.allocateDirect(this.e.i >> 2).order(ByteOrder.nativeOrder());
                TLog.g(this, String.format("FRAME_TYPE_I420 , mFrameData[0] size =  %d , mFrameData[1] size =  %d , mFrameData[2] size =  %d", Integer.valueOf(this.e.i), Integer.valueOf(this.e.i >> 2), Integer.valueOf(this.e.i >> 2)));
            } else if (i2 == 3) {
                this.f[0] = ByteBuffer.allocateDirect(mediaInfo2.i).order(ByteOrder.nativeOrder());
                this.f[1] = ByteBuffer.allocateDirect(this.e.i >> 1).order(ByteOrder.nativeOrder());
                TLog.g(this, String.format("FRAME_TYPE_NV12 , mFrameData[0] size =  %d , mFrameData[1] size =  %d , ", Integer.valueOf(this.e.i), Integer.valueOf(this.e.i >> 1)));
            }
            TLog.g(this, " mPlayerUID:" + this.r + " updateInfo :: updateFrameSize");
            this.b.V(this.e);
        }
    }

    public void t(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mediaSample) == null) {
            synchronized (this.i) {
                int i2 = mediaSample.g.d;
                if (m()) {
                    n();
                    try {
                        D();
                        if (this.I.get()) {
                            if (mediaSample.i.a == 8) {
                                E(true);
                                this.b.n(mediaSample, null);
                            } else if (mediaSample.i.k != null) {
                                if ((this.e.a != 2 && this.e.a != 3) || this.e.a != mediaSample.i.a) {
                                    TLog.c(this, "render dirty data: mMediaInfo.type: " + this.e.a + "  sample.info.type: " + mediaSample.i.a);
                                    U();
                                    U();
                                    return;
                                }
                                MediaInfo.d(mediaSample.i, this.e, this.f);
                                mediaSample.c(this.e);
                                this.b.n(mediaSample, this.f);
                                mediaSample.e();
                            } else {
                                TLog.c(this, "render dirty data (out)");
                            }
                            if (this.w) {
                                TLog.g(this, "readPixels,mSnapShotCallback:" + this.x);
                                this.b.D(this.y, this.x);
                                this.y = null;
                                this.x = null;
                                this.w = false;
                            }
                            this.a.swapBuffer();
                        }
                        U();
                    } catch (Exception e2) {
                        TLog.c(this, "draw error:" + e2);
                    }
                    U();
                    if (i2 != this.s) {
                        GLES20.glFinish();
                        this.s = i2;
                        mediaSample.e = true;
                        this.u = false;
                        k kVar = this.J.get();
                        if (kVar != null) {
                            mediaSample.d = true;
                            kVar.c(mediaSample, this.e.b, this.e.c, System.currentTimeMillis(), mediaSample.g.e);
                            TLog.g(this, " mPlayerUID:" + this.r + "  playTaskId:" + mediaSample.g.e + " first frame show --- video");
                        }
                    } else if (this.u) {
                        this.u = false;
                        k kVar2 = this.J.get();
                        if (kVar2 != null) {
                            kVar2.a(mediaSample, this.e.b, this.e.c, System.currentTimeMillis(), mediaSample.g.e);
                            TLog.g(this, " again show --- video");
                        }
                    }
                }
            }
        }
    }

    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, message) == null) {
            switch (message.what) {
                case 2401:
                    this.t.e();
                    try {
                        TLog.g(this, "mIsOpenGLSetup = " + this.v);
                        q((SurfaceTexture) message.obj);
                        if (!this.v) {
                            R();
                            this.v = true;
                        } else {
                            W();
                        }
                    } catch (Exception e2) {
                        TLog.g(this, "setup error = " + e2.getMessage());
                    }
                    k kVar = this.J.get();
                    if (kVar != null) {
                        kVar.d();
                        return;
                    }
                    return;
                case 2402:
                    this.t.f();
                    r();
                    return;
                case 2403:
                    this.b.V(this.e);
                    return;
                case 2404:
                    this.t.d(message.arg1, message.arg2);
                    if (this.a.available()) {
                        try {
                            try {
                                D();
                                if (this.I.get()) {
                                    E(true);
                                    this.b.C();
                                    this.a.swapBuffer();
                                    this.b.Y(message.arg1, message.arg2);
                                    this.b.C();
                                    this.a.swapBuffer();
                                }
                                U();
                            } catch (Exception e3) {
                                TLog.c(this, "handle surface changed:" + e3.toString());
                            }
                        } finally {
                            U();
                        }
                    }
                    k kVar2 = this.J.get();
                    if (kVar2 != null) {
                        kVar2.onSurfaceChanged(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 2405:
                    n();
                    return;
                case 2406:
                default:
                    return;
                case ErrorConstant.Code.DATA_WRITE_DB /* 2407 */:
                    C();
                    return;
                case 2408:
                    try {
                        B();
                        S();
                        return;
                    } catch (Exception e4) {
                        TLog.g(this, "init render egl error = " + e4.getMessage());
                        return;
                    }
            }
        }
    }

    public final void o(boolean z) {
        int i2;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.B == 0) {
                this.B = currentTimeMillis;
            }
            int i4 = (int) (currentTimeMillis - this.B);
            if (z || i4 >= 5000) {
                long j2 = this.A;
                if (j2 == 0) {
                    return;
                }
                int i5 = this.E + this.F + this.G;
                int i6 = i4 / 1000;
                if (i6 == 0) {
                    i3 = (int) ((j2 * 8) / 1024);
                    i2 = i5;
                } else {
                    i2 = i5 / i6;
                    i3 = (int) (((j2 * 8) / i6) / 1024);
                }
                Object[] objArr = new Object[11];
                objArr[0] = Integer.valueOf(this.r);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = Integer.valueOf(i3);
                objArr[4] = Integer.valueOf(i5);
                objArr[5] = Integer.valueOf(this.E);
                objArr[6] = Integer.valueOf(this.G);
                objArr[7] = Integer.valueOf(this.F);
                if (this.z == 2002) {
                    str = "h265";
                } else {
                    str = "h264";
                }
                objArr[8] = str;
                objArr[9] = Long.valueOf(this.C);
                objArr[10] = Long.valueOf(this.D);
                TLog.h("[VideoMonitor]", String.format("playuid %d, %d ms, fps %d, %d kbps, frames %d, I:P:B, %d:%d:%d, %s, pts [%d, %d]", objArr));
                G();
                this.B = currentTimeMillis;
            }
        }
    }

    public final void q(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, surfaceTexture) == null) {
            c();
            d(surfaceTexture);
            Object window = getWindow();
            if (window == null) {
                TLog.g(this, "window is null");
                return;
            }
            this.a.a();
            this.a.d(true);
            boolean z = false;
            try {
                try {
                    D();
                    if (this.I.get()) {
                        z = this.a.e(window);
                    }
                    this.u = true;
                    U();
                } catch (Exception e2) {
                    TLog.c(this, "createSurface:" + e2.toString());
                }
                k kVar = this.J.get();
                if (!z && kVar != null) {
                    kVar.b();
                }
            } finally {
                U();
            }
        }
    }
}
