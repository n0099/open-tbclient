package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cf extends CustomMessageListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(PbActivity pbActivity, int i) {
        super(i);
        this.eqa = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        exVar = this.eqa.epe;
        if (exVar != null) {
            exVar2 = this.eqa.epe;
            if (exVar2.aPS() != null) {
                exVar3 = this.eqa.epe;
                exVar3.aPS().notifyDataSetChanged();
            }
        }
    }
}
