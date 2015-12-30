package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    private final /* synthetic */ String SM;
    final /* synthetic */ PaymentConfirmActivity cAI;
    private final /* synthetic */ int cAJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PaymentConfirmActivity paymentConfirmActivity, int i, String str) {
        this.cAI = paymentConfirmActivity;
        this.cAJ = i;
        this.SM = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cAI.L(this.cAJ, this.SM);
    }
}
