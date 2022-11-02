package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class kr1 extends gr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gr1
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, callbackHandler, str) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lr1 c;
        public final /* synthetic */ kr1 d;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(kr1 kr1Var, CallbackHandler callbackHandler, String str, lr1 lr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr1Var, callbackHandler, str, lr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kr1Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = lr1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.d.r(response, this.a, this.b, this.c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ kr1 d;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) ? response : invokeLI.objValue;
        }

        public b(kr1 kr1Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr1Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kr1Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (gr1.c) {
                    Log.i("CloudUploadAction", "onFailure: ");
                }
                kr1 kr1Var = this.d;
                CallbackHandler callbackHandler = this.a;
                String str = this.b;
                kr1Var.s(callbackHandler, str, null, "uploadFile:fail" + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(er1.n(this.c, null, "uploadFile:ok"), 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kr1(b53 b53Var) {
        super(b53Var, "/swanAPI/cloudUploadFile");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b53) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public final Map<String, String> t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            ArrayMap arrayMap = new ArrayMap();
            if (jSONObject == null) {
                return arrayMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                arrayMap.put(next, jSONObject.optString(next));
            }
            return arrayMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gr1, com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            if (e43Var == null) {
                return l(unitedSchemeEntity, 1001, "swanApp is null");
            }
            JSONObject a2 = b63.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return l(unitedSchemeEntity, 202, "illegal params");
            }
            String param = unitedSchemeEntity.getParam(WebChromeClient.KEY_ARG_CALLBACK);
            if (TextUtils.isEmpty(param)) {
                return l(unitedSchemeEntity, 202, "illegal callback");
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return l(unitedSchemeEntity, 202, "illegal cb");
            }
            if (gr1.c) {
                Log.d("CloudUploadAction", "schema params : " + a2.toString());
                Log.d("CloudUploadAction", "schema cb : " + optString);
            }
            lr1 p = p(a2);
            if (p == null) {
                l(unitedSchemeEntity, 202, "illegal params");
                return false;
            }
            Request c = er1.c(e43Var, a2, unitedSchemeEntity);
            if (c != null) {
                callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                er1.p(c.url().toString(), c.body(), new a(this, callbackHandler, optString, p));
                return true;
            }
            callbackHandler.handleSchemeDispatchCallback(param, unitedSchemeEntity.result.toString());
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public lr1 p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("fileMap");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("stringMap");
            if (optJSONObject == null || optJSONObject2 == null) {
                return null;
            }
            String optString = optJSONObject2.optString("cloudPath");
            if (TextUtils.isEmpty(optString) || optString.startsWith("/") || optString.contains("@")) {
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String M = mb3.M(optJSONObject.optString(keys.next()), e43.g0());
                if (M != null && !TextUtils.isEmpty(M)) {
                    File file = new File(M);
                    if (file.exists()) {
                        lr1 lr1Var = new lr1(file);
                        u(jSONObject, lr1Var.contentLength());
                        return lr1Var;
                    }
                }
            }
            return null;
        }
        return (lr1) invokeL.objValue;
    }

    public final int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (gr1.c) {
                    e.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeL.intValue;
    }

    public final void r(Response response, CallbackHandler callbackHandler, String str, RequestBody requestBody) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, callbackHandler, str, requestBody) == null) {
            if (!response.isSuccessful()) {
                s(callbackHandler, str, null, null);
                return;
            }
            String header = response.header("Content-Type", "");
            if (header != null && header.contains("application/json")) {
                JSONObject m = er1.m(response);
                if (m != null && response.isSuccessful()) {
                    String optString = m.optString("errno", String.valueOf(0));
                    String optString2 = m.optString("errmsg");
                    if (er1.o(optString)) {
                        s(callbackHandler, str, optString, optString2);
                        return;
                    }
                    String optString3 = m.optString("UploadUrl");
                    String optString4 = m.optString("fileID");
                    if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                        JSONObject optJSONObject = m.optJSONObject("ExtraHeaders");
                        if (optJSONObject == null) {
                            s(callbackHandler, str, optString, optString2);
                            return;
                        }
                        Map<String, String> t = t(optJSONObject);
                        try {
                            Request build = new Request.Builder().headers(Headers.of(t)).url(optString3).put(requestBody).build();
                            if (e43.M() == null) {
                                k(callbackHandler, str, 1001, "uploadFile:fail");
                                return;
                            }
                            hb4 hb4Var = new hb4(build.url().toString(), build.body(), new b(this, callbackHandler, str, optString4));
                            hb4Var.c = t;
                            hb4Var.f = true;
                            hb4Var.g = false;
                            hb4Var.h = true;
                            ib4.g().f(hb4Var);
                            return;
                        } catch (Exception e) {
                            if (gr1.c) {
                                e.printStackTrace();
                            }
                            s(callbackHandler, str, optString, optString2);
                            return;
                        }
                    }
                    s(callbackHandler, str, optString, optString2);
                    return;
                }
                k(callbackHandler, str, 1001, "uploadFile:fail");
                return;
            }
            k(callbackHandler, str, 1001, "uploadFile:fail");
        }
    }

    public final void s(CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, callbackHandler, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2)) {
                k(callbackHandler, str, 1001, "uploadFile:fail");
            } else {
                k(callbackHandler, str, q(str2), er1.k(str3));
            }
        }
    }

    public final void u(JSONObject jSONObject, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048583, this, jSONObject, j) != null) || jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("Content-Length", String.valueOf(j));
            jSONObject2.put("Headers", jSONObject3);
            if (optJSONObject != null) {
                optJSONObject.put("data", jSONObject2);
                jSONObject.put("stringMap", optJSONObject);
            }
        } catch (JSONException e) {
            if (gr1.c) {
                e.printStackTrace();
            }
        }
    }
}
