package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TabSkin;
/* loaded from: classes6.dex */
public class ixc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TabSkin tabSkin) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tabSkin)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "tab_id", tabSkin.tab_id);
            qoc.a(jSONObject, "icon", tabSkin.icon);
            qoc.a(jSONObject, "icon_night", tabSkin.icon_night);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
