package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m82 implements n82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<p82> a;
    public boolean b;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-648426267, "Lcom/baidu/tieba/m82$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-648426267, "Lcom/baidu/tieba/m82$a;");
                    return;
                }
            }
            int[] iArr = new int[RecordType.values().length];
            a = iArr;
            try {
                iArr[RecordType.APP_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RecordType.APP_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RecordType.PREFETCH_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RecordType.PREFETCH_EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RecordType.PREFETCH_OTHER_MSG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RecordType.PREFETCH_PRELINK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public m82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = false;
    }

    public void a(String str, UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, ubcFlowEvent) == null) && b(str)) {
            qw2.q(PrefetchEvent.MODULE, str).F(ubcFlowEvent);
        }
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public final void c(HybridUbcFlow hybridUbcFlow, p82 p82Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow, p82Var) == null) || hybridUbcFlow == null || p82Var == null) {
            return;
        }
        switch (a.a[p82Var.a.ordinal()]) {
            case 1:
                hybridUbcFlow.D("app_id", p82Var.b);
                return;
            case 2:
                hybridUbcFlow.D("app_version", p82Var.b);
                return;
            case 3:
                hybridUbcFlow.E("type", p82Var.c ? "hot" : "cold");
                return;
            case 4:
                hybridUbcFlow.E("source", p82Var.b);
                return;
            case 5:
                hybridUbcFlow.D("msg", p82Var.b);
                return;
            case 6:
                synchronized (this.a) {
                    this.a.add(p82Var);
                }
                return;
            default:
                return;
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) && b(str)) {
            qw2.q(PrefetchEvent.MODULE, str).E("value", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
        }
    }

    public void e(String str, p82 p82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, p82Var) == null) && b(str)) {
            c(qw2.q(PrefetchEvent.MODULE, str), p82Var);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && b(str)) {
            qw2.s(PrefetchEvent.MODULE, str);
            qw2.q(PrefetchEvent.MODULE, str);
        }
    }

    public final void g(HybridUbcFlow hybridUbcFlow) {
        List<p82> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hybridUbcFlow) == null) || hybridUbcFlow == null || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        synchronized (this.a) {
            try {
                for (p82 p82Var : this.a) {
                    String str = p82Var.b;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", str);
                    jSONObject2.put("link", p82Var.c ? "1" : "0");
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("links", jSONArray);
            } catch (JSONException unused) {
            }
            this.a.clear();
        }
        if (jSONObject.length() > 0) {
            hybridUbcFlow.D("prelink", jSONObject.toString());
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && b(str) && !this.b) {
            this.b = true;
            HybridUbcFlow q = qw2.q(PrefetchEvent.MODULE, str);
            g(q);
            q.A();
            qw2.s(PrefetchEvent.MODULE, str);
        }
    }
}
