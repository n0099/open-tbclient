package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(PbActivity pbActivity, int i) {
        super(i);
        this.ciK = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.c.d dVar;
        cc ccVar;
        cc ccVar2;
        com.baidu.tbadk.editortools.c.d dVar2;
        if (customResponsedMessage != null) {
            dVar = this.ciK.ciu;
            if (dVar != null) {
                ccVar2 = this.ciK.cim;
                dVar2 = this.ciK.ciu;
                ccVar2.eN(dVar2.Br());
            }
            ccVar = this.ciK.cim;
            ccVar.eP(false);
        }
    }
}
