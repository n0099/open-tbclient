package com.baidu.tieba.impersonal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.tieba.impersonal.components.FadingEdgeRecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class SlicePersonalChatBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FadingEdgeRecyclerView a;
    @NonNull
    public final FadingEdgeRecyclerView b;

    public SlicePersonalChatBinding(@NonNull FadingEdgeRecyclerView fadingEdgeRecyclerView, @NonNull FadingEdgeRecyclerView fadingEdgeRecyclerView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fadingEdgeRecyclerView, fadingEdgeRecyclerView2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fadingEdgeRecyclerView;
        this.b = fadingEdgeRecyclerView2;
    }

    @NonNull
    public static SlicePersonalChatBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 != null) {
                FadingEdgeRecyclerView fadingEdgeRecyclerView = (FadingEdgeRecyclerView) view2;
                return new SlicePersonalChatBinding(fadingEdgeRecyclerView, fadingEdgeRecyclerView);
            }
            throw new NullPointerException("rootView");
        }
        return (SlicePersonalChatBinding) invokeL.objValue;
    }

    @NonNull
    public static SlicePersonalChatBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0902, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (SlicePersonalChatBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FadingEdgeRecyclerView getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (FadingEdgeRecyclerView) invokeV.objValue;
    }
}
