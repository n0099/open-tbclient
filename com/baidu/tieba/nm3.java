package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (im3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            xm3 m = om3.l().m();
            if (m == null) {
                if (im3.a) {
                    Log.d("BDTLS", "bdtls ubc data is null");
                    return;
                }
                return;
            }
            try {
                int i4 = -1;
                if (m.d() != null) {
                    i = m.d().intValue();
                } else {
                    i = -1;
                }
                if (m.f() != null) {
                    i2 = m.f().intValue();
                } else {
                    i2 = -1;
                }
                if (m.e() != null) {
                    i3 = m.e().intValue();
                } else {
                    i3 = -1;
                }
                if (m.g() != null) {
                    i4 = m.g().intValue();
                }
                if (im3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                pa3 pa3Var = new pa3();
                pa3Var.b = str;
                pa3Var.a("dh_group_id", Integer.valueOf(i));
                pa3Var.a("dh_secret", Integer.valueOf(i2));
                pa3Var.a("dh_pub_c", Integer.valueOf(i3));
                pa3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (im3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                fa3.d(pa3Var);
            } catch (Exception e) {
                if (im3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(xm3 xm3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, xm3Var, bdtls$Alert) == null) {
            if (im3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (xm3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (xm3Var.d() != null) {
                        i = xm3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (xm3Var.f() != null) {
                        i2 = xm3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (xm3Var.e() != null) {
                        i3 = xm3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (xm3Var.g() != null) {
                        i4 = xm3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (im3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    pa3 pa3Var = new pa3();
                    pa3Var.b = "alert";
                    pa3Var.e = str;
                    pa3Var.a("dh_group_id", Integer.valueOf(i));
                    pa3Var.a("dh_secret", Integer.valueOf(i2));
                    pa3Var.a("dh_pub_c", Integer.valueOf(i3));
                    pa3Var.a("dh_pub_s", Integer.valueOf(i4));
                    pa3Var.a("alert_msg", str2);
                    if (im3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    fa3.d(pa3Var);
                } catch (Exception e) {
                    if (im3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (im3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
