package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ AccountSafeActivity ebX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AccountSafeActivity accountSafeActivity, int i, int i2) {
        super(i, i2);
        this.ebX = accountSafeActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (this.ebX.ebT != null) {
            this.ebX.ebT.setLoading(false);
        }
        this.ebX.closeLoadingDialog();
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.ebX.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.ebX.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                return;
            }
            com.baidu.tieba.setting.im.more.a aVar = null;
            if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
            }
            if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
            }
            if (aVar != null && aVar.aMW() != null) {
                this.ebX.ebU = aVar.aMW().secureemail;
                this.ebX.ebV = aVar.aMW().securemobil;
                if (this.ebX.ebT != null) {
                    this.ebX.ebT.il(true);
                }
            }
            if (this.ebX.ebS != null) {
                this.ebX.ebS.d(aVar);
            }
        }
    }
}
