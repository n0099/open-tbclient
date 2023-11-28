package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.NaGuide;
import tbclient.RecGuide;
/* loaded from: classes6.dex */
public class j5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NaGuide naGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, naGuide)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "dwnl_url", naGuide.dwnl_url);
            if (naGuide.rec_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (RecGuide recGuide : naGuide.rec_info) {
                    jSONArray.put(k7d.b(recGuide));
                }
                ltc.a(jSONObject, "rec_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
