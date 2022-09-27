package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p33;
import com.baidu.tieba.uc4;
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
/* loaded from: classes6.dex */
public final class w62 extends v62 implements uc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ei3<wz2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(w62 w62Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w62Var, bVar};
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
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(wz2 wz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz2Var) == null) {
                this.a.onFail(wz2Var.N());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements uc4.a, ei3<p33.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final uc4.a a;
        public final boolean b;
        public boolean c;
        public final /* synthetic */ w62 d;

        public b(w62 w62Var, uc4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w62Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w62Var;
            this.c = false;
            this.a = aVar;
            this.b = aVar != null;
            if (w62.b) {
                w62Var.O("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // com.baidu.tieba.uc4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (w62.b) {
                        w62 w62Var = this.d;
                        w62Var.O("IpcHttpCallbackWrapper#onStatRecord", "valid=" + f + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (f) {
                        this.a.b(str, str2, jSONObject);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.uc4.a
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (w62.b) {
                        w62 w62Var = this.d;
                        w62Var.O("IpcHttpCallbackWrapper#onSuccess", "valid=" + f + " statusCode=" + i + " response=" + str);
                    }
                    if (f) {
                        d();
                        this.a.c(str, i);
                    }
                }
            }
        }

        public synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.c = true;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: e */
        public void a(p33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (w62.b) {
                        w62 w62Var = this.d;
                        w62Var.O("IpcHttpCallbackWrapper#onCallback", "valid=" + f + " msg=" + aVar);
                    }
                    if (f) {
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
                        if (c == 0) {
                            b(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), lg3.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                        } else if (c == 1) {
                            c(aVar.n("pms_http_with_ipc_key_response"), aVar.i("pms_http_with_ipc_key_status_code"));
                        } else if (c == 2) {
                            onFail(new Exception(aVar.n("pms_http_with_ipc_key_error")));
                        } else if (c == 3) {
                            onStart();
                        }
                    }
                }
            }
        }

        public synchronized boolean f() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this) {
                    if (this.b) {
                        z = this.c ? false : true;
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.uc4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (w62.b) {
                        w62 w62Var = this.d;
                        w62Var.O("IpcHttpCallbackWrapper#onFail", "valid=" + f + " exception=" + exc);
                    }
                    if (f) {
                        d();
                        uc4.a aVar = this.a;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.uc4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (w62.b) {
                        w62 w62Var = this.d;
                        w62Var.O("IpcHttpCallbackWrapper#onStart", "valid=" + f);
                    }
                    if (f) {
                        this.a.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222454, "Lcom/baidu/tieba/w62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222454, "Lcom/baidu/tieba/w62;");
                return;
            }
        }
        b = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w62(q33 q33Var) {
        super(q33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void M(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, uc4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, map, map2, jSONObject, aVar}) == null) {
            if (b) {
                N("ipcHttp");
            }
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            b bVar = new b(this, aVar);
            wz2 z = xz2.Q("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            wz2 u = z.z("pms_http_with_ipc_key_url", str2).z("pms_http_with_ipc_keyjson_body", TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2).u("pms_http_with_ipc_key_url_param_map", v62.J(map)).u("pms_http_with_ipc_key_header_param_map", v62.J(map2));
            u.K(true);
            u.G(bVar);
            u.F(new a(this, bVar));
            if (b) {
                O("ipcHttp", "session=" + u);
            }
            u.call(z62.l0);
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

    @Override // com.baidu.tieba.v62, com.baidu.tieba.uc4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, uc4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (b) {
                N("buildJsonPostRequest");
            }
            M("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.baidu.tieba.v62, com.baidu.tieba.uc4
    public void z(String str, Map<String, String> map, Map<String, String> map2, uc4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (b) {
                N("buildGetRequest");
            }
            String b2 = lx2.b();
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
