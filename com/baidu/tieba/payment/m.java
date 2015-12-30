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
        String km;
        String km2;
        com.baidu.tbadk.core.sharedPref.b tJ = com.baidu.tbadk.core.sharedPref.b.tJ();
        km = this.cAI.km("payment_confirm_show");
        tJ.putBoolean(km, !z);
        if (!z) {
            com.baidu.tbadk.core.sharedPref.b tJ2 = com.baidu.tbadk.core.sharedPref.b.tJ();
            km2 = this.cAI.km("payment_confirm_notshow_count");
            tJ2.putInt(km2, 0);
        }
    }
}
