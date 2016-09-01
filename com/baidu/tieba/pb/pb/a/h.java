package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, int i) {
        super(i);
        this.elb = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        com.baidu.tieba.pb.data.h hVar3;
        y yVar;
        boolean a;
        com.baidu.tieba.pb.data.h hVar4;
        com.baidu.tieba.pb.data.h hVar5;
        if (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.r) {
            hVar = this.elb.ekQ;
            if (hVar != null) {
                com.baidu.tieba.graffiti.r rVar = (com.baidu.tieba.graffiti.r) customResponsedMessage.getData();
                if (rVar.threadId != null) {
                    String str = rVar.threadId;
                    hVar2 = this.elb.ekQ;
                    if (str.equals(hVar2.getThreadId())) {
                        UserData userData = new UserData();
                        userData.setName_show(TbadkCoreApplication.getCurrentAccountName());
                        hVar3 = this.elb.ekQ;
                        if (hVar3.aLN() != null) {
                            hVar4 = this.elb.ekQ;
                            if (hVar4.aLN().pV() != null) {
                                hVar5 = this.elb.ekQ;
                                hVar5.aLN().pV().add(0, userData);
                            }
                        }
                        e eVar = this.elb;
                        e eVar2 = this.elb;
                        yVar = this.elb.ekR;
                        a = eVar2.a(yVar, userData);
                        eVar.hR(a);
                    }
                }
            }
        }
    }
}
