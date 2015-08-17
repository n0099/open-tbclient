package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity cvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.cvA = secretSettingActivity;
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
        this.cvA.hideProgressBar();
        if (responsedMessage != null) {
            this.cvA.cvp = true;
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.cvA.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cvA.getResources().getString(i.C0057i.neterror) : responsedMessage.getErrorString());
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
                aVar = this.cvA.cvo;
                aVar.a(aVar6);
                aVar2 = this.cvA.cvo;
                aVar2.akq();
                iVar = this.cvA.cvn;
                iVar.eW(true);
                iVar2 = this.cvA.cvn;
                aVar3 = this.cvA.cvo;
                iVar2.c(aVar3);
                SecretSettingActivity secretSettingActivity = this.cvA;
                aVar4 = this.cvA.cvo;
                secretSettingActivity.b(aVar4);
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                aVar5 = this.cvA.cvo;
                m411getInst.setLocationShared(aVar5.aks());
            }
        }
    }
}
