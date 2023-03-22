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
import com.baidu.tieba.ch4;
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
/* loaded from: classes7.dex */
public abstract class zg4<T> implements ch4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public of4 a;
    public zi4 b;
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

    public abstract ng4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public zg4(of4 of4Var, zi4 zi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {of4Var, zi4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = of4Var;
        this.b = zi4Var;
    }

    public void a(ng4 ng4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, ng4Var, str, str2, str3) == null) {
            d(ng4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.ch4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            of4 of4Var = this.a;
            if (of4Var != null) {
                of4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.ch4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            of4 of4Var = this.a;
            if (of4Var != null) {
                of4Var.H(str, i);
            }
            if (i != 200) {
                ng4 ng4Var = new ng4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                ng4Var.f = i;
                of4 of4Var2 = this.a;
                if (of4Var2 != null) {
                    of4Var2.C(ng4Var);
                }
                a(ng4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            yg4 a = yg4.a(str);
            if (a == null) {
                JSONObject p = al4.p(str);
                ng4 ng4Var2 = new ng4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                of4 of4Var3 = this.a;
                if (of4Var3 != null) {
                    of4Var3.C(ng4Var2);
                }
                a(ng4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                ng4 ng4Var3 = new ng4(d, a.e(), a.g(), i(a));
                of4 of4Var4 = this.a;
                if (of4Var4 != null) {
                    of4Var4.C(ng4Var3);
                }
                if (a.d() != 1010) {
                    d(ng4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                ng4 ng4Var4 = new ng4(2102, "response data empty");
                of4 of4Var5 = this.a;
                if (of4Var5 != null) {
                    of4Var5.C(ng4Var4);
                }
                d(ng4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                ng4 e = e(str, u);
                if (e != null) {
                    of4 of4Var6 = this.a;
                    if (of4Var6 != null) {
                        of4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(ng4 ng4Var, String str, String str2, String str3, @Nullable yg4 yg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, ng4Var, str, str2, str3, yg4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (ng4Var != null) {
                try {
                    if (ng4Var.a != 0) {
                        i = ng4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && ng4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", ef4.b().c());
                        jSONObject.put("network", un4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof vi4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((vi4) this.b).g());
            }
            if (yg4Var != null && yg4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, yg4Var.f());
            }
            cf4 b = ef4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            tk4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public ng4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new ng4(2103, str);
            }
            return null;
        }
        return (ng4) invokeLL.objValue;
    }

    public ng4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new ng4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new ng4(2101, Log.getStackTraceString(exc));
        }
        return (ng4) invokeLL.objValue;
    }

    public void l(og4 og4Var, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, og4Var, bl4Var) != null) || og4Var == null) {
            return;
        }
        bl4Var.a(og4Var, PMSPkgStatus.WAIT);
    }

    public void m(qg4 qg4Var, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, qg4Var, bl4Var) != null) || qg4Var == null) {
            return;
        }
        bl4Var.a(qg4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<ug4> list, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, bl4Var) == null) && list != null && !list.isEmpty()) {
            for (ug4 ug4Var : list) {
                bl4Var.a(ug4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(sg4 sg4Var, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, sg4Var, bl4Var) != null) || sg4Var == null) {
            return;
        }
        bl4Var.a(sg4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<tg4> list, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, bl4Var) == null) && list != null && !list.isEmpty()) {
            for (tg4 tg4Var : list) {
                bl4Var.a(tg4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(ug4 ug4Var, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, ug4Var, bl4Var) != null) || ug4Var == null) {
            return;
        }
        bl4Var.a(ug4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<ug4> g(@Nullable List<ug4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (ug4 ug4Var : list) {
                    if (ug4Var != null && !arrayList.contains(ug4Var)) {
                        qf4 i = qf4.i();
                        String str = ug4Var.g;
                        long j = ug4Var.i;
                        if (!ef4.b().r(i.q(str, j, j))) {
                            arrayList.add(ug4Var);
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
    public final String i(yg4 yg4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yg4Var)) == null) {
            if (yg4Var == null || yg4Var.c() == null || (optJSONObject = yg4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        nf4 p;
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

    @Override // com.baidu.tieba.ch4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            ng4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.ch4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new ng4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
