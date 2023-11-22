package com.baidu.tieba;

import com.baidu.tieba.ebd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayAmountView;
/* loaded from: classes7.dex */
public class pad {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ebd.b a(n9d n9dVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, n9dVar, list, str, viewParams)) == null) {
            ebd.b bVar = new ebd.b();
            bVar.c = n9dVar;
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
        return (ebd.b) invokeLLLL.objValue;
    }
}
