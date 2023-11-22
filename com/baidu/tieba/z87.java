package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.TitleComponent;
/* loaded from: classes9.dex */
public final class z87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final k57 a(e57 businessInfo) {
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
                if (jl6.k(str)) {
                    return new k57(2, str);
                }
                return new k57(1, str);
            }
            return new k57(0, "");
        }
        return (k57) invokeL.objValue;
    }

    public static final void b(TitleComponent titleComponent, List<ab7<?>> dataList, SpannableStringBuilder titleBuilder, a67 feedExtraData, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{titleComponent, dataList, titleBuilder, feedExtraData, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(titleComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            h47 h47Var = new h47(titleBuilder, z, a(feedExtraData.a()));
            List<FeedContentResource> list = titleComponent.data;
            if (list != null) {
                y87.a(list, titleBuilder, feedExtraData, h47Var);
            }
            if (titleBuilder.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                dataList.add(new bb7(h47Var, "title"));
            }
        }
    }
}
