package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
            switch (eVar.getType()) {
                case 0:
                    this.ebT.b((com.baidu.tieba.pb.data.m) eVar.getData());
                    return;
                case 1:
                    this.ebT.a((a.b) eVar.getData());
                    return;
                case 2:
                    if (eVar.getData() == null) {
                        this.ebT.a(false, (MarkData) null);
                        return;
                    } else {
                        this.ebT.a(true, (MarkData) eVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
