package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ma2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v02 extends u02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
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
        public final /* synthetic */ ja2 b;
        public final /* synthetic */ ma2 c;
        public final /* synthetic */ ma2.b d;
        public final /* synthetic */ v02 e;

        public a(v02 v02Var, int i, ja2 ja2Var, ma2 ma2Var, ma2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v02Var, Integer.valueOf(i), ja2Var, ma2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v02Var;
            this.a = i;
            this.b = ja2Var;
            this.c = ma2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    nn3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v02(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        db3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = db3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public d32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (d32) invokeV.objValue;
    }

    public d32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (d32) invokeL.objValue;
    }

    public final d32 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        d13 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            j43.b(uuid);
            ma2 U = qw2.T().U();
            if (U == null) {
                d82.c("NavigateBackApi", "manager is null");
                return new d32(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                d82.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new d32(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            d13 f = rh3.f(uuid, i);
            ja2 m = U.m();
            if (m == null) {
                d82.c("NavigateBackApi", "slave container is null");
                return new d32(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                d82.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new d32(1001, "hideModalPage api can only work after showModalPage");
            } else {
                j43.c(i2, uuid);
                ma2.b i3 = U.i(str);
                i3.n(ma2.i, ma2.h);
                i3.h(i);
                xo3.a0(new a(this, k, m, U, i3));
                la2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                i43.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                j43.a(uuid, o3);
                if (!(U.m() instanceof la2)) {
                    d82.c("NavigateBackApi", "top fragment error");
                    rh3.i(f);
                    return new d32(1001, "top fragment error");
                }
                la2 la2Var = (la2) U.m();
                if (la2Var != null) {
                    str2 = la2Var.v3();
                } else {
                    str2 = "";
                }
                return new d32(0, me3.c(str2));
            }
        }
        return (d32) invokeCommon.objValue;
    }
}
