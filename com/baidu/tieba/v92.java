package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o63;
import com.baidu.tieba.tf4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class v92 extends u92 implements tf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements dl3<v23> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(v92 v92Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v92Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(v23 v23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v23Var) == null) {
                this.a.onFail(v23Var.Q());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements tf4.a, dl3<o63.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final tf4.a a;
        public final boolean b;
        public boolean c;
        public final /* synthetic */ v92 d;

        public b(v92 v92Var, tf4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v92Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v92Var;
            this.c = false;
            this.a = aVar;
            this.b = aVar != null;
            if (v92.b) {
                v92Var.O("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // com.baidu.tieba.tf4.a
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (v92.b) {
                        v92 v92Var = this.d;
                        v92Var.O("IpcHttpCallbackWrapper#onSuccess", "valid=" + e + " statusCode=" + i + " response=" + str);
                    }
                    if (e) {
                        c();
                        this.a.onSuccess(str, i);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.tf4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (v92.b) {
                        v92 v92Var = this.d;
                        v92Var.O("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (e) {
                        this.a.b(str, str2, jSONObject);
                    }
                }
            }
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    this.c = true;
                }
            }
        }

        public synchronized boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    if (this.b) {
                        if (!this.c) {
                            z = true;
                        }
                    }
                    z = false;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: d */
        public void a(o63.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (v92.b) {
                        v92 v92Var = this.d;
                        v92Var.O("IpcHttpCallbackWrapper#onCallback", "valid=" + e + " msg=" + aVar);
                    }
                    if (e) {
                        String o = aVar.o("pms_http_with_ipc_key_action", "");
                        char c = 65535;
                        switch (o.hashCode()) {
                            case -2080875416:
                                if (o.equals("pms_http_with_ipc_action_success")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -898655015:
                                if (o.equals("pms_http_with_ipc_action_fail")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -480804291:
                                if (o.equals("pms_http_with_ipc_action_on_start")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 1737801345:
                                if (o.equals("pms_http_with_ipc_action_stat_record")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        if (c != 0) {
                            if (c != 1) {
                                if (c != 2) {
                                    if (c == 3) {
                                        onStart();
                                    }
                                } else {
                                    onFail(new Exception(aVar.m("pms_http_with_ipc_key_error")));
                                }
                            } else {
                                onSuccess(aVar.m("pms_http_with_ipc_key_response"), aVar.h("pms_http_with_ipc_key_status_code"));
                            }
                        } else {
                            b(aVar.m("pms_http_with_ipc_key_url"), aVar.m("pms_http_with_ipc_key_response"), kj3.d(aVar.m("pms_http_with_ipc_key_stat_record")));
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.tf4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (v92.b) {
                        v92 v92Var = this.d;
                        v92Var.O("IpcHttpCallbackWrapper#onFail", "valid=" + e + " exception=" + exc);
                    }
                    if (e) {
                        c();
                        tf4.a aVar = this.a;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.tf4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (v92.b) {
                        v92 v92Var = this.d;
                        v92Var.O("IpcHttpCallbackWrapper#onStart", "valid=" + e);
                    }
                    if (e) {
                        this.a.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195546, "Lcom/baidu/tieba/v92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195546, "Lcom/baidu/tieba/v92;");
                return;
            }
        }
        b = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v92(p63 p63Var) {
        super(p63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p63Var};
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
    }

    public final void M(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, tf4.a aVar) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, map, map2, jSONObject, aVar}) == null) {
            if (b) {
                N("ipcHttp");
            }
            String str3 = "";
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            b bVar = new b(this, aVar);
            v23 z = w23.Q("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            v23 z2 = z.z("pms_http_with_ipc_key_url", str2);
            if (!TextUtils.isEmpty(jSONObject2)) {
                str3 = jSONObject2;
            }
            v23 u = z2.z("pms_http_with_ipc_keyjson_body", str3).u("pms_http_with_ipc_key_url_param_map", u92.J(map)).u("pms_http_with_ipc_key_header_param_map", u92.J(map2));
            u.L(true);
            u.H(bVar);
            u.G(new a(this, bVar));
            if (b) {
                O("ipcHttp", "session=" + u);
            }
            u.N(y92.m0);
        }
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && b) {
            Log.i("PmsHttpForClient", str);
        }
    }

    public final void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            N(str + ": " + str2);
        }
    }

    @Override // com.baidu.tieba.u92, com.baidu.tieba.tf4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, tf4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (b) {
                N("buildJsonPostRequest");
            }
            M("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.baidu.tieba.u92, com.baidu.tieba.tf4
    public void z(String str, Map<String, String> map, Map<String, String> map2, tf4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (b) {
                N("buildGetRequest");
            }
            String b2 = k03.b();
            if (b2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", b2);
            }
            M("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
        }
    }
}
