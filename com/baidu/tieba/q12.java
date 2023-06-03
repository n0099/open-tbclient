package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.hb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q12 extends p12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b02
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
        public final /* synthetic */ eb2 b;
        public final /* synthetic */ hb2 c;
        public final /* synthetic */ hb2.b d;
        public final /* synthetic */ q12 e;

        public a(q12 q12Var, int i, eb2 eb2Var, hb2 hb2Var, hb2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q12Var, Integer.valueOf(i), eb2Var, hb2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q12Var;
            this.a = i;
            this.b = eb2Var;
            this.c = hb2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    io3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q12(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        yb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = yb3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public y32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (y32) invokeV.objValue;
    }

    public y32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<y32, JSONObject> s = s(str);
            y32 y32Var = (y32) s.first;
            if (!y32Var.isSuccess()) {
                return y32Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (y32) invokeL.objValue;
    }

    public final y32 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        y13 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            e53.b(uuid);
            hb2 U = lx2.T().U();
            if (U == null) {
                y82.c("NavigateBackApi", "manager is null");
                return new y32(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                y82.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new y32(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            y13 f = mi3.f(uuid, i);
            eb2 m = U.m();
            if (m == null) {
                y82.c("NavigateBackApi", "slave container is null");
                return new y32(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                y82.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new y32(1001, "hideModalPage api can only work after showModalPage");
            } else {
                e53.c(i2, uuid);
                hb2.b i3 = U.i(str);
                i3.n(hb2.i, hb2.h);
                i3.h(i);
                sp3.a0(new a(this, k, m, U, i3));
                gb2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                d53.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                e53.a(uuid, o3);
                if (!(U.m() instanceof gb2)) {
                    y82.c("NavigateBackApi", "top fragment error");
                    mi3.i(f);
                    return new y32(1001, "top fragment error");
                }
                gb2 gb2Var = (gb2) U.m();
                if (gb2Var != null) {
                    str2 = gb2Var.v3();
                } else {
                    str2 = "";
                }
                return new y32(0, hf3.c(str2));
            }
        }
        return (y32) invokeCommon.objValue;
    }
}
