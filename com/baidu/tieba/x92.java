package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nr2;
import com.baidu.tieba.o63;
import com.baidu.tieba.tf4;
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
/* loaded from: classes9.dex */
public final class x92 extends u92 implements tf4, dl3<o63.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, tf4.a aVar);
    }

    /* loaded from: classes9.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x92 a;

        public a(x92 x92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x92Var;
        }

        @Override // com.baidu.tieba.x92.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, tf4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.z(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x92 a;

        public b(x92 x92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x92Var;
        }

        @Override // com.baidu.tieba.x92.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, tf4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.b(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements tf4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x92 b;

        public c(x92 x92Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x92Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x92Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.tf4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048576, this, str, str2, jSONObject) != null) {
                return;
            }
            this.b.P(this.a, "pms_http_with_ipc_action_stat_record", new nr2.a().z("pms_http_with_ipc_key_url", str).z("pms_http_with_ipc_key_response", str2).z("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
        }

        @Override // com.baidu.tieba.tf4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                x92 x92Var = this.b;
                String str = this.a;
                x92Var.Q(str, "http: " + exc);
                if (x92.b) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.tf4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_on_start", null);
            }
        }

        @Override // com.baidu.tieba.tf4.a
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_success", new nr2.a().z("pms_http_with_ipc_key_response", str).w("pms_http_with_ipc_key_status_code", i));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ nr2.a c;
        public final /* synthetic */ x92 d;

        public d(x92 x92Var, String str, String str2, nr2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x92Var, str, str2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x92Var;
            this.a = str;
            this.b = str2;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!w23.K(this.a, "pms_http_with_ipc")) {
                    if (!x92.b) {
                        return;
                    }
                    this.d.T("callbackIpcSession", "return by topic pms_http_with_ipc");
                    return;
                }
                v23 z = w23.a0(this.a).z("pms_http_with_ipc_key_action", this.b);
                nr2.a aVar = this.c;
                if (aVar != null) {
                    z.s(aVar.D());
                }
                if (x92.b) {
                    x92 x92Var = this.d;
                    x92Var.T("callbackIpcSession", "ipcSession= " + z);
                }
                z.M();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948255128, "Lcom/baidu/tieba/x92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948255128, "Lcom/baidu/tieba/x92;");
                return;
            }
        }
        b = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x92(r63 r63Var) {
        super(r63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r63Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j63) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h63 h63Var = new h63();
        h63Var.f(this, "event_messenger_call");
        u(h63Var);
    }

    public final void O(String str, @NonNull o63.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, aVar, eVar) == null) {
            if (b) {
                T("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (!w23.K(str, "pms_http_with_ipc")) {
                return;
            }
            String m = aVar.m("pms_http_with_ipc_key_url");
            Map<String, String> I = u92.I(aVar.e("pms_http_with_ipc_key_url_param_map"));
            Map<String, String> I2 = u92.I(aVar.e("pms_http_with_ipc_key_header_param_map"));
            String m2 = aVar.m("pms_http_with_ipc_keyjson_body");
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(m2)) {
                    jSONObject = new JSONObject(m2);
                }
            } catch (JSONException e2) {
                if (b) {
                    e2.printStackTrace();
                }
            }
            try {
                eVar.a(m, I, I2, jSONObject, new c(this, str));
            } catch (Exception e3) {
                Q(str, "catch: " + e3);
                if (b) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final void P(String str, String str2, nr2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, aVar) == null) {
            if (b) {
                T("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ek3.e0(new d(this, str, str2, aVar));
        }
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            P(str, "pms_http_with_ipc_action_fail", new nr2.a().z("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            S(str + ": " + str2);
        }
    }

    public final void R(o63.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (b) {
                T("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar != null && w23.J(aVar.D(), "pms_http_with_ipc")) {
                String m = aVar.m("ipc_session_id");
                if (b) {
                    T("handleIpcMsg", "session=" + m);
                }
                if (TextUtils.isEmpty(m)) {
                    return;
                }
                String m2 = aVar.m("pms_http_with_ipc_key_action");
                if (b) {
                    T("handleIpcMsg", "action=" + m2);
                }
                if (TextUtils.isEmpty(m2)) {
                    Q(m, "empty action");
                    return;
                }
                char c2 = 65535;
                int hashCode = m2.hashCode();
                if (hashCode != 646251642) {
                    if (hashCode == 1779116731 && m2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                        c2 = 1;
                    }
                } else if (m2.equals("pms_http_with_ipc_action_build_get_request")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        Q(m, "no such action:" + m2);
                        return;
                    }
                    O(m, aVar, new b(this));
                    return;
                }
                O(m, aVar, new a(this));
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
    @Override // com.baidu.tieba.dl3
    /* renamed from: U */
    public void a(o63.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            R(aVar);
        }
    }
}
