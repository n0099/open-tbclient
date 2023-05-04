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
public class qk4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qk4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public qk4() {
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

    public static qk4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qk4.class) {
                    if (a == null) {
                        a = new qk4();
                    }
                }
            }
            return a;
        }
        return (qk4) invokeV.objValue;
    }

    public static void b(vg4 vg4Var, fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, vg4Var, fl4Var) != null) || vg4Var == null) {
            return;
        }
        fl4Var.a(vg4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, sf4 sf4Var, sf4 sf4Var2, sf4 sf4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, sf4Var, sf4Var2, sf4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            pk4 pk4Var = new pk4();
            pk4 pk4Var2 = new pk4();
            pk4 pk4Var3 = new pk4();
            fl4 fl4Var = new fl4();
            fl4 fl4Var2 = new fl4();
            fl4 fl4Var3 = new fl4();
            rk4 rk4Var = null;
            if (sf4Var3 != null) {
                rk4Var = sf4Var3.w("so");
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
                                                    if (pk4Var3.e == null) {
                                                        pk4Var3.e = new ArrayList();
                                                    }
                                                    yg4 yg4Var = (yg4) el4.j(jSONObject2, new yg4());
                                                    b(yg4Var, fl4Var3);
                                                    pk4Var3.e.add(yg4Var);
                                                }
                                            } else if (rk4Var != null) {
                                                rk4Var.l(jSONObject2);
                                            }
                                        } else {
                                            sg4 sg4Var = (sg4) el4.j(jSONObject2, new sg4());
                                            if (sg4Var != null) {
                                                b(sg4Var, fl4Var2);
                                                pk4Var2.c = sg4Var;
                                            }
                                        }
                                    } else {
                                        sg4 sg4Var2 = (sg4) el4.j(jSONObject2, new sg4());
                                        if (sg4Var2 != null) {
                                            b(sg4Var2, fl4Var);
                                            pk4Var.c = sg4Var2;
                                        }
                                    }
                                } else {
                                    ug4 ug4Var = (ug4) el4.j(jSONObject2, new ug4());
                                    if (ug4Var != null) {
                                        b(ug4Var, fl4Var2);
                                        pk4Var2.a = ug4Var;
                                    }
                                }
                            } else {
                                ug4 ug4Var2 = (ug4) el4.j(jSONObject2, new ug4());
                                if (ug4Var2 != null) {
                                    b(ug4Var2, fl4Var);
                                    pk4Var.b = ug4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (sf4Var != null) {
                if (fl4Var.n() == 0) {
                    sf4Var.F();
                } else {
                    sf4Var.G(fl4Var);
                    ih4.e(pk4Var, sf4Var);
                }
            }
            if (sf4Var2 != null) {
                if (fl4Var2.n() == 0) {
                    sf4Var2.F();
                } else {
                    sf4Var2.G(fl4Var2);
                    ih4.e(pk4Var2, sf4Var2);
                }
            }
            if (rk4Var != null) {
                rk4Var.o();
            }
            if (fl4Var3.n() > 0 && if4.b() != null) {
                if4.b().t(pk4Var3, fl4Var3);
            }
        }
    }
}
