package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
/* loaded from: classes.dex */
class bm extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && com.baidu.tbadk.core.util.bc.vL() != null && com.baidu.tbadk.core.util.bc.vL().indexOf("NewVcode") != -1) {
            TbadkCoreApplication.m9getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() + 1);
        }
    }
}
