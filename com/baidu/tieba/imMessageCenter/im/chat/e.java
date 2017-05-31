package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes2.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PersonalChatActivity diX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PersonalChatActivity personalChatActivity, int i) {
        super(i);
        this.diX = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        AbsMsglistView absMsglistView3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214) {
            absMsglistView = this.diX.cQk;
            if (absMsglistView != null) {
                absMsglistView2 = this.diX.cQk;
                if (absMsglistView2.getAdapter() != null) {
                    absMsglistView3 = this.diX.cQk;
                    absMsglistView3.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
