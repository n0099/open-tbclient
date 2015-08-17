package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ AccountSafeActivity cwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AccountSafeActivity accountSafeActivity, int i, int i2) {
        super(i, i2);
        this.cwD = accountSafeActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (this.cwD.cwz != null) {
            this.cwD.cwz.setLoading(false);
        }
        this.cwD.closeLoadingDialog();
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.cwD.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cwD.getResources().getString(i.C0057i.neterror) : responsedMessage.getErrorString());
                return;
            }
            com.baidu.tieba.setting.im.more.a aVar = null;
            if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
            }
            if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
            }
            if (aVar != null && aVar.akt() != null) {
                this.cwD.cwA = aVar.akt().secureemail;
                this.cwD.cwB = aVar.akt().securemobil;
                if (this.cwD.cwz != null) {
                    this.cwD.cwz.fa(true);
                }
            }
            if (this.cwD.cwy != null) {
                this.cwD.cwy.d(aVar);
            }
        }
    }
}
