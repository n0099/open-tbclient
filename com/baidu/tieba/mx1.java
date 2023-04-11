package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.d72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mx1 extends lx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xv1
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
        public final /* synthetic */ a72 b;
        public final /* synthetic */ d72 c;
        public final /* synthetic */ d72.b d;
        public final /* synthetic */ mx1 e;

        public a(mx1 mx1Var, int i, a72 a72Var, d72 d72Var, d72.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx1Var, Integer.valueOf(i), a72Var, d72Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mx1Var;
            this.a = i;
            this.b = a72Var;
            this.c = d72Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    ek3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mx1(@NonNull vv1 vv1Var) {
        super(vv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        u73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = u73.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public uz1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (uz1) invokeV.objValue;
    }

    public uz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                return uz1Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (uz1) invokeL.objValue;
    }

    public final uz1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        ux2 p3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            a13.b(uuid);
            d72 V = ht2.U().V();
            if (V == null) {
                u42.c("NavigateBackApi", "manager is null");
                return new uz1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                u42.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new uz1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            ux2 f = ie3.f(uuid, i);
            a72 m = V.m();
            if (m == null) {
                u42.c("NavigateBackApi", "slave container is null");
                return new uz1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                u42.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new uz1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                a13.c(i2, uuid);
                d72.b i3 = V.i(str);
                i3.n(d72.i, d72.h);
                i3.h(i);
                ol3.a0(new a(this, k, m, V, i3));
                c72 o = V.o();
                if (o == null) {
                    p3 = null;
                } else {
                    p3 = o.p3();
                }
                z03.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                a13.a(uuid, p3);
                if (!(V.m() instanceof c72)) {
                    u42.c("NavigateBackApi", "top fragment error");
                    ie3.i(f);
                    return new uz1(1001, "top fragment error");
                }
                c72 c72Var = (c72) V.m();
                if (c72Var != null) {
                    str2 = c72Var.w3();
                } else {
                    str2 = "";
                }
                return new uz1(0, db3.c(str2));
            }
        }
        return (uz1) invokeCommon.objValue;
    }
}
