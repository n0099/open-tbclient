package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RedpacketRain;
/* loaded from: classes7.dex */
public class m2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RedpacketRain redpacketRain) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, redpacketRain)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "start_time", redpacketRain.start_time);
            poc.a(jSONObject, "end_time", redpacketRain.end_time);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, redpacketRain.jump_url);
            poc.a(jSONObject, "float_url", redpacketRain.float_url);
            if (redpacketRain.dynamic_img != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : redpacketRain.dynamic_img) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "dynamic_img", jSONArray);
            }
            poc.a(jSONObject, "activity_id", redpacketRain.activity_id);
            poc.a(jSONObject, "show_type", redpacketRain.show_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
