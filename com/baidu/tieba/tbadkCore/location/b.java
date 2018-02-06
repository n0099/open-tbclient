package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016301) { // from class: com.baidu.tieba.tbadkCore.location.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.location")) {
                    TbadkCoreApplication.getInst().addBDLocCrashCount();
                }
            }
        });
    }
}
