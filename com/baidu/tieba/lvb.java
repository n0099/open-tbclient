package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qvb;
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
/* loaded from: classes6.dex */
public class lvb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nwb a;
    public qub b;
    public int c;
    public boolean d;
    public boolean e;
    public WeakReference<evb> f;
    public qvb.a g;
    public final List<WeakReference<xub>> h;
    public final xub i;

    /* loaded from: classes6.dex */
    public interface d {
        void a(Bitmap bitmap);
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "12.1.0.34" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements qvb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ lvb b;

        public a(lvb lvbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lvbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lvbVar;
            this.a = 0L;
        }

        @Override // com.baidu.tieba.qvb.a
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

        @Override // com.baidu.tieba.qvb.a
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

    /* loaded from: classes6.dex */
    public class b implements xub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lvb a;

        public b(lvb lvbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lvbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lvbVar;
        }

        @Override // com.baidu.tieba.xub
        public void onPlayerFirstVideoFrameShow(lvb lvbVar, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIII(1048576, this, lvbVar, i, i2, i3) != null) {
                return;
            }
            synchronized (this.a.h) {
                for (WeakReference weakReference : this.a.h) {
                    xub xubVar = (xub) weakReference.get();
                    if (xubVar != null) {
                        TLog.g(this, "ff notify " + xubVar);
                        xubVar.onPlayerFirstVideoFrameShow(lvbVar, i, i2, i3);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(lvb lvbVar, ArrayList<MixAudioExtraInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, lvbVar, arrayList) == null) {
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

    public lvb() {
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
            this.a.F(this.c, lub.a());
            return this.c;
        }
        return invokeV.intValue;
    }

    public lvb(Context context, kvb kvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kvbVar};
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
        if (lwb.x(context)) {
            new WeakReference(context);
            iub.a(context);
            iub.b(context);
            if (Preference.f()) {
                kvbVar.m = Preference.g();
                TLog.h("[VodPlayer]", "global process config enabled, globalSubprocess=" + kvbVar.m);
            }
            if (kvbVar.m && Preference.h()) {
                kvbVar.m = false;
                TLog.h("[VodPlayer]", "subprocess fail over to main process, so set subprocess as false");
            }
            if (kvbVar.m && !ryb.n().r()) {
                TLog.h("[VodPlayer]", "subprocess is not support in current devices!!");
                kvbVar.m = false;
            }
            if (kvbVar.m && !ryb.n().o(context.getApplicationContext())) {
                TLog.h("[VodPlayer]", "subprocess fail as initSubProcess fail!!");
                kvbVar.m = false;
            }
            if (kvbVar.m && !ryb.n().q()) {
                TLog.h("[VodPlayer]", "initSubProcess but subProcess is not connected, VodPlayer force start in main process !!!");
                kvbVar.m = false;
            }
            TLog.h("[VodPlayer]", kvbVar.toString());
            if (kvbVar.m) {
                pwb pwbVar = new pwb(context.getApplicationContext(), kvbVar, this);
                this.a = pwbVar;
                jvb.a(pwbVar);
            } else {
                this.a = new owb(context.getApplicationContext(), kvbVar, this);
            }
            qvb.b(this.g);
            TLog.g(this, "VodPlayer, subprocess: " + kvbVar.m + ", vodplayer version : " + h());
            return;
        }
        throw new RuntimeException("dynamic load so enabled, make sure isLibReady returns true or onLibDownloadSuccess!");
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return lwb.x(context);
        }
        return invokeL.booleanValue;
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            TLog.h("AudioFocus", " setAudioFocusEnable:" + z);
            jvb.b(z);
        }
    }

    public void B(yub yubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yubVar) == null) {
            this.a.A(yubVar);
        }
    }

    public void C(dvb dvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dvbVar) == null) {
            this.a.B(dvbVar);
        }
    }

    public void D(evb evbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, evbVar) == null) {
            this.a.C(evbVar);
            this.f = new WeakReference<>(evbVar);
        }
    }

    public void E(fvb fvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fvbVar) == null) {
            this.a.D(fvbVar);
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

    public void t(qub qubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, qubVar) == null) {
            qubVar.p(0L);
            this.a.s(qubVar);
            this.b = qubVar;
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

    public void y(tub tubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, tubVar) == null) {
            this.a.x(tubVar);
        }
    }

    public void z(vub vubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, vubVar) == null) {
            this.a.y(vubVar);
        }
    }

    public static void k(Context context, bwb bwbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, bwbVar) == null) {
            lwb.r(context, null, bwbVar, null);
        }
    }

    public void q(Executor executor, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, executor, dVar) == null) {
            this.a.q(executor, dVar);
        }
    }

    public void x(Executor executor, sub subVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, executor, subVar) == null) {
            this.a.w(executor, subVar);
        }
    }

    public void A(xub xubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xubVar) == null) {
            TLog.g(this, " OnPlayerFirstVideoFrameShowListener:" + xubVar);
            synchronized (this.h) {
                if (xubVar == null) {
                    this.h.clear();
                    return;
                }
                for (WeakReference<xub> weakReference : this.h) {
                    if (weakReference.get() == xubVar) {
                        TLog.g(this, " OnPlayerFirstVideoFrameShowListener dup:" + xubVar);
                        return;
                    }
                }
                this.h.add(new WeakReference<>(xubVar));
                this.a.z(this.i);
            }
        }
    }

    public void u(qub qubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, qubVar) == null) {
            if (qubVar == null) {
                TLog.g(this, "DataSource is null");
                return;
            }
            qub qubVar2 = this.b;
            if (qubVar2 != null && TextUtils.equals(qubVar2.k(), qubVar.k())) {
                TLog.g(this, "setDataSourceAndPrepare pre taskid:" + this.b.j() + " cur taskId:" + qubVar.j());
                qubVar.q(this.b.j());
            }
            qubVar.p(lub.a());
            qubVar.m(false);
            this.b = qubVar;
            if (!this.d) {
                this.a.t(qubVar);
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

    public evb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f.get();
        }
        return (evb) invokeV.objValue;
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
