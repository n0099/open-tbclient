package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public x(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case 2007009:
                    ad.c().M();
                    return;
                case 2007010:
                    ad.c().N();
                    return;
                case 2007011:
                    ad.c().O();
                    return;
                case 2007012:
                    ad.c().P();
                    return;
                case 2007013:
                    ad.c().L();
                    return;
                default:
                    return;
            }
        }
    }
}
