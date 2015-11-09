package com.baidu.tieba.payment;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PaymentConfirmActivity paymentConfirmActivity) {
        this.ceE = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ceE.K(2270066, this.ceE.getResources().getString(i.h.payment_input_password_find));
    }
}
