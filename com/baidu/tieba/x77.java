package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedPicComponent;
import tbclient.PicInfo;
/* loaded from: classes8.dex */
public final class x77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final q47 a(List<PicInfo> picInfoList, String schema, b67 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, picInfoList, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(picInfoList, "picInfoList");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            q57 q57Var = new q57();
            ArrayList arrayList = new ArrayList();
            Iterator<PicInfo> it = picInfoList.iterator();
            while (true) {
                boolean z = false;
                if (it.hasNext()) {
                    PicInfo next = it.next();
                    y67 y67Var = new y67();
                    y67Var.a = next.small_pic_url;
                    Integer num = next.width;
                    Intrinsics.checkNotNullExpressionValue(num, "component.width");
                    y67Var.b = num.intValue();
                    Integer num2 = next.height;
                    Intrinsics.checkNotNullExpressionValue(num2, "component.height");
                    y67Var.c = num2.intValue();
                    Double d = next.crop_point_width_ratio;
                    Intrinsics.checkNotNullExpressionValue(d, "component.crop_point_width_ratio");
                    y67Var.e = d.doubleValue();
                    Double d2 = next.crop_point_height_ratio;
                    Intrinsics.checkNotNullExpressionValue(d2, "component.crop_point_height_ratio");
                    y67Var.f = d2.doubleValue();
                    Integer num3 = next.is_long_pic;
                    if (num3 != null && num3.intValue() == 1) {
                        z = true;
                    }
                    y67Var.d = z;
                    arrayList.add(y67Var);
                } else {
                    q57Var.a = arrayList;
                    return new q47(q57Var, schema, CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "image_click"), c67.b(feedExtraData, "image_click2"), c67.b(feedExtraData, "image_click3"), c67.b(feedExtraData, "image_click4"), c67.b(feedExtraData, "image_click5")}), null, 8, null);
                }
            }
        } else {
            return (q47) invokeLLL.objValue;
        }
    }

    public static final void b(FeedPicComponent feedPicComponent, List<v97<?>> dataList, b67 feedExtraData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, feedPicComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedPicComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<PicInfo> list = feedPicComponent.pics;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            List<PicInfo> pics = feedPicComponent.pics;
            Intrinsics.checkNotNullExpressionValue(pics, "pics");
            String schema = feedPicComponent.schema;
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            dataList.add(new w97(a(pics, schema, feedExtraData), "pic"));
        }
    }
}
