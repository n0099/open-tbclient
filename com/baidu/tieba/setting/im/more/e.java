package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity cdX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.cdX = secretSettingActivity;
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
        if (responsedMessage != null) {
            this.cdX.cdN = true;
            this.cdX.hideProgressBar();
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.cdX.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cdX.getResources().getString(t.neterror) : responsedMessage.getErrorString());
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
                aVar = this.cdX.cdM;
                aVar.a(aVar6);
                aVar2 = this.cdX.cdM;
                aVar2.aic();
                iVar = this.cdX.cdL;
                iVar.eE(true);
                iVar2 = this.cdX.cdL;
                aVar3 = this.cdX.cdM;
                iVar2.c(aVar3);
                SecretSettingActivity secretSettingActivity = this.cdX;
                aVar4 = this.cdX.cdM;
                secretSettingActivity.b(aVar4);
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                aVar5 = this.cdX.cdM;
                m411getInst.setLocationShared(aVar5.aie());
            }
        }
    }
}
