package com.baidu.tieba;

import android.graphics.Color;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return Color.parseColor(b(str));
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f040e) + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13b2) + str;
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f040e) + str;
        }
        return (String) invokeL.objValue;
    }
}
