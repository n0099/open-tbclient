package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.TitleComponent;
/* loaded from: classes7.dex */
public final class q97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final b67 a(v57 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            String str = "";
            if (Intrinsics.areEqual(businessInfo.a().get("update_read_status"), "1")) {
                String str2 = businessInfo.a().get("thread_id");
                if (str2 != null) {
                    str = str2;
                }
                if (xl6.k(str)) {
                    return new b67(2, str);
                }
                return new b67(1, str);
            }
            return new b67(0, "");
        }
        return (b67) invokeL.objValue;
    }

    public static final void b(TitleComponent titleComponent, List<rb7<?>> dataList, SpannableStringBuilder titleBuilder, r67 feedExtraData, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{titleComponent, dataList, titleBuilder, feedExtraData, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(titleComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            y47 y47Var = new y47(titleBuilder, z, a(feedExtraData.a()));
            List<FeedContentResource> list = titleComponent.data;
            if (list != null) {
                p97.a(list, titleBuilder, feedExtraData, y47Var);
            }
            if (titleBuilder.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                dataList.add(new sb7(y47Var, "title"));
            }
        }
    }
}
