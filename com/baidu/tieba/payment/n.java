package com.baidu.tieba.payment;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity cxe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PaymentConfirmActivity paymentConfirmActivity) {
        this.cxe = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.cxe.cwY;
        if (!z) {
            z2 = this.cxe.cwX;
            if (z2) {
                t.kr("c10292");
                this.cxe.ajb();
                return;
            }
            t.kr("c10293");
            this.cxe.aja();
            return;
        }
        this.cxe.K(0, null);
    }
}
