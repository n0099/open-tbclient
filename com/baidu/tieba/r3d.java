package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StarRankIcon;
/* loaded from: classes8.dex */
public class r3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarRankIcon starRankIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starRankIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon_pic_url", starRankIcon.icon_pic_url);
            qoc.a(jSONObject, "icon_link", starRankIcon.icon_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
