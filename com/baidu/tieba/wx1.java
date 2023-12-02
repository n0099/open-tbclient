package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wx1 extends kx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "UbcFlowJarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ k63 b;

        public a(JSONObject jSONObject, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.b = k63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            wx1.z(this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HybridUbcFlow b;
        public final /* synthetic */ rs1 c;

        public b(String str, HybridUbcFlow hybridUbcFlow, rs1 rs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hybridUbcFlow, rs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = hybridUbcFlow;
            this.c = rs1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.a, "1")) {
                    this.b.T();
                } else {
                    this.b.C(this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wx1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static UbcFlowEvent H(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("actionId");
            long optLong = jSONObject.optLong("timestamp");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
            ubcFlowEvent.h(optLong);
            return ubcFlowEvent;
        }
        return (UbcFlowEvent) invokeL.objValue;
    }

    public static List<UbcFlowEvent> I(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                UbcFlowEvent H = H(jSONArray.optJSONObject(i));
                if (H != null) {
                    H.e("FE");
                    arrayList.add(H);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static int A() {
        InterceptResult invokeV;
        s52 o;
        rs1 v3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            t52 W = xr2.V().W();
            if (W == null || (o = W.o()) == null || (v3 = o.v3()) == null) {
                return 0;
            }
            return v3.c0();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void B(HybridUbcFlow hybridUbcFlow, k63 k63Var, String str, @Nullable rs1 rs1Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, hybridUbcFlow, k63Var, str, rs1Var) == null) && hybridUbcFlow != null && k63Var != null) {
            if (!ed2.V().q0()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.T();
                    return;
                } else {
                    hybridUbcFlow.C(rs1Var);
                    return;
                }
            }
            long H = rp2.g0().H();
            if (H <= 0) {
                return;
            }
            hr2.a Z = k63Var.Z();
            boolean z = false;
            if (Z != null) {
                long currentTimeMillis = System.currentTimeMillis() - Z.O();
                if (currentTimeMillis >= H) {
                    z = true;
                } else {
                    j = H - currentTimeMillis;
                    if (!z) {
                        if (TextUtils.equals(str, "1")) {
                            hybridUbcFlow.T();
                            return;
                        } else {
                            hybridUbcFlow.C(rs1Var);
                            return;
                        }
                    } else if (j <= 0) {
                        return;
                    } else {
                        ej3.c(new b(str, hybridUbcFlow, rs1Var), "waitFcp", j, TimeUnit.MILLISECONDS);
                        return;
                    }
                }
            }
            j = 0;
            if (!z) {
            }
        }
    }

    public static void C(JSONObject jSONObject, k63 k63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jSONObject, k63Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(jSONObject, k63Var), "handlePerformMsg", 2);
        }
    }

    public static void D(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() >= 1) {
            rz2.e().c(optJSONArray.optJSONObject(0));
        }
    }

    public static void E(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, jSONObject) != null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ext")) == null) {
            return;
        }
        String optString = optJSONObject.optString("routeId");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        HybridUbcFlow q = pz2.q("route", optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            q.I(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        q.G(I(jSONObject.optJSONArray("data")));
        q.n();
        ts1 B = xr2.V().B(optJSONObject.optString("slaveId"));
        if (B instanceof SwanAppSlaveManager) {
            ((SwanAppSlaveManager) B).g1();
        }
    }

    public static void F(@Nullable JSONArray jSONArray) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, jSONArray) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("FlowJarAction-671: ");
            if (jSONArray == null) {
                obj = StringUtil.NULL_STRING;
            } else {
                obj = jSONArray;
            }
            sb.append(obj);
            k32.k("UbcFlowJarApi", sb.toString());
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                            kc3.d().h(jSONObject);
                        } else {
                            kc3.d().k(jSONObject);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public static void G(JSONArray jSONArray) {
        s52 J;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, jSONArray) != null) || (J = xr2.V().J()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                String string = jSONObject.getString("eventId");
                String optString = jSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                long j = 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        j = Long.valueOf(optString).longValue();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                J.S3(new od3(string, j));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void z(JSONObject jSONObject, k63 k63Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, jSONObject, k63Var) == null) {
            g82 X = ed2.V().X();
            if (X instanceof k82) {
                i = ((k82) X).i();
            } else {
                i = 0;
            }
            uc3.C(true);
            uc3.r();
            HybridUbcFlow p = pz2.p("startup");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            rs1 rs1Var = null;
            String str2 = "0";
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("hasWebView", "0");
                str = optJSONObject.optString("hasRelaunch");
                ts1 B = xr2.V().B(optJSONObject.optString("slaveId"));
                if (B instanceof rs1) {
                    rs1Var = (rs1) B;
                }
            } else {
                str = "";
            }
            if (TextUtils.equals(str2, "1")) {
                HybridUbcFlow.SubmitStrategy i2 = p.i();
                if (i2 == HybridUbcFlow.SubmitStrategy.HYBRID) {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
                } else if (i2 == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                    p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
                }
            }
            if (TextUtils.equals(str, "none")) {
                if (TextUtils.equals(str2, "1")) {
                    p.T();
                } else {
                    p.C(rs1Var);
                }
            }
            B(p, k63Var, str2, rs1Var);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            p.D("codecache", String.valueOf(i));
            p.D("slave_codecache", String.valueOf(A()));
            p.G(I(optJSONArray));
            p.n();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        if (r2.equals("670") != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ly1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            char c = 0;
            r("#ubcFlowJar", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                return new ly1(1001, "swan app is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("flowId");
            if (TextUtils.isEmpty(optString)) {
                return new ly1(201, "empty flowId");
            }
            switch (optString.hashCode()) {
                case 53647:
                    break;
                case 53648:
                    if (optString.equals("671")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 55357:
                    if (optString.equals("805")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 56506:
                    if (optString.equals("967")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 46733230:
                    if (optString.equals("10360")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1529139648:
                    if (optString.equals("renderMonitorLog")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                if (c != 5) {
                                    return new ly1(201, "unknown flowId");
                                }
                                D(jSONObject);
                            } else {
                                E(jSONObject);
                            }
                        } else {
                            F(jSONObject.optJSONArray("data"));
                        }
                    } else {
                        fm3.a().g(jSONObject.optJSONArray("data"));
                    }
                } else {
                    G(jSONObject.optJSONArray("data"));
                }
            } else {
                C(jSONObject, c0);
            }
            return ly1.f();
        }
        return (ly1) invokeL.objValue;
    }
}
