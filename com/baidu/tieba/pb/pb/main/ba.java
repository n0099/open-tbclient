package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dj djVar;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        dj djVar2;
        ey eyVar5;
        dj djVar3;
        dj djVar4;
        dj djVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
            djVar = this.evL.euf;
            djVar.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
            eyVar = this.evL.euP;
            if (eyVar != null) {
                djVar2 = this.evL.euf;
                if (djVar2 != null) {
                    eyVar5 = this.evL.euP;
                    djVar3 = this.evL.euf;
                    com.baidu.tieba.pb.data.h pbData = djVar3.getPbData();
                    djVar4 = this.evL.euf;
                    boolean aQp = djVar4.aQp();
                    djVar5 = this.evL.euf;
                    eyVar5.d(pbData, aQp, djVar5.aQE());
                }
            }
            eyVar2 = this.evL.euP;
            if (eyVar2 != null) {
                eyVar3 = this.evL.euP;
                if (eyVar3.aRW() != null) {
                    eyVar4 = this.evL.euP;
                    eyVar4.aRW().notifyDataSetChanged();
                }
            }
        }
    }
}
