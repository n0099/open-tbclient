package com.baidu.tieba.more;

import android.os.Handler;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.http.ResponseLocationJsonHttpMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends HttpMessageListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.a = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ay ayVar;
        ay ayVar2;
        ayVar = this.a.a;
        if (ayVar != null) {
            ayVar2 = this.a.a;
            if (ayVar2.a() != null && httpResponsedMessage.isSuccess() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ResponseLocationJsonHttpMessage)) {
                TbadkApplication.m252getInst().setLocationShared(((ResponseLocationJsonHttpMessage) httpResponsedMessage).isLocationShared);
                new Handler().postDelayed(new aq(this), 500L);
            }
        }
    }
}
