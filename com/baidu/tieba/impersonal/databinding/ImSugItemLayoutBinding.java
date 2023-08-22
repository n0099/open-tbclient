package com.baidu.tieba.impersonal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ImSugItemLayoutBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final FrameLayout b;
    @NonNull
    public final LinearLayout c;
    @NonNull
    public final ImageView d;
    @NonNull
    public final View e;
    @NonNull
    public final TextView f;

    public ImSugItemLayoutBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull View view2, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout, frameLayout2, linearLayout, imageView, view2, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = linearLayout;
        this.d = imageView;
        this.e = view2;
        this.f = textView;
    }

    @NonNull
    public static ImSugItemLayoutBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            FrameLayout frameLayout = (FrameLayout) view2;
            int i = R.id.obfuscated_res_0x7f092311;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092311);
            if (linearLayout != null) {
                i = R.id.obfuscated_res_0x7f092313;
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092313);
                if (imageView != null) {
                    i = R.id.obfuscated_res_0x7f092315;
                    View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092315);
                    if (findViewById != null) {
                        i = R.id.obfuscated_res_0x7f092316;
                        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092316);
                        if (textView != null) {
                            return new ImSugItemLayoutBinding(frameLayout, frameLayout, linearLayout, imageView, findViewById, textView);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (ImSugItemLayoutBinding) invokeL.objValue;
    }

    @NonNull
    public static ImSugItemLayoutBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0435, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (ImSugItemLayoutBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (FrameLayout) invokeV.objValue;
    }
}
