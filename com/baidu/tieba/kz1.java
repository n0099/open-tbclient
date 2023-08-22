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
/* loaded from: classes6.dex */
public class kz1 extends iz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements wp3<gg3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(kz1 kz1Var, os1 os1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz1Var, os1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = os1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<JSONObject> gg3Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (gg3Var.c() && kz1.y(gg3Var.a)) {
                    JSONObject optJSONObject = gg3Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        wh3.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        wh3.U("checkSession", "fail", "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(gg3Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    wh3.U("checkSession", "fail", "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz1(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
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

    public d32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            wh3.T("checkSession", "create");
            os1 j = lu2.j();
            CallbackHandler e = a().e();
            db3 b0 = db3.b0();
            if (b0 == null) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                wh3.U("checkSession", "fail", "empty swanApp");
                return new d32(1001, "swan app is null");
            }
            String O = b0.O();
            if (TextUtils.isEmpty(O)) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                wh3.U("checkSession", "fail", "empty app key");
                return new d32(1001, "empty app key");
            }
            JSONObject r = gz1.r(str);
            if (r == null) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                wh3.U("checkSession", "fail", "empty joParams");
                return new d32(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                wh3.U("checkSession", "fail", "empty cb");
                return new d32(201, "cb is empty");
            }
            Context context = getContext();
            if (!b0.N().e(context)) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                wh3.U("checkSession", "fail", "account not login");
                return new d32(10004, "user not logged in");
            }
            wh3.T("checkSession", "checkSession");
            jg3 g = cb3.K().x().a().b().g(context, O);
            g.q("checkSession");
            g.o(new a(this, j, e, optString));
            g.call();
            return new d32(0);
        }
        return (d32) invokeL.objValue;
    }
}
