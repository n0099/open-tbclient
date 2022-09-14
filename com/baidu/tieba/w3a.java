package com.baidu.tieba;

import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes6.dex */
public interface w3a {
    GetBannerConfigReqParams a();

    p1a b(PayFlowType payFlowType, Map<String, String> map);

    QueryCurrencyReqParams c();

    QueryCurrencyReqParams d(Map<String, String> map);
}
