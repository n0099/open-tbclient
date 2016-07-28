package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bl extends CustomMessageListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(PbActivity pbActivity, int i) {
        super(i);
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.d.e eVar;
        ew ewVar;
        ew ewVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.ebT.ebk;
            if (eVar != null) {
                ewVar2 = this.ebT.ebb;
                eVar2 = this.ebT.ebk;
                ewVar2.ge(eVar2.BW());
            }
            ewVar = this.ebT.ebb;
            ewVar.gf(false);
        }
    }
}
