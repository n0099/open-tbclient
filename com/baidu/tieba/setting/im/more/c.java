package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity dsq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.dsq = secretSettingActivity;
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
            this.dsq.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.dsq.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dsq.getResources().getString(n.j.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.dsq.dse;
                        this.dsq.mHandler.postDelayed(new d(this, iVar.azs()), 500L);
                        return;
                    }
                    return;
                }
                this.dsq.showToast(n.j.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.dsq.dsf;
                    aVar.ag(operation, type);
                    iVar2 = this.dsq.dse;
                    iVar2.ai(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.dsq.dse;
                m411getInst.setLocationShared(iVar3.azs());
                iVar4 = this.dsq.dse;
                iVar4.gU(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
