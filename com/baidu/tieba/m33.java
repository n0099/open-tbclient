package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.tieba.jo2;
import com.baidu.tieba.q33;
import com.baidu.tieba.z22;
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
/* loaded from: classes4.dex */
public class m33 extends u33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final boolean c;
    public SwanAppConfigData d;
    public v33 e;
    public va3 f;
    public pb3 g;
    public v73 h;
    public zj1 i;
    public xu2 j;
    public HttpManager k;
    public c43 l;
    public oq2 m;
    public yu2 n;
    public o33 o;
    public Map p;
    public final s33 q;
    public final jo2.a r;
    public boolean s;
    public String t;
    public boolean u;

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
    public m33 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this : (m33) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921692, "Lcom/baidu/tieba/m33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921692, "Lcom/baidu/tieba/m33;");
                return;
            }
        }
        v = wj1.a;
    }

    @Deprecated
    public static m33 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b0();
        }
        return (m33) invokeV.objValue;
    }

    public static m33 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            l33 K = l33.K();
            if (K.E()) {
                return K.q();
            }
            return null;
        }
        return (m33) invokeV.objValue;
    }

    @Deprecated
    public static String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return l33.K().getAppId();
        }
        return (String) invokeV.objValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.u0();
        }
    }

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q.w0();
        }
        return invokeV.intValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q.B0();
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.c && this.q.m0() && k() > -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public zj1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.i == null) {
                this.i = new zj1(this);
            }
            return this.i;
        }
        return (zj1) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return W().I();
        }
        return (String) invokeV.objValue;
    }

    public oq2 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.m == null) {
                this.m = new oq2(this);
            }
            return this.m;
        }
        return (oq2) invokeV.objValue;
    }

    public SwanAppConfigData Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.d;
        }
        return (SwanAppConfigData) invokeV.objValue;
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

    public v33 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return (v33) invokeV.objValue;
    }

    public o33 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.o == null) {
                this.o = new o33(this);
            }
            return this.o;
        }
        return (o33) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            jo2.a W = W();
            if (W != null) {
                return L(W.getType());
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public jo2.a W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.r;
        }
        return (jo2.a) invokeV.objValue;
    }

    @Deprecated
    public jo2.a Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return W();
        }
        return (jo2.a) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return W().K();
        }
        return (String) invokeV.objValue;
    }

    public synchronized xu2 a0() {
        InterceptResult invokeV;
        xu2 xu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new xu2(this);
                }
                xu2Var = this.j;
            }
            return xu2Var;
        }
        return (xu2) invokeV.objValue;
    }

    public v73 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.h == null) {
                this.h = new v73(this);
            }
            return this.h;
        }
        return (v73) invokeV.objValue;
    }

    public va3 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.f == null) {
                this.f = new va3(this);
            }
            return this.f;
        }
        return (va3) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return w();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public pb3 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.g == null) {
                if (w0()) {
                    this.g = new uf2();
                } else {
                    this.g = new rb3();
                }
            }
            return this.g;
        }
        return (pb3) invokeV.objValue;
    }

    public synchronized HttpManager i0() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            synchronized (this) {
                if (this.k == null) {
                    this.k = um2.l().a();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return W().v1();
        }
        return (String) invokeV.objValue;
    }

    public c43 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.l == null) {
                this.l = new c43();
            }
            return this.l;
        }
        return (c43) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
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

    public yu2 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.n == null) {
                this.n = new yu2();
            }
            return this.n;
        }
        return (yu2) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return q0(zo2.U().T());
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        lg2 Q;
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

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.q.l0();
        }
        return invokeV.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (W().G() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return TextUtils.equals("update_tag_by_app_launch", this.t);
        }
        return invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m33(p33 p33Var, String str) {
        super(p33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p33Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((p33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new s33(this);
        this.r = new jo2.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.b, "swan_id_unknown")) ? true : true;
        this.c = z;
        if (z) {
            c43 c43Var = new c43();
            this.l = c43Var;
            c43Var.f(this.b);
        }
        m02.k("SwanApp", "new SwanApp id = " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
    public void A(q33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((q33.a) aVar.update(S()));
        }
    }

    public void B0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            e0().w(activity);
        }
    }

    public void G0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppConfigData) == null) {
            this.d = swanAppConfigData;
        }
    }

    public void H0(v33 v33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v33Var) == null) {
            this.e = v33Var;
        }
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.t = str;
            m02.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public m33 J(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.s = z;
            p("event_first_action_launched");
            return this;
        }
        return (m33) invokeZ.objValue;
    }

    public void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.u = z;
        }
    }

    public jo2 K0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundle)) == null) {
            jo2.a W = W();
            W.update(bundle);
            return W;
        }
        return (jo2) invokeL.objValue;
    }

    public void M0(Set set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, set) == null) {
            this.q.J0(set);
        }
    }

    public void N0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, pMSAppInfo) != null) || pMSAppInfo == null) {
            return;
        }
        this.q.M0(pMSAppInfo);
    }

    public String R(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.m mVar;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null && (mVar = swanAppConfigData.d) != null && (map = mVar.a) != null) {
                return (String) map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String X(String str) {
        InterceptResult invokeL;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.p) == null) {
                return null;
            }
            return (String) map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public String d0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null) {
                return swanAppConfigData.h(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            v(str, S());
        }
    }

    public boolean q0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null) {
                return swanAppConfigData.o(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean r0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null && (eVar = swanAppConfigData.b) != null) {
                return eVar.c(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            return new File(zo2.U().z(), str).exists();
        }
        return invokeL.booleanValue;
    }

    public boolean v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return jb4.i().n(this.b, k0(), str);
        }
        return invokeL.booleanValue;
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
            zo2.b0();
            o33 o33Var = this.o;
            if (o33Var != null) {
                o33Var.g();
            }
            qj4.k(ua3.x(this.b));
            oq2 oq2Var = this.m;
            if (oq2Var != null) {
                oq2Var.E();
            }
            c43 c43Var = this.l;
            if (c43Var != null) {
                c43Var.g();
            }
            yu2 yu2Var = this.n;
            if (yu2Var != null) {
                yu2Var.d();
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
            boolean contains = p33.o0.contains(str);
            jo2.a W = W();
            HybridUbcFlow p = rw2.p("startup");
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
                s33.o0(W, W.f0(), false, false);
            }
            return this.q.l0();
        }
        return invokeLLZ.booleanValue;
    }

    public final String L(int i) {
        InterceptResult invokeI;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (i == 0) {
                jo2.a aVar = this.r;
                if (aVar != null) {
                    str = aVar.w1();
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = k0();
                }
                String f = gh3.f(str);
                Object[] objArr = new Object[1];
                if (TextUtils.isEmpty(f)) {
                    str2 = " version is empty ";
                } else {
                    str2 = f;
                }
                objArr[0] = str2;
                m02.b("SwanApp", objArr);
                return f;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public boolean t0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (lVar = swanAppConfigData.c) == null || (map = lVar.b) == null || !map.containsKey(str)) {
                return false;
            }
            if (v) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return ((Boolean) this.d.c.b.get(str)).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public void L0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.p == null) {
                this.p = new HashMap();
            }
            if (v) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.p.put(str2, str);
        }
    }

    public void O0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, str, z) == null) && !TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null && (lVar = swanAppConfigData.c) != null && lVar.b != null) {
            if (v) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.d.c.b.put(str, Boolean.valueOf(z));
        }
    }

    public String c0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null && (lVar = swanAppConfigData.c) != null && lVar.c != null) {
                return (String) this.d.c.c.get(e73.b(str));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        lg2 Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!m72.h()) {
                return false;
            }
            SwanAppActivity w = w();
            if (w == null || w.isFinishing() || w.isDestroyed() || (Q = w.Q()) == null) {
                return true;
            }
            return !Q.a0().hasStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u33, com.baidu.tieba.p33
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

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (z22.b.a()) {
                return true;
            }
            jo2.a W = W();
            if (W == null) {
                m02.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = W.f0();
            if (f0 == null) {
                m02.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                m02.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                m02.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
                if (f0.webPermit == 1) {
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
