package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ch extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.pb.c cVar;
        gg ggVar;
        gg ggVar2;
        com.baidu.tbadk.editortools.pb.c cVar2;
        if (customResponsedMessage != null) {
            cVar = this.ewh.evh;
            if (cVar != null) {
                ggVar2 = this.ewh.euU;
                cVar2 = this.ewh.evh;
                ggVar2.gT(cVar2.Dm());
            }
            ggVar = this.ewh.euU;
            ggVar.gU(false);
        }
    }
}
