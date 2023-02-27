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
import com.baidu.tieba.vi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class si4<T> implements vi4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hh4 a;
    public sk4 b;
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

    public abstract gi4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public si4(hh4 hh4Var, sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hh4Var, sk4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hh4Var;
        this.b = sk4Var;
    }

    public void a(gi4 gi4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, gi4Var, str, str2, str3) == null) {
            d(gi4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.vi4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            hh4 hh4Var = this.a;
            if (hh4Var != null) {
                hh4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.vi4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            hh4 hh4Var = this.a;
            if (hh4Var != null) {
                hh4Var.H(str, i);
            }
            if (i != 200) {
                gi4 gi4Var = new gi4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                gi4Var.f = i;
                hh4 hh4Var2 = this.a;
                if (hh4Var2 != null) {
                    hh4Var2.C(gi4Var);
                }
                a(gi4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            ri4 a = ri4.a(str);
            if (a == null) {
                JSONObject p = tm4.p(str);
                gi4 gi4Var2 = new gi4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                hh4 hh4Var3 = this.a;
                if (hh4Var3 != null) {
                    hh4Var3.C(gi4Var2);
                }
                a(gi4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                gi4 gi4Var3 = new gi4(d, a.e(), a.g(), i(a));
                hh4 hh4Var4 = this.a;
                if (hh4Var4 != null) {
                    hh4Var4.C(gi4Var3);
                }
                if (a.d() != 1010) {
                    d(gi4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                gi4 gi4Var4 = new gi4(2102, "response data empty");
                hh4 hh4Var5 = this.a;
                if (hh4Var5 != null) {
                    hh4Var5.C(gi4Var4);
                }
                d(gi4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                gi4 e = e(str, u);
                if (e != null) {
                    hh4 hh4Var6 = this.a;
                    if (hh4Var6 != null) {
                        hh4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(gi4 gi4Var, String str, String str2, String str3, @Nullable ri4 ri4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, gi4Var, str, str2, str3, ri4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (gi4Var != null) {
                try {
                    if (gi4Var.a != 0) {
                        i = gi4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && gi4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", xg4.b().c());
                        jSONObject.put("network", np4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ok4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ok4) this.b).g());
            }
            if (ri4Var != null && ri4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, ri4Var.f());
            }
            vg4 b = xg4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            mm4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public gi4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new gi4(2103, str);
            }
            return null;
        }
        return (gi4) invokeLL.objValue;
    }

    public gi4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new gi4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new gi4(2101, Log.getStackTraceString(exc));
        }
        return (gi4) invokeLL.objValue;
    }

    public void l(hi4 hi4Var, um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, hi4Var, um4Var) != null) || hi4Var == null) {
            return;
        }
        um4Var.a(hi4Var, PMSPkgStatus.WAIT);
    }

    public void m(ji4 ji4Var, um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, ji4Var, um4Var) != null) || ji4Var == null) {
            return;
        }
        um4Var.a(ji4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<ni4> list, um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, um4Var) == null) && list != null && !list.isEmpty()) {
            for (ni4 ni4Var : list) {
                um4Var.a(ni4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(li4 li4Var, um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, li4Var, um4Var) != null) || li4Var == null) {
            return;
        }
        um4Var.a(li4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<mi4> list, um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, um4Var) == null) && list != null && !list.isEmpty()) {
            for (mi4 mi4Var : list) {
                um4Var.a(mi4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(ni4 ni4Var, um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, ni4Var, um4Var) != null) || ni4Var == null) {
            return;
        }
        um4Var.a(ni4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<ni4> g(@Nullable List<ni4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (ni4 ni4Var : list) {
                    if (ni4Var != null && !arrayList.contains(ni4Var)) {
                        jh4 i = jh4.i();
                        String str = ni4Var.g;
                        long j = ni4Var.i;
                        if (!xg4.b().r(i.q(str, j, j))) {
                            arrayList.add(ni4Var);
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
    public final String i(ri4 ri4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ri4Var)) == null) {
            if (ri4Var == null || ri4Var.c() == null || (optJSONObject = ri4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        gh4 p;
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

    @Override // com.baidu.tieba.vi4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            gi4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.vi4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new gi4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
