package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ d bYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar, int i) {
        super(i);
        this.bYA = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        i iVar;
        i iVar2;
        if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
            BdLog.i("mOpenShareLocSwitchListener response error!");
            iVar = this.bYA.bYt;
            if (iVar != null) {
                String str = null;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                    str = httpResponsedMessage.getErrorString();
                }
                iVar2 = this.bYA.bYt;
                iVar2.ft(str);
                return;
            }
            return;
        }
        TbadkCoreApplication.m255getInst().setLocationShared(true);
        this.bYA.ahB();
    }
}
