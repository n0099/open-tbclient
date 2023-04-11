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
public class nk4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nk4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public nk4() {
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

    public static nk4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (nk4.class) {
                    if (a == null) {
                        a = new nk4();
                    }
                }
            }
            return a;
        }
        return (nk4) invokeV.objValue;
    }

    public static void b(sg4 sg4Var, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, sg4Var, cl4Var) != null) || sg4Var == null) {
            return;
        }
        cl4Var.a(sg4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, pf4 pf4Var, pf4 pf4Var2, pf4 pf4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, pf4Var, pf4Var2, pf4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            mk4 mk4Var = new mk4();
            mk4 mk4Var2 = new mk4();
            mk4 mk4Var3 = new mk4();
            cl4 cl4Var = new cl4();
            cl4 cl4Var2 = new cl4();
            cl4 cl4Var3 = new cl4();
            ok4 ok4Var = null;
            if (pf4Var3 != null) {
                ok4Var = pf4Var3.w("so");
            }
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
                            if (c != 0) {
                                if (c != 1) {
                                    if (c != 2) {
                                        if (c != 3) {
                                            if (c != 4) {
                                                if (c == 5) {
                                                    if (mk4Var3.e == null) {
                                                        mk4Var3.e = new ArrayList();
                                                    }
                                                    vg4 vg4Var = (vg4) bl4.j(jSONObject2, new vg4());
                                                    b(vg4Var, cl4Var3);
                                                    mk4Var3.e.add(vg4Var);
                                                }
                                            } else if (ok4Var != null) {
                                                ok4Var.l(jSONObject2);
                                            }
                                        } else {
                                            pg4 pg4Var = (pg4) bl4.j(jSONObject2, new pg4());
                                            if (pg4Var != null) {
                                                b(pg4Var, cl4Var2);
                                                mk4Var2.c = pg4Var;
                                            }
                                        }
                                    } else {
                                        pg4 pg4Var2 = (pg4) bl4.j(jSONObject2, new pg4());
                                        if (pg4Var2 != null) {
                                            b(pg4Var2, cl4Var);
                                            mk4Var.c = pg4Var2;
                                        }
                                    }
                                } else {
                                    rg4 rg4Var = (rg4) bl4.j(jSONObject2, new rg4());
                                    if (rg4Var != null) {
                                        b(rg4Var, cl4Var2);
                                        mk4Var2.a = rg4Var;
                                    }
                                }
                            } else {
                                rg4 rg4Var2 = (rg4) bl4.j(jSONObject2, new rg4());
                                if (rg4Var2 != null) {
                                    b(rg4Var2, cl4Var);
                                    mk4Var.b = rg4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (pf4Var != null) {
                if (cl4Var.n() == 0) {
                    pf4Var.F();
                } else {
                    pf4Var.G(cl4Var);
                    fh4.e(mk4Var, pf4Var);
                }
            }
            if (pf4Var2 != null) {
                if (cl4Var2.n() == 0) {
                    pf4Var2.F();
                } else {
                    pf4Var2.G(cl4Var2);
                    fh4.e(mk4Var2, pf4Var2);
                }
            }
            if (ok4Var != null) {
                ok4Var.o();
            }
            if (cl4Var3.n() > 0 && ff4.b() != null) {
                ff4.b().t(mk4Var3, cl4Var3);
            }
        }
    }
}
