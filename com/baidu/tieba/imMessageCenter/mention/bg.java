package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf dhN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.dhN = bfVar;
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
            kVar = this.dhN.dhI;
            if (kVar != null) {
                kVar2 = this.dhN.dhI;
                kVar2.fZ(true);
            }
            azVar = this.dhN.dhG;
            if (azVar != null) {
                azVar2 = this.dhN.dhG;
                azVar2.fZ(true);
            }
            jVar = this.dhN.dhH;
            if (jVar != null) {
                jVar2 = this.dhN.dhH;
                jVar2.fZ(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.dhN.dhF;
            if (zVar != null) {
                zVar2 = this.dhN.dhF;
                zVar2.auh();
            }
        }
    }
}
