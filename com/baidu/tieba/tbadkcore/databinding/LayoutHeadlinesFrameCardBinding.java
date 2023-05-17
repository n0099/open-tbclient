package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SimpleCountDownView;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class LayoutHeadlinesFrameCardBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final TbImage b;
    @NonNull
    public final TbImageAutoSwitch c;
    @NonNull
    public final FrameLayout d;
    @NonNull
    public final EMTextView e;
    @NonNull
    public final SimpleCountDownView f;
    @NonNull
    public final TextView g;

    public LayoutHeadlinesFrameCardBinding(@NonNull View view2, @NonNull TbImage tbImage, @NonNull TbImageAutoSwitch tbImageAutoSwitch, @NonNull FrameLayout frameLayout, @NonNull EMTextView eMTextView, @NonNull SimpleCountDownView simpleCountDownView, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbImage, tbImageAutoSwitch, frameLayout, eMTextView, simpleCountDownView, textView};
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
        this.b = tbImage;
        this.c = tbImageAutoSwitch;
        this.d = frameLayout;
        this.e = eMTextView;
        this.f = simpleCountDownView;
        this.g = textView;
    }

    @NonNull
    public static LayoutHeadlinesFrameCardBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.background_card;
            TbImage tbImage = (TbImage) view2.findViewById(R.id.background_card);
            if (tbImage != null) {
                i = R.id.headlines_auto_switch;
                TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) view2.findViewById(R.id.headlines_auto_switch);
                if (tbImageAutoSwitch != null) {
                    i = R.id.headlines_auto_switch_container;
                    FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.headlines_auto_switch_container);
                    if (frameLayout != null) {
                        i = R.id.headlines_auto_switch_text;
                        EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.headlines_auto_switch_text);
                        if (eMTextView != null) {
                            i = R.id.headlines_count_down;
                            SimpleCountDownView simpleCountDownView = (SimpleCountDownView) view2.findViewById(R.id.headlines_count_down);
                            if (simpleCountDownView != null) {
                                i = R.id.headlines_finish_text;
                                TextView textView = (TextView) view2.findViewById(R.id.headlines_finish_text);
                                if (textView != null) {
                                    return new LayoutHeadlinesFrameCardBinding(view2, tbImage, tbImageAutoSwitch, frameLayout, eMTextView, simpleCountDownView, textView);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (LayoutHeadlinesFrameCardBinding) invokeL.objValue;
    }

    @NonNull
    public static LayoutHeadlinesFrameCardBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.layout_headlines_frame_card, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (LayoutHeadlinesFrameCardBinding) invokeLL.objValue;
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
