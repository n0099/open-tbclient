package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf dAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.dAu = bfVar;
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
            kVar = this.dAu.dAp;
            if (kVar != null) {
                kVar2 = this.dAu.dAp;
                kVar2.gS(true);
            }
            azVar = this.dAu.dAn;
            if (azVar != null) {
                azVar2 = this.dAu.dAn;
                azVar2.gS(true);
            }
            jVar = this.dAu.dAo;
            if (jVar != null) {
                jVar2 = this.dAu.dAo;
                jVar2.gS(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.dAu.dAm;
            if (zVar != null) {
                zVar2 = this.dAu.dAm;
                zVar2.aeN();
            }
        }
    }
}
