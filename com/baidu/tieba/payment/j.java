package com.baidu.tieba.payment;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ PaymentConfirmActivity ced;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PaymentConfirmActivity paymentConfirmActivity) {
        this.ced = paymentConfirmActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String jy;
        String jy2;
        com.baidu.tbadk.core.sharedPref.b tr = com.baidu.tbadk.core.sharedPref.b.tr();
        jy = this.ced.jy("payment_confirm_show");
        tr.putBoolean(jy, !z);
        if (!z) {
            com.baidu.tbadk.core.sharedPref.b tr2 = com.baidu.tbadk.core.sharedPref.b.tr();
            jy2 = this.ced.jy("payment_confirm_notshow_count");
            tr2.putInt(jy2, 0);
        }
    }
}
