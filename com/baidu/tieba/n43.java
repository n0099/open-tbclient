package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ex1;
import com.baidu.tieba.fe3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n43 extends j43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.k43
    public w02 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (w02) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k43
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k43
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements pn3<zd3<fe3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia2 a;
        public final /* synthetic */ h43 b;
        public final /* synthetic */ ie3 c;

        public a(n43 n43Var, ia2 ia2Var, h43 h43Var, ie3 ie3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n43Var, ia2Var, h43Var, ie3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia2Var;
            this.b = h43Var;
            this.c = ie3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(zd3<fe3.d> zd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zd3Var) == null) {
                if (zd3Var != null && zd3Var.c() && !TextUtils.isEmpty(zd3Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", zd3Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (gp1.a) {
                                o43.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                o43.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public n43() {
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

    @Override // com.baidu.tieba.j43
    public void p(SwanAppActivity swanAppActivity, String str, g43 g43Var, ie3 ie3Var, ia2<h43> ia2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, g43Var, ie3Var, ia2Var) == null) {
            h43 h43Var = new h43(g43Var.f);
            h43Var.a = g43Var.e;
            if (ie3Var != null && ie3Var.j.a() == 0) {
                o43.b("obtain user info detail, get login code");
                ex1.d dVar = new ex1.d(g43Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", g43Var.a);
                v83.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, ia2Var, h43Var, ie3Var), "SwanPluginUserInfoFunPage");
                return;
            }
            o43.b("open data result failure");
            ia2Var.a(h43Var);
        }
    }
}
