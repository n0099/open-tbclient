package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class SpriteMemeReplyViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final LinearLayout b;
    @NonNull
    public final TBLottieAnimationView c;
    @NonNull
    public final TextView d;
    @NonNull
    public final LinearLayout e;
    @NonNull
    public final TbImageView f;
    @NonNull
    public final TextView g;

    public SpriteMemeReplyViewBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TBLottieAnimationView tBLottieAnimationView, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull TbImageView tbImageView, @NonNull TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayout, linearLayout2, tBLottieAnimationView, textView, linearLayout3, tbImageView, textView2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = tBLottieAnimationView;
        this.d = textView;
        this.e = linearLayout3;
        this.f = tbImageView;
        this.g = textView2;
    }

    @NonNull
    public static SpriteMemeReplyViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.sprite_reply_thread_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.sprite_reply_thread_container);
            if (linearLayout != null) {
                i = R.id.sprite_reply_thread_head;
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.sprite_reply_thread_head);
                if (tBLottieAnimationView != null) {
                    i = R.id.sprite_reply_thread_refresh;
                    TextView textView = (TextView) view2.findViewById(R.id.sprite_reply_thread_refresh);
                    if (textView != null) {
                        i = R.id.sprite_reply_thread_refresh_container;
                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.sprite_reply_thread_refresh_container);
                        if (linearLayout2 != null) {
                            i = R.id.sprite_reply_thread_refresh_icon;
                            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.sprite_reply_thread_refresh_icon);
                            if (tbImageView != null) {
                                i = R.id.sprite_reply_thread_title;
                                TextView textView2 = (TextView) view2.findViewById(R.id.sprite_reply_thread_title);
                                if (textView2 != null) {
                                    return new SpriteMemeReplyViewBinding((LinearLayout) view2, linearLayout, tBLottieAnimationView, textView, linearLayout2, tbImageView, textView2);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (SpriteMemeReplyViewBinding) invokeL.objValue;
    }

    @NonNull
    public static SpriteMemeReplyViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.sprite_meme_reply_view, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (SpriteMemeReplyViewBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (LinearLayout) invokeV.objValue;
    }
}
