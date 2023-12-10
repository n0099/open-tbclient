package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Level;
/* loaded from: classes7.dex */
public class q4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Level level) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, level)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", level.props_id);
            ltc.a(jSONObject, "props_type", level.props_type);
            ltc.a(jSONObject, "props_category", level.props_category);
            ltc.a(jSONObject, "end_time", level.end_time);
            ltc.a(jSONObject, "left_num", level.left_num);
            ltc.a(jSONObject, "update_time", level.update_time);
            ltc.a(jSONObject, "used_status", level.used_status);
            ltc.a(jSONObject, "open_status", level.open_status);
            ltc.a(jSONObject, "expiring_notify", level.expiring_notify);
            ltc.a(jSONObject, "expired_notify", level.expired_notify);
            ltc.a(jSONObject, "max_free_score", level.max_free_score);
            ltc.a(jSONObject, "pic_url", level.pic_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
