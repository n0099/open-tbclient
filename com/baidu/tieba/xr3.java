package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (sr3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            hs3 m = yr3.l().m();
            if (m == null) {
                if (sr3.a) {
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
                if (sr3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                zf3 zf3Var = new zf3();
                zf3Var.b = str;
                zf3Var.a("dh_group_id", Integer.valueOf(i));
                zf3Var.a("dh_secret", Integer.valueOf(i2));
                zf3Var.a("dh_pub_c", Integer.valueOf(i3));
                zf3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (sr3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                pf3.d(zf3Var);
            } catch (Exception e) {
                if (sr3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(hs3 hs3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, hs3Var, bdtls$Alert) == null) {
            if (sr3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (hs3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (hs3Var.d() != null) {
                        i = hs3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (hs3Var.f() != null) {
                        i2 = hs3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (hs3Var.e() != null) {
                        i3 = hs3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (hs3Var.g() != null) {
                        i4 = hs3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (sr3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    zf3 zf3Var = new zf3();
                    zf3Var.b = "alert";
                    zf3Var.e = str;
                    zf3Var.a("dh_group_id", Integer.valueOf(i));
                    zf3Var.a("dh_secret", Integer.valueOf(i2));
                    zf3Var.a("dh_pub_c", Integer.valueOf(i3));
                    zf3Var.a("dh_pub_s", Integer.valueOf(i4));
                    zf3Var.a("alert_msg", str2);
                    if (sr3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    pf3.d(zf3Var);
                } catch (Exception e) {
                    if (sr3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (sr3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
