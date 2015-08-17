package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(PbActivity pbActivity, int i) {
        super(i);
        this.cbo = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.c.d dVar;
        cb cbVar;
        cb cbVar2;
        com.baidu.tbadk.editortools.c.d dVar2;
        if (customResponsedMessage != null) {
            dVar = this.cbo.caX;
            if (dVar != null) {
                cbVar2 = this.cbo.caQ;
                dVar2 = this.cbo.caX;
                cbVar2.eA(dVar2.Br());
            }
            cbVar = this.cbo.caQ;
            cbVar.eC(false);
        }
    }
}
