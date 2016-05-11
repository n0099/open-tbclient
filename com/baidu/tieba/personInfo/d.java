package com.baidu.tieba.personInfo;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.c Dd;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
            ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).a(personInfoDelegateStatic);
            if (((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).getContext() != null && (Dd = personInfoDelegateStatic.Dd()) != null) {
                Dd.auW.setArguments(new Bundle());
            }
        }
    }
}
