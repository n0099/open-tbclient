package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e eVar, int i) {
        super(i);
        this.emY = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        com.baidu.tieba.pb.data.h hVar3;
        v vVar;
        boolean a;
        com.baidu.tieba.pb.data.h hVar4;
        com.baidu.tieba.pb.data.h hVar5;
        if (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.r) {
            hVar = this.emY.emS;
            if (hVar != null) {
                com.baidu.tieba.graffiti.r rVar = (com.baidu.tieba.graffiti.r) customResponsedMessage.getData();
                if (rVar.threadId != null) {
                    String str = rVar.threadId;
                    hVar2 = this.emY.emS;
                    if (str.equals(hVar2.getThreadId())) {
                        UserData userData = new UserData();
                        userData.setName_show(TbadkCoreApplication.getCurrentAccountName());
                        hVar3 = this.emY.emS;
                        if (hVar3.aMp() != null) {
                            hVar4 = this.emY.emS;
                            if (hVar4.aMp().qg() != null) {
                                hVar5 = this.emY.emS;
                                hVar5.aMp().qg().add(0, userData);
                            }
                        }
                        e eVar = this.emY;
                        e eVar2 = this.emY;
                        vVar = this.emY.emT;
                        a = eVar2.a(vVar, userData);
                        eVar.hU(a);
                    }
                }
            }
        }
    }
}
