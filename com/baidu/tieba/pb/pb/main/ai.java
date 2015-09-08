package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(PbActivity pbActivity, int i) {
        super(i);
        this.ccj = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.c.d dVar;
        cb cbVar;
        cb cbVar2;
        com.baidu.tbadk.editortools.c.d dVar2;
        if (customResponsedMessage != null) {
            dVar = this.ccj.cbS;
            if (dVar != null) {
                cbVar2 = this.ccj.cbL;
                dVar2 = this.ccj.cbS;
                cbVar2.eI(dVar2.BE());
            }
            cbVar = this.ccj.cbL;
            cbVar.eK(false);
        }
    }
}
