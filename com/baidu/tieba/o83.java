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
import com.baidu.tieba.hr2;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class o83 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public boolean d;

    public abstract boolean j(k63 k63Var, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(k63 k63Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public void l(k63 k63Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, k63Var, unitedSchemeEntity, callbackHandler, str) == null) {
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

    /* loaded from: classes7.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k63 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ o83 e;

        public a(o83 o83Var, CallbackHandler callbackHandler, String str, k63 k63Var, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o83Var, callbackHandler, str, k63Var, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = o83Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = k63Var;
            this.d = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    ib3.q(nb3Var, this.a, this.b);
                    this.e.l(this.c, this.d, this.a, this.b);
                    return;
                }
                this.e.k(this.c, this.d, this.a, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o83(h73 h73Var, String str) {
        super(h73Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var, str};
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
        k63 c0;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, str, str2, str3) != null) || (c0 = k63.c0()) == null) {
            return;
        }
        md3 md3Var = new md3();
        hr2.a X = c0.X();
        md3Var.a = dd3.n(X.H());
        md3Var.e = str3;
        md3Var.b = DI.BD.FAVOR;
        md3Var.f = c0.P();
        SwanCoreVersion k0 = X.k0();
        String a0 = c0.a0();
        if (k0 != null) {
            str4 = k0.swanCoreVersionName;
        } else {
            str4 = "";
        }
        md3Var.a("appName", a0);
        md3Var.a("isFavor", str);
        md3Var.a("favorBy", str2);
        md3Var.a("swan", str4);
        rc3.i("2571", "89", md3Var.f());
    }

    @Override // com.baidu.tieba.h83
    public final boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (k63Var == null) {
                k32.c("favorite", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (h83.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                }
                return false;
            }
            JSONObject d = kj3.d(unitedSchemeEntity.getParam("params"));
            String optString = d.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                k32.c("favorite", "none cb");
                if (h83.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            this.d = d.optBoolean("isFavorButton", false);
            if (!j(k63Var, unitedSchemeEntity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, IActiveUploadListener.PARAM_ERR_MSG);
                return false;
            }
            String optString2 = d.optString("slaveId");
            String U = xr2.V().U();
            if (TextUtils.equals(optString2, xr2.V().D()) && (TextUtils.equals(U, "pages/swan-news-showcase/index") || TextUtils.equals(U, "pages/swan-operate-news/index"))) {
                k(k63Var, unitedSchemeEntity, callbackHandler, optString);
            } else if (!o(unitedSchemeEntity)) {
                ta3 f0 = k63Var.f0();
                if (this.d) {
                    str = "scope_favorite_button";
                } else {
                    str = "mapp_favorite";
                }
                f0.g(context, str, new a(this, callbackHandler, optString, k63Var, unitedSchemeEntity));
            } else {
                k(k63Var, unitedSchemeEntity, callbackHandler, optString);
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
                if (vm1.a) {
                    e.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }
}
