package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends CustomMessageListener {
    final /* synthetic */ bd cjr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bd bdVar, int i) {
        super(i);
        this.cjr = bdVar;
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
            kVar = this.cjr.cjm;
            if (kVar != null) {
                kVar2 = this.cjr.cjm;
                kVar2.ed(true);
            }
            axVar = this.cjr.cjk;
            if (axVar != null) {
                axVar2 = this.cjr.cjk;
                axVar2.ed(true);
            }
            jVar = this.cjr.cjl;
            if (jVar != null) {
                jVar2 = this.cjr.cjl;
                jVar2.ed(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.cjr.cjj;
            if (zVar != null) {
                zVar2 = this.cjr.cjj;
                zVar2.aev();
            }
        }
    }
}
