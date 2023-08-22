package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.tieba.mk4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class jk4<T> implements mk4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yi4 a;
    public jm4 b;
    public String c;

    public abstract boolean e(T t);

    public abstract String g();

    public boolean r(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract xj4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public jk4(yi4 yi4Var, jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi4Var, jm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yi4Var;
        this.b = jm4Var;
    }

    public void a(xj4 xj4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, xj4Var, str, str2, str3) == null) {
            c(xj4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.mk4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            yi4 yi4Var = this.a;
            if (yi4Var != null) {
                yi4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(xj4 xj4Var, String str, String str2, String str3, @Nullable ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, xj4Var, str, str2, str3, ik4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (xj4Var != null) {
                try {
                    if (xj4Var.a != 0) {
                        i = xj4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && xj4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", oi4.b().c());
                        jSONObject.put("network", er4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof fm4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((fm4) this.b).g());
            }
            if (ik4Var != null && ik4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, ik4Var.f());
            }
            mi4 b = oi4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            do4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public xj4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new xj4(2103, str);
            }
            return null;
        }
        return (xj4) invokeLL.objValue;
    }

    public xj4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new xj4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new xj4(2101, Log.getStackTraceString(exc));
        }
        return (xj4) invokeLL.objValue;
    }

    public void k(yj4 yj4Var, lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, yj4Var, lo4Var) != null) || yj4Var == null) {
            return;
        }
        lo4Var.a(yj4Var, PMSPkgStatus.WAIT);
    }

    public void l(ak4 ak4Var, lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, ak4Var, lo4Var) != null) || ak4Var == null) {
            return;
        }
        lo4Var.a(ak4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<ek4> list, lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, lo4Var) == null) && list != null && !list.isEmpty()) {
            for (ek4 ek4Var : list) {
                lo4Var.a(ek4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(ck4 ck4Var, lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, ck4Var, lo4Var) != null) || ck4Var == null) {
            return;
        }
        lo4Var.a(ck4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<dk4> list, lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, lo4Var) == null) && list != null && !list.isEmpty()) {
            for (dk4 dk4Var : list) {
                lo4Var.a(dk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(ek4 ek4Var, lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, ek4Var, lo4Var) != null) || ek4Var == null) {
            return;
        }
        lo4Var.a(ek4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<ek4> f(@Nullable List<ek4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (ek4 ek4Var : list) {
                    if (ek4Var != null && !arrayList.contains(ek4Var)) {
                        aj4 i = aj4.i();
                        String str = ek4Var.g;
                        long j = ek4Var.i;
                        if (!oi4.b().r(i.q(str, j, j))) {
                            arrayList.add(ek4Var);
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
    public final String h(ik4 ik4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ik4Var)) == null) {
            if (ik4Var == null || ik4Var.c() == null || (optJSONObject = ik4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        xi4 p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) && pMSAppInfo != null && (p = this.a.p()) != null) {
            p.a(pMSAppInfo);
        }
    }

    public JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
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

    @Override // com.baidu.tieba.mk4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            xj4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.mk4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new xj4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.mk4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            yi4 yi4Var = this.a;
            if (yi4Var != null) {
                yi4Var.H(str, i);
            }
            if (i != 200) {
                xj4 xj4Var = new xj4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                xj4Var.f = i;
                yi4 yi4Var2 = this.a;
                if (yi4Var2 != null) {
                    yi4Var2.C(xj4Var);
                }
                a(xj4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            ik4 a = ik4.a(str);
            if (a == null) {
                JSONObject p = ko4.p(str);
                xj4 xj4Var2 = new xj4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                yi4 yi4Var3 = this.a;
                if (yi4Var3 != null) {
                    yi4Var3.C(xj4Var2);
                }
                a(xj4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                xj4 xj4Var3 = new xj4(d, a.e(), a.g(), h(a));
                yi4 yi4Var4 = this.a;
                if (yi4Var4 != null) {
                    yi4Var4.C(xj4Var3);
                }
                if (a.d() != 1010) {
                    c(xj4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                xj4 xj4Var4 = new xj4(2102, "response data empty");
                yi4 yi4Var5 = this.a;
                if (yi4Var5 != null) {
                    yi4Var5.C(xj4Var4);
                }
                c(xj4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                xj4 d2 = d(str, t);
                if (d2 != null) {
                    yi4 yi4Var6 = this.a;
                    if (yi4Var6 != null) {
                        yi4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
