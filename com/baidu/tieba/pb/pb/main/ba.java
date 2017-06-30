package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        com.baidu.tbadk.editortools.pb.c cVar;
        gg ggVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        gg ggVar2;
        gg ggVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        pbModel = this.ewh.eue;
        if (pbModel != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            cVar = this.ewh.evh;
            if (cVar != null) {
                ggVar3 = this.ewh.euU;
                cVar3 = this.ewh.evh;
                ggVar3.gT(cVar3.Dm());
            }
            ggVar = this.ewh.euU;
            ggVar.aOk();
            cVar2 = this.ewh.evh;
            cVar2.Dp();
            ggVar2 = this.ewh.euU;
            ggVar2.azw();
        }
    }
}
