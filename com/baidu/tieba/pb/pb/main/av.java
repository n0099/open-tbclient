package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class av extends CustomMessageListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(PbActivity pbActivity, int i) {
        super(i);
        this.cFS = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.pb.sub.aq aqVar = (com.baidu.tieba.pb.pb.sub.aq) customResponsedMessage.getData();
            switch (aqVar.getType()) {
                case 0:
                    this.cFS.b((com.baidu.tieba.pb.a.d) aqVar.getData());
                    return;
                case 1:
                    this.cFS.a((a.b) aqVar.getData());
                    return;
                case 2:
                    if (aqVar.getData() == null) {
                        this.cFS.a(false, (MarkData) null);
                        return;
                    } else {
                        this.cFS.a(true, (MarkData) aqVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
