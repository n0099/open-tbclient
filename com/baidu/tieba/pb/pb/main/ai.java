package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(PbActivity pbActivity, int i) {
        super(i);
        this.ciz = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.c.d dVar;
        cc ccVar;
        cc ccVar2;
        com.baidu.tbadk.editortools.c.d dVar2;
        if (customResponsedMessage != null) {
            dVar = this.ciz.cij;
            if (dVar != null) {
                ccVar2 = this.ciz.cia;
                dVar2 = this.ciz.cij;
                ccVar2.eN(dVar2.Br());
            }
            ccVar = this.ciz.cia;
            ccVar.eP(false);
        }
    }
}
