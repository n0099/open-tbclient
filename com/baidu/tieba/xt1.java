package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.o32;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xt1 extends wt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ l32 b;
        public final /* synthetic */ o32 c;
        public final /* synthetic */ o32.b d;
        public final /* synthetic */ xt1 e;

        public a(xt1 xt1Var, int i, l32 l32Var, o32 o32Var, o32.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt1Var, Integer.valueOf(i), l32Var, o32Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xt1Var;
            this.a = i;
            this.b = l32Var;
            this.c = o32Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    pg3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        f43 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = f43.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public fw1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (fw1) invokeV.objValue;
    }

    public fw1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (fw1) invokeL.objValue;
    }

    public final fw1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        fu2 m3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            lx2.b(uuid);
            o32 V = sp2.U().V();
            if (V == null) {
                f12.c("NavigateBackApi", "manager is null");
                return new fw1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                f12.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new fw1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            fu2 f = ta3.f(uuid, i);
            l32 m = V.m();
            if (m == null) {
                f12.c("NavigateBackApi", "slave container is null");
                return new fw1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                f12.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new fw1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                lx2.c(i2, uuid);
                o32.b i3 = V.i(str);
                i3.n(o32.i, o32.h);
                i3.h(i);
                zh3.a0(new a(this, k, m, V, i3));
                n32 o = V.o();
                if (o == null) {
                    m3 = null;
                } else {
                    m3 = o.m3();
                }
                kx2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                lx2.a(uuid, m3);
                if (!(V.m() instanceof n32)) {
                    f12.c("NavigateBackApi", "top fragment error");
                    ta3.i(f);
                    return new fw1(1001, "top fragment error");
                }
                n32 n32Var = (n32) V.m();
                if (n32Var != null) {
                    str2 = n32Var.t3();
                } else {
                    str2 = "";
                }
                return new fw1(0, o73.c(str2));
            }
        }
        return (fw1) invokeCommon.objValue;
    }
}
