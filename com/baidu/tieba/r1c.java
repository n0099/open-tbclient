package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes7.dex */
public class r1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PayFlowType a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i == PayFlowType.DIOALOG_PAY_FLOW.getTypeId()) {
                return PayFlowType.DIOALOG_PAY_FLOW;
            }
            if (i == PayFlowType.WALLET_PAY_FLOW.getTypeId()) {
                return PayFlowType.WALLET_PAY_FLOW;
            }
            return null;
        }
        return (PayFlowType) invokeI.objValue;
    }
}
