package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.p82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yy1 extends xy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jx1
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
        public final /* synthetic */ m82 b;
        public final /* synthetic */ p82 c;
        public final /* synthetic */ p82.b d;
        public final /* synthetic */ yy1 e;

        public a(yy1 yy1Var, int i, m82 m82Var, p82 p82Var, p82.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy1Var, Integer.valueOf(i), m82Var, p82Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yy1Var;
            this.a = i;
            this.b = m82Var;
            this.c = p82Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    ql3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy1(@NonNull hx1 hx1Var) {
        super(hx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        g93 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = g93.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public g12 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (g12) invokeV.objValue;
    }

    public g12 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (g12) invokeL.objValue;
    }

    public final g12 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        gz2 p3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            m23.b(uuid);
            p82 V = tu2.U().V();
            if (V == null) {
                g62.c("NavigateBackApi", "manager is null");
                return new g12(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                g62.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new g12(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            gz2 f = uf3.f(uuid, i);
            m82 m = V.m();
            if (m == null) {
                g62.c("NavigateBackApi", "slave container is null");
                return new g12(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                g62.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new g12(1001, "hideModalPage api can only work after showModalPage");
            } else {
                m23.c(i2, uuid);
                p82.b i3 = V.i(str);
                i3.n(p82.i, p82.h);
                i3.h(i);
                an3.a0(new a(this, k, m, V, i3));
                o82 o = V.o();
                if (o == null) {
                    p3 = null;
                } else {
                    p3 = o.p3();
                }
                l23.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                m23.a(uuid, p3);
                if (!(V.m() instanceof o82)) {
                    g62.c("NavigateBackApi", "top fragment error");
                    uf3.i(f);
                    return new g12(1001, "top fragment error");
                }
                o82 o82Var = (o82) V.m();
                if (o82Var != null) {
                    str2 = o82Var.w3();
                } else {
                    str2 = "";
                }
                return new g12(0, pc3.c(str2));
            }
        }
        return (g12) invokeCommon.objValue;
    }
}
