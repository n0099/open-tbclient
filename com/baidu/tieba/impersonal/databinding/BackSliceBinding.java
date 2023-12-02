package com.baidu.tieba.impersonal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class BackSliceBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final TextView b;
    @NonNull
    public final BarImageView c;
    @NonNull
    public final View d;

    public BackSliceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull BarImageView barImageView, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintLayout, textView, barImageView, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = constraintLayout;
        this.b = textView;
        this.c = barImageView;
        this.d = view2;
    }

    @NonNull
    public static BackSliceBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0901b0;
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b0);
            if (textView != null) {
                i = R.id.obfuscated_res_0x7f0901b1;
                BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b1);
                if (barImageView != null) {
                    i = R.id.obfuscated_res_0x7f0917be;
                    View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0917be);
                    if (findViewById != null) {
                        return new BackSliceBinding((ConstraintLayout) view2, textView, barImageView, findViewById);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (BackSliceBinding) invokeL.objValue;
    }

    @NonNull
    public static BackSliceBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d013d, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (BackSliceBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ConstraintLayout) invokeV.objValue;
    }
}
