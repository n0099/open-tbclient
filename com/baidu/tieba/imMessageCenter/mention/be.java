package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends CustomMessageListener {
    final /* synthetic */ bd cnR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bd bdVar, int i) {
        super(i);
        this.cnR = bdVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        k kVar;
        ax axVar;
        j jVar;
        z zVar;
        z zVar2;
        j jVar2;
        ax axVar2;
        k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            kVar = this.cnR.cnM;
            if (kVar != null) {
                kVar2 = this.cnR.cnM;
                kVar2.ek(true);
            }
            axVar = this.cnR.cnK;
            if (axVar != null) {
                axVar2 = this.cnR.cnK;
                axVar2.ek(true);
            }
            jVar = this.cnR.cnL;
            if (jVar != null) {
                jVar2 = this.cnR.cnL;
                jVar2.ek(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.cnR.cnJ;
            if (zVar != null) {
                zVar2 = this.cnR.cnJ;
                zVar2.ahF();
            }
        }
    }
}
