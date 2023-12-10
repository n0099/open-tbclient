package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.forum.databinding.ForumNavBarSecondFloorBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class lk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ForumNavBarSecondFloorBinding a(ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding, NavigationBar navigationBar, ni7 ni7Var, int i, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{forumNavBarSecondFloorBinding, navigationBar, ni7Var, Integer.valueOf(i), onClickListener})) == null) {
            if (forumNavBarSecondFloorBinding == null) {
                forumNavBarSecondFloorBinding = ForumNavBarSecondFloorBinding.c(LayoutInflater.from(navigationBar.getContext()), navigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT), false);
                Intrinsics.checkNotNullExpressionValue(forumNavBarSecondFloorBinding, "inflate(LayoutInflater.f…HORIZONTAL_RIGHT), false)");
            }
            if (forumNavBarSecondFloorBinding.getRoot().getParent() != null) {
                return forumNavBarSecondFloorBinding;
            }
            TbImage tbImage = forumNavBarSecondFloorBinding.b;
            String c = ni7Var.c();
            if (c == null) {
                c = "";
            }
            tbImage.l(c);
            forumNavBarSecondFloorBinding.c.setShadowEnabled(false);
            forumNavBarSecondFloorBinding.c.refresh(0);
            navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, forumNavBarSecondFloorBinding.getRoot(), i, onClickListener);
            return forumNavBarSecondFloorBinding;
        }
        return (ForumNavBarSecondFloorBinding) invokeCommon.objValue;
    }

    public static final ForumNavBarSecondFloorBinding b(ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding, NavigationBar nav, si7 forumData, View visibilityTarget, View.OnClickListener clickListener) {
        InterceptResult invokeLLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, forumNavBarSecondFloorBinding, nav, forumData, visibilityTarget, clickListener)) == null) {
            Intrinsics.checkNotNullParameter(nav, "nav");
            Intrinsics.checkNotNullParameter(forumData, "forumData");
            Intrinsics.checkNotNullParameter(visibilityTarget, "visibilityTarget");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            ni7 a = forumData.a();
            if (a != null && a.g()) {
                if (visibilityTarget.getVisibility() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                return a(forumNavBarSecondFloorBinding, nav, a, i, clickListener);
            }
            c(forumNavBarSecondFloorBinding);
            return forumNavBarSecondFloorBinding;
        }
        return (ForumNavBarSecondFloorBinding) invokeLLLLL.objValue;
    }

    public static final void c(ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, forumNavBarSecondFloorBinding) != null) || forumNavBarSecondFloorBinding == null) {
            return;
        }
        ViewParent parent = forumNavBarSecondFloorBinding.getRoot().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(forumNavBarSecondFloorBinding.getRoot());
        }
    }

    public static final void d(ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding, Boolean bool) {
        MessageRedDotView messageRedDotView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, forumNavBarSecondFloorBinding, bool) != null) || bool == null) {
            return;
        }
        if (forumNavBarSecondFloorBinding != null) {
            messageRedDotView = forumNavBarSecondFloorBinding.c;
        } else {
            messageRedDotView = null;
        }
        if (messageRedDotView != null) {
            if (bool.booleanValue()) {
                i = 0;
            } else {
                i = 8;
            }
            messageRedDotView.setVisibility(i);
        }
    }

    public static final void e(ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding, View target) {
        FrameLayout root;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, forumNavBarSecondFloorBinding, target) == null) {
            Intrinsics.checkNotNullParameter(target, "target");
            if (target.getVisibility() == 0 && forumNavBarSecondFloorBinding != null && (root = forumNavBarSecondFloorBinding.getRoot()) != null) {
                boolean z2 = true;
                if (target.getAlpha() == 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    root.setVisibility(0);
                    if (root.getTag(R.id.obfuscated_res_0x7f0919b1) != null) {
                        z2 = false;
                    }
                    if (z2) {
                        ym7.a(4);
                        root.setTag(R.id.obfuscated_res_0x7f0919b1, "1");
                        return;
                    }
                    return;
                }
                root.setVisibility(8);
            }
        }
    }
}
