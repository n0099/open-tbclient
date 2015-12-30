package com.baidu.tieba.payment;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class q implements TextWatcher {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a apI;
    final /* synthetic */ PaymentConfirmActivity cAI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PaymentConfirmActivity paymentConfirmActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.cAI = paymentConfirmActivity;
        this.apI = aVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.apI.al(!StringUtils.isNull(editable.toString()));
    }
}
