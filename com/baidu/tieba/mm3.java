package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (hm3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            wm3 m = nm3.l().m();
            if (m == null) {
                if (hm3.a) {
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
                if (hm3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                oa3 oa3Var = new oa3();
                oa3Var.b = str;
                oa3Var.a("dh_group_id", Integer.valueOf(intValue));
                oa3Var.a("dh_secret", Integer.valueOf(intValue2));
                oa3Var.a("dh_pub_c", Integer.valueOf(intValue3));
                oa3Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (hm3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                ea3.d(oa3Var);
            } catch (Exception e) {
                if (hm3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(wm3 wm3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, wm3Var, bdtls$Alert) == null) {
            if (hm3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (wm3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = wm3Var.d() != null ? wm3Var.d().intValue() : -1;
                    int intValue2 = wm3Var.f() != null ? wm3Var.f().intValue() : -1;
                    int intValue3 = wm3Var.e() != null ? wm3Var.e().intValue() : -1;
                    int intValue4 = wm3Var.g() != null ? wm3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (hm3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    oa3 oa3Var = new oa3();
                    oa3Var.b = "alert";
                    oa3Var.e = str;
                    oa3Var.a("dh_group_id", Integer.valueOf(intValue));
                    oa3Var.a("dh_secret", Integer.valueOf(intValue2));
                    oa3Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    oa3Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    oa3Var.a("alert_msg", str2);
                    if (hm3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    ea3.d(oa3Var);
                } catch (Exception e) {
                    if (hm3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (hm3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
