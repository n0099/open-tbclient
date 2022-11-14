package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.funad.adapter.FunAdNativeViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, str, str2, i)) == null) {
            if ("personalize".equals(str) && tq5.k().s(AbsDataRecorder.Scene.RECOMMEND)) {
                return true;
            }
            if ("frs_new_tab".equals(str2) && tq5.k().s(AbsDataRecorder.Scene.FRS_NEW)) {
                return true;
            }
            if ("frs_hot_tab".equals(str2) && tq5.k().s(AbsDataRecorder.Scene.FRS_HOT)) {
                return true;
            }
            if ("pb".equals(str) && tq5.k().r(i, AbsDataRecorder.Scene.PB)) {
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void b(FunAdNativeViewHolder funAdNativeViewHolder, VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, int i) {
        ViewGroup c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, Integer.valueOf(i)}) == null) {
            if (!"personalize".equals(str) && !"frs_new_tab".equals(str2) && !"frs_hot_tab".equals(str2)) {
                if ("pb".equals(str)) {
                    if (tq5.k().m() && i == 1) {
                        vipAdFreeGuideLayout.setBottomCornerRound(false);
                        vipAdFreeGuideLayout.setAllCornerRound(false);
                        if (funAdNativeViewHolder != null && funAdNativeViewHolder.d() != null && (c = funAdNativeViewHolder.d().c(null)) != null) {
                            c.setPadding(c.getPaddingLeft(), c.getPaddingTop(), c.getPaddingRight(), 0);
                        }
                    } else if (vipAdFreeGuideLayout != null) {
                        vipAdFreeGuideLayout.setBottomCornerRound(false);
                        vipAdFreeGuideLayout.setAllCornerRound(true);
                    }
                }
            } else if (vipAdFreeGuideLayout != null) {
                vipAdFreeGuideLayout.setBottomCornerRound(true);
            }
        }
    }

    public static void c(VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, vipAdFreeGuideLayout, str, str2, str3) == null) {
            if ("personalize".equals(str2)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.RECOMMEND, str);
            } else if ("frs_new_tab".equals(str3)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.FRS_NEW, str);
            } else if ("frs_hot_tab".equals(str3)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.FRS_HOT, str);
            } else if ("pb".equals(str2)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.PB, str);
            }
        }
    }

    public static void d(FunAdNativeViewHolder funAdNativeViewHolder, VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, str3, Integer.valueOf(i)}) != null) || vipAdFreeGuideLayout == null) {
            return;
        }
        vipAdFreeGuideLayout.setVisibility(0);
        b(funAdNativeViewHolder, vipAdFreeGuideLayout, str2, str3, i);
        vipAdFreeGuideLayout.f();
        c(vipAdFreeGuideLayout, str, str2, str3);
    }

    public static void e(jp8 jp8Var, FunAdNativeViewHolder funAdNativeViewHolder, String str, String str2, String str3, int i) {
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jp8Var, funAdNativeViewHolder, str, str2, str3, Integer.valueOf(i)}) == null) {
            VipAdFreeGuideLayout vipAdFreeGuideLayout = funAdNativeViewHolder.d().getVipAdFreeGuideLayout();
            if (jp8Var != null && vipAdFreeGuideLayout != null) {
                if ("personalize".equals(str2)) {
                    f = tq5.k().j(jp8Var.g());
                } else {
                    f = jp8Var.f();
                }
                if (f == 1) {
                    vipAdFreeGuideLayout.setVisibility(8);
                } else if (f == 2) {
                    d(funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, str3, i);
                } else if (a(str2, str3, i)) {
                    d(funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, str3, i);
                    tq5.k().c();
                    if ("personalize".equals(str2)) {
                        tq5.k().p(jp8Var.g(), 2);
                    } else {
                        jp8Var.q(2);
                    }
                } else {
                    vipAdFreeGuideLayout.setVisibility(8);
                    if ("personalize".equals(str2)) {
                        tq5.k().p(jp8Var.g(), 1);
                    } else {
                        jp8Var.q(1);
                    }
                }
            }
        }
    }
}
