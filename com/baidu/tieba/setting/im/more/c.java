package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity cMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.cMS = secretSettingActivity;
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
            this.cMS.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.cMS.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cMS.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.cMS.cMF;
                        this.cMS.mHandler.postDelayed(new d(this, iVar.arN()), 500L);
                        return;
                    }
                    return;
                }
                this.cMS.showToast(i.h.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.cMS.cMG;
                    aVar.aa(operation, type);
                    iVar2 = this.cMS.cMF;
                    iVar2.ac(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.cMS.cMF;
                m411getInst.setLocationShared(iVar3.arN());
                iVar4 = this.cMS.cMF;
                iVar4.fW(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
