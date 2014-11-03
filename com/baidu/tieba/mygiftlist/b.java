package com.baidu.tieba.mygiftlist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ MyGiftListActivity bto;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bto = myGiftListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Long l;
        boolean z;
        long j;
        j jVar;
        j jVar2;
        if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null) {
            z = this.bto.mIsHost;
            if (!z) {
                j = this.bto.Mp;
                if (j == l.longValue()) {
                    jVar = this.bto.bth;
                    jVar.dR(false);
                    jVar2 = this.bto.bth;
                    jVar2.LoadData();
                }
            }
        }
    }
}
