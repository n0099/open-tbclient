package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ p eLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(p pVar, int i) {
        super(i);
        this.eLo = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (!(customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) || ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() != 0) {
            return;
        }
        this.eLo.ju(true);
    }
}
