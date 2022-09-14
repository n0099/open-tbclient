package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (ul3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            jm3 m = am3.l().m();
            if (m == null) {
                if (ul3.a) {
                    Log.d("BDTLS", "bdtls ubc data is null");
                    return;
                }
                return;
            }
            try {
                int intValue = m.d() != null ? m.d().intValue() : -1;
                int intValue2 = m.f() != null ? m.f().intValue() : -1;
                int intValue3 = m.e() != null ? m.e().intValue() : -1;
                int intValue4 = m.g() != null ? m.g().intValue() : -1;
                if (ul3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                ba3 ba3Var = new ba3();
                ba3Var.b = str;
                ba3Var.a("dh_group_id", Integer.valueOf(intValue));
                ba3Var.a("dh_secret", Integer.valueOf(intValue2));
                ba3Var.a("dh_pub_c", Integer.valueOf(intValue3));
                ba3Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (ul3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                r93.d(ba3Var);
            } catch (Exception e) {
                if (ul3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(jm3 jm3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, jm3Var, bdtls$Alert) == null) {
            if (ul3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (jm3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = jm3Var.d() != null ? jm3Var.d().intValue() : -1;
                    int intValue2 = jm3Var.f() != null ? jm3Var.f().intValue() : -1;
                    int intValue3 = jm3Var.e() != null ? jm3Var.e().intValue() : -1;
                    int intValue4 = jm3Var.g() != null ? jm3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (ul3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    ba3 ba3Var = new ba3();
                    ba3Var.b = "alert";
                    ba3Var.e = str;
                    ba3Var.a("dh_group_id", Integer.valueOf(intValue));
                    ba3Var.a("dh_secret", Integer.valueOf(intValue2));
                    ba3Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    ba3Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    ba3Var.a("alert_msg", str2);
                    if (ul3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    r93.d(ba3Var);
                } catch (Exception e) {
                    if (ul3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (ul3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
