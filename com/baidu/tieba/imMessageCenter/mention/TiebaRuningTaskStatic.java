package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes2.dex */
public class TiebaRuningTaskStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.imMessageCenter.mention.TiebaRuningTaskStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    if (TbadkCoreApplication.isLogin()) {
                        i.aNz().start();
                    } else {
                        i.aNz().destroy();
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.imMessageCenter.mention.TiebaRuningTaskStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin()) {
                    i.aNz().restart();
                } else {
                    i.aNz().destroy();
                }
            }
        });
    }
}
