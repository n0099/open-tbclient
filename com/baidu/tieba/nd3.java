package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nd3 extends ld3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements bn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb3 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ nd3 e;

        public a(nd3 nd3Var, hb3 hb3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd3Var, hb3Var, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nd3Var;
            this.a = hb3Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
        }

        @Override // com.baidu.tieba.bn2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.e.d) {
                    za3 f = za3.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f1599);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }

        @Override // com.baidu.tieba.bn2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (rr1.a) {
                        e.printStackTrace();
                    }
                }
                if (this.e.d) {
                    ld3.m("0", "btn", "success");
                    za3 f = za3.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0141);
                    f.l(2);
                    f.G();
                }
                UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.d);
            }
        }

        @Override // com.baidu.tieba.bn2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (this.e.d && !z) {
                    za3 f = za3.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0140);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nd3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/deleteFavor");
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
                super((ec3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ld3
    public boolean j(hb3 hb3Var, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hb3Var, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(param);
                if (this.d) {
                    optString = hb3Var.O();
                } else {
                    optString = jSONObject.optString("appid");
                }
                this.c = optString;
                return !TextUtils.isEmpty(optString);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ld3
    public void k(hb3 hb3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var, unitedSchemeEntity, callbackHandler, str) == null) {
            if (this.d) {
                ld3.m("0", "btn", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST);
            } else {
                ld3.m("0", "api", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST);
            }
            SwanFavorDataManager h = SwanFavorDataManager.h();
            String str2 = this.c;
            a aVar = new a(this, hb3Var, callbackHandler, unitedSchemeEntity, str);
            cl2 l = cl2.l();
            l.n(3);
            h.c(str2, aVar, l.k());
        }
    }

    @Override // com.baidu.tieba.ld3
    public void l(hb3 hb3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        wv1 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, hb3Var, unitedSchemeEntity, callbackHandler, str) == null) && this.d && (l0 = ou2.l0()) != null) {
            l0.e(hb3Var);
        }
    }
}
