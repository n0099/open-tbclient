package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
/* loaded from: classes8.dex */
public final class y67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final n57 a(FeedFeedback feedFeedback, l57 feedExtraData) {
        InterceptResult invokeLL;
        o57 o57Var;
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
                o57Var = new o57(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
            } else {
                o57Var = null;
            }
            return new n57(type, str, str2, str3, o57Var);
        }
        return (n57) invokeLL.objValue;
    }
}
