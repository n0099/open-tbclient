package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PbActivity pbActivity, int i) {
        super(i);
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        fmVar = this.ehy.egt;
        if (fmVar != null) {
            fmVar2 = this.ehy.egt;
            if (fmVar2.aLy() != null) {
                fmVar3 = this.ehy.egt;
                fmVar3.aLy().notifyDataSetChanged();
            }
        }
    }
}
