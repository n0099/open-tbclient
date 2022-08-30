package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.j02;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class sq1 extends rq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ g02 b;
        public final /* synthetic */ j02 c;
        public final /* synthetic */ j02.b d;
        public final /* synthetic */ sq1 e;

        public a(sq1 sq1Var, int i, g02 g02Var, j02 j02Var, j02.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq1Var, Integer.valueOf(i), g02Var, j02Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sq1Var;
            this.a = i;
            this.b = g02Var;
            this.c = j02Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    kd3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        a13 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (b0 = a13.b0()) == null) {
            return;
        }
        b0.B().I(b0.getAppId());
    }

    public at1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (at1) invokeV.objValue;
    }

    public at1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            return !at1Var.isSuccess() ? at1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final at1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            gu2.b(uuid);
            j02 V = nm2.U().V();
            if (V == null) {
                ay1.c("NavigateBackApi", "manager is null");
                return new at1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                ay1.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new at1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            ar2 f = o73.f(uuid, i);
            g02 m = V.m();
            if (m == null) {
                ay1.c("NavigateBackApi", "slave container is null");
                return new at1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                ay1.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new at1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                gu2.c(i2, uuid);
                j02.b i3 = V.i(str);
                i3.n(j02.i, j02.h);
                i3.h(i);
                ue3.a0(new a(this, k, m, V, i3));
                i02 o = V.o();
                ar2 m3 = o == null ? null : o.m3();
                fu2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                gu2.a(uuid, m3);
                if (!(V.m() instanceof i02)) {
                    ay1.c("NavigateBackApi", "top fragment error");
                    o73.i(f);
                    return new at1(1001, "top fragment error");
                }
                i02 i02Var = (i02) V.m();
                return new at1(0, j43.c(i02Var != null ? i02Var.t3() : ""));
            }
        }
        return (at1) invokeCommon.objValue;
    }
}
