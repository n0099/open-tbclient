package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AbstractComponent;
import tbclient.FeedContentResource;
/* loaded from: classes9.dex */
public final class z47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final q17 a(SpannableStringBuilder titleBuilder, List<FeedContentResource> contentList, k37 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, titleBuilder, contentList, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(contentList, "contentList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            q17 q17Var = new q17(new s27(titleBuilder, spannableStringBuilder));
            k57.a(contentList, spannableStringBuilder, feedExtraData, q17Var);
            return q17Var;
        }
        return (q17) invokeLLL.objValue;
    }

    public static final void b(AbstractComponent abstractComponent, List<h77<?>> dataList, SpannableStringBuilder titleBuilder, k37 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, abstractComponent, dataList, titleBuilder, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(abstractComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<FeedContentResource> data = abstractComponent.data;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            q17 a = a(titleBuilder, data, feedExtraData);
            if (a.i()) {
                dataList.add(new i77(a, "abstract"));
            }
        }
    }
}
