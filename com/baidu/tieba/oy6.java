package com.baidu.tieba;

import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.FeedVideoComponent;
import tbclient.ThumbnailInfo;
import tbclient.VideoField;
/* loaded from: classes5.dex */
public final class oy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(String schema, dx6 feedExtraData) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String a = kz6.a(schema, "author_is_living", feedExtraData.a().a().get("author_is_living"));
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
            String a2 = kz6.a(a, "yy_ext", str);
            Intrinsics.checkNotNullExpressionValue(a2, "{\n        SchemaUtil.app…yy_ext\", yyExtInfo)\n    }");
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    public static final gw6 b(VideoField videoField, xx6 videoSchemaData, dx6 feedExtraData) {
        InterceptResult invokeLLL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, videoField, videoSchemaData, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(videoField, "videoField");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            wx6 wx6Var = new wx6();
            ThumbnailInfo thumbnailInfo = videoField.thumbnail;
            if (thumbnailInfo != null) {
                str = thumbnailInfo.url;
            } else {
                str = null;
            }
            wx6Var.a = str;
            Integer num = videoField.is_vertical;
            if (num != null && num.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            wx6Var.b = z;
            Integer num2 = videoField.width;
            Intrinsics.checkNotNullExpressionValue(num2, "videoField.width");
            num2.intValue();
            Integer num3 = videoField.height;
            Intrinsics.checkNotNullExpressionValue(num3, "videoField.height");
            num3.intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(StringHelper.stringForVideoTime(videoField.duration.intValue() * 1000));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = yu6.a.getString(R.string.play_count_new);
            Intrinsics.checkNotNullExpressionValue(string, "FeedAppContext.getString(R.string.play_count_new)");
            String format = String.format(string, Arrays.copyOf(new Object[]{StringHelper.numFormatOverWan(videoField.play_count.intValue())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb.append(format);
            wx6Var.c = sb.toString();
            return new gw6(wx6Var, videoSchemaData, ex6.b(feedExtraData, "video_click"), null, 8, null);
        }
        return (gw6) invokeLLL.objValue;
    }

    public static final void c(FeedVideoComponent feedVideoComponent, List<b07<?>> dataList, xx6 videoSchemaData, dx6 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, feedVideoComponent, dataList, videoSchemaData, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedVideoComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            VideoField videoField = feedVideoComponent.video_info;
            if (videoField != null) {
                dataList.add(new c07(b(videoField, videoSchemaData, feedExtraData), "video"));
            }
        }
    }
}
