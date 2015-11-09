package com.baidu.tieba.payment;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ PaymentConfirmActivity ceE;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PaymentConfirmActivity paymentConfirmActivity, String str) {
        this.ceE = paymentConfirmActivity;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.ceE.getPageContext().getPageActivity(), this.ceE.getResources().getString(i.h.payment_dilaog_error_button), this.val$url, true, true, true)));
    }
}
