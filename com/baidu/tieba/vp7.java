package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public final class vp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(SpriteBottomTipView.a aVar, FrsSpriteNewUserGuide.BubbleText bubbleText) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeColorInfo themeColorInfo2;
        ThemeElement themeElement2;
        FrsSpriteNewUserGuide.ButtonInfo buttonInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, aVar, bubbleText) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            ThemeColorInfo themeColorInfo3 = null;
            if (bubbleText != null) {
                str = bubbleText.title;
            } else {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f087e);
            }
            aVar.s(str);
            if (bubbleText != null) {
                str2 = bubbleText.text;
            } else {
                str2 = null;
            }
            aVar.g(str2);
            if (bubbleText != null && (buttonInfo = bubbleText.buttonInfo) != null) {
                str3 = buttonInfo.text;
            } else {
                str3 = null;
            }
            aVar.e(str3);
            if (bubbleText != null && (themeColorInfo2 = bubbleText.bgUrlTheme) != null && (themeElement2 = themeColorInfo2.day) != null) {
                str4 = themeElement2.pattern_image;
            } else {
                str4 = null;
            }
            aVar.c(str4);
            if (bubbleText != null && (themeColorInfo = bubbleText.bgUrlTheme) != null && (themeElement = themeColorInfo.dark) != null) {
                str5 = themeElement.pattern_image;
            } else {
                str5 = null;
            }
            aVar.b(str5);
            if (bubbleText != null) {
                themeColorInfo3 = bubbleText.textColor;
            }
            b(aVar, themeColorInfo3);
        }
    }

    public static final void b(SpriteBottomTipView.a aVar, ThemeColorInfo themeColorInfo) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, aVar, themeColorInfo) == null) && themeColorInfo != null) {
            ThemeElement themeElement = themeColorInfo.day;
            String str2 = null;
            if (themeElement != null) {
                str = themeElement.font_color;
            } else {
                str = null;
            }
            int f = zfa.f(str);
            if (!zfa.e(f)) {
                aVar.t(Integer.valueOf(f));
                aVar.h(Integer.valueOf(f));
            }
            ThemeElement themeElement2 = themeColorInfo.dark;
            if (themeElement2 != null) {
                str2 = themeElement2.font_color;
            }
            int f2 = zfa.f(str2);
            if (!zfa.e(f2)) {
                aVar.v(Integer.valueOf(f2));
                aVar.j(Integer.valueOf(f2));
            }
        }
    }

    public static final void c(SpriteBottomTipView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            oa5 oa5Var = new oa5();
            oa5Var.s(R.color.CAM_X0601, R.color.CAM_X0920);
            oa5Var.k(UtilHelper.getDimenPixelSize(R.dimen.tbds10), UtilHelper.getDimenPixelSize(R.dimen.tbds10));
            oa5Var.p(0);
            oa5Var.n(0);
            oa5Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            oa5Var.f(1);
            oa5Var.j(0, R.drawable.ic_icon_mybar_pure_list_arrow16_right, TBSpecificationButtonConfig.IconType.WEBP);
            aVar.d(oa5Var);
            aVar.f(R.dimen.T_X07);
        }
    }

    public static final void d(SpriteBottomTipView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            aVar.w(R.dimen.T_X05);
            aVar.k(R.dimen.T_X07);
            aVar.u(R.color.CAM_X0610);
            aVar.i(R.color.CAM_X0610);
        }
    }
}
