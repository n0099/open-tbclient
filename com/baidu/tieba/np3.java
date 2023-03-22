package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class np3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    /* loaded from: classes5.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ np3 d;

        public a(np3 np3Var, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {np3Var, callbackHandler, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = np3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONObject;
        }

        @Override // com.baidu.tieba.np3.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    this.d.p(this.a, this.b, this.c);
                    return;
                }
                np3 np3Var = this.d;
                np3Var.c = np3Var.m(jSONObject);
                this.d.p(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(np3 np3Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {np3Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                try {
                    this.a.a(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.a.a(null);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.a.a(null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public np3(q83 q83Var) {
        super(q83Var, "/swanAPI/privateGetUserInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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
        this.c = -1;
    }

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (t73Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            try {
                o(context, callbackHandler, t73Var, optString);
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, CallbackHandler callbackHandler, t73 t73Var, String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, callbackHandler, t73Var, str) == null) {
            String y = un3.y(context);
            if (!TextUtils.isEmpty(un3.i(context)) && !TextUtils.isEmpty(y)) {
                JSONObject jSONObject = new JSONObject();
                uo3 g = un3.g(context);
                jSONObject.put("displayname", g.a);
                jSONObject.put("portrait", g.b);
                if (this.c != -1) {
                    p(callbackHandler, str, jSONObject);
                    return;
                } else {
                    n(new a(this, callbackHandler, str, jSONObject));
                    return;
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
        }
    }

    public final int m(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONObject == null) {
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        optJSONObject = optJSONArray.getJSONObject(0);
                    } else {
                        if (q93.b) {
                            Log.d(BaseJsonData.TAG, "Invalid data field!");
                        }
                        optJSONObject = null;
                    }
                }
                if (optJSONObject == null || (jSONObject2 = optJSONObject.getJSONObject("userx")) == null || (jSONObject3 = jSONObject2.getJSONObject(Config.EVENT_ATTR)) == null || (jSONObject4 = jSONObject3.getJSONObject("dataset")) == null) {
                    return -1;
                }
                return jSONObject4.optInt("gender");
            } catch (JSONException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void n(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) != null) || cVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gender", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(p42.v(tn3.c()))).addParam("data", jSONObject.toString()).cookieManager(ar2.q().a())).build().executeAsync(new b(this, cVar));
    }

    public final void p(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, callbackHandler, str, jSONObject) == null) {
            int i = this.c;
            if (i != -1) {
                try {
                    jSONObject.put("gender", String.valueOf(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
