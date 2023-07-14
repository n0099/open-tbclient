package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.hx2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public final class ix2 implements hx2.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static AtomicLong c;
    public static final Lock d;
    public static volatile ix2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public gx2 a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends ex2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ix2 ix2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(ix2 ix2Var, a aVar) {
            this(ix2Var);
        }

        @Override // com.baidu.tieba.ex2
        public void P() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.P();
            }
        }

        @Override // com.baidu.tieba.gx2
        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.h;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947868806, "Lcom/baidu/tieba/ix2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947868806, "Lcom/baidu/tieba/ix2;");
                return;
            }
        }
        b = fs1.a;
        c = new AtomicLong(0L);
        d = new ReentrantLock();
    }

    public static ix2 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d.lock();
            try {
                if (e == null) {
                    e = new ix2();
                }
                return e;
            } finally {
                d.unlock();
            }
        }
        return (ix2) invokeV.objValue;
    }

    public static void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            d.lock();
            try {
                if (e == null) {
                    return;
                }
                if (e.a != null) {
                    e.a.N();
                }
                e = null;
            } finally {
                d.unlock();
            }
        }
    }

    public ix2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b(this, null);
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.C();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public vb3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.D();
        }
        return (vb3) invokeV.objValue;
    }

    public jt1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.F();
        }
        return (jt1) invokeV.objValue;
    }

    public yj3 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.G();
        }
        return (yj3) invokeV.objValue;
    }

    public db2 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.H();
        }
        return (db2) invokeV.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.M();
        }
        return invokeV.booleanValue;
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return c.get();
        }
        return invokeV.longValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return pp3.n().e();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public eb2 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity activity = T().getActivity();
            if (activity == null) {
                return null;
            }
            return activity.Y();
        }
        return (eb2) invokeV.objValue;
    }

    public mt1 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.a.O();
        }
        return (mt1) invokeV.objValue;
    }

    public mt1 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a.L();
        }
        return (mt1) invokeV.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (Y() && this.a.getActivity() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            gx2 gx2Var = this.a;
            if (gx2Var != null && !(gx2Var instanceof b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            long incrementAndGet = c.incrementAndGet();
            if (b) {
                Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a.a();
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.a.b();
        }
        return (String) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.a.c();
        }
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.a.exit();
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.a.g();
        }
        return (String) invokeV.objValue;
    }

    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.a.getActivity();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a.getCoreVersion();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public cy1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.a.i();
        }
        return (cy1) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.a.o();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.a.p();
        }
    }

    @DebugTrace
    public ay1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.a.q();
        }
        return (ay1) invokeV.objValue;
    }

    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.a.r();
        }
        return (Pair) invokeV.objValue;
    }

    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.a.s();
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.a.v();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.a.w();
        }
    }

    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.a.x();
        }
        return (Pair) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.a.z();
        }
        return (String) invokeV.objValue;
    }

    public dy1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.a.A(str);
        }
        return (dy1) invokeL.objValue;
    }

    public View B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.a.B(str);
        }
        return (View) invokeL.objValue;
    }

    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
            return this.a.J(activity);
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.a.K(str);
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || Y()) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                this.a = dv2.a();
                return;
            }
            return;
        }
        this.a = new fx2();
    }

    @NonNull
    public kc3 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            return this.a.f(str);
        }
        return (kc3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hx2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.a.h(i);
        }
    }

    public kc3 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            return this.a.j(str);
        }
        return (kc3) invokeL.objValue;
    }

    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, swanAppActivity) == null) {
            if (swanAppActivity != null && !Y()) {
                P(swanAppActivity.S());
            }
            if (Y()) {
                this.a.l(swanAppActivity);
            }
        }
    }

    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, activity)) == null) {
            return this.a.n(activity);
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, context) == null) {
            this.a.registerReceiver(context);
        }
    }

    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, intent) == null) {
            this.a.t(intent);
        }
    }

    public void u(vl2 vl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, vl2Var) == null) {
            this.a.u(vl2Var);
        }
    }

    public void unregisterReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, context) == null) {
            this.a.unregisterReceiver(context);
        }
    }

    public void E(sw2 sw2Var, pu2 pu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sw2Var, pu2Var) == null) {
            this.a.E(sw2Var, pu2Var);
        }
    }

    public void d(sw2 sw2Var, pu2 pu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, sw2Var, pu2Var) == null) {
            this.a.d(sw2Var, pu2Var);
        }
    }

    public void m(String str, vl2 vl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, vl2Var) == null) {
            this.a.m(str, vl2Var);
        }
    }

    public void y(yl2 yl2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, yl2Var, z) == null) {
            this.a.y(yl2Var, z);
        }
    }

    public void Q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long decrementAndGet = c.decrementAndGet();
            SwanAppActivity w = ub3.K().w();
            if (decrementAndGet <= 0 && w != null && w.f0()) {
                this.a.I();
            }
            if (b) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrementBgThreadAliveCount: count = ");
                sb.append(decrementAndGet);
                sb.append("isBackground = ");
                if (w != null && w.f0()) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.i("SwanAppController", sb.toString());
            }
        }
    }

    @NonNull
    public kc3 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            return this.a.e(str, swanAppConfigData, str2);
        }
        return (kc3) invokeLLL.objValue;
    }
}
