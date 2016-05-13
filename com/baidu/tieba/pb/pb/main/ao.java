package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(PbActivity pbActivity, int i) {
        super(i);
        this.djE = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cw cwVar;
        com.baidu.tbadk.editortools.d.e eVar;
        el elVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        el elVar2;
        el elVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        cwVar = this.djE.dih;
        if (cwVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.djE.dja;
            if (eVar != null) {
                elVar3 = this.djE.diR;
                eVar3 = this.djE.dja;
                elVar3.fn(eVar3.BN());
            }
            elVar = this.djE.diR;
            elVar.ayK();
            eVar2 = this.djE.dja;
            eVar2.BQ();
            elVar2 = this.djE.diR;
            elVar2.amT();
        }
    }
}
