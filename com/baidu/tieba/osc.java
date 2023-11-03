package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedHeadIcon;
/* loaded from: classes7.dex */
public class osc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadIcon feedHeadIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "url", feedHeadIcon.url);
            poc.a(jSONObject, "width", feedHeadIcon.width);
            poc.a(jSONObject, "height", feedHeadIcon.height);
            poc.a(jSONObject, "priority", feedHeadIcon.priority);
            poc.a(jSONObject, "can_degrade", feedHeadIcon.can_degrade);
            poc.a(jSONObject, "degrade_url", feedHeadIcon.degrade_url);
            poc.a(jSONObject, "degrade_width", feedHeadIcon.degrade_width);
            poc.a(jSONObject, "degrade_height", feedHeadIcon.degrade_height);
            poc.a(jSONObject, "degrade_priority", feedHeadIcon.degrade_priority);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
