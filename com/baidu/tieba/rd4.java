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
public class rd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public rd4() {
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

    public static rd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (rd4.class) {
                    if (a == null) {
                        a = new rd4();
                    }
                }
            }
            return a;
        }
        return (rd4) invokeV.objValue;
    }

    public static void b(w94 w94Var, ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, w94Var, ge4Var) == null) || w94Var == null) {
            return;
        }
        ge4Var.a(w94Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, t84 t84Var, t84 t84Var2, t84 t84Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, t84Var, t84Var2, t84Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        qd4 qd4Var = new qd4();
        qd4 qd4Var2 = new qd4();
        qd4 qd4Var3 = new qd4();
        ge4 ge4Var = new ge4();
        ge4 ge4Var2 = new ge4();
        ge4 ge4Var3 = new ge4();
        sd4 w = t84Var3 != null ? t84Var3.w("so") : null;
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
                            v94 v94Var = (v94) fe4.j(jSONObject2, new v94());
                            if (v94Var != null) {
                                b(v94Var, ge4Var);
                                qd4Var.b = v94Var;
                            }
                        } else if (c == 1) {
                            v94 v94Var2 = (v94) fe4.j(jSONObject2, new v94());
                            if (v94Var2 != null) {
                                b(v94Var2, ge4Var2);
                                qd4Var2.a = v94Var2;
                            }
                        } else if (c == 2) {
                            t94 t94Var = (t94) fe4.j(jSONObject2, new t94());
                            if (t94Var != null) {
                                b(t94Var, ge4Var);
                                qd4Var.c = t94Var;
                            }
                        } else if (c == 3) {
                            t94 t94Var2 = (t94) fe4.j(jSONObject2, new t94());
                            if (t94Var2 != null) {
                                b(t94Var2, ge4Var2);
                                qd4Var2.c = t94Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (qd4Var3.e == null) {
                                    qd4Var3.e = new ArrayList();
                                }
                                z94 z94Var = (z94) fe4.j(jSONObject2, new z94());
                                b(z94Var, ge4Var3);
                                qd4Var3.e.add(z94Var);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (t84Var != null) {
            if (ge4Var.n() == 0) {
                t84Var.F();
            } else {
                t84Var.G(ge4Var);
                ja4.e(qd4Var, t84Var);
            }
        }
        if (t84Var2 != null) {
            if (ge4Var2.n() == 0) {
                t84Var2.F();
            } else {
                t84Var2.G(ge4Var2);
                ja4.e(qd4Var2, t84Var2);
            }
        }
        if (w != null) {
            w.o();
        }
        if (ge4Var3.n() <= 0 || j84.b() == null) {
            return;
        }
        j84.b().t(qd4Var3, ge4Var3);
    }
}
