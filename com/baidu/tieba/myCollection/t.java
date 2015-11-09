package com.baidu.tieba.myCollection;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ p ccw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(p pVar, int i) {
        super(i);
        this.ccw = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        u uVar;
        if (customResponsedMessage.getData() instanceof Bundle) {
            Bundle bundle = (Bundle) customResponsedMessage.getData();
            if (bundle.getInt(com.baidu.tbadk.b.b.FRAGMENT_TYPE, -1) == this.ccw.getType()) {
                boolean z = bundle.getBoolean(com.baidu.tbadk.b.b.EDITOR_STATE_EXTRA, false);
                uVar = this.ccw.ccv;
                uVar.changeEditState(z);
            }
        }
    }
}
