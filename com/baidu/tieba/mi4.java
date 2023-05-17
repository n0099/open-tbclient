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
import com.baidu.tieba.pi4;
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
public abstract class mi4<T> implements pi4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bh4 a;
    public mk4 b;
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

    public abstract ai4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public mi4(bh4 bh4Var, mk4 mk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bh4Var, mk4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bh4Var;
        this.b = mk4Var;
    }

    public void a(ai4 ai4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, ai4Var, str, str2, str3) == null) {
            c(ai4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.pi4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            bh4 bh4Var = this.a;
            if (bh4Var != null) {
                bh4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(ai4 ai4Var, String str, String str2, String str3, @Nullable li4 li4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, ai4Var, str, str2, str3, li4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (ai4Var != null) {
                try {
                    if (ai4Var.a != 0) {
                        i = ai4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && ai4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", rg4.b().c());
                        jSONObject.put("network", hp4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ik4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ik4) this.b).g());
            }
            if (li4Var != null && li4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, li4Var.f());
            }
            pg4 b = rg4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            gm4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public ai4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new ai4(2103, str);
            }
            return null;
        }
        return (ai4) invokeLL.objValue;
    }

    public ai4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new ai4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new ai4(2101, Log.getStackTraceString(exc));
        }
        return (ai4) invokeLL.objValue;
    }

    public void k(bi4 bi4Var, om4 om4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, bi4Var, om4Var) != null) || bi4Var == null) {
            return;
        }
        om4Var.a(bi4Var, PMSPkgStatus.WAIT);
    }

    public void l(di4 di4Var, om4 om4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, di4Var, om4Var) != null) || di4Var == null) {
            return;
        }
        om4Var.a(di4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<hi4> list, om4 om4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, om4Var) == null) && list != null && !list.isEmpty()) {
            for (hi4 hi4Var : list) {
                om4Var.a(hi4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(fi4 fi4Var, om4 om4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, fi4Var, om4Var) != null) || fi4Var == null) {
            return;
        }
        om4Var.a(fi4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<gi4> list, om4 om4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, om4Var) == null) && list != null && !list.isEmpty()) {
            for (gi4 gi4Var : list) {
                om4Var.a(gi4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(hi4 hi4Var, om4 om4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, hi4Var, om4Var) != null) || hi4Var == null) {
            return;
        }
        om4Var.a(hi4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<hi4> f(@Nullable List<hi4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (hi4 hi4Var : list) {
                    if (hi4Var != null && !arrayList.contains(hi4Var)) {
                        dh4 i = dh4.i();
                        String str = hi4Var.g;
                        long j = hi4Var.i;
                        if (!rg4.b().r(i.q(str, j, j))) {
                            arrayList.add(hi4Var);
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
    public final String h(li4 li4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, li4Var)) == null) {
            if (li4Var == null || li4Var.c() == null || (optJSONObject = li4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        ah4 p;
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

    @Override // com.baidu.tieba.pi4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            ai4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.pi4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new ai4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.pi4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            bh4 bh4Var = this.a;
            if (bh4Var != null) {
                bh4Var.H(str, i);
            }
            if (i != 200) {
                ai4 ai4Var = new ai4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                ai4Var.f = i;
                bh4 bh4Var2 = this.a;
                if (bh4Var2 != null) {
                    bh4Var2.C(ai4Var);
                }
                a(ai4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            li4 a = li4.a(str);
            if (a == null) {
                JSONObject p = nm4.p(str);
                ai4 ai4Var2 = new ai4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                bh4 bh4Var3 = this.a;
                if (bh4Var3 != null) {
                    bh4Var3.C(ai4Var2);
                }
                a(ai4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                ai4 ai4Var3 = new ai4(d, a.e(), a.g(), h(a));
                bh4 bh4Var4 = this.a;
                if (bh4Var4 != null) {
                    bh4Var4.C(ai4Var3);
                }
                if (a.d() != 1010) {
                    c(ai4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                ai4 ai4Var4 = new ai4(2102, "response data empty");
                bh4 bh4Var5 = this.a;
                if (bh4Var5 != null) {
                    bh4Var5.C(ai4Var4);
                }
                c(ai4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                ai4 d2 = d(str, t);
                if (d2 != null) {
                    bh4 bh4Var6 = this.a;
                    if (bh4Var6 != null) {
                        bh4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
