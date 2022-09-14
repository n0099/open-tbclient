package com.baidu.tieba;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes5.dex */
public interface n2a {
    void a(Activity activity, PayFlowType payFlowType, a4a a4aVar, x3a x3aVar, AppCustomExpand appCustomExpand, Map<String, String> map, IPayCallback iPayCallback, String str);
}
