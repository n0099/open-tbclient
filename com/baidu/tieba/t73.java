package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.mq2;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class t73 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public boolean d;

    public abstract boolean j(p53 p53Var, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(p53 p53Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public void l(p53 p53Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, p53Var, unitedSchemeEntity, callbackHandler, str) == null) {
        }
    }

    public boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ p53 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ t73 e;

        public a(t73 t73Var, CallbackHandler callbackHandler, String str, p53 p53Var, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var, callbackHandler, str, p53Var, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t73Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = p53Var;
            this.d = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (!na3.h(sa3Var)) {
                    na3.q(sa3Var, this.a, this.b);
                    this.e.l(this.c, this.d, this.a, this.b);
                    return;
                }
                this.e.k(this.c, this.d, this.a, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t73(m63 m63Var, String str) {
        super(m63Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var, str};
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
        this.c = null;
        this.d = false;
    }

    public static void m(String str, String str2, String str3) {
        p53 c0;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, str, str2, str3) != null) || (c0 = p53.c0()) == null) {
            return;
        }
        rc3 rc3Var = new rc3();
        mq2.a X = c0.X();
        rc3Var.a = ic3.n(X.H());
        rc3Var.e = str3;
        rc3Var.b = DI.BD.FAVOR;
        rc3Var.f = c0.P();
        SwanCoreVersion k0 = X.k0();
        String a0 = c0.a0();
        if (k0 != null) {
            str4 = k0.swanCoreVersionName;
        } else {
            str4 = "";
        }
        rc3Var.a("appName", a0);
        rc3Var.a("isFavor", str);
        rc3Var.a("favorBy", str2);
        rc3Var.a("swan", str4);
        wb3.i("2571", "89", rc3Var.f());
    }

    @Override // com.baidu.tieba.m73
    public final boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (p53Var == null) {
                p22.c("favorite", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (m73.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                }
                return false;
            }
            JSONObject d = pi3.d(unitedSchemeEntity.getParam("params"));
            String optString = d.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p22.c("favorite", "none cb");
                if (m73.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            this.d = d.optBoolean("isFavorButton", false);
            if (!j(p53Var, unitedSchemeEntity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, IActiveUploadListener.PARAM_ERR_MSG);
                return false;
            }
            String optString2 = d.optString("slaveId");
            String U = cr2.V().U();
            if (TextUtils.equals(optString2, cr2.V().D()) && (TextUtils.equals(U, "pages/swan-news-showcase/index") || TextUtils.equals(U, "pages/swan-operate-news/index"))) {
                k(p53Var, unitedSchemeEntity, callbackHandler, optString);
            } else if (!o(unitedSchemeEntity)) {
                y93 f0 = p53Var.f0();
                if (this.d) {
                    str = "scope_favorite_button";
                } else {
                    str = "mapp_favorite";
                }
                f0.g(context, str, new a(this, callbackHandler, optString, p53Var, unitedSchemeEntity));
            } else {
                k(p53Var, unitedSchemeEntity, callbackHandler, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e) {
                if (am1.a) {
                    e.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }
}
