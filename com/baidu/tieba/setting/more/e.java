package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ AccountSafeActivity cNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AccountSafeActivity accountSafeActivity, int i, int i2) {
        super(i, i2);
        this.cNW = accountSafeActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (this.cNW.cNS != null) {
            this.cNW.cNS.setLoading(false);
        }
        this.cNW.closeLoadingDialog();
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.cNW.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cNW.getResources().getString(i.h.neterror) : responsedMessage.getErrorString());
                return;
            }
            com.baidu.tieba.setting.im.more.a aVar = null;
            if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
            }
            if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
            }
            if (aVar != null && aVar.arA() != null) {
                this.cNW.cNT = aVar.arA().secureemail;
                this.cNW.cNU = aVar.arA().securemobil;
                if (this.cNW.cNS != null) {
                    this.cNW.cNS.fZ(true);
                }
            }
            if (this.cNW.cNR != null) {
                this.cNW.cNR.d(aVar);
            }
        }
    }
}
