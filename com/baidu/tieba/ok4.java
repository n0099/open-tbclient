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
public class ok4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ok4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ok4() {
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

    public static ok4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ok4.class) {
                    if (a == null) {
                        a = new ok4();
                    }
                }
            }
            return a;
        }
        return (ok4) invokeV.objValue;
    }

    public static void b(tg4 tg4Var, dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, tg4Var, dl4Var) != null) || tg4Var == null) {
            return;
        }
        dl4Var.a(tg4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, qf4 qf4Var, qf4 qf4Var2, qf4 qf4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, qf4Var, qf4Var2, qf4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            nk4 nk4Var = new nk4();
            nk4 nk4Var2 = new nk4();
            nk4 nk4Var3 = new nk4();
            dl4 dl4Var = new dl4();
            dl4 dl4Var2 = new dl4();
            dl4 dl4Var3 = new dl4();
            pk4 pk4Var = null;
            if (qf4Var3 != null) {
                pk4Var = qf4Var3.w("so");
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
                                                    if (nk4Var3.e == null) {
                                                        nk4Var3.e = new ArrayList();
                                                    }
                                                    wg4 wg4Var = (wg4) cl4.j(jSONObject2, new wg4());
                                                    b(wg4Var, dl4Var3);
                                                    nk4Var3.e.add(wg4Var);
                                                }
                                            } else if (pk4Var != null) {
                                                pk4Var.l(jSONObject2);
                                            }
                                        } else {
                                            qg4 qg4Var = (qg4) cl4.j(jSONObject2, new qg4());
                                            if (qg4Var != null) {
                                                b(qg4Var, dl4Var2);
                                                nk4Var2.c = qg4Var;
                                            }
                                        }
                                    } else {
                                        qg4 qg4Var2 = (qg4) cl4.j(jSONObject2, new qg4());
                                        if (qg4Var2 != null) {
                                            b(qg4Var2, dl4Var);
                                            nk4Var.c = qg4Var2;
                                        }
                                    }
                                } else {
                                    sg4 sg4Var = (sg4) cl4.j(jSONObject2, new sg4());
                                    if (sg4Var != null) {
                                        b(sg4Var, dl4Var2);
                                        nk4Var2.a = sg4Var;
                                    }
                                }
                            } else {
                                sg4 sg4Var2 = (sg4) cl4.j(jSONObject2, new sg4());
                                if (sg4Var2 != null) {
                                    b(sg4Var2, dl4Var);
                                    nk4Var.b = sg4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (qf4Var != null) {
                if (dl4Var.n() == 0) {
                    qf4Var.F();
                } else {
                    qf4Var.G(dl4Var);
                    gh4.e(nk4Var, qf4Var);
                }
            }
            if (qf4Var2 != null) {
                if (dl4Var2.n() == 0) {
                    qf4Var2.F();
                } else {
                    qf4Var2.G(dl4Var2);
                    gh4.e(nk4Var2, qf4Var2);
                }
            }
            if (pk4Var != null) {
                pk4Var.o();
            }
            if (dl4Var3.n() > 0 && gf4.b() != null) {
                gf4.b().t(nk4Var3, dl4Var3);
            }
        }
    }
}
