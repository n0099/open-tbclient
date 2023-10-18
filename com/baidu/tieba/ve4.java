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
import com.baidu.tieba.ye4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class ve4<T> implements ye4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kd4 a;
    public vg4 b;
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

    public abstract je4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public ve4(kd4 kd4Var, vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kd4Var, vg4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kd4Var;
        this.b = vg4Var;
    }

    public void a(je4 je4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, je4Var, str, str2, str3) == null) {
            c(je4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.ye4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            kd4 kd4Var = this.a;
            if (kd4Var != null) {
                kd4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(je4 je4Var, String str, String str2, String str3, @Nullable ue4 ue4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, je4Var, str, str2, str3, ue4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (je4Var != null) {
                try {
                    if (je4Var.a != 0) {
                        i = je4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && je4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", ad4.b().c());
                        jSONObject.put("network", pl4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof rg4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((rg4) this.b).g());
            }
            if (ue4Var != null && ue4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, ue4Var.f());
            }
            yc4 b = ad4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            pi4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public je4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new je4(2103, str);
            }
            return null;
        }
        return (je4) invokeLL.objValue;
    }

    public je4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new je4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new je4(2101, Log.getStackTraceString(exc));
        }
        return (je4) invokeLL.objValue;
    }

    public void k(ke4 ke4Var, xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, ke4Var, xi4Var) != null) || ke4Var == null) {
            return;
        }
        xi4Var.a(ke4Var, PMSPkgStatus.WAIT);
    }

    public void l(me4 me4Var, xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, me4Var, xi4Var) != null) || me4Var == null) {
            return;
        }
        xi4Var.a(me4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<qe4> list, xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, xi4Var) == null) && list != null && !list.isEmpty()) {
            for (qe4 qe4Var : list) {
                xi4Var.a(qe4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(oe4 oe4Var, xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, oe4Var, xi4Var) != null) || oe4Var == null) {
            return;
        }
        xi4Var.a(oe4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<pe4> list, xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, xi4Var) == null) && list != null && !list.isEmpty()) {
            for (pe4 pe4Var : list) {
                xi4Var.a(pe4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(qe4 qe4Var, xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, qe4Var, xi4Var) != null) || qe4Var == null) {
            return;
        }
        xi4Var.a(qe4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<qe4> f(@Nullable List<qe4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (qe4 qe4Var : list) {
                    if (qe4Var != null && !arrayList.contains(qe4Var)) {
                        md4 i = md4.i();
                        String str = qe4Var.g;
                        long j = qe4Var.i;
                        if (!ad4.b().r(i.q(str, j, j))) {
                            arrayList.add(qe4Var);
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
    public final String h(ue4 ue4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ue4Var)) == null) {
            if (ue4Var == null || ue4Var.c() == null || (optJSONObject = ue4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        jd4 p;
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

    @Override // com.baidu.tieba.ye4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            je4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.ye4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new je4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.ye4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            kd4 kd4Var = this.a;
            if (kd4Var != null) {
                kd4Var.H(str, i);
            }
            if (i != 200) {
                je4 je4Var = new je4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                je4Var.f = i;
                kd4 kd4Var2 = this.a;
                if (kd4Var2 != null) {
                    kd4Var2.C(je4Var);
                }
                a(je4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            ue4 a = ue4.a(str);
            if (a == null) {
                JSONObject p = wi4.p(str);
                je4 je4Var2 = new je4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                kd4 kd4Var3 = this.a;
                if (kd4Var3 != null) {
                    kd4Var3.C(je4Var2);
                }
                a(je4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                je4 je4Var3 = new je4(d, a.e(), a.g(), h(a));
                kd4 kd4Var4 = this.a;
                if (kd4Var4 != null) {
                    kd4Var4.C(je4Var3);
                }
                if (a.d() != 1010) {
                    c(je4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                je4 je4Var4 = new je4(2102, "response data empty");
                kd4 kd4Var5 = this.a;
                if (kd4Var5 != null) {
                    kd4Var5.C(je4Var4);
                }
                c(je4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                je4 d2 = d(str, t);
                if (d2 != null) {
                    kd4 kd4Var6 = this.a;
                    if (kd4Var6 != null) {
                        kd4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
