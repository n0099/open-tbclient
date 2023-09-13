package com.baidu.tieba;

import com.baidu.tieba.jkc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayAmountView;
/* loaded from: classes8.dex */
public class ujc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static jkc.b a(sic sicVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, sicVar, list, str, viewParams)) == null) {
            jkc.b bVar = new jkc.b();
            bVar.c = sicVar;
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
        return (jkc.b) invokeLLLL.objValue;
    }
}
