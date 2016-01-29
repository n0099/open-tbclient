package com.baidu.tieba.myCollection;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ CollectTabActivity cEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CollectTabActivity collectTabActivity, int i) {
        super(i);
        this.cEw = collectTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c cVar;
        c cVar2;
        if (customResponsedMessage.getData() instanceof Bundle) {
            Bundle bundle = (Bundle) customResponsedMessage.getData();
            boolean z = bundle.getBoolean("is_enable_edit", true);
            int i = bundle.getInt("fragment_type", -1);
            if (i != -1) {
                cVar = this.cEw.cEt;
                if (i == cVar.amW()) {
                    cVar2 = this.cEw.cEt;
                    cVar2.eL(z);
                }
            }
        }
    }
}
