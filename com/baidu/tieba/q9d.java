package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeBackgroundInUser;
/* loaded from: classes7.dex */
public class q9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeBackgroundInUser themeBackgroundInUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeBackgroundInUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", themeBackgroundInUser.props_id);
            ltc.a(jSONObject, "exclusive_no", themeBackgroundInUser.exclusive_no);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, themeBackgroundInUser.jump_url);
            ltc.a(jSONObject, PraiseUBCHelper.SOURCE_DYNAMIC, themeBackgroundInUser.dynamic);
            ltc.a(jSONObject, "package_name", themeBackgroundInUser.package_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
