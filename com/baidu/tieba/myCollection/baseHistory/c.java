package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof HistoryMessage) {
            HistoryMessage historyMessage = (HistoryMessage) customResponsedMessage;
            a aVar = new a(historyMessage.Activity);
            b bVar = new b();
            bVar.setThreadId(historyMessage.threadId);
            bVar.setForumName(historyMessage.forumName);
            bVar.jw(historyMessage.threadName);
            bVar.jx(historyMessage.postID);
            bVar.ed(historyMessage.isHostOnly);
            bVar.ee(historyMessage.isSquence);
            bVar.bC(historyMessage.threadType);
            aVar.a((a) bVar);
        }
    }
}
