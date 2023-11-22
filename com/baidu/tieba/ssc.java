package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BaseTextColor;
import tbclient.FeedHeadText;
/* loaded from: classes8.dex */
public class ssc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadText feedHeadText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadText)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "text", feedHeadText.text);
            qoc.a(jSONObject, "priority", feedHeadText.priority);
            qoc.a(jSONObject, "can_degrade", feedHeadText.can_degrade);
            qoc.a(jSONObject, "degrade_len", feedHeadText.degrade_len);
            qoc.a(jSONObject, "degrade_priority", feedHeadText.degrade_priority);
            qoc.a(jSONObject, "suffix", feedHeadText.suffix);
            qoc.a(jSONObject, "type", feedHeadText.type);
            BaseTextColor baseTextColor = feedHeadText.color;
            if (baseTextColor != null) {
                qoc.a(jSONObject, "color", hqc.b(baseTextColor));
            }
            BaseTextColor baseTextColor2 = feedHeadText.bg_color;
            if (baseTextColor2 != null) {
                qoc.a(jSONObject, "bg_color", hqc.b(baseTextColor2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
