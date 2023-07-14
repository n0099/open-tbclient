package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.d02;
import com.baidu.tieba.eh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m73 extends i73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j73
    public v32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (v32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j73
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j73
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements oq3<yg3<eh3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd2 a;
        public final /* synthetic */ g73 b;
        public final /* synthetic */ hh3 c;

        public a(m73 m73Var, hd2 hd2Var, g73 g73Var, hh3 hh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, hd2Var, g73Var, hh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd2Var;
            this.b = g73Var;
            this.c = hh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<eh3.d> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (yg3Var != null && yg3Var.c() && !TextUtils.isEmpty(yg3Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", yg3Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (fs1.a) {
                                n73.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                n73.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public m73() {
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

    @Override // com.baidu.tieba.i73
    public void p(SwanAppActivity swanAppActivity, String str, f73 f73Var, hh3 hh3Var, hd2<g73> hd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, f73Var, hh3Var, hd2Var) == null) {
            g73 g73Var = new g73(f73Var.f);
            g73Var.a = f73Var.e;
            if (hh3Var != null && hh3Var.j.a() == 0) {
                n73.b("obtain user info detail, get login code");
                d02.d dVar = new d02.d(f73Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", f73Var.a);
                ub3.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, hd2Var, g73Var, hh3Var), "SwanPluginUserInfoFunPage");
                return;
            }
            n73.b("open data result failure");
            hd2Var.a(g73Var);
        }
    }
}
