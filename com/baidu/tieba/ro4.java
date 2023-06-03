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
public class ro4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ro4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ro4() {
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

    public static ro4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ro4.class) {
                    if (a == null) {
                        a = new ro4();
                    }
                }
            }
            return a;
        }
        return (ro4) invokeV.objValue;
    }

    public static void b(wk4 wk4Var, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, wk4Var, gp4Var) != null) || wk4Var == null) {
            return;
        }
        gp4Var.a(wk4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, tj4 tj4Var, tj4 tj4Var2, tj4 tj4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, tj4Var, tj4Var2, tj4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            qo4 qo4Var = new qo4();
            qo4 qo4Var2 = new qo4();
            qo4 qo4Var3 = new qo4();
            gp4 gp4Var = new gp4();
            gp4 gp4Var2 = new gp4();
            gp4 gp4Var3 = new gp4();
            so4 so4Var = null;
            if (tj4Var3 != null) {
                so4Var = tj4Var3.w("so");
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
                                                    if (qo4Var3.e == null) {
                                                        qo4Var3.e = new ArrayList();
                                                    }
                                                    zk4 zk4Var = (zk4) fp4.j(jSONObject2, new zk4());
                                                    b(zk4Var, gp4Var3);
                                                    qo4Var3.e.add(zk4Var);
                                                }
                                            } else if (so4Var != null) {
                                                so4Var.l(jSONObject2);
                                            }
                                        } else {
                                            tk4 tk4Var = (tk4) fp4.j(jSONObject2, new tk4());
                                            if (tk4Var != null) {
                                                b(tk4Var, gp4Var2);
                                                qo4Var2.c = tk4Var;
                                            }
                                        }
                                    } else {
                                        tk4 tk4Var2 = (tk4) fp4.j(jSONObject2, new tk4());
                                        if (tk4Var2 != null) {
                                            b(tk4Var2, gp4Var);
                                            qo4Var.c = tk4Var2;
                                        }
                                    }
                                } else {
                                    vk4 vk4Var = (vk4) fp4.j(jSONObject2, new vk4());
                                    if (vk4Var != null) {
                                        b(vk4Var, gp4Var2);
                                        qo4Var2.a = vk4Var;
                                    }
                                }
                            } else {
                                vk4 vk4Var2 = (vk4) fp4.j(jSONObject2, new vk4());
                                if (vk4Var2 != null) {
                                    b(vk4Var2, gp4Var);
                                    qo4Var.b = vk4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (tj4Var != null) {
                if (gp4Var.n() == 0) {
                    tj4Var.F();
                } else {
                    tj4Var.G(gp4Var);
                    jl4.e(qo4Var, tj4Var);
                }
            }
            if (tj4Var2 != null) {
                if (gp4Var2.n() == 0) {
                    tj4Var2.F();
                } else {
                    tj4Var2.G(gp4Var2);
                    jl4.e(qo4Var2, tj4Var2);
                }
            }
            if (so4Var != null) {
                so4Var.o();
            }
            if (gp4Var3.n() > 0 && jj4.b() != null) {
                jj4.b().t(qo4Var3, gp4Var3);
            }
        }
    }
}
