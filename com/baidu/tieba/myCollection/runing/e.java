package com.baidu.tieba.myCollection.runing;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (TbadkCoreApplication.isLogin()) {
            a.acr().abJ();
        } else {
            a.acr().destroy();
        }
    }
}
