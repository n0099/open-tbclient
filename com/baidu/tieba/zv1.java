package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.p52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zv1 extends yv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ m52 b;
        public final /* synthetic */ p52 c;
        public final /* synthetic */ p52.b d;
        public final /* synthetic */ zv1 e;

        public a(zv1 zv1Var, int i, m52 m52Var, p52 p52Var, p52.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv1Var, Integer.valueOf(i), m52Var, p52Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zv1Var;
            this.a = i;
            this.b = m52Var;
            this.c = p52Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    qi3.b(this.c, this.e.i(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zv1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z() {
        g63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (c0 = g63.c0()) != null) {
            c0.B().I(c0.getAppId());
        }
    }

    public hy1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideModalPage", false);
            z();
            return A(1, "hideModalPage", 10);
        }
        return (hy1) invokeV.objValue;
    }

    public final hy1 A(int i, String str, int i2) {
        InterceptResult invokeCommon;
        gw2 t3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            mz2.b(uuid);
            p52 W = tr2.V().W();
            if (W == null) {
                g32.c("NavigateBackApi", "manager is null");
                return new hy1(1001, "manager is null");
            }
            int k = W.k();
            if (k == 1) {
                g32.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new hy1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            gw2 f = uc3.f(uuid, i);
            m52 m = W.m();
            if (m == null) {
                g32.c("NavigateBackApi", "slave container is null");
                return new hy1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                g32.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new hy1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                mz2.c(i2, uuid);
                p52.b i3 = W.i(str);
                i3.n(p52.i, p52.h);
                i3.h(i);
                ak3.a0(new a(this, k, m, W, i3));
                o52 o = W.o();
                if (o == null) {
                    t3 = null;
                } else {
                    t3 = o.t3();
                }
                lz2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                mz2.a(uuid, t3);
                if (!(W.m() instanceof o52)) {
                    g32.c("NavigateBackApi", "top fragment error");
                    uc3.i(f);
                    return new hy1(1001, "top fragment error");
                }
                o52 o52Var = (o52) W.m();
                if (o52Var != null) {
                    str2 = o52Var.A3();
                } else {
                    str2 = "";
                }
                return new hy1(0, p93.c(str2));
            }
        }
        return (hy1) invokeCommon.objValue;
    }

    public hy1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#navigateBack params=" + str, false);
            z();
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            return A(((JSONObject) t.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (hy1) invokeL.objValue;
    }
}
