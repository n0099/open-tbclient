package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (lo3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            ap3 m = ro3.l().m();
            if (m == null) {
                if (lo3.a) {
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
                if (lo3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                sc3 sc3Var = new sc3();
                sc3Var.b = str;
                sc3Var.a("dh_group_id", Integer.valueOf(i));
                sc3Var.a("dh_secret", Integer.valueOf(i2));
                sc3Var.a("dh_pub_c", Integer.valueOf(i3));
                sc3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (lo3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                ic3.d(sc3Var);
            } catch (Exception e) {
                if (lo3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(ap3 ap3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ap3Var, bdtls$Alert) == null) {
            if (lo3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (ap3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (ap3Var.d() != null) {
                        i = ap3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (ap3Var.f() != null) {
                        i2 = ap3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (ap3Var.e() != null) {
                        i3 = ap3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (ap3Var.g() != null) {
                        i4 = ap3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (lo3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    sc3 sc3Var = new sc3();
                    sc3Var.b = "alert";
                    sc3Var.e = str;
                    sc3Var.a("dh_group_id", Integer.valueOf(i));
                    sc3Var.a("dh_secret", Integer.valueOf(i2));
                    sc3Var.a("dh_pub_c", Integer.valueOf(i3));
                    sc3Var.a("dh_pub_s", Integer.valueOf(i4));
                    sc3Var.a("alert_msg", str2);
                    if (lo3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    ic3.d(sc3Var);
                } catch (Exception e) {
                    if (lo3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (lo3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
