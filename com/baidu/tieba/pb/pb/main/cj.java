package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cj extends CustomMessageListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj(PbActivity pbActivity, int i) {
        super(i);
        this.eiV = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        ezVar = this.eiV.ehV;
        if (ezVar != null) {
            ezVar2 = this.eiV.ehV;
            if (ezVar2.aNE() != null) {
                ezVar3 = this.eiV.ehV;
                ezVar3.aNE().notifyDataSetChanged();
            }
        }
    }
}
