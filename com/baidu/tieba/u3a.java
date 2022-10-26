package com.baidu.tieba;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes6.dex */
public interface u3a {
    void a(Activity activity, PayFlowType payFlowType, h5a h5aVar, e5a e5aVar, AppCustomExpand appCustomExpand, Map map, IPayCallback iPayCallback, String str);
}
