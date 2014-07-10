package com.baidu.tieba.more;

import android.os.Handler;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.http.ResponseLocationJsonHttpMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends HttpMessageListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.a = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        at atVar;
        at atVar2;
        atVar = this.a.a;
        if (atVar != null) {
            atVar2 = this.a.a;
            if (atVar2.a() != null && httpResponsedMessage.isSuccess() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ResponseLocationJsonHttpMessage)) {
                TbadkApplication.m252getInst().setLocationShared(((ResponseLocationJsonHttpMessage) httpResponsedMessage).isLocationShared);
                new Handler().postDelayed(new al(this), 500L);
            }
        }
    }
}
