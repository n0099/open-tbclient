package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class sr1 extends qr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ei3<o83<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(sr1 sr1Var, wk1 wk1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr1Var, wk1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wk1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<JSONObject> o83Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (o83Var.c() && sr1.y(o83Var.a)) {
                    JSONObject optJSONObject = o83Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean(TiebaStatic.LogFields.RESULT)) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        ea3.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        ea3.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(o83Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    ea3.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sr1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0") : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    public lv1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            ea3.T("checkSession", "create");
            wk1 j = tm2.j();
            CallbackHandler g = a().g();
            l33 b0 = l33.b0();
            if (b0 == null) {
                j.g(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                ea3.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty swanApp");
                return new lv1(1001, "swan app is null");
            }
            String O = b0.O();
            if (TextUtils.isEmpty(O)) {
                j.g(g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                ea3.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty app key");
                return new lv1(1001, "empty app key");
            }
            JSONObject r = or1.r(str);
            if (r == null) {
                j.g(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                ea3.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty joParams");
                return new lv1(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                ea3.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new lv1(201, "cb is empty");
            }
            Context context = getContext();
            if (!b0.N().e(context)) {
                j.g(g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                ea3.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "account not login");
                return new lv1(10004, "user not logged in");
            }
            ea3.T("checkSession", "checkSession");
            r83 g2 = k33.K().x().a().b().g(context, O);
            g2.q("checkSession");
            g2.o(new a(this, j, g, optString));
            g2.call();
            return new lv1(0);
        }
        return (lv1) invokeL.objValue;
    }
}
