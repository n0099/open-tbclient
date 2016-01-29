package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity dIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.dIu = secretSettingActivity;
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
            this.dIu.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.dIu.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dIu.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        iVar = this.dIu.dIi;
                        this.dIu.mHandler.postDelayed(new d(this, iVar.aGz()), 500L);
                        return;
                    }
                    return;
                }
                this.dIu.showToast(t.j.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.dIu.dIj;
                    aVar.ai(operation, type);
                    iVar2 = this.dIu.dIi;
                    iVar2.ak(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                iVar3 = this.dIu.dIi;
                m411getInst.setLocationShared(iVar3.aGz());
                iVar4 = this.dIu.dIi;
                iVar4.hu(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
