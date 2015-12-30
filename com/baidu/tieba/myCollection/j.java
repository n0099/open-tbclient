package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (customResponsedMessage instanceof NewsNotifyMessage) {
                EditMarkStatic.msgCount = ((NewsNotifyMessage) customResponsedMessage).getMsgBookmark();
                i = EditMarkStatic.msgCount;
                if (i > 0) {
                    e.ajd().ajg();
                    e.ajd().eA(true);
                    return;
                }
                return;
            }
            BdLog.e("transform error");
        }
    }
}
