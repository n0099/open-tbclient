package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.d.e eVar;
        ex exVar;
        ex exVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.eob.ens;
            if (eVar != null) {
                exVar2 = this.eob.enh;
                eVar2 = this.eob.ens;
                exVar2.gA(eVar2.Dr());
            }
            exVar = this.eob.enh;
            exVar.gB(false);
        }
    }
}
