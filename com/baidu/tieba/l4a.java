package com.baidu.tieba;

import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes4.dex */
public interface l4a {
    GetBannerConfigReqParams a();

    e2a b(PayFlowType payFlowType, Map<String, String> map);

    QueryCurrencyReqParams c();

    QueryCurrencyReqParams d(Map<String, String> map);
}
