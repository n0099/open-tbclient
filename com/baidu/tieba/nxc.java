package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedHeadIcon;
/* loaded from: classes7.dex */
public class nxc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadIcon feedHeadIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "url", feedHeadIcon.url);
            ltc.a(jSONObject, "width", feedHeadIcon.width);
            ltc.a(jSONObject, "height", feedHeadIcon.height);
            ltc.a(jSONObject, "priority", feedHeadIcon.priority);
            ltc.a(jSONObject, "can_degrade", feedHeadIcon.can_degrade);
            ltc.a(jSONObject, "degrade_url", feedHeadIcon.degrade_url);
            ltc.a(jSONObject, "degrade_width", feedHeadIcon.degrade_width);
            ltc.a(jSONObject, "degrade_height", feedHeadIcon.degrade_height);
            ltc.a(jSONObject, "degrade_priority", feedHeadIcon.degrade_priority);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
