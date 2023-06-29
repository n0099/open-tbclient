package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.lb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u12 extends t12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
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
        public final /* synthetic */ ib2 b;
        public final /* synthetic */ lb2 c;
        public final /* synthetic */ lb2.b d;
        public final /* synthetic */ u12 e;

        public a(u12 u12Var, int i, ib2 ib2Var, lb2 lb2Var, lb2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, Integer.valueOf(i), ib2Var, lb2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u12Var;
            this.a = i;
            this.b = ib2Var;
            this.c = lb2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    mo3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u12(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        cc3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = cc3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public c42 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (c42) invokeV.objValue;
    }

    public c42 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (c42) invokeL.objValue;
    }

    public final c42 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        c23 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            i53.b(uuid);
            lb2 U = px2.T().U();
            if (U == null) {
                c92.c("NavigateBackApi", "manager is null");
                return new c42(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                c92.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new c42(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            c23 f = qi3.f(uuid, i);
            ib2 m = U.m();
            if (m == null) {
                c92.c("NavigateBackApi", "slave container is null");
                return new c42(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                c92.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new c42(1001, "hideModalPage api can only work after showModalPage");
            } else {
                i53.c(i2, uuid);
                lb2.b i3 = U.i(str);
                i3.n(lb2.i, lb2.h);
                i3.h(i);
                wp3.a0(new a(this, k, m, U, i3));
                kb2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                h53.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                i53.a(uuid, o3);
                if (!(U.m() instanceof kb2)) {
                    c92.c("NavigateBackApi", "top fragment error");
                    qi3.i(f);
                    return new c42(1001, "top fragment error");
                }
                kb2 kb2Var = (kb2) U.m();
                if (kb2Var != null) {
                    str2 = kb2Var.v3();
                } else {
                    str2 = "";
                }
                return new c42(0, lf3.c(str2));
            }
        }
        return (c42) invokeCommon.objValue;
    }
}
