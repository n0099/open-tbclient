package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.eb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n12 extends m12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
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
        public final /* synthetic */ bb2 b;
        public final /* synthetic */ eb2 c;
        public final /* synthetic */ eb2.b d;
        public final /* synthetic */ n12 e;

        public a(n12 n12Var, int i, bb2 bb2Var, eb2 eb2Var, eb2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n12Var, Integer.valueOf(i), bb2Var, eb2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n12Var;
            this.a = i;
            this.b = bb2Var;
            this.c = eb2Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    fo3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n12(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        vb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = vb3.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public v32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (v32) invokeV.objValue;
    }

    public v32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (v32) invokeL.objValue;
    }

    public final v32 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        v13 o3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            b53.b(uuid);
            eb2 U = ix2.T().U();
            if (U == null) {
                v82.c("NavigateBackApi", "manager is null");
                return new v32(1001, "manager is null");
            }
            int k = U.k();
            if (k == 1) {
                v82.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new v32(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            v13 f = ji3.f(uuid, i);
            bb2 m = U.m();
            if (m == null) {
                v82.c("NavigateBackApi", "slave container is null");
                return new v32(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                v82.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new v32(1001, "hideModalPage api can only work after showModalPage");
            } else {
                b53.c(i2, uuid);
                eb2.b i3 = U.i(str);
                i3.n(eb2.i, eb2.h);
                i3.h(i);
                pp3.a0(new a(this, k, m, U, i3));
                db2 o = U.o();
                if (o == null) {
                    o3 = null;
                } else {
                    o3 = o.o3();
                }
                a53.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                b53.a(uuid, o3);
                if (!(U.m() instanceof db2)) {
                    v82.c("NavigateBackApi", "top fragment error");
                    ji3.i(f);
                    return new v32(1001, "top fragment error");
                }
                db2 db2Var = (db2) U.m();
                if (db2Var != null) {
                    str2 = db2Var.v3();
                } else {
                    str2 = "";
                }
                return new v32(0, ef3.c(str2));
            }
        }
        return (v32) invokeCommon.objValue;
    }
}
