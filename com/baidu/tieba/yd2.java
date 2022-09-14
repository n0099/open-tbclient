package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.d83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yd2 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public static final String j;
    public static final String k;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public boolean d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public JSONObject i;

    /* loaded from: classes6.dex */
    public class a implements rh3<b83<d83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ y23 d;
        public final /* synthetic */ yd2 e;

        public a(yd2 yd2Var, CallbackHandler callbackHandler, JSONObject jSONObject, Context context, y23 y23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, callbackHandler, jSONObject, context, y23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yd2Var;
            this.a = callbackHandler;
            this.b = jSONObject;
            this.c = context;
            this.d = y23Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<d83.e> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (!w73.h(b83Var)) {
                    w73.q(b83Var, this.a, this.e.h);
                    return;
                }
                this.e.i = new JSONObject();
                mb3.a().edit().putInt("aiapps_web_mode_cts_use_key", this.b.optInt("loadCts")).apply();
                if (this.b.optInt("loadCts") == 1) {
                    this.e.u(this.c);
                    yd2 yd2Var = this.e;
                    yd2Var.w(this.d, yd2Var.f, this.a, "master");
                    yd2 yd2Var2 = this.e;
                    yd2Var2.w(this.d, yd2Var2.g, this.a, "slave");
                    this.e.e = true;
                    return;
                }
                this.e.e = false;
                xy2.R(false);
                xy2.Z();
                this.a.handleSchemeDispatchCallback(this.e.h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y23 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ yd2 d;

        public b(yd2 yd2Var, y23 y23Var, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, y23Var, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yd2Var;
            this.a = y23Var;
            this.b = str;
            this.c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                yz1.c("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                this.c.handleSchemeDispatchCallback(this.d.h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                if (response.code() == 200 && response.body() != null) {
                    this.d.s(this.a, response, this.b, this.c);
                } else {
                    yz1.c("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    this.c.handleSchemeDispatchCallback(this.d.h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ yd2 c;

        public c(yd2 yd2Var, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yd2Var;
            this.a = str;
            this.b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                yz1.c("setCtsConfig", "download cts file fail");
                this.b.handleSchemeDispatchCallback(this.c.h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                yd2 yd2Var = this.c;
                yd2Var.v(response, this.a, yd2Var.h, this.b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948326242, "Lcom/baidu/tieba/yd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948326242, "Lcom/baidu/tieba/yd2;");
                return;
            }
        }
        j = String.format("?swanjs_version=%s", dc3.h(0));
        k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
        l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yd2(v33 v33Var) {
        super(v33Var, "/swanAPI/debug/setCtsConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
        this.e = false;
    }

    @Override // com.baidu.tieba.v43
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, y23Var)) == null) {
            JSONObject a2 = v43.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                yz1.c("setCtsConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (y23Var == null) {
                yz1.c("setCtsConfig", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                this.h = a2.optString("cb");
                if (!a2.has("loadCts")) {
                    yz1.c("setCtsConfig", "loadCts is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                y23Var.e0().g(context, "mapp_cts_debug", new a(this, callbackHandler, a2, context, y23Var));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void s(y23 y23Var, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y23Var, response, str, callbackHandler) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                    t(jSONObject.optJSONArray("data").optString(0), str, y23Var, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(this.h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(this.h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void t(String str, String str2, y23 y23Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, y23Var, callbackHandler) == null) {
            ba4 ba4Var = new ba4(fm2.o().m(str), new c(this, str2, callbackHandler));
            ba4Var.f = true;
            ba4Var.g = false;
            ba4Var.h = true;
            ca4.g().d(ba4Var);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (jf3.a(context, "aiapps/debug_cts_url.json")) {
                try {
                    JSONObject jSONObject = new JSONObject(jf3.b(context, "aiapps/debug_cts_url.json"));
                    this.f = jSONObject.optString("master");
                    this.g = jSONObject.optString("slave");
                    if (TextUtils.isEmpty(this.f)) {
                        this.f = k;
                    }
                    if (TextUtils.isEmpty(this.g)) {
                        this.g = l;
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.f = k;
                    this.g = l;
                    return;
                }
            }
            this.f = k;
            this.g = l;
        }
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, str, str2, callbackHandler) == null) {
            if (response.code() == 200 && response.body() != null) {
                try {
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                    File file2 = new File(file, str + ".js");
                    if (fj4.a(byteStream, file2)) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(file2);
                        char c2 = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != -1081267614) {
                            if (hashCode == 109519319 && str.equals("slave")) {
                                c2 = 1;
                            }
                        } else if (str.equals("master")) {
                            c2 = 0;
                        }
                        if (c2 == 0) {
                            this.i.put("master", jSONArray);
                            this.c = true;
                            x(this.i, callbackHandler, str2);
                            return;
                        } else if (c2 != 1) {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            yz1.c("setCtsConfig", "error type, get cts url failed");
                            return;
                        } else {
                            this.i.put("slave", jSONArray);
                            this.d = true;
                            x(this.i, callbackHandler, str2);
                            return;
                        }
                    }
                    yz1.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                } catch (Exception unused) {
                    yz1.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
            }
            yz1.c("setCtsConfig", "download cts file fail,code is " + response.code());
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void w(y23 y23Var, String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, y23Var, str, callbackHandler, str2) == null) {
            ba4 ba4Var = new ba4(str, new b(this, y23Var, str2, callbackHandler));
            ba4Var.f = true;
            ba4Var.g = false;
            ba4Var.h = true;
            ca4.g().d(ba4Var);
        }
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, callbackHandler, str) == null) && this.c && this.d && this.e) {
            xy2.R(true);
            mb3.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.d = false;
            this.c = false;
            xy2.Z();
        }
    }
}
