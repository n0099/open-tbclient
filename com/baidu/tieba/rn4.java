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
public class rn4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rn4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public rn4() {
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

    public static rn4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (rn4.class) {
                    if (a == null) {
                        a = new rn4();
                    }
                }
            }
            return a;
        }
        return (rn4) invokeV.objValue;
    }

    public static void b(wj4 wj4Var, go4 go4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, wj4Var, go4Var) != null) || wj4Var == null) {
            return;
        }
        go4Var.a(wj4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, ti4 ti4Var, ti4 ti4Var2, ti4 ti4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, ti4Var, ti4Var2, ti4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            qn4 qn4Var = new qn4();
            qn4 qn4Var2 = new qn4();
            qn4 qn4Var3 = new qn4();
            go4 go4Var = new go4();
            go4 go4Var2 = new go4();
            go4 go4Var3 = new go4();
            sn4 sn4Var = null;
            if (ti4Var3 != null) {
                sn4Var = ti4Var3.w("so");
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
                                                    if (qn4Var3.e == null) {
                                                        qn4Var3.e = new ArrayList();
                                                    }
                                                    zj4 zj4Var = (zj4) fo4.j(jSONObject2, new zj4());
                                                    b(zj4Var, go4Var3);
                                                    qn4Var3.e.add(zj4Var);
                                                }
                                            } else if (sn4Var != null) {
                                                sn4Var.l(jSONObject2);
                                            }
                                        } else {
                                            tj4 tj4Var = (tj4) fo4.j(jSONObject2, new tj4());
                                            if (tj4Var != null) {
                                                b(tj4Var, go4Var2);
                                                qn4Var2.c = tj4Var;
                                            }
                                        }
                                    } else {
                                        tj4 tj4Var2 = (tj4) fo4.j(jSONObject2, new tj4());
                                        if (tj4Var2 != null) {
                                            b(tj4Var2, go4Var);
                                            qn4Var.c = tj4Var2;
                                        }
                                    }
                                } else {
                                    vj4 vj4Var = (vj4) fo4.j(jSONObject2, new vj4());
                                    if (vj4Var != null) {
                                        b(vj4Var, go4Var2);
                                        qn4Var2.a = vj4Var;
                                    }
                                }
                            } else {
                                vj4 vj4Var2 = (vj4) fo4.j(jSONObject2, new vj4());
                                if (vj4Var2 != null) {
                                    b(vj4Var2, go4Var);
                                    qn4Var.b = vj4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (ti4Var != null) {
                if (go4Var.n() == 0) {
                    ti4Var.F();
                } else {
                    ti4Var.G(go4Var);
                    jk4.e(qn4Var, ti4Var);
                }
            }
            if (ti4Var2 != null) {
                if (go4Var2.n() == 0) {
                    ti4Var2.F();
                } else {
                    ti4Var2.G(go4Var2);
                    jk4.e(qn4Var2, ti4Var2);
                }
            }
            if (sn4Var != null) {
                sn4Var.o();
            }
            if (go4Var3.n() > 0 && ji4.b() != null) {
                ji4.b().t(qn4Var3, go4Var3);
            }
        }
    }
}
