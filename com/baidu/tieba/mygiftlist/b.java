package com.baidu.tieba.mygiftlist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ MyGiftListActivity bsZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bsZ = myGiftListActivity;
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
            z = this.bsZ.mIsHost;
            if (!z) {
                j = this.bsZ.Mm;
                if (j == l.longValue()) {
                    jVar = this.bsZ.bsT;
                    jVar.dR(false);
                    jVar2 = this.bsZ.bsT;
                    jVar2.LoadData();
                }
            }
        }
    }
}
