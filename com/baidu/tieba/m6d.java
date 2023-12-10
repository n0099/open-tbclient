package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PluginUser;
/* loaded from: classes7.dex */
public class m6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PluginUser pluginUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pluginUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", pluginUser.user_id);
            ltc.a(jSONObject, "user_name_show", pluginUser.user_name_show);
            ltc.a(jSONObject, "user_type", pluginUser.user_type);
            ltc.a(jSONObject, "user_photo", pluginUser.user_photo);
            ltc.a(jSONObject, "is_download_card_whiteuser", pluginUser.is_download_card_whiteuser);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
