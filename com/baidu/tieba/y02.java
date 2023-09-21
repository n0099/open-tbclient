package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.pa2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y02 extends x02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ma2 b;
        public final /* synthetic */ pa2 c;
        public final /* synthetic */ pa2.b d;
        public final /* synthetic */ y02 e;

        public a(y02 y02Var, int i, ma2 ma2Var, pa2 pa2Var, pa2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y02Var, Integer.valueOf(i), ma2Var, pa2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y02Var;
            this.a = i;
            this.b = ma2Var;
            this.c = pa2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    qn3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y02(@NonNull hz1 hz1Var) {
        super(hz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        gb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = gb3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public g32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (g32) invokeV.objValue;
    }

    public g32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<g32, JSONObject> s = s(str);
            g32 g32Var = (g32) s.first;
            if (!g32Var.isSuccess()) {
                return g32Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (g32) invokeL.objValue;
    }

    public final g32 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        g13 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            m43.b(uuid);
            pa2 U = tw2.T().U();
            if (U == null) {
                g82.c("NavigateBackApi", "manager is null");
                return new g32(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                g82.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new g32(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            g13 f = uh3.f(uuid, i);
            ma2 m = U.m();
            if (m == null) {
                g82.c("NavigateBackApi", "slave container is null");
                return new g32(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                g82.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new g32(1001, "hideModalPage api can only work after showModalPage");
            } else {
                m43.c(i2, uuid);
                pa2.b i3 = U.i(str);
                i3.n(pa2.i, pa2.h);
                i3.h(i);
                ap3.a0(new a(this, k, m, U, i3));
                oa2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                l43.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                m43.a(uuid, o3);
                if (!(U.m() instanceof oa2)) {
                    g82.c("NavigateBackApi", "top fragment error");
                    uh3.i(f);
                    return new g32(1001, "top fragment error");
                }
                oa2 oa2Var = (oa2) U.m();
                if (oa2Var != null) {
                    str2 = oa2Var.v3();
                } else {
                    str2 = "";
                }
                return new g32(0, pe3.c(str2));
            }
        }
        return (g32) invokeCommon.objValue;
    }
}
