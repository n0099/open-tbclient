package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf duP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.duP = bfVar;
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
            kVar = this.duP.duK;
            if (kVar != null) {
                kVar2 = this.duP.duK;
                kVar2.gy(true);
            }
            azVar = this.duP.duI;
            if (azVar != null) {
                azVar2 = this.duP.duI;
                azVar2.gy(true);
            }
            jVar = this.duP.duJ;
            if (jVar != null) {
                jVar2 = this.duP.duJ;
                jVar2.gy(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.duP.duH;
            if (zVar != null) {
                zVar2 = this.duP.duH;
                zVar2.azt();
            }
        }
    }
}
