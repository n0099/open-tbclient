package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int g;
        bp bpVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001233 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.g) && (g = com.baidu.adp.lib.h.b.g(((com.baidu.tieba.tbadkCore.data.g) customResponsedMessage.getData()).bbK(), 0)) > 0) {
            bpVar = this.this$0.eht;
            UserData userData = bpVar.getUserData();
            if (userData != null) {
                userData.setTDouNum(userData.getTDouNum() + g);
            }
        }
    }
}
