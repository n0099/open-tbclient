package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import java.util.List;
/* loaded from: classes9.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicBaseWidgetImp(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
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
        setTag(Integer.valueOf(getClickArea()));
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            f fVar = this.k;
            if (fVar == null || fVar.e() == null) {
                return false;
            }
            if (this.k.e().a() == 8) {
                return true;
            }
            return this.k.e().a() == 6 && !g();
        }
        return invokeV.booleanValue;
    }

    private boolean g() {
        InterceptResult invokeV;
        List<f> f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            f fVar = this.k;
            if (fVar != null && (f2 = fVar.f()) != null && f2.size() > 0) {
                for (f fVar2 : this.k.f()) {
                    if (fVar2 != null && fVar2.e() != null && (fVar2.e().a() == 1 || fVar2.e().a() == 4 || fVar2.e().a() == 7)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View view = this.n;
            if (view == null) {
                view = this;
            }
            if (f()) {
                view.setBackgroundColor(this.f65991j.r());
            } else {
                view.setBackgroundColor(0);
            }
            view.setPadding(this.f65991j.c(), this.f65991j.b(), this.f65991j.d(), this.f65991j.a());
            if (this.o) {
                view.setVisibility(4);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (e()) {
                View view = this.n;
                if (view == null) {
                    view = this;
                }
                view.setOnTouchListener(getDynamicClickListener());
                view.setOnClickListener(getDynamicClickListener());
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ViewGroup.LayoutParams getWidgetLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ViewGroup.LayoutParams(this.f65986e, this.f65987f) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || this.n == null) {
            return;
        }
        k.f("DynamicBaseWidget", "widget mDynamicView onLayout l,t,r,b:" + i2 + "," + i3 + "," + i4 + "," + i5);
        this.n.layout(0, 0, this.f65986e, this.f65987f);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.f65986e, this.f65987f);
        }
    }
}
