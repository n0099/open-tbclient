package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity dlj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.dlj = secretSettingActivity;
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
            this.dlj.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.dlj.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dlj.getResources().getString(n.i.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.dlj.dkW;
                        this.dlj.mHandler.postDelayed(new d(this, iVar.axl()), 500L);
                        return;
                    }
                    return;
                }
                this.dlj.showToast(n.i.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.dlj.dkX;
                    aVar.af(operation, type);
                    iVar2 = this.dlj.dkW;
                    iVar2.ah(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.dlj.dkW;
                m411getInst.setLocationShared(iVar3.axl());
                iVar4 = this.dlj.dkW;
                iVar4.gM(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
