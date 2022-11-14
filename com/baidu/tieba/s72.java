package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ip2;
import com.baidu.tieba.j43;
import com.baidu.tieba.od4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class s72 extends p72 implements od4, yi3<j43.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, od4.a aVar);
    }

    /* loaded from: classes5.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s72 a;

        public a(s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s72Var;
        }

        @Override // com.baidu.tieba.s72.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, od4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.z(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s72 a;

        public b(s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s72Var;
        }

        @Override // com.baidu.tieba.s72.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, od4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.b(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements od4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ s72 b;

        public c(s72 s72Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s72Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s72Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.od4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048576, this, str, str2, jSONObject) != null) {
                return;
            }
            this.b.P(this.a, "pms_http_with_ipc_action_stat_record", new ip2.a().z("pms_http_with_ipc_key_url", str).z("pms_http_with_ipc_key_response", str2).z("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
        }

        @Override // com.baidu.tieba.od4.a
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_success", new ip2.a().z("pms_http_with_ipc_key_response", str).w("pms_http_with_ipc_key_status_code", i));
            }
        }

        @Override // com.baidu.tieba.od4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                s72 s72Var = this.b;
                String str = this.a;
                s72Var.Q(str, "http: " + exc);
                if (s72.b) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.od4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_on_start", null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ip2.a c;
        public final /* synthetic */ s72 d;

        public d(s72 s72Var, String str, String str2, ip2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s72Var, str, str2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s72Var;
            this.a = str;
            this.b = str2;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!r03.K(this.a, "pms_http_with_ipc")) {
                    if (!s72.b) {
                        return;
                    }
                    this.d.T("callbackIpcSession", "return by topic pms_http_with_ipc");
                    return;
                }
                q03 z = r03.a0(this.a).z("pms_http_with_ipc_key_action", this.b);
                ip2.a aVar = this.c;
                if (aVar != null) {
                    z.s(aVar.D());
                }
                if (s72.b) {
                    s72 s72Var = this.d;
                    s72Var.T("callbackIpcSession", "ipcSession= " + z);
                }
                z.call();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104251, "Lcom/baidu/tieba/s72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104251, "Lcom/baidu/tieba/s72;");
                return;
            }
        }
        b = pk1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s72(m43 m43Var) {
        super(m43Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m43Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((e43) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c43 c43Var = new c43();
        c43Var.f(this, "event_messenger_call");
        u(c43Var);
    }

    public final void O(String str, @NonNull j43.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, aVar, eVar) == null) {
            if (b) {
                T("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (!r03.K(str, "pms_http_with_ipc")) {
                return;
            }
            String n = aVar.n("pms_http_with_ipc_key_url");
            Map<String, String> I = p72.I(aVar.f("pms_http_with_ipc_key_url_param_map"));
            Map<String, String> I2 = p72.I(aVar.f("pms_http_with_ipc_key_header_param_map"));
            String n2 = aVar.n("pms_http_with_ipc_keyjson_body");
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(n2)) {
                    jSONObject = new JSONObject(n2);
                }
            } catch (JSONException e2) {
                if (b) {
                    e2.printStackTrace();
                }
            }
            try {
                eVar.a(n, I, I2, jSONObject, new c(this, str));
            } catch (Exception e3) {
                Q(str, "catch: " + e3);
                if (b) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final void P(String str, String str2, ip2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, aVar) == null) {
            if (b) {
                T("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            zh3.e0(new d(this, str, str2, aVar));
        }
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            P(str, "pms_http_with_ipc_action_fail", new ip2.a().z("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            S(str + ": " + str2);
        }
    }

    public final void R(j43.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (b) {
                T("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar != null && r03.J(aVar.D(), "pms_http_with_ipc")) {
                String n = aVar.n("ipc_session_id");
                if (b) {
                    T("handleIpcMsg", "session=" + n);
                }
                if (TextUtils.isEmpty(n)) {
                    return;
                }
                String n2 = aVar.n("pms_http_with_ipc_key_action");
                if (b) {
                    T("handleIpcMsg", "action=" + n2);
                }
                if (TextUtils.isEmpty(n2)) {
                    Q(n, "empty action");
                    return;
                }
                char c2 = 65535;
                int hashCode = n2.hashCode();
                if (hashCode != 646251642) {
                    if (hashCode == 1779116731 && n2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                        c2 = 1;
                    }
                } else if (n2.equals("pms_http_with_ipc_action_build_get_request")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        Q(n, "no such action:" + n2);
                        return;
                    }
                    O(n, aVar, new b(this));
                    return;
                }
                O(n, aVar, new a(this));
            }
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && b) {
            Log.i("PmsHttpForService", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yi3
    /* renamed from: U */
    public void a(j43.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            R(aVar);
        }
    }
}
