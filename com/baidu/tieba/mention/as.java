package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class as extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public as(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (TbadkCoreApplication.isLogin()) {
            v.acZ().adb();
        } else {
            v.acZ().destroy();
        }
    }
}
