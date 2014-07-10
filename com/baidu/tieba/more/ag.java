package com.baidu.tieba.more;

import android.os.Handler;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class ag extends HttpMessageListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.a = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        at atVar;
        at atVar2;
        at atVar3;
        this.a.hideProgressBar();
        atVar = this.a.a;
        if (atVar != null) {
            atVar2 = this.a.a;
            if (atVar2.a() != null) {
                if (httpResponsedMessage.isSuccess()) {
                    if (httpResponsedMessage.getError() == 0) {
                        TbadkApplication m252getInst = TbadkApplication.m252getInst();
                        atVar3 = this.a.a;
                        m252getInst.setLocationShared(atVar3.a().e());
                        this.a.showToast(com.baidu.tieba.y.success);
                        return;
                    }
                    this.a.showToast(httpResponsedMessage.getErrorString());
                    new Handler().postDelayed(new ah(this), 500L);
                    return;
                }
                this.a.showToast(com.baidu.tieba.y.neterror);
                new Handler().postDelayed(new ai(this), 500L);
            }
        }
    }
}
