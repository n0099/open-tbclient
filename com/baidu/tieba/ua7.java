package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.FeedVideoComponent;
import tbclient.ThumbnailInfo;
import tbclient.VideoField;
/* loaded from: classes8.dex */
public final class ua7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(String schema, s87 feedExtraData) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String a = ub7.a(ub7.b(schema, feedExtraData.d()), "author_is_living", feedExtraData.a().a().get("author_is_living"));
            String str = feedExtraData.a().a().get("yy_ext");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                Intrinsics.checkNotNullExpressionValue(a, "{\n        result\n    }");
                return a;
            }
            String a2 = ub7.a(a, "yy_ext", str);
            Intrinsics.checkNotNullExpressionValue(a2, "{\n        SchemaUtil.app…yy_ext\", yyExtInfo)\n    }");
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    public static final o77 b(VideoField videoField, y97 videoSchemaData, s87 feedExtraData) {
        InterceptResult invokeLLL;
        String str;
        boolean z;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, videoField, videoSchemaData, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(videoField, "videoField");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            x97 x97Var = new x97();
            ThumbnailInfo thumbnailInfo = videoField.thumbnail;
            if (thumbnailInfo != null) {
                str = thumbnailInfo.url;
            } else {
                str = null;
            }
            x97Var.a = str;
            Integer num = videoField.is_vertical;
            if (num != null && num.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            x97Var.d = z;
            Integer num2 = videoField.width;
            Intrinsics.checkNotNullExpressionValue(num2, "videoField.width");
            x97Var.b = num2.intValue();
            Integer num3 = videoField.height;
            Intrinsics.checkNotNullExpressionValue(num3, "videoField.height");
            x97Var.c = num3.intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(StringHelper.stringForVideoTime(videoField.duration.intValue() * 1000));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = z57.a.getString(R.string.play_count_new);
            Intrinsics.checkNotNullExpressionValue(string, "FeedAppContext.getString(R.string.play_count_new)");
            String format = String.format(string, Arrays.copyOf(new Object[]{StringHelper.numFormatOverWan(videoField.play_count.intValue())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb.append(format);
            sb.toString();
            x97Var.e = videoField.url;
            Integer num4 = videoField.duration;
            Intrinsics.checkNotNullExpressionValue(num4, "videoField.duration");
            x97Var.f = num4.intValue();
            x97Var.g = 0;
            Integer num5 = videoField.play_count;
            Intrinsics.checkNotNullExpressionValue(num5, "videoField.play_count");
            x97Var.h = num5.intValue();
            String str2 = videoField.md5;
            Map<String, String> a2 = feedExtraData.a().a();
            x97Var.i = a2;
            Intrinsics.checkNotNullExpressionValue(a2, "videoData.businessInfo");
            qc7 qc7Var = feedExtraData.e().get(PageInfo.KEY);
            a2.put("page_from", (qc7Var == null || (a = qc7Var.a(new d87())) == null || (r0 = a.get("page_from")) == null) ? "" : "");
            return new o77(x97Var, videoSchemaData, CollectionsKt__CollectionsKt.listOf((Object[]) new u97[]{t87.b(feedExtraData, "video_click"), t87.b(feedExtraData, "video_click2")}), null, 8, null);
        }
        return (o77) invokeLLL.objValue;
    }

    public static final void c(FeedVideoComponent feedVideoComponent, List<mc7<?>> dataList, y97 videoSchemaData, s87 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, feedVideoComponent, dataList, videoSchemaData, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedVideoComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            VideoField videoField = feedVideoComponent.video_info;
            if (videoField != null) {
                dataList.add(new nc7(b(videoField, videoSchemaData, feedExtraData), "video"));
            }
        }
    }
}
