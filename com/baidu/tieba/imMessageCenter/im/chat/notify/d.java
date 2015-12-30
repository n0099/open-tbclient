package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ ImMessageCenterDelegateStatic cdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, int i) {
        super(i);
        this.cdx = imMessageCenterDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        TextView textView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124 && (customResponsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int msgChat = ((newsNotifyMessage.getMsgChat() + newsNotifyMessage.getMsgReplyme()) + newsNotifyMessage.getMsgAtme()) - newsNotifyMessage.getMsgStrangerChat();
            textView = this.cdx.apj;
            if (textView != null) {
                textView2 = this.cdx.apj;
                ImMessageCenterDelegateStatic.p(textView2, msgChat);
            }
        }
    }
}
