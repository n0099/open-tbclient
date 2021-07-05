package com.bytedance.sdk.openadsdk.core.dynamic.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicButton;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicDislike;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicLogoAd;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicLogoUnion;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicTextView;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicUnKnowView;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicVideoView;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static DynamicBaseWidget a(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, dynamicRootView, fVar)) == null) {
            if (context == null || dynamicRootView == null || fVar == null || fVar.e() == null) {
                return null;
            }
            switch (fVar.e().a()) {
                case -1:
                    return new DynamicUnKnowView(context, dynamicRootView, fVar);
                case 0:
                    return new DynamicTextView(context, dynamicRootView, fVar);
                case 1:
                    return new DynamicImageView(context, dynamicRootView, fVar);
                case 2:
                    return new DynamicButton(context, dynamicRootView, fVar);
                case 3:
                    return new DynamicDislike(context, dynamicRootView, fVar);
                case 4:
                    return new DynamicLogoAd(context, dynamicRootView, fVar);
                case 5:
                    return new DynamicLogoUnion(context, dynamicRootView, fVar);
                case 6:
                    return new DynamicBaseWidgetImp(context, dynamicRootView, fVar);
                case 7:
                    return new DynamicVideoView(context, dynamicRootView, fVar);
                default:
                    return null;
            }
        }
        return (DynamicBaseWidget) invokeLLL.objValue;
    }
}
