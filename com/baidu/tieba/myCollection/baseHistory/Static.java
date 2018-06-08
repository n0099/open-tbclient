package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
/* loaded from: classes3.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001278) { // from class: com.baidu.tieba.myCollection.baseHistory.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof HistoryMessage) {
                    HistoryMessage historyMessage = (HistoryMessage) customResponsedMessage;
                    if (historyMessage.Activity != null) {
                        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(historyMessage.Activity.getPageContext());
                        a aVar = new a();
                        aVar.setThreadId(historyMessage.threadId);
                        aVar.setForumName(historyMessage.forumName);
                        aVar.qL(historyMessage.threadName);
                        aVar.qM(historyMessage.postID);
                        aVar.je(historyMessage.isHostOnly);
                        aVar.jf(historyMessage.isSquence);
                        aVar.setThreadType(historyMessage.threadType);
                        aVar.setCartoonId(historyMessage.cartoonId);
                        aVar.setChapterId(historyMessage.chapterId);
                        aVar.setIsShareThread(historyMessage.isShareThread);
                        aVar.setManga(historyMessage.isManga);
                        aVar.qN(historyMessage.liveId);
                        aVar.setUserName(historyMessage.userName);
                        aVar.setDescription(historyMessage.description);
                        pbHistoryCacheModel.a((PbHistoryCacheModel) aVar);
                    }
                }
            }
        });
    }
}
