package com.baidu.tieba.payment;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity cHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PaymentConfirmActivity paymentConfirmActivity) {
        this.cHo = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.cHo.cHi;
        if (!z) {
            z2 = this.cHo.cHh;
            if (z2) {
                t.kr("c10292");
                this.cHo.aof();
                return;
            }
            t.kr("c10293");
            this.cHo.aoe();
            return;
        }
        this.cHo.M(0, null);
    }
}
