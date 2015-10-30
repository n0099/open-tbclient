package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity cLw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.cLw = secretSettingActivity;
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
            this.cLw.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.cLw.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cLw.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.cLw.cLj;
                        this.cLw.mHandler.postDelayed(new d(this, iVar.arh()), 500L);
                        return;
                    }
                    return;
                }
                this.cLw.showToast(i.h.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.cLw.cLk;
                    aVar.aa(operation, type);
                    iVar2 = this.cLw.cLj;
                    iVar2.ac(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.cLw.cLj;
                m411getInst.setLocationShared(iVar3.arh());
                iVar4 = this.cLw.cLj;
                iVar4.fT(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
