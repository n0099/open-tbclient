package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity cDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.cDW = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        i iVar;
        a aVar;
        i iVar2;
        i iVar3;
        i iVar4;
        if (httpResponsedMessage != null) {
            this.cDW.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.cDW.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cDW.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.cDW.cDJ;
                        this.cDW.mHandler.postDelayed(new d(this, iVar.aoN()), 500L);
                        return;
                    }
                    return;
                }
                this.cDW.showToast(i.h.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.cDW.cDK;
                    aVar.Y(operation, type);
                    iVar2 = this.cDW.cDJ;
                    iVar2.aa(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.cDW.cDJ;
                m411getInst.setLocationShared(iVar3.aoN());
                iVar4 = this.cDW.cDJ;
                iVar4.fI(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
