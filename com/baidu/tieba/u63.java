package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.lz1;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u63 extends q63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.r63
    public d32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (d32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r63
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r63
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements wp3<gg3<mg3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2 a;
        public final /* synthetic */ o63 b;
        public final /* synthetic */ pg3 c;

        public a(u63 u63Var, pc2 pc2Var, o63 o63Var, pg3 pg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u63Var, pc2Var, o63Var, pg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pc2Var;
            this.b = o63Var;
            this.c = pg3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<mg3.d> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (gg3Var != null && gg3Var.c() && !TextUtils.isEmpty(gg3Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", gg3Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (nr1.a) {
                                v63.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                v63.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public u63() {
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

    @Override // com.baidu.tieba.q63
    public void p(SwanAppActivity swanAppActivity, String str, n63 n63Var, pg3 pg3Var, pc2<o63> pc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, n63Var, pg3Var, pc2Var) == null) {
            o63 o63Var = new o63(n63Var.f);
            o63Var.a = n63Var.e;
            if (pg3Var != null && pg3Var.j.a() == 0) {
                v63.b("obtain user info detail, get login code");
                lz1.d dVar = new lz1.d(n63Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", n63Var.a);
                cb3.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, pc2Var, o63Var, pg3Var), "SwanPluginUserInfoFunPage");
                return;
            }
            v63.b("open data result failure");
            pc2Var.a(o63Var);
        }
    }
}
