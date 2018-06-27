package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.MsgReplyCardViewItemAdapter;
/* loaded from: classes2.dex */
public class PersonalMsglistAdapterStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001275) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.PersonalMsglistAdapterStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.egQ != null && aVar.context != null) {
                        MsgReplyCardViewItemAdapter msgReplyCardViewItemAdapter = new MsgReplyCardViewItemAdapter(aVar.context, ChatMessage.TYPE_MSG_REPLY_CARD);
                        msgReplyCardViewItemAdapter.gY(true);
                        aVar.egQ.add(msgReplyCardViewItemAdapter);
                    }
                }
            }
        });
    }
}
