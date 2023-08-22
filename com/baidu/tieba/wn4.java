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
public class wn4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wn4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public wn4() {
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

    public static wn4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (wn4.class) {
                    if (a == null) {
                        a = new wn4();
                    }
                }
            }
            return a;
        }
        return (wn4) invokeV.objValue;
    }

    public static void b(bk4 bk4Var, lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, bk4Var, lo4Var) != null) || bk4Var == null) {
            return;
        }
        lo4Var.a(bk4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, yi4 yi4Var, yi4 yi4Var2, yi4 yi4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, yi4Var, yi4Var2, yi4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            vn4 vn4Var = new vn4();
            vn4 vn4Var2 = new vn4();
            vn4 vn4Var3 = new vn4();
            lo4 lo4Var = new lo4();
            lo4 lo4Var2 = new lo4();
            lo4 lo4Var3 = new lo4();
            xn4 xn4Var = null;
            if (yi4Var3 != null) {
                xn4Var = yi4Var3.w("so");
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
                                                    if (vn4Var3.e == null) {
                                                        vn4Var3.e = new ArrayList();
                                                    }
                                                    ek4 ek4Var = (ek4) ko4.j(jSONObject2, new ek4());
                                                    b(ek4Var, lo4Var3);
                                                    vn4Var3.e.add(ek4Var);
                                                }
                                            } else if (xn4Var != null) {
                                                xn4Var.l(jSONObject2);
                                            }
                                        } else {
                                            yj4 yj4Var = (yj4) ko4.j(jSONObject2, new yj4());
                                            if (yj4Var != null) {
                                                b(yj4Var, lo4Var2);
                                                vn4Var2.c = yj4Var;
                                            }
                                        }
                                    } else {
                                        yj4 yj4Var2 = (yj4) ko4.j(jSONObject2, new yj4());
                                        if (yj4Var2 != null) {
                                            b(yj4Var2, lo4Var);
                                            vn4Var.c = yj4Var2;
                                        }
                                    }
                                } else {
                                    ak4 ak4Var = (ak4) ko4.j(jSONObject2, new ak4());
                                    if (ak4Var != null) {
                                        b(ak4Var, lo4Var2);
                                        vn4Var2.a = ak4Var;
                                    }
                                }
                            } else {
                                ak4 ak4Var2 = (ak4) ko4.j(jSONObject2, new ak4());
                                if (ak4Var2 != null) {
                                    b(ak4Var2, lo4Var);
                                    vn4Var.b = ak4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (yi4Var != null) {
                if (lo4Var.n() == 0) {
                    yi4Var.F();
                } else {
                    yi4Var.G(lo4Var);
                    ok4.e(vn4Var, yi4Var);
                }
            }
            if (yi4Var2 != null) {
                if (lo4Var2.n() == 0) {
                    yi4Var2.F();
                } else {
                    yi4Var2.G(lo4Var2);
                    ok4.e(vn4Var2, yi4Var2);
                }
            }
            if (xn4Var != null) {
                xn4Var.o();
            }
            if (lo4Var3.n() > 0 && oi4.b() != null) {
                oi4.b().t(vn4Var3, lo4Var3);
            }
        }
    }
}
