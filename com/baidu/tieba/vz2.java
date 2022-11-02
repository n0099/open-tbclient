package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ms1;
import com.baidu.tieba.n93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vz2 extends rz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sz2
    public ew1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (ew1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements xi3<h93<n93.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q52 a;
        public final /* synthetic */ pz2 b;
        public final /* synthetic */ q93 c;

        public a(vz2 vz2Var, q52 q52Var, pz2 pz2Var, q93 q93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz2Var, q52Var, pz2Var, q93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q52Var;
            this.b = pz2Var;
            this.c = q93Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<n93.d> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (h93Var != null && h93Var.c() && !TextUtils.isEmpty(h93Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", h93Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (ok1.a) {
                                wz2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                wz2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public vz2() {
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

    @Override // com.baidu.tieba.rz2
    public void p(SwanAppActivity swanAppActivity, String str, oz2 oz2Var, q93 q93Var, q52<pz2> q52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, oz2Var, q93Var, q52Var) == null) {
            pz2 pz2Var = new pz2(oz2Var.f);
            pz2Var.a = oz2Var.e;
            if (q93Var != null && q93Var.j.a() == 0) {
                wz2.b("obtain user info detail, get login code");
                ms1.d dVar = new ms1.d(oz2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", oz2Var.a);
                d43.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, q52Var, pz2Var, q93Var), "SwanPluginUserInfoFunPage");
                return;
            }
            wz2.b("open data result failure");
            q52Var.a(pz2Var);
        }
    }
}
