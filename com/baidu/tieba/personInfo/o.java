package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.csI = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int g;
        y yVar;
        aj ajVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001233 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.c) && (g = com.baidu.adp.lib.g.b.g(((com.baidu.tieba.tbadkCore.data.c) customResponsedMessage.getData()).awn(), 0)) > 0) {
            yVar = this.csI.csv;
            UserData userData = yVar.getUserData();
            if (userData != null) {
                userData.setTDouNum(userData.getTDouNum() + g);
                ajVar = this.csI.csw;
                ajVar.ake().notifyDataSetChanged();
            }
        }
    }
}
