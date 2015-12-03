package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity dlj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.dlj = secretSettingActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        a aVar2;
        i iVar;
        i iVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        this.dlj.hideProgressBar();
        if (responsedMessage != null) {
            this.dlj.dkY = true;
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.dlj.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.dlj.getResources().getString(n.i.neterror) : responsedMessage.getErrorString());
                return;
            }
            a aVar6 = null;
            if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                aVar6 = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
            }
            if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                aVar6 = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
            }
            if (aVar6 != null) {
                aVar = this.dlj.dkX;
                aVar.a(aVar6);
                aVar2 = this.dlj.dkX;
                aVar2.awV();
                iVar = this.dlj.dkW;
                iVar.gL(true);
                iVar2 = this.dlj.dkW;
                aVar3 = this.dlj.dkX;
                iVar2.c(aVar3);
                SecretSettingActivity secretSettingActivity = this.dlj;
                aVar4 = this.dlj.dkX;
                secretSettingActivity.b(aVar4);
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                aVar5 = this.dlj.dkX;
                m411getInst.setLocationShared(aVar5.awX());
            }
        }
    }
}
