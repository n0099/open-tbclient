package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        ex exVar;
        ex exVar2;
        ex exVar3;
        ex exVar4;
        dh dhVar2;
        ex exVar5;
        dh dhVar3;
        dh dhVar4;
        dh dhVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            dhVar = this.eob.emx;
            dhVar.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            exVar = this.eob.enh;
            if (exVar != null) {
                dhVar2 = this.eob.emx;
                if (dhVar2 != null) {
                    exVar5 = this.eob.enh;
                    dhVar3 = this.eob.emx;
                    com.baidu.tieba.pb.data.h pbData = dhVar3.getPbData();
                    dhVar4 = this.eob.emx;
                    boolean aNO = dhVar4.aNO();
                    dhVar5 = this.eob.emx;
                    exVar5.c(pbData, aNO, dhVar5.aOd());
                }
            }
            exVar2 = this.eob.enh;
            if (exVar2 != null) {
                exVar3 = this.eob.enh;
                if (exVar3.aPj() != null) {
                    exVar4 = this.eob.enh;
                    exVar4.aPj().notifyDataSetChanged();
                }
            }
        }
    }
}
