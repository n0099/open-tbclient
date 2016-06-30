package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf deP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.deP = bfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        k kVar;
        az azVar;
        j jVar;
        z zVar;
        z zVar2;
        j jVar2;
        az azVar2;
        k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            kVar = this.deP.deK;
            if (kVar != null) {
                kVar2 = this.deP.deK;
                kVar2.fW(true);
            }
            azVar = this.deP.deI;
            if (azVar != null) {
                azVar2 = this.deP.deI;
                azVar2.fW(true);
            }
            jVar = this.deP.deJ;
            if (jVar != null) {
                jVar2 = this.deP.deJ;
                jVar2.fW(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.deP.deH;
            if (zVar != null) {
                zVar2 = this.deP.deH;
                zVar2.atv();
            }
        }
    }
}
