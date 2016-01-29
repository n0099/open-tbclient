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
            if (historyMessage.Activity != null) {
                a aVar = new a(historyMessage.Activity.getPageContext());
                b bVar = new b();
                bVar.setThreadId(historyMessage.threadId);
                bVar.setForumName(historyMessage.forumName);
                bVar.km(historyMessage.threadName);
                bVar.kn(historyMessage.postID);
                bVar.eS(historyMessage.isHostOnly);
                bVar.eT(historyMessage.isSquence);
                bVar.setThreadType(historyMessage.threadType);
                aVar.a((a) bVar);
            }
        }
    }
}
