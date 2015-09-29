package com.baidu.tieba.payment;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ PaymentConfirmActivity cdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PaymentConfirmActivity paymentConfirmActivity) {
        this.cdS = paymentConfirmActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String jy;
        String jy2;
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        jy = this.cdS.jy("payment_confirm_show");
        tu.putBoolean(jy, !z);
        if (!z) {
            com.baidu.tbadk.core.sharedPref.b tu2 = com.baidu.tbadk.core.sharedPref.b.tu();
            jy2 = this.cdS.jy("payment_confirm_notshow_count");
            tu2.putInt(jy2, 0);
        }
    }
}
