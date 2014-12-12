package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.e eVar;
        int i;
        com.baidu.tbadk.mainTab.e eVar2;
        com.baidu.tbadk.mainTab.e eVar3;
        com.baidu.tbadk.mainTab.e eVar4;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (!(customResponsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            EditMarkStatic.msgCount = newsNotifyMessage.getMsgBookmark();
            eVar = EditMarkStatic.bwJ;
            if (eVar != null) {
                i = EditMarkStatic.msgCount;
                eVar2 = EditMarkStatic.bwJ;
                if (i > eVar2.wg()) {
                    eVar4 = EditMarkStatic.bwJ;
                    eVar4.aL(true);
                }
                eVar3 = EditMarkStatic.bwJ;
                eVar3.du(newsNotifyMessage.getMsgBookmark());
            }
        }
    }
}
