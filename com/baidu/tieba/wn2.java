package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wn2 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public db3 d;
    public CallbackHandler e;

    /* loaded from: classes8.dex */
    public class a implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        public a(wn2 wn2Var, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn2Var, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unitedSchemeEntity;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(i, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wn2 b;

        public b(wn2 wn2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wn2Var;
            this.a = str;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(i, str).toString());
                } else {
                    this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements xn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wn2 b;

        public c(wn2 wn2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wn2Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.h93
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }

        @Override // com.baidu.tieba.h93
        public void onSuccess(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (!j93.c.c()) {
                    if (ku2.h0().e(this.b.c)) {
                        j93.c.e();
                    } else {
                        j93.c.f();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wn2(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/getFormId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (unitedSchemeEntity == null) {
                if (ad3.b) {
                    Log.w("GetFormIdAction", "entity is null");
                }
                return false;
            } else if (db3Var != null && (context instanceof Activity) && callbackHandler != null) {
                this.c = context;
                this.d = db3Var;
                this.e = callbackHandler;
                JSONObject a2 = ad3.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.length() != 0) {
                    String optString = a2.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        if (ad3.b) {
                            Log.w("GetFormIdAction", "cb is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String O = db3Var.O();
                    if (TextUtils.isEmpty(O)) {
                        if (ad3.b) {
                            Log.w("GetFormIdAction", "appKey is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                        return false;
                    }
                    if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a2.optString("reportType"))) {
                        SubscribeHelper subscribeHelper = new SubscribeHelper();
                        if (!subscribeHelper.n(this.c, this.d, O, a2, SubscribeHelper.invokeSubscribeFrom.GET_FORM_ID_BUTTON, new a(this, unitedSchemeEntity))) {
                            return false;
                        }
                        subscribeHelper.o(O, new b(this, optString));
                    } else {
                        l(O, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                if (ad3.b) {
                    Log.d("GetFormIdAction", "runtime parameter error");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (!SubscribeHelper.l()) {
                this.e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(do3.f(null, "data", do3.f(null, "formid", "")), 0).toString());
                return;
            }
            ku2.W().c(str, new c(this, str2));
        }
    }
}
