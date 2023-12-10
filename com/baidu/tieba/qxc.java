package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BaseTextColor;
import tbclient.FeedHeadText;
/* loaded from: classes8.dex */
public class qxc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadText feedHeadText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadText)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "text", feedHeadText.text);
            ltc.a(jSONObject, "priority", feedHeadText.priority);
            ltc.a(jSONObject, "can_degrade", feedHeadText.can_degrade);
            ltc.a(jSONObject, "degrade_len", feedHeadText.degrade_len);
            ltc.a(jSONObject, "degrade_priority", feedHeadText.degrade_priority);
            ltc.a(jSONObject, "suffix", feedHeadText.suffix);
            ltc.a(jSONObject, "type", feedHeadText.type);
            BaseTextColor baseTextColor = feedHeadText.color;
            if (baseTextColor != null) {
                ltc.a(jSONObject, "color", evc.b(baseTextColor));
            }
            BaseTextColor baseTextColor2 = feedHeadText.bg_color;
            if (baseTextColor2 != null) {
                ltc.a(jSONObject, "bg_color", evc.b(baseTextColor2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
