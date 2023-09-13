package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oz1 extends mz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements aq3<kg3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(oz1 oz1Var, ss1 ss1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, ss1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ss1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<JSONObject> kg3Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (kg3Var.c() && oz1.y(kg3Var.a)) {
                    JSONObject optJSONObject = kg3Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        ai3.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        ai3.U("checkSession", "fail", "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(kg3Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    ai3.U("checkSession", "fail", "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oz1(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public h32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            ai3.T("checkSession", "create");
            ss1 j = pu2.j();
            CallbackHandler f = a().f();
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                ai3.U("checkSession", "fail", "empty swanApp");
                return new h32(1001, "swan app is null");
            }
            String O = b0.O();
            if (TextUtils.isEmpty(O)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                ai3.U("checkSession", "fail", "empty app key");
                return new h32(1001, "empty app key");
            }
            JSONObject r = kz1.r(str);
            if (r == null) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                ai3.U("checkSession", "fail", "empty joParams");
                return new h32(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                ai3.U("checkSession", "fail", "empty cb");
                return new h32(201, "cb is empty");
            }
            Context context = getContext();
            if (!b0.N().e(context)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                ai3.U("checkSession", "fail", "account not login");
                return new h32(10004, "user not logged in");
            }
            ai3.T("checkSession", "checkSession");
            ng3 g = gb3.K().x().a().b().g(context, O);
            g.q("checkSession");
            g.o(new a(this, j, f, optString));
            g.call();
            return new h32(0);
        }
        return (h32) invokeL.objValue;
    }
}
