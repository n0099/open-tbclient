package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.tieba.od4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ld4<T> implements od4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ac4 a;
    public lf4 b;
    public String c;

    public abstract boolean f(T t);

    public abstract String h();

    public boolean s(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract zc4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public ld4(ac4 ac4Var, lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac4Var, lf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ac4Var;
        this.b = lf4Var;
    }

    public void a(zc4 zc4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, zc4Var, str, str2, str3) == null) {
            d(zc4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.od4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            ac4 ac4Var = this.a;
            if (ac4Var != null) {
                ac4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.od4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            ac4 ac4Var = this.a;
            if (ac4Var != null) {
                ac4Var.H(str, i);
            }
            if (i != 200) {
                zc4 zc4Var = new zc4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                zc4Var.f = i;
                ac4 ac4Var2 = this.a;
                if (ac4Var2 != null) {
                    ac4Var2.C(zc4Var);
                }
                a(zc4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            kd4 a = kd4.a(str);
            if (a == null) {
                JSONObject p = mh4.p(str);
                zc4 zc4Var2 = new zc4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                ac4 ac4Var3 = this.a;
                if (ac4Var3 != null) {
                    ac4Var3.C(zc4Var2);
                }
                a(zc4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                zc4 zc4Var3 = new zc4(d, a.e(), a.g(), i(a));
                ac4 ac4Var4 = this.a;
                if (ac4Var4 != null) {
                    ac4Var4.C(zc4Var3);
                }
                if (a.d() != 1010) {
                    d(zc4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                zc4 zc4Var4 = new zc4(2102, "response data empty");
                ac4 ac4Var5 = this.a;
                if (ac4Var5 != null) {
                    ac4Var5.C(zc4Var4);
                }
                d(zc4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                zc4 e = e(str, u);
                if (e != null) {
                    ac4 ac4Var6 = this.a;
                    if (ac4Var6 != null) {
                        ac4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(zc4 zc4Var, String str, String str2, String str3, @Nullable kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, zc4Var, str, str2, str3, kd4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (zc4Var != null) {
                try {
                    if (zc4Var.a != 0) {
                        i = zc4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && zc4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", qb4.b().c());
                        jSONObject.put("network", gk4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof hf4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((hf4) this.b).g());
            }
            if (kd4Var != null && kd4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, kd4Var.f());
            }
            ob4 b = qb4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            fh4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public zc4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new zc4(2103, str);
            }
            return null;
        }
        return (zc4) invokeLL.objValue;
    }

    public zc4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new zc4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new zc4(2101, Log.getStackTraceString(exc));
        }
        return (zc4) invokeLL.objValue;
    }

    public void l(ad4 ad4Var, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, ad4Var, nh4Var) != null) || ad4Var == null) {
            return;
        }
        nh4Var.a(ad4Var, PMSPkgStatus.WAIT);
    }

    public void m(cd4 cd4Var, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, cd4Var, nh4Var) != null) || cd4Var == null) {
            return;
        }
        nh4Var.a(cd4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<gd4> list, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, nh4Var) == null) && list != null && !list.isEmpty()) {
            for (gd4 gd4Var : list) {
                nh4Var.a(gd4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(ed4 ed4Var, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, ed4Var, nh4Var) != null) || ed4Var == null) {
            return;
        }
        nh4Var.a(ed4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<fd4> list, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, nh4Var) == null) && list != null && !list.isEmpty()) {
            for (fd4 fd4Var : list) {
                nh4Var.a(fd4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(gd4 gd4Var, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, gd4Var, nh4Var) != null) || gd4Var == null) {
            return;
        }
        nh4Var.a(gd4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<gd4> g(@Nullable List<gd4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (gd4 gd4Var : list) {
                    if (gd4Var != null && !arrayList.contains(gd4Var)) {
                        cc4 i = cc4.i();
                        String str = gd4Var.g;
                        long j = gd4Var.i;
                        if (!qb4.b().r(i.q(str, j, j))) {
                            arrayList.add(gd4Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public final String i(kd4 kd4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kd4Var)) == null) {
            if (kd4Var == null || kd4Var.c() == null || (optJSONObject = kd4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        zb4 p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) && pMSAppInfo != null && (p = this.a.p()) != null) {
            p.a(pMSAppInfo);
        }
    }

    public JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split("request fail : ");
                if (split.length <= 1) {
                    return null;
                }
                return new JSONObject(split[1]);
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.od4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            zc4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.od4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new zc4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
