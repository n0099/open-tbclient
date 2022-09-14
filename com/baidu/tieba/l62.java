package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bo2;
import com.baidu.tieba.c33;
import com.baidu.tieba.hc4;
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
/* loaded from: classes4.dex */
public final class l62 extends i62 implements hc4, rh3<c33.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public a(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        @Override // com.baidu.tieba.l62.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, hc4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.z(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public b(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        @Override // com.baidu.tieba.l62.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, hc4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.b(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements hc4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ l62 b;

        public c(l62 l62Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l62Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.hc4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_stat_record", new bo2.a().z("pms_http_with_ipc_key_url", str).z("pms_http_with_ipc_key_response", str2).z("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
            }
        }

        @Override // com.baidu.tieba.hc4.a
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_success", new bo2.a().z("pms_http_with_ipc_key_response", str).w("pms_http_with_ipc_key_status_code", i));
            }
        }

        @Override // com.baidu.tieba.hc4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                l62 l62Var = this.b;
                String str = this.a;
                l62Var.Q(str, "http: " + exc);
                if (l62.b) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.hc4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_on_start", null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ bo2.a c;
        public final /* synthetic */ l62 d;

        public d(l62 l62Var, String str, String str2, bo2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, str, str2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = l62Var;
            this.a = str;
            this.b = str2;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!kz2.K(this.a, "pms_http_with_ipc")) {
                    if (l62.b) {
                        this.d.T("callbackIpcSession", "return by topic pms_http_with_ipc");
                        return;
                    }
                    return;
                }
                jz2 z = kz2.a0(this.a).z("pms_http_with_ipc_key_action", this.b);
                bo2.a aVar = this.c;
                if (aVar != null) {
                    z.s(aVar.D());
                }
                if (l62.b) {
                    l62 l62Var = this.d;
                    l62Var.T("callbackIpcSession", "ipcSession= " + z);
                }
                z.call();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, hc4.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894753, "Lcom/baidu/tieba/l62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894753, "Lcom/baidu/tieba/l62;");
                return;
            }
        }
        b = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l62(f33 f33Var) {
        super(f33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((x23) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        v23 v23Var = new v23();
        v23Var.f(this, "event_messenger_call");
        u(v23Var);
    }

    public final void O(String str, @NonNull c33.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, aVar, eVar) == null) {
            if (b) {
                T("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (kz2.K(str, "pms_http_with_ipc")) {
                String n = aVar.n("pms_http_with_ipc_key_url");
                Map<String, String> I = i62.I(aVar.f("pms_http_with_ipc_key_url_param_map"));
                Map<String, String> I2 = i62.I(aVar.f("pms_http_with_ipc_key_header_param_map"));
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
    }

    public final void P(String str, String str2, bo2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, aVar) == null) {
            if (b) {
                T("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            sg3.e0(new d(this, str, str2, aVar));
        }
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            P(str, "pms_http_with_ipc_action_fail", new bo2.a().z("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void R(c33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (b) {
                T("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar == null || !kz2.J(aVar.D(), "pms_http_with_ipc")) {
                return;
            }
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
            if (c2 == 0) {
                O(n, aVar, new a(this));
            } else if (c2 != 1) {
                Q(n, "no such action:" + n2);
            } else {
                O(n, aVar, new b(this));
            }
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && b) {
            Log.i("PmsHttpForService", str);
        }
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            S(str + ": " + str2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rh3
    /* renamed from: U */
    public void a(c33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            R(aVar);
        }
    }
}
