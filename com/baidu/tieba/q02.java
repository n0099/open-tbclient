package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ha2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q02 extends p02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ea2 b;
        public final /* synthetic */ ha2 c;
        public final /* synthetic */ ha2.b d;
        public final /* synthetic */ q02 e;

        public a(q02 q02Var, int i, ea2 ea2Var, ha2 ha2Var, ha2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q02Var, Integer.valueOf(i), ea2Var, ha2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q02Var;
            this.a = i;
            this.b = ea2Var;
            this.c = ha2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    in3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q02(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zy1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        ya3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = ya3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public y22 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (y22) invokeV.objValue;
    }

    public y22 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (y22) invokeL.objValue;
    }

    public final y22 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        y03 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            e43.b(uuid);
            ha2 U = lw2.T().U();
            if (U == null) {
                y72.c("NavigateBackApi", "manager is null");
                return new y22(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                y72.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new y22(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            y03 f = mh3.f(uuid, i);
            ea2 m = U.m();
            if (m == null) {
                y72.c("NavigateBackApi", "slave container is null");
                return new y22(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                y72.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new y22(1001, "hideModalPage api can only work after showModalPage");
            } else {
                e43.c(i2, uuid);
                ha2.b i3 = U.i(str);
                i3.n(ha2.i, ha2.h);
                i3.h(i);
                so3.a0(new a(this, k, m, U, i3));
                ga2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                d43.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                e43.a(uuid, o3);
                if (!(U.m() instanceof ga2)) {
                    y72.c("NavigateBackApi", "top fragment error");
                    mh3.i(f);
                    return new y22(1001, "top fragment error");
                }
                ga2 ga2Var = (ga2) U.m();
                if (ga2Var != null) {
                    str2 = ga2Var.v3();
                } else {
                    str2 = "";
                }
                return new y22(0, he3.c(str2));
            }
        }
        return (y22) invokeCommon.objValue;
    }
}
