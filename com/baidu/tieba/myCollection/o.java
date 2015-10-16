package com.baidu.tieba.myCollection;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.c fragmentTabStructure;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016207 && (customResponsedMessage.getData() instanceof com.baidu.tbadk.b.a)) {
            com.baidu.tbadk.b.a aVar = (com.baidu.tbadk.b.a) customResponsedMessage.getData();
            ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
            aVar.a(threadDelegateStatic);
            if (aVar.getContext() != null && (fragmentTabStructure = threadDelegateStatic.getFragmentTabStructure()) != null) {
                fragmentTabStructure.auZ.setArguments(new Bundle());
            }
        }
    }
}
