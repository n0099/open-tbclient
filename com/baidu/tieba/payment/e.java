package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    private final /* synthetic */ String RZ;
    final /* synthetic */ PaymentConfirmActivity ceE;
    private final /* synthetic */ int ceF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PaymentConfirmActivity paymentConfirmActivity, int i, String str) {
        this.ceE = paymentConfirmActivity;
        this.ceF = i;
        this.RZ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.ceE.K(this.ceF, this.RZ);
    }
}
