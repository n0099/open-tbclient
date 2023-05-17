package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.titletags.TitleTagsView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class RecommendCardViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final TbImageView b;
    @NonNull
    public final RelativeLayout c;
    @NonNull
    public final TbImageView d;
    @NonNull
    public final TbImageView e;
    @NonNull
    public final TbImageView f;
    @NonNull
    public final LinearLayout g;
    @NonNull
    public final LinearLayout h;
    @NonNull
    public final TextView i;
    @NonNull
    public final TextView j;
    @NonNull
    public final FrameLayout k;
    @NonNull
    public final TextView l;
    @NonNull
    public final EMTextView m;
    @NonNull
    public final TbImageView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final LinearLayout p;
    @NonNull
    public final TextView q;
    @NonNull
    public final TbImageView r;
    @NonNull
    public final EMTextView s;
    @NonNull
    public final TextView t;
    @NonNull
    public final TitleTagsView u;
    @NonNull
    public final RelativeLayout v;

    public RecommendCardViewBinding(@NonNull FrameLayout frameLayout, @NonNull TbImageView tbImageView, @NonNull RelativeLayout relativeLayout, @NonNull TbImageView tbImageView2, @NonNull TbImageView tbImageView3, @NonNull TbImageView tbImageView4, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout2, @NonNull TextView textView3, @NonNull EMTextView eMTextView, @NonNull TbImageView tbImageView5, @NonNull TextView textView4, @NonNull LinearLayout linearLayout3, @NonNull TextView textView5, @NonNull TbImageView tbImageView6, @NonNull EMTextView eMTextView2, @NonNull TextView textView6, @NonNull TitleTagsView titleTagsView, @NonNull RelativeLayout relativeLayout2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout, tbImageView, relativeLayout, tbImageView2, tbImageView3, tbImageView4, linearLayout, linearLayout2, textView, textView2, frameLayout2, textView3, eMTextView, tbImageView5, textView4, linearLayout3, textView5, tbImageView6, eMTextView2, textView6, titleTagsView, relativeLayout2};
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
        this.b = tbImageView;
        this.c = relativeLayout;
        this.d = tbImageView2;
        this.e = tbImageView3;
        this.f = tbImageView4;
        this.g = linearLayout;
        this.h = linearLayout2;
        this.i = textView;
        this.j = textView2;
        this.k = frameLayout2;
        this.l = textView3;
        this.m = eMTextView;
        this.n = tbImageView5;
        this.o = textView4;
        this.p = linearLayout3;
        this.q = textView5;
        this.r = tbImageView6;
        this.s = eMTextView2;
        this.t = textView6;
        this.u = titleTagsView;
        this.v = relativeLayout2;
    }

    @NonNull
    public static RecommendCardViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.background_image;
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.background_image);
            if (tbImageView != null) {
                i = R.id.bottom_group;
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.bottom_group);
                if (relativeLayout != null) {
                    i = R.id.bottom_icon_left;
                    TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.bottom_icon_left);
                    if (tbImageView2 != null) {
                        i = R.id.bottom_icon_right_end;
                        TbImageView tbImageView3 = (TbImageView) view2.findViewById(R.id.bottom_icon_right_end);
                        if (tbImageView3 != null) {
                            i = R.id.bottom_icon_right_start;
                            TbImageView tbImageView4 = (TbImageView) view2.findViewById(R.id.bottom_icon_right_start);
                            if (tbImageView4 != null) {
                                i = R.id.bottom_icon_text_group_left;
                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.bottom_icon_text_group_left);
                                if (linearLayout != null) {
                                    i = R.id.bottom_icon_text_group_right;
                                    LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.bottom_icon_text_group_right);
                                    if (linearLayout2 != null) {
                                        i = R.id.bottom_icon_text_left;
                                        TextView textView = (TextView) view2.findViewById(R.id.bottom_icon_text_left);
                                        if (textView != null) {
                                            i = R.id.bottom_icon_text_right;
                                            TextView textView2 = (TextView) view2.findViewById(R.id.bottom_icon_text_right);
                                            if (textView2 != null) {
                                                FrameLayout frameLayout = (FrameLayout) view2;
                                                i = R.id.description_one_line_text;
                                                TextView textView3 = (TextView) view2.findViewById(R.id.description_one_line_text);
                                                if (textView3 != null) {
                                                    i = R.id.description_text;
                                                    EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.description_text);
                                                    if (eMTextView != null) {
                                                        i = R.id.icon_left;
                                                        TbImageView tbImageView5 = (TbImageView) view2.findViewById(R.id.icon_left);
                                                        if (tbImageView5 != null) {
                                                            i = R.id.icon_subtext_left;
                                                            TextView textView4 = (TextView) view2.findViewById(R.id.icon_subtext_left);
                                                            if (textView4 != null) {
                                                                i = R.id.icon_text_group_left;
                                                                LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(R.id.icon_text_group_left);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.icon_text_left;
                                                                    TextView textView5 = (TextView) view2.findViewById(R.id.icon_text_left);
                                                                    if (textView5 != null) {
                                                                        i = R.id.main_image;
                                                                        TbImageView tbImageView6 = (TbImageView) view2.findViewById(R.id.main_image);
                                                                        if (tbImageView6 != null) {
                                                                            i = R.id.subtitle_text;
                                                                            EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.subtitle_text);
                                                                            if (eMTextView2 != null) {
                                                                                i = R.id.text_button_right;
                                                                                TextView textView6 = (TextView) view2.findViewById(R.id.text_button_right);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.title_tags;
                                                                                    TitleTagsView titleTagsView = (TitleTagsView) view2.findViewById(R.id.title_tags);
                                                                                    if (titleTagsView != null) {
                                                                                        i = R.id.title_tags_container;
                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.title_tags_container);
                                                                                        if (relativeLayout2 != null) {
                                                                                            return new RecommendCardViewBinding(frameLayout, tbImageView, relativeLayout, tbImageView2, tbImageView3, tbImageView4, linearLayout, linearLayout2, textView, textView2, frameLayout, textView3, eMTextView, tbImageView5, textView4, linearLayout3, textView5, tbImageView6, eMTextView2, textView6, titleTagsView, relativeLayout2);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
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
        return (RecommendCardViewBinding) invokeL.objValue;
    }

    @NonNull
    public static RecommendCardViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.recommend_card_view, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (RecommendCardViewBinding) invokeLLZ.objValue;
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
