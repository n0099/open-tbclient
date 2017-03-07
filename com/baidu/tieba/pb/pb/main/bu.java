package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.pb.c cVar;
        fa faVar;
        fa faVar2;
        com.baidu.tbadk.editortools.pb.c cVar2;
        if (customResponsedMessage != null) {
            cVar = this.elO.ekY;
            if (cVar != null) {
                faVar2 = this.elO.ekM;
                cVar2 = this.elO.ekY;
                faVar2.gB(cVar2.Dw());
            }
            faVar = this.elO.ekM;
            faVar.gC(false);
        }
    }
}
