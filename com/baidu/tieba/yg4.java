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
/* loaded from: classes6.dex */
public class yg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public yg4() {
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

    public static yg4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (yg4.class) {
                    if (a == null) {
                        a = new yg4();
                    }
                }
            }
            return a;
        }
        return (yg4) invokeV.objValue;
    }

    public static void b(dd4 dd4Var, nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, dd4Var, nh4Var) != null) || dd4Var == null) {
            return;
        }
        nh4Var.a(dd4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, ac4 ac4Var, ac4 ac4Var2, ac4 ac4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, ac4Var, ac4Var2, ac4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            xg4 xg4Var = new xg4();
            xg4 xg4Var2 = new xg4();
            xg4 xg4Var3 = new xg4();
            nh4 nh4Var = new nh4();
            nh4 nh4Var2 = new nh4();
            nh4 nh4Var3 = new nh4();
            zg4 zg4Var = null;
            if (ac4Var3 != null) {
                zg4Var = ac4Var3.w("so");
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
                                                    if (xg4Var3.e == null) {
                                                        xg4Var3.e = new ArrayList();
                                                    }
                                                    gd4 gd4Var = (gd4) mh4.j(jSONObject2, new gd4());
                                                    b(gd4Var, nh4Var3);
                                                    xg4Var3.e.add(gd4Var);
                                                }
                                            } else if (zg4Var != null) {
                                                zg4Var.l(jSONObject2);
                                            }
                                        } else {
                                            ad4 ad4Var = (ad4) mh4.j(jSONObject2, new ad4());
                                            if (ad4Var != null) {
                                                b(ad4Var, nh4Var2);
                                                xg4Var2.c = ad4Var;
                                            }
                                        }
                                    } else {
                                        ad4 ad4Var2 = (ad4) mh4.j(jSONObject2, new ad4());
                                        if (ad4Var2 != null) {
                                            b(ad4Var2, nh4Var);
                                            xg4Var.c = ad4Var2;
                                        }
                                    }
                                } else {
                                    cd4 cd4Var = (cd4) mh4.j(jSONObject2, new cd4());
                                    if (cd4Var != null) {
                                        b(cd4Var, nh4Var2);
                                        xg4Var2.a = cd4Var;
                                    }
                                }
                            } else {
                                cd4 cd4Var2 = (cd4) mh4.j(jSONObject2, new cd4());
                                if (cd4Var2 != null) {
                                    b(cd4Var2, nh4Var);
                                    xg4Var.b = cd4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (ac4Var != null) {
                if (nh4Var.n() == 0) {
                    ac4Var.F();
                } else {
                    ac4Var.G(nh4Var);
                    qd4.e(xg4Var, ac4Var);
                }
            }
            if (ac4Var2 != null) {
                if (nh4Var2.n() == 0) {
                    ac4Var2.F();
                } else {
                    ac4Var2.G(nh4Var2);
                    qd4.e(xg4Var2, ac4Var2);
                }
            }
            if (zg4Var != null) {
                zg4Var.o();
            }
            if (nh4Var3.n() > 0 && qb4.b() != null) {
                qb4.b().t(xg4Var3, nh4Var3);
            }
        }
    }
}
