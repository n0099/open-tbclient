package com.baidu.tieba;

import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes8.dex */
public interface wsb {
    void a(PayFlowType payFlowType);

    void b(PayFlowType payFlowType, PayDialogType payDialogType);

    void c(String str, PayFlowType payFlowType);

    void d(String str, PayFlowType payFlowType);
}
