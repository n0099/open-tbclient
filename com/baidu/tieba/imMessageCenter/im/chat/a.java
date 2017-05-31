package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
class a extends CustomMessageListener {
    final /* synthetic */ PersonalChatActivity diX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonalChatActivity personalChatActivity, int i) {
        super(i);
        this.diX = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonalMsglistModel personalMsglistModel;
        PersonalMsglistModel personalMsglistModel2;
        PersonalChatView personalChatView;
        PersonalChatView personalChatView2;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
            com.baidu.tieba.im.data.a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
            personalMsglistModel = this.diX.diQ;
            PersonalMsglistModel.CardStatus j = personalMsglistModel.j(data);
            personalMsglistModel2 = this.diX.diQ;
            personalMsglistModel2.a(j);
            if (j == PersonalMsglistModel.CardStatus.AGREE) {
                String content = data.getContent();
                personalChatView2 = this.diX.diR;
                personalChatView2.a(j, false, content);
                return;
            }
            personalChatView = this.diX.diR;
            personalChatView.a(j, false, new String[0]);
        }
    }
}
