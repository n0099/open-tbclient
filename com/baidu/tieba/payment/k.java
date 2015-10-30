package com.baidu.tieba.payment;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity ced;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PaymentConfirmActivity paymentConfirmActivity) {
        this.ced = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.ced.cdZ;
        if (!z) {
            z2 = this.ced.cdY;
            if (z2) {
                r.jz("c10292");
                this.ced.aen();
                return;
            }
            r.jz("c10293");
            this.ced.aem();
            return;
        }
        this.ced.I(0, null);
    }
}
