package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.IH5PayActivityVisit;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes8.dex */
public class vjc implements IH5PayActivityVisit {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vjc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.IH5PayActivityVisit
    public void notifyPayFlowActivityVisit(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, str, i, i2, i3) == null) {
            RLog.info("H5PayActivityVisitImpl", "notifyPayFlowActivityVisit mAppId:" + i + " mUserChannel:" + i2 + " name:" + str);
            PayFlowType a = flc.a(i3);
            if (a == null) {
                RLog.error("H5PayActivityVisitImpl", "notifyPayFlowActivityVisit mAppId:" + i + " mUserChannel:" + i2 + " name:" + str + " payFlowType null", new Object[0]);
                return;
            }
            ekc.b(str, i, i2, a);
        }
    }
}
