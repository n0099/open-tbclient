package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BaseTextColor;
import tbclient.FeedHeadText;
/* loaded from: classes8.dex */
public class rsc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadText feedHeadText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadText)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", feedHeadText.text);
            poc.a(jSONObject, "priority", feedHeadText.priority);
            poc.a(jSONObject, "can_degrade", feedHeadText.can_degrade);
            poc.a(jSONObject, "degrade_len", feedHeadText.degrade_len);
            poc.a(jSONObject, "degrade_priority", feedHeadText.degrade_priority);
            poc.a(jSONObject, "suffix", feedHeadText.suffix);
            poc.a(jSONObject, "type", feedHeadText.type);
            BaseTextColor baseTextColor = feedHeadText.color;
            if (baseTextColor != null) {
                poc.a(jSONObject, "color", gqc.b(baseTextColor));
            }
            BaseTextColor baseTextColor2 = feedHeadText.bg_color;
            if (baseTextColor2 != null) {
                poc.a(jSONObject, "bg_color", gqc.b(baseTextColor2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
