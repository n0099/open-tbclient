package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes2.dex */
class e extends CustomMessageListener {
    final /* synthetic */ ImMessageCenterDelegateStatic drl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, int i) {
        super(i);
        this.drl = imMessageCenterDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        TextView textView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int a = s.a(newsNotifyMessage);
            textView = this.drl.awx;
            if (textView != null) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zx()) {
                    a -= newsNotifyMessage.getMsgOfficialMerge();
                }
                textView2 = this.drl.awx;
                ImMessageCenterDelegateStatic.n(textView2, a);
            }
        }
    }
}
