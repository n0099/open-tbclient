package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.h.a;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(PbActivity pbActivity, int i) {
        super(i);
        this.ccj = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.pb.sub.am amVar = (com.baidu.tieba.pb.pb.sub.am) customResponsedMessage.getData();
            switch (amVar.getType()) {
                case 0:
                    this.ccj.b((com.baidu.tieba.pb.a.c) amVar.getData());
                    return;
                case 1:
                    this.ccj.a((a.b) amVar.getData());
                    return;
                case 2:
                    if (amVar.getData() == null) {
                        this.ccj.a(false, (MarkData) null);
                        return;
                    } else {
                        this.ccj.a(true, (MarkData) amVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
