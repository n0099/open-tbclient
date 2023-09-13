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
public final class AigcFeedbackFoldViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final EMTextView b;
    @NonNull
    public final TbImage c;
    @NonNull
    public final EMTextView d;

    public AigcFeedbackFoldViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull EMTextView eMTextView, @NonNull TbImage tbImage, @NonNull EMTextView eMTextView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relativeLayout, eMTextView, tbImage, eMTextView2};
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
        this.b = eMTextView;
        this.c = tbImage;
        this.d = eMTextView2;
    }

    @NonNull
    public static AigcFeedbackFoldViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0901bf;
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0901bf);
            if (eMTextView != null) {
                i = R.id.obfuscated_res_0x7f0901c1;
                TbImage tbImage = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f0901c1);
                if (tbImage != null) {
                    i = R.id.obfuscated_res_0x7f0901c2;
                    EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c2);
                    if (eMTextView2 != null) {
                        return new AigcFeedbackFoldViewBinding((RelativeLayout) view2, eMTextView, tbImage, eMTextView2);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (AigcFeedbackFoldViewBinding) invokeL.objValue;
    }

    @NonNull
    public static AigcFeedbackFoldViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e9, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (AigcFeedbackFoldViewBinding) invokeLLZ.objValue;
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
