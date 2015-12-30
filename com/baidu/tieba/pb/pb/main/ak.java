package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ak extends CustomMessageListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(PbActivity pbActivity, int i) {
        super(i);
        this.cFS = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.d.e eVar;
        dk dkVar;
        dk dkVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.cFS.cFx;
            if (eVar != null) {
                dkVar2 = this.cFS.cFq;
                eVar2 = this.cFS.cFx;
                dkVar2.ft(eVar2.BU());
            }
            dkVar = this.cFS.cFq;
            dkVar.fv(false);
        }
    }
}
