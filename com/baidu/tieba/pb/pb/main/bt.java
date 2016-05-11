package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class bt extends CustomMessageListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(PbActivity pbActivity, int i) {
        super(i);
        this.djE = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.f fVar = (com.baidu.tieba.pb.f) customResponsedMessage.getData();
            switch (fVar.getType()) {
                case 0:
                    this.djE.b((com.baidu.tieba.pb.data.h) fVar.getData());
                    return;
                case 1:
                    this.djE.a((a.b) fVar.getData());
                    return;
                case 2:
                    if (fVar.getData() == null) {
                        this.djE.a(false, (MarkData) null);
                        return;
                    } else {
                        this.djE.a(true, (MarkData) fVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
