package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (rq3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            gr3 m = xq3.l().m();
            if (m == null) {
                if (rq3.a) {
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
                if (rq3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                ye3 ye3Var = new ye3();
                ye3Var.b = str;
                ye3Var.a("dh_group_id", Integer.valueOf(i));
                ye3Var.a("dh_secret", Integer.valueOf(i2));
                ye3Var.a("dh_pub_c", Integer.valueOf(i3));
                ye3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (rq3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                oe3.d(ye3Var);
            } catch (Exception e) {
                if (rq3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(gr3 gr3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, gr3Var, bdtls$Alert) == null) {
            if (rq3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (gr3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (gr3Var.d() != null) {
                        i = gr3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (gr3Var.f() != null) {
                        i2 = gr3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (gr3Var.e() != null) {
                        i3 = gr3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (gr3Var.g() != null) {
                        i4 = gr3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (rq3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    ye3 ye3Var = new ye3();
                    ye3Var.b = "alert";
                    ye3Var.e = str;
                    ye3Var.a("dh_group_id", Integer.valueOf(i));
                    ye3Var.a("dh_secret", Integer.valueOf(i2));
                    ye3Var.a("dh_pub_c", Integer.valueOf(i3));
                    ye3Var.a("dh_pub_s", Integer.valueOf(i4));
                    ye3Var.a("alert_msg", str2);
                    if (rq3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    oe3.d(ye3Var);
                } catch (Exception e) {
                    if (rq3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (rq3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
