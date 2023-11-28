package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeCardInUser;
/* loaded from: classes8.dex */
public class s9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeCardInUser themeCardInUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeCardInUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", themeCardInUser.props_id);
            ltc.a(jSONObject, "img_ios", themeCardInUser.img_ios);
            ltc.a(jSONObject, "coordinate", themeCardInUser.coordinate);
            ltc.a(jSONObject, "img_android", themeCardInUser.img_android);
            ltc.a(jSONObject, "level", themeCardInUser.level);
            ltc.a(jSONObject, "dynamic_url", themeCardInUser.dynamic_url);
            ltc.a(jSONObject, "exclusive_no", themeCardInUser.exclusive_no);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, themeCardInUser.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
