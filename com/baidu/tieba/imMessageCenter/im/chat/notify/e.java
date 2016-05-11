package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ ImMessageCenterDelegateStatic ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, int i) {
        super(i);
        this.ctz = imMessageCenterDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        TextView textView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124 && (customResponsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int a = s.a(newsNotifyMessage);
            textView = this.ctz.amh;
            if (textView != null) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().ya()) {
                    a -= newsNotifyMessage.getMsgOfficialMerge();
                }
                textView2 = this.ctz.amh;
                ImMessageCenterDelegateStatic.r(textView2, a);
            }
        }
    }
}
