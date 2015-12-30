package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class p implements a.b {
    final /* synthetic */ PaymentConfirmActivity cAI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PaymentConfirmActivity paymentConfirmActivity) {
        this.cAI = paymentConfirmActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
