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
/* loaded from: classes8.dex */
public class xt1 extends vt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements ik3<sa3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bn1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(xt1 xt1Var, bn1 bn1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt1Var, bn1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bn1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<JSONObject> sa3Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (sa3Var.c() && xt1.z(sa3Var.a)) {
                    JSONObject optJSONObject = sa3Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        ic3.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        ic3.U("checkSession", "fail", "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(sa3Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    ic3.U("checkSession", "fail", "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean z(JSONObject jSONObject) {
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

    public qx1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#checkSession", false);
            ic3.T("checkSession", "create");
            bn1 j = xo2.j();
            CallbackHandler f = a().f();
            p53 c0 = p53.c0();
            if (c0 == null) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                ic3.U("checkSession", "fail", "empty swanApp");
                return new qx1(1001, "swan app is null");
            }
            String P = c0.P();
            if (TextUtils.isEmpty(P)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                ic3.U("checkSession", "fail", "empty app key");
                return new qx1(1001, "empty app key");
            }
            JSONObject s = tt1.s(str);
            if (s == null) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                ic3.U("checkSession", "fail", "empty joParams");
                return new qx1(201, "empty joParams");
            }
            String optString = s.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                ic3.U("checkSession", "fail", "empty cb");
                return new qx1(201, "cb is empty");
            }
            Context i = i();
            if (!c0.N().e(i)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                ic3.U("checkSession", "fail", "account not login");
                return new qx1(10004, "user not logged in");
            }
            ic3.T("checkSession", "checkSession");
            va3 g = o53.K().x().a().b().g(i, P);
            g.r("checkSession");
            g.p(new a(this, j, f, optString));
            g.a();
            return new qx1(0);
        }
        return (qx1) invokeL.objValue;
    }
}
