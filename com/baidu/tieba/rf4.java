package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public rf4() {
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

    public static rf4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (rf4.class) {
                    if (a == null) {
                        a = new rf4();
                    }
                }
            }
            return a;
        }
        return (rf4) invokeV.objValue;
    }

    public static void b(wb4 wb4Var, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, wb4Var, gg4Var) == null) || wb4Var == null) {
            return;
        }
        gg4Var.a(wb4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, ta4 ta4Var, ta4 ta4Var2, ta4 ta4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, ta4Var, ta4Var2, ta4Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        qf4 qf4Var = new qf4();
        qf4 qf4Var2 = new qf4();
        qf4 qf4Var3 = new qf4();
        gg4 gg4Var = new gg4();
        gg4 gg4Var2 = new gg4();
        gg4 gg4Var3 = new gg4();
        sf4 w = ta4Var3 != null ? ta4Var3.w("so") : null;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("type");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (!TextUtils.isEmpty(jSONObject2.getString("version_name"))) {
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
                        if (c == 0) {
                            vb4 vb4Var = (vb4) fg4.j(jSONObject2, new vb4());
                            if (vb4Var != null) {
                                b(vb4Var, gg4Var);
                                qf4Var.b = vb4Var;
                            }
                        } else if (c == 1) {
                            vb4 vb4Var2 = (vb4) fg4.j(jSONObject2, new vb4());
                            if (vb4Var2 != null) {
                                b(vb4Var2, gg4Var2);
                                qf4Var2.a = vb4Var2;
                            }
                        } else if (c == 2) {
                            tb4 tb4Var = (tb4) fg4.j(jSONObject2, new tb4());
                            if (tb4Var != null) {
                                b(tb4Var, gg4Var);
                                qf4Var.c = tb4Var;
                            }
                        } else if (c == 3) {
                            tb4 tb4Var2 = (tb4) fg4.j(jSONObject2, new tb4());
                            if (tb4Var2 != null) {
                                b(tb4Var2, gg4Var2);
                                qf4Var2.c = tb4Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (qf4Var3.e == null) {
                                    qf4Var3.e = new ArrayList();
                                }
                                zb4 zb4Var = (zb4) fg4.j(jSONObject2, new zb4());
                                b(zb4Var, gg4Var3);
                                qf4Var3.e.add(zb4Var);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (ta4Var != null) {
            if (gg4Var.n() == 0) {
                ta4Var.F();
            } else {
                ta4Var.G(gg4Var);
                jc4.e(qf4Var, ta4Var);
            }
        }
        if (ta4Var2 != null) {
            if (gg4Var2.n() == 0) {
                ta4Var2.F();
            } else {
                ta4Var2.G(gg4Var2);
                jc4.e(qf4Var2, ta4Var2);
            }
        }
        if (w != null) {
            w.o();
        }
        if (gg4Var3.n() <= 0 || ja4.b() == null) {
            return;
        }
        ja4.b().t(qf4Var3, gg4Var3);
    }
}
