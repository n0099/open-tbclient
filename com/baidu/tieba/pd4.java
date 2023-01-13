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
import com.baidu.tieba.sd4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class pd4<T> implements sd4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ec4 a;
    public pf4 b;
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

    public abstract dd4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public pd4(ec4 ec4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec4Var, pf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ec4Var;
        this.b = pf4Var;
    }

    public void a(dd4 dd4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dd4Var, str, str2, str3) == null) {
            d(dd4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.sd4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            ec4 ec4Var = this.a;
            if (ec4Var != null) {
                ec4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.sd4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            ec4 ec4Var = this.a;
            if (ec4Var != null) {
                ec4Var.H(str, i);
            }
            if (i != 200) {
                dd4 dd4Var = new dd4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                dd4Var.f = i;
                ec4 ec4Var2 = this.a;
                if (ec4Var2 != null) {
                    ec4Var2.C(dd4Var);
                }
                a(dd4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            od4 a = od4.a(str);
            if (a == null) {
                JSONObject p = qh4.p(str);
                dd4 dd4Var2 = new dd4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                ec4 ec4Var3 = this.a;
                if (ec4Var3 != null) {
                    ec4Var3.C(dd4Var2);
                }
                a(dd4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                dd4 dd4Var3 = new dd4(d, a.e(), a.g(), i(a));
                ec4 ec4Var4 = this.a;
                if (ec4Var4 != null) {
                    ec4Var4.C(dd4Var3);
                }
                if (a.d() != 1010) {
                    d(dd4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                dd4 dd4Var4 = new dd4(2102, "response data empty");
                ec4 ec4Var5 = this.a;
                if (ec4Var5 != null) {
                    ec4Var5.C(dd4Var4);
                }
                d(dd4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                dd4 e = e(str, u);
                if (e != null) {
                    ec4 ec4Var6 = this.a;
                    if (ec4Var6 != null) {
                        ec4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(dd4 dd4Var, String str, String str2, String str3, @Nullable od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, dd4Var, str, str2, str3, od4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (dd4Var != null) {
                try {
                    if (dd4Var.a != 0) {
                        i = dd4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && dd4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", ub4.b().c());
                        jSONObject.put("network", kk4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof lf4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((lf4) this.b).g());
            }
            if (od4Var != null && od4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, od4Var.f());
            }
            sb4 b = ub4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            jh4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public dd4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new dd4(2103, str);
            }
            return null;
        }
        return (dd4) invokeLL.objValue;
    }

    public dd4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new dd4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new dd4(2101, Log.getStackTraceString(exc));
        }
        return (dd4) invokeLL.objValue;
    }

    public void l(ed4 ed4Var, rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, ed4Var, rh4Var) != null) || ed4Var == null) {
            return;
        }
        rh4Var.a(ed4Var, PMSPkgStatus.WAIT);
    }

    public void m(gd4 gd4Var, rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, gd4Var, rh4Var) != null) || gd4Var == null) {
            return;
        }
        rh4Var.a(gd4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<kd4> list, rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, rh4Var) == null) && list != null && !list.isEmpty()) {
            for (kd4 kd4Var : list) {
                rh4Var.a(kd4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(id4 id4Var, rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, id4Var, rh4Var) != null) || id4Var == null) {
            return;
        }
        rh4Var.a(id4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<jd4> list, rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, rh4Var) == null) && list != null && !list.isEmpty()) {
            for (jd4 jd4Var : list) {
                rh4Var.a(jd4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(kd4 kd4Var, rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, kd4Var, rh4Var) != null) || kd4Var == null) {
            return;
        }
        rh4Var.a(kd4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<kd4> g(@Nullable List<kd4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (kd4 kd4Var : list) {
                    if (kd4Var != null && !arrayList.contains(kd4Var)) {
                        gc4 i = gc4.i();
                        String str = kd4Var.g;
                        long j = kd4Var.i;
                        if (!ub4.b().r(i.q(str, j, j))) {
                            arrayList.add(kd4Var);
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
    public final String i(od4 od4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, od4Var)) == null) {
            if (od4Var == null || od4Var.c() == null || (optJSONObject = od4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        dc4 p;
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

    @Override // com.baidu.tieba.sd4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            dd4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.sd4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new dd4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
