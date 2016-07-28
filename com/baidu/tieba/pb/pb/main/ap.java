package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        com.baidu.tbadk.editortools.d.e eVar;
        ew ewVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        ew ewVar2;
        ew ewVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        dhVar = this.ebT.eas;
        if (dhVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.ebT.ebk;
            if (eVar != null) {
                ewVar3 = this.ebT.ebb;
                eVar3 = this.ebT.ebk;
                ewVar3.ge(eVar3.BW());
            }
            ewVar = this.ebT.ebb;
            ewVar.aKg();
            eVar2 = this.ebT.ebk;
            eVar2.BZ();
            ewVar2 = this.ebT.ebb;
            ewVar2.avR();
        }
    }
}
