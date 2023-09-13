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
import com.baidu.tieba.qk4;
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
public abstract class nk4<T> implements qk4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cj4 a;
    public nm4 b;
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

    public abstract bk4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public nk4(cj4 cj4Var, nm4 nm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cj4Var, nm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cj4Var;
        this.b = nm4Var;
    }

    public void a(bk4 bk4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, bk4Var, str, str2, str3) == null) {
            c(bk4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.qk4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            cj4 cj4Var = this.a;
            if (cj4Var != null) {
                cj4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(bk4 bk4Var, String str, String str2, String str3, @Nullable mk4 mk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bk4Var, str, str2, str3, mk4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (bk4Var != null) {
                try {
                    if (bk4Var.a != 0) {
                        i = bk4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && bk4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", si4.b().c());
                        jSONObject.put("network", ir4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof jm4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((jm4) this.b).g());
            }
            if (mk4Var != null && mk4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, mk4Var.f());
            }
            qi4 b = si4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            ho4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public bk4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new bk4(2103, str);
            }
            return null;
        }
        return (bk4) invokeLL.objValue;
    }

    public bk4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new bk4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new bk4(2101, Log.getStackTraceString(exc));
        }
        return (bk4) invokeLL.objValue;
    }

    public void k(ck4 ck4Var, po4 po4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, ck4Var, po4Var) != null) || ck4Var == null) {
            return;
        }
        po4Var.a(ck4Var, PMSPkgStatus.WAIT);
    }

    public void l(ek4 ek4Var, po4 po4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, ek4Var, po4Var) != null) || ek4Var == null) {
            return;
        }
        po4Var.a(ek4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<ik4> list, po4 po4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, po4Var) == null) && list != null && !list.isEmpty()) {
            for (ik4 ik4Var : list) {
                po4Var.a(ik4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(gk4 gk4Var, po4 po4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, gk4Var, po4Var) != null) || gk4Var == null) {
            return;
        }
        po4Var.a(gk4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<hk4> list, po4 po4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, po4Var) == null) && list != null && !list.isEmpty()) {
            for (hk4 hk4Var : list) {
                po4Var.a(hk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(ik4 ik4Var, po4 po4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, ik4Var, po4Var) != null) || ik4Var == null) {
            return;
        }
        po4Var.a(ik4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<ik4> f(@Nullable List<ik4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (ik4 ik4Var : list) {
                    if (ik4Var != null && !arrayList.contains(ik4Var)) {
                        ej4 i = ej4.i();
                        String str = ik4Var.g;
                        long j = ik4Var.i;
                        if (!si4.b().r(i.q(str, j, j))) {
                            arrayList.add(ik4Var);
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
    public final String h(mk4 mk4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mk4Var)) == null) {
            if (mk4Var == null || mk4Var.c() == null || (optJSONObject = mk4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        bj4 p;
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

    @Override // com.baidu.tieba.qk4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            bk4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.qk4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new bk4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.qk4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            cj4 cj4Var = this.a;
            if (cj4Var != null) {
                cj4Var.H(str, i);
            }
            if (i != 200) {
                bk4 bk4Var = new bk4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                bk4Var.f = i;
                cj4 cj4Var2 = this.a;
                if (cj4Var2 != null) {
                    cj4Var2.C(bk4Var);
                }
                a(bk4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            mk4 a = mk4.a(str);
            if (a == null) {
                JSONObject p = oo4.p(str);
                bk4 bk4Var2 = new bk4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                cj4 cj4Var3 = this.a;
                if (cj4Var3 != null) {
                    cj4Var3.C(bk4Var2);
                }
                a(bk4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                bk4 bk4Var3 = new bk4(d, a.e(), a.g(), h(a));
                cj4 cj4Var4 = this.a;
                if (cj4Var4 != null) {
                    cj4Var4.C(bk4Var3);
                }
                if (a.d() != 1010) {
                    c(bk4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                bk4 bk4Var4 = new bk4(2102, "response data empty");
                cj4 cj4Var5 = this.a;
                if (cj4Var5 != null) {
                    cj4Var5.C(bk4Var4);
                }
                c(bk4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                bk4 d2 = d(str, t);
                if (d2 != null) {
                    cj4 cj4Var6 = this.a;
                    if (cj4Var6 != null) {
                        cj4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
