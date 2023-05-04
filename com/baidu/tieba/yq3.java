package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (tq3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            ir3 m = zq3.l().m();
            if (m == null) {
                if (tq3.a) {
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
                if (tq3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                af3 af3Var = new af3();
                af3Var.b = str;
                af3Var.a("dh_group_id", Integer.valueOf(i));
                af3Var.a("dh_secret", Integer.valueOf(i2));
                af3Var.a("dh_pub_c", Integer.valueOf(i3));
                af3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (tq3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                qe3.d(af3Var);
            } catch (Exception e) {
                if (tq3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(ir3 ir3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ir3Var, bdtls$Alert) == null) {
            if (tq3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (ir3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (ir3Var.d() != null) {
                        i = ir3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (ir3Var.f() != null) {
                        i2 = ir3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (ir3Var.e() != null) {
                        i3 = ir3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (ir3Var.g() != null) {
                        i4 = ir3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (tq3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    af3 af3Var = new af3();
                    af3Var.b = "alert";
                    af3Var.e = str;
                    af3Var.a("dh_group_id", Integer.valueOf(i));
                    af3Var.a("dh_secret", Integer.valueOf(i2));
                    af3Var.a("dh_pub_c", Integer.valueOf(i3));
                    af3Var.a("dh_pub_s", Integer.valueOf(i4));
                    af3Var.a("alert_msg", str2);
                    if (tq3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    qe3.d(af3Var);
                } catch (Exception e) {
                    if (tq3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (tq3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
