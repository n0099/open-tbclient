package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class bk extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (TbadkCoreApplication.isLogin()) {
            ai.azB().Ro();
        } else {
            ai.azB().destroy();
        }
    }
}
