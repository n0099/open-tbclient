package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.YulePostActivity;
/* loaded from: classes8.dex */
public class sbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull YulePostActivity yulePostActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yulePostActivity)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "start_time", yulePostActivity.start_time);
            ltc.a(jSONObject, "end_time", yulePostActivity.end_time);
            ltc.a(jSONObject, "activity_banner", yulePostActivity.activity_banner);
            ltc.a(jSONObject, "activity_url", yulePostActivity.activity_url);
            ltc.a(jSONObject, "activity_desc", yulePostActivity.activity_desc);
            ltc.a(jSONObject, "activity_button", yulePostActivity.activity_button);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
