package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.tieba.bl2;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes8.dex */
public class wd3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ wd3 h;

        public a(wd3 wd3Var, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd3Var, callbackHandler, str, unitedSchemeEntity, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = wd3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = unitedSchemeEntity;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    this.h.m(this.c, this.a, this.d, this.e, this.f, this.g, this.b);
                } else {
                    fg3.q(kg3Var, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements gbc<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bl2.b b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ String e;

        public b(wd3 wd3Var, String str, bl2.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd3Var, str, bVar, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = bVar;
            this.c = callbackHandler;
            this.d = unitedSchemeEntity;
            this.e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gbc
        public void call(Boolean bool) {
            hb3 M;
            c83 y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.a) && (M = hb3.M()) != null && (y = M.y()) != null) {
                        y.a0(8, new SwanAppDeleteInfo(this.a).setPurgerScenes(cl2.m(this.b).c()));
                    }
                    h82.i("history", "remove success");
                    if (ed3.b) {
                        Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + this.a);
                    }
                    UnitedSchemeUtility.safeCallback(this.c, this.d, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.e);
                    return;
                }
                h82.o("history", "execute fail --- no match app id");
                if (ed3.b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
                }
                UnitedSchemeUtility.safeCallback(this.c, this.d, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements lbc<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ bl2.b d;

        public c(wd3 wd3Var, String str, String str2, String str3, bl2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd3Var, str, str2, str3, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return Boolean.valueOf(ki2.g(AppRuntime.getAppContext().getContentResolver(), this.a, str, this.b, this.c, false, this.d));
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/deleteHistory");
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
            if (hb3Var == null) {
                h82.c("history", "none swanApp");
                if (ed3.b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                h82.c("history", "empty joParams");
                if (ed3.b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("history", "empty cb");
                if (ed3.b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            String optString3 = optParamsAsJo.optString("appKey");
            String optString4 = optParamsAsJo.optString("version");
            String optString5 = optParamsAsJo.optString("type");
            if (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)) {
                h82.c("history", "empty appKey");
                if (ed3.b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty appKey");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
                return false;
            }
            hb3Var.e0().g(context, "mapp_i_delete_history", new a(this, callbackHandler, optString, unitedSchemeEntity, optString2, optString3, optString4, optString5));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{unitedSchemeEntity, callbackHandler, str, str2, str3, str4, str5}) == null) {
            h82.i("history", "start remove history");
            cl2 l = cl2.l();
            l.n(4);
            bl2.b k = l.k();
            sac.n(str2).J(Schedulers.io()).p(new c(this, str, str3, str4, k)).s(cbc.b()).H(new b(this, str, k, callbackHandler, unitedSchemeEntity, str5));
        }
    }
}
