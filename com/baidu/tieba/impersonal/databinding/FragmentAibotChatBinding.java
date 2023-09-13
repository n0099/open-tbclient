package com.baidu.tieba.impersonal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class FragmentAibotChatBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final LinearLayout b;
    @NonNull
    public final FrameLayout c;
    @NonNull
    public final FragmentContainerView d;
    @NonNull
    public final FrameLayout e;
    @NonNull
    public final FrameLayout f;
    @NonNull
    public final FrameLayout g;
    @NonNull
    public final RelativeLayout h;

    public FragmentAibotChatBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull RelativeLayout relativeLayout2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relativeLayout, linearLayout, frameLayout, fragmentContainerView, frameLayout2, frameLayout3, frameLayout4, relativeLayout2};
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
        this.b = linearLayout;
        this.c = frameLayout;
        this.d = fragmentContainerView;
        this.e = frameLayout2;
        this.f = frameLayout3;
        this.g = frameLayout4;
        this.h = relativeLayout2;
    }

    @NonNull
    public static FragmentAibotChatBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f090490;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090490);
            if (linearLayout != null) {
                i = R.id.obfuscated_res_0x7f0906db;
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906db);
                if (frameLayout != null) {
                    i = R.id.obfuscated_res_0x7f091143;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) view2.findViewById(R.id.obfuscated_res_0x7f091143);
                    if (fragmentContainerView != null) {
                        i = R.id.obfuscated_res_0x7f0918e1;
                        FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918e1);
                        if (frameLayout2 != null) {
                            i = R.id.obfuscated_res_0x7f092357;
                            FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092357);
                            if (frameLayout3 != null) {
                                i = R.id.view_bg;
                                FrameLayout frameLayout4 = (FrameLayout) view2.findViewById(R.id.view_bg);
                                if (frameLayout4 != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) view2;
                                    return new FragmentAibotChatBinding(relativeLayout, linearLayout, frameLayout, fragmentContainerView, frameLayout2, frameLayout3, frameLayout4, relativeLayout);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (FragmentAibotChatBinding) invokeL.objValue;
    }

    @NonNull
    public static FragmentAibotChatBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0324, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (FragmentAibotChatBinding) invokeLLZ.objValue;
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
