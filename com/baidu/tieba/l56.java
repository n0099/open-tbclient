package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l56 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947893916, "Lcom/baidu/tieba/l56;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947893916, "Lcom/baidu/tieba/l56;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds130);
        b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds226);
        c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds30);
        d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds800);
    }
}
