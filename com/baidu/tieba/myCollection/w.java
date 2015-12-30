package com.baidu.tieba.myCollection;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ s cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(s sVar, int i) {
        super(i);
        this.cyx = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        x xVar;
        if (customResponsedMessage.getData() instanceof Bundle) {
            Bundle bundle = (Bundle) customResponsedMessage.getData();
            if (bundle.getInt(com.baidu.tbadk.c.b.FRAGMENT_TYPE, -1) == this.cyx.getType()) {
                boolean z = bundle.getBoolean(com.baidu.tbadk.c.b.EDITOR_STATE_EXTRA, false);
                xVar = this.cyx.cyw;
                xVar.changeEditState(z);
            }
        }
    }
}
