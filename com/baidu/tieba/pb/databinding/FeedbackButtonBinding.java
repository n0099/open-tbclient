package com.baidu.tieba.pb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class FeedbackButtonBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final TbImage b;
    @NonNull
    public final EMTextView c;

    public FeedbackButtonBinding(@NonNull RelativeLayout relativeLayout, @NonNull TbImage tbImage, @NonNull EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relativeLayout, tbImage, eMTextView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = relativeLayout;
        this.b = tbImage;
        this.c = eMTextView;
    }

    @NonNull
    public static FeedbackButtonBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f090b0a;
            TbImage tbImage = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f090b0a);
            if (tbImage != null) {
                i = R.id.obfuscated_res_0x7f090b0b;
                EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090b0b);
                if (eMTextView != null) {
                    return new FeedbackButtonBinding((RelativeLayout) view2, tbImage, eMTextView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (FeedbackButtonBinding) invokeL.objValue;
    }

    @NonNull
    public static FeedbackButtonBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02db, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FeedbackButtonBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (RelativeLayout) invokeV.objValue;
    }
}
