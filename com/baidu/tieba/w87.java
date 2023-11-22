package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedPicComponent;
import tbclient.PicDecoration;
import tbclient.PicInfo;
/* loaded from: classes8.dex */
public final class w87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<g77> a(List<PicDecoration> decorationComponentList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, decorationComponentList)) == null) {
            Intrinsics.checkNotNullParameter(decorationComponentList, "decorationComponentList");
            ArrayList arrayList = new ArrayList();
            for (PicDecoration picDecoration : decorationComponentList) {
                HashMap<String, String> a = ea7.a.a(picDecoration.decoration_info);
                String str = picDecoration.name;
                Intrinsics.checkNotNullExpressionValue(str, "decorationComponent.name");
                String str2 = picDecoration.location;
                Intrinsics.checkNotNullExpressionValue(str2, "decorationComponent.location");
                arrayList.add(new g77(str, str2, a));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static final d47 b(List<PicInfo> picInfoList, String schema, a67 feedExtraData) {
        InterceptResult invokeLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, picInfoList, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(picInfoList, "picInfoList");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            j57 j57Var = new j57();
            ArrayList arrayList = new ArrayList();
            for (PicInfo picInfo : picInfoList) {
                f77 f77Var = new f77();
                f77Var.a = picInfo.small_pic_url;
                Integer num = picInfo.width;
                Intrinsics.checkNotNullExpressionValue(num, "component.width");
                f77Var.b = num.intValue();
                Integer num2 = picInfo.height;
                Intrinsics.checkNotNullExpressionValue(num2, "component.height");
                f77Var.c = num2.intValue();
                Double d = picInfo.crop_point_width_ratio;
                Intrinsics.checkNotNullExpressionValue(d, "component.crop_point_width_ratio");
                f77Var.e = d.doubleValue();
                Double d2 = picInfo.crop_point_height_ratio;
                Intrinsics.checkNotNullExpressionValue(d2, "component.crop_point_height_ratio");
                f77Var.f = d2.doubleValue();
                Integer num3 = picInfo.is_long_pic;
                if (num3 != null && num3.intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                f77Var.d = z;
                f77Var.g = picInfo.scheme;
                List<PicDecoration> list = picInfo.decoration;
                if (list != null && !list.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    List<PicDecoration> list2 = picInfo.decoration;
                    Intrinsics.checkNotNullExpressionValue(list2, "component.decoration");
                    f77Var.h = a(list2);
                }
                f77Var.i.addAll(CollectionsKt__CollectionsKt.listOf((Object[]) new n77[]{b67.d(feedExtraData, "image_click", null, 2, null), b67.d(feedExtraData, "image_click2", null, 2, null), b67.d(feedExtraData, "image_click3", null, 2, null), b67.d(feedExtraData, "image_click4", null, 2, null), b67.d(feedExtraData, "image_click5", null, 2, null), b67.c(feedExtraData, "image_click_selector1", b67.a(feedExtraData, MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pic_type", picInfo.pic_type))))}));
                arrayList.add(f77Var);
            }
            j57Var.a = arrayList;
            return new d47(j57Var, schema, feedExtraData.a().a(), feedExtraData.c().a(), null, 16, null);
        }
        return (d47) invokeLLL.objValue;
    }

    public static final void c(FeedPicComponent feedPicComponent, List<ab7<?>> dataList, a67 feedExtraData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, feedPicComponent, dataList, feedExtraData) == null) {
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
            dataList.add(new bb7(b(pics, schema, feedExtraData), "pic"));
        }
    }
}
