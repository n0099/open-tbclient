package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class w99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ha9 ha9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, ha9Var) == null) || ha9Var == null || ha9Var.y()) {
            return;
        }
        JSONArray n = ha9Var.n();
        int length = n.length();
        boolean B = ha9Var.B();
        for (int i = 0; i < length; i++) {
            try {
                if (B != c99.o().e(n.getJSONObject(i).getString("id"))) {
                    Log.w("UBCDebug", " data is " + B + "  content " + ha9Var.u().toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }
}
