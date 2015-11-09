package com.baidu.tieba.payment;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ PaymentConfirmActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PaymentConfirmActivity paymentConfirmActivity) {
        this.ceE = paymentConfirmActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String jA;
        String jA2;
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        jA = this.ceE.jA("payment_confirm_show");
        tu.putBoolean(jA, !z);
        if (!z) {
            com.baidu.tbadk.core.sharedPref.b tu2 = com.baidu.tbadk.core.sharedPref.b.tu();
            jA2 = this.ceE.jA("payment_confirm_notshow_count");
            tu2.putInt(jA2, 0);
        }
    }
}
