package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (ut3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            ju3 m = au3.l().m();
            if (m == null) {
                if (ut3.a) {
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
                if (ut3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                bi3 bi3Var = new bi3();
                bi3Var.b = str;
                bi3Var.a("dh_group_id", Integer.valueOf(i));
                bi3Var.a("dh_secret", Integer.valueOf(i2));
                bi3Var.a("dh_pub_c", Integer.valueOf(i3));
                bi3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (ut3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                rh3.d(bi3Var);
            } catch (Exception e) {
                if (ut3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(ju3 ju3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ju3Var, bdtls$Alert) == null) {
            if (ut3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (ju3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (ju3Var.d() != null) {
                        i = ju3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (ju3Var.f() != null) {
                        i2 = ju3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (ju3Var.e() != null) {
                        i3 = ju3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (ju3Var.g() != null) {
                        i4 = ju3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (ut3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    bi3 bi3Var = new bi3();
                    bi3Var.b = "alert";
                    bi3Var.e = str;
                    bi3Var.a("dh_group_id", Integer.valueOf(i));
                    bi3Var.a("dh_secret", Integer.valueOf(i2));
                    bi3Var.a("dh_pub_c", Integer.valueOf(i3));
                    bi3Var.a("dh_pub_s", Integer.valueOf(i4));
                    bi3Var.a("alert_msg", str2);
                    if (ut3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    rh3.d(bi3Var);
                } catch (Exception e) {
                    if (ut3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (ut3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
