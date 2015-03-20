package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity bZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.bZp = secretSettingActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        a aVar2;
        g gVar;
        g gVar2;
        a aVar3;
        a aVar4;
        if (responsedMessage != null) {
            this.bZp.bZl = true;
            this.bZp.hideProgressBar();
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.bZp.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bZp.getResources().getString(y.neterror) : responsedMessage.getErrorString());
                return;
            }
            a aVar5 = null;
            if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                aVar5 = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
            }
            if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                aVar5 = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
            }
            if (aVar5 != null) {
                aVar = this.bZp.bZk;
                aVar.a(aVar5);
                aVar2 = this.bZp.bZk;
                aVar2.afX();
                gVar = this.bZp.bZj;
                gVar.ep(true);
                gVar2 = this.bZp.bZj;
                aVar3 = this.bZp.bZk;
                gVar2.b(aVar3);
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                aVar4 = this.bZp.bZk;
                m411getInst.setLocationShared(aVar4.afZ());
            }
        }
    }
}
