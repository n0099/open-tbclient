package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
/* loaded from: classes7.dex */
public final class v17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final k07 a(FeedFeedback feedFeedback, i07 feedExtraData) {
        InterceptResult invokeLL;
        l07 l07Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, feedFeedback, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(feedFeedback, "<this>");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String type = feedFeedback.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            String str = feedFeedback.title;
            String str2 = feedFeedback.button_text;
            String str3 = feedFeedback.common_id;
            if (Intrinsics.areEqual(feedFeedback.type, ImageViewerConfig.FROM_CONCERN)) {
                l07Var = new l07(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
            } else {
                l07Var = null;
            }
            return new k07(type, str, str2, str3, l07Var);
        }
        return (k07) invokeLL.objValue;
    }
}
