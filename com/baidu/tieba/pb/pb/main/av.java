package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class av extends CustomMessageListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(PbActivity pbActivity, int i) {
        super(i);
        this.cCm = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.pb.sub.ap apVar = (com.baidu.tieba.pb.pb.sub.ap) customResponsedMessage.getData();
            switch (apVar.getType()) {
                case 0:
                    this.cCm.b((com.baidu.tieba.pb.a.d) apVar.getData());
                    return;
                case 1:
                    this.cCm.a((a.b) apVar.getData());
                    return;
                case 2:
                    if (apVar.getData() == null) {
                        this.cCm.a(false, (MarkData) null);
                        return;
                    } else {
                        this.cCm.a(true, (MarkData) apVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
