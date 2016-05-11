package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ aj cws;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(aj ajVar, int i) {
        super(i);
        this.cws = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
            return;
        }
        this.cws.j(((ResponseNewFriendDataMessage) customResponsedMessage).getData());
    }
}
