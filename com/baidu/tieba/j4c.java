package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o4c;
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
public class j4c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l5c a;
    public o3c b;
    public int c;
    public boolean d;
    public boolean e;
    public WeakReference<c4c> f;
    public o4c.a g;
    public final List<WeakReference<v3c>> h;
    public final v3c i;

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
    public class a implements o4c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ j4c b;

        public a(j4c j4cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j4cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j4cVar;
            this.a = 0L;
        }

        @Override // com.baidu.tieba.o4c.a
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

        @Override // com.baidu.tieba.o4c.a
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
    public class b implements v3c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j4c a;

        public b(j4c j4cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j4cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j4cVar;
        }

        @Override // com.baidu.tieba.v3c
        public void onPlayerFirstVideoFrameShow(j4c j4cVar, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIII(1048576, this, j4cVar, i, i2, i3) != null) {
                return;
            }
            synchronized (this.a.h) {
                for (WeakReference weakReference : this.a.h) {
                    v3c v3cVar = (v3c) weakReference.get();
                    if (v3cVar != null) {
                        TLog.g(this, "ff notify " + v3cVar);
                        v3cVar.onPlayerFirstVideoFrameShow(j4cVar, i, i2, i3);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(j4c j4cVar, ArrayList<MixAudioExtraInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, j4cVar, arrayList) == null) {
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

    public j4c() {
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
            this.a.F(this.c, j3c.a());
            return this.c;
        }
        return invokeV.intValue;
    }

    public j4c(Context context, i4c i4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, i4cVar};
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
        if (j5c.x(context)) {
            new WeakReference(context);
            g3c.a(context);
            g3c.b(context);
            if (Preference.f()) {
                i4cVar.m = Preference.g();
                TLog.h("[VodPlayer]", "global process config enabled, globalSubprocess=" + i4cVar.m);
            }
            if (i4cVar.m && Preference.h()) {
                i4cVar.m = false;
                TLog.h("[VodPlayer]", "subprocess fail over to main process, so set subprocess as false");
            }
            if (i4cVar.m && !p7c.n().r()) {
                TLog.h("[VodPlayer]", "subprocess is not support in current devices!!");
                i4cVar.m = false;
            }
            if (i4cVar.m && !p7c.n().o(context.getApplicationContext())) {
                TLog.h("[VodPlayer]", "subprocess fail as initSubProcess fail!!");
                i4cVar.m = false;
            }
            if (i4cVar.m && !p7c.n().q()) {
                TLog.h("[VodPlayer]", "initSubProcess but subProcess is not connected, VodPlayer force start in main process !!!");
                i4cVar.m = false;
            }
            TLog.h("[VodPlayer]", i4cVar.toString());
            if (i4cVar.m) {
                n5c n5cVar = new n5c(context.getApplicationContext(), i4cVar, this);
                this.a = n5cVar;
                h4c.a(n5cVar);
            } else {
                this.a = new m5c(context.getApplicationContext(), i4cVar, this);
            }
            o4c.b(this.g);
            TLog.g(this, "VodPlayer, subprocess: " + i4cVar.m + ", vodplayer version : " + h());
            return;
        }
        throw new RuntimeException("dynamic load so enabled, make sure isLibReady returns true or onLibDownloadSuccess!");
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return j5c.x(context);
        }
        return invokeL.booleanValue;
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            TLog.h("AudioFocus", " setAudioFocusEnable:" + z);
            h4c.b(z);
        }
    }

    public void B(w3c w3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w3cVar) == null) {
            this.a.A(w3cVar);
        }
    }

    public void C(b4c b4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b4cVar) == null) {
            this.a.B(b4cVar);
        }
    }

    public void D(c4c c4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c4cVar) == null) {
            this.a.C(c4cVar);
            this.f = new WeakReference<>(c4cVar);
        }
    }

    public void E(d4c d4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d4cVar) == null) {
            this.a.D(d4cVar);
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

    public void t(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, o3cVar) == null) {
            o3cVar.p(0L);
            this.a.s(o3cVar);
            this.b = o3cVar;
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

    public void y(r3c r3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, r3cVar) == null) {
            this.a.x(r3cVar);
        }
    }

    public void z(t3c t3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, t3cVar) == null) {
            this.a.y(t3cVar);
        }
    }

    public static void k(Context context, z4c z4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, z4cVar) == null) {
            j5c.r(context, null, z4cVar, null);
        }
    }

    public void q(Executor executor, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, executor, dVar) == null) {
            this.a.q(executor, dVar);
        }
    }

    public void x(Executor executor, q3c q3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, executor, q3cVar) == null) {
            this.a.w(executor, q3cVar);
        }
    }

    public void A(v3c v3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v3cVar) == null) {
            TLog.g(this, " OnPlayerFirstVideoFrameShowListener:" + v3cVar);
            synchronized (this.h) {
                if (v3cVar == null) {
                    this.h.clear();
                    return;
                }
                for (WeakReference<v3c> weakReference : this.h) {
                    if (weakReference.get() == v3cVar) {
                        TLog.g(this, " OnPlayerFirstVideoFrameShowListener dup:" + v3cVar);
                        return;
                    }
                }
                this.h.add(new WeakReference<>(v3cVar));
                this.a.z(this.i);
            }
        }
    }

    public void u(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, o3cVar) == null) {
            if (o3cVar == null) {
                TLog.g(this, "DataSource is null");
                return;
            }
            o3c o3cVar2 = this.b;
            if (o3cVar2 != null && TextUtils.equals(o3cVar2.k(), o3cVar.k())) {
                TLog.g(this, "setDataSourceAndPrepare pre taskid:" + this.b.j() + " cur taskId:" + o3cVar.j());
                o3cVar.q(this.b.j());
            }
            o3cVar.p(j3c.a());
            o3cVar.m(false);
            this.b = o3cVar;
            if (!this.d) {
                this.a.t(o3cVar);
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

    public c4c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f.get();
        }
        return (c4c) invokeV.objValue;
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
