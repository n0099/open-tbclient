package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends CustomMessageListener {
    final /* synthetic */ bc cfn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, int i) {
        super(i);
        this.cfn = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        k kVar;
        aw awVar;
        j jVar;
        y yVar;
        y yVar2;
        j jVar2;
        aw awVar2;
        k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            kVar = this.cfn.cfi;
            if (kVar != null) {
                kVar2 = this.cfn.cfi;
                kVar2.ed(true);
            }
            awVar = this.cfn.cfg;
            if (awVar != null) {
                awVar2 = this.cfn.cfg;
                awVar2.ed(true);
            }
            jVar = this.cfn.cfh;
            if (jVar != null) {
                jVar2 = this.cfn.cfh;
                jVar2.ed(true);
            }
            MentionActivityConfig.newJumpIn = true;
            yVar = this.cfn.cff;
            if (yVar != null) {
                yVar2 = this.cfn.cff;
                yVar2.adm();
            }
        }
    }
}
