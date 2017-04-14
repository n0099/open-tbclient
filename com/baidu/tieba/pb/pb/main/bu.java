package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.pb.c cVar;
        ey eyVar;
        ey eyVar2;
        com.baidu.tbadk.editortools.pb.c cVar2;
        if (customResponsedMessage != null) {
            cVar = this.ejU.eje;
            if (cVar != null) {
                eyVar2 = this.ejU.eiS;
                cVar2 = this.ejU.eje;
                eyVar2.gB(cVar2.DU());
            }
            eyVar = this.ejU.eiS;
            eyVar.gC(false);
        }
    }
}
