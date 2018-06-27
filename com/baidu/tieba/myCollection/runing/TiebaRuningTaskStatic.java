package com.baidu.tieba.myCollection.runing;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes3.dex */
public class TiebaRuningTaskStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.myCollection.runing.TiebaRuningTaskStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        a.aYJ().destroy();
                    } else if (TbadkCoreApplication.isLogin()) {
                        a.aYJ().start();
                    } else {
                        a.aYJ().destroy();
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.myCollection.runing.TiebaRuningTaskStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin()) {
                    a.aYJ().restart();
                } else {
                    a.aYJ().destroy();
                }
            }
        });
    }
}
