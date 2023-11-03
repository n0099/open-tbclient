package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Level;
/* loaded from: classes7.dex */
public class mzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Level level) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, level)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "props_id", level.props_id);
            poc.a(jSONObject, "props_type", level.props_type);
            poc.a(jSONObject, "props_category", level.props_category);
            poc.a(jSONObject, "end_time", level.end_time);
            poc.a(jSONObject, "left_num", level.left_num);
            poc.a(jSONObject, "update_time", level.update_time);
            poc.a(jSONObject, "used_status", level.used_status);
            poc.a(jSONObject, "open_status", level.open_status);
            poc.a(jSONObject, "expiring_notify", level.expiring_notify);
            poc.a(jSONObject, "expired_notify", level.expired_notify);
            poc.a(jSONObject, "max_free_score", level.max_free_score);
            poc.a(jSONObject, "pic_url", level.pic_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
