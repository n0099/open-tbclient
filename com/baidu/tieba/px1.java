package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.g72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class px1 extends ox1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ d72 b;
        public final /* synthetic */ g72 c;
        public final /* synthetic */ g72.b d;
        public final /* synthetic */ px1 e;

        public a(px1 px1Var, int i, d72 d72Var, g72 g72Var, g72.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px1Var, Integer.valueOf(i), d72Var, g72Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = px1Var;
            this.a = i;
            this.b = d72Var;
            this.c = g72Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    hk3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px1(@NonNull yv1 yv1Var) {
        super(yv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        x73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = x73.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public xz1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (xz1) invokeV.objValue;
    }

    public xz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<xz1, JSONObject> s = s(str);
            xz1 xz1Var = (xz1) s.first;
            if (!xz1Var.isSuccess()) {
                return xz1Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (xz1) invokeL.objValue;
    }

    public final xz1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        xx2 p3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            d13.b(uuid);
            g72 V = kt2.U().V();
            if (V == null) {
                x42.c("NavigateBackApi", "manager is null");
                return new xz1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                x42.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new xz1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            xx2 f = le3.f(uuid, i);
            d72 m = V.m();
            if (m == null) {
                x42.c("NavigateBackApi", "slave container is null");
                return new xz1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                x42.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new xz1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                d13.c(i2, uuid);
                g72.b i3 = V.i(str);
                i3.n(g72.i, g72.h);
                i3.h(i);
                rl3.a0(new a(this, k, m, V, i3));
                f72 o = V.o();
                if (o == null) {
                    p3 = null;
                } else {
                    p3 = o.p3();
                }
                c13.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                d13.a(uuid, p3);
                if (!(V.m() instanceof f72)) {
                    x42.c("NavigateBackApi", "top fragment error");
                    le3.i(f);
                    return new xz1(1001, "top fragment error");
                }
                f72 f72Var = (f72) V.m();
                if (f72Var != null) {
                    str2 = f72Var.w3();
                } else {
                    str2 = "";
                }
                return new xz1(0, gb3.c(str2));
            }
        }
        return (xz1) invokeCommon.objValue;
    }
}
