package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ShowIcon;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes8.dex */
public class u2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserInfo userInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", userInfo.user_id);
            ltc.a(jSONObject, "portrait", userInfo.portrait);
            ltc.a(jSONObject, "user_name", userInfo.user_name);
            ltc.a(jSONObject, "gender", userInfo.gender);
            ltc.a(jSONObject, "intro", userInfo.intro);
            ShowIcon showIcon = userInfo.tshow_icon;
            if (showIcon != null) {
                ltc.a(jSONObject, "tshow_icon", y1d.b(showIcon));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
