package com.baidu.tieba.payment;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    private final /* synthetic */ String Sf;
    final /* synthetic */ PaymentConfirmActivity cHo;
    private final /* synthetic */ int cHp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PaymentConfirmActivity paymentConfirmActivity, int i, String str) {
        this.cHo = paymentConfirmActivity;
        this.cHp = i;
        this.Sf = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cHo.N(this.cHp, this.Sf);
    }
}
