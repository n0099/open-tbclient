package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ PaymentConfirmActivity cdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PaymentConfirmActivity paymentConfirmActivity) {
        this.cdS = paymentConfirmActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
