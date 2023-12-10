package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aic;
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
/* loaded from: classes8.dex */
public class vhc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xic a;
    public ahc b;
    public int c;
    public boolean d;
    public boolean e;
    public WeakReference<ohc> f;
    public aic.a g;
    public final List<WeakReference<hhc>> h;
    public final hhc i;

    /* loaded from: classes8.dex */
    public interface d {
        void a(Bitmap bitmap);
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "12.1.0.34" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements aic.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ vhc b;

        public a(vhc vhcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vhcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vhcVar;
            this.a = 0L;
        }

        @Override // com.baidu.tieba.aic.a
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

        @Override // com.baidu.tieba.aic.a
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

    /* loaded from: classes8.dex */
    public class b implements hhc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vhc a;

        public b(vhc vhcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vhcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vhcVar;
        }

        @Override // com.baidu.tieba.hhc
        public void onPlayerFirstVideoFrameShow(vhc vhcVar, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIII(1048576, this, vhcVar, i, i2, i3) != null) {
                return;
            }
            synchronized (this.a.h) {
                for (WeakReference weakReference : this.a.h) {
                    hhc hhcVar = (hhc) weakReference.get();
                    if (hhcVar != null) {
                        TLog.g(this, "ff notify " + hhcVar);
                        hhcVar.onPlayerFirstVideoFrameShow(vhcVar, i, i2, i3);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(vhc vhcVar, ArrayList<MixAudioExtraInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, vhcVar, arrayList) == null) {
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

    public vhc() {
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
            this.a.F(this.c, vgc.a());
            return this.c;
        }
        return invokeV.intValue;
    }

    public vhc(Context context, uhc uhcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uhcVar};
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
        if (vic.x(context)) {
            new WeakReference(context);
            sgc.a(context);
            sgc.b(context);
            if (Preference.f()) {
                uhcVar.m = Preference.g();
                TLog.h("[VodPlayer]", "global process config enabled, globalSubprocess=" + uhcVar.m);
            }
            if (uhcVar.m && Preference.h()) {
                uhcVar.m = false;
                TLog.h("[VodPlayer]", "subprocess fail over to main process, so set subprocess as false");
            }
            if (uhcVar.m && !blc.n().r()) {
                TLog.h("[VodPlayer]", "subprocess is not support in current devices!!");
                uhcVar.m = false;
            }
            if (uhcVar.m && !blc.n().o(context.getApplicationContext())) {
                TLog.h("[VodPlayer]", "subprocess fail as initSubProcess fail!!");
                uhcVar.m = false;
            }
            if (uhcVar.m && !blc.n().q()) {
                TLog.h("[VodPlayer]", "initSubProcess but subProcess is not connected, VodPlayer force start in main process !!!");
                uhcVar.m = false;
            }
            TLog.h("[VodPlayer]", uhcVar.toString());
            if (uhcVar.m) {
                zic zicVar = new zic(context.getApplicationContext(), uhcVar, this);
                this.a = zicVar;
                thc.a(zicVar);
            } else {
                this.a = new yic(context.getApplicationContext(), uhcVar, this);
            }
            aic.b(this.g);
            TLog.g(this, "VodPlayer, subprocess: " + uhcVar.m + ", vodplayer version : " + h());
            return;
        }
        throw new RuntimeException("dynamic load so enabled, make sure isLibReady returns true or onLibDownloadSuccess!");
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return vic.x(context);
        }
        return invokeL.booleanValue;
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            TLog.h("AudioFocus", " setAudioFocusEnable:" + z);
            thc.b(z);
        }
    }

    public void B(ihc ihcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ihcVar) == null) {
            this.a.A(ihcVar);
        }
    }

    public void C(nhc nhcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nhcVar) == null) {
            this.a.B(nhcVar);
        }
    }

    public void D(ohc ohcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ohcVar) == null) {
            this.a.C(ohcVar);
            this.f = new WeakReference<>(ohcVar);
        }
    }

    public void E(phc phcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, phcVar) == null) {
            this.a.D(phcVar);
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

    public void t(ahc ahcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ahcVar) == null) {
            ahcVar.p(0L);
            this.a.s(ahcVar);
            this.b = ahcVar;
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

    public void y(dhc dhcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, dhcVar) == null) {
            this.a.x(dhcVar);
        }
    }

    public void z(fhc fhcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fhcVar) == null) {
            this.a.y(fhcVar);
        }
    }

    public static void k(Context context, lic licVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, licVar) == null) {
            vic.r(context, null, licVar, null);
        }
    }

    public void q(Executor executor, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, executor, dVar) == null) {
            this.a.q(executor, dVar);
        }
    }

    public void x(Executor executor, chc chcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, executor, chcVar) == null) {
            this.a.w(executor, chcVar);
        }
    }

    public void A(hhc hhcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hhcVar) == null) {
            TLog.g(this, " OnPlayerFirstVideoFrameShowListener:" + hhcVar);
            synchronized (this.h) {
                if (hhcVar == null) {
                    this.h.clear();
                    return;
                }
                for (WeakReference<hhc> weakReference : this.h) {
                    if (weakReference.get() == hhcVar) {
                        TLog.g(this, " OnPlayerFirstVideoFrameShowListener dup:" + hhcVar);
                        return;
                    }
                }
                this.h.add(new WeakReference<>(hhcVar));
                this.a.z(this.i);
            }
        }
    }

    public void u(ahc ahcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, ahcVar) == null) {
            if (ahcVar == null) {
                TLog.g(this, "DataSource is null");
                return;
            }
            ahc ahcVar2 = this.b;
            if (ahcVar2 != null && TextUtils.equals(ahcVar2.k(), ahcVar.k())) {
                TLog.g(this, "setDataSourceAndPrepare pre taskid:" + this.b.j() + " cur taskId:" + ahcVar.j());
                ahcVar.q(this.b.j());
            }
            ahcVar.p(vgc.a());
            ahcVar.m(false);
            this.b = ahcVar;
            if (!this.d) {
                this.a.t(ahcVar);
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

    public ohc f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f.get();
        }
        return (ohc) invokeV.objValue;
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
