package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes8.dex */
public class suc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ColorEgg colorEgg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, colorEgg)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (colorEgg.holiday_words != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : colorEgg.holiday_words) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "holiday_words", jSONArray);
            }
            poc.a(jSONObject, "style_flag", colorEgg.style_flag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
