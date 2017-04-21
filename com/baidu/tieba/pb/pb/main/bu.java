package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.emk = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.pb.c cVar;
        ey eyVar;
        ey eyVar2;
        com.baidu.tbadk.editortools.pb.c cVar2;
        if (customResponsedMessage != null) {
            cVar = this.emk.elu;
            if (cVar != null) {
                eyVar2 = this.emk.eli;
                cVar2 = this.emk.elu;
                eyVar2.gL(cVar2.DU());
            }
            eyVar = this.emk.eli;
            eyVar.gM(false);
        }
    }
}
