package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class sf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void a(dg9 dg9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, dg9Var) == null) && dg9Var != null && !dg9Var.y()) {
            JSONArray n = dg9Var.n();
            int length = n.length();
            boolean B = dg9Var.B();
            for (int i = 0; i < length; i++) {
                try {
                    if (B != ye9.o().e(n.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + B + "  content " + dg9Var.u().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
