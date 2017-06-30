package com.baidu.tieba.write.bottomButton;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c Ez;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            WriteThreadDelegateStatic writeThreadDelegateStatic = new WriteThreadDelegateStatic();
            ((d) customResponsedMessage.getData()).a(writeThreadDelegateStatic);
            if (((d) customResponsedMessage.getData()).getContext() != null && (Ez = writeThreadDelegateStatic.Ez()) != null) {
                Ez.aFj.setArguments(new Bundle());
            }
        }
    }
}
