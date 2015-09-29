package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    private final /* synthetic */ String RX;
    final /* synthetic */ PaymentConfirmActivity cdS;
    private final /* synthetic */ int cdT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PaymentConfirmActivity paymentConfirmActivity, int i, String str) {
        this.cdS = paymentConfirmActivity;
        this.cdT = i;
        this.RX = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cdS.J(this.cdT, this.RX);
    }
}
