package com.baidu.tieba;

import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static qf4 a(Node node) {
        InterceptResult invokeL;
        Class<? extends qf4> processor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, node)) == null) {
            if (node == null || (processor = node.getProcessor()) == null) {
                return null;
            }
            try {
                return processor.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
                return null;
            }
        }
        return (qf4) invokeL.objValue;
    }
}
