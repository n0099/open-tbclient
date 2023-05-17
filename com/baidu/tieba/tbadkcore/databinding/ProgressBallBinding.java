package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ProgressBallBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final RoundTbImageView b;
    @NonNull
    public final TbImage c;
    @NonNull
    public final View d;
    @NonNull
    public final TextView e;

    public ProgressBallBinding(@NonNull FrameLayout frameLayout, @NonNull RoundTbImageView roundTbImageView, @NonNull TbImage tbImage, @NonNull View view2, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout, roundTbImageView, tbImage, view2, textView};
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
        this.b = roundTbImageView;
        this.c = tbImage;
        this.d = view2;
        this.e = textView;
    }

    @NonNull
    public static ProgressBallBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.progress_ball_background;
            RoundTbImageView roundTbImageView = (RoundTbImageView) view2.findViewById(R.id.progress_ball_background);
            if (roundTbImageView != null) {
                i = R.id.progress_ball_dynamic_mask;
                TbImage tbImage = (TbImage) view2.findViewById(R.id.progress_ball_dynamic_mask);
                if (tbImage != null) {
                    i = R.id.progress_ball_static_mask;
                    View findViewById = view2.findViewById(R.id.progress_ball_static_mask);
                    if (findViewById != null) {
                        i = R.id.progress_ball_text;
                        TextView textView = (TextView) view2.findViewById(R.id.progress_ball_text);
                        if (textView != null) {
                            return new ProgressBallBinding((FrameLayout) view2, roundTbImageView, tbImage, findViewById, textView);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (ProgressBallBinding) invokeL.objValue;
    }

    @NonNull
    public static ProgressBallBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.progress_ball, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (ProgressBallBinding) invokeLLZ.objValue;
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
