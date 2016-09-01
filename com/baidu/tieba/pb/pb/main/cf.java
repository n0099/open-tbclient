package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cf extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        exVar = this.eob.enh;
        if (exVar != null) {
            exVar2 = this.eob.enh;
            if (exVar2.aPj() != null) {
                exVar3 = this.eob.enh;
                exVar3.aPj().notifyDataSetChanged();
            }
        }
    }
}
