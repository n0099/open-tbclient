package com.baidu.tieba.impersonal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.tieba.core.image.dynamic.DynamicAnimView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class SlicePersonalSpriteBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final DynamicAnimView a;
    @NonNull
    public final DynamicAnimView b;

    public SlicePersonalSpriteBinding(@NonNull DynamicAnimView dynamicAnimView, @NonNull DynamicAnimView dynamicAnimView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dynamicAnimView, dynamicAnimView2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dynamicAnimView;
        this.b = dynamicAnimView2;
    }

    @NonNull
    public static SlicePersonalSpriteBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 != null) {
                DynamicAnimView dynamicAnimView = (DynamicAnimView) view2;
                return new SlicePersonalSpriteBinding(dynamicAnimView, dynamicAnimView);
            }
            throw new NullPointerException("rootView");
        }
        return (SlicePersonalSpriteBinding) invokeL.objValue;
    }

    @NonNull
    public static SlicePersonalSpriteBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08c0, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (SlicePersonalSpriteBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public DynamicAnimView getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (DynamicAnimView) invokeV.objValue;
    }
}
