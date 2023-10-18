package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes9.dex */
public class zw2 extends rw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HttpUrl b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ c f;

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(zw2 zw2Var, String str, HttpUrl httpUrl, String str2, int i, long j, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw2Var, str, httpUrl, str2, Integer.valueOf(i), Long.valueOf(j), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = httpUrl;
            this.c = str2;
            this.d = i;
            this.e = j;
            this.f = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                ic3.C(this.c, this.d, null, this.e, System.currentTimeMillis(), this.a);
                if (exc instanceof IOException) {
                    this.f.onFailure(null, (IOException) exc);
                } else {
                    this.f.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i, networkStatRecord)) == null) {
                za2.k().C(this.a, this.b, networkStatRecord);
                ic3.C(this.c, this.d, networkStatRecord, this.e, System.currentTimeMillis(), this.a);
                this.f.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ik3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public b(zw2 zw2Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw2Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public p53 a;
        public JSONObject b;
        public String c;
        public String d;
        public CallbackHandler e;
        public String f;
        public long g;
        public final /* synthetic */ zw2 h;

        public c(@NonNull zw2 zw2Var, @NonNull p53 p53Var, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull CallbackHandler callbackHandler, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw2Var, p53Var, jSONObject, str, str2, callbackHandler, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = zw2Var;
            this.a = p53Var;
            this.b = jSONObject;
            this.c = str;
            this.d = str2;
            this.e = callbackHandler;
            this.f = str3;
            this.g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (m73.b) {
                    Log.d("RequestAction", "onFailure: " + iOException.getMessage());
                }
                int H = this.a.Z().H();
                String l = ic3.l();
                String e = jj3.n().e();
                SwanAppNetworkUtils.a(tc4.g().getOkHttpClient(), this.d);
                this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                ic3.Q(0, this.c, H, iOException.getMessage(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!ic3.o(this.c)) {
                    le3.l().x(this.c, response.headers("Set-cookie"));
                }
                String K = ev1.K(this.b);
                String M = ev1.M(this.b);
                int H = this.a.Z().H();
                long currentTimeMillis = System.currentTimeMillis();
                String l = ic3.l();
                String e = jj3.n().e();
                String optString = this.b.optString("cb");
                try {
                    long L = ev1.L(response);
                    if (L <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", rw2.s(response.headers()));
                        ev1.S(jSONObject, response.body(), K, M);
                        this.h.y(jSONObject);
                        this.e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        ev1.T(this.a, this.c, L, currentTimeMillis);
                        this.e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e2) {
                    if (m73.b) {
                        Log.d("RequestAction", Log.getStackTraceString(e2));
                    }
                    this.e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (m73.b) {
                    Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.c + ", msg=" + message);
                }
                ic3.Q(code, this.c, H, message, l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zw2(m63 m63Var) {
        super(m63Var, "/swanAPI/request");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((m63) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zw2(m63 m63Var, String str) {
        super(m63Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((m63) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean A(@NonNull p53 p53Var, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, p53Var, unitedSchemeEntity, callbackHandler, str)) == null) {
            JSONObject a2 = m73.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return false;
            }
            Pair<HttpRequest, Integer> D = ev1.D(a2, str);
            HttpRequest httpRequest = (HttpRequest) D.first;
            if (httpRequest == null) {
                unitedSchemeEntity.result = t(((Integer) D.second).intValue());
                return false;
            }
            z(p53Var, a2, httpRequest, str, callbackHandler);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (m73.b) {
                Log.d("RequestApi", "request with scheme : " + unitedSchemeEntity.getParam("params"));
            }
            if (!k(p53Var, unitedSchemeEntity)) {
                return false;
            }
            String a2 = fv1.a(p53Var.b);
            if (!A(p53Var, unitedSchemeEntity, callbackHandler, a2)) {
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean x(@NonNull p53 p53Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{p53Var, jSONObject, str, str2, callbackHandler, str3})) == null) {
            return wo2.e().i(p53Var, jSONObject, str, str2, new c(this, p53Var, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3));
        }
        return invokeCommon.booleanValue;
    }

    public final void z(@NonNull p53 p53Var, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, p53Var, jSONObject, httpRequest, str, callbackHandler) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            String optString = jSONObject.optString("cb");
            if (x(p53Var, jSONObject, httpUrl, str, callbackHandler, optString)) {
                return;
            }
            httpRequest.executeStat(new a(this, str, url, httpUrl, p53Var.Z().H(), System.currentTimeMillis(), new c(this, p53Var, jSONObject, httpUrl, str, callbackHandler, optString)));
        }
    }
}
