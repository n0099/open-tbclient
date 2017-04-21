package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.emk = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        com.baidu.tbadk.editortools.pb.c cVar;
        ey eyVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        pbModel = this.emk.ekv;
        if (pbModel != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            cVar = this.emk.elu;
            if (cVar != null) {
                eyVar3 = this.emk.eli;
                cVar3 = this.emk.elu;
                eyVar3.gL(cVar3.DU());
            }
            eyVar = this.emk.eli;
            eyVar.aNU();
            cVar2 = this.emk.elu;
            cVar2.DX();
            eyVar2 = this.emk.eli;
            eyVar2.axI();
        }
    }
}
