package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class p implements a.b {
    final /* synthetic */ PaymentConfirmActivity cHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PaymentConfirmActivity paymentConfirmActivity) {
        this.cHo = paymentConfirmActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
