package com.baidu.tieba.payment;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ PaymentConfirmActivity cAI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PaymentConfirmActivity paymentConfirmActivity) {
        this.cAI = paymentConfirmActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String kn;
        String kn2;
        com.baidu.tbadk.core.sharedPref.b tJ = com.baidu.tbadk.core.sharedPref.b.tJ();
        kn = this.cAI.kn("payment_confirm_show");
        tJ.putBoolean(kn, !z);
        if (!z) {
            com.baidu.tbadk.core.sharedPref.b tJ2 = com.baidu.tbadk.core.sharedPref.b.tJ();
            kn2 = this.cAI.kn("payment_confirm_notshow_count");
            tJ2.putInt(kn2, 0);
        }
    }
}
