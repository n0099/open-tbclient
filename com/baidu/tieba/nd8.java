package com.baidu.tieba;

import com.baidu.tieba.immessagecenter.arch.utils.NetWorkException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class nd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Exception a(int i, String str, Serializable serializable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65536, null, i, str, serializable)) == null) {
            return new NetWorkException("网络请求发生异常-错误码：" + i + "-错误描述：" + str + "-网络返回数据：" + serializable);
        }
        return (Exception) invokeILL.objValue;
    }
}
