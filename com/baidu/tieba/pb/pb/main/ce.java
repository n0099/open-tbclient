package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ce extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
            switch (eVar.getType()) {
                case 0:
                    this.eob.b((com.baidu.tieba.pb.data.m) eVar.getData());
                    return;
                case 1:
                    this.eob.a((a.b) eVar.getData(), false);
                    return;
                case 2:
                    if (eVar.getData() == null) {
                        this.eob.a(false, (MarkData) null);
                        return;
                    } else {
                        this.eob.a(true, (MarkData) eVar.getData());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
