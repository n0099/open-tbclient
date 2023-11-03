package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.editortools.meme.view.TbCircleProgressBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class SpriteMemeGenerateViewLayoutBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final TextView b;
    @NonNull
    public final ImageView c;
    @NonNull
    public final TbCircleProgressBar d;

    public SpriteMemeGenerateViewLayoutBinding(@NonNull View view2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TbCircleProgressBar tbCircleProgressBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, textView, imageView, tbCircleProgressBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = textView;
        this.c = imageView;
        this.d = tbCircleProgressBar;
    }

    @NonNull
    public static SpriteMemeGenerateViewLayoutBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0908b0;
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908b0);
            if (textView != null) {
                i = R.id.img_view;
                ImageView imageView = (ImageView) view2.findViewById(R.id.img_view);
                if (imageView != null) {
                    i = R.id.progress_view;
                    TbCircleProgressBar tbCircleProgressBar = (TbCircleProgressBar) view2.findViewById(R.id.progress_view);
                    if (tbCircleProgressBar != null) {
                        return new SpriteMemeGenerateViewLayoutBinding(view2, textView, imageView, tbCircleProgressBar);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (SpriteMemeGenerateViewLayoutBinding) invokeL.objValue;
    }

    @NonNull
    public static SpriteMemeGenerateViewLayoutBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.sprite_meme_generate_view_layout, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (SpriteMemeGenerateViewLayoutBinding) invokeLL.objValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }
}
