package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.c72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class lx1 extends kx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ z62 b;
        public final /* synthetic */ c72 c;
        public final /* synthetic */ c72.b d;
        public final /* synthetic */ lx1 e;

        public a(lx1 lx1Var, int i, z62 z62Var, c72 c72Var, c72.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx1Var, Integer.valueOf(i), z62Var, c72Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = lx1Var;
            this.a = i;
            this.b = z62Var;
            this.c = c72Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    dk3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lx1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        t73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = t73.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public tz1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (tz1) invokeV.objValue;
    }

    public tz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<tz1, JSONObject> s = s(str);
            tz1 tz1Var = (tz1) s.first;
            if (!tz1Var.isSuccess()) {
                return tz1Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (tz1) invokeL.objValue;
    }

    public final tz1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        tx2 p3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            z03.b(uuid);
            c72 V = gt2.U().V();
            if (V == null) {
                t42.c("NavigateBackApi", "manager is null");
                return new tz1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                t42.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new tz1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            tx2 f = he3.f(uuid, i);
            z62 m = V.m();
            if (m == null) {
                t42.c("NavigateBackApi", "slave container is null");
                return new tz1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                t42.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new tz1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                z03.c(i2, uuid);
                c72.b i3 = V.i(str);
                i3.n(c72.i, c72.h);
                i3.h(i);
                nl3.a0(new a(this, k, m, V, i3));
                b72 o = V.o();
                if (o == null) {
                    p3 = null;
                } else {
                    p3 = o.p3();
                }
                y03.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                z03.a(uuid, p3);
                if (!(V.m() instanceof b72)) {
                    t42.c("NavigateBackApi", "top fragment error");
                    he3.i(f);
                    return new tz1(1001, "top fragment error");
                }
                b72 b72Var = (b72) V.m();
                if (b72Var != null) {
                    str2 = b72Var.w3();
                } else {
                    str2 = "";
                }
                return new tz1(0, cb3.c(str2));
            }
        }
        return (tz1) invokeCommon.objValue;
    }
}
