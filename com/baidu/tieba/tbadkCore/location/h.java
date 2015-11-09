package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ d ddg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar, int i) {
        super(i);
        this.ddg = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        d.a aVar;
        d.a aVar2;
        if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
            BdLog.i("mOpenShareLocSwitchListener response error!");
            aVar = this.ddg.dcZ;
            if (aVar != null) {
                String str = null;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                    str = httpResponsedMessage.getErrorString();
                }
                aVar2 = this.ddg.dcZ;
                aVar2.fd(str);
                return;
            }
            return;
        }
        TbadkCoreApplication.m411getInst().setLocationShared(true);
        this.ddg.ayu();
    }
}
