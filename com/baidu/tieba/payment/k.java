package com.baidu.tieba.payment;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PaymentConfirmActivity paymentConfirmActivity) {
        this.ceE = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.ceE.ceA;
        if (!z) {
            z2 = this.ceE.cez;
            if (z2) {
                r.jB("c10292");
                this.ceE.aeI();
                return;
            }
            r.jB("c10293");
            this.ceE.aeH();
            return;
        }
        this.ceE.J(0, null);
    }
}
