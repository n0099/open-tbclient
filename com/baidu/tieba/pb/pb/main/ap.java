package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.eiV = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        com.baidu.tbadk.editortools.pb.c cVar;
        ez ezVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        ez ezVar2;
        ez ezVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        pbModel = this.eiV.ehh;
        if (pbModel != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            cVar = this.eiV.eih;
            if (cVar != null) {
                ezVar3 = this.eiV.ehV;
                cVar3 = this.eiV.eih;
                ezVar3.gK(cVar3.Dd());
            }
            ezVar = this.eiV.ehV;
            ezVar.aNr();
            cVar2 = this.eiV.eih;
            cVar2.Dg();
            ezVar2 = this.eiV.ehV;
            ezVar2.axs();
        }
    }
}
