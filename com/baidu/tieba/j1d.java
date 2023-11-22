package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PluginUser;
/* loaded from: classes6.dex */
public class j1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PluginUser pluginUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pluginUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", pluginUser.user_id);
            qoc.a(jSONObject, "user_name_show", pluginUser.user_name_show);
            qoc.a(jSONObject, "user_type", pluginUser.user_type);
            qoc.a(jSONObject, "user_photo", pluginUser.user_photo);
            qoc.a(jSONObject, "is_download_card_whiteuser", pluginUser.is_download_card_whiteuser);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
