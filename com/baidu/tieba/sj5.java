package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.NewGodInfo;
/* loaded from: classes5.dex */
public class sj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(NewGodData newGodData) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newGodData)) == null) {
            if (newGodData != null && newGodData.getType() == 2) {
                z = true;
            } else {
                z = false;
            }
            return c(z);
        }
        return (String) invokeL.objValue;
    }

    public static String b(NewGodInfo newGodInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newGodInfo)) == null) {
            if (newGodInfo != null && newGodInfo.type.intValue() == 2) {
                z = true;
            } else {
                z = false;
            }
            return c(z);
        }
        return (String) invokeL.objValue;
    }

    public static String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0630);
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f062f);
        }
        return (String) invokeZ.objValue;
    }
}
