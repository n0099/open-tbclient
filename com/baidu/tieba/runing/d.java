package com.baidu.tieba.runing;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.service.g;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof BackgroundSwitchMessage) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                a.abX().destroy();
            } else if (TbadkApplication.isLogin()) {
                a.abX().start();
                g.aco().start();
            } else {
                a.abX().destroy();
                g.aco().destroy();
            }
        }
    }
}
