package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.eqa = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        com.baidu.tbadk.editortools.e.e eVar;
        ex exVar;
        com.baidu.tbadk.editortools.e.e eVar2;
        ex exVar2;
        ex exVar3;
        com.baidu.tbadk.editortools.e.e eVar3;
        dhVar = this.eqa.eov;
        if (dhVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.eqa.epp;
            if (eVar != null) {
                exVar3 = this.eqa.epe;
                eVar3 = this.eqa.epp;
                exVar3.gD(eVar3.Dr());
            }
            exVar = this.eqa.epe;
            exVar.aPG();
            eVar2 = this.eqa.epp;
            eVar2.Du();
            exVar2 = this.eqa.epe;
            exVar2.aBc();
        }
    }
}
