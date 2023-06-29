package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import tbclient.BaseTextColor;
import tbclient.CustomState;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadFigure;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedHeadIcon;
import tbclient.FeedHeadImg;
import tbclient.FeedHeadSymbol;
import tbclient.FeedHeadText;
import tbclient.FeedKV;
/* loaded from: classes8.dex */
public final class w67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(List<FeedKV> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list != null) {
                for (FeedKV feedKV : list) {
                    if (feedKV != null) {
                        str = feedKV.key;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, "author_is_living")) {
                        return Intrinsics.areEqual(feedKV.value, "1");
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final String b(List<FeedKV> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list != null) {
                for (FeedKV feedKV : list) {
                    if (feedKV != null) {
                        str = feedKV.key;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, "user_id")) {
                        return feedKV.value;
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static final String d(String str) {
        InterceptResult invokeL;
        Long longOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null && (longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str)) != null) {
                long longValue = longOrNull.longValue() * 1000;
                String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(longValue);
                if (StringHelper.isThisYear(formatTimeForJustNow)) {
                    return StringHelper.getFormatTimeShort(longValue);
                }
                return formatTimeForJustNow;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final o57 h(FeedHeadFigure feedHeadFigure) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, feedHeadFigure)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadFigure, "<this>");
            String img_url = feedHeadFigure.img_url;
            if (Intrinsics.areEqual(feedHeadFigure.bg_type, "tone")) {
                i = 1;
            } else {
                i = 2;
            }
            String bg_value = feedHeadFigure.bg_value;
            String str = feedHeadFigure.corner_url;
            Intrinsics.checkNotNullExpressionValue(img_url, "img_url");
            Intrinsics.checkNotNullExpressionValue(bg_value, "bg_value");
            return new o57(img_url, bg_value, i, str);
        }
        return (o57) invokeL.objValue;
    }

    public static final String c(String str) {
        InterceptResult invokeL;
        Long longOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && (longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str)) != null) {
                return StringHelper.getFormatTimeForAlaCardCreate(longOrNull.longValue() * 1000);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final VirtualImageCustomState m(CustomState customState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, customState)) == null) {
            Intrinsics.checkNotNullParameter(customState, "<this>");
            VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
            virtualImageCustomState.parseProto(customState);
            return virtualImageCustomState;
        }
        return (VirtualImageCustomState) invokeL.objValue;
    }

    public static final void e(FeedHeadComponent feedHeadComponent, List<t87<?>> mutableList, m67 m67Var, m67 m67Var2, x57 x57Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{feedHeadComponent, mutableList, m67Var, m67Var2, x57Var, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(feedHeadComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            if (feedHeadComponent.image_data != null) {
                FeedHeadImg image_data = feedHeadComponent.image_data;
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                mutableList.add(new p47(new k57(g(image_data, z), j(feedHeadComponent.main_data, feedHeadComponent.schema), j(feedHeadComponent.extra_data, feedHeadComponent.schema), m67Var, m67Var2), x57Var, feedHeadComponent.schema, null, null, null, 56, null));
            }
        }
    }

    public static final void f(FeedHeadFigureComponent feedHeadFigureComponent, List<t87<?>> mutableList, m67 m67Var, m67 m67Var2, x57 x57Var) {
        VirtualImageCustomState virtualImageCustomState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, feedHeadFigureComponent, mutableList, m67Var, m67Var2, x57Var) == null) {
            Intrinsics.checkNotNullParameter(feedHeadFigureComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            FeedHeadFigure image_data = feedHeadFigureComponent.image_data;
            if (image_data != null) {
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                o57 h = h(image_data);
                List<r57> j = j(feedHeadFigureComponent.main_data, feedHeadFigureComponent.schema);
                List<r57> j2 = j(feedHeadFigureComponent.extra_data, feedHeadFigureComponent.schema);
                CustomState customState = feedHeadFigureComponent.custom_state;
                if (customState != null) {
                    virtualImageCustomState = m(customState);
                } else {
                    virtualImageCustomState = null;
                }
                mutableList.add(new z47(new n57(h, j, j2, virtualImageCustomState, m67Var, m67Var2), x57Var, feedHeadFigureComponent.schema, b(feedHeadFigureComponent.business_info), null, null, null, null, 240, null));
            }
        }
    }

    public static final l57 g(FeedHeadImg feedHeadImg, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, feedHeadImg, z)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadImg, "<this>");
            String img_url = feedHeadImg.img_url;
            Intrinsics.checkNotNullExpressionValue(img_url, "img_url");
            Integer shape_type = feedHeadImg.shape_type;
            Intrinsics.checkNotNullExpressionValue(shape_type, "shape_type");
            return new l57(img_url, shape_type.intValue(), feedHeadImg.schema, feedHeadImg.pendant_url, feedHeadImg.corner_url, z);
        }
        return (l57) invokeLZ.objValue;
    }

    public static final List<r57> j(List<FeedHeadSymbol> list, String str) {
        InterceptResult invokeLL;
        r57 i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (FeedHeadSymbol feedHeadSymbol : list) {
                    if (feedHeadSymbol != null && (i = i(feedHeadSymbol, str)) != null) {
                        arrayList.add(i);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static final r57 i(FeedHeadSymbol feedHeadSymbol, String str) {
        InterceptResult invokeLL;
        FeedHeadText text;
        FeedHeadIcon icon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, feedHeadSymbol, str)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadSymbol, "<this>");
            Integer num = feedHeadSymbol.type;
            boolean z = false;
            if (num != null && num.intValue() == 2 && (icon = feedHeadSymbol.icon) != null) {
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                String str2 = feedHeadSymbol.schema;
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    str = feedHeadSymbol.schema;
                }
                return k(icon, str);
            }
            Integer num2 = feedHeadSymbol.type;
            if (num2 != null && num2.intValue() == 1 && (text = feedHeadSymbol.text) != null) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                String str3 = feedHeadSymbol.schema;
                if (!((str3 == null || str3.length() == 0) ? true : true)) {
                    str = feedHeadSymbol.schema;
                }
                return l(text, str);
            }
            return null;
        }
        return (r57) invokeLL.objValue;
    }

    public static final t57 l(FeedHeadText feedHeadText, String str) {
        InterceptResult invokeLL;
        String str2;
        p57 p57Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, feedHeadText, str)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadText, "<this>");
            Integer num = feedHeadText.type;
            if (num != null && num.intValue() == 1) {
                str2 = d(feedHeadText.text);
            } else if (num != null && num.intValue() == 2) {
                str2 = c(feedHeadText.text);
            } else {
                str2 = feedHeadText.text;
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            BaseTextColor color = feedHeadText.color;
            if (color != null) {
                Intrinsics.checkNotNullExpressionValue(color, "color");
                p57Var = u67.a(color);
            } else {
                p57Var = null;
            }
            p57 p57Var2 = p57Var;
            Integer priority = feedHeadText.priority;
            Intrinsics.checkNotNullExpressionValue(priority, "priority");
            int intValue = priority.intValue();
            Integer num2 = feedHeadText.can_degrade;
            if (num2 != null && num2.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            return new t57(str3, p57Var2, str, intValue, z, feedHeadText.degrade_len, feedHeadText.suffix, feedHeadText.degrade_priority);
        }
        return (t57) invokeLL.objValue;
    }

    public static final s57 k(FeedHeadIcon feedHeadIcon, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, feedHeadIcon, str)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadIcon, "<this>");
            String url = feedHeadIcon.url;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            Integer width = feedHeadIcon.width;
            Intrinsics.checkNotNullExpressionValue(width, "width");
            int intValue = width.intValue();
            Integer height = feedHeadIcon.height;
            Intrinsics.checkNotNullExpressionValue(height, "height");
            int intValue2 = height.intValue();
            Integer priority = feedHeadIcon.priority;
            Intrinsics.checkNotNullExpressionValue(priority, "priority");
            int intValue3 = priority.intValue();
            Integer num = feedHeadIcon.can_degrade;
            if (num != null && num.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            return new s57(url, str, intValue, intValue2, intValue3, z, feedHeadIcon.degrade_url, feedHeadIcon.degrade_width, feedHeadIcon.degrade_height, feedHeadIcon.degrade_priority);
        }
        return (s57) invokeLL.objValue;
    }
}
