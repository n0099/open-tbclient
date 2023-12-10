package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes9.dex */
public class xyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActivityConfig activityConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activityConfig)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", activityConfig.type);
            ltc.a(jSONObject, "agree_icon", activityConfig.agree_icon);
            ltc.a(jSONObject, "night_agree_icon", activityConfig.night_agree_icon);
            ltc.a(jSONObject, "agreed_icon", activityConfig.agreed_icon);
            ltc.a(jSONObject, "night_agreed_icon", activityConfig.night_agreed_icon);
            ltc.a(jSONObject, "activity_id", activityConfig.activity_id);
            ltc.a(jSONObject, "addthread_icon", activityConfig.addthread_icon);
            ltc.a(jSONObject, "night_addthread_icon", activityConfig.night_addthread_icon);
            ltc.a(jSONObject, "addthread_text", activityConfig.addthread_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
