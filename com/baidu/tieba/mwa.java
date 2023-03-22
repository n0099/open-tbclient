package com.baidu.tieba;

import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes5.dex */
public interface mwa {
    GetBannerConfigReqParams a();

    QueryCurrencyReqParams b();

    pwa c(PayFlowType payFlowType, Map<String, String> map);

    GetSplitOrderConfigReqParams d(int i, String str, long j);

    QueryCurrencyReqParams e(Map<String, String> map);
}
