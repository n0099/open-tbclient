package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity eaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.eaO = secretSettingActivity;
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
            this.eaO.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.eaO.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.eaO.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.eaO.eaC;
                        this.eaO.mHandler.postDelayed(new d(this, iVar.aNj()), 500L);
                        return;
                    }
                    return;
                }
                this.eaO.showToast(t.j.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.eaO.eaD;
                    aVar.aq(operation, type);
                    iVar2 = this.eaO.eaC;
                    iVar2.as(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.eaO.eaC;
                m411getInst.setLocationShared(iVar3.aNj());
                iVar4 = this.eaO.eaC;
                iVar4.ii(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
