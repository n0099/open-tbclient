package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeRequestMessage;
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
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (customResponsedMessage instanceof NewsNotifyMessage) {
                EditMarkStatic.msgCount = ((NewsNotifyMessage) customResponsedMessage).getMsgBookmark();
                i = EditMarkStatic.msgCount;
                if (i > 0) {
                    z = EditMarkStatic.cud;
                    if (!z) {
                        MessageManager.getInstance().sendMessage(new GetStoreRemindTimeRequestMessage());
                    }
                    e.ahT().eA(true);
                    return;
                }
                return;
            }
            BdLog.e("transform error");
        }
    }
}
