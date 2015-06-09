package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(PbActivity pbActivity, int i) {
        super(i);
        this.bKU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.pb.sub.an anVar = (com.baidu.tieba.pb.pb.sub.an) customResponsedMessage.getData();
            switch (anVar.getType()) {
                case 0:
                    this.bKU.a((com.baidu.tieba.pb.a.c) anVar.getData());
                    return;
                case 1:
                    this.bKU.a((com.baidu.tieba.tbadkCore.h.c) anVar.getData());
                    return;
                case 2:
                    if (anVar.getData() == null) {
                        this.bKU.a(false, (MarkData) null);
                        return;
                    } else {
                        this.bKU.a(true, (MarkData) anVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
