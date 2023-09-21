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
import com.baidu.tieba.pk4;
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
public abstract class mk4<T> implements pk4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bj4 a;
    public mm4 b;
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

    public abstract ak4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public mk4(bj4 bj4Var, mm4 mm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bj4Var, mm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bj4Var;
        this.b = mm4Var;
    }

    public void a(ak4 ak4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, ak4Var, str, str2, str3) == null) {
            c(ak4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.pk4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            bj4 bj4Var = this.a;
            if (bj4Var != null) {
                bj4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(ak4 ak4Var, String str, String str2, String str3, @Nullable lk4 lk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, ak4Var, str, str2, str3, lk4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (ak4Var != null) {
                try {
                    if (ak4Var.a != 0) {
                        i = ak4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && ak4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", ri4.b().c());
                        jSONObject.put("network", hr4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof im4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((im4) this.b).g());
            }
            if (lk4Var != null && lk4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, lk4Var.f());
            }
            pi4 b = ri4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            go4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public ak4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new ak4(2103, str);
            }
            return null;
        }
        return (ak4) invokeLL.objValue;
    }

    public ak4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new ak4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new ak4(2101, Log.getStackTraceString(exc));
        }
        return (ak4) invokeLL.objValue;
    }

    public void k(bk4 bk4Var, oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, bk4Var, oo4Var) != null) || bk4Var == null) {
            return;
        }
        oo4Var.a(bk4Var, PMSPkgStatus.WAIT);
    }

    public void l(dk4 dk4Var, oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, dk4Var, oo4Var) != null) || dk4Var == null) {
            return;
        }
        oo4Var.a(dk4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<hk4> list, oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, oo4Var) == null) && list != null && !list.isEmpty()) {
            for (hk4 hk4Var : list) {
                oo4Var.a(hk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(fk4 fk4Var, oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, fk4Var, oo4Var) != null) || fk4Var == null) {
            return;
        }
        oo4Var.a(fk4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<gk4> list, oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, oo4Var) == null) && list != null && !list.isEmpty()) {
            for (gk4 gk4Var : list) {
                oo4Var.a(gk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(hk4 hk4Var, oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, hk4Var, oo4Var) != null) || hk4Var == null) {
            return;
        }
        oo4Var.a(hk4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<hk4> f(@Nullable List<hk4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (hk4 hk4Var : list) {
                    if (hk4Var != null && !arrayList.contains(hk4Var)) {
                        dj4 i = dj4.i();
                        String str = hk4Var.g;
                        long j = hk4Var.i;
                        if (!ri4.b().r(i.q(str, j, j))) {
                            arrayList.add(hk4Var);
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
    public final String h(lk4 lk4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lk4Var)) == null) {
            if (lk4Var == null || lk4Var.c() == null || (optJSONObject = lk4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        aj4 p;
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

    @Override // com.baidu.tieba.pk4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            ak4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.pk4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new ak4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.pk4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            bj4 bj4Var = this.a;
            if (bj4Var != null) {
                bj4Var.H(str, i);
            }
            if (i != 200) {
                ak4 ak4Var = new ak4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                ak4Var.f = i;
                bj4 bj4Var2 = this.a;
                if (bj4Var2 != null) {
                    bj4Var2.C(ak4Var);
                }
                a(ak4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            lk4 a = lk4.a(str);
            if (a == null) {
                JSONObject p = no4.p(str);
                ak4 ak4Var2 = new ak4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                bj4 bj4Var3 = this.a;
                if (bj4Var3 != null) {
                    bj4Var3.C(ak4Var2);
                }
                a(ak4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                ak4 ak4Var3 = new ak4(d, a.e(), a.g(), h(a));
                bj4 bj4Var4 = this.a;
                if (bj4Var4 != null) {
                    bj4Var4.C(ak4Var3);
                }
                if (a.d() != 1010) {
                    c(ak4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                ak4 ak4Var4 = new ak4(2102, "response data empty");
                bj4 bj4Var5 = this.a;
                if (bj4Var5 != null) {
                    bj4Var5.C(ak4Var4);
                }
                c(ak4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                ak4 d2 = d(str, t);
                if (d2 != null) {
                    bj4 bj4Var6 = this.a;
                    if (bj4Var6 != null) {
                        bj4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
