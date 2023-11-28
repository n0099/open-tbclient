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
import com.baidu.tieba.qf4;
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
public abstract class nf4<T> implements qf4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ce4 a;
    public nh4 b;
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

    public abstract bf4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public nf4(ce4 ce4Var, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ce4Var, nh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ce4Var;
        this.b = nh4Var;
    }

    public void a(bf4 bf4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, bf4Var, str, str2, str3) == null) {
            c(bf4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.qf4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            ce4 ce4Var = this.a;
            if (ce4Var != null) {
                ce4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(bf4 bf4Var, String str, String str2, String str3, @Nullable mf4 mf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bf4Var, str, str2, str3, mf4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (bf4Var != null) {
                try {
                    if (bf4Var.a != 0) {
                        i = bf4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && bf4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", sd4.b().c());
                        jSONObject.put("network", hm4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof jh4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((jh4) this.b).g());
            }
            if (mf4Var != null && mf4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, mf4Var.f());
            }
            qd4 b = sd4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            hj4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public bf4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new bf4(2103, str);
            }
            return null;
        }
        return (bf4) invokeLL.objValue;
    }

    public bf4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new bf4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new bf4(2101, Log.getStackTraceString(exc));
        }
        return (bf4) invokeLL.objValue;
    }

    public void k(cf4 cf4Var, pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, cf4Var, pj4Var) != null) || cf4Var == null) {
            return;
        }
        pj4Var.a(cf4Var, PMSPkgStatus.WAIT);
    }

    public void l(ef4 ef4Var, pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, ef4Var, pj4Var) != null) || ef4Var == null) {
            return;
        }
        pj4Var.a(ef4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<if4> list, pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, pj4Var) == null) && list != null && !list.isEmpty()) {
            for (if4 if4Var : list) {
                pj4Var.a(if4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(gf4 gf4Var, pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, gf4Var, pj4Var) != null) || gf4Var == null) {
            return;
        }
        pj4Var.a(gf4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<hf4> list, pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, pj4Var) == null) && list != null && !list.isEmpty()) {
            for (hf4 hf4Var : list) {
                pj4Var.a(hf4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(if4 if4Var, pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, if4Var, pj4Var) != null) || if4Var == null) {
            return;
        }
        pj4Var.a(if4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<if4> f(@Nullable List<if4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (if4 if4Var : list) {
                    if (if4Var != null && !arrayList.contains(if4Var)) {
                        ee4 i = ee4.i();
                        String str = if4Var.g;
                        long j = if4Var.i;
                        if (!sd4.b().r(i.q(str, j, j))) {
                            arrayList.add(if4Var);
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
    public final String h(mf4 mf4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mf4Var)) == null) {
            if (mf4Var == null || mf4Var.c() == null || (optJSONObject = mf4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        be4 p;
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

    @Override // com.baidu.tieba.qf4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            bf4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.qf4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new bf4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.qf4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            ce4 ce4Var = this.a;
            if (ce4Var != null) {
                ce4Var.H(str, i);
            }
            if (i != 200) {
                bf4 bf4Var = new bf4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                bf4Var.f = i;
                ce4 ce4Var2 = this.a;
                if (ce4Var2 != null) {
                    ce4Var2.C(bf4Var);
                }
                a(bf4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            mf4 a = mf4.a(str);
            if (a == null) {
                JSONObject p = oj4.p(str);
                bf4 bf4Var2 = new bf4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                ce4 ce4Var3 = this.a;
                if (ce4Var3 != null) {
                    ce4Var3.C(bf4Var2);
                }
                a(bf4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                bf4 bf4Var3 = new bf4(d, a.e(), a.g(), h(a));
                ce4 ce4Var4 = this.a;
                if (ce4Var4 != null) {
                    ce4Var4.C(bf4Var3);
                }
                if (a.d() != 1010) {
                    c(bf4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                bf4 bf4Var4 = new bf4(2102, "response data empty");
                ce4 ce4Var5 = this.a;
                if (ce4Var5 != null) {
                    ce4Var5.C(bf4Var4);
                }
                c(bf4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                bf4 d2 = d(str, t);
                if (d2 != null) {
                    ce4 ce4Var6 = this.a;
                    if (ce4Var6 != null) {
                        ce4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
