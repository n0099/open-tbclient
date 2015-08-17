package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity cvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.cvA = secretSettingActivity;
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
            this.cvA.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.cvA.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cvA.getResources().getString(i.C0057i.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.cvA.cvn;
                        this.cvA.mHandler.postDelayed(new d(this, iVar.akG()), 500L);
                        return;
                    }
                    return;
                }
                this.cvA.showToast(i.C0057i.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.cvA.cvo;
                    aVar.W(operation, type);
                    iVar2 = this.cvA.cvn;
                    iVar2.Y(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.cvA.cvn;
                m411getInst.setLocationShared(iVar3.akG());
                iVar4 = this.cvA.cvn;
                iVar4.eX(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
