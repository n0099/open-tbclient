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
import com.baidu.tieba.uc4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class rc4<T> implements uc4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gb4 a;
    public re4 b;
    public String c;

    public rc4(gb4 gb4Var, re4 re4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gb4Var, re4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gb4Var;
        this.b = re4Var;
    }

    public void a(fc4 fc4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, fc4Var, str, str2, str3) == null) {
            d(fc4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.uc4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            gb4 gb4Var = this.a;
            if (gb4Var != null) {
                gb4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.uc4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            gb4 gb4Var = this.a;
            if (gb4Var != null) {
                gb4Var.H(str, i);
            }
            if (i != 200) {
                fc4 fc4Var = new fc4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                fc4Var.f = i;
                gb4 gb4Var2 = this.a;
                if (gb4Var2 != null) {
                    gb4Var2.C(fc4Var);
                }
                a(fc4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            qc4 a = qc4.a(str);
            if (a == null) {
                JSONObject p = sg4.p(str);
                fc4 fc4Var2 = new fc4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                gb4 gb4Var3 = this.a;
                if (gb4Var3 != null) {
                    gb4Var3.C(fc4Var2);
                }
                a(fc4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                fc4 fc4Var3 = new fc4(d, a.e(), a.g(), i(a));
                gb4 gb4Var4 = this.a;
                if (gb4Var4 != null) {
                    gb4Var4.C(fc4Var3);
                }
                if (a.d() != 1010) {
                    d(fc4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                fc4 fc4Var4 = new fc4(2102, "response data empty");
                gb4 gb4Var5 = this.a;
                if (gb4Var5 != null) {
                    gb4Var5.C(fc4Var4);
                }
                d(fc4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                fc4 e = e(str, u);
                if (e != null) {
                    gb4 gb4Var6 = this.a;
                    if (gb4Var6 != null) {
                        gb4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(fc4 fc4Var, String str, String str2, String str3, @Nullable qc4 qc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, fc4Var, str, str2, str3, qc4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (fc4Var != null) {
                try {
                    if (fc4Var.a != 0) {
                        i = fc4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && fc4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", wa4.b().c());
                        jSONObject.put("network", mj4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ne4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ne4) this.b).g());
            }
            if (qc4Var != null && qc4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, qc4Var.f());
            }
            ua4 b = wa4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            lg4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public fc4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new fc4(2103, str);
        }
        return (fc4) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<mc4> g(@Nullable List<mc4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (mc4 mc4Var : list) {
                if (mc4Var != null && !arrayList.contains(mc4Var)) {
                    ib4 i = ib4.i();
                    String str = mc4Var.g;
                    long j = mc4Var.i;
                    if (!wa4.b().r(i.q(str, j, j))) {
                        arrayList.add(mc4Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(qc4 qc4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qc4Var)) == null) {
            if (qc4Var == null || qc4Var.c() == null || (optJSONObject = qc4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public fc4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new fc4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new fc4(2101, Log.getStackTraceString(exc));
        }
        return (fc4) invokeLL.objValue;
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
                if (split.length > 1) {
                    return new JSONObject(split[1]);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void l(gc4 gc4Var, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, gc4Var, tg4Var) == null) || gc4Var == null) {
            return;
        }
        tg4Var.a(gc4Var, PMSPkgStatus.WAIT);
    }

    public void m(ic4 ic4Var, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, ic4Var, tg4Var) == null) || ic4Var == null) {
            return;
        }
        tg4Var.a(ic4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<mc4> list, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, tg4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (mc4 mc4Var : list) {
            tg4Var.a(mc4Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(kc4 kc4Var, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, kc4Var, tg4Var) == null) || kc4Var == null) {
            return;
        }
        tg4Var.a(kc4Var, PMSPkgStatus.WAIT);
    }

    @Override // com.baidu.tieba.uc4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            fc4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.uc4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new fc4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<lc4> list, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, tg4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (lc4 lc4Var : list) {
            tg4Var.a(lc4Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(mc4 mc4Var, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, mc4Var, tg4Var) == null) || mc4Var == null) {
            return;
        }
        tg4Var.a(mc4Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        fb4 p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null || (p = this.a.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public boolean s(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract fc4 t(T t);

    public abstract T u(JSONObject jSONObject);
}
