package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (du3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            su3 m = ju3.l().m();
            if (m == null) {
                if (du3.a) {
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
                if (du3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                ki3 ki3Var = new ki3();
                ki3Var.b = str;
                ki3Var.a("dh_group_id", Integer.valueOf(i));
                ki3Var.a("dh_secret", Integer.valueOf(i2));
                ki3Var.a("dh_pub_c", Integer.valueOf(i3));
                ki3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (du3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                ai3.d(ki3Var);
            } catch (Exception e) {
                if (du3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(su3 su3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, su3Var, bdtls$Alert) == null) {
            if (du3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (su3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (su3Var.d() != null) {
                        i = su3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (su3Var.f() != null) {
                        i2 = su3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (su3Var.e() != null) {
                        i3 = su3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (su3Var.g() != null) {
                        i4 = su3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (du3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    ki3 ki3Var = new ki3();
                    ki3Var.b = "alert";
                    ki3Var.e = str;
                    ki3Var.a("dh_group_id", Integer.valueOf(i));
                    ki3Var.a("dh_secret", Integer.valueOf(i2));
                    ki3Var.a("dh_pub_c", Integer.valueOf(i3));
                    ki3Var.a("dh_pub_s", Integer.valueOf(i4));
                    ki3Var.a("alert_msg", str2);
                    if (du3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    ai3.d(ki3Var);
                } catch (Exception e) {
                    if (du3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (du3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
