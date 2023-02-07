package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.f82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oy1 extends ny1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zw1
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
        public final /* synthetic */ c82 b;
        public final /* synthetic */ f82 c;
        public final /* synthetic */ f82.b d;
        public final /* synthetic */ oy1 e;

        public a(oy1 oy1Var, int i, c82 c82Var, f82 f82Var, f82.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy1Var, Integer.valueOf(i), c82Var, f82Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oy1Var;
            this.a = i;
            this.b = c82Var;
            this.c = f82Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    gl3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oy1(@NonNull xw1 xw1Var) {
        super(xw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xw1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xw1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        w83 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = w83.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public w02 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (w02) invokeV.objValue;
    }

    public w02 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<w02, JSONObject> s = s(str);
            w02 w02Var = (w02) s.first;
            if (!w02Var.isSuccess()) {
                return w02Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (w02) invokeL.objValue;
    }

    public final w02 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        wy2 m3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            c23.b(uuid);
            f82 V = ju2.U().V();
            if (V == null) {
                w52.c("NavigateBackApi", "manager is null");
                return new w02(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                w52.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new w02(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            wy2 f = kf3.f(uuid, i);
            c82 m = V.m();
            if (m == null) {
                w52.c("NavigateBackApi", "slave container is null");
                return new w02(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                w52.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new w02(1001, "hideModalPage api can only work after showModalPage");
            } else {
                c23.c(i2, uuid);
                f82.b i3 = V.i(str);
                i3.n(f82.i, f82.h);
                i3.h(i);
                qm3.a0(new a(this, k, m, V, i3));
                e82 o = V.o();
                if (o == null) {
                    m3 = null;
                } else {
                    m3 = o.m3();
                }
                b23.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                c23.a(uuid, m3);
                if (!(V.m() instanceof e82)) {
                    w52.c("NavigateBackApi", "top fragment error");
                    kf3.i(f);
                    return new w02(1001, "top fragment error");
                }
                e82 e82Var = (e82) V.m();
                if (e82Var != null) {
                    str2 = e82Var.t3();
                } else {
                    str2 = "";
                }
                return new w02(0, fc3.c(str2));
            }
        }
        return (w02) invokeCommon.objValue;
    }
}
