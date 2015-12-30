package com.baidu.tieba.payment;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ PaymentConfirmActivity cAI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PaymentConfirmActivity paymentConfirmActivity) {
        this.cAI = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cAI.L(2270066, this.cAI.getResources().getString(n.j.payment_input_password_find));
    }
}
