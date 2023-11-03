package com.baidu.tieba;

import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes8.dex */
public interface r6d {
    GetBannerConfigReqParams a();

    QueryCurrencyReqParams b();

    u6d c(PayFlowType payFlowType, Map<String, String> map);

    QueryCurrencyReqParams d(PayFlowType payFlowType, Map<String, String> map);

    GetSplitOrderConfigReqParams e(int i, String str, long j);
}
