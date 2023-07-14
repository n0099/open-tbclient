package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class l3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void a(w3b w3bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, w3bVar) == null) && w3bVar != null && !w3bVar.y()) {
            JSONArray n = w3bVar.n();
            int length = n.length();
            boolean B = w3bVar.B();
            for (int i = 0; i < length; i++) {
                try {
                    if (B != r2b.o().e(n.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + B + "  content " + w3bVar.u().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
