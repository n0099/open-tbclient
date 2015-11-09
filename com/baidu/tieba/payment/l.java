package com.baidu.tieba.payment;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ PaymentConfirmActivity ceE;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PaymentConfirmActivity paymentConfirmActivity, String str) {
        this.ceE = paymentConfirmActivity;
        this.tz = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        q qVar;
        aVar.dismiss();
        qVar = this.ceE.cew;
        String aeQ = qVar.aeQ();
        if (StringUtils.isNull(aeQ)) {
            return;
        }
        this.ceE.a(this.tz, aeQ, null, null, null, false);
    }
}
