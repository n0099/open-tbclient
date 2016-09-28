package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.eqa = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.e.e eVar;
        ex exVar;
        ex exVar2;
        com.baidu.tbadk.editortools.e.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.eqa.epp;
            if (eVar != null) {
                exVar2 = this.eqa.epe;
                eVar2 = this.eqa.epp;
                exVar2.gD(eVar2.Dr());
            }
            exVar = this.eqa.epe;
            exVar.gE(false);
        }
    }
}
