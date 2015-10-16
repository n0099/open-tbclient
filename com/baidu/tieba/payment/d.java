package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ PaymentConfirmActivity ced;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PaymentConfirmActivity paymentConfirmActivity) {
        this.ced = paymentConfirmActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
