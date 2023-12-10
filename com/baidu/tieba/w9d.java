package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeTailInUser;
/* loaded from: classes8.dex */
public class w9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeTailInUser themeTailInUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeTailInUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "url", themeTailInUser.url);
            ltc.a(jSONObject, PraiseUBCHelper.SOURCE_DYNAMIC, themeTailInUser.dynamic);
            ltc.a(jSONObject, "props_id", themeTailInUser.props_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
