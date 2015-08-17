package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ PersonalChatActivity bFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonalChatActivity personalChatActivity, int i) {
        super(i);
        this.bFJ = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonalMsglistModel personalMsglistModel;
        PersonalMsglistModel personalMsglistModel2;
        PersonalChatView personalChatView;
        PersonalChatView personalChatView2;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
            com.baidu.tieba.im.data.b data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
            personalMsglistModel = this.bFJ.bFC;
            PersonalMsglistModel.CardStatus currentStatus = personalMsglistModel.getCurrentStatus(data);
            personalMsglistModel2 = this.bFJ.bFC;
            personalMsglistModel2.setCardStatus(currentStatus);
            if (currentStatus == PersonalMsglistModel.CardStatus.AGREE) {
                String content = data.getContent();
                personalChatView2 = this.bFJ.bFD;
                personalChatView2.a(currentStatus, false, content);
                return;
            }
            personalChatView = this.bFJ.bFD;
            personalChatView.a(currentStatus, false, new String[0]);
        }
    }
}
