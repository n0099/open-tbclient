package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iv1 extends hv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ v42 b;
        public final /* synthetic */ y42 c;
        public final /* synthetic */ y42.b d;
        public final /* synthetic */ iv1 e;

        public a(iv1 iv1Var, int i, v42 v42Var, y42 y42Var, y42.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv1Var, Integer.valueOf(i), v42Var, y42Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = iv1Var;
            this.a = i;
            this.b = v42Var;
            this.c = y42Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    zh3.b(this.c, this.e.i(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z() {
        p53 c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (c0 = p53.c0()) != null) {
            c0.B().I(c0.getAppId());
        }
    }

    public qx1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideModalPage", false);
            z();
            return A(1, "hideModalPage", 10);
        }
        return (qx1) invokeV.objValue;
    }

    public final qx1 A(int i, String str, int i2) {
        InterceptResult invokeCommon;
        pv2 t3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            vy2.b(uuid);
            y42 W = cr2.V().W();
            if (W == null) {
                p22.c("NavigateBackApi", "manager is null");
                return new qx1(1001, "manager is null");
            }
            int k = W.k();
            if (k == 1) {
                p22.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new qx1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            pv2 f = dc3.f(uuid, i);
            v42 m = W.m();
            if (m == null) {
                p22.c("NavigateBackApi", "slave container is null");
                return new qx1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                p22.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new qx1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                vy2.c(i2, uuid);
                y42.b i3 = W.i(str);
                i3.n(y42.i, y42.h);
                i3.h(i);
                jj3.a0(new a(this, k, m, W, i3));
                x42 o = W.o();
                if (o == null) {
                    t3 = null;
                } else {
                    t3 = o.t3();
                }
                uy2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                vy2.a(uuid, t3);
                if (!(W.m() instanceof x42)) {
                    p22.c("NavigateBackApi", "top fragment error");
                    dc3.i(f);
                    return new qx1(1001, "top fragment error");
                }
                x42 x42Var = (x42) W.m();
                if (x42Var != null) {
                    str2 = x42Var.A3();
                } else {
                    str2 = "";
                }
                return new qx1(0, y83.c(str2));
            }
        }
        return (qx1) invokeCommon.objValue;
    }

    public qx1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#navigateBack params=" + str, false);
            z();
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            return A(((JSONObject) t.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (qx1) invokeL.objValue;
    }
}
