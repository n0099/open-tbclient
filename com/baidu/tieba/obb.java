package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class obb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void a(zbb zbbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, zbbVar) == null) && zbbVar != null && !zbbVar.y()) {
            JSONArray n = zbbVar.n();
            int length = n.length();
            boolean B = zbbVar.B();
            for (int i = 0; i < length; i++) {
                try {
                    if (B != uab.o().e(n.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + B + "  content " + zbbVar.u().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
