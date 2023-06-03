package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (uu3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            jv3 m = av3.l().m();
            if (m == null) {
                if (uu3.a) {
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
                if (uu3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                bj3 bj3Var = new bj3();
                bj3Var.b = str;
                bj3Var.a("dh_group_id", Integer.valueOf(i));
                bj3Var.a("dh_secret", Integer.valueOf(i2));
                bj3Var.a("dh_pub_c", Integer.valueOf(i3));
                bj3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (uu3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                ri3.d(bj3Var);
            } catch (Exception e) {
                if (uu3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(jv3 jv3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, jv3Var, bdtls$Alert) == null) {
            if (uu3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (jv3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (jv3Var.d() != null) {
                        i = jv3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (jv3Var.f() != null) {
                        i2 = jv3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (jv3Var.e() != null) {
                        i3 = jv3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (jv3Var.g() != null) {
                        i4 = jv3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (uu3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    bj3 bj3Var = new bj3();
                    bj3Var.b = "alert";
                    bj3Var.e = str;
                    bj3Var.a("dh_group_id", Integer.valueOf(i));
                    bj3Var.a("dh_secret", Integer.valueOf(i2));
                    bj3Var.a("dh_pub_c", Integer.valueOf(i3));
                    bj3Var.a("dh_pub_s", Integer.valueOf(i4));
                    bj3Var.a("alert_msg", str2);
                    if (uu3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    ri3.d(bj3Var);
                } catch (Exception e) {
                    if (uu3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (uu3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
