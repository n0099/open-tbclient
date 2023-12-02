package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PluginUser;
/* loaded from: classes7.dex */
public class l6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PluginUser pluginUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pluginUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "user_id", pluginUser.user_id);
            ktc.a(jSONObject, "user_name_show", pluginUser.user_name_show);
            ktc.a(jSONObject, "user_type", pluginUser.user_type);
            ktc.a(jSONObject, "user_photo", pluginUser.user_photo);
            ktc.a(jSONObject, "is_download_card_whiteuser", pluginUser.is_download_card_whiteuser);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
