package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.c33;
import com.baidu.tieba.l22;
import com.baidu.tieba.vn2;
import com.baidu.tieba.xd4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class y23 extends g33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final boolean c;
    public SwanAppConfigData d;
    public h33 e;
    public ha3 f;
    public bb3 g;
    public h73 h;
    public lj1 i;
    public ju2 j;
    public HttpManager k;
    public o33 l;
    public aq2 m;
    public ku2 n;
    public a33 o;
    public Map<String, String> p;
    public final e33 q;
    public final vn2.a r;
    public boolean s;
    public String t;
    public boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948278223, "Lcom/baidu/tieba/y23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948278223, "Lcom/baidu/tieba/y23;");
                return;
            }
        }
        v = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y23(b33 b33Var, String str) {
        super(b33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b33Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new e33(this);
        this.r = new vn2.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.b, "swan_id_unknown")) ? true : true;
        this.c = z;
        if (z) {
            o33 o33Var = new o33();
            this.l = o33Var;
            o33Var.f(this.b);
        }
        yz1.k("SwanApp", "new SwanApp id = " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Deprecated
    public static y23 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b0() : (y23) invokeV.objValue;
    }

    public static y23 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            x23 K = x23.K();
            if (K.E()) {
                return K.q();
            }
            return null;
        }
        return (y23) invokeV.objValue;
    }

    @Deprecated
    public static String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? x23.K().getAppId() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public void A(c33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((c33.a) aVar.update(S()));
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.u0();
        }
    }

    public void B0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            e0().w(activity);
        }
    }

    public String C0(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
            if (v) {
                Log.d("SwanApp", "——> release client Id " + this.b);
            }
            SwanAppActivity w = w();
            if (w != null && !w.isDestroyed() && !w.isFinishing() && w.Z()) {
                w.x0(strArr);
            }
            lo2.b0();
            a33 a33Var = this.o;
            if (a33Var != null) {
                a33Var.g();
            }
            cj4.k(ga3.x(this.b));
            aq2 aq2Var = this.m;
            if (aq2Var != null) {
                aq2Var.E();
            }
            o33 o33Var = this.l;
            if (o33Var != null) {
                o33Var.g();
            }
            ku2 ku2Var = this.n;
            if (ku2Var != null) {
                ku2Var.d();
            }
            this.f = null;
            this.h = null;
            this.k = null;
            this.s = false;
            return this.b;
        }
        return (String) invokeL.objValue;
    }

    public boolean D0(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, bundle, str, z)) == null) {
            boolean contains = b33.o0.contains(str);
            vn2.a W = W();
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.q.m0() && p0()) {
                if (W.c("swanCoreVersion")) {
                    bundle.remove("swanCoreVersion");
                    bundle.remove("extensionCore");
                }
                if (W.c("pms_db_info_onload")) {
                    bundle.remove("pms_db_info_onload");
                }
            }
            bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
            W.update(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            if (z) {
                p("event_on_app_occupied");
            }
            if (this.c && !this.q.m0() && !this.q.l0()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                this.q.q0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
                return true;
            }
            if (this.q.m0() && contains) {
                e33.o0(W, W.f0(), false, false);
            }
            return this.q.l0();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q.w0() : invokeV.intValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q.B0() : invokeV.booleanValue;
    }

    public void G0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppConfigData) == null) {
            this.d = swanAppConfigData;
        }
    }

    public void H0(h33 h33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, h33Var) == null) {
            this.e = h33Var;
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c && this.q.m0() && k() > -1 : invokeV.booleanValue;
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.t = str;
            yz1.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public y23 J(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.s = z;
            p("event_first_action_launched");
            return this;
        }
        return (y23) invokeZ.objValue;
    }

    public void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.u = z;
        }
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public vn2 K0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundle)) == null) {
            vn2.a W = W();
            W.update(bundle);
            return W;
        }
        return (vn2) invokeL.objValue;
    }

    public final String L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (i == 0) {
                vn2.a aVar = this.r;
                String w1 = aVar != null ? aVar.w1() : "";
                if (TextUtils.isEmpty(w1)) {
                    w1 = k0();
                }
                String f = sg3.f(w1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f) ? " version is empty " : f;
                yz1.b("SwanApp", objArr);
                return f;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public void L0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.p == null) {
            this.p = new HashMap();
        }
        if (v) {
            Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
        }
        this.p.put(str2, str);
    }

    public void M0(Set<xd4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, set) == null) {
            this.q.J0(set);
        }
    }

    public lj1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.i == null) {
                this.i = new lj1(this);
            }
            return this.i;
        }
        return (lj1) invokeV.objValue;
    }

    public void N0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        this.q.M0(pMSAppInfo);
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? W().I() : (String) invokeV.objValue;
    }

    public void O0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, str, z) == null) || TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (lVar = swanAppConfigData.c) == null || lVar.b == null) {
            return;
        }
        if (v) {
            Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
        }
        this.d.c.b.put(str, Boolean.valueOf(z));
    }

    public aq2 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.m == null) {
                this.m = new aq2(this);
            }
            return this.m;
        }
        return (aq2) invokeV.objValue;
    }

    public SwanAppConfigData Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.d : (SwanAppConfigData) invokeV.objValue;
    }

    public String R(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.m mVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData == null || (mVar = swanAppConfigData.d) == null || (map = mVar.a) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public final Bundle S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", this.b);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public h33 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.e : (h33) invokeV.objValue;
    }

    @NonNull
    public a33 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.o == null) {
                this.o = new a33(this);
            }
            return this.o;
        }
        return (a33) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            vn2.a W = W();
            return W != null ? L(W.getType()) : "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public vn2.a W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.r : (vn2.a) invokeV.objValue;
    }

    @Nullable
    public String X(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.p) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public vn2.a Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? W() : (vn2.a) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? W().K() : (String) invokeV.objValue;
    }

    public synchronized ju2 a0() {
        InterceptResult invokeV;
        ju2 ju2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new ju2(this);
                }
                ju2Var = this.j;
            }
            return ju2Var;
        }
        return (ju2) invokeV.objValue;
    }

    public String c0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData == null || (lVar = swanAppConfigData.c) == null || lVar.c == null) {
                return null;
            }
            return this.d.c.c.get(q63.b(str));
        }
        return (String) invokeL.objValue;
    }

    public String d0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            return swanAppConfigData != null ? swanAppConfigData.h(str) : "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public h73 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.h == null) {
                this.h = new h73(this);
            }
            return this.h;
        }
        return (h73) invokeV.objValue;
    }

    public ha3 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.f == null) {
                this.f = new ha3(this);
            }
            return this.f;
        }
        return (ha3) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? w() : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public bb3 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.g == null) {
                if (w0()) {
                    this.g = new gf2();
                } else {
                    this.g = new db3();
                }
            }
            return this.g;
        }
        return (bb3) invokeV.objValue;
    }

    public synchronized HttpManager i0() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            synchronized (this) {
                if (this.k == null) {
                    this.k = gm2.l().a();
                }
                httpManager = this.k;
            }
            return httpManager;
        }
        return (HttpManager) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.c) {
                return W().G();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? W().v1() : (String) invokeV.objValue;
    }

    public o33 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.l == null) {
                this.l = new o33();
            }
            return this.l;
        }
        return (o33) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public SwanAppCores m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            SwanAppCores swanAppCores = new SwanAppCores();
            swanAppCores.setSwanCoreVersion(W().j0());
            swanAppCores.setExtensionCore(W().O());
            return swanAppCores;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    public ku2 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.n == null) {
                this.n = new ku2();
            }
            return this.n;
        }
        return (ku2) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        xf2 Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (y62.h()) {
                SwanAppActivity w = w();
                if (w == null || w.isFinishing() || w.isDestroyed() || (Q = w.Q()) == null) {
                    return true;
                }
                return !Q.a0().hasStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? q0(lo2.U().T()) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            v(str, S());
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        xf2 Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            SwanAppActivity w = w();
            if (w == null || (Q = w.Q()) == null) {
                return false;
            }
            return Q.a0().hasCreated();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public y23 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this : (y23) invokeV.objValue;
    }

    public boolean q0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null) {
                return false;
            }
            return swanAppConfigData.o(str);
        }
        return invokeL.booleanValue;
    }

    public boolean r0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (eVar = swanAppConfigData.b) == null) {
                return false;
            }
            return eVar.c(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            e0().l();
            f0().d(true);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.q.l0() : invokeV.booleanValue;
    }

    public boolean t0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (lVar = swanAppConfigData.c) == null || (map = lVar.b) == null || !map.containsKey(str)) {
                return false;
            }
            if (v) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.d.c.b.get(str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) ? new File(lo2.U().z(), str).exists() : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public void v(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, str, bundle) == null) {
            if (bundle == null) {
                bundle = S();
            } else {
                bundle.putAll(S());
            }
            super.v(str, bundle);
        }
    }

    public boolean v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return va4.i().n(this.b, k0(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? W().G() == 1 : invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? TextUtils.equals("update_tag_by_app_launch", this.t) : invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (l22.b.a()) {
                return true;
            }
            vn2.a W = W();
            if (W == null) {
                yz1.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = W.f0();
            if (f0 == null) {
                yz1.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                yz1.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                yz1.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
                return f0.webPermit == 1;
            }
        }
        return invokeV.booleanValue;
    }
}
