package com.baidu.tieba.payment;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ PaymentConfirmActivity cxe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PaymentConfirmActivity paymentConfirmActivity) {
        this.cxe = paymentConfirmActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String kq;
        String kq2;
        com.baidu.tbadk.core.sharedPref.b tZ = com.baidu.tbadk.core.sharedPref.b.tZ();
        kq = this.cxe.kq("payment_confirm_show");
        tZ.putBoolean(kq, !z);
        if (!z) {
            com.baidu.tbadk.core.sharedPref.b tZ2 = com.baidu.tbadk.core.sharedPref.b.tZ();
            kq2 = this.cxe.kq("payment_confirm_notshow_count");
            tZ2.putInt(kq2, 0);
        }
    }
}
