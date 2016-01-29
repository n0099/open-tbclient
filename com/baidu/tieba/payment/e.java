package com.baidu.tieba.payment;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity cHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PaymentConfirmActivity paymentConfirmActivity) {
        this.cHo = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cHo.N(2270066, this.cHo.getResources().getString(t.j.payment_input_password_find));
    }
}
