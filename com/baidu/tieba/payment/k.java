package com.baidu.tieba.payment;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity cdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PaymentConfirmActivity paymentConfirmActivity) {
        this.cdS = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.cdS.cdO;
        if (!z) {
            z2 = this.cdS.cdN;
            if (z2) {
                r.jz("c10292");
                this.cdS.aer();
                return;
            }
            r.jz("c10293");
            this.cdS.aeq();
            return;
        }
        this.cdS.I(0, null);
    }
}
