package com.baidu.tieba.personInfo;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.c Ez;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
            ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
            if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (Ez = personInfoDelegateStatic.Ez()) != null) {
                Ez.aFj.setArguments(new Bundle());
            }
        }
    }
}
