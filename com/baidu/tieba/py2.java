package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.gr1;
import com.baidu.tieba.h83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class py2 extends ly2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements rh3<b83<h83.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k42 a;
        public final /* synthetic */ jy2 b;
        public final /* synthetic */ k83 c;

        public a(py2 py2Var, k42 k42Var, jy2 jy2Var, k83 k83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py2Var, k42Var, jy2Var, k83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k42Var;
            this.b = jy2Var;
            this.c = k83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<h83.d> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (b83Var != null && b83Var.c() && !TextUtils.isEmpty(b83Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", b83Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (ij1.a) {
                                qy2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                qy2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public py2() {
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

    @Override // com.baidu.tieba.my2
    public yu1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (yu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.my2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ly2
    public void p(SwanAppActivity swanAppActivity, String str, iy2 iy2Var, k83 k83Var, k42<jy2> k42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, iy2Var, k83Var, k42Var) == null) {
            jy2 jy2Var = new jy2(iy2Var.f);
            jy2Var.a = iy2Var.e;
            if (k83Var != null && k83Var.j.a() == 0) {
                qy2.b("obtain user info detail, get login code");
                gr1.d dVar = new gr1.d(iy2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", iy2Var.a);
                x23.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, k42Var, jy2Var, k83Var), "SwanPluginUserInfoFunPage");
                return;
            }
            qy2.b("open data result failure");
            k42Var.a(jy2Var);
        }
    }
}
