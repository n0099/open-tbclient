package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLinkComponent;
import tbclient.PbLinkInfo;
/* loaded from: classes7.dex */
public final class p67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLinkComponent feedLinkComponent, List<j87<? extends Object>> mutableList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, feedLinkComponent, mutableList) == null) {
            Intrinsics.checkNotNullParameter(feedLinkComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            List<PbLinkInfo> list = feedLinkComponent.links;
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (PbLinkInfo it : list) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    r57 b = b(it);
                    if (b != null) {
                        arrayList.add(b);
                    }
                }
                if (arrayList.size() > 1) {
                    mutableList.add(new i47(arrayList));
                } else {
                    mutableList.add(new l47((r57) arrayList.get(0)));
                }
            }
        }
    }

    public static final r57 b(PbLinkInfo pbLinkInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int intValue;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pbLinkInfo)) == null) {
            Intrinsics.checkNotNullParameter(pbLinkInfo, "<this>");
            String str7 = pbLinkInfo.title;
            if (str7 == null) {
                str = "";
            } else {
                str = str7;
            }
            String str8 = pbLinkInfo.to_url;
            if (str8 == null) {
                str2 = "";
            } else {
                str2 = str8;
            }
            String str9 = pbLinkInfo.pic_url;
            if (str9 == null) {
                str3 = "";
            } else {
                str3 = str9;
            }
            String str10 = pbLinkInfo.link_from;
            if (str10 == null) {
                str4 = "";
            } else {
                str4 = str10;
            }
            String str11 = pbLinkInfo.ext_txt;
            if (str11 == null) {
                str5 = "";
            } else {
                str5 = str11;
            }
            Integer num = pbLinkInfo.sort;
            int i = 0;
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            Integer num2 = pbLinkInfo.url_type;
            if (num2 != null) {
                i = num2.intValue();
            }
            String str12 = pbLinkInfo.content1;
            if (str12 == null) {
                str6 = "";
            } else {
                str6 = str12;
            }
            String str13 = pbLinkInfo.content2;
            if (str13 == null) {
                str13 = "";
            }
            return new r57(str, str2, str3, str4, str5, intValue, i, str6, str13);
        }
        return (r57) invokeL.objValue;
    }
}
