package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity eaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.eaO = secretSettingActivity;
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
        this.eaO.hideProgressBar();
        if (responsedMessage != null) {
            this.eaO.eaE = true;
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.eaO.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.eaO.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
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
                aVar = this.eaO.eaD;
                aVar.a(aVar6);
                aVar2 = this.eaO.eaD;
                aVar2.aMT();
                iVar = this.eaO.eaC;
                iVar.ih(true);
                iVar2 = this.eaO.eaC;
                aVar3 = this.eaO.eaD;
                iVar2.c(aVar3);
                SecretSettingActivity secretSettingActivity = this.eaO;
                aVar4 = this.eaO.eaD;
                secretSettingActivity.b(aVar4);
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                aVar5 = this.eaO.eaD;
                m411getInst.setLocationShared(aVar5.aMV());
            }
        }
    }
}
