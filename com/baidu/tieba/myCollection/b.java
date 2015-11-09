package com.baidu.tieba.myCollection;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ CollectTabActivity cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CollectTabActivity collectTabActivity, int i) {
        super(i);
        this.cbR = collectTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c cVar;
        c cVar2;
        if (customResponsedMessage.getData() instanceof Bundle) {
            Bundle bundle = (Bundle) customResponsedMessage.getData();
            boolean z = bundle.getBoolean(com.baidu.tbadk.b.b.EDITOR_ENABLE_EXTRA, true);
            int i = bundle.getInt(com.baidu.tbadk.b.b.FRAGMENT_TYPE, -1);
            if (i != -1) {
                cVar = this.cbR.cbO;
                if (i == cVar.adF()) {
                    cVar2 = this.cbR.cbO;
                    cVar2.dZ(z);
                }
            }
        }
    }
}
