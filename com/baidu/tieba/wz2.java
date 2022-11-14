package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ns1;
import com.baidu.tieba.o93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wz2 extends sz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tz2
    public fw1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (fw1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements yi3<i93<o93.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r52 a;
        public final /* synthetic */ qz2 b;
        public final /* synthetic */ r93 c;

        public a(wz2 wz2Var, r52 r52Var, qz2 qz2Var, r93 r93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz2Var, r52Var, qz2Var, r93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r52Var;
            this.b = qz2Var;
            this.c = r93Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(i93<o93.d> i93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i93Var) == null) {
                if (i93Var != null && i93Var.c() && !TextUtils.isEmpty(i93Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", i93Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (pk1.a) {
                                xz2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                xz2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public wz2() {
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

    @Override // com.baidu.tieba.sz2
    public void p(SwanAppActivity swanAppActivity, String str, pz2 pz2Var, r93 r93Var, r52<qz2> r52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, pz2Var, r93Var, r52Var) == null) {
            qz2 qz2Var = new qz2(pz2Var.f);
            qz2Var.a = pz2Var.e;
            if (r93Var != null && r93Var.j.a() == 0) {
                xz2.b("obtain user info detail, get login code");
                ns1.d dVar = new ns1.d(pz2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", pz2Var.a);
                e43.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, r52Var, qz2Var, r93Var), "SwanPluginUserInfoFunPage");
                return;
            }
            xz2.b("open data result failure");
            r52Var.a(qz2Var);
        }
    }
}
