package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (gp3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            vp3 m = mp3.l().m();
            if (m == null) {
                if (gp3.a) {
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
                if (gp3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                nd3 nd3Var = new nd3();
                nd3Var.b = str;
                nd3Var.a("dh_group_id", Integer.valueOf(i));
                nd3Var.a("dh_secret", Integer.valueOf(i2));
                nd3Var.a("dh_pub_c", Integer.valueOf(i3));
                nd3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (gp3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                dd3.d(nd3Var);
            } catch (Exception e) {
                if (gp3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(vp3 vp3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vp3Var, bdtls$Alert) == null) {
            if (gp3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (vp3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (vp3Var.d() != null) {
                        i = vp3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (vp3Var.f() != null) {
                        i2 = vp3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (vp3Var.e() != null) {
                        i3 = vp3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (vp3Var.g() != null) {
                        i4 = vp3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (gp3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    nd3 nd3Var = new nd3();
                    nd3Var.b = "alert";
                    nd3Var.e = str;
                    nd3Var.a("dh_group_id", Integer.valueOf(i));
                    nd3Var.a("dh_secret", Integer.valueOf(i2));
                    nd3Var.a("dh_pub_c", Integer.valueOf(i3));
                    nd3Var.a("dh_pub_s", Integer.valueOf(i4));
                    nd3Var.a("alert_msg", str2);
                    if (gp3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    dd3.d(nd3Var);
                } catch (Exception e) {
                    if (gp3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (gp3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
