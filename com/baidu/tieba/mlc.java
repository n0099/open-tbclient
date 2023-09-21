package com.baidu.tieba;

import com.baidu.tieba.bmc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayAmountView;
/* loaded from: classes7.dex */
public class mlc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bmc.b a(kkc kkcVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, kkcVar, list, str, viewParams)) == null) {
            bmc.b bVar = new bmc.b();
            bVar.c = kkcVar;
            bVar.a = list;
            bVar.b = str;
            if (viewParams != null) {
                bVar.d = viewParams.appCustomExpand;
                bVar.f = viewParams.viewEventListener;
                bVar.e = viewParams.clientInfoExpand;
                bVar.h = viewParams.windowParams;
                bVar.i = viewParams.showFaqPage;
                bVar.j = viewParams.splitOrderPayScene;
            }
            return bVar;
        }
        return (bmc.b) invokeLLLL.objValue;
    }
}
