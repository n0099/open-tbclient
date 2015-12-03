package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    private final /* synthetic */ String So;
    final /* synthetic */ PaymentConfirmActivity cxe;
    private final /* synthetic */ int cxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PaymentConfirmActivity paymentConfirmActivity, int i, String str) {
        this.cxe = paymentConfirmActivity;
        this.cxf = i;
        this.So = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cxe.L(this.cxf, this.So);
    }
}
