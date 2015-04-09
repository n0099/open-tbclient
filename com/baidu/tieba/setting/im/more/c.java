package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity bZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.bZE = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        g gVar;
        a aVar;
        g gVar2;
        g gVar3;
        g gVar4;
        if (httpResponsedMessage != null) {
            this.bZE.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.bZE.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bZE.getResources().getString(y.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        gVar = this.bZE.bZy;
                        this.bZE.mHandler.postDelayed(new d(this, gVar.agv()), 500L);
                        return;
                    }
                    return;
                }
                this.bZE.showToast(y.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.bZE.bZz;
                    aVar.Q(operation, type);
                    gVar2 = this.bZE.bZy;
                    gVar2.T(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                gVar3 = this.bZE.bZy;
                m411getInst.setLocationShared(gVar3.agv());
                gVar4 = this.bZE.bZy;
                gVar4.eo(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
