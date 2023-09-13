package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pz1;
import com.baidu.tieba.qg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y63 extends u63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.v63
    public h32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (h32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v63
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v63
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements aq3<kg3<qg3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc2 a;
        public final /* synthetic */ s63 b;
        public final /* synthetic */ tg3 c;

        public a(y63 y63Var, tc2 tc2Var, s63 s63Var, tg3 tg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y63Var, tc2Var, s63Var, tg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc2Var;
            this.b = s63Var;
            this.c = tg3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<qg3.d> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (kg3Var != null && kg3Var.c() && !TextUtils.isEmpty(kg3Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", kg3Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (rr1.a) {
                                z63.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                z63.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public y63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.u63
    public void p(SwanAppActivity swanAppActivity, String str, r63 r63Var, tg3 tg3Var, tc2<s63> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, r63Var, tg3Var, tc2Var) == null) {
            s63 s63Var = new s63(r63Var.f);
            s63Var.a = r63Var.e;
            if (tg3Var != null && tg3Var.j.a() == 0) {
                z63.b("obtain user info detail, get login code");
                pz1.d dVar = new pz1.d(r63Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", r63Var.a);
                gb3.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, tc2Var, s63Var, tg3Var), "SwanPluginUserInfoFunPage");
                return;
            }
            z63.b("open data result failure");
            tc2Var.a(s63Var);
        }
    }
}
