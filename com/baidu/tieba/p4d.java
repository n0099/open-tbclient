package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Level;
/* loaded from: classes7.dex */
public class p4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Level level) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, level)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "props_id", level.props_id);
            ktc.a(jSONObject, "props_type", level.props_type);
            ktc.a(jSONObject, "props_category", level.props_category);
            ktc.a(jSONObject, "end_time", level.end_time);
            ktc.a(jSONObject, "left_num", level.left_num);
            ktc.a(jSONObject, "update_time", level.update_time);
            ktc.a(jSONObject, "used_status", level.used_status);
            ktc.a(jSONObject, "open_status", level.open_status);
            ktc.a(jSONObject, "expiring_notify", level.expiring_notify);
            ktc.a(jSONObject, "expired_notify", level.expired_notify);
            ktc.a(jSONObject, "max_free_score", level.max_free_score);
            ktc.a(jSONObject, "pic_url", level.pic_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
