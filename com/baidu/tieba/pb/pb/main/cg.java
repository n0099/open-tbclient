package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cg extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        eyVar = this.ejU.eiS;
        if (eyVar != null) {
            eyVar2 = this.ejU.eiS;
            if (eyVar2.aNg() != null) {
                eyVar3 = this.ejU.eiS;
                eyVar3.aNg().notifyDataSetChanged();
            }
        }
    }
}
