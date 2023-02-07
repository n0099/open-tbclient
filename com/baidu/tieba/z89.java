package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public final class z89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        ThemeElement themeElement;
        String str;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            boolean z = true;
            String str2 = "";
            if (skinType == 0 ? (themeElement = themeColorInfoInfo.day) != null && (str = themeElement.common_color) != null : skinType == 1 ? (themeElement2 = themeColorInfoInfo.night) != null && (str = themeElement2.common_color) != null : skinType == 4 && (themeElement3 = themeColorInfoInfo.dark) != null && (str = themeElement3.common_color) != null) {
                str2 = str;
            }
            if (str2.length() <= 0) {
                z = false;
            }
            if (z) {
                return lz8.f(str2);
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static final String b(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        String str;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0) {
                if (skinType != 1) {
                    if (skinType != 4 || (themeElement = themeColorInfoInfo.dark) == null || (str = themeElement.dark_color) == null) {
                        return "";
                    }
                } else {
                    ThemeElement themeElement2 = themeColorInfoInfo.night;
                    if (themeElement2 == null || (str = themeElement2.dark_color) == null) {
                        return "";
                    }
                }
            } else {
                ThemeElement themeElement3 = themeColorInfoInfo.day;
                if (themeElement3 == null || (str = themeElement3.dark_color) == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String c(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        String str;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0) {
                if (skinType != 1) {
                    if (skinType != 4 || (themeElement = themeColorInfoInfo.dark) == null || (str = themeElement.light_color) == null) {
                        return "";
                    }
                } else {
                    ThemeElement themeElement2 = themeColorInfoInfo.night;
                    if (themeElement2 == null || (str = themeElement2.light_color) == null) {
                        return "";
                    }
                }
            } else {
                ThemeElement themeElement3 = themeColorInfoInfo.day;
                if (themeElement3 == null || (str = themeElement3.light_color) == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
