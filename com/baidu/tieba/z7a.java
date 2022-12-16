package com.baidu.tieba;

import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes7.dex */
public interface z7a {
    GetBannerConfigReqParams a();

    QueryCurrencyReqParams b();

    c8a c(PayFlowType payFlowType, Map<String, String> map);

    GetSplitOrderConfigReqParams d(int i, String str, long j);

    QueryCurrencyReqParams e(Map<String, String> map);
}
