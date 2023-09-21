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
/* loaded from: classes9.dex */
public class zn4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zn4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public zn4() {
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

    public static zn4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (zn4.class) {
                    if (a == null) {
                        a = new zn4();
                    }
                }
            }
            return a;
        }
        return (zn4) invokeV.objValue;
    }

    public static void b(ek4 ek4Var, oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, ek4Var, oo4Var) != null) || ek4Var == null) {
            return;
        }
        oo4Var.a(ek4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, bj4 bj4Var, bj4 bj4Var2, bj4 bj4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, bj4Var, bj4Var2, bj4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            yn4 yn4Var = new yn4();
            yn4 yn4Var2 = new yn4();
            yn4 yn4Var3 = new yn4();
            oo4 oo4Var = new oo4();
            oo4 oo4Var2 = new oo4();
            oo4 oo4Var3 = new oo4();
            ao4 ao4Var = null;
            if (bj4Var3 != null) {
                ao4Var = bj4Var3.w("so");
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
                                                    if (yn4Var3.e == null) {
                                                        yn4Var3.e = new ArrayList();
                                                    }
                                                    hk4 hk4Var = (hk4) no4.j(jSONObject2, new hk4());
                                                    b(hk4Var, oo4Var3);
                                                    yn4Var3.e.add(hk4Var);
                                                }
                                            } else if (ao4Var != null) {
                                                ao4Var.l(jSONObject2);
                                            }
                                        } else {
                                            bk4 bk4Var = (bk4) no4.j(jSONObject2, new bk4());
                                            if (bk4Var != null) {
                                                b(bk4Var, oo4Var2);
                                                yn4Var2.c = bk4Var;
                                            }
                                        }
                                    } else {
                                        bk4 bk4Var2 = (bk4) no4.j(jSONObject2, new bk4());
                                        if (bk4Var2 != null) {
                                            b(bk4Var2, oo4Var);
                                            yn4Var.c = bk4Var2;
                                        }
                                    }
                                } else {
                                    dk4 dk4Var = (dk4) no4.j(jSONObject2, new dk4());
                                    if (dk4Var != null) {
                                        b(dk4Var, oo4Var2);
                                        yn4Var2.a = dk4Var;
                                    }
                                }
                            } else {
                                dk4 dk4Var2 = (dk4) no4.j(jSONObject2, new dk4());
                                if (dk4Var2 != null) {
                                    b(dk4Var2, oo4Var);
                                    yn4Var.b = dk4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (bj4Var != null) {
                if (oo4Var.n() == 0) {
                    bj4Var.F();
                } else {
                    bj4Var.G(oo4Var);
                    rk4.e(yn4Var, bj4Var);
                }
            }
            if (bj4Var2 != null) {
                if (oo4Var2.n() == 0) {
                    bj4Var2.F();
                } else {
                    bj4Var2.G(oo4Var2);
                    rk4.e(yn4Var2, bj4Var2);
                }
            }
            if (ao4Var != null) {
                ao4Var.o();
            }
            if (oo4Var3.n() > 0 && ri4.b() != null) {
                ri4.b().t(yn4Var3, oo4Var3);
            }
        }
    }
}
