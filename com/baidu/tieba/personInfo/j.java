package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity bER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bER = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        v vVar2;
        ae aeVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
            vVar = this.bER.bEG;
            if (vVar.aaV() != null) {
                vVar2 = this.bER.bEG;
                vVar2.aaV().setIsFriend(1);
                aeVar = this.bER.bEH;
                aeVar.abh();
            }
        }
    }
}
