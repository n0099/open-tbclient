package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.qa2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class z02 extends y02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ na2 b;
        public final /* synthetic */ qa2 c;
        public final /* synthetic */ qa2.b d;
        public final /* synthetic */ z02 e;

        public a(z02 z02Var, int i, na2 na2Var, qa2 qa2Var, qa2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, Integer.valueOf(i), na2Var, qa2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z02Var;
            this.a = i;
            this.b = na2Var;
            this.c = qa2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    rn3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z02(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        hb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = hb3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public h32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (h32) invokeV.objValue;
    }

    public h32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (h32) invokeL.objValue;
    }

    public final h32 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        h13 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            n43.b(uuid);
            qa2 U = uw2.T().U();
            if (U == null) {
                h82.c("NavigateBackApi", "manager is null");
                return new h32(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                h82.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new h32(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            h13 f = vh3.f(uuid, i);
            na2 m = U.m();
            if (m == null) {
                h82.c("NavigateBackApi", "slave container is null");
                return new h32(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                h82.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new h32(1001, "hideModalPage api can only work after showModalPage");
            } else {
                n43.c(i2, uuid);
                qa2.b i3 = U.i(str);
                i3.n(qa2.i, qa2.h);
                i3.h(i);
                bp3.a0(new a(this, k, m, U, i3));
                pa2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                m43.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                n43.a(uuid, o3);
                if (!(U.m() instanceof pa2)) {
                    h82.c("NavigateBackApi", "top fragment error");
                    vh3.i(f);
                    return new h32(1001, "top fragment error");
                }
                pa2 pa2Var = (pa2) U.m();
                if (pa2Var != null) {
                    str2 = pa2Var.v3();
                } else {
                    str2 = "";
                }
                return new h32(0, qe3.c(str2));
            }
        }
        return (h32) invokeCommon.objValue;
    }
}
