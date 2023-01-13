package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (fn3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            un3 m = ln3.l().m();
            if (m == null) {
                if (fn3.a) {
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
                if (fn3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                mb3 mb3Var = new mb3();
                mb3Var.b = str;
                mb3Var.a("dh_group_id", Integer.valueOf(i));
                mb3Var.a("dh_secret", Integer.valueOf(i2));
                mb3Var.a("dh_pub_c", Integer.valueOf(i3));
                mb3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (fn3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                cb3.d(mb3Var);
            } catch (Exception e) {
                if (fn3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(un3 un3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, un3Var, bdtls$Alert) == null) {
            if (fn3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (un3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (un3Var.d() != null) {
                        i = un3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (un3Var.f() != null) {
                        i2 = un3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (un3Var.e() != null) {
                        i3 = un3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (un3Var.g() != null) {
                        i4 = un3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (fn3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    mb3 mb3Var = new mb3();
                    mb3Var.b = "alert";
                    mb3Var.e = str;
                    mb3Var.a("dh_group_id", Integer.valueOf(i));
                    mb3Var.a("dh_secret", Integer.valueOf(i2));
                    mb3Var.a("dh_pub_c", Integer.valueOf(i3));
                    mb3Var.a("dh_pub_s", Integer.valueOf(i4));
                    mb3Var.a("alert_msg", str2);
                    if (fn3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    cb3.d(mb3Var);
                } catch (Exception e) {
                    if (fn3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (fn3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
