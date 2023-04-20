package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.dw1;
import com.baidu.tieba.ed3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m33 extends i33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j33
    public vz1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (vz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j33
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j33
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements om3<yc3<ed3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;
        public final /* synthetic */ g33 b;
        public final /* synthetic */ hd3 c;

        public a(m33 m33Var, h92 h92Var, g33 g33Var, hd3 hd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m33Var, h92Var, g33Var, hd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
            this.b = g33Var;
            this.c = hd3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(yc3<ed3.d> yc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yc3Var) == null) {
                if (yc3Var != null && yc3Var.c() && !TextUtils.isEmpty(yc3Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", yc3Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (fo1.a) {
                                n33.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                n33.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public m33() {
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

    @Override // com.baidu.tieba.i33
    public void p(SwanAppActivity swanAppActivity, String str, f33 f33Var, hd3 hd3Var, h92<g33> h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, f33Var, hd3Var, h92Var) == null) {
            g33 g33Var = new g33(f33Var.f);
            g33Var.a = f33Var.e;
            if (hd3Var != null && hd3Var.j.a() == 0) {
                n33.b("obtain user info detail, get login code");
                dw1.d dVar = new dw1.d(f33Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", f33Var.a);
                u73.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, h92Var, g33Var, hd3Var), "SwanPluginUserInfoFunPage");
                return;
            }
            n33.b("open data result failure");
            h92Var.a(g33Var);
        }
    }
}
