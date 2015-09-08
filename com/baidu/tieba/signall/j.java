package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity cJd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.cJd = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            zVar = this.cJd.cIV;
            c arH = zVar.arH();
            if (arH != null) {
                arH.b((SignData) customResponsedMessage.getData());
                zVar2 = this.cJd.cIV;
                zVar2.arI().notifyDataSetChanged();
            }
        }
    }
}
