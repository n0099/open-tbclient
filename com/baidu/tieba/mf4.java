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
import com.baidu.tieba.pf4;
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
public abstract class mf4<T> implements pf4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public be4 a;
    public mh4 b;
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

    public abstract af4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public mf4(be4 be4Var, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {be4Var, mh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = be4Var;
        this.b = mh4Var;
    }

    public void a(af4 af4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, af4Var, str, str2, str3) == null) {
            c(af4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.pf4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            be4 be4Var = this.a;
            if (be4Var != null) {
                be4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(af4 af4Var, String str, String str2, String str3, @Nullable lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, af4Var, str, str2, str3, lf4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (af4Var != null) {
                try {
                    if (af4Var.a != 0) {
                        i = af4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && af4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", rd4.b().c());
                        jSONObject.put("network", gm4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ih4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ih4) this.b).g());
            }
            if (lf4Var != null && lf4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, lf4Var.f());
            }
            pd4 b = rd4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            gj4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public af4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new af4(2103, str);
            }
            return null;
        }
        return (af4) invokeLL.objValue;
    }

    public af4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new af4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new af4(2101, Log.getStackTraceString(exc));
        }
        return (af4) invokeLL.objValue;
    }

    public void k(bf4 bf4Var, oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, bf4Var, oj4Var) != null) || bf4Var == null) {
            return;
        }
        oj4Var.a(bf4Var, PMSPkgStatus.WAIT);
    }

    public void l(df4 df4Var, oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, df4Var, oj4Var) != null) || df4Var == null) {
            return;
        }
        oj4Var.a(df4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<hf4> list, oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, oj4Var) == null) && list != null && !list.isEmpty()) {
            for (hf4 hf4Var : list) {
                oj4Var.a(hf4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(ff4 ff4Var, oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, ff4Var, oj4Var) != null) || ff4Var == null) {
            return;
        }
        oj4Var.a(ff4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<gf4> list, oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, oj4Var) == null) && list != null && !list.isEmpty()) {
            for (gf4 gf4Var : list) {
                oj4Var.a(gf4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(hf4 hf4Var, oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, hf4Var, oj4Var) != null) || hf4Var == null) {
            return;
        }
        oj4Var.a(hf4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<hf4> f(@Nullable List<hf4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (hf4 hf4Var : list) {
                    if (hf4Var != null && !arrayList.contains(hf4Var)) {
                        de4 i = de4.i();
                        String str = hf4Var.g;
                        long j = hf4Var.i;
                        if (!rd4.b().r(i.q(str, j, j))) {
                            arrayList.add(hf4Var);
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
    public final String h(lf4 lf4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lf4Var)) == null) {
            if (lf4Var == null || lf4Var.c() == null || (optJSONObject = lf4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        ae4 p;
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

    @Override // com.baidu.tieba.pf4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            af4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.pf4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new af4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.pf4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            be4 be4Var = this.a;
            if (be4Var != null) {
                be4Var.H(str, i);
            }
            if (i != 200) {
                af4 af4Var = new af4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                af4Var.f = i;
                be4 be4Var2 = this.a;
                if (be4Var2 != null) {
                    be4Var2.C(af4Var);
                }
                a(af4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            lf4 a = lf4.a(str);
            if (a == null) {
                JSONObject p = nj4.p(str);
                af4 af4Var2 = new af4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                be4 be4Var3 = this.a;
                if (be4Var3 != null) {
                    be4Var3.C(af4Var2);
                }
                a(af4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                af4 af4Var3 = new af4(d, a.e(), a.g(), h(a));
                be4 be4Var4 = this.a;
                if (be4Var4 != null) {
                    be4Var4.C(af4Var3);
                }
                if (a.d() != 1010) {
                    c(af4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                af4 af4Var4 = new af4(2102, "response data empty");
                be4 be4Var5 = this.a;
                if (be4Var5 != null) {
                    be4Var5.C(af4Var4);
                }
                c(af4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                af4 d2 = d(str, t);
                if (d2 != null) {
                    be4 be4Var6 = this.a;
                    if (be4Var6 != null) {
                        be4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
