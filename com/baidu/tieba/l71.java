package com.baidu.tieba;

import android.content.pm.PackageInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class l71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PackageInfo a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            if (new File(str).exists()) {
                return ContextHolder.getApplicationContext().getPackageManager().getPackageArchiveInfo(str, i);
            }
            return null;
        }
        return (PackageInfo) invokeLI.objValue;
    }
}
