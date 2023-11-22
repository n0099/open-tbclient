package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Props;
/* loaded from: classes8.dex */
public class v1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Props props) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, props)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "props_id", props.props_id);
            qoc.a(jSONObject, "props_type", props.props_type);
            qoc.a(jSONObject, "props_category", props.props_category);
            qoc.a(jSONObject, "left_num", props.left_num);
            qoc.a(jSONObject, "used_status", props.used_status);
            qoc.a(jSONObject, "num", props.num);
            qoc.a(jSONObject, "end_time", props.end_time);
            qoc.a(jSONObject, "notice", props.notice);
            qoc.a(jSONObject, "update_time", props.update_time);
            qoc.a(jSONObject, "open_status", props.open_status);
            qoc.a(jSONObject, "expiring_notify", props.expiring_notify);
            qoc.a(jSONObject, "expired_notify", props.expired_notify);
            qoc.a(jSONObject, "title", props.title);
            if (props._word != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : props._word) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "_word", jSONArray);
            }
            if (props.pattern != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : props.pattern) {
                    jSONArray2.put(str2);
                }
                qoc.a(jSONObject, "pattern", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
