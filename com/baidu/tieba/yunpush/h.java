package com.baidu.tieba.yunpush;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.pushservice.PushServiceReceiverUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
class h extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Intent)) {
            PushServiceReceiverUtil.onReceive(TbadkCoreApplication.m9getInst(), (Intent) customResponsedMessage.getData());
        }
    }
}
