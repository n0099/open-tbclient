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
public class mk4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mk4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public mk4() {
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

    public static mk4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (mk4.class) {
                    if (a == null) {
                        a = new mk4();
                    }
                }
            }
            return a;
        }
        return (mk4) invokeV.objValue;
    }

    public static void b(rg4 rg4Var, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, rg4Var, bl4Var) != null) || rg4Var == null) {
            return;
        }
        bl4Var.a(rg4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, of4 of4Var, of4 of4Var2, of4 of4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, of4Var, of4Var2, of4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            lk4 lk4Var = new lk4();
            lk4 lk4Var2 = new lk4();
            lk4 lk4Var3 = new lk4();
            bl4 bl4Var = new bl4();
            bl4 bl4Var2 = new bl4();
            bl4 bl4Var3 = new bl4();
            nk4 nk4Var = null;
            if (of4Var3 != null) {
                nk4Var = of4Var3.w("so");
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
                                                    if (lk4Var3.e == null) {
                                                        lk4Var3.e = new ArrayList();
                                                    }
                                                    ug4 ug4Var = (ug4) al4.j(jSONObject2, new ug4());
                                                    b(ug4Var, bl4Var3);
                                                    lk4Var3.e.add(ug4Var);
                                                }
                                            } else if (nk4Var != null) {
                                                nk4Var.l(jSONObject2);
                                            }
                                        } else {
                                            og4 og4Var = (og4) al4.j(jSONObject2, new og4());
                                            if (og4Var != null) {
                                                b(og4Var, bl4Var2);
                                                lk4Var2.c = og4Var;
                                            }
                                        }
                                    } else {
                                        og4 og4Var2 = (og4) al4.j(jSONObject2, new og4());
                                        if (og4Var2 != null) {
                                            b(og4Var2, bl4Var);
                                            lk4Var.c = og4Var2;
                                        }
                                    }
                                } else {
                                    qg4 qg4Var = (qg4) al4.j(jSONObject2, new qg4());
                                    if (qg4Var != null) {
                                        b(qg4Var, bl4Var2);
                                        lk4Var2.a = qg4Var;
                                    }
                                }
                            } else {
                                qg4 qg4Var2 = (qg4) al4.j(jSONObject2, new qg4());
                                if (qg4Var2 != null) {
                                    b(qg4Var2, bl4Var);
                                    lk4Var.b = qg4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (of4Var != null) {
                if (bl4Var.n() == 0) {
                    of4Var.F();
                } else {
                    of4Var.G(bl4Var);
                    eh4.e(lk4Var, of4Var);
                }
            }
            if (of4Var2 != null) {
                if (bl4Var2.n() == 0) {
                    of4Var2.F();
                } else {
                    of4Var2.G(bl4Var2);
                    eh4.e(lk4Var2, of4Var2);
                }
            }
            if (nk4Var != null) {
                nk4Var.o();
            }
            if (bl4Var3.n() > 0 && ef4.b() != null) {
                ef4.b().t(lk4Var3, bl4Var3);
            }
        }
    }
}
