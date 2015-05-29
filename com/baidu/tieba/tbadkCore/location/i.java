package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends HttpMessageListener {
    final /* synthetic */ e ctM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.ctM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        j jVar;
        j jVar2;
        if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
            BdLog.i("mOpenShareLocSwitchListener response error!");
            jVar = this.ctM.ctF;
            if (jVar != null) {
                String str = null;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                    str = httpResponsedMessage.getErrorString();
                }
                jVar2 = this.ctM.ctF;
                jVar2.gh(str);
                return;
            }
            return;
        }
        TbadkCoreApplication.m411getInst().setLocationShared(true);
        this.ctM.apk();
    }
}
