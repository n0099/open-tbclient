package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        com.baidu.tbadk.editortools.pb.c cVar;
        fa faVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        fa faVar2;
        fa faVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        pbModel = this.elO.ejZ;
        if (pbModel != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            cVar = this.elO.ekY;
            if (cVar != null) {
                faVar3 = this.elO.ekM;
                cVar3 = this.elO.ekY;
                faVar3.gB(cVar3.Dw());
            }
            faVar = this.elO.ekM;
            faVar.aMK();
            cVar2 = this.elO.ekY;
            cVar2.Dz();
            faVar2 = this.elO.ekM;
            faVar2.awO();
        }
    }
}
