package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && com.baidu.tbadk.core.util.be.uq() != null && com.baidu.tbadk.core.util.be.uq().indexOf("NewVcode") != -1) {
            TbadkCoreApplication.m11getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m11getInst().getNewVcodeWebviewCrashCount() + 1);
        }
    }
}
