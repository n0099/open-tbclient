package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PersonalChatActivity bJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PersonalChatActivity personalChatActivity, int i) {
        super(i);
        this.bJG = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        AbsMsglistView absMsglistView3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001220) {
            absMsglistView = this.bJG.mListView;
            if (absMsglistView != null) {
                absMsglistView2 = this.bJG.mListView;
                if (absMsglistView2.getAdapter() != null) {
                    absMsglistView3 = this.bJG.mListView;
                    absMsglistView3.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
