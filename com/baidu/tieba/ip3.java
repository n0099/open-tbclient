package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.tieba.yc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ip3 extends vy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements mm3<wc3<yc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ t73 d;
        public final /* synthetic */ ip3 e;

        /* renamed from: com.baidu.tieba.ip3$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0300a implements mm3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0300a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.mm3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    a aVar = this.a;
                    aVar.e.E(str, aVar.a, aVar.b, aVar.d);
                }
            }
        }

        public a(ip3 ip3Var, CallbackHandler callbackHandler, String str, String str2, t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip3Var, callbackHandler, str, str2, t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ip3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = t73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<yc3.e> wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                if (!rc3.h(wc3Var)) {
                    rc3.q(wc3Var, this.a, this.b);
                } else {
                    ip3.z(this.c, new C0300a(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements mm3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public b(ip3 ip3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip3Var, callbackHandler, str};
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
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.handleSchemeDispatchCallback(this.b, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;
        public final /* synthetic */ Request b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public c(mm3 mm3Var, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
            this.b = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                String str = "";
                if (exc == null) {
                    message = "";
                } else {
                    message = exc.getMessage();
                }
                this.a.a(ip3.A(message));
                SwanInterfaceType swanInterfaceType = SwanInterfaceType.REAL_NAME_CHECK;
                String httpUrl = this.b.url().toString();
                if (exc != null) {
                    str = exc.getMessage();
                }
                ye3.b(swanInterfaceType, 2101, httpUrl, null, str);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) != null) {
                return invokeLI.objValue;
            }
            ip3.F(response, this.a);
            return response;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements mm3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;

        public d(mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(Bundle bundle) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                if (bundle == null) {
                    this.a.a(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String g = sk3.g(bundle, "callbackKey");
                if (TextUtils.isEmpty(g)) {
                    this.a.a(UnitedSchemeUtility.wrapCallbackParams(1001, sk3.g(bundle, "failMsg")).toString());
                    return;
                }
                t42.i("FaceVerifyAction", g);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callbackKey", g);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e) {
                    if (ip3.e) {
                        e.printStackTrace();
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                this.a.a(wrapCallbackParams.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947861149, "Lcom/baidu/tieba/ip3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947861149, "Lcom/baidu/tieba/ip3;");
                return;
            }
        }
        e = do1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip3(q83 q83Var) {
        super(q83Var, "/swanAPI/faceVerify");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((q83) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            t42.i("FaceVerifyAction", str);
            return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
        }
        return (String) invokeL.objValue;
    }

    public static String B(String str, int i, String str2, Response response) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65539, null, str, i, str2, response)) == null) {
            ye3.c(SwanInterfaceType.REAL_NAME_CHECK, i, str2, response);
            return A(str);
        }
        return (String) invokeLILL.objValue;
    }

    public static void C(@NonNull Request request, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, request, mm3Var) == null) {
            we4 we4Var = new we4(request.url().toString(), request.body(), new c(mm3Var, request));
            we4Var.i = request.tag();
            we4Var.f = true;
            we4Var.g = true;
            we4Var.h = true;
            xe4.g().e(we4Var);
            ye3.a(SwanInterfaceType.REAL_NAME_CHECK);
        }
    }

    public static void D(String str, t73 t73Var, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, t73Var, mm3Var) == null) {
            un3.J(t73Var.w(), str, t73Var.b, new d(mm3Var));
        }
    }

    public static void F(Response response, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, response, mm3Var) == null) {
            String str = null;
            if (response == null) {
                mm3Var.a(B(ADConfigError.REASON_NULL_RESPONSE, 2103, null, null));
            } else if (!response.isSuccessful()) {
                mm3Var.a(B("response code is error", RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, response));
            } else {
                ResponseBody body = response.body();
                if (body == null) {
                    mm3Var.a(B("body is null", 2103, null, response));
                    return;
                }
                try {
                    str = body.string();
                } catch (IOException e2) {
                    if (e) {
                        e2.printStackTrace();
                    }
                }
                if (e) {
                    Log.d("FaceVerifyAction", "response body : " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    mm3Var.a(B("body is null", 2103, str, response));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt != 0) {
                        mm3Var.a(B(jSONObject.optString("errmsg"), optInt, str, response));
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        mm3Var.a(A("server data is null"));
                    } else {
                        mm3Var.a(String.valueOf(optJSONObject.optInt("real_name")));
                    }
                } catch (JSONException e3) {
                    if (e) {
                        e3.printStackTrace();
                    }
                    mm3Var.a(B("body format error", 2103, str, response));
                }
            }
        }
    }

    public static void z(String str, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, mm3Var) == null) {
            Request y = y(str);
            if (y == null) {
                mm3Var.a(null);
            } else {
                C(y, mm3Var);
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            HttpUrl parse = HttpUrl.parse(p42.a);
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
            for (Map.Entry<String, String> entry : o42.b().d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            Request.Builder builder = new Request.Builder();
            builder.tag(str);
            builder.post(new FormBody.Builder().build());
            builder.url(p42.v(build.toString()));
            return builder.build();
        }
        return (Request) invokeL.objValue;
    }

    public final void E(String str, CallbackHandler callbackHandler, String str2, t73 t73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, callbackHandler, str2, t73Var) == null) {
            if (str == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
            } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
                callbackHandler.handleSchemeDispatchCallback(str2, str);
            } else {
                D(str, t73Var, new b(this, callbackHandler, str2));
            }
        }
    }

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (t73Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (t73Var.n0()) {
                if (e) {
                    Log.d("FaceVerifyAction", "FaceVerifyAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
                    return false;
                }
                String a2 = ix1.a(t73Var.b);
                JSONObject n = n(a2);
                t73Var.e0().h(context, "mapp_i_face_verify", rc3.j(optParamsAsJo), new a(this, callbackHandler, optString, a2, t73Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
