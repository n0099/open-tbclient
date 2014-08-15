package com.baidu.tieba.more;

import android.os.Handler;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class al extends HttpMessageListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.a = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        this.a.hideProgressBar();
        ayVar = this.a.a;
        if (ayVar != null) {
            ayVar2 = this.a.a;
            if (ayVar2.a() != null) {
                if (httpResponsedMessage.isSuccess()) {
                    if (httpResponsedMessage.getError() == 0) {
                        TbadkApplication m252getInst = TbadkApplication.m252getInst();
                        ayVar3 = this.a.a;
                        m252getInst.setLocationShared(ayVar3.a().e());
                        this.a.showToast(com.baidu.tieba.x.success);
                        return;
                    }
                    this.a.showToast(httpResponsedMessage.getErrorString());
                    new Handler().postDelayed(new am(this), 500L);
                    return;
                }
                this.a.showToast(com.baidu.tieba.x.neterror);
                new Handler().postDelayed(new an(this), 500L);
            }
        }
    }
}
