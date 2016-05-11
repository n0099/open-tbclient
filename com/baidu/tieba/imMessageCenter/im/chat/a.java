package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ PersonalChatActivity cth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonalChatActivity personalChatActivity, int i) {
        super(i);
        this.cth = personalChatActivity;
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
            personalMsglistModel = this.cth.cta;
            PersonalMsglistModel.CardStatus k = personalMsglistModel.k(data);
            personalMsglistModel2 = this.cth.cta;
            personalMsglistModel2.a(k);
            if (k == PersonalMsglistModel.CardStatus.AGREE) {
                String content = data.getContent();
                personalChatView2 = this.cth.ctb;
                personalChatView2.a(k, false, content);
                return;
            }
            personalChatView = this.cth.ctb;
            personalChatView.a(k, false, new String[0]);
        }
    }
}
