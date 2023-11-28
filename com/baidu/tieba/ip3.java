package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ip3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (dp3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            sp3 m = jp3.l().m();
            if (m == null) {
                if (dp3.a) {
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
                if (dp3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                kd3 kd3Var = new kd3();
                kd3Var.b = str;
                kd3Var.a("dh_group_id", Integer.valueOf(i));
                kd3Var.a("dh_secret", Integer.valueOf(i2));
                kd3Var.a("dh_pub_c", Integer.valueOf(i3));
                kd3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (dp3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                ad3.d(kd3Var);
            } catch (Exception e) {
                if (dp3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(sp3 sp3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, sp3Var, bdtls$Alert) == null) {
            if (dp3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (sp3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (sp3Var.d() != null) {
                        i = sp3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (sp3Var.f() != null) {
                        i2 = sp3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (sp3Var.e() != null) {
                        i3 = sp3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (sp3Var.g() != null) {
                        i4 = sp3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (dp3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    kd3 kd3Var = new kd3();
                    kd3Var.b = "alert";
                    kd3Var.e = str;
                    kd3Var.a("dh_group_id", Integer.valueOf(i));
                    kd3Var.a("dh_secret", Integer.valueOf(i2));
                    kd3Var.a("dh_pub_c", Integer.valueOf(i3));
                    kd3Var.a("dh_pub_s", Integer.valueOf(i4));
                    kd3Var.a("alert_msg", str2);
                    if (dp3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    ad3.d(kd3Var);
                } catch (Exception e) {
                    if (dp3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (dp3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
