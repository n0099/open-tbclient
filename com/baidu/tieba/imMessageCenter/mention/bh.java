package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
class bh extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (TbadkCoreApplication.isLogin()) {
            ai.auc().aue();
        } else {
            ai.auc().destroy();
        }
    }
}
