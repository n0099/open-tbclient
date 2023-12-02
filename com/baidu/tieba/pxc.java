package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BaseTextColor;
import tbclient.FeedHeadText;
/* loaded from: classes7.dex */
public class pxc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadText feedHeadText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadText)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "text", feedHeadText.text);
            ktc.a(jSONObject, "priority", feedHeadText.priority);
            ktc.a(jSONObject, "can_degrade", feedHeadText.can_degrade);
            ktc.a(jSONObject, "degrade_len", feedHeadText.degrade_len);
            ktc.a(jSONObject, "degrade_priority", feedHeadText.degrade_priority);
            ktc.a(jSONObject, "suffix", feedHeadText.suffix);
            ktc.a(jSONObject, "type", feedHeadText.type);
            BaseTextColor baseTextColor = feedHeadText.color;
            if (baseTextColor != null) {
                ktc.a(jSONObject, "color", dvc.b(baseTextColor));
            }
            BaseTextColor baseTextColor2 = feedHeadText.bg_color;
            if (baseTextColor2 != null) {
                ktc.a(jSONObject, "bg_color", dvc.b(baseTextColor2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
