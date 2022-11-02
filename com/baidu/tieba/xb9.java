package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class xb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void a(ic9 ic9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ic9Var) == null) && ic9Var != null && !ic9Var.y()) {
            JSONArray n = ic9Var.n();
            int length = n.length();
            boolean B = ic9Var.B();
            for (int i = 0; i < length; i++) {
                try {
                    if (B != db9.o().e(n.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + B + "  content " + ic9Var.u().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
