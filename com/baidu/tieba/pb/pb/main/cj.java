package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class cj extends CustomMessageListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj(PbActivity pbActivity, int i) {
        super(i);
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
            switch (dVar.getType()) {
                case 0:
                    this.ehy.b((com.baidu.tieba.pb.data.l) dVar.getData());
                    return;
                case 1:
                    this.ehy.a((ForumManageModel.b) dVar.getData(), false);
                    return;
                case 2:
                    if (dVar.getData() == null) {
                        this.ehy.a(false, (MarkData) null);
                        return;
                    } else {
                        this.ehy.a(true, (MarkData) dVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
