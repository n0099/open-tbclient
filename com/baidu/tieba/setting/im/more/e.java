package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity dsq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.dsq = secretSettingActivity;
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
        this.dsq.hideProgressBar();
        if (responsedMessage != null) {
            this.dsq.dsg = true;
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.dsq.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.dsq.getResources().getString(n.j.neterror) : responsedMessage.getErrorString());
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
                aVar = this.dsq.dsf;
                aVar.a(aVar6);
                aVar2 = this.dsq.dsf;
                aVar2.azc();
                iVar = this.dsq.dse;
                iVar.gT(true);
                iVar2 = this.dsq.dse;
                aVar3 = this.dsq.dsf;
                iVar2.c(aVar3);
                SecretSettingActivity secretSettingActivity = this.dsq;
                aVar4 = this.dsq.dsf;
                secretSettingActivity.b(aVar4);
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                aVar5 = this.dsq.dsf;
                m411getInst.setLocationShared(aVar5.aze());
            }
        }
    }
}
