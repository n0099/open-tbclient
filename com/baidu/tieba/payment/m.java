package com.baidu.tieba.payment;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ PaymentConfirmActivity cHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PaymentConfirmActivity paymentConfirmActivity) {
        this.cHo = paymentConfirmActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String kq;
        String kq2;
        com.baidu.tbadk.core.sharedPref.b uO = com.baidu.tbadk.core.sharedPref.b.uO();
        kq = this.cHo.kq("payment_confirm_show");
        uO.putBoolean(kq, !z);
        if (!z) {
            com.baidu.tbadk.core.sharedPref.b uO2 = com.baidu.tbadk.core.sharedPref.b.uO();
            kq2 = this.cHo.kq("payment_confirm_notshow_count");
            uO2.putInt(kq2, 0);
        }
    }
}
