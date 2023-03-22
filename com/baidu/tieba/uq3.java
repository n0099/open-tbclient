package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (pq3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            er3 m = vq3.l().m();
            if (m == null) {
                if (pq3.a) {
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
                if (pq3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                we3 we3Var = new we3();
                we3Var.b = str;
                we3Var.a("dh_group_id", Integer.valueOf(i));
                we3Var.a("dh_secret", Integer.valueOf(i2));
                we3Var.a("dh_pub_c", Integer.valueOf(i3));
                we3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (pq3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                me3.d(we3Var);
            } catch (Exception e) {
                if (pq3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(er3 er3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, er3Var, bdtls$Alert) == null) {
            if (pq3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (er3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (er3Var.d() != null) {
                        i = er3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (er3Var.f() != null) {
                        i2 = er3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (er3Var.e() != null) {
                        i3 = er3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (er3Var.g() != null) {
                        i4 = er3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (pq3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    we3 we3Var = new we3();
                    we3Var.b = "alert";
                    we3Var.e = str;
                    we3Var.a("dh_group_id", Integer.valueOf(i));
                    we3Var.a("dh_secret", Integer.valueOf(i2));
                    we3Var.a("dh_pub_c", Integer.valueOf(i3));
                    we3Var.a("dh_pub_s", Integer.valueOf(i4));
                    we3Var.a("alert_msg", str2);
                    if (pq3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    me3.d(we3Var);
                } catch (Exception e) {
                    if (pq3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (pq3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
