package com.baidu.tieba.payment;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ PaymentConfirmActivity cAI;
    private final /* synthetic */ String tC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PaymentConfirmActivity paymentConfirmActivity, String str) {
        this.cAI = paymentConfirmActivity;
        this.tC = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        sVar = this.cAI.cAy;
        String ako = sVar.ako();
        if (StringUtils.isNull(ako)) {
            return;
        }
        this.cAI.a(this.tC, ako, null, null, null, false);
    }
}
