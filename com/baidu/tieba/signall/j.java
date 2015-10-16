package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity cQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.cQx = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            zVar = this.cQx.cQp;
            c aub = zVar.aub();
            if (aub != null) {
                aub.b((SignData) customResponsedMessage.getData());
                zVar2 = this.cQx.cQp;
                zVar2.auc().notifyDataSetChanged();
            }
        }
    }
}
