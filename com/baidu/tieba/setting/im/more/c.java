package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity bZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.bZp = secretSettingActivity;
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
            this.bZp.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.bZp.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bZp.getResources().getString(y.neterror) : httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        gVar = this.bZp.bZj;
                        this.bZp.mHandler.postDelayed(new d(this, gVar.agg()), 500L);
                        return;
                    }
                    return;
                }
                this.bZp.showToast(y.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.bZp.bZk;
                    aVar.Q(operation, type);
                    gVar2 = this.bZp.bZj;
                    gVar2.T(operation, type);
                    return;
                }
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                gVar3 = this.bZp.bZj;
                m411getInst.setLocationShared(gVar3.agg());
                gVar4 = this.bZp.bZj;
                gVar4.eq(TbadkCoreApplication.m411getInst().getLocationShared());
            }
        }
    }
}
