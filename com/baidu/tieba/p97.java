package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.TitleComponent;
/* loaded from: classes7.dex */
public final class p97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(TitleComponent titleComponent, List<jb7<?>> dataList, SpannableStringBuilder titleBuilder, p77 feedExtraData, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{titleComponent, dataList, titleBuilder, feedExtraData, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(titleComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            i67 i67Var = new i67(titleBuilder, z);
            List<FeedContentResource> list = titleComponent.data;
            if (list != null) {
                n97.a(list, titleBuilder, feedExtraData, i67Var);
            }
            if (titleBuilder.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                dataList.add(new kb7(i67Var, "title"));
            }
        }
    }
}
