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
/* loaded from: classes8.dex */
public class vo4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vo4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public vo4() {
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

    public static vo4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (vo4.class) {
                    if (a == null) {
                        a = new vo4();
                    }
                }
            }
            return a;
        }
        return (vo4) invokeV.objValue;
    }

    public static void b(al4 al4Var, kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, al4Var, kp4Var) != null) || al4Var == null) {
            return;
        }
        kp4Var.a(al4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, xj4 xj4Var, xj4 xj4Var2, xj4 xj4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, xj4Var, xj4Var2, xj4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            uo4 uo4Var = new uo4();
            uo4 uo4Var2 = new uo4();
            uo4 uo4Var3 = new uo4();
            kp4 kp4Var = new kp4();
            kp4 kp4Var2 = new kp4();
            kp4 kp4Var3 = new kp4();
            wo4 wo4Var = null;
            if (xj4Var3 != null) {
                wo4Var = xj4Var3.w("so");
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
                                                    if (uo4Var3.e == null) {
                                                        uo4Var3.e = new ArrayList();
                                                    }
                                                    dl4 dl4Var = (dl4) jp4.j(jSONObject2, new dl4());
                                                    b(dl4Var, kp4Var3);
                                                    uo4Var3.e.add(dl4Var);
                                                }
                                            } else if (wo4Var != null) {
                                                wo4Var.l(jSONObject2);
                                            }
                                        } else {
                                            xk4 xk4Var = (xk4) jp4.j(jSONObject2, new xk4());
                                            if (xk4Var != null) {
                                                b(xk4Var, kp4Var2);
                                                uo4Var2.c = xk4Var;
                                            }
                                        }
                                    } else {
                                        xk4 xk4Var2 = (xk4) jp4.j(jSONObject2, new xk4());
                                        if (xk4Var2 != null) {
                                            b(xk4Var2, kp4Var);
                                            uo4Var.c = xk4Var2;
                                        }
                                    }
                                } else {
                                    zk4 zk4Var = (zk4) jp4.j(jSONObject2, new zk4());
                                    if (zk4Var != null) {
                                        b(zk4Var, kp4Var2);
                                        uo4Var2.a = zk4Var;
                                    }
                                }
                            } else {
                                zk4 zk4Var2 = (zk4) jp4.j(jSONObject2, new zk4());
                                if (zk4Var2 != null) {
                                    b(zk4Var2, kp4Var);
                                    uo4Var.b = zk4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (xj4Var != null) {
                if (kp4Var.n() == 0) {
                    xj4Var.F();
                } else {
                    xj4Var.G(kp4Var);
                    nl4.e(uo4Var, xj4Var);
                }
            }
            if (xj4Var2 != null) {
                if (kp4Var2.n() == 0) {
                    xj4Var2.F();
                } else {
                    xj4Var2.G(kp4Var2);
                    nl4.e(uo4Var2, xj4Var2);
                }
            }
            if (wo4Var != null) {
                wo4Var.o();
            }
            if (kp4Var3.n() > 0 && nj4.b() != null) {
                nj4.b().t(uo4Var3, kp4Var3);
            }
        }
    }
}
