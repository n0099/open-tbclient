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
/* loaded from: classes8.dex */
public class zl4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zl4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public zl4() {
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

    public static zl4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (zl4.class) {
                    if (a == null) {
                        a = new zl4();
                    }
                }
            }
            return a;
        }
        return (zl4) invokeV.objValue;
    }

    public static void b(ei4 ei4Var, om4 om4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, ei4Var, om4Var) != null) || ei4Var == null) {
            return;
        }
        om4Var.a(ei4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, bh4 bh4Var, bh4 bh4Var2, bh4 bh4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, bh4Var, bh4Var2, bh4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            yl4 yl4Var = new yl4();
            yl4 yl4Var2 = new yl4();
            yl4 yl4Var3 = new yl4();
            om4 om4Var = new om4();
            om4 om4Var2 = new om4();
            om4 om4Var3 = new om4();
            am4 am4Var = null;
            if (bh4Var3 != null) {
                am4Var = bh4Var3.w("so");
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
                                                    if (yl4Var3.e == null) {
                                                        yl4Var3.e = new ArrayList();
                                                    }
                                                    hi4 hi4Var = (hi4) nm4.j(jSONObject2, new hi4());
                                                    b(hi4Var, om4Var3);
                                                    yl4Var3.e.add(hi4Var);
                                                }
                                            } else if (am4Var != null) {
                                                am4Var.l(jSONObject2);
                                            }
                                        } else {
                                            bi4 bi4Var = (bi4) nm4.j(jSONObject2, new bi4());
                                            if (bi4Var != null) {
                                                b(bi4Var, om4Var2);
                                                yl4Var2.c = bi4Var;
                                            }
                                        }
                                    } else {
                                        bi4 bi4Var2 = (bi4) nm4.j(jSONObject2, new bi4());
                                        if (bi4Var2 != null) {
                                            b(bi4Var2, om4Var);
                                            yl4Var.c = bi4Var2;
                                        }
                                    }
                                } else {
                                    di4 di4Var = (di4) nm4.j(jSONObject2, new di4());
                                    if (di4Var != null) {
                                        b(di4Var, om4Var2);
                                        yl4Var2.a = di4Var;
                                    }
                                }
                            } else {
                                di4 di4Var2 = (di4) nm4.j(jSONObject2, new di4());
                                if (di4Var2 != null) {
                                    b(di4Var2, om4Var);
                                    yl4Var.b = di4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (bh4Var != null) {
                if (om4Var.n() == 0) {
                    bh4Var.F();
                } else {
                    bh4Var.G(om4Var);
                    ri4.e(yl4Var, bh4Var);
                }
            }
            if (bh4Var2 != null) {
                if (om4Var2.n() == 0) {
                    bh4Var2.F();
                } else {
                    bh4Var2.G(om4Var2);
                    ri4.e(yl4Var2, bh4Var2);
                }
            }
            if (am4Var != null) {
                am4Var.o();
            }
            if (om4Var3.n() > 0 && rg4.b() != null) {
                rg4.b().t(yl4Var3, om4Var3);
            }
        }
    }
}
