package com.baidu.tieba;

import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public final class tg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (ih5.b.a().a("show_write_tip")) {
                od5 a = hh5.b.a().a();
                if (a != null && a.b == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final int b(boolean z) {
        InterceptResult invokeZ;
        ThemeColorInfo themeColorInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (!z) {
                return SkinManager.getColor(R.color.CAM_X0110);
            }
            od5 a = hh5.b.a().a();
            if (a != null) {
                themeColorInfo = a.f;
            } else {
                themeColorInfo = null;
            }
            if (a() && themeColorInfo != null) {
                return SkinManager.getColorFromServerColor(themeColorInfo, R.color.CAM_X0301);
            }
            return SkinManager.getColor(R.color.CAM_X0302);
        }
        return invokeZ.intValue;
    }
}
