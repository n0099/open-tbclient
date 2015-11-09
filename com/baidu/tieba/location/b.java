package com.baidu.tieba.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001337 && (customResponsedMessage.getData() instanceof Boolean)) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                com.baidu.adp.lib.d.a.gC().a(a.abp());
            } else {
                com.baidu.adp.lib.d.a.gC().b(a.abp());
            }
        }
    }
}
