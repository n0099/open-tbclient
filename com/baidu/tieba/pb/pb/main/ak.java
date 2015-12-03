package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ak extends CustomMessageListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(PbActivity pbActivity, int i) {
        super(i);
        this.cCm = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.d.e eVar;
        da daVar;
        da daVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.cCm.cBS;
            if (eVar != null) {
                daVar2 = this.cCm.cBL;
                eVar2 = this.cCm.cBS;
                daVar2.fu(eVar2.Cf());
            }
            daVar = this.cCm.cBL;
            daVar.fw(false);
        }
    }
}
