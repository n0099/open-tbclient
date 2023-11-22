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
public class n2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RedpacketRain redpacketRain) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, redpacketRain)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "start_time", redpacketRain.start_time);
            qoc.a(jSONObject, "end_time", redpacketRain.end_time);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, redpacketRain.jump_url);
            qoc.a(jSONObject, "float_url", redpacketRain.float_url);
            if (redpacketRain.dynamic_img != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : redpacketRain.dynamic_img) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "dynamic_img", jSONArray);
            }
            qoc.a(jSONObject, "activity_id", redpacketRain.activity_id);
            qoc.a(jSONObject, "show_type", redpacketRain.show_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
