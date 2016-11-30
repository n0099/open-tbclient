package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.e.e eVar;
        ey eyVar;
        ey eyVar2;
        com.baidu.tbadk.editortools.e.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.evL.evb;
            if (eVar != null) {
                eyVar2 = this.evL.euP;
                eVar2 = this.evL.evb;
                eyVar2.gX(eVar2.Dz());
            }
            eyVar = this.evL.euP;
            eyVar.gY(false);
        }
    }
}
