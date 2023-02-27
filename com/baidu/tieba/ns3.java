package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ns3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (is3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            xs3 m = os3.l().m();
            if (m == null) {
                if (is3.a) {
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
                if (is3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                pg3 pg3Var = new pg3();
                pg3Var.b = str;
                pg3Var.a("dh_group_id", Integer.valueOf(i));
                pg3Var.a("dh_secret", Integer.valueOf(i2));
                pg3Var.a("dh_pub_c", Integer.valueOf(i3));
                pg3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (is3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                fg3.d(pg3Var);
            } catch (Exception e) {
                if (is3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(xs3 xs3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, xs3Var, bdtls$Alert) == null) {
            if (is3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (xs3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (xs3Var.d() != null) {
                        i = xs3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (xs3Var.f() != null) {
                        i2 = xs3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (xs3Var.e() != null) {
                        i3 = xs3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (xs3Var.g() != null) {
                        i4 = xs3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (is3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    pg3 pg3Var = new pg3();
                    pg3Var.b = "alert";
                    pg3Var.e = str;
                    pg3Var.a("dh_group_id", Integer.valueOf(i));
                    pg3Var.a("dh_secret", Integer.valueOf(i2));
                    pg3Var.a("dh_pub_c", Integer.valueOf(i3));
                    pg3Var.a("dh_pub_s", Integer.valueOf(i4));
                    pg3Var.a("alert_msg", str2);
                    if (is3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    fg3.d(pg3Var);
                } catch (Exception e) {
                    if (is3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (is3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
