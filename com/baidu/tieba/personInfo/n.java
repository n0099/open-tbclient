package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity csx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.csx = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        aj ajVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
            yVar = this.csx.csk;
            if (yVar.ajN() != null) {
                yVar2 = this.csx.csk;
                yVar2.ajN().setIsFriend(1);
                ajVar = this.csx.csl;
                ajVar.aka();
            }
        }
    }
}
