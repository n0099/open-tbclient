package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ LocationModel fOq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(LocationModel locationModel, int i) {
        super(i);
        this.fOq = locationModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        LocationModel.a aVar;
        LocationModel.a aVar2;
        if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
            BdLog.i("mOpenShareLocSwitchListener response error!");
            aVar = this.fOq.fOk;
            if (aVar != null) {
                String str = null;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                    str = httpResponsedMessage.getErrorString();
                }
                aVar2 = this.fOq.fOk;
                aVar2.fQ(str);
                return;
            }
            return;
        }
        TbadkCoreApplication.m9getInst().setLocationShared(true);
        this.fOq.bnc();
    }
}
