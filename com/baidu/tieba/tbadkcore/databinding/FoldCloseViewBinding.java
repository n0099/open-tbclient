package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class FoldCloseViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final View b;
    @NonNull
    public final ImageView c;
    @NonNull
    public final FrameLayout d;
    @NonNull
    public final RelativeLayout e;

    public FoldCloseViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view2, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relativeLayout, view2, imageView, frameLayout, relativeLayout2};
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
        this.b = view2;
        this.c = imageView;
        this.d = frameLayout;
        this.e = relativeLayout2;
    }

    @NonNull
    public static FoldCloseViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.fold_close_background;
            View findViewById = view2.findViewById(R.id.fold_close_background);
            if (findViewById != null) {
                i = R.id.fold_close_btn;
                ImageView imageView = (ImageView) view2.findViewById(R.id.fold_close_btn);
                if (imageView != null) {
                    i = R.id.fold_close_child_container;
                    FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.fold_close_child_container);
                    if (frameLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view2;
                        return new FoldCloseViewBinding(relativeLayout, findViewById, imageView, frameLayout, relativeLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (FoldCloseViewBinding) invokeL.objValue;
    }

    @NonNull
    public static FoldCloseViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.fold_close_view, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FoldCloseViewBinding) invokeLLZ.objValue;
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
