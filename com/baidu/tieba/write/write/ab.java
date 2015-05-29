package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.j) && com.baidu.tbadk.core.util.bg.tM() != null && com.baidu.tbadk.core.util.bg.tM().indexOf("NewVcode") != -1) {
            TbadkCoreApplication.m411getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() + 1);
        }
    }
}
