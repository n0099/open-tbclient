package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.recapp.lego.view.AdCardBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ld8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, str, i, i2)) == null) {
            if (i != 2) {
                return i == 3 ? fm5.k().r(i2, AbsDataRecorder.Scene.PB) : i == 1 && "INDEX".equals(str) && fm5.k().s(AbsDataRecorder.Scene.RECOMMEND);
            } else if ("frs_new_tab".equals(str) && fm5.k().s(AbsDataRecorder.Scene.FRS_NEW)) {
                return true;
            } else {
                return "frs_hot_tab".equals(str) && fm5.k().s(AbsDataRecorder.Scene.FRS_HOT);
            }
        }
        return invokeLII.booleanValue;
    }

    public static void b(AdCardBaseView adCardBaseView, VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{adCardBaseView, vipAdFreeGuideLayout, str, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (i == 2 || i == 1) {
                if (vipAdFreeGuideLayout != null) {
                    vipAdFreeGuideLayout.setBottomCornerRound(true);
                }
            } else if (i == 3) {
                if (fm5.k().m() && i2 == 1) {
                    vipAdFreeGuideLayout.setBottomCornerRound(false);
                    vipAdFreeGuideLayout.setAllCornerRound(false);
                    if (adCardBaseView.getPbBottomView() != null) {
                        adCardBaseView.getPbBottomView().setVisibility(8);
                        return;
                    }
                    return;
                }
                if (vipAdFreeGuideLayout != null) {
                    vipAdFreeGuideLayout.setBottomCornerRound(false);
                    vipAdFreeGuideLayout.setAllCornerRound(true);
                }
                if (adCardBaseView.getPbBottomView() != null) {
                    adCardBaseView.getPbBottomView().setVisibility(0);
                }
            }
        }
    }

    public static void c(VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, null, vipAdFreeGuideLayout, str, str2, i) == null) {
            if (i == 2) {
                if ("frs_new_tab".equals(str2)) {
                    vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.FRS_NEW, str);
                } else if ("frs_hot_tab".equals(str2)) {
                    vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.FRS_HOT, str);
                }
            } else if (i == 3) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.PB, str);
            } else if (i == 1) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.RECOMMEND, str);
            }
        }
    }

    public static void d(AdCardBaseView adCardBaseView, VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{adCardBaseView, vipAdFreeGuideLayout, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || vipAdFreeGuideLayout == null) {
            return;
        }
        vipAdFreeGuideLayout.setVisibility(0);
        b(adCardBaseView, vipAdFreeGuideLayout, str2, i, i2);
        vipAdFreeGuideLayout.f();
        c(vipAdFreeGuideLayout, str, str2, i);
    }

    public static void e(AdvertAppInfo advertAppInfo, rf7<?> rf7Var, String str, String str2, int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{advertAppInfo, rf7Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            AdCardBaseView adCardBaseView = rf7Var instanceof AdCardBaseView ? (AdCardBaseView) rf7Var : null;
            VipAdFreeGuideLayout vipAdFreeGuideLayout = adCardBaseView != null ? adCardBaseView.getVipAdFreeGuideLayout() : null;
            if (vipAdFreeGuideLayout != null) {
                if (i == 1) {
                    i3 = fm5.k().j(advertAppInfo.a);
                } else {
                    i3 = advertAppInfo.s;
                }
                if (i3 == 1) {
                    vipAdFreeGuideLayout.setVisibility(8);
                } else if (i3 == 2) {
                    d(adCardBaseView, vipAdFreeGuideLayout, str, str2, i, i2);
                } else if (a(str2, i, i2)) {
                    d(adCardBaseView, vipAdFreeGuideLayout, str, str2, i, i2);
                    fm5.k().c();
                    if (i == 1) {
                        fm5.k().p(advertAppInfo.a, 2);
                    } else {
                        advertAppInfo.s = 2;
                    }
                } else {
                    vipAdFreeGuideLayout.setVisibility(8);
                    if (i == 1) {
                        fm5.k().p(advertAppInfo.a, 1);
                    } else {
                        advertAppInfo.s = 1;
                    }
                }
            }
        }
    }
}
