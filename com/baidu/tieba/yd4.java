package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class yd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ae4 a(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            Response executeSync = ib4.g().getRequest().requestFrom(6).requestSubFrom(i).url(str).build().executeSync();
            if (executeSync == null) {
                return null;
            }
            return new wd4(executeSync);
        }
        return (ae4) invokeLI.objValue;
    }
}
