package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ip1;
import com.baidu.tieba.j63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rw2 extends nw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements tf3<d63<j63.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m22 a;
        public final /* synthetic */ lw2 b;
        public final /* synthetic */ m63 c;

        public a(rw2 rw2Var, m22 m22Var, lw2 lw2Var, m63 m63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw2Var, m22Var, lw2Var, m63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m22Var;
            this.b = lw2Var;
            this.c = m63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(d63<j63.d> d63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d63Var) == null) {
                if (d63Var != null && d63Var.c() && !TextUtils.isEmpty(d63Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", d63Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (kh1.a) {
                                sw2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                sw2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public rw2() {
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

    @Override // com.baidu.tieba.ow2
    public at1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nw2
    public void p(SwanAppActivity swanAppActivity, String str, kw2 kw2Var, m63 m63Var, m22<lw2> m22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, kw2Var, m63Var, m22Var) == null) {
            lw2 lw2Var = new lw2(kw2Var.f);
            lw2Var.a = kw2Var.e;
            if (m63Var != null && m63Var.j.a() == 0) {
                sw2.b("obtain user info detail, get login code");
                ip1.d dVar = new ip1.d(kw2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", kw2Var.a);
                z03.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, m22Var, lw2Var, m63Var), "SwanPluginUserInfoFunPage");
                return;
            }
            sw2.b("open data result failure");
            m22Var.a(lw2Var);
        }
    }
}
