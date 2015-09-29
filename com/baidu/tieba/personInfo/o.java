package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity csx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.csx = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int g;
        y yVar;
        aj ajVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001233 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.c) && (g = com.baidu.adp.lib.g.b.g(((com.baidu.tieba.tbadkCore.data.c) customResponsedMessage.getData()).awe(), 0)) > 0) {
            yVar = this.csx.csk;
            UserData userData = yVar.getUserData();
            if (userData != null) {
                userData.setTDouNum(userData.getTDouNum() + g);
                ajVar = this.csx.csl;
                ajVar.ake().notifyDataSetChanged();
            }
        }
    }
}
