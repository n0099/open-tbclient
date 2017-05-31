package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        com.baidu.tbadk.editortools.pb.c cVar;
        fx fxVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        fx fxVar2;
        fx fxVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        pbModel = this.enc.ele;
        if (pbModel != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            cVar = this.enc.emh;
            if (cVar != null) {
                fxVar3 = this.enc.elU;
                cVar3 = this.enc.emh;
                fxVar3.gz(cVar3.CS());
            }
            fxVar = this.enc.elU;
            fxVar.aKn();
            cVar2 = this.enc.emh;
            cVar2.CV();
            fxVar2 = this.enc.elU;
            fxVar2.avy();
        }
    }
}
