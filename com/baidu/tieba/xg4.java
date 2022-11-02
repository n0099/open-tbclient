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
public class xg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public xg4() {
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

    public static xg4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (xg4.class) {
                    if (a == null) {
                        a = new xg4();
                    }
                }
            }
            return a;
        }
        return (xg4) invokeV.objValue;
    }

    public static void b(cd4 cd4Var, mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, cd4Var, mh4Var) != null) || cd4Var == null) {
            return;
        }
        mh4Var.a(cd4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, zb4 zb4Var, zb4 zb4Var2, zb4 zb4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, zb4Var, zb4Var2, zb4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            wg4 wg4Var = new wg4();
            wg4 wg4Var2 = new wg4();
            wg4 wg4Var3 = new wg4();
            mh4 mh4Var = new mh4();
            mh4 mh4Var2 = new mh4();
            mh4 mh4Var3 = new mh4();
            yg4 yg4Var = null;
            if (zb4Var3 != null) {
                yg4Var = zb4Var3.w("so");
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
                                                    if (wg4Var3.e == null) {
                                                        wg4Var3.e = new ArrayList();
                                                    }
                                                    fd4 fd4Var = (fd4) lh4.j(jSONObject2, new fd4());
                                                    b(fd4Var, mh4Var3);
                                                    wg4Var3.e.add(fd4Var);
                                                }
                                            } else if (yg4Var != null) {
                                                yg4Var.l(jSONObject2);
                                            }
                                        } else {
                                            zc4 zc4Var = (zc4) lh4.j(jSONObject2, new zc4());
                                            if (zc4Var != null) {
                                                b(zc4Var, mh4Var2);
                                                wg4Var2.c = zc4Var;
                                            }
                                        }
                                    } else {
                                        zc4 zc4Var2 = (zc4) lh4.j(jSONObject2, new zc4());
                                        if (zc4Var2 != null) {
                                            b(zc4Var2, mh4Var);
                                            wg4Var.c = zc4Var2;
                                        }
                                    }
                                } else {
                                    bd4 bd4Var = (bd4) lh4.j(jSONObject2, new bd4());
                                    if (bd4Var != null) {
                                        b(bd4Var, mh4Var2);
                                        wg4Var2.a = bd4Var;
                                    }
                                }
                            } else {
                                bd4 bd4Var2 = (bd4) lh4.j(jSONObject2, new bd4());
                                if (bd4Var2 != null) {
                                    b(bd4Var2, mh4Var);
                                    wg4Var.b = bd4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (zb4Var != null) {
                if (mh4Var.n() == 0) {
                    zb4Var.F();
                } else {
                    zb4Var.G(mh4Var);
                    pd4.e(wg4Var, zb4Var);
                }
            }
            if (zb4Var2 != null) {
                if (mh4Var2.n() == 0) {
                    zb4Var2.F();
                } else {
                    zb4Var2.G(mh4Var2);
                    pd4.e(wg4Var2, zb4Var2);
                }
            }
            if (yg4Var != null) {
                yg4Var.o();
            }
            if (mh4Var3.n() > 0 && pb4.b() != null) {
                pb4.b().t(wg4Var3, mh4Var3);
            }
        }
    }
}
