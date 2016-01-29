package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends CustomMessageListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(f fVar, int i) {
        super(i);
        this.diG = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.person.a.al alVar;
        com.baidu.tieba.person.a.al alVar2;
        if (customResponsedMessage != null) {
            alVar = this.diG.dhZ;
            if (alVar != null) {
                alVar2 = this.diG.dhZ;
                alVar2.aue();
            }
        }
    }
}
