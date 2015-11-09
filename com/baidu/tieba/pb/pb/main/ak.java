package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ak extends CustomMessageListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(PbActivity pbActivity, int i) {
        super(i);
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.c.e eVar;
        ct ctVar;
        ct ctVar2;
        com.baidu.tbadk.editortools.c.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.cjN.cjw;
            if (eVar != null) {
                ctVar2 = this.cjN.cjo;
                eVar2 = this.cjN.cjw;
                ctVar2.eQ(eVar2.Bf());
            }
            ctVar = this.cjN.cjo;
            ctVar.eS(false);
        }
    }
}
