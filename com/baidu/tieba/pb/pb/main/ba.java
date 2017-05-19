package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        com.baidu.tbadk.editortools.pb.c cVar;
        fm fmVar;
        com.baidu.tbadk.editortools.pb.c cVar2;
        fm fmVar2;
        fm fmVar3;
        com.baidu.tbadk.editortools.pb.c cVar3;
        pbModel = this.ehy.efE;
        if (pbModel != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            cVar = this.ehy.egG;
            if (cVar != null) {
                fmVar3 = this.ehy.egt;
                cVar3 = this.ehy.egG;
                fmVar3.gm(cVar3.CY());
            }
            fmVar = this.ehy.egt;
            fmVar.aLl();
            cVar2 = this.ehy.egG;
            cVar2.Db();
            fmVar2 = this.ehy.egt;
            fmVar2.auE();
        }
    }
}
