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
public class zi4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zi4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public zi4() {
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

    public static zi4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (zi4.class) {
                    if (a == null) {
                        a = new zi4();
                    }
                }
            }
            return a;
        }
        return (zi4) invokeV.objValue;
    }

    public static void b(ef4 ef4Var, oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, ef4Var, oj4Var) != null) || ef4Var == null) {
            return;
        }
        oj4Var.a(ef4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, be4 be4Var, be4 be4Var2, be4 be4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, be4Var, be4Var2, be4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            yi4 yi4Var = new yi4();
            yi4 yi4Var2 = new yi4();
            yi4 yi4Var3 = new yi4();
            oj4 oj4Var = new oj4();
            oj4 oj4Var2 = new oj4();
            oj4 oj4Var3 = new oj4();
            aj4 aj4Var = null;
            if (be4Var3 != null) {
                aj4Var = be4Var3.w("so");
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
                                                    if (yi4Var3.e == null) {
                                                        yi4Var3.e = new ArrayList();
                                                    }
                                                    hf4 hf4Var = (hf4) nj4.j(jSONObject2, new hf4());
                                                    b(hf4Var, oj4Var3);
                                                    yi4Var3.e.add(hf4Var);
                                                }
                                            } else if (aj4Var != null) {
                                                aj4Var.l(jSONObject2);
                                            }
                                        } else {
                                            bf4 bf4Var = (bf4) nj4.j(jSONObject2, new bf4());
                                            if (bf4Var != null) {
                                                b(bf4Var, oj4Var2);
                                                yi4Var2.c = bf4Var;
                                            }
                                        }
                                    } else {
                                        bf4 bf4Var2 = (bf4) nj4.j(jSONObject2, new bf4());
                                        if (bf4Var2 != null) {
                                            b(bf4Var2, oj4Var);
                                            yi4Var.c = bf4Var2;
                                        }
                                    }
                                } else {
                                    df4 df4Var = (df4) nj4.j(jSONObject2, new df4());
                                    if (df4Var != null) {
                                        b(df4Var, oj4Var2);
                                        yi4Var2.a = df4Var;
                                    }
                                }
                            } else {
                                df4 df4Var2 = (df4) nj4.j(jSONObject2, new df4());
                                if (df4Var2 != null) {
                                    b(df4Var2, oj4Var);
                                    yi4Var.b = df4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (be4Var != null) {
                if (oj4Var.n() == 0) {
                    be4Var.F();
                } else {
                    be4Var.G(oj4Var);
                    rf4.e(yi4Var, be4Var);
                }
            }
            if (be4Var2 != null) {
                if (oj4Var2.n() == 0) {
                    be4Var2.F();
                } else {
                    be4Var2.G(oj4Var2);
                    rf4.e(yi4Var2, be4Var2);
                }
            }
            if (aj4Var != null) {
                aj4Var.o();
            }
            if (oj4Var3.n() > 0 && rd4.b() != null) {
                rd4.b().t(yi4Var3, oj4Var3);
            }
        }
    }
}
