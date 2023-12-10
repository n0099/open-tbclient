package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Props;
/* loaded from: classes9.dex */
public class y6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Props props) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, props)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", props.props_id);
            ltc.a(jSONObject, "props_type", props.props_type);
            ltc.a(jSONObject, "props_category", props.props_category);
            ltc.a(jSONObject, "left_num", props.left_num);
            ltc.a(jSONObject, "used_status", props.used_status);
            ltc.a(jSONObject, "num", props.num);
            ltc.a(jSONObject, "end_time", props.end_time);
            ltc.a(jSONObject, "notice", props.notice);
            ltc.a(jSONObject, "update_time", props.update_time);
            ltc.a(jSONObject, "open_status", props.open_status);
            ltc.a(jSONObject, "expiring_notify", props.expiring_notify);
            ltc.a(jSONObject, "expired_notify", props.expired_notify);
            ltc.a(jSONObject, "title", props.title);
            if (props._word != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : props._word) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "_word", jSONArray);
            }
            if (props.pattern != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : props.pattern) {
                    jSONArray2.put(str2);
                }
                ltc.a(jSONObject, "pattern", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
