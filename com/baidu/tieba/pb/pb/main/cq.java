package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class cq extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.h hVar = (com.baidu.tieba.pb.h) customResponsedMessage.getData();
            switch (hVar.getType()) {
                case 0:
                    this.ewh.b((com.baidu.tieba.pb.data.n) hVar.getData());
                    return;
                case 1:
                    this.ewh.a((ForumManageModel.b) hVar.getData(), false);
                    return;
                case 2:
                    if (hVar.getData() == null) {
                        this.ewh.a(false, (MarkData) null);
                        return;
                    } else {
                        this.ewh.a(true, (MarkData) hVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
