package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class TbGroupChatLinkCardLayoutBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final ImageView b;
    @NonNull
    public final ImageView c;
    @NonNull
    public final TextView d;
    @NonNull
    public final ImageView e;
    @NonNull
    public final TextView f;
    @NonNull
    public final LinearLayout g;
    @NonNull
    public final TbImageView h;
    @NonNull
    public final EMTextView i;
    @NonNull
    public final RelativeLayout j;
    @NonNull
    public final RelativeLayout k;

    public TbGroupChatLinkCardLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TbImageView tbImageView, @NonNull EMTextView eMTextView, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {relativeLayout, imageView, imageView2, textView, imageView3, textView2, linearLayout, tbImageView, eMTextView, relativeLayout2, relativeLayout3};
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
        this.b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = imageView3;
        this.f = textView2;
        this.g = linearLayout;
        this.h = tbImageView;
        this.i = eMTextView;
        this.j = relativeLayout2;
        this.k = relativeLayout3;
    }

    @NonNull
    public static TbGroupChatLinkCardLayoutBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.close_button;
            ImageView imageView = (ImageView) view2.findViewById(R.id.close_button);
            if (imageView != null) {
                i = R.id.content1_icon;
                ImageView imageView2 = (ImageView) view2.findViewById(R.id.content1_icon);
                if (imageView2 != null) {
                    i = R.id.content1_text;
                    TextView textView = (TextView) view2.findViewById(R.id.content1_text);
                    if (textView != null) {
                        i = R.id.content2_icon;
                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.content2_icon);
                        if (imageView3 != null) {
                            i = R.id.content2_text;
                            TextView textView2 = (TextView) view2.findViewById(R.id.content2_text);
                            if (textView2 != null) {
                                i = R.id.extra_info_container;
                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.extra_info_container);
                                if (linearLayout != null) {
                                    i = R.id.icon_view;
                                    TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.icon_view);
                                    if (tbImageView != null) {
                                        i = R.id.link_title;
                                        EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.link_title);
                                        if (eMTextView != null) {
                                            i = R.id.main_view;
                                            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.main_view);
                                            if (relativeLayout != null) {
                                                RelativeLayout relativeLayout2 = (RelativeLayout) view2;
                                                return new TbGroupChatLinkCardLayoutBinding(relativeLayout2, imageView, imageView2, textView, imageView3, textView2, linearLayout, tbImageView, eMTextView, relativeLayout, relativeLayout2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (TbGroupChatLinkCardLayoutBinding) invokeL.objValue;
    }

    @NonNull
    public static TbGroupChatLinkCardLayoutBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.tb_group_chat_link_card_layout, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (TbGroupChatLinkCardLayoutBinding) invokeLLZ.objValue;
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
