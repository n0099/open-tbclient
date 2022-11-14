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
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.cp2;
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
/* loaded from: classes5.dex */
public class qv1 extends ev1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "UbcFlowJarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ f43 b;

        public a(JSONObject jSONObject, f43 f43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, f43Var};
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
            this.b = f43Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            qv1.y(this.a, this.b);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HybridUbcFlow b;
        public final /* synthetic */ lq1 c;

        public b(String str, HybridUbcFlow hybridUbcFlow, lq1 lq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hybridUbcFlow, lq1Var};
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
            this.c = lq1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.a, "1")) {
                    this.b.S();
                } else {
                    this.b.C(this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qv1(@NonNull gs1 gs1Var) {
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

    public static UbcFlowEvent G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
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

    public static List<UbcFlowEvent> H(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                UbcFlowEvent G = G(jSONArray.optJSONObject(i));
                if (G != null) {
                    G.e("FE");
                    arrayList.add(G);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A(HybridUbcFlow hybridUbcFlow, f43 f43Var, String str, @Nullable lq1 lq1Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, hybridUbcFlow, f43Var, str, lq1Var) == null) && hybridUbcFlow != null && f43Var != null) {
            if (!za2.U().p0()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.S();
                    return;
                } else {
                    hybridUbcFlow.C(lq1Var);
                    return;
                }
            }
            long H = mn2.g0().H();
            if (H <= 0) {
                return;
            }
            cp2.a Y = f43Var.Y();
            boolean z = false;
            if (Y != null) {
                long currentTimeMillis = System.currentTimeMillis() - Y.N();
                if (currentTimeMillis >= H) {
                    z = true;
                } else {
                    j = H - currentTimeMillis;
                    if (!z) {
                        if (TextUtils.equals(str, "1")) {
                            hybridUbcFlow.S();
                            return;
                        } else {
                            hybridUbcFlow.C(lq1Var);
                            return;
                        }
                    } else if (j <= 0) {
                        return;
                    } else {
                        zg3.c(new b(str, hybridUbcFlow, lq1Var), "waitFcp", j, TimeUnit.MILLISECONDS);
                        return;
                    }
                }
            }
            j = 0;
            if (!z) {
            }
        }
    }

    public static void B(JSONObject jSONObject, f43 f43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, f43Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(jSONObject, f43Var), "handlePerformMsg", 2);
        }
    }

    public static void C(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() >= 1) {
            mx2.e().c(optJSONArray.optJSONObject(0));
        }
    }

    public static void D(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ext")) == null) {
            return;
        }
        String optString = optJSONObject.optString("routeId");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        HybridUbcFlow q = kx2.q("route", optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            q.I(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        q.G(H(jSONObject.optJSONArray("data")));
        q.n();
        nq1 A = sp2.U().A(optJSONObject.optString("slaveId"));
        if (A instanceof SwanAppSlaveManager) {
            ((SwanAppSlaveManager) A).j1();
        }
    }

    public static void E(@Nullable JSONArray jSONArray) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, jSONArray) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("FlowJarAction-671: ");
            if (jSONArray == null) {
                obj = StringUtil.NULL_STRING;
            } else {
                obj = jSONArray;
            }
            sb.append(obj);
            f12.k("UbcFlowJarApi", sb.toString());
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                            fa3.d().h(jSONObject);
                        } else {
                            fa3.d().k(jSONObject);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public static void F(JSONArray jSONArray) {
        n32 H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, jSONArray) != null) || (H = sp2.U().H()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                String string = jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString = jSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                long j = 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        j = Long.valueOf(optString).longValue();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                H.L3(new jb3(string, j));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void y(JSONObject jSONObject, f43 f43Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, jSONObject, f43Var) == null) {
            b62 W = za2.U().W();
            if (W instanceof f62) {
                i = ((f62) W).i();
            } else {
                i = 0;
            }
            pa3.C(true);
            pa3.r();
            HybridUbcFlow p = kx2.p("startup");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            lq1 lq1Var = null;
            String str2 = "0";
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("hasWebView", "0");
                str = optJSONObject.optString("hasRelaunch");
                nq1 A = sp2.U().A(optJSONObject.optString("slaveId"));
                if (A instanceof lq1) {
                    lq1Var = (lq1) A;
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
                    p.S();
                } else {
                    p.C(lq1Var);
                }
            }
            A(p, f43Var, str2, lq1Var);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            p.D("codecache", String.valueOf(i));
            p.D("slave_codecache", String.valueOf(z()));
            p.G(H(optJSONArray));
            p.n();
        }
    }

    public static int z() {
        InterceptResult invokeV;
        n32 o;
        lq1 o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            o32 V = sp2.U().V();
            if (V == null || (o = V.o()) == null || (o3 = o.o3()) == null) {
                return 0;
            }
            return o3.f0();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        if (r2.equals("670") != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public fw1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            char c = 0;
            q("#ubcFlowJar", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                return new fw1(1001, "swan app is null");
            }
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("flowId");
            if (TextUtils.isEmpty(optString)) {
                return new fw1(201, "empty flowId");
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
                                    return new fw1(201, "unknown flowId");
                                }
                                C(jSONObject);
                            } else {
                                D(jSONObject);
                            }
                        } else {
                            E(jSONObject.optJSONArray("data"));
                        }
                    } else {
                        ak3.a().g(jSONObject.optJSONArray("data"));
                    }
                } else {
                    F(jSONObject.optJSONArray("data"));
                }
            } else {
                B(jSONObject, b0);
            }
            return fw1.f();
        }
        return (fw1) invokeL.objValue;
    }
}
