package com.baidu.tieba;

import com.baidu.tieba.ne7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class oe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ne7.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            ne7.a aVar = new ne7.a();
            aVar.f(null);
            aVar.c(R.color.CAM_X0605);
            aVar.e(R.color.CAM_X0101);
            aVar.b(R.color.CAM_X0101);
            return aVar;
        }
        return (ne7.a) invokeV.objValue;
    }

    public static final ne7.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ne7.a aVar = new ne7.a();
            aVar.c(R.color.CAM_X0620);
            aVar.e(R.color.CAM_X0611);
            aVar.b(R.color.CAM_X0611);
            return aVar;
        }
        return (ne7.a) invokeV.objValue;
    }

    public static final ne7.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ne7.a aVar = new ne7.a();
            aVar.c(R.color.CAM_X0620);
            aVar.e(R.color.CAM_X0310);
            aVar.b(R.color.CAM_X0611);
            return aVar;
        }
        return (ne7.a) invokeV.objValue;
    }

    public static final ne7.a b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return new ne7.a();
                    }
                    return d();
                }
                return c();
            }
            return a();
        }
        return (ne7.a) invokeI.objValue;
    }
}
