package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ve3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ hb3 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ve3 e;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(ve3 ve3Var, String str, CallbackHandler callbackHandler, hb3 hb3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, str, callbackHandler, hb3Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ve3Var;
            this.a = str;
            this.b = callbackHandler;
            this.c = hb3Var;
            this.d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.b.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
                mi3.b(SwanInterfaceType.NAVIGATE, 2101, this.d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.e.n(response, this.a, this.b, this.c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ve3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/navigateToProgram");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (hb3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (hb3Var.n0()) {
                if (ed3.b) {
                    Log.d("NavigateToSmartProgram", "NavigateToSmartProgram does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                String a2 = j32.a(hb3Var.O());
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a2.trim())) {
                    String optString = optParamsAsJo.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    } else if (TextUtils.equals(optParamsAsJo.optString("appKey"), a2)) {
                        if (callbackHandler != null) {
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(202, "The target program is running now.").toString());
                        }
                        return true;
                    } else if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a2.trim())) {
                        Request l = l(a2, optParamsAsJo);
                        if (l == null) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                            return false;
                        }
                        m(l.body(), unitedSchemeEntity, optString, callbackHandler, hb3Var);
                        return true;
                    } else {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final Uri k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = BaiduIdentityManager.VALUE_OSNAME;
            }
            buildUpon.scheme(schemeHead);
            if (ed3.b) {
                Log.i("NavigateToSmartProgram", buildUpon.build().toString());
            }
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final Request l(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                String b = h13.b(bp3.n());
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, str);
                    jSONObject2.put("srcAppPage", b);
                    jSONObject2.put("params", jSONObject);
                    Request build = new Request.Builder().url(ou2.o().I()).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                    if (ed3.b) {
                        Log.i("NavigateToSmartProgram", "appKey :" + str + "\nrequest params" + jSONObject2.toString());
                    }
                    return build;
                } catch (Exception e) {
                    if (ed3.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (Request) invokeLL.objValue;
    }

    public final void m(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, String str, CallbackHandler callbackHandler, hb3 hb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, requestBody, unitedSchemeEntity, str, callbackHandler, hb3Var) == null) {
            String I = ou2.o().I();
            ki4 ki4Var = new ki4(I, requestBody, new a(this, str, callbackHandler, hb3Var, I));
            ki4Var.f = true;
            ki4Var.g = false;
            ki4Var.h = true;
            li4.g().e(ki4Var);
            mi3.a(SwanInterfaceType.NAVIGATE);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void n(Response response, String str, CallbackHandler callbackHandler, hb3 hb3Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, str, callbackHandler, hb3Var) == null) {
            try {
                if (!response.isSuccessful()) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    mi3.c(SwanInterfaceType.NAVIGATE, RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, response);
                    return;
                }
                String string = response.body().string();
                JSONObject jSONObject = new JSONObject(string);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    mi3.c(SwanInterfaceType.NAVIGATE, jSONObject.optInt("errno", 2103), string, response);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                Uri k = k(optJSONObject.optString("scheme"));
                if (k == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                if (SchemeRouter.invokeScheme(hb3Var.getApplicationContext(), k, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    i = 0;
                } else {
                    i = 1001;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i).toString());
            } catch (Exception e) {
                if (ed3.b) {
                    Log.d("NavigateToSmartProgram", e.getMessage());
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                mi3.c(SwanInterfaceType.NAVIGATE, 2103, e.getMessage(), null);
            }
        }
    }
}
