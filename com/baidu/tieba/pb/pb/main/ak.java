package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ak extends CustomMessageListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(PbActivity pbActivity, int i) {
        super(i);
        this.cNq = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.d.e eVar;
        dz dzVar;
        dz dzVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.cNq.cMU;
            if (eVar != null) {
                dzVar2 = this.cNq.cMK;
                eVar2 = this.cNq.cMU;
                dzVar2.ep(eVar2.Dk());
            }
            dzVar = this.cNq.cMK;
            dzVar.eq(false);
        }
    }
}
