package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d0c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class yzb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a1c a;
    public dzb b;
    public int c;
    public boolean d;
    public boolean e;
    public WeakReference<rzb> f;
    public d0c.a g;
    public final List<WeakReference<kzb>> h;
    public final kzb i;

    /* loaded from: classes9.dex */
    public interface d {
        void a(Bitmap bitmap);
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "12.1.0.34" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements d0c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ yzb b;

        public a(yzb yzbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yzbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yzbVar;
            this.a = 0L;
        }

        @Override // com.baidu.tieba.d0c.a
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this) {
                    if (j <= this.a) {
                        return;
                    }
                    this.a = j;
                    if (this.b.a != null) {
                        this.b.a.e();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.d0c.a
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    if (j <= this.a) {
                        return;
                    }
                    this.a = j;
                    if (this.b.a != null) {
                        this.b.a.f();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements kzb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yzb a;

        public b(yzb yzbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yzbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yzbVar;
        }

        @Override // com.baidu.tieba.kzb
        public void onPlayerFirstVideoFrameShow(yzb yzbVar, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIII(1048576, this, yzbVar, i, i2, i3) != null) {
                return;
            }
            synchronized (this.a.h) {
                for (WeakReference weakReference : this.a.h) {
                    kzb kzbVar = (kzb) weakReference.get();
                    if (kzbVar != null) {
                        TLog.g(this, "ff notify " + kzbVar);
                        kzbVar.onPlayerFirstVideoFrameShow(yzbVar, i, i2, i3);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(yzb yzbVar, ArrayList<MixAudioExtraInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, yzbVar, arrayList) == null) {
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public yzb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = false;
        this.e = false;
        this.f = new WeakReference<>(null);
        this.g = new a(this);
        this.h = new ArrayList();
        this.i = new b(this);
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TLog.g(this, "start");
            if (this.b == null) {
                TLog.g(this, "start mDataSource is null!");
                return -1;
            }
            this.d = true;
            if (this.e) {
                TLog.g(this, "player start and update DataSource");
                t(this.b);
                this.e = false;
            }
            this.c = (int) this.b.j();
            this.a.F(this.c, yyb.a());
            return this.c;
        }
        return invokeV.intValue;
    }

    public yzb(Context context, xzb xzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xzbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = false;
        this.e = false;
        this.f = new WeakReference<>(null);
        this.g = new a(this);
        this.h = new ArrayList();
        this.i = new b(this);
        if (y0c.x(context)) {
            new WeakReference(context);
            vyb.a(context);
            vyb.b(context);
            if (Preference.f()) {
                xzbVar.m = Preference.g();
                TLog.h("[VodPlayer]", "global process config enabled, globalSubprocess=" + xzbVar.m);
            }
            if (xzbVar.m && Preference.h()) {
                xzbVar.m = false;
                TLog.h("[VodPlayer]", "subprocess fail over to main process, so set subprocess as false");
            }
            if (xzbVar.m && !e3c.n().r()) {
                TLog.h("[VodPlayer]", "subprocess is not support in current devices!!");
                xzbVar.m = false;
            }
            if (xzbVar.m && !e3c.n().o(context.getApplicationContext())) {
                TLog.h("[VodPlayer]", "subprocess fail as initSubProcess fail!!");
                xzbVar.m = false;
            }
            if (xzbVar.m && !e3c.n().q()) {
                TLog.h("[VodPlayer]", "initSubProcess but subProcess is not connected, VodPlayer force start in main process !!!");
                xzbVar.m = false;
            }
            TLog.h("[VodPlayer]", xzbVar.toString());
            if (xzbVar.m) {
                c1c c1cVar = new c1c(context.getApplicationContext(), xzbVar, this);
                this.a = c1cVar;
                wzb.a(c1cVar);
            } else {
                this.a = new b1c(context.getApplicationContext(), xzbVar, this);
            }
            d0c.b(this.g);
            TLog.g(this, "VodPlayer, subprocess: " + xzbVar.m + ", vodplayer version : " + h());
            return;
        }
        throw new RuntimeException("dynamic load so enabled, make sure isLibReady returns true or onLibDownloadSuccess!");
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return y0c.x(context);
        }
        return invokeL.booleanValue;
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            TLog.h("AudioFocus", " setAudioFocusEnable:" + z);
            wzb.b(z);
        }
    }

    public void B(lzb lzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lzbVar) == null) {
            this.a.A(lzbVar);
        }
    }

    public void C(qzb qzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qzbVar) == null) {
            this.a.B(qzbVar);
        }
    }

    public void D(rzb rzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rzbVar) == null) {
            this.a.C(rzbVar);
            this.f = new WeakReference<>(rzbVar);
        }
    }

    public void E(szb szbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, szbVar) == null) {
            this.a.D(szbVar);
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.E(i);
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.a.r(j);
        }
    }

    public void t(dzb dzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dzbVar) == null) {
            dzbVar.p(0L);
            this.a.s(dzbVar);
            this.b = dzbVar;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.a.u(i);
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.a.v(i);
        }
    }

    public void y(gzb gzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, gzbVar) == null) {
            this.a.x(gzbVar);
        }
    }

    public void z(izb izbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, izbVar) == null) {
            this.a.y(izbVar);
        }
    }

    public static void k(Context context, o0c o0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, o0cVar) == null) {
            y0c.r(context, null, o0cVar, null);
        }
    }

    public void q(Executor executor, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, executor, dVar) == null) {
            this.a.q(executor, dVar);
        }
    }

    public void x(Executor executor, fzb fzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, executor, fzbVar) == null) {
            this.a.w(executor, fzbVar);
        }
    }

    public void A(kzb kzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kzbVar) == null) {
            TLog.g(this, " OnPlayerFirstVideoFrameShowListener:" + kzbVar);
            synchronized (this.h) {
                if (kzbVar == null) {
                    this.h.clear();
                    return;
                }
                for (WeakReference<kzb> weakReference : this.h) {
                    if (weakReference.get() == kzbVar) {
                        TLog.g(this, " OnPlayerFirstVideoFrameShowListener dup:" + kzbVar);
                        return;
                    }
                }
                this.h.add(new WeakReference<>(kzbVar));
                this.a.z(this.i);
            }
        }
    }

    public void u(dzb dzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dzbVar) == null) {
            if (dzbVar == null) {
                TLog.g(this, "DataSource is null");
                return;
            }
            dzb dzbVar2 = this.b;
            if (dzbVar2 != null && TextUtils.equals(dzbVar2.k(), dzbVar.k())) {
                TLog.g(this, "setDataSourceAndPrepare pre taskid:" + this.b.j() + " cur taskId:" + dzbVar.j());
                dzbVar.q(this.b.j());
            }
            dzbVar.p(yyb.a());
            dzbVar.m(false);
            this.b = dzbVar;
            if (!this.d) {
                this.a.t(dzbVar);
                return;
            }
            TLog.g(this, "player has already started, need update DataSource when next start");
            this.e = true;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d = false;
            this.e = false;
            this.a.G();
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.g();
        }
        return invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.h();
        }
        return invokeV.longValue;
    }

    public rzb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f.get();
        }
        return (rzb) invokeV.objValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.finalize();
        }
    }

    public Object g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a.i();
        }
        return invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a.k();
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.l();
        }
        return invokeV.intValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.m();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.n();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.o();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.p();
        }
    }
}
