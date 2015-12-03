package com.baidu.tieba.payment;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ PaymentConfirmActivity cxe;
    private final /* synthetic */ String tA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PaymentConfirmActivity paymentConfirmActivity, String str) {
        this.cxe = paymentConfirmActivity;
        this.tA = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        sVar = this.cxe.cwU;
        String aji = sVar.aji();
        if (StringUtils.isNull(aji)) {
            return;
        }
        this.cxe.a(this.tA, aji, null, null, null, false);
    }
}
