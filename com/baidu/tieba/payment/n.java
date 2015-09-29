package com.baidu.tieba.payment;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class n implements TextWatcher {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aml;
    final /* synthetic */ PaymentConfirmActivity cdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PaymentConfirmActivity paymentConfirmActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.cdS = paymentConfirmActivity;
        this.aml = aVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.aml.am(!StringUtils.isNull(editable.toString()));
    }
}
