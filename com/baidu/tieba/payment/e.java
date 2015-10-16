package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    private final /* synthetic */ String RY;
    final /* synthetic */ PaymentConfirmActivity ced;
    private final /* synthetic */ int cee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PaymentConfirmActivity paymentConfirmActivity, int i, String str) {
        this.ced = paymentConfirmActivity;
        this.cee = i;
        this.RY = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.ced.J(this.cee, this.RY);
    }
}
