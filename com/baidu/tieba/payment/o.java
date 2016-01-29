package com.baidu.tieba.payment;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ PaymentConfirmActivity cHo;
    private final /* synthetic */ String tL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PaymentConfirmActivity paymentConfirmActivity, String str) {
        this.cHo = paymentConfirmActivity;
        this.tL = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        s sVar;
        aVar.dismiss();
        sVar = this.cHo.cHe;
        String aom = sVar.aom();
        if (StringUtils.isNull(aom)) {
            return;
        }
        this.cHo.a(this.tL, aom, null, null, null, false);
    }
}
