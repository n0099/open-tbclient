package com.baidu.tieba;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes5.dex */
public interface t0a {
    void a(Activity activity, PayFlowType payFlowType, g2a g2aVar, d2a d2aVar, AppCustomExpand appCustomExpand, Map<String, String> map, IPayCallback iPayCallback, String str);
}
