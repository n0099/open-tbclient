package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class cn extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
            switch (dVar.getType()) {
                case 0:
                    this.enc.b((com.baidu.tieba.pb.data.n) dVar.getData());
                    return;
                case 1:
                    this.enc.a((ForumManageModel.b) dVar.getData(), false);
                    return;
                case 2:
                    if (dVar.getData() == null) {
                        this.enc.a(false, (MarkData) null);
                        return;
                    } else {
                        this.enc.a(true, (MarkData) dVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
