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
public class pl4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pl4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public pl4() {
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

    public static pl4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (pl4.class) {
                    if (a == null) {
                        a = new pl4();
                    }
                }
            }
            return a;
        }
        return (pl4) invokeV.objValue;
    }

    public static void b(uh4 uh4Var, em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, uh4Var, em4Var) != null) || uh4Var == null) {
            return;
        }
        em4Var.a(uh4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, rg4 rg4Var, rg4 rg4Var2, rg4 rg4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, rg4Var, rg4Var2, rg4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            ol4 ol4Var = new ol4();
            ol4 ol4Var2 = new ol4();
            ol4 ol4Var3 = new ol4();
            em4 em4Var = new em4();
            em4 em4Var2 = new em4();
            em4 em4Var3 = new em4();
            ql4 ql4Var = null;
            if (rg4Var3 != null) {
                ql4Var = rg4Var3.w("so");
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
                                                    if (ol4Var3.e == null) {
                                                        ol4Var3.e = new ArrayList();
                                                    }
                                                    xh4 xh4Var = (xh4) dm4.j(jSONObject2, new xh4());
                                                    b(xh4Var, em4Var3);
                                                    ol4Var3.e.add(xh4Var);
                                                }
                                            } else if (ql4Var != null) {
                                                ql4Var.l(jSONObject2);
                                            }
                                        } else {
                                            rh4 rh4Var = (rh4) dm4.j(jSONObject2, new rh4());
                                            if (rh4Var != null) {
                                                b(rh4Var, em4Var2);
                                                ol4Var2.c = rh4Var;
                                            }
                                        }
                                    } else {
                                        rh4 rh4Var2 = (rh4) dm4.j(jSONObject2, new rh4());
                                        if (rh4Var2 != null) {
                                            b(rh4Var2, em4Var);
                                            ol4Var.c = rh4Var2;
                                        }
                                    }
                                } else {
                                    th4 th4Var = (th4) dm4.j(jSONObject2, new th4());
                                    if (th4Var != null) {
                                        b(th4Var, em4Var2);
                                        ol4Var2.a = th4Var;
                                    }
                                }
                            } else {
                                th4 th4Var2 = (th4) dm4.j(jSONObject2, new th4());
                                if (th4Var2 != null) {
                                    b(th4Var2, em4Var);
                                    ol4Var.b = th4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (rg4Var != null) {
                if (em4Var.n() == 0) {
                    rg4Var.F();
                } else {
                    rg4Var.G(em4Var);
                    hi4.e(ol4Var, rg4Var);
                }
            }
            if (rg4Var2 != null) {
                if (em4Var2.n() == 0) {
                    rg4Var2.F();
                } else {
                    rg4Var2.G(em4Var2);
                    hi4.e(ol4Var2, rg4Var2);
                }
            }
            if (ql4Var != null) {
                ql4Var.o();
            }
            if (em4Var3.n() > 0 && hg4.b() != null) {
                hg4.b().t(ol4Var3, em4Var3);
            }
        }
    }
}
