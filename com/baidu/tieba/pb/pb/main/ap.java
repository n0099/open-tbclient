package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
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
        pbModel = this.ejU.eif;
        if (pbModel != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            cVar = this.ejU.eje;
            if (cVar != null) {
                eyVar3 = this.ejU.eiS;
                cVar3 = this.ejU.eje;
                eyVar3.gB(cVar3.DU());
            }
            eyVar = this.ejU.eiS;
            eyVar.aMT();
            cVar2 = this.ejU.eje;
            cVar2.DX();
            eyVar2 = this.ejU.eiS;
            eyVar2.awH();
        }
    }
}
