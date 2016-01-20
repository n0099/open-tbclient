package com.baidu.tieba.payment;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity cAI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PaymentConfirmActivity paymentConfirmActivity) {
        this.cAI = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.cAI.cAC;
        if (!z) {
            z2 = this.cAI.cAB;
            if (z2) {
                t.ko("c10292");
                this.cAI.akh();
                return;
            }
            t.ko("c10293");
            this.cAI.akg();
            return;
        }
        this.cAI.K(0, null);
    }
}
