package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.TitleComponent;
/* loaded from: classes7.dex */
public final class sa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(TitleComponent titleComponent, List<mc7<?>> dataList, SpannableStringBuilder titleBuilder, s87 feedExtraData, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{titleComponent, dataList, titleBuilder, feedExtraData, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(titleComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            l77 l77Var = new l77(titleBuilder, z);
            List<FeedContentResource> list = titleComponent.data;
            if (list != null) {
                qa7.a(list, titleBuilder, feedExtraData, l77Var);
            }
            if (titleBuilder.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                dataList.add(new nc7(l77Var, "title"));
            }
        }
    }
}
