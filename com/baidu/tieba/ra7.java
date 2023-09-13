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
/* loaded from: classes7.dex */
public final class ra7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final j77 a(List<PicInfo> picInfoList, String schema, u87 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, picInfoList, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(picInfoList, "picInfoList");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            j87 j87Var = new j87();
            ArrayList arrayList = new ArrayList();
            Iterator<PicInfo> it = picInfoList.iterator();
            while (true) {
                boolean z = false;
                if (it.hasNext()) {
                    PicInfo next = it.next();
                    r97 r97Var = new r97();
                    r97Var.a = next.small_pic_url;
                    Integer num = next.width;
                    Intrinsics.checkNotNullExpressionValue(num, "component.width");
                    r97Var.b = num.intValue();
                    Integer num2 = next.height;
                    Intrinsics.checkNotNullExpressionValue(num2, "component.height");
                    r97Var.c = num2.intValue();
                    Double d = next.crop_point_width_ratio;
                    Intrinsics.checkNotNullExpressionValue(d, "component.crop_point_width_ratio");
                    r97Var.e = d.doubleValue();
                    Double d2 = next.crop_point_height_ratio;
                    Intrinsics.checkNotNullExpressionValue(d2, "component.crop_point_height_ratio");
                    r97Var.f = d2.doubleValue();
                    Integer num3 = next.is_long_pic;
                    if (num3 != null && num3.intValue() == 1) {
                        z = true;
                    }
                    r97Var.d = z;
                    arrayList.add(r97Var);
                } else {
                    j87Var.a = arrayList;
                    return new j77(j87Var, schema, CollectionsKt__CollectionsKt.listOf((Object[]) new w97[]{v87.b(feedExtraData, "image_click"), v87.b(feedExtraData, "image_click2"), v87.b(feedExtraData, "image_click3"), v87.b(feedExtraData, "image_click4"), v87.b(feedExtraData, "image_click5")}), null, 8, null);
                }
            }
        } else {
            return (j77) invokeLLL.objValue;
        }
    }

    public static final void b(FeedPicComponent feedPicComponent, List<pc7<?>> dataList, u87 feedExtraData) {
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
            dataList.add(new qc7(a(pics, schema, feedExtraData), "pic"));
        }
    }
}
