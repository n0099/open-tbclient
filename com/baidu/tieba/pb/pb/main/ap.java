package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dg dgVar;
        com.baidu.tbadk.editortools.d.e eVar;
        es esVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        es esVar2;
        es esVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        dgVar = this.dPF.dOf;
        if (dgVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.dPF.dOX;
            if (eVar != null) {
                esVar3 = this.dPF.dOO;
                eVar3 = this.dPF.dOX;
                esVar3.gb(eVar3.BW());
            }
            esVar = this.dPF.dOO;
            esVar.aGT();
            eVar2 = this.dPF.dOX;
            eVar2.BZ();
            esVar2 = this.dPF.dOO;
            esVar2.avf();
        }
    }
}
