package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ib2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r12 extends q12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
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
        public final /* synthetic */ fb2 b;
        public final /* synthetic */ ib2 c;
        public final /* synthetic */ ib2.b d;
        public final /* synthetic */ r12 e;

        public a(r12 r12Var, int i, fb2 fb2Var, ib2 ib2Var, ib2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r12Var, Integer.valueOf(i), fb2Var, ib2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r12Var;
            this.a = i;
            this.b = fb2Var;
            this.c = ib2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    jo3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r12(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        zb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = zb3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public z32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (z32) invokeV.objValue;
    }

    public z32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (z32) invokeL.objValue;
    }

    public final z32 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        z13 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            f53.b(uuid);
            ib2 U = mx2.T().U();
            if (U == null) {
                z82.c("NavigateBackApi", "manager is null");
                return new z32(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                z82.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new z32(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            z13 f = ni3.f(uuid, i);
            fb2 m = U.m();
            if (m == null) {
                z82.c("NavigateBackApi", "slave container is null");
                return new z32(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                z82.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new z32(1001, "hideModalPage api can only work after showModalPage");
            } else {
                f53.c(i2, uuid);
                ib2.b i3 = U.i(str);
                i3.n(ib2.i, ib2.h);
                i3.h(i);
                tp3.a0(new a(this, k, m, U, i3));
                hb2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                e53.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                f53.a(uuid, o3);
                if (!(U.m() instanceof hb2)) {
                    z82.c("NavigateBackApi", "top fragment error");
                    ni3.i(f);
                    return new z32(1001, "top fragment error");
                }
                hb2 hb2Var = (hb2) U.m();
                if (hb2Var != null) {
                    str2 = hb2Var.v3();
                } else {
                    str2 = "";
                }
                return new z32(0, if3.c(str2));
            }
        }
        return (z32) invokeCommon.objValue;
    }
}
