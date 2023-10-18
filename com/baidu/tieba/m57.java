package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.TitleComponent;
/* loaded from: classes7.dex */
public final class m57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(TitleComponent titleComponent, List<h77<?>> dataList, SpannableStringBuilder titleBuilder, k37 feedExtraData, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{titleComponent, dataList, titleBuilder, feedExtraData, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(titleComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            d27 d27Var = new d27(titleBuilder, z);
            List<FeedContentResource> list = titleComponent.data;
            if (list != null) {
                k57.a(list, titleBuilder, feedExtraData, d27Var);
            }
            if (titleBuilder.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                dataList.add(new i77(d27Var, "title"));
            }
        }
    }
}
