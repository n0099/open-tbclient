package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.h.a;
/* loaded from: classes.dex */
class av extends CustomMessageListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(PbActivity pbActivity, int i) {
        super(i);
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.pb.sub.ao aoVar = (com.baidu.tieba.pb.pb.sub.ao) customResponsedMessage.getData();
            switch (aoVar.getType()) {
                case 0:
                    this.cjN.b((com.baidu.tieba.pb.a.d) aoVar.getData());
                    return;
                case 1:
                    this.cjN.a((a.b) aoVar.getData());
                    return;
                case 2:
                    if (aoVar.getData() == null) {
                        this.cjN.a(false, (MarkData) null);
                        return;
                    } else {
                        this.cjN.a(true, (MarkData) aoVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
