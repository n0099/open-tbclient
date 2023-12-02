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
public class su1 extends qu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements dl3<nb3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(su1 su1Var, wn1 wn1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var, wn1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<JSONObject> nb3Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (nb3Var.c() && su1.z(nb3Var.a)) {
                    JSONObject optJSONObject = nb3Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        dd3.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        dd3.U("checkSession", "fail", "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(nb3Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    dd3.U("checkSession", "fail", "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
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

    public ly1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#checkSession", false);
            dd3.T("checkSession", "create");
            wn1 j = sp2.j();
            CallbackHandler f = a().f();
            k63 c0 = k63.c0();
            if (c0 == null) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                dd3.U("checkSession", "fail", "empty swanApp");
                return new ly1(1001, "swan app is null");
            }
            String P = c0.P();
            if (TextUtils.isEmpty(P)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                dd3.U("checkSession", "fail", "empty app key");
                return new ly1(1001, "empty app key");
            }
            JSONObject s = ou1.s(str);
            if (s == null) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                dd3.U("checkSession", "fail", "empty joParams");
                return new ly1(201, "empty joParams");
            }
            String optString = s.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                dd3.U("checkSession", "fail", "empty cb");
                return new ly1(201, "cb is empty");
            }
            Context i = i();
            if (!c0.N().e(i)) {
                j.g(f, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                dd3.U("checkSession", "fail", "account not login");
                return new ly1(10004, "user not logged in");
            }
            dd3.T("checkSession", "checkSession");
            qb3 g = j63.K().x().a().b().g(i, P);
            g.r("checkSession");
            g.p(new a(this, j, f, optString));
            g.a();
            return new ly1(0);
        }
        return (ly1) invokeL.objValue;
    }
}
