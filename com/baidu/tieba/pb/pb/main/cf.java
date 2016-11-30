package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class cf extends CustomMessageListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(PbActivity pbActivity, int i) {
        super(i);
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
            switch (eVar.getType()) {
                case 0:
                    this.evL.b((com.baidu.tieba.pb.data.n) eVar.getData());
                    return;
                case 1:
                    this.evL.a((a.b) eVar.getData(), false);
                    return;
                case 2:
                    if (eVar.getData() == null) {
                        this.evL.a(false, (MarkData) null);
                        return;
                    } else {
                        this.evL.a(true, (MarkData) eVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
