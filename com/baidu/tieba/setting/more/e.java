package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ AccountSafeActivity dmn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AccountSafeActivity accountSafeActivity, int i, int i2) {
        super(i, i2);
        this.dmn = accountSafeActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (this.dmn.dmj != null) {
            this.dmn.dmj.setLoading(false);
        }
        this.dmn.closeLoadingDialog();
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.dmn.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.dmn.getResources().getString(n.i.neterror) : responsedMessage.getErrorString());
                return;
            }
            com.baidu.tieba.setting.im.more.a aVar = null;
            if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
            }
            if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
            }
            if (aVar != null && aVar.awY() != null) {
                this.dmn.dmk = aVar.awY().secureemail;
                this.dmn.dml = aVar.awY().securemobil;
                if (this.dmn.dmj != null) {
                    this.dmn.dmj.gP(true);
                }
            }
            if (this.dmn.dmi != null) {
                this.dmn.dmi.d(aVar);
            }
        }
    }
}
