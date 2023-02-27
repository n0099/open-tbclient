package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public final class td9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
        r2 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int a(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            String str2 = "";
            if (skinType != 0) {
                if (skinType == 4) {
                    ThemeElement themeElement = themeColorInfoInfo.dark;
                    if (themeElement != null) {
                        str = themeElement.common_color;
                    }
                }
                if (str2.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return b49.f(str2);
                }
                return Integer.MAX_VALUE;
            }
            ThemeElement themeElement2 = themeColorInfoInfo.day;
            if (themeElement2 != null) {
                str = themeElement2.common_color;
            }
        } else {
            return invokeL.intValue;
        }
    }

    public static final String b(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.dark_color;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.dark_color;
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String c(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.light_color;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.light_color;
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String d(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.pattern_image;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.pattern_image;
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
