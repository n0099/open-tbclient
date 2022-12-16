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
import com.baidu.tieba.nd4;
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
public abstract class kd4<T> implements nd4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zb4 a;
    public kf4 b;
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

    public abstract yc4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public kd4(zb4 zb4Var, kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zb4Var, kf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zb4Var;
        this.b = kf4Var;
    }

    public void a(yc4 yc4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, yc4Var, str, str2, str3) == null) {
            d(yc4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.nd4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            zb4 zb4Var = this.a;
            if (zb4Var != null) {
                zb4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.nd4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            zb4 zb4Var = this.a;
            if (zb4Var != null) {
                zb4Var.H(str, i);
            }
            if (i != 200) {
                yc4 yc4Var = new yc4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                yc4Var.f = i;
                zb4 zb4Var2 = this.a;
                if (zb4Var2 != null) {
                    zb4Var2.C(yc4Var);
                }
                a(yc4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            jd4 a = jd4.a(str);
            if (a == null) {
                JSONObject p = lh4.p(str);
                yc4 yc4Var2 = new yc4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                zb4 zb4Var3 = this.a;
                if (zb4Var3 != null) {
                    zb4Var3.C(yc4Var2);
                }
                a(yc4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                yc4 yc4Var3 = new yc4(d, a.e(), a.g(), i(a));
                zb4 zb4Var4 = this.a;
                if (zb4Var4 != null) {
                    zb4Var4.C(yc4Var3);
                }
                if (a.d() != 1010) {
                    d(yc4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                yc4 yc4Var4 = new yc4(2102, "response data empty");
                zb4 zb4Var5 = this.a;
                if (zb4Var5 != null) {
                    zb4Var5.C(yc4Var4);
                }
                d(yc4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                yc4 e = e(str, u);
                if (e != null) {
                    zb4 zb4Var6 = this.a;
                    if (zb4Var6 != null) {
                        zb4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(yc4 yc4Var, String str, String str2, String str3, @Nullable jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, yc4Var, str, str2, str3, jd4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (yc4Var != null) {
                try {
                    if (yc4Var.a != 0) {
                        i = yc4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && yc4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", pb4.b().c());
                        jSONObject.put("network", fk4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof gf4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((gf4) this.b).g());
            }
            if (jd4Var != null && jd4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, jd4Var.f());
            }
            nb4 b = pb4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            eh4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public yc4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new yc4(2103, str);
            }
            return null;
        }
        return (yc4) invokeLL.objValue;
    }

    public yc4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new yc4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new yc4(2101, Log.getStackTraceString(exc));
        }
        return (yc4) invokeLL.objValue;
    }

    public void l(zc4 zc4Var, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, zc4Var, mh4Var) != null) || zc4Var == null) {
            return;
        }
        mh4Var.a(zc4Var, PMSPkgStatus.WAIT);
    }

    public void m(bd4 bd4Var, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, bd4Var, mh4Var) != null) || bd4Var == null) {
            return;
        }
        mh4Var.a(bd4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<fd4> list, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, mh4Var) == null) && list != null && !list.isEmpty()) {
            for (fd4 fd4Var : list) {
                mh4Var.a(fd4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(dd4 dd4Var, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, dd4Var, mh4Var) != null) || dd4Var == null) {
            return;
        }
        mh4Var.a(dd4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<ed4> list, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, mh4Var) == null) && list != null && !list.isEmpty()) {
            for (ed4 ed4Var : list) {
                mh4Var.a(ed4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(fd4 fd4Var, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, fd4Var, mh4Var) != null) || fd4Var == null) {
            return;
        }
        mh4Var.a(fd4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<fd4> g(@Nullable List<fd4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (fd4 fd4Var : list) {
                    if (fd4Var != null && !arrayList.contains(fd4Var)) {
                        bc4 i = bc4.i();
                        String str = fd4Var.g;
                        long j = fd4Var.i;
                        if (!pb4.b().r(i.q(str, j, j))) {
                            arrayList.add(fd4Var);
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
    public final String i(jd4 jd4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jd4Var)) == null) {
            if (jd4Var == null || jd4Var.c() == null || (optJSONObject = jd4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        yb4 p;
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

    @Override // com.baidu.tieba.nd4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            yc4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.nd4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new yc4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
