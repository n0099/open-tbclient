package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity cdW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.cdW = secretSettingActivity;
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
            this.cdW.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.cdW.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cdW.getResources().getString(t.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.cdW.cdK;
                        this.cdW.mHandler.postDelayed(new d(this, iVar.aio()), 500L);
                        return;
                    }
                    return;
                }
                this.cdW.showToast(t.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.cdW.cdL;
                    aVar.R(operation, type);
                    iVar2 = this.cdW.cdK;
                    iVar2.U(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.cdW.cdK;
                m411getInst.setLocationShared(iVar3.aio());
                iVar4 = this.cdW.cdK;
                iVar4.eF(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
