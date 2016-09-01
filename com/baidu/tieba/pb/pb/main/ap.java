package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        com.baidu.tbadk.editortools.d.e eVar;
        ex exVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        ex exVar2;
        ex exVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        dhVar = this.eob.emx;
        if (dhVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.eob.ens;
            if (eVar != null) {
                exVar3 = this.eob.enh;
                eVar3 = this.eob.ens;
                exVar3.gA(eVar3.Dr());
            }
            exVar = this.eob.enh;
            exVar.aOX();
            eVar2 = this.eob.ens;
            eVar2.Du();
            exVar2 = this.eob.enh;
            exVar2.aAE();
        }
    }
}
