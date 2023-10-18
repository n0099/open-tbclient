package com.baidu.tieba.immessagecenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class MsgTabGuideViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final TextView b;
    @NonNull
    public final ImageView c;
    @NonNull
    public final FrameLayout d;
    @NonNull
    public final RelativeLayout e;
    @NonNull
    public final ImageView f;
    @NonNull
    public final FrameLayout g;
    @NonNull
    public final TextView h;

    public MsgTabGuideViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintLayout, textView, imageView, frameLayout, relativeLayout, imageView2, frameLayout2, textView2};
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
        this.c = imageView;
        this.d = frameLayout;
        this.e = relativeLayout;
        this.f = imageView2;
        this.g = frameLayout2;
        this.h = textView2;
    }

    @NonNull
    public static MsgTabGuideViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f09006a;
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09006a);
            if (textView != null) {
                i = R.id.obfuscated_res_0x7f09100b;
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09100b);
                if (imageView != null) {
                    i = R.id.obfuscated_res_0x7f091013;
                    FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091013);
                    if (frameLayout != null) {
                        i = R.id.obfuscated_res_0x7f091a47;
                        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a47);
                        if (relativeLayout != null) {
                            i = R.id.obfuscated_res_0x7f091a48;
                            ImageView imageView2 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a48);
                            if (imageView2 != null) {
                                i = R.id.obfuscated_res_0x7f091a49;
                                FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a49);
                                if (frameLayout2 != null) {
                                    i = R.id.obfuscated_res_0x7f0925a4;
                                    TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a4);
                                    if (textView2 != null) {
                                        return new MsgTabGuideViewBinding((ConstraintLayout) view2, textView, imageView, frameLayout, relativeLayout, imageView2, frameLayout2, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (MsgTabGuideViewBinding) invokeL.objValue;
    }

    @NonNull
    public static MsgTabGuideViewBinding c(@NonNull LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, layoutInflater)) == null) {
            return d(layoutInflater, null, false);
        }
        return (MsgTabGuideViewBinding) invokeL.objValue;
    }

    @NonNull
    public static MsgTabGuideViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0642, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (MsgTabGuideViewBinding) invokeLLZ.objValue;
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
