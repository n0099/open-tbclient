package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bf bfVar;
        bi biVar;
        bf bfVar2;
        bi biVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
            bfVar = this.this$0.dvN;
            if (bfVar.aDf() != null) {
                biVar = this.this$0.dCt;
                if (biVar != null) {
                    bfVar2 = this.this$0.dvN;
                    bfVar2.aDf().setIsFriend(1);
                    biVar2 = this.this$0.dCt;
                    biVar2.aDM();
                }
            }
        }
    }
}
