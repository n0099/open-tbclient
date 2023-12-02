package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeCardInUser;
/* loaded from: classes8.dex */
public class r9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeCardInUser themeCardInUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeCardInUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "props_id", themeCardInUser.props_id);
            ktc.a(jSONObject, "img_ios", themeCardInUser.img_ios);
            ktc.a(jSONObject, "coordinate", themeCardInUser.coordinate);
            ktc.a(jSONObject, "img_android", themeCardInUser.img_android);
            ktc.a(jSONObject, "level", themeCardInUser.level);
            ktc.a(jSONObject, "dynamic_url", themeCardInUser.dynamic_url);
            ktc.a(jSONObject, "exclusive_no", themeCardInUser.exclusive_no);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, themeCardInUser.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
