package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.e72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nx1 extends mx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yv1
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
        public final /* synthetic */ b72 b;
        public final /* synthetic */ e72 c;
        public final /* synthetic */ e72.b d;
        public final /* synthetic */ nx1 e;

        public a(nx1 nx1Var, int i, b72 b72Var, e72 e72Var, e72.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, Integer.valueOf(i), b72Var, e72Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nx1Var;
            this.a = i;
            this.b = b72Var;
            this.c = e72Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    fk3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nx1(@NonNull wv1 wv1Var) {
        super(wv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        v73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = v73.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public vz1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (vz1) invokeV.objValue;
    }

    public vz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<vz1, JSONObject> s = s(str);
            vz1 vz1Var = (vz1) s.first;
            if (!vz1Var.isSuccess()) {
                return vz1Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (vz1) invokeL.objValue;
    }

    public final vz1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        vx2 p3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            b13.b(uuid);
            e72 V = it2.U().V();
            if (V == null) {
                v42.c("NavigateBackApi", "manager is null");
                return new vz1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                v42.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new vz1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            vx2 f = je3.f(uuid, i);
            b72 m = V.m();
            if (m == null) {
                v42.c("NavigateBackApi", "slave container is null");
                return new vz1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                v42.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new vz1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                b13.c(i2, uuid);
                e72.b i3 = V.i(str);
                i3.n(e72.i, e72.h);
                i3.h(i);
                pl3.a0(new a(this, k, m, V, i3));
                d72 o = V.o();
                if (o == null) {
                    p3 = null;
                } else {
                    p3 = o.p3();
                }
                a13.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                b13.a(uuid, p3);
                if (!(V.m() instanceof d72)) {
                    v42.c("NavigateBackApi", "top fragment error");
                    je3.i(f);
                    return new vz1(1001, "top fragment error");
                }
                d72 d72Var = (d72) V.m();
                if (d72Var != null) {
                    str2 = d72Var.w3();
                } else {
                    str2 = "";
                }
                return new vz1(0, eb3.c(str2));
            }
        }
        return (vz1) invokeCommon.objValue;
    }
}
