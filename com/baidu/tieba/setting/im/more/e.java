package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity dIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.dIu = secretSettingActivity;
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
        this.dIu.hideProgressBar();
        if (responsedMessage != null) {
            this.dIu.dIk = true;
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.dIu.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.dIu.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
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
                aVar = this.dIu.dIj;
                aVar.a(aVar6);
                aVar2 = this.dIu.dIj;
                aVar2.aGj();
                iVar = this.dIu.dIi;
                iVar.ht(true);
                iVar2 = this.dIu.dIi;
                aVar3 = this.dIu.dIj;
                iVar2.c(aVar3);
                SecretSettingActivity secretSettingActivity = this.dIu;
                aVar4 = this.dIu.dIj;
                secretSettingActivity.b(aVar4);
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                aVar5 = this.dIu.dIj;
                m411getInst.setLocationShared(aVar5.aGl());
            }
        }
    }
}
