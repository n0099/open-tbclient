package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sc3 extends rc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;

    public sc3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        hc3.i(this);
        hc3.h(this);
        hc3.f(this);
        hc3.g(this);
    }

    @Override // com.baidu.tieba.rc3
    public JSONObject f() {
        int i;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                p53 F = cr2.V().F();
                if (TextUtils.equals(this.a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                    i = 1;
                } else {
                    i = 0;
                }
                String i2 = ue3.i(this.k, i);
                if (F != null && F.Z() != null) {
                    mq2.a Z = F.Z();
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = F.l0();
                    }
                    if (TextUtils.isEmpty(this.m)) {
                        this.m = Z.y1();
                    }
                    Bundle Q = Z.Q();
                    if (Q != null) {
                        this.o = Q.getString("aiapp_extra_need_download", "");
                    }
                    if (TextUtils.isEmpty(this.p)) {
                        this.p = Z.X();
                    }
                    this.p = hc3.b(this.p);
                    if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(Z.f0())) {
                        this.s = Z.f0();
                    }
                    String b = hc3.b(this.s);
                    this.s = b;
                    if (b == null) {
                        this.s = "";
                    }
                    if (TextUtils.isEmpty(this.u)) {
                        this.u = Z.W();
                    }
                }
                this.n = SwanAppNetworkUtils.f().type;
                if (this.h == null) {
                    this.h = new JSONObject();
                }
                this.h.put("swan", i2);
                this.h.put("appversion", this.l);
                this.h.put("thirdversion", this.m);
                this.h.put("net", this.n);
                this.h.put("needdown", this.o);
                this.h.put("scheme", this.p);
                this.h.put("page", this.s);
                this.h.put("launchid", this.u);
                if (!TextUtils.isEmpty(this.t)) {
                    this.h.put("error_code", this.t);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    this.h.put("canceltime", this.q);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    this.h.put("successtime", this.r);
                }
                if (rc3.j) {
                    Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.h + "\t " + Thread.currentThread().getId());
                }
            } catch (JSONException e) {
                if (rc3.j) {
                    e.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public void h(pq2 pq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pq2Var) == null) {
            if (pq2Var == null) {
                if (rc3.j) {
                    Log.w("SwanAppUBCEvent", "launchinfo is null");
                    return;
                }
                return;
            }
            this.f = pq2Var.I();
            this.c = pq2Var.U();
            this.o = pq2Var.t0().getString("aiapp_extra_need_download", "");
            this.p = pq2Var.X();
            this.s = pq2Var.f0();
            this.u = pq2Var.W();
        }
    }

    public void i(pq2 pq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pq2Var) == null) {
            h(pq2Var);
        }
    }

    public void j(pq2 pq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pq2Var) == null) {
            h(pq2Var);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }
}
