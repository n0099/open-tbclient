package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Props;
/* loaded from: classes8.dex */
public class u1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Props props) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, props)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "props_id", props.props_id);
            poc.a(jSONObject, "props_type", props.props_type);
            poc.a(jSONObject, "props_category", props.props_category);
            poc.a(jSONObject, "left_num", props.left_num);
            poc.a(jSONObject, "used_status", props.used_status);
            poc.a(jSONObject, "num", props.num);
            poc.a(jSONObject, "end_time", props.end_time);
            poc.a(jSONObject, "notice", props.notice);
            poc.a(jSONObject, "update_time", props.update_time);
            poc.a(jSONObject, "open_status", props.open_status);
            poc.a(jSONObject, "expiring_notify", props.expiring_notify);
            poc.a(jSONObject, "expired_notify", props.expired_notify);
            poc.a(jSONObject, "title", props.title);
            if (props._word != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : props._word) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "_word", jSONArray);
            }
            if (props.pattern != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : props.pattern) {
                    jSONArray2.put(str2);
                }
                poc.a(jSONObject, "pattern", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
