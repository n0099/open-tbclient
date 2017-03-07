package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (TbadkCoreApplication.m9getInst().getPhotoLiveReadThreadHistory() != null) {
            TbadkCoreApplication.m9getInst().getPhotoLiveReadThreadHistory().biy();
        }
    }
}
