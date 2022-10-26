package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.tieba.vc4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class sc4 implements vc4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hb4 a;
    public se4 b;
    public String c;

    public abstract boolean f(Object obj);

    public abstract String h();

    public boolean s(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, obj, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract gc4 t(Object obj);

    public abstract Object u(JSONObject jSONObject);

    public sc4(hb4 hb4Var, se4 se4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hb4Var, se4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hb4Var;
        this.b = se4Var;
    }

    public void a(gc4 gc4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, gc4Var, str, str2, str3) == null) {
            d(gc4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.vc4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            hb4 hb4Var = this.a;
            if (hb4Var != null) {
                hb4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.vc4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            hb4 hb4Var = this.a;
            if (hb4Var != null) {
                hb4Var.H(str, i);
            }
            if (i != 200) {
                gc4 gc4Var = new gc4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                gc4Var.f = i;
                hb4 hb4Var2 = this.a;
                if (hb4Var2 != null) {
                    hb4Var2.C(gc4Var);
                }
                a(gc4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            rc4 a = rc4.a(str);
            if (a == null) {
                JSONObject p = tg4.p(str);
                gc4 gc4Var2 = new gc4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                hb4 hb4Var3 = this.a;
                if (hb4Var3 != null) {
                    hb4Var3.C(gc4Var2);
                }
                a(gc4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            Object u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                gc4 gc4Var3 = new gc4(d, a.e(), a.g(), i(a));
                hb4 hb4Var4 = this.a;
                if (hb4Var4 != null) {
                    hb4Var4.C(gc4Var3);
                }
                if (a.d() != 1010) {
                    d(gc4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                gc4 gc4Var4 = new gc4(2102, "response data empty");
                hb4 hb4Var5 = this.a;
                if (hb4Var5 != null) {
                    hb4Var5.C(gc4Var4);
                }
                d(gc4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                gc4 e = e(str, u);
                if (e != null) {
                    hb4 hb4Var6 = this.a;
                    if (hb4Var6 != null) {
                        hb4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(gc4 gc4Var, String str, String str2, String str3, rc4 rc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, gc4Var, str, str2, str3, rc4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (gc4Var != null) {
                try {
                    if (gc4Var.a != 0) {
                        i = gc4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && gc4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", xa4.b().c());
                        jSONObject.put("network", nj4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof oe4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((oe4) this.b).g());
            }
            if (rc4Var != null && rc4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, rc4Var.f());
            }
            va4 b = xa4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            mg4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    public gc4 e(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, obj)) == null) {
            if (!f(obj)) {
                return new gc4(2103, str);
            }
            return null;
        }
        return (gc4) invokeLL.objValue;
    }

    public gc4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new gc4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new gc4(2101, Log.getStackTraceString(exc));
        }
        return (gc4) invokeLL.objValue;
    }

    public void l(hc4 hc4Var, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, hc4Var, ug4Var) != null) || hc4Var == null) {
            return;
        }
        ug4Var.a(hc4Var, PMSPkgStatus.WAIT);
    }

    public void m(jc4 jc4Var, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, jc4Var, ug4Var) != null) || jc4Var == null) {
            return;
        }
        ug4Var.a(jc4Var, PMSPkgStatus.WAIT);
    }

    public void n(List list, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, ug4Var) == null) && list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ug4Var.a((nc4) it.next(), PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(lc4 lc4Var, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, lc4Var, ug4Var) != null) || lc4Var == null) {
            return;
        }
        ug4Var.a(lc4Var, PMSPkgStatus.WAIT);
    }

    public void p(List list, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, ug4Var) == null) && list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ug4Var.a((mc4) it.next(), PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(nc4 nc4Var, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, nc4Var, ug4Var) != null) || nc4Var == null) {
            return;
        }
        ug4Var.a(nc4Var, PMSPkgStatus.WAIT);
    }

    public List g(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    nc4 nc4Var = (nc4) it.next();
                    if (nc4Var != null && !arrayList.contains(nc4Var)) {
                        jb4 i = jb4.i();
                        String str = nc4Var.g;
                        long j = nc4Var.i;
                        if (!xa4.b().r(i.q(str, j, j))) {
                            arrayList.add(nc4Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final String i(rc4 rc4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rc4Var)) == null) {
            if (rc4Var == null || rc4Var.c() == null || (optJSONObject = rc4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        gb4 p;
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

    @Override // com.baidu.tieba.vc4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            gc4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.vc4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new gc4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
