package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int g;
        bg bgVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001233 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.g) && (g = com.baidu.adp.lib.h.b.g(((com.baidu.tieba.tbadkCore.data.g) customResponsedMessage.getData()).aTx(), 0)) > 0) {
            bgVar = this.this$0.dyP;
            UserData userData = bgVar.getUserData();
            if (userData != null) {
                userData.setTDouNum(userData.getTDouNum() + g);
            }
        }
    }
}
