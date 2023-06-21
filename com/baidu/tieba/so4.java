package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class so4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile so4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public so4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static so4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (so4.class) {
                    if (a == null) {
                        a = new so4();
                    }
                }
            }
            return a;
        }
        return (so4) invokeV.objValue;
    }

    public static void b(xk4 xk4Var, hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, xk4Var, hp4Var) != null) || xk4Var == null) {
            return;
        }
        hp4Var.a(xk4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, uj4 uj4Var, uj4 uj4Var2, uj4 uj4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, uj4Var, uj4Var2, uj4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            ro4 ro4Var = new ro4();
            ro4 ro4Var2 = new ro4();
            ro4 ro4Var3 = new ro4();
            hp4 hp4Var = new hp4();
            hp4 hp4Var2 = new hp4();
            hp4 hp4Var3 = new hp4();
            to4 to4Var = null;
            if (uj4Var3 != null) {
                to4Var = uj4Var3.w("so");
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("type");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (!TextUtils.isEmpty(jSONObject2.getString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME))) {
                            switch (string.hashCode()) {
                                case -612557761:
                                    if (string.equals(ETAG.KEY_EXTENSION)) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3676:
                                    if (string.equals("so")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 99308:
                                    if (string.equals("ddl")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 54573042:
                                    if (string.equals("extension_game")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 714512640:
                                    if (string.equals("bbasp_core")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 714618195:
                                    if (string.equals("bbasp_game")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    if (c != 2) {
                                        if (c != 3) {
                                            if (c != 4) {
                                                if (c == 5) {
                                                    if (ro4Var3.e == null) {
                                                        ro4Var3.e = new ArrayList();
                                                    }
                                                    al4 al4Var = (al4) gp4.j(jSONObject2, new al4());
                                                    b(al4Var, hp4Var3);
                                                    ro4Var3.e.add(al4Var);
                                                }
                                            } else if (to4Var != null) {
                                                to4Var.l(jSONObject2);
                                            }
                                        } else {
                                            uk4 uk4Var = (uk4) gp4.j(jSONObject2, new uk4());
                                            if (uk4Var != null) {
                                                b(uk4Var, hp4Var2);
                                                ro4Var2.c = uk4Var;
                                            }
                                        }
                                    } else {
                                        uk4 uk4Var2 = (uk4) gp4.j(jSONObject2, new uk4());
                                        if (uk4Var2 != null) {
                                            b(uk4Var2, hp4Var);
                                            ro4Var.c = uk4Var2;
                                        }
                                    }
                                } else {
                                    wk4 wk4Var = (wk4) gp4.j(jSONObject2, new wk4());
                                    if (wk4Var != null) {
                                        b(wk4Var, hp4Var2);
                                        ro4Var2.a = wk4Var;
                                    }
                                }
                            } else {
                                wk4 wk4Var2 = (wk4) gp4.j(jSONObject2, new wk4());
                                if (wk4Var2 != null) {
                                    b(wk4Var2, hp4Var);
                                    ro4Var.b = wk4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (uj4Var != null) {
                if (hp4Var.n() == 0) {
                    uj4Var.F();
                } else {
                    uj4Var.G(hp4Var);
                    kl4.e(ro4Var, uj4Var);
                }
            }
            if (uj4Var2 != null) {
                if (hp4Var2.n() == 0) {
                    uj4Var2.F();
                } else {
                    uj4Var2.G(hp4Var2);
                    kl4.e(ro4Var2, uj4Var2);
                }
            }
            if (to4Var != null) {
                to4Var.o();
            }
            if (hp4Var3.n() > 0 && kj4.b() != null) {
                kj4.b().t(ro4Var3, hp4Var3);
            }
        }
    }
}
