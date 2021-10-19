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
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int p;
    public int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicButton(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
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

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.p = ((this.f66713f - ((int) s.b(this.f66716i, this.f66717j.e()))) / 2) - this.f66717j.a();
            this.q = 0;
        }
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
            ((TextView) this.n).setText(this.f66717j.i());
            ((TextView) this.n).setTextColor(this.f66717j.g());
            ((TextView) this.n).setTextSize(this.f66717j.e());
            if (Build.VERSION.SDK_INT >= 16) {
                this.n.setBackground(getBackgroundDrawable());
            }
            ((TextView) this.n).setGravity(17);
            ((TextView) this.n).setIncludeFontPadding(false);
            f();
            this.n.setPadding(this.f66717j.c(), this.p, this.f66717j.d(), this.q);
            return true;
        }
        return invokeV.booleanValue;
    }
}
