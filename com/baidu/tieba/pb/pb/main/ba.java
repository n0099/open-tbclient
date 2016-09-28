package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.eqa = pbActivity;
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
            dhVar = this.eqa.eov;
            dhVar.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            exVar = this.eqa.epe;
            if (exVar != null) {
                dhVar2 = this.eqa.eov;
                if (dhVar2 != null) {
                    exVar5 = this.eqa.epe;
                    dhVar3 = this.eqa.eov;
                    com.baidu.tieba.pb.data.h pbData = dhVar3.getPbData();
                    dhVar4 = this.eqa.eov;
                    boolean aOw = dhVar4.aOw();
                    dhVar5 = this.eqa.eov;
                    exVar5.c(pbData, aOw, dhVar5.aOL());
                }
            }
            exVar2 = this.eqa.epe;
            if (exVar2 != null) {
                exVar3 = this.eqa.epe;
                if (exVar3.aPS() != null) {
                    exVar4 = this.eqa.epe;
                    exVar4.aPS().notifyDataSetChanged();
                }
            }
        }
    }
}
