package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
/* loaded from: classes9.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicLogoAd(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context, dynamicRootView, fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dynamicRootView, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (DynamicRootView) objArr2[1], (f) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.n, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            super.b();
            if (Build.VERSION.SDK_INT >= 17) {
                this.n.setTextAlignment(this.f66717j.h());
            }
            ((TextView) this.n).setText("广告");
            ((TextView) this.n).setTextColor(this.f66717j.g());
            ((TextView) this.n).setTextSize(this.f66717j.e());
            return true;
        }
        return invokeV.booleanValue;
    }
}
