package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ PaymentConfirmActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PaymentConfirmActivity paymentConfirmActivity) {
        this.ceE = paymentConfirmActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
