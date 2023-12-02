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
import com.baidu.tieba.tf4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class qf4<T> implements tf4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fe4 a;
    public qh4 b;
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

    public abstract ef4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public qf4(fe4 fe4Var, qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fe4Var, qh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fe4Var;
        this.b = qh4Var;
    }

    public void a(ef4 ef4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, ef4Var, str, str2, str3) == null) {
            c(ef4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.tf4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            fe4 fe4Var = this.a;
            if (fe4Var != null) {
                fe4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(ef4 ef4Var, String str, String str2, String str3, @Nullable pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, ef4Var, str, str2, str3, pf4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (ef4Var != null) {
                try {
                    if (ef4Var.a != 0) {
                        i = ef4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && ef4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", vd4.b().c());
                        jSONObject.put("network", km4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof mh4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((mh4) this.b).g());
            }
            if (pf4Var != null && pf4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, pf4Var.f());
            }
            td4 b = vd4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            kj4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public ef4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new ef4(2103, str);
            }
            return null;
        }
        return (ef4) invokeLL.objValue;
    }

    public ef4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new ef4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new ef4(2101, Log.getStackTraceString(exc));
        }
        return (ef4) invokeLL.objValue;
    }

    public void k(ff4 ff4Var, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, ff4Var, sj4Var) != null) || ff4Var == null) {
            return;
        }
        sj4Var.a(ff4Var, PMSPkgStatus.WAIT);
    }

    public void l(hf4 hf4Var, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, hf4Var, sj4Var) != null) || hf4Var == null) {
            return;
        }
        sj4Var.a(hf4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<lf4> list, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, sj4Var) == null) && list != null && !list.isEmpty()) {
            for (lf4 lf4Var : list) {
                sj4Var.a(lf4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(jf4 jf4Var, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, jf4Var, sj4Var) != null) || jf4Var == null) {
            return;
        }
        sj4Var.a(jf4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<kf4> list, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, sj4Var) == null) && list != null && !list.isEmpty()) {
            for (kf4 kf4Var : list) {
                sj4Var.a(kf4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(lf4 lf4Var, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, lf4Var, sj4Var) != null) || lf4Var == null) {
            return;
        }
        sj4Var.a(lf4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<lf4> f(@Nullable List<lf4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (lf4 lf4Var : list) {
                    if (lf4Var != null && !arrayList.contains(lf4Var)) {
                        he4 i = he4.i();
                        String str = lf4Var.g;
                        long j = lf4Var.i;
                        if (!vd4.b().r(i.q(str, j, j))) {
                            arrayList.add(lf4Var);
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
    public final String h(pf4 pf4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pf4Var)) == null) {
            if (pf4Var == null || pf4Var.c() == null || (optJSONObject = pf4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        ee4 p;
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

    @Override // com.baidu.tieba.tf4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            ef4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.tf4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new ef4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.tf4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            fe4 fe4Var = this.a;
            if (fe4Var != null) {
                fe4Var.H(str, i);
            }
            if (i != 200) {
                ef4 ef4Var = new ef4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                ef4Var.f = i;
                fe4 fe4Var2 = this.a;
                if (fe4Var2 != null) {
                    fe4Var2.C(ef4Var);
                }
                a(ef4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            pf4 a = pf4.a(str);
            if (a == null) {
                JSONObject p = rj4.p(str);
                ef4 ef4Var2 = new ef4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                fe4 fe4Var3 = this.a;
                if (fe4Var3 != null) {
                    fe4Var3.C(ef4Var2);
                }
                a(ef4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                ef4 ef4Var3 = new ef4(d, a.e(), a.g(), h(a));
                fe4 fe4Var4 = this.a;
                if (fe4Var4 != null) {
                    fe4Var4.C(ef4Var3);
                }
                if (a.d() != 1010) {
                    c(ef4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                ef4 ef4Var4 = new ef4(2102, "response data empty");
                fe4 fe4Var5 = this.a;
                if (fe4Var5 != null) {
                    fe4Var5.C(ef4Var4);
                }
                c(ef4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                ef4 d2 = d(str, t);
                if (d2 != null) {
                    fe4 fe4Var6 = this.a;
                    if (fe4Var6 != null) {
                        fe4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
