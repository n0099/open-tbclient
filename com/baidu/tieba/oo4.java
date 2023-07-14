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
public class oo4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oo4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public oo4() {
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

    public static oo4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (oo4.class) {
                    if (a == null) {
                        a = new oo4();
                    }
                }
            }
            return a;
        }
        return (oo4) invokeV.objValue;
    }

    public static void b(tk4 tk4Var, dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, tk4Var, dp4Var) != null) || tk4Var == null) {
            return;
        }
        dp4Var.a(tk4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, qj4 qj4Var, qj4 qj4Var2, qj4 qj4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, qj4Var, qj4Var2, qj4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            no4 no4Var = new no4();
            no4 no4Var2 = new no4();
            no4 no4Var3 = new no4();
            dp4 dp4Var = new dp4();
            dp4 dp4Var2 = new dp4();
            dp4 dp4Var3 = new dp4();
            po4 po4Var = null;
            if (qj4Var3 != null) {
                po4Var = qj4Var3.w("so");
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
                                                    if (no4Var3.e == null) {
                                                        no4Var3.e = new ArrayList();
                                                    }
                                                    wk4 wk4Var = (wk4) cp4.j(jSONObject2, new wk4());
                                                    b(wk4Var, dp4Var3);
                                                    no4Var3.e.add(wk4Var);
                                                }
                                            } else if (po4Var != null) {
                                                po4Var.l(jSONObject2);
                                            }
                                        } else {
                                            qk4 qk4Var = (qk4) cp4.j(jSONObject2, new qk4());
                                            if (qk4Var != null) {
                                                b(qk4Var, dp4Var2);
                                                no4Var2.c = qk4Var;
                                            }
                                        }
                                    } else {
                                        qk4 qk4Var2 = (qk4) cp4.j(jSONObject2, new qk4());
                                        if (qk4Var2 != null) {
                                            b(qk4Var2, dp4Var);
                                            no4Var.c = qk4Var2;
                                        }
                                    }
                                } else {
                                    sk4 sk4Var = (sk4) cp4.j(jSONObject2, new sk4());
                                    if (sk4Var != null) {
                                        b(sk4Var, dp4Var2);
                                        no4Var2.a = sk4Var;
                                    }
                                }
                            } else {
                                sk4 sk4Var2 = (sk4) cp4.j(jSONObject2, new sk4());
                                if (sk4Var2 != null) {
                                    b(sk4Var2, dp4Var);
                                    no4Var.b = sk4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (qj4Var != null) {
                if (dp4Var.n() == 0) {
                    qj4Var.F();
                } else {
                    qj4Var.G(dp4Var);
                    gl4.e(no4Var, qj4Var);
                }
            }
            if (qj4Var2 != null) {
                if (dp4Var2.n() == 0) {
                    qj4Var2.F();
                } else {
                    qj4Var2.G(dp4Var2);
                    gl4.e(no4Var2, qj4Var2);
                }
            }
            if (po4Var != null) {
                po4Var.o();
            }
            if (dp4Var3.n() > 0 && gj4.b() != null) {
                gj4.b().t(no4Var3, dp4Var3);
            }
        }
    }
}
