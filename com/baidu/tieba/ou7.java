package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ou7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PackageInfo a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return TbadkApplication.getInst().getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }
}
