package com.baidu.tieba.impersonal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class FragmentPersonalChatBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final FrameLayout b;
    @NonNull
    public final TextView c;
    @NonNull
    public final TbImage d;
    @NonNull
    public final FrameLayout e;
    @NonNull
    public final FrameLayout f;
    @NonNull
    public final FrameLayout g;
    @NonNull
    public final Group h;
    @NonNull
    public final FrameLayout i;
    @NonNull
    public final Space j;
    @NonNull
    public final Space k;
    @NonNull
    public final FrameLayout l;
    @NonNull
    public final TbImage m;
    @NonNull
    public final TbImage n;

    public FragmentPersonalChatBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TbImage tbImage, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull Group group, @NonNull FrameLayout frameLayout5, @NonNull Space space, @NonNull Space space2, @NonNull FrameLayout frameLayout6, @NonNull TbImage tbImage2, @NonNull TbImage tbImage3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {constraintLayout, frameLayout, textView, tbImage, frameLayout2, frameLayout3, frameLayout4, group, frameLayout5, space, space2, frameLayout6, tbImage2, tbImage3};
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
        this.b = frameLayout;
        this.c = textView;
        this.d = tbImage;
        this.e = frameLayout2;
        this.f = frameLayout3;
        this.g = frameLayout4;
        this.h = group;
        this.i = frameLayout5;
        this.j = space;
        this.k = space2;
        this.l = frameLayout6;
        this.m = tbImage2;
        this.n = tbImage3;
    }

    @NonNull
    public static FragmentPersonalChatBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0906a9;
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906a9);
            if (frameLayout != null) {
                i = R.id.obfuscated_res_0x7f0907d4;
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907d4);
                if (textView != null) {
                    i = R.id.obfuscated_res_0x7f090b4a;
                    TbImage tbImage = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f090b4a);
                    if (tbImage != null) {
                        i = R.id.obfuscated_res_0x7f0910f3;
                        FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0910f3);
                        if (frameLayout2 != null) {
                            i = R.id.obfuscated_res_0x7f091862;
                            FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091862);
                            if (frameLayout3 != null) {
                                i = R.id.obfuscated_res_0x7f091881;
                                FrameLayout frameLayout4 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091881);
                                if (frameLayout4 != null) {
                                    i = R.id.obfuscated_res_0x7f091884;
                                    Group group = (Group) view2.findViewById(R.id.obfuscated_res_0x7f091884);
                                    if (group != null) {
                                        i = R.id.obfuscated_res_0x7f091e1a;
                                        FrameLayout frameLayout5 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e1a);
                                        if (frameLayout5 != null) {
                                            i = R.id.obfuscated_res_0x7f092188;
                                            Space space = (Space) view2.findViewById(R.id.obfuscated_res_0x7f092188);
                                            if (space != null) {
                                                i = R.id.obfuscated_res_0x7f092189;
                                                Space space2 = (Space) view2.findViewById(R.id.obfuscated_res_0x7f092189);
                                                if (space2 != null) {
                                                    i = R.id.obfuscated_res_0x7f0921b2;
                                                    FrameLayout frameLayout6 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0921b2);
                                                    if (frameLayout6 != null) {
                                                        i = R.id.obfuscated_res_0x7f0921b3;
                                                        TbImage tbImage2 = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f0921b3);
                                                        if (tbImage2 != null) {
                                                            i = R.id.obfuscated_res_0x7f092917;
                                                            TbImage tbImage3 = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f092917);
                                                            if (tbImage3 != null) {
                                                                return new FragmentPersonalChatBinding((ConstraintLayout) view2, frameLayout, textView, tbImage, frameLayout2, frameLayout3, frameLayout4, group, frameLayout5, space, space2, frameLayout6, tbImage2, tbImage3);
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
        return (FragmentPersonalChatBinding) invokeL.objValue;
    }

    @NonNull
    public static FragmentPersonalChatBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0320, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FragmentPersonalChatBinding) invokeLLZ.objValue;
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
