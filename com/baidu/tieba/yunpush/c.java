package com.baidu.tieba.yunpush;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.pushservice.CommandService;
import com.baidu.android.pushservice.CommandServiceUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof CommandService.OnStartCommandData)) {
            CommandService.OnStartCommandData onStartCommandData = (CommandService.OnStartCommandData) customResponsedMessage.getData();
            CommandServiceUtil.onStartCommand(TbadkCoreApplication.m9getInst(), onStartCommandData.intent, onStartCommandData.flags, onStartCommandData.startId);
        }
    }
}
