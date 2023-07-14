package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
import tbclient.FeedbackReason;
/* loaded from: classes8.dex */
public final class wa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final u87 a(FeedFeedback feedFeedback, s87 feedExtraData) {
        InterceptResult invokeLL;
        w87 w87Var;
        int i;
        Object v87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, feedFeedback, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(feedFeedback, "<this>");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String type = feedFeedback.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            String str = feedFeedback.title;
            String str2 = feedFeedback.button_text;
            String str3 = feedFeedback.common_id;
            String str4 = feedFeedback.type;
            if (Intrinsics.areEqual(str4, ImageViewerConfig.FROM_CONCERN)) {
                w87Var = new w87(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
            } else if (Intrinsics.areEqual(str4, "recommend_post")) {
                String str5 = feedExtraData.a().a().get("thread_id");
                String str6 = feedExtraData.a().a().get("forum_id");
                List<FeedbackReason> list = feedFeedback.dislike;
                SparseArray sparseArray = new SparseArray();
                for (FeedbackReason feedbackReason : list) {
                    Integer num = feedbackReason.id;
                    Intrinsics.checkNotNullExpressionValue(num, "reason.id");
                    sparseArray.put(num.intValue(), feedbackReason.reason);
                }
                List<FeedbackReason> list2 = feedFeedback.dislike;
                SparseArray sparseArray2 = new SparseArray();
                for (FeedbackReason feedbackReason2 : list2) {
                    Integer num2 = feedbackReason2.id;
                    Intrinsics.checkNotNullExpressionValue(num2, "reason.id");
                    sparseArray2.put(num2.intValue(), feedbackReason2.extra);
                }
                String str7 = feedExtraData.a().a().get("weight");
                String str8 = feedExtraData.a().a().get("source");
                String str9 = feedExtraData.a().a().get("threadType");
                if (str9 != null) {
                    i = Integer.parseInt(str9);
                } else {
                    i = 0;
                }
                v87Var = new v87(str5, str6, null, sparseArray, sparseArray2, str7, str8, feedExtraData.a().a().get("extra"), i, 4, null);
                return new u87(type, str, str2, str3, v87Var);
            } else {
                w87Var = null;
            }
            v87Var = w87Var;
            return new u87(type, str, str2, str3, v87Var);
        }
        return (u87) invokeLL.objValue;
    }
}
