package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ShowIcon;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes8.dex */
public class rxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserInfo userInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", userInfo.user_id);
            qoc.a(jSONObject, "portrait", userInfo.portrait);
            qoc.a(jSONObject, "user_name", userInfo.user_name);
            qoc.a(jSONObject, "gender", userInfo.gender);
            qoc.a(jSONObject, "intro", userInfo.intro);
            ShowIcon showIcon = userInfo.tshow_icon;
            if (showIcon != null) {
                qoc.a(jSONObject, "tshow_icon", xwc.b(showIcon));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
