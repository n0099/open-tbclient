package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.BaseTextColor;
import tbclient.FeedContentColor;
import tbclient.FeedContentText;
/* loaded from: classes6.dex */
public final class ja7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final m87 a(BaseTextColor baseTextColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baseTextColor)) == null) {
            Intrinsics.checkNotNullParameter(baseTextColor, "<this>");
            Integer type = baseTextColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new m87(type.intValue(), baseTextColor.day, baseTextColor.night);
        }
        return (m87) invokeL.objValue;
    }

    public static final m87 b(FeedContentColor feedContentColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, feedContentColor)) == null) {
            Intrinsics.checkNotNullParameter(feedContentColor, "<this>");
            Integer type = feedContentColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new m87(type.intValue(), feedContentColor.day, feedContentColor.night);
        }
        return (m87) invokeL.objValue;
    }

    public static final y97 c(FeedContentText feedContentText) {
        InterceptResult invokeL;
        m87 m87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, feedContentText)) == null) {
            Intrinsics.checkNotNullParameter(feedContentText, "<this>");
            String str = feedContentText.text;
            if (str == null) {
                str = "";
            }
            FeedContentColor feedContentColor = feedContentText.color;
            m87 m87Var2 = null;
            if (feedContentColor != null) {
                m87Var = b(feedContentColor);
            } else {
                m87Var = null;
            }
            FeedContentColor feedContentColor2 = feedContentText.bg_color;
            if (feedContentColor2 != null) {
                m87Var2 = b(feedContentColor2);
            }
            return new y97(str, m87Var, m87Var2);
        }
        return (y97) invokeL.objValue;
    }
}
